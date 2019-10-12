package club.redbody.blog.service;

import club.redbody.blog.pojo.Partner;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;
import java.util.Set;


public interface PartnerService{
    public void insert(Partner partner);

    public Partner selectById(Integer id);

    public Partner selectOne(Partner partner);

    public List<Partner> selectAll();

    public Integer selectAllTotal();

    public List<Partner> selectListByIds(Set<Integer> ids);

    public IPage<Partner> selectListByPage(Integer pageNum, Integer pageSize);

    public void updateById(Partner partner);

    public void deleteById(Integer id);

    public void deleteByIds(Set<Integer> ids);



}
