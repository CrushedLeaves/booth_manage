package com.manage.service;

import com.manage.entity.Manage;
import com.manage.service.impl.ManageServiceImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userDetailsService")
public class AuthService implements UserDetailsService {
    @Resource
    private ManageServiceImpl manageService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("userDetails验证:"+username);
        Manage manage = manageService.selectManage(username);
        if(manage==null){
            throw new UsernameNotFoundException("用户不存在，请确认输入的用户名是否正确");
        }

        //建立权限信息对象
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("role");
        return new User(manage.getEmail(),manage.getPassword(),auths);
    }
}