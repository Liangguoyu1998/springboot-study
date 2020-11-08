package com.liang.controller;

import com.liang.service.AsynService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author:Lenovo
 * @date:2020-11-05 2020/11/5
 */
@RestController
public class AsynController {
    @Autowired
    private AsynService asynService;
    @RequestMapping("/hello")
    public String hello(){
        asynService.hello();
        return "hello";
    }
}
