package com.UserServlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.dao.UserDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		// Validate if username and password are provided
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		
		// Verify user credentials using UserDao
		String uname = UserDao.verifyUser(username, password);

		if (uname != null) {
			pw.println("<h2>User Verfied Successfully. Redirecting to Home...!</h2>");
            res.sendRedirect("UHome.html");
		} else {
			// Invalid credentials, redirect back to login with an error message
			pw.print("Invalid credentials, please try again.");
			res.sendRedirect("Login.html");
		}

		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
