package gen.database.model;

import lombok.Data;

import java.util.List;

@Data
public class Database {
    private String name;
    private List<DatabaseTable> databaseTableList;
    //使用编码
    private String charset;
    //服务器名称
    private String serverName;
}
