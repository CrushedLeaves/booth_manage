package com.zjp.util;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;

public class UserUtils {

    /*
    获取openid
    传参：code,
     */

    public  static JSONObject getUserOpenid(String code,String appid,String secret){

        String url = "https://api.weixin.qq.com/sns/jscode2session?appid={0}&secret={1}&js_code={2}&grant_type=authorization_code";
        String replaceUrl = url.replace("{0}",appid).replace("{1}",secret).replace("{2}",code);
        String res = HttpUtil.get(replaceUrl);
        JSONObject jsonObject = JSONObject.parseObject(res);
        return jsonObject;
    }
}
