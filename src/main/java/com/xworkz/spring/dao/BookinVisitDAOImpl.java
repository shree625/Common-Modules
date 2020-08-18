package com.xworkz.spring.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.spring.entity.VisitingDetails;

@Repository("BookingVisitDAO")
public class BookinVisitDAOImpl implements BookingVisitDAO {

	private static final Logger logger = Logger.getLogger(BookinVisitDAOImpl.class);

	private SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public BookinVisitDAOImpl(SessionFactory factory) {
		logger.info("Created \t" + this.getClass().getSimpleName());
		this.factory = factory;
	}

	public void saveVisitngDetails(VisitingDetails visitingDetails, int visitingDetails_id) {
		logger.info(
				"Start: saveVisitngDetails method of BookinVisitDAOImpl" + visitingDetails + "\t" + visitingDetails_id);
		Session session = this.factory.openSession();

		try {
			logger.info("inside the saveVisitngDetails method of BookinVisitDAOImpl" + visitingDetails + "\t"
					+ visitingDetails_id);
			visitingDetails.setId(visitingDetails_id);
			logger.info("transaction started");
			Transaction transaction = session.beginTransaction();
			logger.info("saving the visitingDetails"+visitingDetails);
			session.save(visitingDetails);
			transaction.commit();
			logger.info("Transaction is committed");

		} catch (HibernateException he) {
			logger.error("Exception in saveVisitngDetails method of BookinVisitDAOImpl" + visitingDetails + "\t"
					+ visitingDetails_id, he);
		} finally {
			logger.info("Closing session");
			session.close();
		}
	}

}
