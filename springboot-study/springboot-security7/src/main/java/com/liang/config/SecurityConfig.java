package com.liang.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

/**
 * @description:
 * @author:Lenovo
 * @date:2020-11-03 2020/11/3
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //@Autowired
    //private DataSource dataSource;
     //授权
    //链式编程
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问，功能页只有对应有权限的人才能访问
        //请求授权的规则
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasAnyRole("vip1")
                .antMatchers("/level2/**").hasAnyRole("vip2")
                .antMatchers("/level3/**").hasAnyRole("vip3");
        //没有权限默认会到登录页面,需要开启登录的页面
        // /login
        //定制登录页 loginPage("/toLogin")
        http.formLogin().loginPage("/toLogin");
        //注销,开启注销功能
        //http.logout();
        //注销成功,跳到首页
        http.csrf().disable(); //关闭csrf功能，解决注销退出报错
        http.logout().logoutSuccessUrl("/");
        //开启记住我功能
        http.rememberMe().rememberMeParameter("remember");
    }
    //认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //这些数据正常应该从数据库中读
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("kuangsheng").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip3")
                .and().withUser("liang").password(new BCryptPasswordEncoder().encode("199805")).roles("vip1","vip2")
                .and().withUser("root").password(new BCryptPasswordEncoder().encode("root")).roles("vip1","vip2","vip3");
        //用数据库中的数据进行认证
//        auth.jdbcAuthentication().dataSource(dataSource)
//                .passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("kuangsheng").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip3")
//                .and().withUser("liang").password(new BCryptPasswordEncoder().encode("199805")).roles("vip1","vip2")
//                .and().withUser("root").password(new BCryptPasswordEncoder().encode("root")).roles("vip1","vip2","vip3");
    }

}
