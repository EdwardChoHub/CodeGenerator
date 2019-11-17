package gen.springmvc;

import gen.base.util.manager.DatabaseManager;
import gen.base.database.Database;
import gen.base.util.factory.ManagerFactory;
import gen.base.util.manager.TemplateManager;

import java.util.List;

public class Generator {
    public static void main(String[] args) throws Exception {
        Generator gen = new Generator();


        DatabaseManager databaseManager = ManagerFactory.getDatabaseManager(ConfigCenter.getDataSourceConfigMap());
        List<Database> databaseInfoAllList = databaseManager.getDatabaseInfoAllList();

        TemplateManager templateManager = ManagerFactory.getTemplateManager(ConfigCenter.getTemplateConfigMap(databaseInfoAllList));



    }
}