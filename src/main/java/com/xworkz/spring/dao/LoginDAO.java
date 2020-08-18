package com.xworkz.spring.dao;

import org.springframework.stereotype.Repository;

import com.xworkz.spring.entity.PersonalInfo;
import com.xworkz.spring.entity.VisitingDetails;

@Repository
public interface LoginDAO {
	public int updatePersonalInfoDetails(String emailId, String password);

	public PersonalInfo fetchPersonDetailsByEmailIdAndPassword(String emailId, String password);

	public VisitingDetails fetchVisitingDetailsByEmailIdAndPassword(String emailId, String password);

	public String randomPasswordGeneration();
	
}
