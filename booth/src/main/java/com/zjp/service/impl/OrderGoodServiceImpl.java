package com.zjp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjp.entity.OrderGood;
import com.zjp.mapper.OrderGoodMapper;
import com.zjp.service.IOrderGoodService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zjp
 * @since 2023-04-12
 */
@Service
public class OrderGoodServiceImpl extends ServiceImpl<OrderGoodMapper, OrderGood> implements IOrderGoodService {


    @Resource
    private OrderGoodMapper orderGoodMapper;

    //插入商品订单练习表
    public boolean setOrderGood(OrderGood orderGood){
        try{
            orderGoodMapper.insert(orderGood);
            return true;
        }catch(Exception e){
            System.out.println("插入失败");
            return false;
        }
    }
    //查询该订单中存在的商品
    public List<OrderGood> getOrderGoodList(int order){
        QueryWrapper<OrderGood> wrapper = new QueryWrapper<>();
        wrapper.eq("order_id",order);
        try{
            return orderGoodMapper.selectList(wrapper);
        }catch (Exception e){
            System.out.println("查询结果为空");
            return null;
        }

    }
}
