package com.xworkz.spring.service;

import org.springframework.stereotype.Service;

@Service
public interface LoginService {
	public int validateAndupdatePersonalInfoDetails(String emailId, String password);

	public int validateRandomPasswordGenerationAndEmailId(String emailId);

}
