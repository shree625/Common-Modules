package com.xworkz.spring.service;

import org.springframework.stereotype.Service;

@Service
public interface ResetPasswordService {
	public int validateEmailIdAndSendPassword(String emailId);

	public void validateAndUpdateCountLoginByEmail(String emailId, int countLogin);
	
	public String reset(String emailId, String password);
}
