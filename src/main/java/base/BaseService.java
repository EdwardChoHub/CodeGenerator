package base;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;
import java.util.Set;

public interface BaseService<Entity> {

	public void insert(Entity entity);

	public Entity findById(Integer id);

	public List<Entity> findAll();

	public List<Entity> findListByIds(Set<Integer> ids);

	public IPage<Entity> findListByPage(Integer pageSize, Integer pageNum);

	public IPage<Entity> findListByRange(Integer startRecordNumber, Integer endRecordNumber);

	public void updateById(Entity entity);

	public void deleteById(Integer id);

	public void deleteByIds(Set<Integer> ids);

	public Integer getTotalCount();

}
