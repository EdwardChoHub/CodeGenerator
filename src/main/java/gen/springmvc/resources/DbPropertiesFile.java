package gen.springmvc.resources;

import gen.base.properties.PropertiesFileStringTools;
import gen.base.properties.PropertiesLine;
import gen.base.util.ifs.modify.FileToString;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
@Data
public class DbPropertiesFile implements FileToString {
    private LinkedHashMap<String,String> dbLine;
    @Override
    public String getFileString(Map<String,Object> configMap) {
//        PropertiesFileStringToolsOld tools = new PropertiesFileStringToolsOld();
//        for (String key : configMap.keySet()){
//            tools.addConfig(key, (String) configMap.get(key));
//        }
//        return tools.getFileString(null);
        return new PropertiesFileStringTools().setPropertiesLineList(
            new ArrayList<PropertiesLine>(){{
                for (String key : dbLine.keySet()){
                    add(new PropertiesLine(key,dbLine.get(key)));
                }
            }}
        ).getFileString(configMap);
    }
}
