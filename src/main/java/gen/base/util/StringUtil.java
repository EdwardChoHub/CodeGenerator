package gen.base.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StringUtil {
    public static final String CHARS_BASIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz_";

    public static String ucfirst(String string){
        char[] cs=string.toCharArray();
        cs[0]-=32;
        return String.valueOf(cs);
    }
    public static String getFileName(String file){
        return file.split(".")[0];
    }
    public static String getFileExt(String file){
        String[] strList = file.split(".");
        return strList[strList.length-1];
    }
    public static String implode(String regex,String... strings){
        if(regex == null)regex = "";
        StringBuilder newStr = new StringBuilder();
        for (int i=0;i<strings.length;i++){
            newStr.append(strings[i]);
            if(i == strings.length) break;
            newStr.append(regex);
        }
        return newStr.toString();
    }
    public static String implodeBigHump(String... strings){
        StringBuilder newStr = new StringBuilder();
        for (int i=0;i<strings.length;i++){
            newStr.append(StringUtil.ucfirst(strings[i]));
        }
        return newStr.toString();
    }

    public static List<String> cleanList(List<String> list){
        List<String> rList = new ArrayList<>();
        for(String str:list){
            if(str.equals("")) continue;
            if(str.length() <= 1 && !CHARS_BASIC.contains(str)) continue;
            rList.add(str);
        }
        return rList;
    }
    public static String getDbName(String DB_URL){
        DB_URL = DB_URL.split("/?")[0];
        String[] temp = DB_URL.split("/");
        return temp[temp.length - 1];
    }
    public static String multip(String string, Integer num){
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<num;i++){
            builder.append(string);
        }
        return builder.toString();
    }
    public static String getMapString(Map<String,String> map, String connector, String separator, String valueSymbol, String keySymbol){
        StringBuilder builder = new StringBuilder();
        for (String key : map.keySet()){
            String tmp = keySymbol + key + keySymbol + connector + valueSymbol + map.get(key) + valueSymbol + separator;
            builder.append(tmp);
        }
        return builder.toString();
    }
}
