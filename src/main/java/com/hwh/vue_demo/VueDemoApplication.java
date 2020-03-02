package com.hwh.vue_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hwh.vue_demo.mapper")
public class VueDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(VueDemoApplication.class, args);
    }

}
