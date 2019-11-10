package gen.database.converter;

import gen.database.model.DatabaseField;
import gen.util.StringUtil;

import java.util.Arrays;
import java.util.List;

public class StringToDatabaseFieldConverter {
    public static DatabaseField converter(String source){
        DatabaseField field = new DatabaseField();
        if(source.contains("`KEY`")) return null;
        if(!source.contains("PRIMARY KEY")){
            List<String> fieldBodyStrs = StringUtil.cleanList(Arrays.asList(fieldStr.split(" ")));
            boolean nameFlag=true;
            boolean typeFlag=false;
            boolean commentFlag=false;
            for (String fieldBodyStr : fieldBodyStrs){
                if(nameFlag){
                    nameFlag=false;
                    String name = fieldBodyStr.substring(1,fieldBodyStr.length()-1);
//                        List<String> nameList = Arrays.asList(realName.split("_"));
//                        StringBuilder name = new StringBuilder(nameList.get(0));
//                        for(int i=1;i<nameList.size();i++){
//                            name.append(nameList.get(i).substring(0,1).toUpperCase());
//                            name.append(nameList.get(i).substring(1,nameList.get(i).length()));
//                        }
//                        field.setName(name.toString());
                    field.setName(name);
                    typeFlag=true;
                }else if(typeFlag){
                    typeFlag=false;
                    int symbool = (fieldBodyStr.contains("(")) ? fieldBodyStr.indexOf("(") : fieldBodyStr.length();
//                        field.setType(TYPE_MATCH.get(fieldBodyStr.substring(0,symbool)));
                }else if(fieldBodyStr.equals("COMMENT")){
                    commentFlag=true;
                }else if(commentFlag){
                    if(field.getComment() == null) field.setComment("");
                    field.setComment(field.getComment()+fieldBodyStr);
                }else if(fieldBodyStr.equals("AUTO_INCREMENT")){
                    field.setAutoIncrement(true);
                }
            }
        return field;
    }
}
