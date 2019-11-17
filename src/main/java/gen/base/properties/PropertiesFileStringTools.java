package gen.base.properties;

import gen.base.util.FileToString;
import gen.base.util.SequenceRecorder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PropertiesFileStringTools implements FileToString {
    //换行符号
    private final String ENTER_SYMBOL = "\n\t\r";
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

    public PropertiesFileStringTools(){
        this.configMap = new HashMap<>();
        this.annotationList = new ArrayList<>();
        this.sequenceRecorder = new SequenceRecorder();
    }
    public void addConfig(String name, String value){
        //做顺序记录
        this.sequenceRecorder.addRecord(name, PREFIX_CONFIG);
        //添加到配置集合中
        this.configMap.put(name,value);
    }
    public void addAnnotationConfig(String name, String value){
        //做顺序记录
        this.sequenceRecorder.addRecord(name, PREFIX_ANNOTATION_CONFIG);
        //添加到配置集合中
        this.configMap.put(name,value);
    }
    public void addAnnotation(String content){
        //做顺序记录
        this.sequenceRecorder.addRecord(String.valueOf(this.annotationList.size()), PREFIX_ANNOTATION);
        //储存注释信息
        this.annotationList.add(content);
    }
    public void addEnter(){
        //做顺序记录
        this.sequenceRecorder.addRecord("", PREFIX_ENTER);
    }
    public String getFileString(Map<String, Object> configMap){
        StringBuilder stringBuilder = new StringBuilder();
        this.sequenceRecorder.startGet();
        while (this.sequenceRecorder.hasNext()){
            //前缀(配置,注释,注释的配置)
            String prefix = this.sequenceRecorder.getPrefix();
            String index = this.sequenceRecorder.getIndex();
            switch (prefix){
                case PREFIX_CONFIG:
                    stringBuilder.append(this.configFormat(index, this.getConfig(index)));
                    break;
                case PREFIX_ANNOTATION:
                    stringBuilder.append(ANNOTATION_SYMBOL).append(this.getAnnotation(index));
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
}
