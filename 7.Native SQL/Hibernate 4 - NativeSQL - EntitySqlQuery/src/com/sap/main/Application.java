package com.sap.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.sap.pojo.Employee;
import com.sap.util.HibernateUtil;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			Query query = session.getNamedQuery("HQL_GET_ALL_SALARY");
			query.setFloat(0, 100000);
			query.setFloat("max_Sal", 3000);
			List<Employee> list = query.list();
			for (Employee emp : list) {
				System.out.println("Employee details");
				System.out.println("-----------------");
				System.out.println("Employee Id:" + emp.getEmployeeId());
				System.out.println("Employee Id:" + emp.getEmployeeName());
				System.out.println("Employee Id:" + emp.getEmployeeSalary());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
