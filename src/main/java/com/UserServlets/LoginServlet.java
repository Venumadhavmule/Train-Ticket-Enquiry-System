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

		if (username == null || password == null) {
			pw.print("Please provide both username and password.");
			return;
		}

		// Verify user credentials using UserDao
		String uname = UserDao.verifyUser(username, password);

		if (uname != null) {
			// User verified, redirect to a welcome page or dashboard
			res.sendRedirect("response.jsp");
		} else {
			// Invalid credentials, redirect back to login with an error message
			pw.print("Invalid credentials, please try again.");
			req.getRequestDispatcher("ULogin.html").include(req, res);
		}

		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
