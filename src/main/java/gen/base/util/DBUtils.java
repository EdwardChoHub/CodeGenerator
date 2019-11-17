package gen.base.util;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DBUtils {

    public static Connection getConnection(String DB_DRIVER,String DB_URL, String DB_USERNAME, String DB_PASSWORD) throws Exception {
        if(DB_PASSWORD == null || "".equals(DB_PASSWORD)) return null;
        if(DB_URL == null || "".equals(DB_URL)) return null;
        if(DB_USERNAME == null || "".equals(DB_USERNAME)) return null;
        if(DB_DRIVER == null || "".equals(DB_DRIVER)) return null;
        Class.forName(DB_DRIVER);
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    //默认使用第一个，适合单数据库
    public static ResultSet executeQuery(Connection connection, String sql) throws SQLException {
        return connection.createStatement().executeQuery(sql);
    }
    public static ResultSet executeQueryByShowCreateTables(Connection connection) throws SQLException{
        return executeQuery(connection, "show create tables");
    }
    public static ResultSet executeQueryByShowCreateTable(Connection connection, String tableName) throws SQLException {
        return executeQuery(connection, "show create table " + tableName);
    }
    public static void colse(Connection connection, Statement statement, ResultSet resultSet){
        if(connection != null) connection = null;
        if(statement != null) statement = null;
        if (resultSet != null) resultSet = null;
    }
    public static Map<String, ResultSet> getShowCreateTableAllMap(Connection connection) throws SQLException {
        ResultSet showCreateTablesResultSet = executeQueryByShowCreateTables(connection);
        Map<String, ResultSet> resultSetList = new HashMap<>();
        while (showCreateTablesResultSet.next()) {
            //将所有的表创建一个数据表对象
            String tableName = showCreateTablesResultSet.getString(1);
            ResultSet showCreateTableResultSet = executeQueryByShowCreateTable(connection, tableName);
            resultSetList.put(tableName, showCreateTableResultSet);
        }
        return resultSetList;
    }
}
