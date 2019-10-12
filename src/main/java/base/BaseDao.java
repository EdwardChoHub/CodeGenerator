package base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;


@Component
public interface BaseDao<Entity> extends BaseMapper<Entity> {
}
