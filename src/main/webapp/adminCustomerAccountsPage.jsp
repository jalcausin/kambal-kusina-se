<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Accounts</title>
<link rel="stylesheet" href="css/adminPagesStyles.css">
</head>
<style>
body {
   font-family: 'Ovo', serif;
}
</style>
<body>
<div class = "table-container">
<h2 style="color:#DF7D60">Customer Accounts Information</h2>
<div class = "search">
<form action="searchAccountsPage.jsp">
		<input type="text" name="user" placeholder="Type..."/>
		<input type="submit" value ="Search"/>	
</form>
	<br>
	<br>	
<%
try
{
	Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest","root","rootpass123");
	String sql =  "select * from users";
	PreparedStatement pst = con.prepareStatement(sql);
	
	ResultSet rs = pst.executeQuery();
	
	if (rs.next() == false)
	{
		out.println("No records found in the table!");
	}
	else 
	{ %>	
		<table border="1">
			<tr><th>ID</th><th>First Name</th><th>Last Name</th><th>Email</th><th>UserName</th>
		<%
		do { %>
			<tr><td><%= rs.getString(1) %></td><td><%= rs.getString(2) %></td><td><%= rs.getString(3) %></td><td><%= rs.getString(4) %></td><td><%= rs.getString(5) %></td></tr>
			<%	
		} while (rs.next());
			
			}
			%>
		</table> 
		<%		
} catch (Exception e) {
	e.getStackTrace();
}
%>
</div>
<div style="display:flex; position:fixed; right:80px; bottom:130px;">
<button class="backbtn" onclick="history.go(-1)" class="Btn">Back</button>
</div>
</div>
</body>
</html>