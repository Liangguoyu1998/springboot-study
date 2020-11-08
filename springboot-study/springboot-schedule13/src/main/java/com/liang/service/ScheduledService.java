package com.liang.service;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author:Lenovo
 * @date:2020-11-05 2020/11/5
 */
@Service
public class ScheduledService {
    //在一个特定的时间执行这个方法~ Timer
    //cron表达式
    //秒 分 时 日 月 周几~
    @Scheduled(cron = "0 * * * * 0-7")
    public void hello(){

        String format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
        System.out.println(format+":hello,你被执行了！");
    }
}

