package com.zjp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjp.entity.*;
import com.zjp.mapper.OrdersMapper;
import com.zjp.service.IOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zjp
 * @since 2023-04-13
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

    //插入订单
    @Resource
    private OrdersMapper ordersMapper;

    @Resource
    private BoothServiceImpl boothService;

    @Resource
    private OrderGoodServiceImpl orderGoodService;

    @Resource
    private GoodsServiceImpl goodsService;

    //设置订单
    public int setOrder(Orders orders){
        int i = ordersMapper.insert(orders);
        return i;
    }
    //获取订单
    public List<OrderList> getOrder(String openid){
        //获取订单
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("openid",openid);
        List<Orders> orders= ordersMapper.selectList(wrapper);
        List<OrderList> orderLists = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
            OrderList orderList = new OrderList();
            orderList.setOrderId(orders.get(i).getOrderId());
            orderList.setSum(orders.get(i).getSumOrder());
            orderList.setState(Integer.parseInt(orders.get(i).getOrderStatus()));
            orderList.setTime(orders.get(i).getCreattime().toString());
            Booth booth = boothService.getBoothByID(orders.get(i).getBoothId());
            orderList.setBoothName(booth.getBoothName());
            List<OrderGood> orderGoods = orderGoodService.getOrderGoodList(orders.get(i).getOrderId());
            List<String> images = new ArrayList<>();
            orderGoods.forEach(orderGood -> {
                Goods goods = goodsService.getById(orderGood.getGoodId());
                String image = goods.getImageUrl();
                images.add(image);
            });
            orderList.setImages(images);
            orderLists.add(orderList);
        }
        return orderLists;
    }
}
