package gen.base.xml;

import gen.base.util.ifs.BaseNameDict;
import gen.base.util.ifs.modify.FileToString;
import gen.base.xml.model.XmlTag;
import gen.base.util.StringUtil;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class XmlFileToString implements FileToString {
    //默认编码
    private final String DEFAULT_CODING = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>";
    //模板标签
    private final String TEMPLATE_TAG_TWO = "<#tag# #attribute#>#child#</#tag#>";
    private final String TEMPLATE_TAG_ONE = "<#tag# #attribute#/>";

    private final String ENTER = "\n";

    private XmlTag tagTree;
    //是否压缩
    private boolean reduce = false;

    @Override
    public String getFileString(Map<String, Object> configMap) {
        String coding = DEFAULT_CODING;
        if(configMap != null){
            Object tmp = configMap.get(BaseNameDict.XML_CONFIG);
            coding = tmp != null ? (String) tmp : DEFAULT_CODING;
        }
        StringBuilder builder = new StringBuilder();
        //添加首行编码
        builder.append(coding);
        builder.append("\n");
        //标签名替换tag
        final List<XmlTag> tagTree = new ArrayList<>();
        tagTree.add(this.tagTree);
        builder.append(this.getTagTreeString(tagTree,0));

        return builder.toString();
    }
    private String getTagTreeString(List<XmlTag> xmlTagList,Integer tabNum){
        String tab = StringUtil.multip("\t",tabNum);
        StringBuilder builder = new StringBuilder();
        for (XmlTag xmlTag : xmlTagList){
            //控制每个开始标签前的缩进
            builder.append(tab);
            String template = TEMPLATE_TAG_TWO;
            //没有子标签使用单标签模板
            if(xmlTag.getChildXmlTagList().size() <= 0) template = TEMPLATE_TAG_ONE;
            template = template.replaceAll("#tag#", xmlTag.getName());
            String attributeString = StringUtil.getMapString(xmlTag.getAttributeMap(),"="," ","\"","");
            template = template.replace("#attribute#", attributeString);
            String child = this.getTagTreeString(xmlTag.getChildXmlTagList(),tabNum + 1);
            /**
             * '/n' 控制父与子标签的换行切不共用一行
             * 'tab' 控制结束标签前的缩进
             */
            template = template.replace("#child#", "\n" + child + tab);
            builder.append(template);
            //控制每个标签结束的换行
            builder.append("\n");
        }
        return builder.toString();
    }

}
