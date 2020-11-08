package com.liang.config;

import com.liang.pojo.User;
import com.liang.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description:
 * @author:Lenovo
 * @date:2020-11-04 2020/11/4
 */
//自定义的UserRealm
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=》授权doGetAuthorizationInfo");
        //SimpleAuthorizationInfo
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //info.addStringPermission("user:add");
        //拿到当前登录的对象
        Subject subject = SecurityUtils.getSubject();
        //拿到User对象
        User currentUser = (User)subject.getPrincipal();
        info.addStringPermission(currentUser.getPerms());
        //return info
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了=》认证doGetAuthenticationInfo.");
        //用户名，密码~ 数据库中去
 //       String username = "root";
//        String password = "123456";
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        //连接真实数据库
        User user = userService.queryUserByName(userToken.getUsername());
        if(user == null){
            return null;
        }
        //可以加密，MD5加密:eelloolie6554deee555555，   MD5盐值加密eelloolie6554deee555555username
        //密码认证了，shiro做~,加密了
        return new SimpleAuthenticationInfo(user,user.getPwd(),"");
    }
}
