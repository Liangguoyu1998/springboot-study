package com.liang.controller;

import com.liang.pojo.User;
import com.sun.istack.internal.NotNull;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author:Lenovo
 * @date:2020-11-04 2020/11/4
 */
@RestController
public class HelloController {
    @ApiOperation("hello方法")
    @RequestMapping("/hello/{id}/{name}/{age}")
    public User hello(@ApiParam("传过来的用户")User user){
        return user;
    }
    @ApiOperation("test方法")
    @GetMapping("/test/{id1}")
    public String test(@ApiParam("用户id~~") @PathVariable("id1")int id){
        return ""+id;
    }
}
