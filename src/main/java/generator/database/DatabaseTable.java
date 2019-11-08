package generator.database;

import lombok.Data;

import java.util.List;

@Data
public class DatabaseTable {
    private String name;
    private List<DatabaseField> databaseFieldList;
}
