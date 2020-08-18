package com.xworkz.spring.dao;

import org.springframework.stereotype.Repository;

import com.xworkz.spring.entity.PersonalInfo;
import com.xworkz.spring.entity.VisitingDetails;

@Repository
public interface RegisterFormDAO {

	public void fillPersonalInfo(PersonalInfo personalInfoEntity);

	public void fillVisitingDetails(VisitingDetails visitingDetailsEntity);

	public Long fetchCountByEmail(String email);

	public Long fetchCountByNumber(String number);

	public VisitingDetails fetchVisitDetailsByEmail(String emailId);

}
