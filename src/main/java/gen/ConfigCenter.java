package gen;

import gen.config.DatabaseConnectionConfig;
import gen.model.Database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigCenter {
    private ConfigCenter(){}
    public static Map<String, Object> getDataSourceConfigMap(){
        return new HashMap<String, Object>(){{
            put("ALLOW_DB_ID_LIST", DatabaseConnectionConfig.ALLOW_DB_ID_LIST);
        }};
    }
    public static Map<String, Object> getTemplateConfigMap(final List<Database> databaseList){
        return new HashMap<String, Object>(){{
            put("ALLOW_DB_ID_LIST", DatabaseConnectionConfig.ALLOW_DB_ID_LIST);
            put("DATABASE_LIST", databaseList);
        }};
    }
}
