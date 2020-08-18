package com.xworkz.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xworkz.spring.dto.RegisterDTO;

@Service
public interface RegisterService {

	public List<RegisterDTO> validateAndfetchAllByTypes(String type);

	
}
