package com.kambalkusina.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cancelOrder")
public class cancelOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String product = request.getParameter("productName");
		
		RequestDispatcher dispatcher = null;
		Connection con = null;
			
		HttpSession session = request.getSession();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest","root","rootpass123");
			
			PreparedStatement pst = con.prepareStatement("select * from customerorders where uname = ? AND product = ?");
			pst.setString(1, uname);
			pst.setString(2, product);
			
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
			String fullName = rs.getString(1);
			String email = rs.getString(2);
			String address = rs.getString(3);
			String uname1 = rs.getString(4);
			String contact = rs.getString(5);
			String productName = rs.getString(6);
			String quantity = rs.getString(7);
			String total = rs.getString(8);
			String datentime = rs.getString(9);
			String payment = rs.getString(10);
			String orderStatus = rs.getString(11);
			String exp = rs.getString(12);
			
			session.setAttribute("fullName", fullName);
			session.setAttribute("email", email);
			session.setAttribute("address", address);
			session.setAttribute("uname1", uname1);
			session.setAttribute("contact", contact);
			session.setAttribute("productName", productName);
			session.setAttribute("quantity", quantity);
			session.setAttribute("total", total);
			session.setAttribute("datentime", datentime);
			session.setAttribute("payment", payment);
			session.setAttribute("orderStatus", orderStatus);
			session.setAttribute("exp", exp);
			
			request.setAttribute("status", "success");
			dispatcher = request.getRequestDispatcher("cancelOrderPage.jsp");
			dispatcher.forward(request, response);
			}
			
		} catch (Exception e) {
			
		}
			
	}
}


