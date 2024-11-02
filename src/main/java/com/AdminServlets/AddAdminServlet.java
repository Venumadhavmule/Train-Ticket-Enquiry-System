package com.AdminServlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.dao.AdminDao;
import com.model.AdminBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "addAdmin", urlPatterns = { "/addAdmin" })
public class AddAdminServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		AdminBean admin = new AdminBean(name,phone,email,username,password);
		boolean result = AdminDao.saveAdmin(admin);
		if(result) {
			pw.print("<h2>Admin added successfully. you are redirecting to Home page..!</h2>");
			response.setHeader("Refresh", "2; URL=AHome.jsp");
		}else {
			pw.print("<h2>Admin not added.. Try with unique username!..</h2>");
			response.setHeader("Refresh", "2; URL=AAddAdmin.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
