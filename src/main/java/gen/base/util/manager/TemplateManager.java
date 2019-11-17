package gen.base.util.manager;


import gen.base.util.ifs.Manager;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TemplateManager implements Manager {
    private boolean USE_DBNAME_PREFIX;
    private boolean USE_SUB_PACKAGE_WITH_DBNAME;
    private List<String> USE_EXTRA_PACKAGE;
    private String USE_POJO_MODEL;
    private Map<String,Map<String,Object>> USE_RENDER_MODE_CONFIG;

    @Override
    public void setConfig(Map<String, Object> configMap) throws Exception {
        this.USE_DBNAME_PREFIX = (boolean) configMap.get("USE_DBNAME_PREFIX");
        this.USE_SUB_PACKAGE_WITH_DBNAME = (boolean) configMap.get("USE_SUB_PACKAGE_WITH_DBNAME");
        this.USE_EXTRA_PACKAGE = (List<String>) configMap.get("USE_EXTRA_PACKAGE");
        this.USE_POJO_MODEL = (String) configMap.get("USE_POJO_MODEL");
        this.USE_RENDER_MODE_CONFIG = Collections.unmodifiableMap((Map<String, Map<String, Object>>) configMap.get("USE_RENDER_MODE_CONFIG"));

    }

    @Override
    public void loadConfig() throws Exception {

    }

    @Override
    public void loadConfig(Map<String, Object> configMap) throws Exception {
        this.setConfig(configMap);
        this.loadConfig();
    }

    @Override
    public void run(Map<String, Object> resourceMap) throws Exception {

    }

    @Override
    public Object get() throws Exception {
        return null;
    }


}
