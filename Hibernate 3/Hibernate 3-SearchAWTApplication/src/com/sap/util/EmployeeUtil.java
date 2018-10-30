package com.sap.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class EmployeeUtil {
	private static SessionFactory sessionFactory;
	static {
		try {
			Configuration cfg=new Configuration();
			cfg.configure("/com/sap/configuration/hibernate.cfg.xml");
			sessionFactory=cfg.buildSessionFactory(); 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
	
	public static void shutDown(SessionFactory sfg,Session s) {
		sfg.close();
		s.close();
	}
}
