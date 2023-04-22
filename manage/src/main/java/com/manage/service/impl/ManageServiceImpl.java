package com.manage.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manage.entity.Manage;
import com.manage.entity.RestBean;
import com.manage.mapper.ManageMapper;
import com.manage.service.IManageService;
import com.manage.utils.JwtUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zjp
 * @since 2023-04-16
 */
@Service
public class ManageServiceImpl extends ServiceImpl<ManageMapper, Manage> implements IManageService {

    @Resource
    private StringRedisTemplate template;

    @Resource
    private JavaMailSender sender;

    @Resource
    private ManageMapper manageMapper;

    //查询注册用户
    public Manage selectManage(String email){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("email",email);
        return manageMapper.selectOne(wrapper);
    }

    //返回token
    public RestBean<Manage> login(Manage manage) {
        manage.setPassword("");
        //使用userid生成JWT，并将userid所在用户信息(json)存入redis
        String userid = String.valueOf(manage.getUserid());
        String userJson = JSON.toJSONString(manage);
        //存入Redis
        template.opsForValue().set("user"+userid,userJson);
        System.out.println("Redis存入key:user"+userid);
        Map<String,String> map = new HashMap<>();
        map.put("userToken",userid);
        String token = JwtUtils.sign(map);
        //返回token给响应体
        return new RestBean<>(200,"用户登陆成功",manage,token);
    }

    //发送验证码
    public void sendVerify(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("个人博客登录验证码");
        Random random = new Random();
        int code = random.nextInt(899999)+100000;
        //保存到Redis数据库
        template.opsForValue().set("verify_"+email,code+"");
        message.setText("你的注册验证码为:"+code+",有效时间为三分钟,请勿传递给他人使用");
        message.setTo(email);
        message.setFrom("zjp_student@163.com");
        sender.send(message);
    }

    //验证邮件信息
    public boolean doVerify(String email,String verify) {
        String string = template.opsForValue().get("verify_"+email);
        if(string == null) {
            return false;
        }
        if(string.equals(verify)){
            return true;
        }else{
            return false;
        }
    }
    //存储注册信息
    public boolean setManage(Manage manage){
        try{
            manageMapper.insert(manage);
            return true;
        }catch(Exception e){
            System.out.println("注册失败");
            return false;
        }
    }
}
