package gen;

import gen.database.DatabaseManager;

public class Generator {
    public static void main(String[] args) throws Exception{
        DatabaseManager dbManager = new DatabaseManager().getAllowConnection();


    }
}
