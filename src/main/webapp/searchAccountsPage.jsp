<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/adminPagesStyles.css">
<title>Search Account Page</title>
</head>
<body>
<div class = "table-container">
<h2>Customer Accounts Information</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>UserName</th>
			<th>Email</th>
			
		</tr>
		<%
			try{
				//database connection
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest","root","rootpass123");
			// above statement mydb is database name and root is mysql db username and mysql123 is db password
			Statement st = con.createStatement();
			//get username input from customerAccounts.jsp
			String user = request.getParameter("user");
			String sqlStr = "select * from users where uname='"+user+"'";
			ResultSet rs = st.executeQuery(sqlStr);
			while(rs.next()){
			%>	
			<tr>
				<td><%=rs.getInt("id")%></td>
				<td><%=rs.getString("fname")%></td>
				<td><%=rs.getString("lname")%></td>
				<td><%=rs.getString("uname")%></td>
				<td><%=rs.getString("email")%></td>
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
</div>
</body>
</html>