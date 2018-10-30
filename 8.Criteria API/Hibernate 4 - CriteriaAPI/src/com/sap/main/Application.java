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
			Criteria c = session.createCriteria(com.sap.pojo.Employee.class);

			// Adding conditions
			Criterion c1 = Restrictions.gt("employeeSalary", 1000.0f);
			Criterion c2 = Restrictions.lt("employeeSalary", 1000000.0f);
			c.add(c1);
			c.add(c2);

			// Adding column name
			ProjectionList p1 = Projections.projectionList();
			p1.add(Projections.property("employeeId"));
			p1.add(Projections.property("employeeName"));
			p1.add(Projections.property("employeeSalary"));
			c.setProjection(p1);

			// Orderby
			Order order = Order.desc("employeeName");
			c.addOrder(order);

			List<Object[]> obj = c.list();
			System.out.println("Employee No Employename EmployeSalary");
			System.out.println("--------------------------------------");
			for (Object[] obj1 : obj) {
				for (Object o : obj1) {
					System.out.print(o + "\t\t");
				}
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}