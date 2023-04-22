package com.zjp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zjp.entity.Business;
import com.zjp.mapper.BusinessMapper;
import com.zjp.service.IBusinessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjp.util.UserUtils;
import com.zjp.util.WXUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zjp
 * @since 2023-03-13
 */
@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements IBusinessService {


    @Autowired
    private BusinessMapper mapper;


    public boolean setBusiness(String session_key,String encryptedData,String iv,String openid) {
        JSONObject userData = WXUtils.getUserInfo(encryptedData,session_key,iv);
        Business business = new Business();
        business.setBusName(userData.getString("nickName"));
        business.setGender(userData.getString("gender"));
        business.setImgAddress(userData.getString("avatarUrl"));
        business.setOpenid(openid);
        System.out.println(business);
        try {
            mapper.insert(business);
        } catch (Exception e) {
            System.out.println("存在此数据");
            return false;
        }
        return true;
    }

    //获取用户信息
    public Business getBusiness(String openid){
        Business business = null;
        try {
            business = mapper.selectById(openid);
        } catch (Exception e) {
            System.out.println("未存在此用户");
            return null;
        }
        return business;
    }
}
