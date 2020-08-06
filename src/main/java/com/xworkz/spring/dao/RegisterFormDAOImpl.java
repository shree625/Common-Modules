package com.xworkz.spring.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.xworkz.spring.entity.PersonalInfo;
import com.xworkz.spring.entity.VisitingDetails;

@Repository("RegisterFormDAO ")
public class RegisterFormDAOImpl implements RegisterFormDAO {

	private static final Logger logger = Logger.getLogger(RegisterFormDAOImpl.class);
	private SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public RegisterFormDAOImpl(SessionFactory factory) {
		logger.info("Created \t" + this.getClass().getSimpleName());
		this.factory = factory;
	}

	@Override
	public void fillPersonalInfo(PersonalInfo personalInfoEntity) {
		Session session = this.factory.openSession();
		try {
			logger.info("inside the fillPersonalInfo method of RegisterFormDAOImpl" + personalInfoEntity);
			logger.info("transaction started");
			Transaction transaction = session.beginTransaction();
			logger.info("Saving " + personalInfoEntity);
			session.save(personalInfoEntity);
			logger.info(personalInfoEntity + "details are saved");
			session.flush();
			transaction.commit();
			logger.info("Transaction is committed");

		} catch (Exception e) {
			logger.error("Exception occurred in fillPersonalInfo method of register form dao impl" + e.getMessage());
			e.printStackTrace();
		} finally {
			logger.info("Closing session");
			session.close();
		}
	}

	@Override
	public void fillVisitingDetails(VisitingDetails visitingDetailsEntity) {
		Session session = this.factory.openSession();
		try {
			logger.info("inside the fillVisitingDetails method of RegisterFormDAOImpl" + visitingDetailsEntity);
			logger.info("transaction started");
			Transaction transaction = session.beginTransaction();
			logger.info("Saving " + visitingDetailsEntity);
			session.save(visitingDetailsEntity);
			logger.info(visitingDetailsEntity + "details are saved");
			session.flush();
			transaction.commit();
			logger.info("Transaction is committed");

		} catch (Exception e) {
			logger.error("Exception occurred in visitingDetailsEntity method of register form dao impl" + e.getMessage());
			e.printStackTrace();
		} finally {
			logger.info("Closing session");
			session.close();
		}

	}

	@Override
	public Long fetchCountByEmail(String email) {
		Session session = this.factory.openSession();
		try {
			logger.info(" inside the fetchCountByEmail of daoimpl");
			Query query = session.getNamedQuery("fetchCountByEmail");
			query.setParameter("emailId", email);
			Object result = query.uniqueResult();
			Long countByPrice = (Long) result;
			return countByPrice;

		} catch (HibernateException he) {
			logger.error(he.getMessage(), he);
		} finally {
			logger.info("Closing session");
			session.close();
		}
		return null;
	}

	@Override
	public Long fetchCountByNumber(String number) {
		Session session = this.factory.openSession();
		try {
			logger.info("inside the fetchCountByNumber register form dao impl");

			Query query = session.getNamedQuery("fetchCountByNumber");
			query.setParameter("mobileNumber", number);
			Object result = query.uniqueResult();
			Long countByPrice = (Long) result;
			return countByPrice;

		} catch (HibernateException he) {
			logger.error(he.getMessage(), he);
		} finally {
			logger.info("Session closed");
			session.close();
		}
		return null;
	}

	@Override
	public VisitingDetails fetchVisitDetailsByEmail(String email) {
		Session session = this.factory.openSession();
		logger.info(" inside the fetch VisitDetails By Email of daoimpl");
		try {
			logger.info(" fetch VisitDetails By Email of daoimpl is started");
			Query query = session.getNamedQuery("fetchVisitDetailsByEmail");
			query.setParameter("email", email);
			VisitingDetails entity = (VisitingDetails) query.uniqueResult();
			return entity;
		} catch (HibernateException he) {
			logger.error(he.getMessage(), he);
		} finally {
			logger.info("Session closed");
			session.close();
		}
		return null;
	}

}
