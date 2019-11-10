package gen.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TemplateConfig {
    //使用数据库名做为对应类的前缀
    public static final boolean USE_DBNAME_PREFIX = false;
    //使用数据库名进行分包存储
    public static final boolean USE_SUB_PACKAGE_WITH_DBNAME = true;

    //使用额外的工具包(为空,False,null都表示不支持)
    public static final Map<String, Boolean> USE_EXTRA_PACKAGE = new HashMap<String, Boolean>(){{
        //使用lombok架包
        put("LOMBOK", true);
        //使用mybatis_plus架包
        put("MYBATISPLUS", true);
    }};
}
