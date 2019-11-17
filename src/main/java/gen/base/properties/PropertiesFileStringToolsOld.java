package gen.base.properties;

import gen.base.util.ifs.modify.FileToString;
import gen.base.util.SequenceRecorder;

import java.util.*;

public class PropertiesFileStringToolsOld implements FileToString {
    //换行符号
    private final String ENTER_SYMBOL = "\n";
    //注解符号
    private final String ANNOTATION_SYMBOL = "#";
    //配置集合
    private Map<String,String> configMap;
    //注解集合
    private List<String> annotationList;
    //顺序记录器
    private SequenceRecorder sequenceRecorder;

    private final String PREFIX_CONFIG = "config";
    private final String PREFIX_ANNOTATION = "annotation";
    private final String PREFIX_ANNOTATION_CONFIG = "annotationConfig";
    private final String PREFIX_ENTER = "enter";

    public PropertiesFileStringToolsOld(){
        this.configMap = new HashMap<>();
        this.annotationList = new ArrayList<>();
        this.sequenceRecorder = new SequenceRecorder();
    }

    /**
     * 添加配置
     * @param name 配置键
     * @param value 配置值
     */
    public void addConfig(String name, String value){
        this.sequenceRecorder.addRecord(name, PREFIX_CONFIG);
        this.configMap.put(name,value);
    }

    /**
     * 添加被注释的配置
     * @param name 配置键
     * @param value 配置值
     */
    public void addAnnotationConfig(String name, String value){
        this.sequenceRecorder.addRecord(name, PREFIX_ANNOTATION_CONFIG);
        this.configMap.put(name,value);
    }

    /**
     * 添加注释
     * @param content 注释内容
     */
    public void addAnnotation(String content){
        this.sequenceRecorder.addRecord(String.valueOf(this.annotationList.size()), PREFIX_ANNOTATION);
        this.annotationList.add(content);
    }

    /**
     * 添加换行符
     */
    public void addEnter(){
        this.sequenceRecorder.addRecord("", PREFIX_ENTER);
    }
    public String getFileString(Map<String, Object> configMap){
        StringBuilder stringBuilder = new StringBuilder();
        sequenceRecorder.startGet();
        while (sequenceRecorder.hasNext()){
            //前缀(配置,注释,注释的配置)
            String prefix = sequenceRecorder.getPrefix();
            String index = sequenceRecorder.getIndex();
            switch (prefix){
                case PREFIX_CONFIG:
                    stringBuilder.append(this.configFormat(index, this.getConfig(index)));
                    break;
                case PREFIX_ANNOTATION:
                    stringBuilder.append(ANNOTATION_SYMBOL).append(this.getAnnotation(index)).append(ENTER_SYMBOL);
                    break;
                case PREFIX_ANNOTATION_CONFIG:
                    stringBuilder.append(ANNOTATION_SYMBOL).append(this.configFormat(index, this.getConfig(index)));
                    break;
                case PREFIX_ENTER:
                    stringBuilder.append(ENTER_SYMBOL);
                    break;
            }
        }
        return stringBuilder.toString();
    }

    private String configFormat(String name, String value){
        return String.format("%s=%s" + ENTER_SYMBOL,name,value);
    }
    private String getConfig(String index){
        return this.configMap.get(index);
    }
    private String getAnnotation(String index){
        return this.annotationList.get(Integer.parseInt(index));
    }

    public static String getFileContent(List<PropertiesLine> propertiesLineList){
        StringBuilder builder = new StringBuilder();
        for(PropertiesLine propertiesLine : propertiesLineList){
            builder.append(propertiesLine.getLine());
        }
        return builder.toString();
    }
}
