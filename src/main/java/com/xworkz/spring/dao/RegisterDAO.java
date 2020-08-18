package com.xworkz.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xworkz.spring.entity.RegisterEntity;

@Repository
public interface RegisterDAO {

	public List<RegisterEntity> fetchAllByType(String type);
}
