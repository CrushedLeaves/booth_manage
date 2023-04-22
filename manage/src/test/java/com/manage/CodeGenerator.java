package com.manage;


import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class CodeGenerator {


    @Test
    public void test1(){
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/booth_sys", "root", "root")
                .globalConfig(builder -> {
                    builder.author("zjp") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
//                            .fileOverride(false) // 覆盖已生成文件
                            .outputDir("D:\\idea\\mybatis_test\\manage\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.manage")
                            .entity("entity")
                            .service("service")
                            .serviceImpl("service.impl")
                            .controller("controller")
                            .mapper("mapper")
                            .xml("mapper")
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, System.getProperty("user.dir")+"\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}