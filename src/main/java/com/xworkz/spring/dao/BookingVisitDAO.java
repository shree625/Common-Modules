package com.xworkz.spring.dao;

import org.springframework.stereotype.Repository;

import com.xworkz.spring.entity.VisitingDetails;

@Repository
public interface BookingVisitDAO {
	public void saveVisitngDetails(VisitingDetails visitingDetails, int visitingDetails_id);

}