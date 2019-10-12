package generator.model;

import java.util.List;

public class Table {
    private String name;
    private String realName;
    private List<Field> fields;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "Table{" +
                "name='" + name + '\'' +
                ", realName='" + realName + '\'' +
                ", fields=" + fields +
                '}';
    }
}
