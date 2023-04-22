package com.zjp.util;

public class UUIDUtils {
    public static String creatUUID(){
        int hashCode = java.util.UUID.randomUUID().toString().hashCode();
        if (hashCode <0){
            hashCode=-hashCode;
        }
        // 0 代表前面补充0
        // 10 代表长度为10
        // d 代表参数为正数型
        String format = String.format("%010d", hashCode).substring(0,10);
        return format;
    }
}
