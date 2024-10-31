package com.UserServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.dao.StationDao;
import com.dao.UserDao;
import com.model.StationBean;
import com.model.UserBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "login", urlPatterns = { "/login" })
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
		List<StationBean> stationsList = StationDao.getAllStations();

		if (uname != null) {
			// pw.println("<h2>User Verfied Successfully. Redirecting to Home...!</h2>");
			HttpSession session = req.getSession();
			session.setAttribute("username", uname);
			
			UserBean user = UserDao.getUserByUserName(uname);
			session.setAttribute("aUser", user);
			session.setAttribute("allStations", stationsList);
			res.sendRedirect("UHome.jsp");
		} else {
//			Invalid credentials, redirect back to login with an error message
//         pw.print("Invalid credentials, please try again.");
			res.sendRedirect("Login.html");
		}

		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
