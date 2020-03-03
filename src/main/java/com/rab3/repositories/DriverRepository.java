package com.rab3.repositories;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rab3.entities.DriverEntity;

public class DriverRepository {

	private SessionFactory sessionFactory;
	
	public void save(DriverEntity driver) {
		Session session =  sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(driver);
		session.getTransaction().commit();
		session.close();
		
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
