package com.kambalkusina.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/verifyCode2")
public class verifyPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
		       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			try (PrintWriter out = response.getWriter()) {
				RequestDispatcher dispatcher = null;
				HttpSession session = request.getSession();
				User2 user2 = (User2) session.getAttribute("authcode");
				
				String code = request.getParameter("authcode");
				
				if(code.equals(user2.getCode())) {
					dispatcher = request.getRequestDispatcher("resetPasswordPage.jsp");
					request.setAttribute("status", "success");
					dispatcher.forward(request,response);
					
				}else {
					out.println("Incorrrect verification code");
				}
			}
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

}
