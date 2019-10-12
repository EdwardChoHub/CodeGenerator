package generator.test;

import generator.Config;
import generator.model.Field;
import generator.model.Table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.*;

public class Test extends Config {
    public static void main(String[] args) {
        Table table = new Test().getTableInfo("tb_freight_template");
        for (Field field : table.getFields()){
            System.out.println(field);
        }
    }

    private Table getTableInfo(String tableName){
        Table table = new Table();
        try {
            Class.forName(DB_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            table.setRealName(tableName);

            ResultSet fieldResultSet = conn.createStatement().executeQuery("SHOW CREATE TABLE " + table.getRealName());
            if (fieldResultSet.next()) {
                List<Field> fieldList = handleCreateStatement(fieldResultSet.getString(2));
                table.setFields(fieldList);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return table;
    }
    private List<Field> handleCreateStatement(String createStatement){
        List<Field> fieldList = new ArrayList<>();

        String cs = createStatement;
        cs = cs.substring(cs.indexOf("(")+1, cs.lastIndexOf(")"));
        cs = cs.replaceAll("\\,\\n","￥￥,￥￥");
        String[] fieldStrs = cs.split("￥￥,￥￥");

        for(String fieldStr : fieldStrs){
            if(fieldStr.replace(" ","").length() == 0) continue;
            if(fieldStr.isEmpty()) continue;
            System.out.println(fieldStr);
            Field field = new Field();
            if(fieldStr.contains("KEY") && !fieldStr.contains("`KEY`")) continue;
            if(!fieldStr.contains("PRIMARY KEY")){
                List<String> fieldBodyStrs = cleanList(Arrays.asList(fieldStr.split(" ")));
                boolean nameFlag=true,typeFlag=false,commentFlag=false;
                for (String fieldBodyStr : fieldBodyStrs){
                    if(nameFlag){
                        nameFlag=false;
                        String realName = fieldBodyStr.substring(1,fieldBodyStr.length()-1);
                        List<String> nameList = Arrays.asList(realName.split("_"));
                        StringBuilder name = new StringBuilder(nameList.get(0));
                        for(int i=1;i<nameList.size();i++){
                            name.append(nameList.get(i).substring(0,1).toUpperCase());
                            name.append(nameList.get(i).substring(1));
                        }
                        field.setName(name.toString());
                        field.setRealName(realName);
                        typeFlag=true;
                    }else if(typeFlag){
                        typeFlag=false;
                        int symbool = (fieldBodyStr.contains("(")) ? fieldBodyStr.indexOf("(") : fieldBodyStr.length();
                        field.setType(TYPE_MATCH.get(fieldBodyStr.substring(0,symbool)));
                    }else if(fieldBodyStr.equals("COMMENT")){
                        commentFlag=true;
                    }else if(commentFlag){
                        if(field.getComment() == null) field.setComment("");
                        field.setComment(field.getComment()+fieldBodyStr);
                    }else if(fieldBodyStr.equals("AUTO_INCREMENT")){
                        field.setIsAutoIncrement("true");
                    }
                }
                fieldList.add(field);
            }else{
                String primaryKey = fieldStr.substring(fieldStr.indexOf("`")+1,fieldStr.lastIndexOf("`"));
                for(Field tempField : fieldList){
                    if(tempField.getName().equals(primaryKey)){
                        tempField.setIsPrimaryKey("true");
                        break;
                    }
                }
            }
        }
        return fieldList;
    }
    private List<String> cleanList(List<String> list){
        List<String> rList = new ArrayList<>();
        for(String str:list){
            if(str.equals("")) continue;
            if(str.length() <= 1 && !CHARS_BASIC.contains(str)) continue;
            rList.add(str);
        }
        return rList;
    }
}
