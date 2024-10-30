package com.UserServlets;

import java.io.IOException;
import java.util.List;

import com.dao.TrainDao;
import com.model.TrainBean;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "alltrains", urlPatterns = { "/alltrains" })
public class AvailableTrains extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<TrainBean> trains = TrainDao.getAllTrains();
		System.out.print(trains);
		request.setAttribute("trains", trains);
		RequestDispatcher dispatcher = request.getRequestDispatcher("UAvailableTrains.jsp");
		dispatcher.forward(request, response);
	}
}
