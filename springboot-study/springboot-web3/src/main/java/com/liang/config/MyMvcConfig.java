package com.liang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

/**
 * @description:
 * @author:Lenovo
 * @date:2020-11-02 2020/11/2
 */
//如果我们要扩展springmvc,官方建议我们这样做

//如果，你想diy一些定制化的功能，只要写这个组件，然后将它交给
//springboot,springboot就会帮我们自动装配！
//扩展springmvc dipatchservlet
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    //ViewResolver 实现了视图解析器接口的类，我们就可以
    //把它看做视图解析器
//    @Bean
//    public ViewResolver myViewResolver(){
//        return new MyViewResolver();
//    }
//    public static class MyViewResolver implements ViewResolver {
//
//        @Override
//        public View resolveViewName(String s, Locale locale) throws Exception {
//            return null;
//        }
//    }

    //视图跳转

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/liang").setViewName("test");
    }
}
