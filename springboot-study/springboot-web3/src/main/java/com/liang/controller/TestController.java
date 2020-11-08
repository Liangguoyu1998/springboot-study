package com.liang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author:Lenovo
 * @date:2020-11-02 2020/11/2
 */
@Controller
public class TestController {
    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("msg","<h3>hello,world</h3>");
        List<String> users = new ArrayList<>();
        users.add("小李");
        users.add("小张");
        model.addAttribute("users",users);
        return "test";
    }
}
