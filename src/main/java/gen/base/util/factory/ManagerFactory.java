package gen.base.util.factory;

import gen.base.util.manager.DatabaseManager;
import gen.base.util.manager.TemplateManager;

import java.util.Map;


public class ManagerFactory {
    public static DatabaseManager getDatabaseManager(Map configMap) throws Exception {
        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.setConfig(configMap);
        databaseManager.loadConfig();
        return databaseManager;
    }
    public static TemplateManager getTemplateManager(Map configMap) throws Exception {
        TemplateManager templateManager = new TemplateManager();
        templateManager.setConfig(configMap);
        templateManager.loadConfig();
        return templateManager;
    }
}
