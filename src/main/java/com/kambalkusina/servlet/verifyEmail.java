package com.kambalkusina.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/verifyCode")
public class verifyEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			try (PrintWriter out = response.getWriter()) {
				
				String fname = request.getParameter("fname");
				String lname = request.getParameter("lname");
				String email = request.getParameter("email");
				String uname = request.getParameter("uname");
				String password = request.getParameter("password");
				
				RequestDispatcher dispatcher = null;
				HttpSession session = request.getSession();
				User user = (User) session.getAttribute("authcode");
				
				String code = request.getParameter("authcode");
				
				if(code.equals(user.getCode())) {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");	
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest","root","rootpass123");
						PreparedStatement pst = con.prepareStatement("insert into users(fname,lname,email,uname,pwd,access) value(?,?,?,?,?,?)");
						pst.setString(1, fname);
						pst.setString(2, lname);
						pst.setString(3, email);
						pst.setString(4, uname);
						pst.setString(5, password);
						pst.setString(6, "cstmr");
						
						int rowCount = pst.executeUpdate();
						if (rowCount > 0) {
							dispatcher = request.getRequestDispatcher("loginPage.jsp");
							request.setAttribute("status", "success");
							dispatcher.forward(request,response);
						} else {
							request.setAttribute("status", "failed");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					
				}else {
					dispatcher = request.getRequestDispatcher("verifyEmail.jsp");
					request.setAttribute("status", "Failed");
					dispatcher.forward(request,response);
				}
			}
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
