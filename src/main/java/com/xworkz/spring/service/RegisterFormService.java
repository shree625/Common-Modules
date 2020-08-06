package com.xworkz.spring.service;

import org.springframework.stereotype.Service;

import com.xworkz.spring.dto.RegisterFormDTO;

@Service
public interface RegisterFormService {

	public int validateAndFillDetails(RegisterFormDTO registrationDto);
	public RegisterFormDTO validateVisitDetailsByEmail(String email);
	
	
}
