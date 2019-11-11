package gen.template.model;

import lombok.Data;

import java.util.Set;

@Data
public class JavaClass {
    //类名
    private String name;
    //模板名称
    private String fltName;
    //依赖包集合(不重复集合)
    private Set<String> dependPackages;
    //注解
    private Set<String> annotations;
    //方法集合
    private Set<JavaMethod> javaMethods;
    //变量集合
    private Set<JavaProperty> javaProperties;
}