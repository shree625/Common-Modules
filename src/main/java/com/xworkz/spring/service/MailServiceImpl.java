package com.xworkz.spring.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.xworkz.spring.dto.MailDTO;

@Service("MailService")
public class MailServiceImpl implements MailService {

	private static final Logger logger = Logger.getLogger(MailServiceImpl.class);

	@Autowired
	public MailSender mailSender;

	public MailServiceImpl() {
		logger.info("MailServiceImpl object created");
	}

	public boolean sendMail(MailDTO mailDTO) {
		try {
			logger.info("Inside sendMail method");
			SimpleMailMessage simpleMessage = new SimpleMailMessage();
			// set the properties from maildto
			simpleMessage.setTo(mailDTO.getTo());
			simpleMessage.setFrom(mailDTO.getFrom());
			simpleMessage.setSubject(mailDTO.getSubject());
			simpleMessage.setText(mailDTO.getBody());
			// calling the mailservice method
			mailSender.send(simpleMessage);
			logger.info("Mail sent successfully");
		} catch (MailException me) {
			logger.error(me.getMessage(), me);
		}
		return false;
	}

}
