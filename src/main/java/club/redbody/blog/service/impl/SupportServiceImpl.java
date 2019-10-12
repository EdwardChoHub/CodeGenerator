package club.redbody.blog.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import club.redbody.blog.dao.SupportDao;
import club.redbody.blog.service.SupportService;
import club.redbody.blog.pojo.Support;
import java.util.List;
import java.util.Set;

import java.util.Date;

@Service
@Transactional
public class SupportServiceImpl implements SupportService {
    @Autowired
    private SupportDao supportDao;

    public void insert(Support support) {
        supportDao.insert(support);
    }

    public Support selectById(Integer id) {
        return supportDao.selectById(id);
    }

    public Support selectOne(Support support){
        QueryWrapper<Support> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(support);
        return supportDao.selectOne(queryWrapper);
    }

    public List<Support> selectAll() {
        return supportDao.selectList(null);
    }

    public Integer selectAllTotal() {
        return supportDao.selectCount(null);
    }

    public List<Support> selectListByIds(Set<Integer> ids) {
        return supportDao.selectBatchIds(ids);
    }

    public IPage<Support> selectListByPage(Integer pageNum, Integer pageSize) {
        Page<Support> page  = new Page<>(pageNum,pageSize);
        return supportDao.selectPage(page,null);
    }

    public void updateById(Support support) {
        supportDao.updateById(support);
    }

    public void deleteById(Integer id) {
        supportDao.deleteById(id);
    }

    public void deleteByIds(Set<Integer> ids) {
        supportDao.deleteBatchIds(ids);
    };
}
