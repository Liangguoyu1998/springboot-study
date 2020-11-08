package com.liang.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description:
 * @author:Lenovo
 * @date:2020-11-04 2020/11/4
 */
@Configuration
public class ShiroConfig {
    //ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //添加shiro的内置过滤器
        /**
         *  anon:无需认证就可以访问
         *  authc:需要认证才能访问
         *  user:不许拥有 记住我 功能才能用
         *  perms:拥有对某个资源的权限才能访问
         *  role:拥有某个角色权限才能访问
         */
        Map<String,String> filterMap = new LinkedHashMap<>();
        //授权，如果没有授权，会调到一个未授权的页面
        filterMap.put("/user/add","perms[user:add]");
        filterMap.put("/user/update","perms[user:update]");
        filterMap.put("/user/*","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        //设置登录的请求
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        //未授权，跳转页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/noauth");
        return shiroFilterFactoryBean;
    }
    //DefaultWebSecurityManager
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    //创建 realm 对象，需要自定义
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }
    //整合ShiroDialect:用来整合shiro和thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }

}
