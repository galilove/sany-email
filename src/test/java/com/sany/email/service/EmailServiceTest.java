package com.sany.email.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailServiceTest {
    @Resource
    EmailService helloService;
    @Resource
    private TemplateEngine templateEngine;
    @Test
    public void sayHello() {
//        helloService.sayHello();
    }

    @Test
    public void senMail() {
        helloService.sendTextMail("xx9090950@gmail.com","hello","world");
    }
    @Test
    public void senTemplateMail() throws MessagingException {
        Context context = new Context();
        context.setVariable("userName","殿下");
        context.setVariable("code","123456");
        String emailContent = templateEngine.process("email", context);
        helloService.sendHtmlMail("543479003@qq.com",emailContent,"邮件标题");
    }

}