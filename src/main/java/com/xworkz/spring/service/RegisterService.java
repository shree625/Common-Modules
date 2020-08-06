package com.xworkz.spring.service;

import java.util.List;

import com.xworkz.spring.dto.RegisterDTO;


public interface RegisterService {

	public List<RegisterDTO> validateAndfetchAllByTypes(String type);

	
}
