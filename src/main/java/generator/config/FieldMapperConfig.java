package generator.config;

import java.util.HashMap;
import java.util.Map;

class FieldConverter {
    public static final Map<String,String> TYPE_MATCH = new HashMap<String,String>(){{
        put("varchar", "String");
        put("int", "Long");
        put("text","String");
        put("datetime", "Date");
        put("char","String");
        put("bigint","Long");
        put("decimal","BigDecimal");
    }};

}
