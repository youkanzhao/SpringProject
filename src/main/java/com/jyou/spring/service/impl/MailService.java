package com.jyou.spring.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.jyou.spring.exception.SPException;
import com.jyou.spring.service.IMailService;

@Service
public class MailService implements IMailService {
	
	private static final Logger logger = LoggerFactory.getLogger(MailService.class);
	
	@Autowired
	private ApplicationContext context;

	@Autowired
	private JavaMailSender mailSender;

	public void sendTextMail(String from, String to, String subject, String content) throws SPException {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom(from);
		mail.setTo(to);
		mail.setSubject(subject);
		mail.setText(content);
		logger.info(content);
		mailSender.send(mail);
	}

}
