package com.liang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author:Lenovo
 * @date:2020-11-02 2020/11/2
 */
@Controller
public class IndexController {
    //我们一般首页不用此方式，而是在config中配置
//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        return "index";
//    }
    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }
}
