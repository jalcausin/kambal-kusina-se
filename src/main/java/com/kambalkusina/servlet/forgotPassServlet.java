package com.kambalkusina.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/forgotPass")
public class forgotPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			try (PrintWriter out = response.getWriter()) {
				String email = request.getParameter("email");
				
				HttpSession session = request.getSession();
				
				RequestDispatcher dispatcher = null;
				Connection con = null;
				
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");	
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest","root","rootpass123");
					PreparedStatement pst = con.prepareStatement("select * from users where email = ?");
				
					pst.setString(1, email);
					
					ResultSet rs = pst.executeQuery();
					if (rs.next()) {
						sendEmail2 sm = new sendEmail2();
						String code = sm.getRandom();
				
						User2 user2 = new User2(email,code);
				
						boolean test = sm.SendEmail2(user2);
				
						if(test) {
							session.setAttribute("authcode",user2);
							session.setAttribute("email", email);
							response.sendRedirect("verifyPassword.jsp");
						} else {
							out.println("Failed to send a verification email!");
						}
					} else {
						
						response.sendRedirect("forgotError.jsp");
					}
						
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
