package gen.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseConnectionConfig {
    //允许使用的数据库连接,使用DB_ID,为空表示全都使用
    public static final List<String> ALLOW_DB_ID_LIST =  new ArrayList<String>(){{
        add("BLOG");
    }};
    public static final List<Map<String, String>> DB_MYSQL_LIST = new ArrayList<Map<String, String>>(){{
        //多数据库添加多个add(new HashMap<String,String)>{{...}}),DB_ID唯一性
        add(new HashMap<String, String>(){{
            put("DB_ID", "BLOG");
            put("DB_DRIVER","com.mysql.cj.jdbc.Driver");
            put("DB_URL","jdbc:mysql://127.0.0.1:3306/blog?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8&useSSL=false");
            put("DB_USERNAME", "root");
            put("DB_PASSWORD", "root");
        }});
        add(new HashMap<String, String>(){{
            put("DB_ID", "BLL1");
            put("DB_DRIVER","com.mysql.cj.jdbc.Driver");
            put("DB_URL","jdbc:mysql://127.0.0.1:3306/blog?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8&useSSL=false");
            put("DB_USERNAME", "root");
            put("DB_PASSWORD", "root");
        }});
    }};
}
