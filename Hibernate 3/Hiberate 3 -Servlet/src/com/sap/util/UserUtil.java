package com.sap.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserUtil {
	private static SessionFactory sessionFactory;
	static {
		try {
			Configuration cfg = new Configuration();
			cfg.configure("/com/sap/configuration/hibernate.cfg.xml");
			sessionFactory = cfg.buildSessionFactory();
			System.out.println(sessionFactory);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
