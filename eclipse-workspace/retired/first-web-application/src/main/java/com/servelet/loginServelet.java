package com.servelet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login.do")
public class loginServelet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		String name = request.getParameter("name");
		System.out.println(name);
		request.setAttribute("name", name);
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		
	}
}