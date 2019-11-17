package gen.base.database;

import lombok.Data;

import java.util.List;

@Data
public class DatabaseTable {
    //表名
    private String name;
    private List<DatabaseField> databaseFieldList;
}
