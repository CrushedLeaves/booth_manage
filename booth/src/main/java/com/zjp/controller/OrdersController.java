package com.zjp.controller;


import com.zjp.entity.OrderList;
import com.zjp.entity.Orders;
import com.zjp.service.impl.OrdersServiceImpl;
import com.zjp.util.UUIDUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zjp
 * @since 2023-04-13
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Resource
    private OrdersServiceImpl ordersService;

    @PostMapping("/setOrders")
    public String setOrder(@RequestBody() Map<String,String> map){
        String uid = UUIDUtils.creatUUID();
        System.out.println(map);
        Orders order = new Orders();
        order.setOrderId(Integer.parseInt(uid));
        order.setBoothId(Integer.parseInt(map.get("boothId")));
        order.setSumOrder(map.get("sum"));
        order.setOpenid(map.get("openid"));
        System.out.println(ordersService.setOrder(order));
        return uid;
    }
//    查询订单
    @GetMapping("/getOrderGood")
    public List<OrderList> getOrderGood(@RequestParam("openid")String openid){
        System.out.println("获取订单信息");
        System.out.println("list2"+ordersService.getOrder(openid));
        return ordersService.getOrder(openid);
    }

}
