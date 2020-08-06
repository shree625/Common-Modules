package com.xworkz.spring.service;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.mail.MailSender;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.xworkz.spring.dao.RegisterFormDAO;
import com.xworkz.spring.dto.MailDTO;
import com.xworkz.spring.dto.RegisterFormDTO;
import com.xworkz.spring.entity.PersonalInfo;
import com.xworkz.spring.entity.VisitingDetails;

@Service("RegisterFormService")
public class RegisterFormServiceImpl implements RegisterFormService {

	@Autowired
	private RegisterFormDAO registerFormDao;

	@Autowired
	private MailService mailService;

	private static final Logger logger = Logger.getLogger(RegisterFormServiceImpl.class);

	public RegisterFormServiceImpl() {
		logger.info("Created \t" + this.getClass().getSimpleName());
	}

	@Override
	public int validateAndFillDetails(RegisterFormDTO registrationDto) {

		logger.info("validateAndFillDetails of RegisterFormServiceImpl started " + registrationDto);
		int isValid = 0;
		try {
			if (Objects.nonNull(registrationDto)) {
				logger.info("Starting to validate fields..");

				String name = registrationDto.getName();
				if (name != null && !name.isEmpty()) {
					logger.info("Name is valid");
					isValid = 0;
				} else {
					logger.warn("Name is not valid");
					isValid = 1;
				}
				String mobileNumber = registrationDto.getMobileNumber();
				if (mobileNumber != null && !mobileNumber.isEmpty()) {
					logger.info("mobileNumber is valid");
					isValid = 0;
				} else {
					logger.warn("mobileNumber is not valid");
					isValid = 1;
				}
				String address = registrationDto.getAddress();
				if (isValid == 0 && address != null && !address.isEmpty()) {
					logger.info("address is valid");
					isValid = 0;
				} else {
					logger.warn("address is not valid");
					isValid = 1;
				}
				String age = registrationDto.getAge();
				if (isValid == 0 && age != null && !age.isEmpty()) {
					logger.info("age is valid");
					isValid = 0;
				} else {
					logger.warn("age is not valid");
					isValid = 1;
				}
				String emailId = registrationDto.getEmailId();
				if (isValid == 0 && emailId != null && !emailId.isEmpty()) {
					logger.info("Email Id is valid");
					isValid = 0;
				} else {
					logger.warn("Email Id is not valid");
					isValid = 1;
				}
				String state = registrationDto.getState();
				if (isValid == 0 && state != null && !state.isEmpty()) {
					logger.info("State is valid");
					isValid = 0;
				} else {
					logger.warn("State is not valid");
					isValid = 1;
				}
			}
			if (isValid == 0) {
				logger.info("invoking of fetchCountByEmail and fetchCountByNumber from RegisterFormDaoImpl");
				Long emailCount = registerFormDao.fetchCountByEmail(registrationDto.getEmailId());
				Long phoneCount = registerFormDao.fetchCountByNumber(registrationDto.getMobileNumber());
				// validation of email and phonenumber
				if (emailCount == 0 && phoneCount == 0) {
					logger.info("PersonalInfo and VisitingDetails objects are created");
					PersonalInfo personalInfoEntity = new PersonalInfo();
					VisitingDetails visitingDetailsEntity = new VisitingDetails();
					logger.info("The hibernate one to one mapping is created");
					personalInfoEntity.setVisitingDetails(visitingDetailsEntity);

					logger.info("Copying data from personal info entity to registration dto");
					BeanUtils.copyProperties(registrationDto, personalInfoEntity);
					logger.info("Copying data from visiting Details Entity to  registration  dto");
					BeanUtils.copyProperties(registrationDto, visitingDetailsEntity);

					logger.info("printing the personal information details from entity" + personalInfoEntity);
					System.out.println(personalInfoEntity);
					registerFormDao.fillPersonalInfo(personalInfoEntity);
					logger.info("printing the visiting information details from entity" + visitingDetailsEntity);
					System.out.println(visitingDetailsEntity);
					// mail dto object is created
					MailDTO mailDTO = new MailDTO(registrationDto.getEmailId(), "Anusree", "Registration Confirmed",
							"Wear a MASK and please follow SOCIAL DISTANCE," + "\n"
									+ " Registration is done successfully done");
					mailService.sendMail(mailDTO);

				}
				return isValid;
			} else {
				logger.error("mailId and number already exists");
			}
		} catch (Exception e) {
			logger.error("Exception occurred in validateAndFillDetails " + e.getMessage());
			e.printStackTrace();
		}
		return isValid;
	}

	@Override
	public RegisterFormDTO validateVisitDetailsByEmail(String email) {
		logger.info("RegisterFormDTO,VisitingDetails objects are created");
		RegisterFormDTO registerFormDto = new RegisterFormDTO();
		VisitingDetails visitingDetailsEntity = new VisitingDetails();
		try {
			logger.info("validating of email is done in RegisterFormServiceimpl");
			if (Objects.nonNull(email) && !email.isEmpty()) {
				logger.info("Validation successful and the Email Id is valid");
				logger.info("fetchVisitDetailsByEmail from registerFormDao is invoked");
				visitingDetailsEntity = registerFormDao.fetchVisitDetailsByEmail(email);
				logger.info("visitingDetailsEntity checking is done and its not equal to null");
				if (visitingDetailsEntity != null) {
					logger.info("copying the visitingentity details into registerdto");
					BeanUtils.copyProperties(visitingDetailsEntity, registerFormDto);
				} else {
					logger.warn("please check the visiting entity should not be null before copied");
					// registerFormDto = null;
				}
			} else {
				logger.error("Email Id is not valid");
				// registerFormDto = null;
			}
		} catch (Exception e) {
			logger.error(
					"Exception occurred in validateVisitDetailsByEmail from RegisterFormServiceImpl" + e.getMessage());
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return registerFormDto;
	}

}
