package com.manage.controller;


import com.manage.entity.Manage;
import com.manage.entity.RestBean;
import com.manage.service.impl.ManageServiceImpl;
import com.manage.utils.UUIDUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zjp
 * @since 2023-04-16
 */
@RestController
@RequestMapping("/manage")
public class ManageController {


    @Resource
    private ManageServiceImpl service;

//    数据加密
    @Resource
    private PasswordEncoder passwordEncoder;

    //登陆验证功能
    @PostMapping("/login-failure")
    public RestBean<Void> loginFailure(){
        System.out.println("登陆失败");
        return new RestBean<>(401,"登陆失败,铁子");
    }

    //登录成功
    @PostMapping("/login-success")
    public RestBean<Manage> loginSuccess(){
        //从security中获取那个用户登陆成功。
        SecurityContext context = SecurityContextHolder.getContext();
        Manage manage = service.selectManage(context.getAuthentication().getName());

        //传递数据交给登录业务，
        /**
         * Param 用户信息
         * return 相应数据
         */
//        返回token
        return service.login(manage);
    }

    //获取邮件服务
    @RequestMapping("/verify/{email}")
    public void getVerify(@PathVariable("email") String email){
        System.out.println("发送邮件中..."+email);
        service.sendVerify(email);
    }

    @PostMapping("/register")
    public RestBean<Void> register(
                                   @RequestParam String password,
                                   @RequestParam String email,
                                   @RequestParam String verify){
        if(service.doVerify(email,verify)) {
            //对密码加密处理
            String encoder = passwordEncoder.encode(password);
            String uid = UUIDUtils.creatUUID();
            Manage manage = new Manage();
            manage.setUserid(Integer.parseInt(uid));
            manage.setPassword(encoder);
            manage.setEmail(email);
            service.setManage(manage);
            System.out.println(email+"注册成功");
            return new RestBean<>(201, "注册成功");
        }else{
            System.out.println(email+"注册失败");
            return new RestBean<>(402,"注册失败，请稍后再试");
        }
    }

}
