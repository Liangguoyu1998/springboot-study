package com.liang;

import org.apache.logging.log4j.message.SimpleMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class SpringbootMail12ApplicationTests {
    @Autowired
    JavaMailSenderImpl mailSender;
    @Test
    void contextLoads() {
        //一个简单的邮件
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("小梁，你好啊！");
        simpleMailMessage.setText("谢谢你邀请我参加生日聚会！");
        simpleMailMessage.setTo("liang199805@gmail.com");
        simpleMailMessage.setFrom("3083614562@qq.com");
        mailSender.send(simpleMailMessage);
    }
    @Test
    void test() throws MessagingException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String format = dateFormat.format(new Date());
        System.out.println(format+":发送邮件");
        //一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject("小梁，你好啊！");
        helper.setText("<p style='color:red'>我是梁国宇！</p>",true);
        helper.setTo("liang199805@gmail.com");
        helper.setFrom("3083614562@qq.com");
        //附件
        helper.addAttachment("1.jpg",new File("C:\\Users\\Lenovo\\Pictures\\1.png"));
        mailSender.send(mimeMessage);
    }

}
