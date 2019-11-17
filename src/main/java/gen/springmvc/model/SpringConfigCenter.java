package gen.springmvc.model;

import gen.base.util.BaseNameDict;
import gen.base.xml.model.XmlTag;

import java.util.ArrayList;
import java.util.List;

public class SpringConfigCenter {
    public static XmlTag contextPropertyPlaceholder(String location){
        return new XmlTag().setName("context:property-placeholder")
                .addAttribute("location",location);
    }
    public static XmlTag dynamicDataSource(String packageName, final String defaultId, final String... dataSourceIds){
        XmlTag dynamicDataSource = SpringBeanXmlTag.getBean(
                "dynamicDataSource",
                packageName +".DynamicDataSource",
                new ArrayList<XmlTag>(){{
                    add(SpringBeanXmlTag.getMapKeyTypeEntryKeyValueRef(
                            "targetDataSources",
                            new ArrayList<XmlTag>(){{
                                for (String dataSourceId : dataSourceIds){
                                    add(SpringBeanXmlTag.getEntryKeyValueRef(dataSourceId,dataSourceId));
                                }
                            }}
                    ));
                    add(SpringBeanXmlTag.getPropertyNameRef("defaultTargetDataSource", defaultId));
                }});
        return dynamicDataSource;
    }
    public static XmlTag sqlSessionFactory(String sqlSessionFactoryBeanPackage){
        return SpringBeanXmlTag.getBean(
                "sqlSessionFactory",
                sqlSessionFactoryBeanPackage,
                new ArrayList<XmlTag>(){{
                    add(SpringBeanXmlTag.getPropertyNameRef("dataSource","dynamicDataSource"));
                }});
    }
    public static XmlTag mapperImport(final String daoPackage){
        return SpringBeanXmlTag.getBean(
                null,
                "org.mybatis.spring.mapper.MapperScannerConfigurer",
                new ArrayList<XmlTag>(){{
                    add(SpringBeanXmlTag.getPropertyNameValue("basePackage",daoPackage));
                    add(SpringBeanXmlTag.getPropertyNameValue("sqlSessionFactoryBeanName","sqlSessionFactory"));
                }});
    }
    public static XmlTag druidDataSource(String id){
        final String finalId = id.toLowerCase();
        return SpringBeanXmlTag.getBean(
                finalId + "DataSource",
                "com.alibaba.druid.pool.DruidDataSource",
                new ArrayList<XmlTag>(){{
                    add(SpringBeanXmlTag.getPropertyNameValue("url","${jdbc." + finalId + ".url}"));
                    add(SpringBeanXmlTag.getPropertyNameValue("username","${jdbc."+ finalId +".username}"));
                    add(SpringBeanXmlTag.getPropertyNameValue("password","${jdbc."+ finalId +".password}"));
                }}
        );
    }
}
