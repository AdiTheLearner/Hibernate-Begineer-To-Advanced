package com.sap.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sap.service.UserService;
import com.sap.util.UserUtil;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		UserUtil.getSessionFactory();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName=request.getParameter("userName");
		String password = request.getParameter("password");
		System.out.println(userName);
		UserService userService=new UserService();
		String status=userService.checkLogin(userName,password);
		RequestDispatcher requestDispatcher =null;
		if(status.equals("success")) {
			requestDispatcher=request.getRequestDispatcher("/Success.html");
			requestDispatcher.forward(request, response);
		}
		else {
			requestDispatcher=request.getRequestDispatcher("/Failure.html");
			requestDispatcher.forward(request, response);
		}
		
	}

}
