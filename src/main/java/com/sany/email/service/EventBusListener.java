package com.sany.email.service;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.Subscribe;
import com.sany.email.model.req.HtmlEmailDTO;
import com.sany.email.model.req.ImgEmailDTO;
import com.sany.email.model.req.TextEmailDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;

@Service
@Slf4j
public class EventBusListener {

    /**
     * 引入bean
     */
    @Autowired
    private AsyncEventBus asyncEventBus;

    @Autowired
    private EmailService emailService;

    /**
     * 注册服务类
     */
    @PostConstruct
    public void init(){
        asyncEventBus.register(this);
    }

    /**
     * 线程安全，消费 文本消息
     * @param textEmailDTO
     */
    @AllowConcurrentEvents
    @Subscribe
    public void sendTextMail(TextEmailDTO textEmailDTO){
        emailService.sendTextMail(
                textEmailDTO.getTo(),
                textEmailDTO.getSubject(),
                textEmailDTO.getContent()
        );
    }

    /**
     * 线程安全 消费 html消息
     * @param htmlEmailDTO
     */
    @AllowConcurrentEvents
    @Subscribe
    public void sendHtmlMail(HtmlEmailDTO htmlEmailDTO){
        try {
            emailService.sendHtmlMail(
                    htmlEmailDTO.getTo(),
                    htmlEmailDTO.getHtmlContent(),
                    htmlEmailDTO.getSubject()
            );
        } catch (MessagingException e) {
            //@todo 后续完善,将失败的信息保存到数据库中
            log.error("向收件人" + htmlEmailDTO.getTo() + "发送邮件异常,异常信息为:" + e.getMessage(),e);
        }
    }

    /**
     * 线程安全 消费 图文消息
     * @param imgEmailDTO
     */
    @AllowConcurrentEvents
    @Subscribe
    public void sendImgMail(ImgEmailDTO imgEmailDTO){
        try {
            emailService.sendImgMail(
                    imgEmailDTO.getTo(),
                    imgEmailDTO.getImgContent(),
                    imgEmailDTO.getSubject(),
                    imgEmailDTO.getRscId(),
                    imgEmailDTO.getImgPath()
            );
        } catch (MessagingException e) {
            //@todo 后续完善,将失败的信息保存到数据库中
            log.error("向收件人" + imgEmailDTO.getTo() + "发送邮件异常,异常信息为:" + e.getMessage(),e);
        }
    }
}
