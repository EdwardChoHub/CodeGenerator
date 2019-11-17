package gen.base.java;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class JavaMethod {
    //公开方法
    public static Integer METHOD_PUBLIC  = 1;
    //半私有方法
    public static Integer METHOD_PROTECTED  = 2;
    //私有方法
    public static Integer METHOD_PRIVATE  = 3;

    //方法名
    private String name;
    //返回值
    private  String returnClass;
    //方法域(1public 2protect 3private)
    private int useArea;
    //形参列表
    private List<JavaProperty> javaPropertyList;
    //方法拥有的注解
    private Set<String> notes;

}
