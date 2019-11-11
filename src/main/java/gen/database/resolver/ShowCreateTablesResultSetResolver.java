package gen.database.resolver;

import gen.database.model.DatabaseTable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ShowCreateTablesResultSetResolver {
    public static List<DatabaseTable> resolver(ResultSet showCreateTablesResultSet) throws Exception {
        List<DatabaseTable> databaseTableList = new ArrayList<>();
        while (showCreateTablesResultSet.next()) {
            DatabaseTable table = new DatabaseTable();
            //将所有的表创建一个数据表对象
            table.setName(showCreateTablesResultSet.getString(1));
            databaseTableList.add(table);
//            //将数据库中的表名改为大驼峰
//            StringBuilder name = new StringBuilder("");
//            for (String temp : explode(table.getRealName(),"_")){name.append(firstCap(temp));}
//            table.setName(name.toString());
        }
        return databaseTableList;
    }

}
