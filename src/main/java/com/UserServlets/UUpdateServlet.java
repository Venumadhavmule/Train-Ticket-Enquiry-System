package com.UserServlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.dao.UserDao;
import com.model.UserBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "uProfileUp", urlPatterns = { "/uProfileUp" })
public class UUpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		
		
		String fname = req.getParameter("firstname");
		String lname = req.getParameter("lastname");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String uname = req.getParameter("username");
		String pswd = req.getParameter("password");
		UserBean user = new UserBean(fname, lname, phone, email, uname, pswd);
		boolean result =  UserDao.updateUser(user);
		if (!result) {
            pw.println("<h2>User profile not updated! Please try again with a own username...</h2>");
            resp.setHeader("Refresh", "2; URL=UUpdate.jsp");
        } else {
            pw.println("<h2>User Profile data updated successfully! you will see updates in next time login...</h2>");
            resp.setHeader("Refresh", "2; URL=UProfile.jsp");
        }

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
