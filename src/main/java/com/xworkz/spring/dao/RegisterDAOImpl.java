package com.xworkz.spring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.spring.entity.RegisterEntity;

@Component
public class RegisterDAOImpl implements RegisterDAO {

	private static final Logger logger = Logger.getLogger(RegisterDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	public RegisterDAOImpl() {
		logger.info("object created\t" + this.getClass().getSimpleName());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<RegisterEntity> fetchAllByType(String type) {
		Session session = this.sessionFactory.openSession();
		logger.info("inside the fetch method");
		try {
			Query query = session.getNamedQuery("fetchAllByType");
			query.setParameter("typ", type);
			Object object = query.list();
			List<RegisterEntity> list = (List<RegisterEntity>) object;
			return list;

		} catch (HibernateException me) {
			logger.error("Exception in create method" + me.getMessage());
			me.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			logger.info("the session is closed");
			session.close();
		}
		return null;
	}

}
