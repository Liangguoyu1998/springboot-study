package com.liang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author:Lenovo
 * @date:2020-11-03 2020/11/3
 */
@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    //查询数据库的所有信息
    //没有实体类，数据库中的东西，怎么获取？  Map
    @GetMapping("/userList")
    public List test(){
        String sql = "select * from user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        System.out.println(maps);
        return maps;
    }
    @GetMapping("/addUser")
    public String addUser(){
        String sql = "insert into user(id,name,pwd) values(5,'小韩','123456')";
        jdbcTemplate.update(sql);
        return "add-ok";
    }
    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id){
        String sql = "update user set name=?,pwd=? where id="+id;
        //封装
        Object[] objects = new Object[2];
        objects[0] = "小海";
        objects[1] = "854692";
        jdbcTemplate.update(sql,objects);
        return "update-ok";
    }
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        String sql = "delete from user where id=?";
        jdbcTemplate.update(sql,id);
        return "delete-ok";
    }
}
