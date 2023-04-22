package com.zjp.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Slf4j
@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

    @Value("${logo-img.request-path}")
    private String logoReqPath; // 请求地址
    @Value("${logo-img.local-path}")
    private String logoLocPath; // 本地存放资源目录的绝对路径

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        File logoDir = new File(logoLocPath);
        boolean flag = false;
        if (!logoDir.exists())
            flag = logoDir.mkdirs();
        if (flag)
            log.info("已成功创建资源 logo 目录：{}", logoLocPath);

        log.info("getAbsolutePath = {}", logoDir.getAbsolutePath());
        log.info("getPath = {}", logoDir.getPath());

        registry.addResourceHandler(logoReqPath)
                .addResourceLocations("file:" + logoDir.getAbsolutePath() + File.separator);
    }
}
