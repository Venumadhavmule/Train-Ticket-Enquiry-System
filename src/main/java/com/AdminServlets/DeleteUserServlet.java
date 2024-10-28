package com.AdminServlets;


import java.io.IOException;
import java.io.PrintWriter;

import com.dao.UserDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "deleteUser", urlPatterns = { "/deleteUser" })
public class DeleteUserServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		String username = request.getParameter("username");
		boolean result = UserDao.deleteUser(username);
		if (!result) {
            pw.println("<h2>User not found! Please try again with a exist username.</h2>");
            response.setHeader("Refresh", "2; URL=ADeleteUser.html");
        } else {
            pw.println("<h2>User deleted successfully! Redirecting to Home Page...</h2>");
            response.setHeader("Refresh", "2; URL=AHome.html");
        }
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
