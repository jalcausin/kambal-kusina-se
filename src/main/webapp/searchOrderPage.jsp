<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/adminPagesStyles.css">
<title>Search Customer Orders</title>
</head>
<body>
<div class = "table-container">
	<h2>Customer Orders</h2>
	<table border="1">
		<tr>
			<th>Full Name</th>
			<th>Email</th>
			<th>Address</th>
			<th>Username</th>
			<th>Contact</th>
			<th>Product</th>
			<th>Quantity</th>
			<th>Total</th>
			<th>Date and Time</th>
			<th>Payment</th>
			<th>Order Status</th>
		</tr>
		<%
			try{
				//database connection
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest","root","rootpass123");	
			// above statement mydb is database name and root is mysql db username and mysql123 is db password
			Statement st = con.createStatement();
			//get username input from customerAccounts.jsp
			String uname = request.getParameter("uname");
			String sqlStr = "select * from customerorders where uname RLIKE '"+uname+"'";
			ResultSet rs = st.executeQuery(sqlStr);
			while(rs.next()){
			%>	
			<tr>
				<td><%=rs.getString(1)%></td>
				<td><%=rs.getString(2)%></td>
				<td><%=rs.getString(3) %> </td>
				<td><%=rs.getString(4) %> </td>
				<td><%=rs.getString(5) %> </td>
				<td><%=rs.getString(6) %> </td>
				<td><%=rs.getString(7) %> </td>
				<td><%=rs.getString(8) %> </td>
				<td><%=rs.getString(9) %> </td>
				<td><%=rs.getString(10) %> </td>
				<td><%=rs.getString(11) %> </td>
			</tr>
			<% } // while loop complete here
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		%>
	</table>
	<br>
	<br>
	<button onclick="history.go(-1)">Return</button>
</body>
</html>