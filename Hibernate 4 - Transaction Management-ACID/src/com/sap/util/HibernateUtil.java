package com.sap.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory oracleSessionFactory;
	private static SessionFactory mysqlSessionFactory;

	public static SessionFactory getOracleSessionFactory() {
		if (oracleSessionFactory == null) {
			Configuration oracle_cfg=new Configuration();
			oracle_cfg.configure("com/sap/configuration/oracle_cfg.xml");
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
			builder = builder.applySettings(oracle_cfg.getProperties());
			StandardServiceRegistry registry = builder.build();
			oracleSessionFactory = oracle_cfg.buildSessionFactory(registry);
		}
		return oracleSessionFactory;
	}
	
	public static SessionFactory getMysqlSessionFactory() {
		if (mysqlSessionFactory == null) {
			Configuration mysql_cfg=new Configuration();
			mysql_cfg.configure("com/sap/configuration/mysql_cfg.xml");
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
			builder = builder.applySettings(mysql_cfg.getProperties());
			StandardServiceRegistry registry = builder.build();
			mysqlSessionFactory = mysql_cfg.buildSessionFactory(registry);
		}
		return mysqlSessionFactory;
	}
}
