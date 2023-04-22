package com.zjp.controller;


import com.alibaba.fastjson.JSONObject;
import com.zjp.entity.Business;
import com.zjp.service.impl.BoothServiceImpl;
import com.zjp.service.impl.BusinessServiceImpl;
import com.zjp.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
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
@RequestMapping("/business")
public class BusinessController {

    @Resource
    private BusinessServiceImpl businessService;


    @Value("${weixin.appid}")
    private  String appid;
    @Value("${weixin.secret}")
    private  String secret;

    @Autowired
    private BoothServiceImpl boothService;


    @GetMapping("/getSession")
    public Map getSession(@RequestParam("code")String code){
        Map<String,Object> map = new HashMap();
        JSONObject jsonObject = UserUtils.getUserOpenid(code,appid,secret);
        String openid = jsonObject.getString("openid");
        String session_key = jsonObject.getString("session_key");
        if(boothService.getBooth(openid)==null){
            int boothId = -1;
            map.put("boothId",boothId);
        }else{
            int boothId  =  boothService.getBooth(openid).getBoothId();
            map.put("boothId",boothId);
        }
        map.put("code",200);
        map.put("status","登陆成功");
        map.put("openid",openid);
        map.put("openid",openid);
        map.put("session_key",session_key);
        return map;
    }

    @PostMapping ("/login")
    public String login(@RequestBody()Map<String,String> map){

        System.out.println("商户登录请求:"+ map.get("session_key"));
        String session_key = map.get("session_key");
        String encryptedData = map.get("encryptedData");
        String iv = map.get("iv");
        String openid = map.get("openid");
        businessService.setBusiness(session_key, encryptedData, iv, openid);
        return openid;
    }

    @GetMapping("/getBusiness")
    public Map<String,Object> getBusiness(@RequestParam("openid") String openid){

        Map<String,Object> map = new HashMap<>();
        Business business =  businessService.getBusiness(openid);
        if (business != null){
            map.put("code",200);
            map.put("status","获取成功");
            map.put("business",business);
        }else{
            map.put("code",500);
            map.put("status","获取失败");
            map.put("business", null);
        }
        return map;
    }

}
