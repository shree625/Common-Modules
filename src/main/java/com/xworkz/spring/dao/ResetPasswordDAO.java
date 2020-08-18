package com.xworkz.spring.dao;

import org.springframework.stereotype.Repository;

import com.xworkz.spring.entity.PersonalInfo;

@Repository
public interface ResetPasswordDAO {
	public PersonalInfo fetchEntityByEmailId(String emailId);

	public String fetchPasswordByEmail(String emailId);

	public int fetchNumberOfLoginCountsByEmail(String emailId);

	public void updateCountLoginByEmail(String emailId, int countLogin);

}
