package club.redbody.blog.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import club.redbody.blog.service.NoticeService;
import club.redbody.blog.pojo.Notice;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;
import java.util.Set;



import java.util.Date;

@RestController
@RequestMapping("/notice")
public class NoticeController{

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/add")
    public void add(Notice notice){
        noticeService.insert(notice);
    }

    @RequestMapping("/findById")
    public Notice findById(Integer id){
        return noticeService.selectById(id);
    }

    @RequestMapping("/findAll")
    public List<Notice> findAll(){
        return noticeService.selectAll();
    }

    @RequestMapping("/findAllTotal")
    public Integer findAllTotal(){
        return noticeService.selectAllTotal();
    };

    @RequestMapping("/findOne")
    public Notice findOne(Notice notice){
        return noticeService.selectOne(notice);
    }


    @RequestMapping("/findListByIds")
    public List<Notice> findListByIds(Set<Integer> ids){
        return noticeService.selectListByIds(ids);
    }

    @RequestMapping("/findListByPage")
    public IPage<Notice> findListByPage(Integer pageNum, Integer pageSize){
        return noticeService.selectListByPage(pageNum, pageSize);
    }

    @RequestMapping("/updateById")
    public void updateById(Notice notice){
         noticeService.updateById(notice);
    }

    @RequestMapping("/deleteById")
    public void deleteById(Integer id){
        noticeService.deleteById(id);
    }

    @RequestMapping("/deleteByIds")
    public void deleteByIds(Set<Integer> ids){
        noticeService.deleteByIds(ids);
    }

}