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
    /**
     * EASY 只有pojo
     * FRONT_RENDER 前端渲染，拆分为do, dto
     * BACK_RENDER 后端渲染，拆分为do，dto, vo
     * SAFE 安全模式，do,dto,vo,bo
     * SUBDIVIDE 完全拆分，do,dto,vo,bo,ao
     * CUSTOMER 自定义，设置自定义才会区USE_POJO_TYPE_CUSTOMER拿值
     */
    public static final String USE_POJO_MODEL = "EASY";
   //只有DO,DTO,VO,BO,AO
    public static final List<String> USE_POJO_TYPE_CUSTOMER = new ArrayList<String>(){{
        add("DO");
        add("DTO");
        add("VO");
        add("BO");
        add("AO");
    }};
    /**
     * 渲染模式
     * FRONT 前端渲染，前后端分离
     * BACK 后端渲染
     * MIX 混合
     */
    public static final String USE_RENDER_MODE = "FRONT";
    //渲染模式相关配置
    public static final Map<String,Map<String,Object>> USE_RENDER_MODE_CONFIG = new HashMap<String, Map<String,Object>>(){{
        //默认方法相关公用配置信息
        put("USE_DEFAULT_METHOD_CONFIG", new HashMap<String, Object>(){{
            //替换共用词为关键字，例如primarykey
            put("USE_REPLACE_KEYWORD", true);
        }});
        put("FRONT", new HashMap<String,Object>(){{
           //使用通用controller类
           put("USE_BASE_CONTROLLER", true);
           //使用通用service类
           put("USE_BASE_SERVICE", true);
           //使用通用dao类
           put("USE_BASE_DAO", true);
           //controller/service/dao 默认方法
           put("USE_DEFAULT_METHOD", new ArrayList<String>(){{
               add("findByPrimaryKey");
               add("insert");
               add("updateByPrimaryKey");
               add("selectByPage");
               add("deleteByPrimaryKey");
           }});

       }});
    }};
}
