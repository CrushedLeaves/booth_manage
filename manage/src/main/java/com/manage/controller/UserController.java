package com.manage.controller;


import com.manage.entity.User;
import com.manage.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zjp
 * @since 2023-04-18
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserServiceImpl userService;

    @GetMapping("/getUserList")
    public List<User> getUserList(){
        System.out.println("获取用户列表数据");
        return userService.getUserList();
    }

}
