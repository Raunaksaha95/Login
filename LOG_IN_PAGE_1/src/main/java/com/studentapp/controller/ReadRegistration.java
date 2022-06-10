package com.studentapp.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;

import com.studentapp.model.DAOservice;
import com.studentapp.model.DAOserviceimpl;

@WebServlet("/fetch")
public class ReadRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReadRegistration() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			session.setMaxInactiveInterval(10);
			if (session.getAttribute("email") != null) {

				DAOservice service = new DAOserviceimpl();
				service.connectDB();

				ResultSet result = service.getAllReg();
				request.setAttribute("res", result);
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/list_registration.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}

		} catch (Exception e) {
			request.setAttribute("errormsg", "Session Timeout login again");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
