package com.kambalkusina.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/signup")
public class signupPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public signupPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String uname = request.getParameter("uname");
		String password = request.getParameter("pwd");
		String confirmPassword = request.getParameter("cpwd");
		
		RequestDispatcher dispatcher = null;
		Connection con = null;
		
		HttpSession session = request.getSession();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest","root","rootpass123");
			
			PreparedStatement pst1 = con.prepareStatement("select * from users where uname = ?");
			pst1.setString(1,  uname);
			
			ResultSet rs = pst1.executeQuery();
			
			if (rs.next()) {
				request.setAttribute("alertMsg", "Username Already Exists");
				RequestDispatcher rd=request.getRequestDispatcher("/signupPage.jsp");  
				rd.include(request, response);
			} else {
				session.setAttribute("fname", fname);
				session.setAttribute("lname", lname);
				session.setAttribute("uname", uname);
				session.setAttribute("email", email);
				session.setAttribute("password", password);
				

				sendEmail sm = new sendEmail();
				String code = sm.getRandom();
				
				User user = new User(uname,email,code);	
				
				boolean test = sm.SendEmail(user);
				
				if(test) {
					session.setAttribute("authcode",user);
					response.sendRedirect("verifyEmail.jsp");
				} else {
					PrintWriter out = response.getWriter();
					out.println("Failed to send a verification email!");
				}
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("Account Created");
				dispatcher.forward(request,response);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}

}
