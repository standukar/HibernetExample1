package com.rab3.repositories;


import java.util.List;


import org.hibernate.Query;
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

	public DriverEntity getById(Integer id) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		DriverEntity dr = (DriverEntity) session.get(DriverEntity.class, id);
		
		session.getTransaction().commit();
		session.close();
		
		return dr;
	}

	

	public DriverEntity getByAddress(String address) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query q = session.createQuery("select dr from DriverEntity dr where dr.address =:address");
		q.setParameter("address", address);
		
		List<DriverEntity> drivers = q.list();
		
		session.getTransaction().commit();
		session.close();
		
		if(drivers.size() > 0){
			return drivers.get(0);
		}
		
		return null;
	}

	public DriverEntity getByState(String state) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query q = session.createQuery("selsct dr from DriverEntity dr.state =:state");
		q.setParameter("state", state);
		
		List<DriverEntity> drivers = q.list();
		session.getTransaction().commit();
		session.close();
		
		if(drivers.size() >0 ) {
			return drivers.get(0);
			
		}
		return null;
	}
	

	public void update(DriverEntity de) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.merge(de);
		session.getTransaction().commit();
		session.close();
		
	}
	
}
