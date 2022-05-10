package com.kambalkusina.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/salesReport")
public class salesReport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String datePicker = request.getParameter("datePicker");
		String datePickerEnd = request.getParameter("datePickerEnd");
		LocalDateTime pick = LocalDateTime.parse(datePicker);
		LocalDateTime pick2 = LocalDateTime.parse(datePickerEnd);
		
		RequestDispatcher dispatcher = null;
		Connection con = null;
		
		HttpSession session = request.getSession();

		session.setAttribute("datepicker", pick);
		session.setAttribute("datepicker1", pick2);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest","root","rootpass123");
			
			PreparedStatement pst = con.prepareStatement("select * from customerorders");
			
			ResultSet rs = pst.executeQuery();
			Statement stmt =  con.createStatement();
			String sql = "DROP TABLE successfulSales";
	        stmt.executeUpdate(sql);
	        stmt.executeUpdate("create table successfulSales (fullName varchar(50), email varchar(30), uname varchar(50), contact varchar(11), product varchar(30), quantity int, total int, datentime varchar(100))");
			
	        String sql1 = "DROP TABLE successfulSalesTemp";
	        stmt.executeUpdate(sql1);
	        stmt.executeUpdate("create table successfulSalesTemp (fullName varchar(50), email varchar(30), uname varchar(50), contact varchar(11), product varchar(30), quantity int, total int, datentime varchar(100))");
	        
	        while (rs.next()) {
				String payment = rs.getString(10);
				String orderStatus = rs.getString(11);
				
				boolean bool1 = orderStatus.equals("Confirmed");
				boolean bool2 = payment.equals("Paid");
				
				if (bool1 == true && bool2 == true) {
					String uname = rs.getString(4);
					String productName = rs.getString(6);
					String datentime = rs.getString(9);
					
					PreparedStatement pst2 = con.prepareStatement("insert into successfulSales (fullName, email, uname, contact, product, quantity, total, datentime) select fullName, email, uname, contact, product, quantity, total, datentime from customerorders WHERE uname=? AND product=? AND datentime=?");
					pst2.setString(1,uname);
					pst2.setString(2, productName);
					pst2.setString(3, datentime);
					
					int rowCount2 = pst2.executeUpdate();
					if (rowCount2 > 0) {
						request.setAttribute("status", "success");
					} else {
						request.setAttribute("status", "failed");
					}
			
				}
				
				PreparedStatement pst1 = con.prepareStatement("Select * from successfulSales");
				
				ResultSet rs1 = pst1.executeQuery();
				while (rs1.next());
				String datecom = rs.getString(9);
				LocalDateTime compare = LocalDateTime.parse(datecom);
				boolean aftdate = compare.isAfter(pick);
				boolean befdate = compare.isBefore(pick2);
				
					if (aftdate == true && befdate == true) {
						PreparedStatement pst3 = con.prepareStatement("insert into successfulSalesTemp (fullName, email, uname, contact, product, quantity, total, datentime) select fullName, email, uname, contact, product, quantity, total, datentime from successfulSales WHERE uname=? AND product=? AND datentime=?");
						pst3.setString(1, rs.getString(4));
						pst3.setString(2, rs.getString(6));
						pst3.setString(3, rs.getString(9));
						
						int rowCount3 = pst3.executeUpdate();
						if (rowCount3 > 0) {
							request.setAttribute("status", "success");
						} else {
							request.setAttribute("status", "failed");
						}
						
					}
						
			}
	        
			
			dispatcher = request.getRequestDispatcher("salesReportPage.jsp");
			dispatcher.forward(request, response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
