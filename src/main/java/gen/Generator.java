package gen;

import gen.config.DatabaseConnectionConfig;
import gen.config.TemplateConfig;
import gen.database.DatabaseManager;
import gen.database.model.Database;
import gen.database.model.DatabaseField;
import gen.database.model.DatabaseTable;
import gen.database.resolver.ShowCreateTableResultSetResolver;
import gen.database.resolver.ShowCreateTablesResultSetResolver;
import gen.template.TemplateManager;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class Generator {
    public static void main(String[] args) throws Exception {
        //获取需要使用的表所有信息
        List<String> ALLOW_DB_ID_LIST = DatabaseConnectionConfig.ALLOW_DB_ID_LIST;
        DatabaseManager dbManager = new DatabaseManager().getAllowConnection(ALLOW_DB_ID_LIST);
        //获取一个数据所有表的名称
        Map<String, ResultSet> resultSetMap = dbManager.executeQueryAll("show create tables");
        for (String key : resultSetMap.keySet()) {
            Database db = new Database();
            List<DatabaseTable> tableList = ShowCreateTablesResultSetResolver.resolver(resultSetMap.get(key));
            for (DatabaseTable table : tableList) {
                String tableName = table.getName();
                //获得表的字段
                ResultSet resultSet = dbManager.executeQuery("show create table " + tableName, key);
                List<DatabaseField> fieldList = ShowCreateTableResultSetResolver.resolver(resultSet);
                table.setDatabaseFieldList(fieldList);
            }
            db.setDatabaseTableList(tableList);
        }

        //模板管理器
        TemplateManager templateManager = new TemplateManager();
        //是否使用表名做前缀
        templateManager.setUseDbnamePrefix(TemplateConfig.USE_DBNAME_PREFIX);
        //是否使用拓展第三方包
        templateManager.setUseExtraPackage(TemplateConfig.USE_EXTRA_PACKAGE);
        //是否使用数据库名进行分包
        templateManager.setUseSubPackageWithDbname(TemplateConfig.USE_SUB_PACKAGE_WITH_DBNAME);
    }
}