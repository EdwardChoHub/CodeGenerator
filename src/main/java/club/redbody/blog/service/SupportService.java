package club.redbody.blog.service;

import club.redbody.blog.pojo.Support;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;
import java.util.Set;


public interface SupportService{
    public void insert(Support support);

    public Support selectById(Integer id);

    public Support selectOne(Support support);

    public List<Support> selectAll();

    public Integer selectAllTotal();

    public List<Support> selectListByIds(Set<Integer> ids);

    public IPage<Support> selectListByPage(Integer pageNum, Integer pageSize);

    public void updateById(Support support);

    public void deleteById(Integer id);

    public void deleteByIds(Set<Integer> ids);



}
