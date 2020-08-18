package com.xworkz.spring.service;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.spring.dao.LoginDAO;
import com.xworkz.spring.dao.ResetPasswordDAO;
import com.xworkz.spring.dto.MailDTO;
import com.xworkz.spring.entity.PersonalInfo;
import com.xworkz.spring.password.EncrptyDecrypt;

@Service("ResetPasswordService")
public class ResetPasswordServiceImpl implements ResetPasswordService {
	private static final Logger logger = Logger.getLogger(ResetPasswordServiceImpl.class);

	@Autowired
	public LoginDAO loginDAO;

	@Autowired
	public ResetPasswordDAO resetPasswordDAO;

	@Autowired
	private MailService mailService;

	@Autowired
	private EncrptyDecrypt encrptyDecrypt;

	StringBuilder str = new StringBuilder("Hey!! \n");

	public ResetPasswordServiceImpl() {
		logger.info("Created \t" + this.getClass().getSimpleName());
	}

	public void validateAndUpdateCountLoginByEmail(String emailId, int countLogin) {
		logger.info("Start: the validateAndUpdateCountLoginByEmail of ResetPasswordServiceImpl" + emailId + "\t"
				+ countLogin);
		try {
			logger.info("inside the validateAndUpdateCountLoginByEmail of ResetPasswordServiceImpl " + emailId + "\t"
					+ countLogin);
			logger.info("check if the login count is greater than zero");
			if (countLogin >= 0) {
				logger.info(
						"valid login count from validateAndUpdateCountLoginByEmail method of ResetPasswordServiceImpl");
				logger.info("validateAndUpdateCountLoginByEmail of resetpasswordDao is invoked");
				resetPasswordDAO.updateCountLoginByEmail(emailId, countLogin);

			} else {
				logger.error(
						"invalid login count from validateAndUpdateCountLoginByEmail method of ResetPasswordServiceImpl"
								+ emailId + "\t" + countLogin);
			}
		} catch (Exception e) {
			logger.error("Exception occurred in validateAndUpdateCountLoginByEmail from ResetPasswordServiceImp"
					+ emailId + "\t" + countLogin + e.getMessage());
		}
		logger.info(" End:validateAndUpdateCountLoginByEmail are completed in ResetPasswordServiceImp" + emailId + "\t"
				+ countLogin);
	}

	public int validateEmailIdAndSendPassword(String emailId) {
		// StringBuilder str = new StringBuilder("Hello!! \n");
		logger.info("The validateAndUpdateCountLoginByEmail of ResetPasswordServiceImpl is started" + emailId);
		try {
			logger.info("inside the validateemailIdAndSendPassword of ResetPasswordServiceImpl " + emailId);
			if (Objects.nonNull(emailId) && emailId != null) {
				logger.info("Data is valid and can fetch password");
				logger.info("validateemailIdAndSendPassword of resetpasswordDao is invoked");
				String randomPasswordFetched = resetPasswordDAO.fetchPasswordByEmail(emailId);
				if (randomPasswordFetched != null) {

					String decryptedPassword = EncrptyDecrypt.decrypt(randomPasswordFetched);
					logger.info("Decrypting the fetched password " + decryptedPassword);

					String from = "Anushree";
					String subject = "Online Registration for Temple ";
					String body = str.append("Anushree here, ").append("\n").append("\n\n")
							.append("Temple Registration forgot password is sent below,").append("\n\n\n")
							.append("Email-Id is: ").append(emailId).append("\n").append("Password is: ")
							.append(decryptedPassword).append("\n\n").toString();

					logger.info("Sending Email and password for registered mail");
					MailDTO mailDTO = new MailDTO(from, emailId, subject, body);

					mailService.sendMail(mailDTO);
					logger.info("Forgot password Mail Sent Successfully");
					return 1;
				} else {
					logger.error(
							"invalid password for validateemailIdAndSendPassword method of ResetPasswordServiceImpl"
									+ randomPasswordFetched);
					return 0;
				}
			} else {
				logger.error(
						"invalid mail for validateemailIdAndSendPassword method of ResetPasswordServiceImpl" + emailId);
				return 0;
			}
		} catch (Exception e) {
			logger.error("Exception in validateemailIdAndSendPassword method of ResetPasswordServiceImpl", e);
		}
		return 0;
	}

	public String reset(String emailId, String password) {
		logger.info("The reset method of ResetPasswordServiceImpl is started" + emailId + "\t" + password);
		boolean valid = false;
		int loginCount = 0;
		try {
			logger.info("inside the reset method of ResetPasswordServiceImpl" + emailId + "\t" + password);
			if (emailId != null) {
				PersonalInfo personalInfoEntity = resetPasswordDAO.fetchEntityByEmailId(emailId);

				int loginCounts = personalInfoEntity.getCountLogin();
				if (personalInfoEntity != null) {
					logger.info("Fetching the mailid and password from personalInfoEntity");
					String mail = personalInfoEntity.getEmailId();
					String password1 = personalInfoEntity.getPassword();
					String decryptedPassword = encrptyDecrypt.decrypt(password1);
					logger.info("decryptedPwd: " + decryptedPassword);
					valid = true;

					if (valid && mail.equals(emailId)) {
						logger.info("registered emailid can login,Thankyou");
						valid = true;

					} else {
						logger.error("emailid doesnot match ,sorry!!!!!!!!!!!!!");
						valid = false;
					}
					if (valid && decryptedPassword.equals(password1)) {
						logger.info("password is valid  can login");
						loginCount = 0;
						resetPasswordDAO.updateCountLoginByEmail(decryptedPassword, loginCount);
						logger.info("loginCount: " + loginCount);
						valid = true;

					} else {
						logger.warn("invalid password");
					}

				} else {
					logger.warn("emailId is null");
				}
			}
		} catch (Exception e) {
			logger.error("Exception in reset method of ResetPasswordServiceImpl", e);
		}
		return null;
	}
}
