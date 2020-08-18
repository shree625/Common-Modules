package com.xworkz.spring.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.spring.entity.PersonalInfo;
import com.xworkz.spring.entity.VisitingDetails;

@Repository("LoginDAO")
public class LoginDAOImpl implements LoginDAO {

	private static final Logger logger = Logger.getLogger(LoginDAOImpl.class);

	private SessionFactory factory;

	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public LoginDAOImpl(SessionFactory factory) {
		logger.info("Created \t" + this.getClass().getSimpleName());
		this.factory = factory;
	}

	public int updatePersonalInfoDetails(String emailId, String password) {
		logger.info("Start: updatePersonalInfoDetails " + emailId);
		Session session = this.factory.openSession();
		try {
			logger.info("inside the updatePersonalInfoDetails method of LoginFormDAOImpl" + emailId + "\t" + password);
			logger.info("transaction started");
			Transaction transaction = session.beginTransaction();
			logger.info(" CREATED FROM DTO USING NAMEDQUERY ");
			Query query = session.getNamedQuery("updatePersonalInfoDetails");
			query.setParameter("emailId", emailId);
			query.setParameter("password", password);
			logger.info(" PROCESS STARTED");
			int updatedRows = query.executeUpdate();
			transaction.commit();
			logger.info("Transaction is committed");
			return updatedRows;

		} catch (HibernateException he) {
			logger.error("Exception in updatePersonalInfoDetails ", he);
		} finally {
			logger.info("Closing session");
			session.close();
		}
		return 0;
	}

	public PersonalInfo fetchPersonDetailsByEmailIdAndPassword(String emailId, String password) {
		Session session = this.factory.openSession();
		try {
			logger.info(
					"inside the fetchPersonDetailsByEmailIdAndPassword of LoginDAOImpl" + emailId + "\t" + password);

			logger.info("CREATE FROM DTO USING NAMEDQUERY");
			Query query = session.getNamedQuery("fetchPersonDetailsByEmailIdAndPassword");
			logger.info("Personal info QUERY---->" + query);
			query.setParameter("emailId", emailId);
			query.setParameter("password", password);
			logger.info("PROCESS is started");
			Object result = query.uniqueResult();
			PersonalInfo personalInfoEntity = (PersonalInfo) result;
			return personalInfoEntity;

		} catch (HibernateException he) {
			logger.error(
					"Exception occurred in fetchPersonDetailsByEmailIdAndPassword of LoginDAOImpl" + he.getMessage());
		} finally {
			logger.info("Session closed");
			session.close();
		}
		return null;
	}

	public VisitingDetails fetchVisitingDetailsByEmailIdAndPassword(String emailId, String password) {
		Session session = this.factory.openSession();
		try {
			logger.info(
					"inside the fetchVisitingDetailsByEmailIdAndPassword of LoginDAOImpl" + emailId + "\t" + password);

			logger.info("CREATE FROM DTO USING NAMEDQUERY");
			Query query = session.getNamedQuery("fetchVisitingDetailsByEmailIdAndPassword");
			logger.info("Personal info QUERY---->" + query);
			query.setParameter("emailId", emailId);
			query.setParameter("password", password);
			logger.info("PROCESS STARTED");
			Object result = query.uniqueResult();
			VisitingDetails visitingDetailsEntity = (VisitingDetails) result;
			return visitingDetailsEntity;

		} catch (HibernateException he) {
			logger.error(
					"Exception occurred in fetchVisitingDetailsByEmailIdAndPassword of LoginDAOImpl" + he.getMessage());
		} finally {
			System.out.println("Session closed");
			session.close();
		}
		System.out.println("fetchVisitingDetailsByEmailIdAndPassword is completed" + emailId + "\t" + password);
		return null;
	}

	public String randomPasswordGeneration() {
		StringBuilder builder = new StringBuilder();
		int length = 8;
		while (length-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}

}
