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
    //使用简单的java对象
    public static final boolean USE_EASY_POJO = true;
    //使用完全细分pojo（do,dto,vo,bo,ao）
    public static final boolean USE_SUBDIVIDE_POJO = true;
    //前后端分离(do,dto)
    public static final boolean USE_AJAX_POJO= true;
    //后端渲染模式(do,dto,vo)
    public static final boolean USE_RENDER_BACK = true;
    //自定义选择使用pojo模型
    public static final List<String> USE_CUSTOMER = new ArrayList<String>(){{
        add("DO");
        add("DTO");
        add("VO");
        add("BO");
        add("AO");
    }};
    public static final List<String> CONTROLLER_DEFAULT_MEHOD_LIST = new ArrayList<String>(){{
        add("findByPrimaryKey");
        add("insert");
        add("updateByPrimaryKey");
        add("selectByPage");
        add("deleteByPrimaryKey");
    }};
    //使用baseController，包含默认通用的几个方法，controller继承他即可
    public static final boolean USE_BASE_FILE_CONTROLLER = true;
    //使用baseService，包含默认通用的几个方法，controller继承他即可
    public static final boolean USE_BASE_FILE_SERVICE = true;
}
