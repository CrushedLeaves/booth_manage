package com.zjp.controller;


import com.zjp.entity.Booth;
import com.zjp.service.impl.BoothServiceImpl;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zjp
 * @since 2023-04-03
 */
@RestController
@RequestMapping("/booth")
public class BoothController {


    @Resource
    private BoothServiceImpl boothService;
    //存储摊位信息
    @PostMapping("/setBooth")
    public String setBooth(@RequestBody()Map<String,Object> map) {

        System.out.println(map);
        Booth booth = new Booth();
        booth.setBoothName(map.get("boothname").toString());
        booth.setBoothAddress(map.get("boothaddress").toString());
        booth.setBoothStartTime(map.get("starttime").toString());
        booth.setBoothEndTime(map.get("endtime").toString());
        booth.setBoothPhone(map.get("phone").toString());
        booth.setBoothImg(map.get("Imageurl").toString());
        booth.setBusinessId(map.get("openid").toString());
        System.out.println(booth);
        if (boothService.setBooth(booth)){
            return "插入成功";
        }
        return "插入失败";
    }
    //获取摊位信息
    @GetMapping("/getBooth")
    public Booth getBooth(@RequestParam("id")String id){
        System.out.println("获取"+id+"号摊位信息");
        Booth booth = boothService.getBooth(id);
        System.out.println(booth);
        return booth;
    }
    //获取多个摊位信息
    @GetMapping("/getBooths")
    public List<Booth> getBooths(){
        System.out.println("获取多个摊位信息");
        List<Booth> booths = boothService.getBooths();
        return booths;
    }

    //删除摊位信息
    @GetMapping("/deleteBooth")
    public String deleteBooth(@RequestParam("id")String id){
        System.out.println("删除"+id+"号摊位信息");

        if (boothService.deleteBooth(id)) {
            return "注销成功";
        }
        return "注销失败";
    }

}