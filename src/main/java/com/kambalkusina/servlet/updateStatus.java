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


@WebServlet("/updateStatus")
public class updateStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String productName = request.getParameter("productName");
		String datetime = request.getParameter("datetime");
		
		RequestDispatcher dispatcher = null;
		Connection con = null;
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest","root","rootpass123");
			
			PreparedStatement pst = con.prepareStatement("select * from customerorders where uname = ? AND product = ? AND datentime = ?");
			pst.setString(1, uname);
			pst.setString(2, productName);
			pst.setString(3, datetime);
			
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
			String fullName = rs.getString(1);
			String email = rs.getString(2);
			String address = rs.getString(3);
			String uname1 = rs.getString(4);
			String contact = rs.getString(5);
			String productName1 = rs.getString(6);
			String quantity = rs.getString(7);
			String total = rs.getString(8);
			String datentime = rs.getString(9);
			String payment = rs.getString(10);
			String orderStatus = rs.getString(11);	
			String exp = rs.getString(12);
			LocalDateTime currentDate = LocalDateTime.now();
			LocalDateTime expdateTime = LocalDateTime.parse(exp);
			
			boolean bool = currentDate.isAfter(expdateTime);
			boolean bool1 = orderStatus.equals("Cancelled");
			
			if (bool == true) {
				if (bool1 == true) {
					System.out.println("1");
					PreparedStatement pst2 = con.prepareStatement("update customerorders SET orderStatus = ? WHERE uname = ? AND product = ? AND datentime = ?");
					pst2.setString(1, "Cancelled");
					pst2.setString(2, uname1);
					pst2.setString(3, productName1);
					pst2.setString(4, datentime);
				
					int rowCount2 = pst2.executeUpdate();
					if (rowCount2 > 0) {
						request.setAttribute("status", "success");
					} else {
						request.setAttribute("status", "failed");
					}
				
					dispatcher = request.getRequestDispatcher("adminCustomerOrdersPage.jsp");
					dispatcher.forward(request, response);
				} else {
					System.out.println("2");
					PreparedStatement pst1 = con.prepareStatement("update customerorders SET orderStatus = ? WHERE uname = ? AND product = ? AND datentime = ?");
					pst1.setString(1, "Confirmed");
					pst1.setString(2, uname1);
					pst1.setString(3, productName1);
					pst1.setString(4, datentime);
				
					int rowCount1 = pst1.executeUpdate();
					if (rowCount1 > 0) {
						request.setAttribute("status", "success");
					} else {
						request.setAttribute("status", "failed");
					}
			
					dispatcher = request.getRequestDispatcher("adminCustomerOrdersPage.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				System.out.println("3");
				dispatcher = request.getRequestDispatcher("adminCustomerOrdersPage.jsp");
				dispatcher.forward(request, response);
			}
		} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
