package com.studentapp.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.studentapp.model.DAOservice;
import com.studentapp.model.DAOserviceimpl;
@WebServlet("/verifyLogin")
public class Logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Logincontroller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		DAOservice service = new DAOserviceimpl();
		service.connectDB();
		boolean status = service.verifyCredential(email, password);

		if (status == true) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/new_ragistration.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("errormsg", "Invalid username/password");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}

	}

}
