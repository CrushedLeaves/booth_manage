package com.zjp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjp.entity.Goods;
import com.zjp.mapper.GoodsMapper;
import com.zjp.service.IGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjp.util.UrlSub;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zjp
 * @since 2023-04-02
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    public boolean setGoods(Goods good){
        if (good != null){
            goodsMapper.insert(good);
            return true;
        }
        return false;
    }

    public boolean thumb(int goodId,boolean thumb){
        Goods goods = goodsMapper.selectById(goodId);
        int like = goods.getLikeNum();
        if(!thumb){
            goods.setLikeNum(++like);
            goodsMapper.updateById(goods);
            return true;
        }
            goods.setLikeNum(--like);
            goodsMapper.updateById(goods);
            return false;
    }

    //获取商品列表信息
    public List<Goods> getGoodList(int id){
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();
        wrapper.eq("booth_id",id);
        return goodsMapper.selectList(wrapper);
    }

    //删除商品信息
    public boolean deleteGood(int id){
        Goods goods = goodsMapper.selectById(id);
        String ImageUrl = goods.getImageUrl();
        deleteFile(ImageUrl);
        int i = goodsMapper.deleteById(id);
        if (i != 0){
            return true;
        }
        return false;
    }

    static void deleteFile(String imageUrl) {
        String filename = UrlSub.getFile(imageUrl);
        String filePath = "D:\\idea\\mybatis_test\\images\\";
        String filePathAndName = filePath + filename;
        System.out.println(filePathAndName);
        try {
            File file = new File(filePathAndName);
            file.delete();
        } catch (Exception e) {
            System.out.println("删除文件操作出错");
            e.printStackTrace();
        }
    }

}
