package gen.template;

import gen.database.model.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TemplateManager {
    private boolean USE_DBNAME_PREFIX;
    private boolean USE_SUB_PACKAGE_WITH_DBNAME;
    private List<String> USE_EXTRA_PACKAGE;
    public TemplateManager(){}

    public TemplateManager setUseDbnamePrefix(boolean USE_DBNAME_PREFIX) {
        this.USE_DBNAME_PREFIX = USE_DBNAME_PREFIX;
        return this;
    }
    public TemplateManager setUseSubPackageWithDbname(boolean USE_SUB_PACKAGE_WITH_DBNAME){
        this.USE_SUB_PACKAGE_WITH_DBNAME = USE_SUB_PACKAGE_WITH_DBNAME;
        return this;
    }
    public TemplateManager setUseExtraPackage(Map<String, Boolean> USE_EXTRA_PACKAGE){
        List<String> tmp = new ArrayList<>();
        for (String key: USE_EXTRA_PACKAGE.keySet()) {
            if(USE_EXTRA_PACKAGE.get(key)){
                tmp.add(key);
            }
        }
        this.USE_EXTRA_PACKAGE = tmp;
        return this;
    }
    //配置后开始
    public void startAfterConfig(List<Database> databaseList){

    }

}
