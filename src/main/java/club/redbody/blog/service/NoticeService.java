package club.redbody.blog.service;

import club.redbody.blog.pojo.Notice;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;
import java.util.Set;


public interface NoticeService{
    public void insert(Notice notice);

    public Notice selectById(Integer id);

    public Notice selectOne(Notice notice);

    public List<Notice> selectAll();

    public Integer selectAllTotal();

    public List<Notice> selectListByIds(Set<Integer> ids);

    public IPage<Notice> selectListByPage(Integer pageNum, Integer pageSize);

    public void updateById(Notice notice);

    public void deleteById(Integer id);

    public void deleteByIds(Set<Integer> ids);



}
