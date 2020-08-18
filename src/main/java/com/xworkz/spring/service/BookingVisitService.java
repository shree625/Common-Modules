package com.xworkz.spring.service;

import org.springframework.stereotype.Service;

import com.xworkz.spring.dto.RegisterFormDTO;

@Service
public interface BookingVisitService {
	public String bookingVisit(RegisterFormDTO registerFormDTO);
}
