package com.kambalkusina.servlet;

import java.io.IOException;
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

/**
 * Servlet implementation class updateStocks
 */
@WebServlet("/updateStocks")
public class updateStocks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String product = request.getParameter("product");
		String stockChange = request.getParameter("stockChange");
		int stockChangeint = Integer.parseInt(stockChange);
		
		RequestDispatcher dispatcher = null;
		Connection con = null;
		
		HttpSession session = request.getSession();
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");	
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest","root","rootpass123");
		
		PreparedStatement pst = con.prepareStatement("update product SET quantity = ? WHERE productName = ?");
		pst.setInt(1, stockChangeint);
		pst.setString(2, product);
		
		int rowCount = pst.executeUpdate();
		if (rowCount > 0) {
			request.setAttribute("status", "success");
		} else {
			request.setAttribute("status", "failed");
		}
		
		
		dispatcher = request.getRequestDispatcher("adminProductStocksPage.jsp");
		dispatcher.forward(request, response);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
