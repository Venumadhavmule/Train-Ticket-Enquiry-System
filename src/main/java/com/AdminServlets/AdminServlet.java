package com.AdminServlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.dao.AdminDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(name = "admin", urlPatterns = { "/admin" })
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
	
		
		String adUsername = req.getParameter("username");
		String adPassword = req.getParameter("password");
		
		if (adUsername == null || adPassword == null) {
			pw.print("Please provide both username and password.");
			return;
		}
		
		String uname = AdminDao.verifyAdmin(adUsername, adPassword);
		
		if(uname!=null) {
			HttpSession session= req.getSession();
			session.setAttribute("username", uname);
			res.sendRedirect("AHome.jsp");
		}else {
			res.sendRedirect("Admin.html");
		}
		
		pw.close();
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
