package com.kambalkusina.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class updateCancel
 */
@WebServlet("/updateCancel")
public class updateCancel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname1");
		String product = request.getParameter("product");
		String expDate = request.getParameter("exp");
		LocalDateTime currentDate = LocalDateTime.now();
		LocalDateTime expdateTime = LocalDateTime.parse(expDate);
		
		boolean bool = currentDate.isAfter(expdateTime);
		
		RequestDispatcher dispatcher = null;
		Connection con = null;
		
		if (bool == true) {
			request.setAttribute("alertMsg", "Sorry! You can't cancel this order anymore!");
			RequestDispatcher rd=request.getRequestDispatcher("/cancelOrderPage.jsp");  
			rd.include(request, response);
		}
		else {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");	
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest","root","rootpass123");
				
				PreparedStatement pst = con.prepareStatement("update customerorders SET orderStatus = ? WHERE uname = ? AND product = ?");
				pst.setString(1, "Cancelled");
				pst.setString(2, uname);
				pst.setString(3, product);
				
				int rowCount = pst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
				
				request.setAttribute("alertMsg", "Order Successfuly Cancelled!");
				RequestDispatcher rd=request.getRequestDispatcher("/customerProfilePage.jsp");  
				rd.include(request, response);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}

}
