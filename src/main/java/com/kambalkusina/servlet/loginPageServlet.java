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

@WebServlet("/login")
public class loginPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public loginPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		
		HttpSession session = request.getSession();
		
		RequestDispatcher dispatcher = null;
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest","root","rootpass123");
			PreparedStatement pst = con.prepareStatement("select * from users where uname = ? and pwd = ?");
			
			pst.setString(1, uname);
			pst.setString(2, pwd);
			
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				session.setAttribute("name", rs.getString("uname"));
				
				PreparedStatement pst1 = con.prepareStatement("select * from users where uname = ? and access = ?");
				pst1.setString(1,  uname);
				pst1.setString(2, "admin");
				
				ResultSet rs1 = pst1.executeQuery();
				if (rs1.next()) {
					dispatcher = request.getRequestDispatcher("adminHomePage.jsp");
				} else {
					dispatcher = request.getRequestDispatcher("orderingMenuPage.jsp");
				}
			} else {
				request.setAttribute("status","failed");
				dispatcher = request.getRequestDispatcher("loginPage.jsp");
			}
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			
		}
		
		
	}

}
