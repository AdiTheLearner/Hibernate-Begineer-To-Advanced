package com.sap.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sap.pojo.Employee;
import com.sap.service.EmployeeService;

/**
 * Servlet implementation class DisplayServlet
 */
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			PrintWriter	 out = response.getWriter();
			int label = Integer.parseInt(request.getParameter("button"));
			EmployeeService empService=new EmployeeService();
			List<Employee> list = empService.getEmployees(label);
			out.println("<html><head>");
			out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'>");
			out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js'>");
			out.println("</script>");
			out.println("</head>");
			out.println("<body>");
			out.println("<div class='container-fluid'> <div class='table-responsive'> <table class='table table-bordered table-striped table-hover table-dark'>");
		    out.println("<thead><tr> <th> Employee Number</th><th> Employee Name</th><th> Employee Salary </th></tr></thead><tbody>"); 
		    for(Employee emp:list) {
		    out.println("<tr class='table-success'><td>"+emp.getEmployeeId()+"</td><td>"+emp.getEmployeeName()+"</td><td>"+emp.getEmployeeId()+"</td></tr>");
		    }
		    out.println("</tbody></table></div></div>");
		    out.println("</table></body></html");
			RequestDispatcher rd  = request.getRequestDispatcher("/Home.html");
			rd.include(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
