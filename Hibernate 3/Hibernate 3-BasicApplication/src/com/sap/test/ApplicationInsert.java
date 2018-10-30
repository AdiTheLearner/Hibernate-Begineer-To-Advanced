package com.sap.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sap.pojo.Employee;

public class ApplicationInsert {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		SessionFactory sf=null;
		Session s=null;
		try
		{
			Configuration cfg=new Configuration();
			cfg.configure("/com/sap/configuration/hibernate.cfg.xml");
			sf=cfg.buildSessionFactory();
			s=sf.openSession();
			Transaction t=s.beginTransaction();
			Employee emp=new Employee();
			emp.setEmployeeId(333);
			//emp.setEmployeeName("Varun");
			//emp.setEmployeeSalary(100000.0f);
			//s.saveOrUpdate(emp);
			s.delete(emp);
			t.commit();
			//System.out.println("Inserted/Updated  Succesfully");
			System.out.println("Deleted Succesffuly");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			s.close();
			sf.close();
		}

	}

}
