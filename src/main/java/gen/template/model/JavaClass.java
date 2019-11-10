package gen.template.model;

import lombok.Data;

import java.util.Set;

@Data
public class JavaClass {
    //类名
    private String  name;
    //依赖包集合(不重复集合)
    private Set<String> dependPackages;
    //注解
    private Set<String> annotationList;
}
