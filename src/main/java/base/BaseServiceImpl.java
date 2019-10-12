package base;

import java.util.List;
import java.util.Set;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BaseServiceImpl<Entity> implements BaseService<Entity> {

	@Autowired
	private BaseDao<Entity> baseDao;

	public void insert(Entity entity) {
		baseDao.insert(entity);
	}

	public Entity findById(Integer id) {
		return baseDao.selectById(id);
	}

	public List<Entity> findAll() {
		return baseDao.selectList(null);
	}

	public List<Entity> findListByIds(Set<Integer> ids) {
		return baseDao.selectBatchIds(ids);
	}

	public IPage<Entity> findListByPage(Integer pageSize, Integer pageNum) {
		return findListByRange(pageSize * pageNum, pageNum);
	}

	public IPage<Entity> findListByRange(Integer start, Integer limit) {
		Page<Entity> page = new Page<Entity>(start,limit);
		return baseDao.selectPage(page,null);
	}

	public void updateById(Entity entity) {
		baseDao.updateById(entity);
	}

	public void deleteById(Integer id) {
		baseDao.deleteById(id);
	}

	public void deleteByIds(Set<Integer> ids) {
		baseDao.deleteBatchIds(ids);
	};

	public Integer getTotalCount() {
		return baseDao.selectCount(null);
	}

}
