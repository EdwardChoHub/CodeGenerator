package gen.base.properties;

import lombok.Data;

@Data
public class PropertiesLine {
    private final static String annotationSymbol = "# ";
    private final static String keyValueConnector = "=";
    private final static String enter = "\n";
    private String line;
    public PropertiesLine (String annotation){
        this.line = annotationSymbol + annotation + enter;
    }
    public PropertiesLine (String name, String value){
        this.line = name + keyValueConnector + value + enter;
    }
    public PropertiesLine (String name, String value, boolean isAnnotation){
        if(isAnnotation) this.line = annotationSymbol;
        this.line = this.line + name + keyValueConnector + value + enter;
    }
    public PropertiesLine (boolean isEnter){
        this.line = enter;
    }
}
