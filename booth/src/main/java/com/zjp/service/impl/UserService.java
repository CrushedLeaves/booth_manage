package com.zjp.service.impl;


import com.zjp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Value("${weixin.appid}")
    private String appid;
    @Value("${weixin.secret}")
    private String secret;

    @Autowired
    private UserMapper userMapper;

    @Resource
    StringRedisTemplate stringRedisTemplate;
    public String getSessionId(String code) {
//
//        JSONObject jsonObject = UserUtils.getUserOpenid(code);
//        String openid = jsonObject.getString("openid");
//        String session_key = jsonObject.getString("session_key");
//        User user = new User();
//        user.setOpenid(jsonObject.getString("openid"));
//        user.setUsername(null);
//        try{
//            userMapper.insert(user);
//        }catch(Exception e){
//            System.out.println("存在此数据");
//        }
//        stringRedisTemplate.opsForValue().set(openid,session_key);
        return "lll";
    }

}
