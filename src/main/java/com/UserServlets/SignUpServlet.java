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

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");

        String fname = req.getParameter("firstname");
        String lname = req.getParameter("lastname");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String uname = req.getParameter("username");
        String pswd = req.getParameter("password");
        UserBean user = new UserBean(fname, lname, phone, email, uname, pswd);
        int count = UserDao.saveUser(user);
        
        if (count == 0) {
            pw.println("<h2>User not registered! Please try again with a unique username.</h2>");
            res.setHeader("Refresh", "2; URL=USignup.html");
        } else {
            pw.println("<h2>User registration completed successfully! Redirecting to Login...</h2>");
            res.setHeader("Refresh", "2; URL=Login.html");
        }
    }
}
