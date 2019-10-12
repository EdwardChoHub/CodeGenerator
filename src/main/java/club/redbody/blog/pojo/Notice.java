package club.redbody.blog.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

@Data
@TableName("notice")
public class Notice implements Serializable{
    
    @TableId(type = IdType.AUTO, value = "id")
	private Long id;
    
    @TableField("title")
	private String title;
    
    @TableField("sender")
	private String sender;
    
    @TableField("receiver")
	private String receiver;
    
    @TableField("content")
	private String content;
    
    @TableField("gmt_create")
	private Date gmtCreate;
    
    @TableField("gmt_modified")
	private Date gmtModified;
}
