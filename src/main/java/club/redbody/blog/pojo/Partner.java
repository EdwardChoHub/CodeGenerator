package club.redbody.blog.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableId;

@Data
@TableName("partner")
public class Partner implements Serializable{
    
    @TableId( value = "name")
	private String name;
    
    @TableField("url")
	private String url;
    
    @TableField("img_url")
	private String imgUrl;
}
