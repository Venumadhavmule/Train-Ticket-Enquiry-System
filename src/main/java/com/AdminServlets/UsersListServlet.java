package com.AdminServlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.dao.UserDao;
import com.model.UserBean;

/**
 * Servlet implementation class UsersListServlet
 */
@WebServlet(name = "usersList", urlPatterns = { "/usersList" })
public class UsersListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<UserBean> allUsers = UserDao.getAllUsers();
		System.out.print(allUsers);
		request.setAttribute("users", allUsers);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AViewAllUsers.jsp");
		dispatcher.forward(request, response);
	}
}
