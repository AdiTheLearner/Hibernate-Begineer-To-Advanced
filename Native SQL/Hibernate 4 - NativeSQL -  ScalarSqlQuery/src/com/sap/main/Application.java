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
			SQLQuery query = session.createSQLQuery("select employeeId,employeeName,employeeSalary from Employee");
			List<Object[]> list = query.list();
			for (Object[] obj : list) {
				System.out.println("Employee details");
				System.out.println("-----------------");
				System.out.println("Employee Id:" + obj[0]);
				System.out.println("Employee Name:" + obj[1]);
				System.out.println("Employee Salary:" + obj[2]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
