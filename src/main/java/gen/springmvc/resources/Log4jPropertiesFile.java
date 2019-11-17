package gen.springmvc.resources;

import gen.base.util.FileToString;
import gen.base.properties.PropertiesFileStringTools;

import java.util.Map;

public class Log4jPropertiesFile implements FileToString {
    public String getFileString(Map<String, Object> configMap){
        PropertiesFileStringTools tools = new PropertiesFileStringTools();
        tools.addAnnotation(" Set root category priority to INFO and its only appender to CONSOLE.");
        tools.addAnnotation(" log4j.rootCategory=INFO, CONSOLE            debug   info   warn error fatal");
        tools.addConfig("log4j.rootCategory","debug, CONSOLE, LOGFILE");
        tools.addEnter();
        tools.addAnnotation(" Set the enterprise logger category to FATAL and its only appender to CONSOLE.");
        tools.addConfig("log4j.logger.org.apache.axis.enterprise","FATAL, CONSOLE");
        tools.addEnter();
        tools.addAnnotation(" CONSOLE is set to be a ConsoleAppender using a PatternLayout.");
        tools.addConfig("log4j.appender.CONSOLE","org.apache.log4j.ConsoleAppender");
        tools.addConfig("log4j.appender.CONSOLE.layout","org.apache.log4j.PatternLayout");
        tools.addConfig("log4j.appender.CONSOLE.layout.ConversionPattern","%d{ISO8601} %-6r [%15.15t] %-5p %30.30c %x - %m\n");
        tools.addEnter();
        tools.addAnnotation(" LOGFILE is set to be a File appender using a PatternLayout.");
        tools.addAnnotationConfig("log4j.appender.LOGFILE","org.apache.log4j.FileAppender");
        tools.addAnnotationConfig("log4j.appender.LOGFILE.File","d:\\axis.log");
        tools.addAnnotationConfig("log4j.appender.LOGFILE.Append","true");
        tools.addAnnotationConfig("log4j.appender.LOGFILE.layout","org.apache.log4j.PatternLayout");
        tools.addAnnotationConfig("log4j.appender.LOGFILE.layout.ConversionPattern","%d{ISO8601} %-6r [%15.15t] %-5p %30.30c %x - %m\\n");
        return tools.getFileString(null);
    }

}
