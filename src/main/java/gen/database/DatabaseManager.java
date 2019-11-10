package gen.database;

import gen.config.DatabaseConnectionConfig;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseManager {
    private Map<String, Connection> connMap;
    private List<Map<String, String>> ALLOW_DB_LIST;
    //构造器，先获取允许使用的数据库列表
    public DatabaseManager(){
        this.ALLOW_DB_LIST = this.getAllowDbList(DatabaseConnectionConfig.DB_MYSQL_LIST, Config.ALLOW_DB_ID_LIST);
    }
    //连接数据库返回对象组
    public DatabaseManager getAllowConnection() throws Exception{
        List<Map<String, String>> ALLOW_DB_LIST = this.getAllowDbList(DatabaseConnectionConfig.DB_MYSQL_LIST, Config.ALLOW_DB_ID_LIST);
        DBConnection dbConnection = new DBConnection();
        this.connMap =  dbConnection.getConnectionList(ALLOW_DB_LIST);
        return this;
    }
    //批量执行语句
    public Map<String, ResultSet> executeQuery(String sql, List<String> DB_ID_LIST) throws Exception{
        Map<String, ResultSet> rsMap = new HashMap<>();
        for (String DB_ID : DB_ID_LIST){
            rsMap.put(DB_ID, this.executeQuery(sql, DB_ID));
        }
        return rsMap;
    }

    public ResultSet executeQuery(String sql, String DB_ID) throws Exception{
        Connection conn = this.connMap.get(DB_ID);
        return conn.createStatement().executeQuery(sql);
    }
    //默认使用第一个，适合单数据库
    public ResultSet executeQuery(String sql) throws Exception{
        String DB_ID = this.connMap.keySet().iterator().next();
        Connection conn = connMap.get(DB_ID);
        return conn.createStatement().executeQuery(sql);
    }


    private List<Map<String, String>> getAllowDbList(List<Map<String, String>> DB_LIST, List<String> ALLOW_DB_ID_LIST){
        List<Map<String, String>> ALLOW_DB_LIST = new ArrayList<>();
        for(String ALLOW_DB_ID : ALLOW_DB_ID_LIST){
            for (Map<String, String> DB : DB_LIST){
                if(ALLOW_DB_ID.equals(DB.get("DB_ID"))){
                    ALLOW_DB_LIST.add(DB);
                    break;
                }
            }
        }
        return ALLOW_DB_LIST;
    }
}
