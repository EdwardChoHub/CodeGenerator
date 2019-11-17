package gen.base.properties;

import gen.base.util.ifs.modify.FileToString;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class PropertiesFileStringTools implements FileToString {
    private List<PropertiesLine> propertiesLineList;

    @Override
    public String getFileString(Map<String, Object> configMap) {
        StringBuilder builder = new StringBuilder();
        for(PropertiesLine propertiesLine : propertiesLineList){
            builder.append(propertiesLine.getLine());
        }
        return builder.toString();
    }
}
