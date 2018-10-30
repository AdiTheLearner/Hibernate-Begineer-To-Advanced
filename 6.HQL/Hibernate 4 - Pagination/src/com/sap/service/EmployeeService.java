package com.sap.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sap.pojo.Employee;
import com.sap.util.HibernateUtil;

public class EmployeeService {
	List<Employee> list;
	SessionFactory sessionFactory;
	Session session;
	Query query;
	
	public EmployeeService() {
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session=sessionFactory.openSession();
			query = session.createQuery("from Employee");
			query.setMaxResults(3);
		}
		catch(Exception e) {
		e.printStackTrace();
		}
	}
	public List<Employee> getEmployees(int label){
		try {
			if(label == 1) {
				query.setFirstResult(0);
			}
			if(label == 2) {
				query.setFirstResult(3);
			}
			if(label == 3) {
				query.setFirstResult(6);
			}
			list = query.list();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
