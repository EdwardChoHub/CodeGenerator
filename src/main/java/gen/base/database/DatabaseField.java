package gen.base.database;

import lombok.Data;

@Data
public class DatabaseField{
    //字段名
    private String name;
    //字段类型
    private String type;
    //字段类型长度
    private String typeLen;
    //备注
    private String comment;
    //默认值
    private String defaultValue;
    //是否主键
    private boolean primaryKey = false;
    //是否外键
    private boolean foreignKey = false;
    //是否自增
    private boolean autoIncrement = false;
    //是否非空
    private boolean notNull = false;
}
