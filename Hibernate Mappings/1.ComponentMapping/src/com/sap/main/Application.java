package com.sap.main;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

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
			Employee emp = (Employee) session.get(com.sap.pojo.Employee.class, 111);
			System.out.println("Employee Details");
			System.out.println("-----------------");
			System.out.println("Employee Id" + emp.getEmployeeId());
			System.out.println("Employee Name" + emp.getEmployeeName());
			System.out.println("Employee Salary" + emp.getEmployeeSalary());
			System.out.println("Account Details");
			System.out.println("-----------------");
			System.out.println("Account Id" + emp.getAccount().getAccountNo());
			System.out.println("Account Name" + emp.getAccount().getAccountName());
			System.out.println("Account Balance" + emp.getAccount().getAccountBalance());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}