package com.liang.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author:Lenovo
 * @date:2020-11-02 2020/11/2
 */
@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello world!";
    }
}
