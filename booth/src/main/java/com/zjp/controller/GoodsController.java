package com.zjp.controller;


import com.zjp.entity.Goods;
import com.zjp.service.impl.GoodsServiceImpl;
import com.zjp.util.FileUpLoad;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zjp
 * @since 2023-03-13
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsServiceImpl goodsService;

    int i=1;


    @PostMapping("/goodsList")
    public String setGoods(@RequestBody() Map<String,String> map){
        Goods goods = new Goods();
        goods.setGoodName(map.get("goodname"));
        System.out.println("----------------"+(i++)+"-------------");
        goods.setGoodType(map.get("goodtype"));
        BigDecimal bd=new BigDecimal(map.get("price"));
        goods.setPrice(bd);
        goods.setDescription(map.get("desc"));
        BigDecimal bd2=new BigDecimal(map.get("discount"));
        goods.setDiscount(bd2);
        goods.setImageUrl(map.get("Imageurl"));
        goods.setBoothId(Integer.parseInt(map.get("boothId").toString()));
        System.out.println(goods);
        //存储数据库
        if (goodsService.setGoods(goods)){
            return "存储成功";
        }
        return "存储失败";
    }


    @PostMapping("/uploadImage")
    public String uploadImage(MultipartFile file){
        String url = FileUpLoad.getFileUrl(file);
        System.out.println("获取图片地址:" + url);
        return url;
    }

    //获取商品列表
    @GetMapping("/getGoodList")
    public Map<String, Object> getGoodList(@RequestParam("boothId")int id){
        List<Goods> goods = goodsService.getGoodList(id);
        for (int j = 0; j < goods.toArray().length; j++) {
            if(goods.get(j).getLikeNum() == null){
                goods.get(j).setLikeNum(0);
            }
        }
        Map<String,Object> map = new HashMap<>();
        if(goods == null){
            map.put("code","200");
            map.put("status","请求失败");
            map.put("data",goods);
        }else{
            map.put("code","500");
            map.put("status","请求成功");
            map.put("data",goods);
        }
        return map;
    }
    //删除商品
    @GetMapping("/deleteGood")
    public String deleteGood(@RequestParam("goodId")int id){
        goodsService.deleteGood(id);
        return "删除成功";
    }

    //点赞与取消点赞
    @GetMapping("/thumb")
    public String thumb(@RequestParam("goodId")int goodId,@RequestParam("thumb")boolean thumb){
        System.out.println("点赞"+goodId+";"+thumb);
        if(goodsService.thumb(goodId,thumb)){
            return "点赞成功";
        }
        return "取消点赞成功";
    }

}
