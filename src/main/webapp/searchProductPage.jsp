<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Result Products</title>
<link rel="stylesheet" href="css/adminPagesStyles.css">
</head>
<body>
<div class = "table-container">
	<h2>Product Stocks</h2>
	<table border="1">
		<tr>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Category</th>
			<th>Quantity</th>
			<th>Price</th>
		</tr>
		<%
			try{
				//database connection
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest","root","rootpass123");	
			// above statement mydb is database name and root is mysql db username and mysql123 is db password
			Statement st = con.createStatement();
			//get username input from customerAccounts.jsp
			String product = request.getParameter("product");
			String sqlStr = "select * from product where productName RLIKE '"+product+"'";
			ResultSet rs = st.executeQuery(sqlStr);
			while(rs.next()){
			%>	
			<tr>
				<td><%=rs.getInt("productID")%></td>
				<td><%=rs.getString("productName")%></td>
				<td><%=rs.getString("category") %> </td>
				<td><%=rs.getString("quantity") %> </td>
				<td><%=rs.getString("price") %> </td>
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