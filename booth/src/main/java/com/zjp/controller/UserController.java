package com.zjp.controller;


import com.alibaba.fastjson.JSONObject;
import com.zjp.entity.Business;
import com.zjp.entity.User;
import com.zjp.service.impl.BoothServiceImpl;
import com.zjp.service.impl.UserService;
import com.zjp.service.impl.UserServiceImpl;
import com.zjp.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zjp
 * @since 2023-03-28
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${weixin.appid}")
    private  String appid;
    @Value("${weixin.secret}")
    private  String secret;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private BoothServiceImpl boothService;

    @Autowired
    private UserService service;

    //微信解密用户信息
    @PostMapping("/getUserInfo")
    public String setUserInfo(@RequestBody()Map<String,String> map){
        System.out.println("游客登录请求:"+ map.get("session_key"));
        String session_key = map.get("session_key");
        String encryptedData = map.get("encryptedData");
        String iv = map.get("iv");
        String openid = map.get("openid");
        userService.setUserInfo(encryptedData,iv,openid,session_key);
        return openid;
    }

    @GetMapping("/getUser")
    public Map<String,Object> getBusiness(@RequestParam("openid") String openid){

        Map<String,Object> map = new HashMap<>();
        User user = userService.getUserInfo(openid);
        if (user != null){
            map.put("code",200);
            map.put("status","获取成功");
            map.put("business",user);
        }else{
            map.put("code",500);
            map.put("status","获取失败");
            map.put("business", null);
        }
        return map;
    }

    @GetMapping("/getSession")
    public Map getSession(@RequestParam("code")String code){
        HashMap map = new HashMap();
        JSONObject jsonObject = UserUtils.getUserOpenid(code,appid,secret);
        String openid = jsonObject.getString("openid");
        String session_key = jsonObject.getString("session_key");
        map.put("code",200);
        map.put("status","登陆成功");
        map.put("openid",openid);
        map.put("openid",openid);
        map.put("session_key",session_key);
        return map;
    }

    @GetMapping("/login")
    public Map<String, Object> login(@RequestParam("code")String code){
        System.out.println("用户登录请求:"+ code);
        String openid = service.getSessionId(code);
        int boothId  =  boothService.getBooth(openid).getBoothId();
        Map<String,Object> map  = new HashMap<>();
        map.put("code",200);
        map.put("status","登陆成功");
        map.put("openid",openid);
        map.put("boothId",boothId);

        return map;
    }

}
