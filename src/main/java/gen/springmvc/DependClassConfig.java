package gen.springmvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//类依赖
public class DependClassConfig {
    private static final List<String> JAVA_STRING = new ArrayList<String>(){{}};
    private static final List<String> JAVA_LONG = new ArrayList<String>(){{}};
    private static final List<String> JAVA_INTEGER = new ArrayList<String>(){{}};
    private static final List<String> JAVA_DATE = new ArrayList<String>(){{
        add("java.util.Date");
    }};
    private static final List<String> JAVA_BIGDESCIMAL = new ArrayList<String>(){{
        add("java.math.BigDecimal");
    }};
    private static final List<String> JAVA_HASHMAP = new ArrayList<String>(){{
        add("java.util.HashMap");
        add("java.util.Map");
    }};
    private static final List<String> JAVA_MAP = new ArrayList<String>(){{
        add("java.util.Map");
        add("java.util.HashMap");
    }};
    private static final List<String> JAVA_LIST = new ArrayList<String>(){{
        add("java.util.List");
        add("java.util.ArrayList");
    }};
    private static final List<String> JAVA_ARRAYLIST = new ArrayList<String>(){{
        add("java.util.List");
        add("java.util.ArrayList");
    }};
    private static final List<String> SPRING_MVC_RESTCONTROLLER = new ArrayList<String>(){{
        add("org.springframework.web.bind.annotation.RestController");
        add("org.springframework.beans.factory.annotation.Autowired");
        add("org.springframework.web.bind.annotation.RequestMapping");
    }};
    private static final List<String> SPRING_MVC_CONTROLLER = new ArrayList<String>(){{
        add("org.springframework.beans.factory.annotation.Autowired");
        add("org.springframework.stereotype.Controller");
        add("org.springframework.web.bind.annotation.RequestMapping");
    }};
    private static final List<String> SPRING_MVC_SERVICE = new ArrayList<String>(){{
        add("org.springframework.beans.factory.annotation.Autowired");
        add("org.springframework.stereotype.Service");
        add("org.springframework.transaction.annotation.Transactional");
    }};
    private static final List<String> SPRING_MVC_DAO = new ArrayList<String>(){{
        add("org.apache.ibatis.annotations.Param");
        add("org.apache.ibatis.annotations.Select");
        add("org.apache.ibatis.annotations.Update");
    }};
    private static final Map<String, List<String>> MYBATISPLUS = new HashMap<String, List<String>>(){{
        put("DAO",new ArrayList<String>(){{
            add("com.baomidou.mybatisplus.core.mapper.BaseMapper");
        }});
    }};
    private static final Map<String, List<String>> LOMBOK = new HashMap<String, List<String>>(){{
        put("POJO", new ArrayList<String>(){{
            add("lombok.Data");
        }});
    }};
}
