package xml;

import gen.base.util.BaseNameDict;
import gen.base.util.FileToString;
import gen.base.xml.XmlFileToString;
import gen.base.xml.model.XmlTag;
import gen.springmvc.model.SpringConfigCenter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XmlTest implements FileToString {
    private XmlTag root;
    public XmlTest(){
        this.root = new XmlTag();
    }
    @Override
    public String getFileString(Map<String, Object> configMap) {
        if(configMap != null){
            Object tmp = configMap.get(BaseNameDict.DB_LIST_ALLOW);
            if(tmp != null) this.addDbConfig((List<Map<String, String>>) tmp);
            XmlFileToString tools = new XmlFileToString();
            return tools.setTagTree(root).getFileString(null);
        }
        return null;
    }

    private void addDbConfig(List<Map<String,String>> dbMapList){
        //引入配置文件
        root.setName("beans");
        root.addChild(SpringConfigCenter.contextPropertyPlaceholder("classpath:db.properties"));
        //配置数据源
        for (Map<String, String> dbMap : dbMapList){
            final String dbId = dbMap.get(BaseNameDict.DB_ID).toLowerCase();
            root.addChild(SpringConfigCenter.druidDataSource(dbId));
        }
        //数据库路由
        root.addChild(SpringConfigCenter.dynamicDataSource("club.redbody.blog.util.dataSource", "blogDataSource", "blogDataSource","commonDataSource"));
        //创建sqlSessionFactory
        root.addChild(SpringConfigCenter.sqlSessionFactory("com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean"));
        //导入DAO包
        root.addChild(SpringConfigCenter.mapperImport("club.redbody.blog.dao"));
    }

    public static void main(String[] args) throws IOException {
        XmlTest xmlTest = new XmlTest();
        String xmlString = xmlTest.getFileString(new HashMap<String, Object>(){{
            put(BaseNameDict.DB_LIST_ALLOW, new ArrayList<Map<String,String>>(){{
                add(new HashMap<String, String>(){{
                    put(BaseNameDict.DB_ID, "BLOG1");
                }});
                add(new HashMap<String, String>(){{
                    put(BaseNameDict.DB_ID, "BLOG2");
                }});
            }});
        }});
        String filename = System.getProperty("user.dir") + "\\src\\main\\test\\xml\\test.xml";
        File file = new File(filename);
        System.out.println(filename);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(xmlString);
        fileWriter.flush();
    }
}
