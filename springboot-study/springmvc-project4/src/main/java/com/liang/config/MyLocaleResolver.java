package com.liang.config;

import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Locale;

/**
 * @description:
 * @author:Lenovo
 * @date:2020-11-02 2020/11/2
 */
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //如果没有就使用默认的
        Locale defaultLocale = Locale.getDefault();
        String lang = httpServletRequest.getParameter("lang");
        //如果请求的连接携带了国际化的参数
        if(!StringUtils.isEmpty(lang)){
            //zh_CN
            String[] s = lang.split("_");
            //国家，地区
            defaultLocale = new Locale(s[0], s[1]);
        }
        return defaultLocale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
