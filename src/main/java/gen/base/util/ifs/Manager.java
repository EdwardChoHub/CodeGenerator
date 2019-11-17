package gen.base.util.ifs;

import java.util.Map;

public interface Manager {
    void setConfig(Map<String, Object> configMap) throws Exception;
    void loadConfig() throws Exception;
    void loadConfig(Map<String, Object> configMap) throws Exception;
    void run(Map<String, Object> resourceMap) throws Exception;
    Object get() throws Exception;
}
