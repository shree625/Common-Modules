package com.xworkz.spring.dto;

import org.apache.log4j.Logger;

public class MailDTO{

	private static final Logger logger = Logger.getLogger(MailDTO.class);
	private String to;
	private String from;
	private String subject;
	private String body;

	public MailDTO() {
		logger.info("created\t" + this.getClass().getSimpleName());
	}

	public MailDTO(String to, String from, String subject, String body) {
		super();
		this.to = to;
		this.from = from;
		this.subject = subject;
		this.body = body;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "MailDTO [to=" + to + ", from=" + from + ", subject=" + subject + ", body=" + body + "]";
	}

}