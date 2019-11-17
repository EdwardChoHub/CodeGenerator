package gen.springmvc;

import config.DatabaseConnectionConfig;
import config.DatabaseRelationConfig;
import gen.base.database.Database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 配置中心（中间件）
 *
 */
public class ConfigCenter {
    private ConfigCenter(){}
    public static Map<String, Object> getDataSourceConfigMap(){
        return new HashMap<String, Object>(){{
            put("ALLOW_DB_ID_LIST", DatabaseConnectionConfig.ALLOW_DB_LIST.keySet());
        }};
    }
    public static Map<String, Object> getTemplateConfigMap(final List<Database> databaseList){
        return new HashMap<String, Object>(){{
            put("ALLOW_DB_LIST", DatabaseConnectionConfig.ALLOW_DB_LIST);
            put("DATABASE_LIST", databaseList);
            put("DATABASE_RELATION", DatabaseRelationConfig.DATABASE_RELATION);
        }};
    }
}
