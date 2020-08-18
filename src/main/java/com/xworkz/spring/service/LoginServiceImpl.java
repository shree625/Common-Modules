package com.xworkz.spring.service;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.spring.dao.LoginDAO;
import com.xworkz.spring.dao.RegisterFormDAO;
import com.xworkz.spring.dto.MailDTO;
import com.xworkz.spring.dto.RegisterFormDTO;
import com.xworkz.spring.entity.PersonalInfo;
import com.xworkz.spring.entity.VisitingDetails;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {

	private static final Logger logger = Logger.getLogger(LoginServiceImpl.class);

	@Autowired
	public LoginDAO loginDao;

	@Autowired
	private MailService mailService;

	@Autowired
	private RegisterFormDAO registerFormDao;

	public StringBuilder str = new StringBuilder();

	PersonalInfo personalInfoEntity = new PersonalInfo();
	VisitingDetails visitingDetailsEntity = new VisitingDetails();
	RegisterFormDTO registerDto = new RegisterFormDTO();

	public LoginServiceImpl() {
		logger.info("Created \t" + this.getClass().getSimpleName());
	}

	public int validateAndupdatePersonalInfoDetails(String emailId, String password) {
		logger.info("inside the validateAndupdatePersonalInfoDetails of LoginServiceimpl " + emailId + "\t" + password);
		try {
			if (Objects.nonNull(emailId) && emailId != null && Objects.nonNull(password) && password != null) {
				logger.info("given mailId and password are valid");

				logger.info("fetchPersonDetailsByEmailIdAndPassword of loginDao");
				personalInfoEntity = loginDao.fetchPersonDetailsByEmailIdAndPassword(emailId, password);
				logger.info("fetchVisitingDetailsByEmailIdAndPassword of loginDao");
				visitingDetailsEntity = loginDao.fetchVisitingDetailsByEmailIdAndPassword(emailId, password);

				logger.info("getting email and password from database and comparing with sent email and password");
				String fetchedEmailpersonalInfoEntity = personalInfoEntity.getEmailId();
				String fetchedPassword = personalInfoEntity.getPassword();

				if (emailId.equalsIgnoreCase(fetchedEmailpersonalInfoEntity)
						&& password.equalsIgnoreCase(fetchedPassword)) {
					logger.info("EmailId and Password matched successfully");

					logger.info("Sending Email for Login successfully");
					MailDTO mailDTO = new MailDTO("Anushree", emailId, "LoginSuccessful ",
							"Here is your password for given mailId");
					System.out.println("EmailId:" + emailId);
					System.out.println("Generated password is:" + password);

					logger.info("invoking the sendMail method from mailService ");
					mailService.sendMail(mailDTO);
					logger.info("Login Mail Sent Successfully");
				}
				return 1;
			} else {
				logger.error("invalid details of email id and password");
				return 0;
			}
		} catch (Exception e) {
			logger.error("Exception occurred in validateAndupdatePersonalInfoDetails from LoginServiceImpl"
					+ e.getMessage());
		}
		logger.info(" validateAndupdatePersonalInfoDetails are completed in LoginServiceImpl" + emailId);
		return 0;
	}

	public int validateRandomPasswordGenerationAndEmailId(String emailId) {
		logger.info("inside the validateRandomPasswordGenerationAndEmailId of LoginServiceImpl" + emailId);
		try {
			if (Objects.nonNull(emailId) && emailId != null) {
				logger.info("Validated EmailId");
				Long emailCount = registerFormDao.fetchCountByEmail(emailId);
				if (emailCount == 1) {
					logger.info("Data is valid and can generate password");
					String generatedpassword = loginDao.randomPasswordGeneration();
					logger.info("*******************" + generatedpassword);
					logger.info("password generated of 8 digit alphanumeric");
					logger.info("Updating PersonalInfo Details " + personalInfoEntity);
					logger.info("Updating visitingInfo Details " + visitingDetailsEntity);
					int isUpdated = loginDao.updatePersonalInfoDetails(emailId, generatedpassword);
					if (isUpdated == 1) {
						System.out.println("Password updated for given email-id:" + emailId);

						System.out.println(
								"Sending Email and password for registered mail" + emailId + "\n" + generatedpassword);
						MailDTO mailDTO = new MailDTO("Anushree", emailId, "Online Registration for Temple ",
								str.append("Anushree").append("\n").append("\n\n").append("Password is sent below,")
										.append("\n\n\n").append("Email-Id is: ").append(emailId).append("\n")
										.append("Password is: ").append(generatedpassword).append("\n\n").toString());
						mailService.sendMail(mailDTO);
						logger.info("successfully logged in");
						return 1;
					} else {
						logger.warn("invalid password for the email-id" + generatedpassword);
						return 0;
					}
				} else {
					logger.error("invalid mailId" + emailId);
					return 0;
				}
			} else {
				logger.info("Email-Id provided in invalid");
				return 0;
			}
		} catch (Exception e) {
			logger.error("Exception in validateEmailIdAndGeneratePassword ", e);
		}
		return 0;
	}

}
