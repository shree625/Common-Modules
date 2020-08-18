package com.xworkz.spring.service;

import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.spring.dao.BookingVisitDAO;
import com.xworkz.spring.dao.ResetPasswordDAO;
import com.xworkz.spring.dto.RegisterFormDTO;
import com.xworkz.spring.entity.PersonalInfo;
import com.xworkz.spring.entity.VisitingDetails;

@Service("BookingVisitService")
public class BookingVisitServiceImpl implements BookingVisitService {
	private static final Logger logger = Logger.getLogger(BookingVisitServiceImpl.class);

	@Autowired
	private BookingVisitDAO bookingVisitDAO;
	@Autowired
	private ResetPasswordDAO resetPasswordDAO ;
	@Autowired
	private HttpSession httpSession;

	public String bookingVisit(RegisterFormDTO registerFormDTO) {
		logger.info("start the bookingVisit method of BookingVisitServiceImpl " +registerFormDTO);
		try {
			logger.info("inside the bookingVisit method of BookingVisitServiceImpl " +registerFormDTO);
			logger.info("getting the session attribute of emailid from httpSession");
			String emailId = (String) httpSession.getAttribute("emailId");
			System.out.println("EmailId:" +emailId);
			logger.warn("Check and confirm the emailid is not null");
			if (Objects.nonNull(emailId)) {
				logger.info("invoking of fetchEntityByEmailId from ResetPasswordDAO"+emailId);
				PersonalInfo personalInfoEntity =resetPasswordDAO.fetchEntityByEmailId(emailId);
				logger.info("getting the id from PersonalInfo");
				int id = personalInfoEntity.getId();
				System.out.println("VisitingDetails id is: " + id);
				logger.info("VisitingDetails entity object is created");
				VisitingDetails visitingDetails = new VisitingDetails();
				logger.info("setting the one to many mapping");
				visitingDetails.setPersonalInfo(personalInfoEntity);
				logger.info("Copying the details of registerFormDTO into visitingDetails");
				BeanUtils.copyProperties(registerFormDTO, visitingDetails);
				System.out.println(visitingDetails);
				logger.info("invoking of saveVisitngDetails from BookingVisitDAO");
				bookingVisitDAO.saveVisitngDetails(visitingDetails, id);
				return "Success";
			} else {
				logger.error("invalid details of email id");
				return "Register ";
			}

		} catch (Exception e) {
			logger.error("Exception occurred in bookingVisit method of BookingVisitServiceImpl "
					+ e.getMessage());
		}
		return null;
	}
	}


