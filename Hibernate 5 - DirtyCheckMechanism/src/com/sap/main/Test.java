package com.sap.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.sap.pojo.Employee;
import com.sap.util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
			Session session = null;
			try {
				session = HibernateUtil.getSessionFactory().openSession();
				Employee employee = session.get(Employee.class, 111);
				if(employee != null){
					session.beginTransaction();
					employee.setEmployeeSalary(4000.0f);
					employee.setEmployeeName("Chimme");
					session.update(employee);
					session.getTransaction().commit();
					//employee.setEmployeeName("cingge");
				}else{
					System.out.println("Employeedoesn't exist with provided Id..");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(session != null){
					session.close();
				}
			}
	}

}
