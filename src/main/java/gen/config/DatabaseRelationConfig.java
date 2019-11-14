package gen.config;

import java.util.HashMap;
import java.util.Map;

public class DatabaseRelationConfig {
    //数据库表关系
    public static final Map<String, Map<String,String>> DATABASE_RELATION = new HashMap<String, Map<String, String>>() {{
        //一对多关系(需要带上DB_ID),单数据库无需携带DB_ID
        put("ONE_TO_MANY", new HashMap<String, String>(){{
            put("ChapterCategory","Chapter");
        }});
        //多对多，创建一个新传输对象类模型，例如名字为StudentTeacherDTO
        put("MANY_TO_MANY",new HashMap<String, String>(){{
            put("Student","Teacher");
        }});
    }};
}
