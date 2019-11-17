package gen.base.xml.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Data
public class XmlTag {

    private String name;
    //属性
    private Map<String,String> attributeMap = new HashMap<>();
    //子标签
    private List<XmlTag> childXmlTagList = new ArrayList<>();

    public XmlTag addAttribute(String name, String value){
        this.attributeMap.put(name,value);
        return this;
    }
    public XmlTag addChild(XmlTag childXmlTag){
        this.childXmlTagList.add(childXmlTag);
        return this;

    }
}
