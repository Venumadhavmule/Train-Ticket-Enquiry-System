package com.AdminServlets;

import java.io.IOException;
import java.io.PrintWriter;
import com.dao.UserDao;
import com.model.UserBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "updateUser", urlPatterns = { "/updateUser" })
public class UpdateUserServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String uname = request.getParameter("username");
		String pswd = request.getParameter("password");

		UserBean user = new UserBean(fname, lname, phone, email, uname, pswd);
		boolean result = UserDao.updateUser(user);
		if (!result) {
            pw.println("<h2>User details not updated Please provide required filed data</h2>");
            response.setHeader("Refresh", "2; URL=AUpdateUser.html");
        } else {
            pw.println("<h2>User registration completed successfully! Redirecting to Home page...</h2>");
            response.setHeader("Refresh", "2; URL=AHome.html");
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
