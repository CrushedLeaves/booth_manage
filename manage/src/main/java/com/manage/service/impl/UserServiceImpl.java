package com.manage.service.impl;

import com.manage.entity.User;
import com.manage.mapper.UserMapper;
import com.manage.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zjp
 * @since 2023-04-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    public List<User> getUserList(){
        return userMapper.selectList(null);
    }

}
