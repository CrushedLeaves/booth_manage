package com.zjp.controller;


import com.alibaba.fastjson.JSONArray;
import com.zjp.entity.OrderGood;
import com.zjp.service.impl.OrderGoodServiceImpl;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zjp
 * @since 2023-04-12
 */
@RestController
@RequestMapping("/order-good")
public class OrderGoodController {

    @Resource
    private OrderGoodServiceImpl orderGoodService;

    @PostMapping("/setOrderGood")
    public String setOrderGood(@RequestBody() Map<String,Object> map){
        System.out.println(map);
        JSONArray list = (JSONArray) JSONArray.toJSON(map.get("goodList"));
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            OrderGood orderGood = new OrderGood();
            orderGood.setGoodId(Integer.parseInt(list.get(i).toString()));
            orderGood.setOrderId(Integer.parseInt(map.get("orderId").toString()));
            orderGoodService.setOrderGood(orderGood);
        }
        return "KEYI";
    }

}
