package com.sap.main;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.sap.pojo.CompoundKey;
import com.sap.pojo.Product;

public class Application {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(com.sap.pojo.Product.class);
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			CompoundKey ck = new CompoundKey(333, "ONEPLUS6T");
			Product product = new Product();
			product.setCompoundKey(ck);
			product.setProductPrice(60000.0f);
			session.save(product);
			tx.commit();
			System.out.println("Product Data inserted");
			product = (Product) session.get(com.sap.pojo.Product.class, ck);
			if (product == null) {
				System.out.println("Sorry product doesnot exists");
			} else {
				System.out.println("Product Details");
				System.out.println("------------------");
				System.out.println("Product Name" + ck.getProductName());
				System.out.println("Product Id" + ck.getProductId());
				System.out.println("Product Price" + product.getProductPrice());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			sessionFactory.close();
			session.close();
		}

	}

}
