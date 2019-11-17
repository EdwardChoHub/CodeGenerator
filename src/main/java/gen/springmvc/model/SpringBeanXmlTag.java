package gen.springmvc.model;

import gen.base.xml.model.XmlTag;

import java.util.List;

public class SpringBeanXmlTag {
    public static XmlTag getPropertyNameValue(String name, String value){
        return new XmlTag()
                .setName("property")
                .addAttribute("name", name)
                .addAttribute("value", value);
    }
    public static XmlTag getBean(String idValue, String classValue, List<XmlTag> childTagXmlList){
        XmlTag bean = new XmlTag().setName("bean");
        if(idValue != null) bean.addAttribute("id", idValue);
        if(classValue != null) bean.addAttribute("class", classValue);
        if(childTagXmlList != null) bean.setChildXmlTagList(childTagXmlList);
        return bean;
    }
    public static XmlTag getMapKeyTypeEntryKeyValueRef(String keyType, List<XmlTag> entryList){
        XmlTag map =  new XmlTag()
                .setName("map")
                .addAttribute("key-type",keyType)
                .setChildXmlTagList(entryList);
        return map;
    }
    public static XmlTag getPropertyNameRef(String name, String ref){
        return new XmlTag()
                .setName("property")
                .addAttribute("name", name)
                .addAttribute("ref", ref);
    }
    public static XmlTag getPropertyNameMap(String name, List<XmlTag> childXmlTag){
        return new XmlTag().setName("property").addAttribute("name",name).setChildXmlTagList(childXmlTag);
    }
    public static XmlTag getEntryKeyValueRef(String key, String valueRef){
        return new XmlTag().setName("entry").addAttribute("key", key).addAttribute("value-ref",valueRef);
    }
}
