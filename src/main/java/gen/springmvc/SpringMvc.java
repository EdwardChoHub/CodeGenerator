package gen.springmvc;

import gen.springmvc.controller.Controller;
import gen.springmvc.dao.Dao;
import gen.springmvc.dao.DaoXml;
import gen.springmvc.factory.PropertiesFactory;
import gen.springmvc.service.Service;
import gen.springmvc.service.impl.ServiceImpl;
import lombok.Data;

import java.util.Map;
import java.util.Set;

@Data
public class SpringMvc {
    //控制器类集合
    private Set<Controller> controllerSet;
    //服务接口类集合
    private Set<Service> serviceSet;
    //服务实现类集合
    private Set<ServiceImpl> serviceImplSet;
    //DAO接口类集合
    private Set<Dao> daoSet;
    //DAO的SQL映射文件集合
    private Set<DaoXml> daoXmlSet;
    //配置文件
    private String applicationContextDaoXml;
    //配置文件
    private String applicationContextServiceXml;
    //配置文件
    private String springMvcXml;
    //配置文件
    private String log4jProperties;
    //配置文件
    private String dbProperties;
    //个性化配置器
    public Map<String,Object> configMap;
    public SpringMvc(Map<String,Object> configMap){
        this.configMap = configMap;
        this.log4jProperties = this.getLog4jProperties();
        this.dbProperties = this.getLog4jProperties();
        this.applicationContextDaoXml = this.getApplicationContextServiceXml();
    }
    private String getLog4jProperties(){
        return PropertiesFactory.getLog4jPropertiesFileContent(null);
    }
    private String getDbProperties(){
        return PropertiesFactory.getDbPropertiesFileContent(null);
    }
    private String getApplicationContextDaoXml(){
        return null;
    }
}
