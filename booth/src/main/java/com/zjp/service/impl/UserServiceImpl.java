package com.zjp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zjp.entity.User;
import com.zjp.mapper.UserMapper;
import com.zjp.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjp.util.WXUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zjp
 * @since 2023-03-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    public String setUserInfo(String encryptedData,String iv,String openid,String session_key){
        System.out.println("解密并获取游客信息");
        System.out.println("获取密钥："+session_key);
        JSONObject object = WXUtils.getUserInfo(encryptedData,session_key,iv);
        User user = new User();
        user.setOpenid(openid);
        user.setUsername(object.getString("nickName"));
        user.setImgUrl(object.getString("avatarUrl"));
        //插入数据库
        userMapper.insert(user);
        return "获取成功";

    }

//    获取用户信息
    public User getUserInfo(String openid){
        System.out.println("数据库并获取游客信息");
        User user = userMapper.selectById(openid);
        return user;
    }
}
