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
import com.sap.pojo.Student;
import com.sap.util.HibernateUtil;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			
			Student student= new Student();
			student.setAccountNo(111);
			student.setAccountName("adtya");
			student.setAccountType("SAVINGS");
			student.setStudentId(123);
			student.setStudentBranch("DTS");
			student.setStudentMarks(90);
			
			Employee employee = new Employee();
			employee.setAccountNo(222);
			employee.setAccountName("karthik");
			employee.setAccountType("SAVINGS");
			employee.setEmployeeId(21);
			employee.setEmployeeName("JHAVER");
			employee.setEmployeeSalary(10000.0f);
			
			Transaction tc = session.beginTransaction();
			session.save(student);
			session.save(employee);
			tc.commit();
			
			System.out.println("Account data inserted");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}