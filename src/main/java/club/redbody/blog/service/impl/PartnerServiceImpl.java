package club.redbody.blog.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import club.redbody.blog.dao.PartnerDao;
import club.redbody.blog.service.PartnerService;
import club.redbody.blog.pojo.Partner;
import java.util.List;
import java.util.Set;


@Service
@Transactional
public class PartnerServiceImpl implements PartnerService {
    @Autowired
    private PartnerDao partnerDao;

    public void insert(Partner partner) {
        partnerDao.insert(partner);
    }

    public Partner selectById(Integer id) {
        return partnerDao.selectById(id);
    }

    public Partner selectOne(Partner partner){
        QueryWrapper<Partner> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(partner);
        return partnerDao.selectOne(queryWrapper);
    }

    public List<Partner> selectAll() {
        return partnerDao.selectList(null);
    }

    public Integer selectAllTotal() {
        return partnerDao.selectCount(null);
    }

    public List<Partner> selectListByIds(Set<Integer> ids) {
        return partnerDao.selectBatchIds(ids);
    }

    public IPage<Partner> selectListByPage(Integer pageNum, Integer pageSize) {
        Page<Partner> page  = new Page<>(pageNum,pageSize);
        return partnerDao.selectPage(page,null);
    }

    public void updateById(Partner partner) {
        partnerDao.updateById(partner);
    }

    public void deleteById(Integer id) {
        partnerDao.deleteById(id);
    }

    public void deleteByIds(Set<Integer> ids) {
        partnerDao.deleteBatchIds(ids);
    };
}
