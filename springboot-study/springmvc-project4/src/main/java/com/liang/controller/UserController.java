package com.liang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @description:
 * @author:Lenovo
 * @date:2020-11-03 2020/11/3
 */
@Controller
public class UserController {
    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session){
        //先把原先session存储的用户信息清除
        session.removeAttribute("loginUser");
        if(username.equals("小明") && password.equals("123456")){
            session.setAttribute("loginUser",username);
            return "redirect:/home";
        }else{
            model.addAttribute("msg","密码或用户名错误！");
            return "login";
        }
    }
}
