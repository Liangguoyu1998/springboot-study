package com.liang.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author:Lenovo
 * @date:2020-11-02 2020/11/2
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hell(){
        return "hello,world!";
    }
}
