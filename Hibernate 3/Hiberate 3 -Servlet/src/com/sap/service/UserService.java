package com.sap.service;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.sap.pojo.User;
import com.sap.util.UserUtil;

public class UserService {
	String status = "";
	public String checkLogin(String username, String password) {
		try {
			SessionFactory sessionFactory = UserUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			User user = (User)session.get("com.sap.pojo.User",username);
			if (user == null) {
				status = "failure";
			} else {
				if (user.getPassword().equals(password)) {
					status = "success";
				} else {
					status = "failure";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;

	}
}
