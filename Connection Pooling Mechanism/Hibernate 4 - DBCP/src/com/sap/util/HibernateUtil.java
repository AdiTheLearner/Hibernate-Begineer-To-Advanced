package com.sap.util;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class HibernateUtil {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
				Map<String, Object> settings = new HashMap<>();
				settings.put(Environment.DATASOURCE, getDataSource());
				settings.put(Environment.SHOW_SQL, "true");
				registryBuilder.applySettings(settings);
				registry = registryBuilder.build();
				org.hibernate.metamodel.MetadataSources sources = new org.hibernate.metamodel.MetadataSources(registry)
						.addAnnotatedClass(com.sap.pojo.Employee.class);
				org.hibernate.metamodel.Metadata metadata = sources.getMetadataBuilder().build();
				sessionFactory = metadata.getSessionFactoryBuilder().build();
			} catch (Exception e) {
				if (registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}

	public static void shutdown() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

	private static DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3307/db2");
		dataSource.setUsername("root");
		dataSource.setPassword("root");

		// Connection pooling properties
		dataSource.setInitialSize(0);
		dataSource.setMaxIdle(5);
		dataSource.setMaxTotal(5);
		dataSource.setMinIdle(0);

		return dataSource;
	}

}
