package gen.springmvc.factory;

import gen.springmvc.resources.DbPropertiesFile;
import gen.springmvc.resources.Log4jPropertiesFile;

import java.util.Map;

public class PropertiesFactory {
    public static String getLog4jPropertiesFileContent(Map<String, Object> configMap){
        return new Log4jPropertiesFile().getFileString(configMap);
    }
    public static String getDbPropertiesFileContent(Map<String, Object> configMap){
        return new DbPropertiesFile().getFileString(configMap);
    }
}
