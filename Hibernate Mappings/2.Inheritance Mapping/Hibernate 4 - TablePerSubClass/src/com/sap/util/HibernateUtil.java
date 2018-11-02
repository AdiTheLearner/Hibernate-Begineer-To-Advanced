package com.sap.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			// loads configuration and mappings
			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(com.sap.pojo.Payment.class);
			configuration.addAnnotatedClass(com.sap.pojo.CreditCard.class);
			configuration.addAnnotatedClass(com.sap.pojo.DebitCard.class);
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
			builder = builder.applySettings(configuration.getProperties());
			StandardServiceRegistry registry = builder.build();

			// builds a session factory from the service registry
			sessionFactory = configuration.buildSessionFactory(registry);
		}

		return sessionFactory;
	}
}
