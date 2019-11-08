package generator.java;

import lombok.Data;

import java.util.Set;

@Data
public class JavaProperty {
    //名称
    private String name;
    //类型
    private String type;
    //默认值
    private String value;
    //是否映射对应字段
    private boolean isExist;
    //是否有构造方法，包含属性给默认值，gmt_update赋值
    private boolean hasConstrut;
    //拥有的注解
    private Set<String> notes;
}
