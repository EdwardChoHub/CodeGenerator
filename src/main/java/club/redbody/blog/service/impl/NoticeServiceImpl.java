package club.redbody.blog.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import club.redbody.blog.dao.NoticeDao;
import club.redbody.blog.service.NoticeService;
import club.redbody.blog.pojo.Notice;
import java.util.List;
import java.util.Set;

import java.util.Date;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeDao noticeDao;

    public void insert(Notice notice) {
        noticeDao.insert(notice);
    }

    public Notice selectById(Integer id) {
        return noticeDao.selectById(id);
    }

    public Notice selectOne(Notice notice){
        QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(notice);

        return noticeDao.selectOne(queryWrapper);
    }

    public List<Notice> selectAll() {
        return noticeDao.selectList(null);
    }

    public Integer selectAllTotal() {
        return noticeDao.selectCount(null);
    }

    public List<Notice> selectListByIds(Set<Integer> ids) {
        return noticeDao.selectBatchIds(ids);
    }

    public IPage<Notice> selectListByPage(Integer pageNum, Integer pageSize) {
        Page<Notice> page  = new Page<>(pageNum,pageSize);
        return noticeDao.selectPage(page,null);
    }

    public void updateById(Notice notice) {
        noticeDao.updateById(notice);
    }

    public void deleteById(Integer id) {
        noticeDao.deleteById(id);
    }

    public void deleteByIds(Set<Integer> ids) {
        noticeDao.deleteBatchIds(ids);
    };
}
