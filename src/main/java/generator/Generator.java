package generator;

import generator.model.Field;
import generator.model.Table;
import freemarker.template.Configuration;
import freemarker.template.Template;


import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.*;

public class Generator extends Config {
    public static void main(String[] args) {
        Generator generator = new Generator(INFO);
    }

    public Generator(Map<String,String> info){
        MODULE_PATH = DEFAULT_PACKAGES_DIR + "\\" + info.get("moduleName").replace(".","/");
        //创建MVC标准的文件夹
        createMvcDir(MODULE_PATH);

        Configuration configuration = new Configuration(Configuration.getVersion());
        try {
            configuration.setDirectoryForTemplateLoading(new File(RESOURCES_DIR +"\\flt"));
            //获取全部表结构
            List<Table> tableList = this.getDatabaseInfo();
            for (Table table : tableList) {

                for (String flt : FLTS) {
                    //指定模板
                    Template template = configuration.getTemplate(flt);

                    //生成所需的包集合;
                    List<String> basicPackages = FLT_PACKAGES.get(flt);
                    if(basicPackages == null) basicPackages = new ArrayList<>();
                    List<String> typePackages = appendPackages(flt, basicPackages,table.getFields());
                    String fileName = MODULE_PATH + FLT_BUILD_DIR.get(flt) + "\\" + table.getName() + FLT_BUILD_FILE_SUFFIX.get(flt);
                    //指定输出文件名
                    FileWriter out = new FileWriter(fileName);

                    // 创建数据模型
                    Map<String, Object> dataModel = new HashMap<String, Object>();
                    dataModel.putAll(info);
                    dataModel.put("pojoClassName", table.getName());
                    dataModel.put("tableName", table.getRealName());
                    dataModel.put("fields", table.getFields());
                    dataModel.put("typePackages", typePackages);
                    template.process(dataModel, out);
                    out.close();
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private List<Table> getDatabaseInfo(){
        List<Table> tableList = new ArrayList<>();
        try {
            Class.forName(DB_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            ResultSet tableResultSet = conn.createStatement().executeQuery("SHOW TABLES");
            while (tableResultSet.next()) {
                Table table = new Table();
                if(!isTableAllow(tableResultSet.getString(1))) continue;
                table.setRealName(tableResultSet.getString(1));

                //将数据库中的表名改为大驼峰
                StringBuilder name = new StringBuilder("");
                for (String temp : explode(table.getRealName(),"_")){name.append(firstCap(temp));}
                table.setName(name.toString());

                ResultSet fieldResultSet = conn.createStatement().executeQuery("SHOW CREATE TABLE " + table.getRealName());
                if (fieldResultSet.next()) {
                    List<Field> fieldList = handleCreateStatement(fieldResultSet.getString(2));
                    table.setFields(fieldList);
                }
                tableList.add(table);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return tableList;
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
            Field field = new Field();
            if(fieldStr.contains("`KEY`")) continue;
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
                            name.append(nameList.get(i).substring(1,nameList.get(i).length()));
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
    private void createMvcDir(String prefix){
        for (String dir : MVC_BASIC_DIRS){
            File file = new File(prefix + dir);
            file.mkdirs();
        }
    }
    private List<String> appendPackages(String fltName,List<String> mvcPackages, List<Field> fieldList){
        for(Field field : fieldList){
            List<String> qualified_classes = QUALIFIED_CLASS.get(field.getType());
            if(qualified_classes != null && qualified_classes.size() > 0){
                for(String qualified_class : qualified_classes){
                    boolean have = false;
                    for(String hadPackages : mvcPackages){
                        if (hadPackages.equals(qualified_class)){
                            have = true;
                            break;
                        }
                    }
                    if(!have) mvcPackages.add(qualified_class);
                }
            }
            if(fltName.equals("pojo.java.flt")){
                if(field.getIsPrimaryKey().equals("true")){
                    mvcPackages.add("com.baomidou.mybatisplus.annotation.TableId");
                    if(field.getIsAutoIncrement().equals("true")){
                        mvcPackages.add("com.baomidou.mybatisplus.annotation.IdType");
                    }
                }
            }
        }
        return mvcPackages;
    }
    private String firstCap(String str){
        return str.substring(0,1).toUpperCase() + str.substring(1,str.length());
    }
    private List<String> explode(String str, String separator){
        return Arrays.asList(str.split(separator));
    }
    private String implode(List<String> strs, String separator){
        if(separator == null) separator = "";
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str);
            sb.append(separator);
        }
        return  sb.toString().substring(0,sb.toString().length()-1);
    }
    private boolean isTableAllow(String tableName){
        if(ALLOW_TABLES.size() == 0){
            return true;
        }else{
            for(String allowTableName:ALLOW_TABLES){
                if(tableName.equals(allowTableName)) return true;
            }
            return false;
        }
    }
}
