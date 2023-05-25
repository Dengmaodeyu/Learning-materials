package com.xixicc.adminservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author pcc
 * @version 1.0
 * @description admin 启动服务器
 * @date 2023/4/8 19:50
 */
@SpringBootApplication
@MapperScan("com.xixicc.*.dao")
@ComponentScan(basePackages = {"com.xixicc"})
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class,args);
    }
}
