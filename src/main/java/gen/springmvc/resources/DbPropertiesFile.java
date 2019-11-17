package gen.springmvc.resources;

import gen.base.util.FileToString;
import gen.base.properties.PropertiesFileStringTools;

import java.util.Map;

public class DbPropertiesFile implements FileToString {
    @Override
    public String getFileString(Map<String, Object> configMap) {
        PropertiesFileStringTools tools = new PropertiesFileStringTools();
        for (String key : configMap.keySet()){
            tools.addConfig(key, (String) configMap.get(key));
        }
        return tools.getFileString(null);
    }
}
