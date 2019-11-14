package gen;

import gen.manager.DatabaseManager;
import gen.model.Database;
import gen.factory.ManagerFactory;
import gen.manager.TemplateManager;

import java.util.List;

public class Generator {
    public static void main(String[] args) throws Exception {
        Generator gen = new Generator();


        DatabaseManager databaseManager = ManagerFactory.getDatabaseManager(ConfigCenter.getDataSourceConfigMap());
        List<Database> databaseInfoAllList = databaseManager.getDatabaseInfoAllList();

        TemplateManager templateManager = ManagerFactory.getTemplateManager(ConfigCenter.getTemplateConfigMap(databaseInfoAllList));



    }
}