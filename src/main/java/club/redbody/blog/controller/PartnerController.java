package club.redbody.blog.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import club.redbody.blog.service.PartnerService;
import club.redbody.blog.pojo.Partner;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;
import java.util.Set;




@RestController
@RequestMapping("/partner")
public class PartnerController{

    @Autowired
    private PartnerService partnerService;

    @RequestMapping("/add")
    public void add(Partner partner){
        partnerService.insert(partner);
    }

    @RequestMapping("/findById")
    public Partner findById(Integer id){
        return partnerService.selectById(id);
    }

    @RequestMapping("/findAll")
    public List<Partner> findAll(){
        return partnerService.selectAll();
    }

    @RequestMapping("/findAllTotal")
    public Integer findAllTotal(){
        return partnerService.selectAllTotal();
    };

    @RequestMapping("/findOne")
    public Partner findOne(Partner partner){
        return partnerService.selectOne(partner);
    }


    @RequestMapping("/findListByIds")
    public List<Partner> findListByIds(Set<Integer> ids){
        return partnerService.selectListByIds(ids);
    }

    @RequestMapping("/findListByPage")
    public IPage<Partner> findListByPage(Integer pageNum, Integer pageSize){
        return partnerService.selectListByPage(pageNum, pageSize);
    }

    @RequestMapping("/updateById")
    public void updateById(Partner partner){
         partnerService.updateById(partner);
    }

    @RequestMapping("/deleteById")
    public void deleteById(Integer id){
        partnerService.deleteById(id);
    }

    @RequestMapping("/deleteByIds")
    public void deleteByIds(Set<Integer> ids){
        partnerService.deleteByIds(ids);
    }

}