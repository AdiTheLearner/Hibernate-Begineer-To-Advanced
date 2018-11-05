package com.sap.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.sap.pojo.Employee;
import com.sap.util.HibernateUtil;

public class Application {

	public static void main(String[] args) {

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			Employee emp = new Employee();
			emp.setEmployeeId(111);
			emp.setEmployeeName("Aditya");
			emp.setEmployeeSalary(25000.0f);
			transaction = session.beginTransaction();
			Integer cache = (Integer) session.save(emp);
			transaction.commit();
			System.out.println("------------");
			Employee emp2 = (Employee) session.get(Employee.class, cache);
			System.out.println(emp2);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
	}
}
