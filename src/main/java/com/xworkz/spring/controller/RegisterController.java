package com.xworkz.spring.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.spring.dto.MailDTO;
import com.xworkz.spring.dto.RegisterDTO;
import com.xworkz.spring.dto.RegisterFormDTO;
import com.xworkz.spring.service.BookingVisitService;
import com.xworkz.spring.service.LoginService;
import com.xworkz.spring.service.MailService;
import com.xworkz.spring.service.RegisterFormService;
import com.xworkz.spring.service.RegisterService;
import com.xworkz.spring.service.ResetPasswordService;

@Component
@RequestMapping("/")
public class RegisterController {

	private static final Logger logger = Logger.getLogger(RegisterController.class);

	@Autowired
	private RegisterService registerService;
	@Autowired
	private RegisterFormService registerFormService;
	@Autowired
	private MailService mailService;
	@Autowired
	public LoginService loginService;
	@Autowired
	public ResetPasswordService resetPasswordService;
	@Autowired
	private BookingVisitService bookingvisitService;

	private List<RegisterDTO> seList;
	private List<RegisterDTO> prList;
	private List<RegisterDTO> idList;
	private List<RegisterDTO> ptList;

	public RegisterController() {
		logger.info("Controller object created");
	}

	@PostConstruct
	public void init() {
		logger.info("Inside the init method");
		seList = registerService.validateAndfetchAllByTypes("SE");
		prList = registerService.validateAndfetchAllByTypes("PR");
		idList = registerService.validateAndfetchAllByTypes("id");
		ptList = registerService.validateAndfetchAllByTypes("PT");

	}

	@RequestMapping(value = "/landing.odc", method = RequestMethod.GET)
	public String onSubmit(Model model) {
		logger.info("inside the  on submit  method");

		try {
			logger.info("inside the on submit method");
			logger.info("Special Entrance :" + seList);
			logger.info("prasad List" + prList);
			logger.info("Identity List" + idList);
			logger.info("pooja List" + ptList);

			model.addAttribute("specialList", seList);
			model.addAttribute("prasadList", prList);
			model.addAttribute("identityList", idList);
			model.addAttribute("poojaList", ptList);

			return "Register";
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/register.odc", method = RequestMethod.POST)
	public String registerPage(RegisterFormDTO registerDto, Model model) {
		try {
			logger.info(registerDto);

			int isValid = registerFormService.validateAndFillDetails(registerDto);
			if (isValid == 0) {
				logger.info("Personal Information are:" + registerDto);
				model.addAttribute("name:" + registerDto.getName());
				model.addAttribute("mobilenumber:" + registerDto.getMobileNumber());
				model.addAttribute("address:" + registerDto.getAddress());
				model.addAttribute("age:" + registerDto.getAge());
				model.addAttribute("emailid:" + registerDto.getEmailId());
				model.addAttribute("state:" + registerDto.getState());
				logger.info("Visiting Details are:" + registerDto);
				model.addAttribute("date:" + registerDto.getDate());
				model.addAttribute("entrance:" + registerDto.getSelist());
				model.addAttribute("pooja:" + registerDto.getPtList());
				model.addAttribute("idCard:" + registerDto.getIdCard());
				model.addAttribute("idNumber:" + registerDto.getIdNumber());
				model.addAttribute("prasada:" + registerDto.getPrasada());
				model.addAttribute("noofpersons:" + registerDto.getNumberOfPersons());
				// boolean status = mailService.sendMail(mailDto);
				return "Success";
			} else {
				logger.info("invalid data");
				model.addAttribute("Error", "Please check which field is not valid and enter valid data");
				return "Register";
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	@RequestMapping(value = "/request.doc", method = RequestMethod.POST)
	public String getVisitDetails(@RequestParam String email, Model model) {
		logger.info("inside the getVisitDetails of controller class");
		logger.info("registerDto object created");
		RegisterFormDTO registerDto = new RegisterFormDTO();
		logger.info("invoked the validateVisitDetailsByEmail from service class");
		registerDto = registerFormService.validateVisitDetailsByEmail(email);
		logger.warn("check whether the registerDto is not null");
		if (registerDto != null) {
			logger.info("set the emailId property from regidter dto class");
			registerDto.setEmailId(email);
			logger.info("invoking of sendMail from mailservice class");
			MailDTO mailDto = new MailDTO();
			mailService.sendMail(mailDto);
			model.addAttribute("The registration was successful" + email);
		} else {
			logger.error("The registration was unsuccessful" + email);
		}
		return "Request";
	}

	@RequestMapping(value = "/login.odc", method = RequestMethod.POST)
	public String onLogin(String emailId, String password, Model model) {
		try {
			logger.info("Invoked login method with emailId and password in Controller Class");

			int isCheck = loginService.validateAndupdatePersonalInfoDetails(emailId, password);
			if (isCheck == 1) {
				System.out.println("The given mailId:" + emailId);
				System.out.println("The generated password is:" + password);
				return "SuccessfulLogin";
			} else {
				return "Register";
			}
		} catch (Exception e) {
			logger.error("Exception occurred in controller class of login method" + e);
		}
		return "Success";
	}

	@RequestMapping(value = "/generatepassword.odc", method = RequestMethod.POST)
	public String randomPasswordGeneration(String emailId, Model model) {
		try {
			logger.info("Invoked login page with emailId in generatingPasswordPage of controller class");
			int isCheck = loginService.validateRandomPasswordGenerationAndEmailId(emailId);
			if (isCheck == 1) {
				logger.info("Validated email" + emailId);
				return "SuccessfulLogin";
			} else {
				return "Register";
			}
		} catch (Exception e) {
			logger.error("Exception occurred in Controller class of generatingPasswordPage method", e);
		}
		return "Success";
	}

	@RequestMapping(value = "/forgotpassword.odc", method = RequestMethod.POST)
	public String forgotPassword(String emailId, Model model) {
		try {
			logger.info("Invoked forgot password page with emailId,later redirect to login.jsp");

			int isCheck = resetPasswordService.validateEmailIdAndSendPassword(emailId);
			if (isCheck == 1) {
				logger.info("Validated email" + emailId);
				return "Login";
			} else {
				return "Register";
			}
		} catch (Exception e) {
			logger.error("Exception occurred in Controller class of forgotPassword method", e);
		}
		return "Login";
	}

	@RequestMapping(value = "/onBooking.doc", method = RequestMethod.POST)
	public String onVisitAgain(RegisterFormDTO registerFormDto, Model model) {
		try {
			logger.info("Invoked onVisitAgain method with registerFormDto of Controller Class");
			logger.info("invoking the bookingVisit method from BookingvisitService");
			String isCheck = bookingvisitService.bookingVisit(registerFormDto);
			if (isCheck != null) {
				logger.info("validated registerFormDto of controller class" + registerFormDto);
				model.addAttribute("message", isCheck);
				return "BookingVisit";
			} else {
				return "Register";
			}
		} catch (Exception e) {
			logger.error("Exception occurred in Controller class of onVisitAgain method", e);
		}
		return "BookingVisit";

	}

}
