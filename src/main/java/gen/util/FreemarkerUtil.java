package gen.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import gen.model.Database;
import gen.model.DatabaseTable;
import gen.util.config.PathConfig;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreemarkerUtil {
    private FreemarkerUtil(){}
    public static void gen(List<Database> databaseList) throws Exception {
        FreemarkerUtil self = new FreemarkerUtil();
        List<String> allowFltList = self.getFltList();

        Configuration configuration = new Configuration(Configuration.getVersion());
        File file = new File(PathConfig.FLT_DIR);
        configuration.setDirectoryForTemplateLoading(file);

        for (Database database : databaseList){
            for (DatabaseTable table : database.getDatabaseTableList()){
                for (String flt : allowFltList) {
                    //指定模板
                    Template template = configuration.getTemplate(flt);
                    //获取表名
                    String tableName = StringUtil.ucfirst(table.getName());
                    //获取flt文件名称
                    String fltFileName = StringUtil.getFileName(flt);

                    String fileName = StringUtil.implodeBigHump(tableName,fltFileName,".java");

                    //指定输出文件名
                    FileWriter out = new FileWriter(fileName);
                    // 创建数据模型
                    Map<String, Object> dataModel = new HashMap<>();
                    template.process(dataModel, out);
                    out.close();
                }
            }
        }

    }
    private List<String> getFltList(){
        return new ArrayList<String>();
    }
}
