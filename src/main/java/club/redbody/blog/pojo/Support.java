package club.redbody.blog.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

@Data
@TableName("support")
public class Support implements Serializable{
    
    @TableId(type = IdType.AUTO, value = "id")
	private Long id;
    
    @TableField("name")
	private String name;
    
    @TableField("url")
	private String url;
    
    @TableField("img_url")
	private String imgUrl;
    
    @TableField("gmt_create")
	private Date gmtCreate;
    
    @TableField("gmt_modified")
	private Date gmtModified;
}
