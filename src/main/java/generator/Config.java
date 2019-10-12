package generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Config {
    public static final String ROOT_PATH = System.getProperty("user.dir");
    public static final String DEFAULT_PACKAGES_DIR = ROOT_PATH + "\\src\\main\\java";
    public static final String RESOURCES_DIR = ROOT_PATH + "\\src\\main\\resources";

    public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/blog?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8&useSSL=false";
    public static final String DB_USER = "root";
    public static final String DB_PASS = "root";
    public static final String CHARS_BASIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz_";
    public static final List<String> FLTS = new ArrayList<String>(){{
        add("controller.java.flt");
        add("pojo.java.flt");
        add("dao.java.flt");
        add("dao.xml.flt");
        add("service.java.flt");
        add("serviceImpl.java.flt");
    }};
    public static final Map<String,String> TYPE_MATCH = new HashMap<String,String>(){{
        put("varchar", "String");
        put("int", "Long");
        put("text","String");
        put("datetime", "Date");
        put("char","String");
        put("bigint","Long");
        put("decimal","BigDecimal");
    }};
    public static final Map<String,List<String>> QUALIFIED_CLASS = new HashMap<String,List<String>>(){{
        put("Date", new ArrayList<String>(){{
            add("java.util.Date");
        }});
        put("List",new ArrayList<String>(){{
            add("java.util.List");
            add("java.util.ArrayList");
        }});
        put("Map",new ArrayList<String>(){{
            add("java.util.HashMap");
            add("java.util.Map");
        }});
        put("BigDecimal",new ArrayList<String>(){{
            add("java.math.BigDecimal");
        }});
    }};

    public static final List<String> MVC_BASIC_DIRS = new ArrayList<String>(){{
        add("/controller");
        add("/service/impl");
        add("/dao");
        add("/pojo");
    }};
    public static final Map<String,String> FLT_BUILD_DIR = new HashMap<String,String>(){{
        put("controller.java.flt", "\\controller");
        put("service.java.flt", "\\service");
        put("serviceImpl.java.flt", "\\service\\impl");
        put("dao.xml.flt", "\\dao");
        put("dao.java.flt", "\\dao");
        put("pojo.java.flt", "\\pojo");
    }};

    private static final List<String> FLT_PACKAGES_CONTROLLER = new ArrayList<String>(){{
    }};
    private static final List<String> FLT_PACKAGES_SERVICE_IMPL = new ArrayList<String>(){{
    }};
    private static final List<String> FLT_PACKAGES_SERVICE = new ArrayList<String>(){{
    }};

    public static final Map<String,List<String>> FLT_PACKAGES = new HashMap<String,List<String>>(){{
        put("serviceImpl.java.flt",FLT_PACKAGES_SERVICE_IMPL);
        put("controller.java.flt",FLT_PACKAGES_CONTROLLER);
        put("service.java.flt",FLT_PACKAGES_SERVICE);
    }};
    public static final Map<String,String> FLT_BUILD_FILE_SUFFIX = new HashMap<String,String>(){{
        put("controller.java.flt","Controller.java");
        put("service.java.flt","Service.java");
        put("serviceImpl.java.flt","ServiceImpl.java");
        put("dao.xml.flt","Dao.xml");
        put("dao.java.flt","Dao.java");
        put("pojo.java.flt",".java");
    }};

    public static final Map<String,String> CLASSES_BASE = new HashMap<String,String>(){{
        put("BaseDao.java.flt","\\dao\\BaseDao.java");
        put("BaseService.java.flt","\\service\\BaseService.java");
        put("BaseServiceImpl.java.flt","\\service\\impl\\BaseServiceImpl.java");
    }};
    //需要使用的表，为空时表示数据库中的全部表
    public static final List<String> ALLOW_TABLES = new ArrayList<String>(){{
        add("notice");
    }};
    public static Map<String,String> INFO = new HashMap<String,String>(){{
        put("moduleName","club.redbody.blog");
    }};
    public static String MODULE_PATH = "";
}
