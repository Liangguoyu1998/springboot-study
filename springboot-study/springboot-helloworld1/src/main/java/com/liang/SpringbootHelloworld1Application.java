package com.liang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@SpringBootApplication：标注这个类是一个SpringBoot应用
//启动类下的所有资源被导入
@SpringBootApplication
public class SpringbootHelloworld1Application {

    public static void main(String[] args) {
        //将SpringBoot应用启用
        SpringApplication.run(SpringbootHelloworld1Application.class, args);
    }

}
