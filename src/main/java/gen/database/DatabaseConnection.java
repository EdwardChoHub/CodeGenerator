package gen.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DatabaseConnection {
    public Map<String,Connection> getConnectionList(List<Map<String, String>> DB_LIST) throws Exception {
        Map<String, Connection> connMap = new HashMap<String,Connection>();
        if(DB_LIST == null) return connMap;

        for (Map<String, String> DB : DB_LIST){
            Connection conn = this.getConnection(DB);
            if(conn != null) connMap.put(DB.get("DB_ID"), conn);
        }
        return connMap;
    }

    public Connection getConnection(Map<String, String> DB) throws Exception {
        if(DB == null) return null;

        String DB_DRIVER = DB.get("DB_DRIVER");
        String DB_URL = DB.get("DB_URL");
        String DB_USERNAME = DB.get("DB_USERNAME");
        String DB_PASSWORD = DB.get("DB_PASSWORD");

        if(DB_PASSWORD == null || "".equals(DB_PASSWORD)) return null;
        if(DB_URL == null || "".equals(DB_URL)) return null;
        if(DB_USERNAME == null || "".equals(DB_USERNAME)) return null;
        if(DB_DRIVER == null || "".equals(DB_DRIVER)) return null;

        Class.forName(DB_DRIVER);
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }
}
