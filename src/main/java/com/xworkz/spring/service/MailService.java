package com.xworkz.spring.service;

import org.springframework.stereotype.Service;

import com.xworkz.spring.dto.MailDTO;

@Service
public interface MailService {

	public boolean sendMail(MailDTO mailDTO);
}
