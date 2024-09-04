package com.boeing.ps.innovationvenue.service;


import com.boeing.ps.innovationvenue.bean.EmailMessage;
import com.boeing.ps.innovationvenue.valueobjects.MailResponse;

import freemarker.template.TemplateException;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Map;

@Service
public abstract class EmailNotificationService {


    public abstract void sendEmailNotification(EmailMessage emailMessage, Map<String, Object> model) throws MessagingException, IOException, TemplateException;
    public abstract void sendUserQuery(EmailMessage emailMessage, Map<String, Object> model) throws MessagingException, IOException, TemplateException;
    public abstract void sendCommentEmailNotification(EmailMessage emailMessage, Map<String, Object> model) throws MessagingException, IOException, TemplateException;
}