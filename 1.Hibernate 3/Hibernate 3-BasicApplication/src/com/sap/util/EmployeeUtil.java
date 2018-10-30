package com.sap.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeUtil {
	private static SessionFactory sessionFactory;
	static {
		try {
			Configuration cfg=new Configuration();
			cfg.configure("/com/sap/configuration/hibernate.cfg.xml");
			sessionFactory=cfg.buildSessionFactory();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;	
	}
	
	public static void clean(SessionFactory sf,Session s) {
		sf.close();
		s.close();
	}
}
