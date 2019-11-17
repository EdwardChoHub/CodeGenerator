package properties;

import gen.base.properties.PropertiesFileStringTools;
import gen.base.properties.PropertiesFileStringToolsOld;
import gen.base.properties.PropertiesLine;
import gen.base.util.ifs.modify.FileToString;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class PropertiesTest implements FileToString {
    public String getFileString(Map<String, Object> configMap){
        PropertiesFileStringToolsOld tools = new PropertiesFileStringToolsOld();
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
    public String getFileString2(Map<String, Object> configMap){
        return new PropertiesFileStringTools().setPropertiesLineList(new ArrayList<PropertiesLine>(){{
            add(new PropertiesLine("Set root category priority to INFO and its only appender to CONSOLE."));
            add(new PropertiesLine("log4j.rootCategory=INFO, CONSOLE            debug   info   warn error fatal"));
            add(new PropertiesLine("log4j.rootCategory","debug, CONSOLE, LOGFILE"));
            add(new PropertiesLine(true));
            add(new PropertiesLine(" Set the enterprise logger category to FATAL and its only appender to CONSOLE."));
            add(new PropertiesLine("log4j.logger.org.apache.axis.enterprise","FATAL, CONSOLE"));
            add(new PropertiesLine(true));
            add(new PropertiesLine("CONSOLE is set to be a ConsoleAppender using a PatternLayout."));
            add(new PropertiesLine("log4j.appender.CONSOLE","org.apache.log4j.ConsoleAppender"));
            add(new PropertiesLine("log4j.appender.CONSOLE.layout","org.apache.log4j.PatternLayout"));
            add(new PropertiesLine("log4j.appender.CONSOLE.layout.ConversionPattern","%d{ISO8601} %-6r [%15.15t] %-5p %30.30c %x - %m\\n"));
            add(new PropertiesLine(true));
            add(new PropertiesLine("LOGFILE is set to be a File appender using a PatternLayout."));
            add(new PropertiesLine("log4j.appender.LOGFILE","org.apache.log4j.FileAppender",true));
            add(new PropertiesLine("log4j.appender.LOGFILE.File","d:\\axis.log",true));
            add(new PropertiesLine("log4j.appender.LOGFILE.Append","true",true));
            add(new PropertiesLine("log4j.appender.LOGFILE.layout","org.apache.log4j.PatternLayout",true));
            add(new PropertiesLine("log4j.appender.LOGFILE.layout.ConversionPattern","%d{ISO8601} %-6r [%15.15t] %-5p %30.30c %x - %m\\n",true));
        }}).getFileString(configMap);
    }
    public static void main(String[] args) throws IOException {
        PropertiesTest propertiesTest = new PropertiesTest();
        String propertiesString = propertiesTest.getFileString2(null);
        String filename = System.getProperty("user.dir") + "\\src\\main\\test\\properties\\test.properties";
        File file = new File(filename);
        System.out.println(filename);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(propertiesString);
        fileWriter.flush();
    }
}
