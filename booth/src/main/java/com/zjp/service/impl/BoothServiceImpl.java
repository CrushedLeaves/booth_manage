package com.zjp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjp.entity.Booth;
import com.zjp.mapper.BoothMapper;
import com.zjp.service.IBoothService;
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
 * @since 2023-04-03
 */
@Service
public class BoothServiceImpl extends ServiceImpl<BoothMapper, Booth> implements IBoothService {

    @Resource
    private BoothMapper boothMapper;

    //存储商店信息
    public boolean setBooth(Booth booth){

        try{
            int i = boothMapper.insert(booth);
            System.out.println(i);
        }catch(Exception e){
            System.out.println("数据库存储失败");
            return false;
        }
        return true;
    }

    //通过商店id插商店
    public Booth getBoothByID(int id){
        return boothMapper.selectById(id);
    }

    //获取商店信息
    public Booth getBooth(String id){

        System.out.println("查询id为"+id+"的数据");
        QueryWrapper<Booth> wrapper = new QueryWrapper<>();
        wrapper.eq("business_id",id);
        return boothMapper.selectOne(wrapper);
    }

    //获取多个商店信息
    public List<Booth> getBooths(){
        return boothMapper.selectList(null);
    }

    //删除摊位信息
    public boolean deleteBooth(String id){
        QueryWrapper<Booth> wrapper = new QueryWrapper<>();
        wrapper.eq("business_id",id);
        Booth booth = boothMapper.selectOne(wrapper);
        String ImageUrl = booth.getBoothImg();
        GoodsServiceImpl.deleteFile(ImageUrl);
        try {
            int i = boothMapper.delete(wrapper);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("注销失败");
            return false;
        }
        return true;
    }

}
