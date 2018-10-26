package com.sap.main;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.sap.pojo.Employee;
import com.sap.util.HibernateUtil;

public class ApplicationRetrieve {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();

			Query query = session.createQuery("from Employee");
			Query unique = session.createQuery("from Employee where employeeId=111");

			// Approach-1
			List<Employee> list = query.list();
			System.out.println("Employee No \t Employename \t Employee Salary");
			System.out.println("-----------------------------------------------");
			for (Employee e : list) {
				System.out.print(e.getEmployeeId() + "	\t");
				System.out.print(e.getEmployeeName() + "	\t");
				System.out.println(e.getEmployeeSalary() + "	\t");
			}
			System.out.println();
			// Apporach-2
			Iterator<Employee> it = query.iterate();
			System.out.println("Employee No \t Employename \t Employee Salary");
			System.out.println("-----------------------------------------------");
			while (it.hasNext()) {
				Employee emp = (Employee) it.next();
				System.out.print(emp.getEmployeeId() + "	\t");
				System.out.print(emp.getEmployeeName() + "	\t");
				System.out.println(emp.getEmployeeSalary() + "	\t");

			}
			System.out.println();
			// Apporach-3 Data in Forward Direction
			ScrollableResults results = query.scroll();
			System.out.println("Employee No \t Employename \t Employee Salary");
			System.out.println("-----------------------------------------------");
			while (results.next()) {
				Object[] obj = results.get();
				for (Object o : obj) {
					Employee e1 = (Employee) o;
					System.out.print(e1.getEmployeeId() + "	\t");
					System.out.print(e1.getEmployeeName() + "	\t");
					System.out.println(e1.getEmployeeSalary() + "	\t");

				}
			}
			System.out.println();
			System.out.println();
			// Approach -4 Data in Backward Direction
			while (results.previous()) {
				Object[] obj = results.get();
				for (Object o : obj) {
					Employee e1 = (Employee) o;
					System.out.print(e1.getEmployeeId() + "	\t");
					System.out.print(e1.getEmployeeName() + "	\t");
					System.out.println(e1.getEmployeeSalary() + "	\t");

				}
			}

			System.out.println();
			System.out.println();
			
			// Approach-5
			Object obj = unique.uniqueResult();
			Employee e = (Employee) obj;
			System.out.print(e.getEmployeeId() + "	\t");
			System.out.print(e.getEmployeeName() + "	\t");
			System.out.println(e.getEmployeeSalary() + "	\t");

			// SELECT CLAUSE
			Query query1 = session.createQuery("select e.employeeId,e.employeeName from Employee e where e.employeeName IS NOT NULL");
			List<Object[]> list1 = query1.list();
			System.out.println("Employee No\t Employename\t");
			System.out.println("---------------------------");
			for (Object[] obj1 : list1) {
				for (Object o : obj1) {
					System.out.print(o + "\t");
				}
				System.out.println();
			}

			//ORDER BY CLAUSE
			Query query2 = session.createQuery(
					"select e.employeeId,e.employeeName from Employee e where e.employeeSalary>=1000 order by e.employeeName desc");
			List<Object[]> list2 = query2.list();
			System.out.println("Employee No\t Employename\t");
			System.out.println("---------------------------");
			for (Object[] obj1 : list2) {
				for (Object o : obj1) {
					System.out.print(o + "\t");
				}
				System.out.println();
			}

			//GROUP BY 
			Query query3 = session.createQuery("select sum(e.employeeSalary) from Employee e group by e.employeeName");
			List<Double> list3 = query3.list();
			for (Double val : list3) {
				System.out.println(val);
			}
			
			//GROUP BY + HAVING
			Query query4 = session.createQuery("select count(e.employeeSalary) from Employee e group by e.employeeSalary having e.employeeSalary>500");
			List<Long> list4 = query4.list();
			for (Long val : list4) {
				System.out.println(val);
			}
			
			//BETWEEN 
			Query query5 = session.createQuery("select employeeName from Employee where employeeSalary BETWEEN 2000 and 2000000");
			List<String> list5 = query5.list();
			for (String val : list5) {
				System.out.println(val);
			}
			

			System.out.println("Employee Data retrieved");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Employee Data Insertion failure");
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
