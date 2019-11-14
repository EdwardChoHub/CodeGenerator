package gen.converter;

import gen.model.DatabaseField;
import gen.util.StringUtil;

import java.util.Arrays;
import java.util.List;

public class StringToDatabaseFieldConverter {
    public static DatabaseField converter(String source) {
        DatabaseField field = new DatabaseField();
        if (source.contains("`KEY`")) return null;
        if (!source.contains("PRIMARY KEY")) {
            List<String> fieldBodyStrs = StringUtil.cleanList(Arrays.asList(source.split(" ")));
            boolean nameFlag = true;
            boolean typeFlag = false;
            boolean commentFlag = false;
            for (String fieldBodyStr : fieldBodyStrs) {
                if (nameFlag) {
                    nameFlag = false;
                    String name = fieldBodyStr.substring(1, fieldBodyStr.length() - 1);
                    field.setName(name);
                    typeFlag = true;
                } else if (typeFlag) {
                    typeFlag = false;
                    int symbool = (fieldBodyStr.contains("(")) ? fieldBodyStr.indexOf("(") : fieldBodyStr.length();
//                        field.setType(TYPE_MATCH.get(fieldBodyStr.substring(0,symbool)));
                } else if (fieldBodyStr.equals("COMMENT")) {
                    commentFlag = true;
                } else if (commentFlag) {
                    if (field.getComment() == null) field.setComment("");
                    field.setComment(field.getComment() + fieldBodyStr);
                } else if (fieldBodyStr.equals("AUTO_INCREMENT")) {
                    field.setAutoIncrement(true);
                }
            }
        }
        return field;
    }
}
