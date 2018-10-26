package com.sap.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sap.pojo.Employee;
import com.sap.util.HibernateUtil;

public class Application {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.getTransaction();
			transaction.begin();
			Employee employee = new Employee();
			employee.setEmployeeId(111);
			employee.setEmployeeName("Aditya");
			employee.setEmployeeSalary(25000.0f);
			session.save(employee);
			transaction.commit();
			System.out.print("Data Inserted");
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}
}
