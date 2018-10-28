package com.sap.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static StandardServiceRegistry registry;
	
	static {
			Configuration config = new Configuration();
			config.configure();
			config.addAnnotatedClass(com.sap.pojo.Employee.class);
			registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			sessionFactory = config.buildSessionFactory(registry);			
		}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
