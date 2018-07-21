package com.fanw.socialapp.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@RestController
@RequestMapping("/mail")
public class MailController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private JavaMailSender mailSender;


    @RequestMapping(value = "/simple",method = RequestMethod.POST)
    public void sendMail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("fanw9611@163.com");
        message.setTo("fanw96@qq.com");
        message.setSubject("Test");
        message.setText("哈哈哈哈哈哈哈");
        this.mailSender.send(message);
    }

    @RequestMapping(value = "/find",method = RequestMethod.POST)
    public void sendTemplateMail(){
        Context context = new Context();
        context.setVariable("id","006");
        String emailContent = templateEngine.process("emailTemplate",context);
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom("fanw9611@163.com");
            helper.setTo("lmiegn@qq.com");
            helper.setSubject("李蒙小腿粗");
            helper.setText(emailContent,true);
            mailSender.send(message);
            logger.info("success");
        } catch (MessagingException e) {
            logger.error("fail",e);
        }
    }

}
