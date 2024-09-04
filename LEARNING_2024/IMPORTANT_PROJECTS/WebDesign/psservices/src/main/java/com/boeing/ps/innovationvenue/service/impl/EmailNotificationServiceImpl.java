package com.boeing.ps.innovationvenue.service.impl;


import com.boeing.ps.innovationvenue.bean.EmailMessage;

import com.boeing.ps.innovationvenue.entity.UserProfile;
import com.boeing.ps.innovationvenue.entity.UserQueries;
import com.boeing.ps.innovationvenue.repository.UserProfileRepository;
import com.boeing.ps.innovationvenue.repository.UserQueriesRepository;
import com.boeing.ps.innovationvenue.service.EmailNotificationService;

import com.boeing.ps.innovationvenue.valueobjects.MailResponse;
import com.boeing.ps.innovationvenue.valueobjects.UserProfileResponse;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.RequestBody;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailNotificationServiceImpl extends EmailNotificationService {

	private static final Logger logger = LoggerFactory.getLogger(EmailNotificationServiceImpl.class);
	
	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private Configuration configuration;
	
	@Autowired
	UserQueriesRepository userQueryRepo;
	
	@Autowired
	UserProfileRepository userProfileRepo;

    /**To Send New Idea Submission Email Notification To Admin
     *
     * @param emailMessage - Email Notification Template
     * @param model - Message Body Template
     */
	public void sendEmailNotification(EmailMessage emailMessage, Map<String,Object> model)  {
		logger.info("Inside sendEmailNotification");
        try {
			MimeMessage message=mailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message,MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
			Template template=configuration.getTemplate("IdeaWorkFlowTemplate.ftl");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(template,model);
			helper.setFrom(emailMessage.getFromAddress());
			helper.setText(html,true);
			String[] emailList= emailMessage.getToAddress().stream().toArray(String[]::new);
			helper.setTo(emailList);
			helper.setSubject(emailMessage.getSubject());
			mailSender.send(message);
			logger.info("Email Notification has been sent out");
		} catch (MessagingException | IOException | TemplateException e) {
			logger.info("Error occured while sending an email " + e.getMessage());
		}
		catch (Exception e) {
			logger.info("Error occured while sending an email " + e.getMessage());
		}
	}

    /** To send User Queries to Core Team
     *
     * @param emailMessage - Email Notification Template
     * @param model - Message Body Template
     */
    public void sendUserQuery(EmailMessage emailMessage, Map<String,Object> model)  {
        logger.info("Inside sendUserQuery");
        try {
            MimeMessage message=mailSender.createMimeMessage();
            MimeMessageHelper helper=new MimeMessageHelper(message,MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
            Template template=configuration.getTemplate("UserFeedback.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template,model);
            helper.setFrom(emailMessage.getFromAddress());
            helper.setText(html,true);
            String[] emailList= emailMessage.getToAddress().stream().toArray(String[]::new);
            helper.setTo(emailList);
            helper.setCc(emailMessage.getCcAddress());
			helper.setSubject(emailMessage.getSubject());
            mailSender.send(message);
            logger.info("User Query Sent Successfully");
            /*** Adding entry to User Queries table ***/
            UserProfile userProfile= userProfileRepo.findByBemsId(emailMessage.getBemsId());
            UserQueries userQuery = new UserQueries(userProfile,emailMessage.getSubject(),
                    emailMessage.getMessageBody(),new Date());
            userQueryRepo.save(userQuery);

        } catch (MessagingException | IOException | TemplateException e) {

            logger.info("User Query Failed to send");
        }
        catch (Exception e) {
            logger.info("User Query Failed to send");
        }
    }

	/**To Send Email Notification for New Comments on Idea
	 *
	 * @param emailMessage - Email Notification Template
	 * @param model - Message Body Template
	 */
	public void sendCommentEmailNotification(EmailMessage emailMessage, Map<String,Object> model)  {
		logger.info("Inside sendCommentEmailNotification");
		try {
			MimeMessage message=mailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message,MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
			Template template=configuration.getTemplate("CommentEmailTemplate.ftl");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(template,model);
			helper.setFrom(emailMessage.getFromAddress());
			helper.setText(html,true);
			String[] emailList= emailMessage.getToAddress().stream().toArray(String[]::new);
			helper.setTo(emailList);
			helper.setSubject(emailMessage.getSubject());
			mailSender.send(message);
			logger.info("Email Notification for Comment has been sent out");
		} catch (MessagingException | IOException | TemplateException e) {
			logger.info("Error occured while sending an email " + e.getMessage());
		}
		catch (Exception e) {
			logger.info("Error occured while sending an email " + e.getMessage());
		}
	}
}
