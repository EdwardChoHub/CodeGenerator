package gen.base.util.manager;

import gen.base.util.ifs.Manager;
import gen.base.database.Database;
import gen.base.database.DatabaseTable;
import gen.base.util.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** 数据库连接管理工具
 *
 */
public class DatabaseManager implements Manager {
    private List<Map<String, String>> allowDatabaseList;
    private Map<String, Connection> connectionMap;

    @Override
    public void setConfig(Map<String, Object> configMap) throws Exception {
        this.allowDatabaseList = new ArrayList<>();

        List<Map<String, String>> databaseList = (List<Map<String, String>>) configMap.get("DB_LIST");
        List<String> allowDatabaseIdList = (List<String>) configMap.get("ALLOW_DB_ID_LIST");

        for(String allowDatabaseId : allowDatabaseIdList){
            for (Map<String, String> database : databaseList){
                if(allowDatabaseId.equals(database.get("DB_ID"))){
                    this.allowDatabaseList.add(database);
                }
            }
        }
    }

    @Override
    public void loadConfig() throws Exception {
        for (Map<String, String> database : this.allowDatabaseList){
            String id = database.get("DB_ID");
            String driver = database.get("DB_DRIVER");
            String url = database.get("DB_URL");
            String username = database.get("DB_USERNAME");
            String password = database.get("DB_PASSWORD");
            this.connectionMap.put(id, DBUtils.getConnection(driver, url, username, password));
        }
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

    public List<Database> getDatabaseInfoAllList() throws SQLException {
        List<Database> databaseList = new ArrayList<>();
        for(String key : this.connectionMap.keySet()){
            Database database = new Database();

            Connection connection = this.connectionMap.get(key);
            //获取执行SQL语句的返回值，数据库中所有表遍历执行SQL语句:show create table 表名
            Map<String, ResultSet> showCreateTableAllMap = DBUtils.getShowCreateTableAllMap(connection);
            //遍历解析然后放到数据库对象中
            for(String tableName : showCreateTableAllMap.keySet()){
                ResultSet resultSet = showCreateTableAllMap.get(tableName);
                //SQL语句执行的返回对象解析(show create table 表名) 为对象
//                List<DatabaseField> databaseFieldList = (List<DatabaseField>) StringToDatabaseFieldConverter.converter("");
                DatabaseTable databaseTable = new DatabaseTable()
                        .setName(tableName)
                        .setDatabaseFieldList(null);

                //库对象中的表对象列表追加对象
                List<DatabaseTable> databaseTableList = database.getDatabaseTableList();
                databaseTableList.add(databaseTable);
                database.setDatabaseTableList(databaseTableList);
            }

            databaseList.add(database);
        }

        return databaseList;
    }
}
