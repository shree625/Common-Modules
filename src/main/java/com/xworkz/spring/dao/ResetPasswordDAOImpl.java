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

@Repository("ResetPassword")
public class ResetPasswordDAOImpl implements ResetPasswordDAO {

	private static final Logger logger = Logger.getLogger(ResetPasswordDAOImpl.class);

	private SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public ResetPasswordDAOImpl(SessionFactory factory) {
		logger.info("Created \t" + this.getClass().getSimpleName());
		this.factory = factory;
	}

	public int fetchNumberOfLoginCountsByEmail(String emailId) {
		logger.info("Start: fetchNumberOfLoginCountsByEmail  ResetPasswordDAOImpl" + emailId);
		Session session = this.factory.openSession();
		int logincounts = 10;
		try {
			logger.info("inside the fetchNumberOfLoginCountsByEmail method of ResetPasswordDAOImpl method" + emailId);
			logger.info("transaction started");
			Transaction transaction = session.beginTransaction();
			Query query = session.getNamedQuery("fetchNumberOfLoginCountsByEmail");
			query.setParameter("emailId", emailId);
			logger.info(" PROCESS STARTED");
			logincounts = (Integer) query.uniqueResult();
			transaction.commit();
			logger.info("Transaction is committed");
		} catch (HibernateException he) {
			logger.error("Exception in fetchNumberOfLoginCountsByEmail of ResetPasswordDAOImpl method ", he);
		} finally {
			logger.info("Closing session");
			session.close();
		}
		return logincounts;
	}

	public void updateCountLoginByEmail(String emailId, int countLogin) {
		logger.info("Start:updateCountLoginByEmail  ResetPasswordDAOImpl" + emailId + "\t" + countLogin);
		Session session = this.factory.openSession();
		try {
			logger.info(
					"inside the updateCountLoginByEmail method of ResetPasswordDAOImpl" + emailId + "\t" + countLogin);
			logger.info("transaction started");
			Transaction transaction = session.beginTransaction();
			logger.info(" CREATED FROM DTO USING NAMEDQUERY ");
			Query query = session.getNamedQuery("updateCountLoginByEmail");
			query.setParameter("emailId", emailId);
			query.setParameter("loginCounts", countLogin);
			logger.info(" PROCESS STARTED");
			int updatedRows = query.executeUpdate();
			transaction.commit();
			logger.info("Transaction is committed");
			if (updatedRows > 0) {
				logger.info("login counts are update from email");
			} else {
				logger.error("error occurred in updateCountLoginByEmail ResetPasswordDAOImpl method");
			}
		} catch (HibernateException he) {
			logger.error("Exception in updateCountLoginByEmail of ResetPasswordDAOImpl method ", he);
		} finally {
			logger.info("Closing session");
			session.close();
		}

	}

	public String fetchPasswordByEmail(String emailId) {
		Session session = this.factory.openSession();
		try {
			logger.info("inside the fetchPasswordByEmail of ResetPasswordDAOImpl" + emailId);
			logger.info("CREATE FROM DTO USING NAMEDQUERY");
			Query query = session.getNamedQuery("fetchPasswordByEmail");
			System.out.println("Password QUERY---->" + query);
			query.setParameter("emailId", emailId);
			logger.info("PROCESS STARTED");
			Object result = query.uniqueResult();
			String entity = (String) result;
			return entity;

		} catch (HibernateException he) {
			logger.error("Exception occurred in fetchPasswordByEmail of ResetPasswordDAOImpl" + he.getMessage());
		} finally {
			System.out.println("Session closed");
			session.close();
		}
		System.out.println("fetchPasswordByEmail is completed of ResetPasswordDAOImpl" + emailId);
		return null;
	}

	public PersonalInfo fetchEntityByEmailId(String emailId) {
		Session session = this.factory.openSession();
		try {
			logger.info("inside the fetchEntityByEmailId of ResetPasswordDAOImpl" + emailId);
			logger.info("CREATE FROM DTO USING NAMEDQUERY");
			Query query = session.getNamedQuery("fetchEntityByEmailId");
			query.setParameter("emailId", emailId);
			PersonalInfo personalInfoEntity = (PersonalInfo) query.uniqueResult();
			logger.info("PersonalInfoEntity: " + personalInfoEntity);
			return personalInfoEntity;
		} catch (HibernateException he) {
			logger.error("Exception occurred in fetchEntityByEmailId of ResetPasswordDAOImpl" + he.getMessage());
		} finally {
			System.out.println("Session closed");
			session.close();
		}
		return null;
	}

}
