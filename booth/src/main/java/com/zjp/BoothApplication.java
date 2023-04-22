package com.zjp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zjp.mapper")
@SpringBootApplication
public class BoothApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoothApplication.class, args);
    }

}
