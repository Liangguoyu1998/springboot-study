package com.liang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //开启定时执行任务功能
public class SpringbootSchedule13Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSchedule13Application.class, args);
    }

}
