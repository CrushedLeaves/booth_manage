package com.zjp.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlSub {

    public static String getFile(String url){
        String regEx = ".+/(.+)$";
        // String regEx = ".+\\\\(.+)$";
        // String str = "c:\\dir1\\dir2\\文件.pdf";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(url);
        if (!m.find()) {
            System.out.println("文件路径格式错误!");
            return "文件格式错误";
        }
        System.out.println(m.group(1));
        return m.group(1);
    }
}
