package com.sap.main;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sap.util.HibernateUtil;

public class ApplicationDelete {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx=null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			Query query=session.createQuery("Delete from Employee");
			tx=session.beginTransaction();
			int rowcount=query.executeUpdate();
			tx.commit();
			System.out.println(rowcount);		
		}
		catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}

	}

}
