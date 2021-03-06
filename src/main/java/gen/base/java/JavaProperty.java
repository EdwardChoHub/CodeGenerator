package gen.base.java;

import lombok.Data;

import java.util.Set;

@Data
public class JavaProperty {
    //名称
    private String name;
    //类型
    private String type;
    //是否静态
    private boolean staticState;
    //是否常量
    private boolean finalState;
    //默认值
    private String value;
    //是否映射对应字段
    private boolean exist;
    //拥有的注解
    private Set<String> annotations;
}
