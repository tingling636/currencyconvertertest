package com.test.currencyconverter.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.currencyconverter.model.ConvertRate;

@Repository
public class ConverterDaoImpl implements ConverterDao {
	
	@Autowired
    private SessionFactory sessionFactory;
	private Session session;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = this.sessionFactory.getCurrentSession();
		}catch(HibernateException e) {
			session = sessionFactory.openSession();
		}
	}
	
	public boolean saveRate(ConvertRate rate) {
		boolean status = false;
		
		try {
			Transaction tx = session.beginTransaction();
			
			session.save(rate);
			tx.commit();
			status = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}

	public boolean updateRate(ConvertRate rate) {
		boolean status = false;
		
		try {
			Transaction tx = session.beginTransaction();
			
			session.update(rate);
			tx.commit();
			status = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}

	public boolean deleteRate(ConvertRate rate) {
		boolean status = false;
		
		try {
			Transaction tx = session.beginTransaction();
			
			//delete book item
			session.delete(rate);
			tx.commit();
			status = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}

	public List<ConvertRate> get() {
		List<ConvertRate> rs = null;
		
		try {
			Query query = session.createQuery("FROM rate");
			rs = query.list();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ConvertRate get(String base, String ex) {
		ConvertRate rs = null;
		
		try {
			Query query = session.createQuery("FROM rate WHERE baseCountry='"+base+
					"' AND exCountry='"+ex+"'");
			rs = (ConvertRate)query.uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return rs;
	}

}
