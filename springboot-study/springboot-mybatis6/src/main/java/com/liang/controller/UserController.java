package com.liang.controller;

import com.liang.mapper.UserMapper;
import com.liang.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author:Lenovo
 * @date:2020-11-03 2020/11/3
 */
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/queryUserList")
    public List<User> queryUserList(){
        List<User> userList = userMapper.queryUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        return userList;
    }
    @GetMapping("/addUser")
    public String addUser(){
        userMapper.addUser(new User(5,"小韩","1258459"));
        return "add-ok";
    }
    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id){
        userMapper.updateUser(new User(5,"小小","123456"));
        return "update-ok";
    }
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userMapper.deleteUser(id);
        return "delete-ok";
    }
}
