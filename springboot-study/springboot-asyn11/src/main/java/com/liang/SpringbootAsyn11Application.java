package com.liang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync   //开启异步任务
public class SpringbootAsyn11Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAsyn11Application.class, args);
    }

}
