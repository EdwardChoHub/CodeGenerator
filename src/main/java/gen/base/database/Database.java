package gen.base.database;

import lombok.Data;

import java.util.List;

@Data
public class Database {
    //serverName 使用常量
    public static final String SERVER_NAME_MYSQL = "MYSQL";
    public static final String SERVER_NAME_MARIADB = "MARIADB";
    public static final String SERVER_NAME_MICROSOFT_SQL_SERVER = "MICROSOFT_SQL_SERVER";
    public static final String SERVER_NAME_ORACLE = "ORACLE";
    public static final String SERVER_NAME_MICROSOFT_ACCESS = "MICROSOFT_ACCESS";

    //数据库名称
    private String name;
    //数据库表列表
    private List<DatabaseTable> databaseTableList;
    //使用编码
    private String charset;
    //服务器名称(MYSQL,SQL_SERVER等)
    private String serverName;
}
