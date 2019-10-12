package club.redbody.blog.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import club.redbody.blog.service.SupportService;
import club.redbody.blog.pojo.Support;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;
import java.util.Set;



import java.util.Date;

@RestController
@RequestMapping("/support")
public class SupportController{

    @Autowired
    private SupportService supportService;

    @RequestMapping("/add")
    public void add(Support support){
        supportService.insert(support);
    }

    @RequestMapping("/findById")
    public Support findById(Integer id){
        return supportService.selectById(id);
    }

    @RequestMapping("/findAll")
    public List<Support> findAll(){
        return supportService.selectAll();
    }

    @RequestMapping("/findAllTotal")
    public Integer findAllTotal(){
        return supportService.selectAllTotal();
    };

    @RequestMapping("/findOne")
    public Support findOne(Support support){
        return supportService.selectOne(support);
    }


    @RequestMapping("/findListByIds")
    public List<Support> findListByIds(Set<Integer> ids){
        return supportService.selectListByIds(ids);
    }

    @RequestMapping("/findListByPage")
    public IPage<Support> findListByPage(Integer pageNum, Integer pageSize){
        return supportService.selectListByPage(pageNum, pageSize);
    }

    @RequestMapping("/updateById")
    public void updateById(Support support){
         supportService.updateById(support);
    }

    @RequestMapping("/deleteById")
    public void deleteById(Integer id){
        supportService.deleteById(id);
    }

    @RequestMapping("/deleteByIds")
    public void deleteByIds(Set<Integer> ids){
        supportService.deleteByIds(ids);
    }

}