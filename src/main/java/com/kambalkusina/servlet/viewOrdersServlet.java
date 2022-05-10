package com.kambalkusina.servlet;

import java.io.IOException;
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

/**
 * Servlet implementation class viewOrders
 */
@WebServlet("/viewOrders")
public class viewOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		
		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest","root","rootpass123");
			
			PreparedStatement pst = con.prepareStatement("select * from users where uname = ?");
			
			pst.setString(1, uname);
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				String fname = rs.getString(2);
				String lname = rs.getString(3);
				String email = rs.getString(4);
				session.setAttribute("fname", fname);
				session.setAttribute("lname", lname);
				session.setAttribute("email", email);
				session.setAttribute("uname", uname);
			}
		} catch (Exception e) {
			
		}
		
		request.setAttribute("status","successful");
		dispatcher = request.getRequestDispatcher("customerProfilePage.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
