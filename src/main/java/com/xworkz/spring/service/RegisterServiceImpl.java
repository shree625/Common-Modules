package com.xworkz.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.spring.dto.RegisterDTO;
import com.xworkz.spring.entity.RegisterEntity;
import com.xworkz.spring.dao.RegisterDAO;

@Service("RegisterService")
public class RegisterServiceImpl implements RegisterService {

	private static final Logger logger = Logger.getLogger(RegisterServiceImpl.class);

	@Autowired
	private RegisterDAO registerDAO;

	public RegisterServiceImpl() {
		logger.info("RegisterServiceImpl object created");
	}

	@Override
	public List<RegisterDTO> validateAndfetchAllByTypes(String type) {
		logger.info("the types that are fetched are below:");
		try {
			logger.info("inside the fetched mathod");
			List<RegisterEntity> registerEntityList = registerDAO.fetchAllByType(type);
			List<RegisterDTO> list = new ArrayList<RegisterDTO>();
			// check if the entity is null and the type is not empty
			if (registerEntityList != null && !type.isEmpty()) {
				logger.info("list is found" + registerEntityList.size());
				for (RegisterEntity entity : registerEntityList) {
					RegisterDTO registerDto = new RegisterDTO();
					// conversion of dto to entity
					BeanUtils.copyProperties(entity,registerDto);
					logger.info(registerDto);
					list.add(registerDto);
				}
				return list;
			} else {
				logger.error("invalid list");
				return null;
			}
		} catch (Exception me) {
			logger.error(me.getMessage(), me);
			me.printStackTrace();
		}
		return null;
	}

}
