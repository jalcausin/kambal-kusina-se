<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Accounts</title>
<link rel="stylesheet" href="css/adminCustomerOrdersStyles.css">
</head>
<style>
body {
   font-family: 'Ovo', serif;
}
</style>
<body>
<div class = "table-container">
<h2 style="color:#DF7D60">Customer Orders</h2>
<div class = "search">
<form action="searchOrderPage.jsp">
		<input type="text" name="uname" placeholder="Type..."/>
		<input type="submit" value ="Search"/>	
</form>
	<br>
	<br>
<form action="salesReport" method="post">
<p>Start Date: <input type="datetime-local" name="datePicker"></p>
<p>End Date: <input type="datetime-local" name="datePickerEnd"></p>
<button type="submit">Sales Report</button>
</form>
<br>
<%
try
{
	Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest","root","rootpass123");	
	String sql =  "select * from customerorders";
	PreparedStatement pst = con.prepareStatement(sql);
	
	ResultSet rs = pst.executeQuery();
	
	if (rs.next() == false)
	{
		out.println("No records found in the table!");
	}
	else 
	{ %>	
		<table id="tableid" border="1">
			<tr><th>Full Name</th><th>Email</th><th>Address</th><th>Username</th><th>Contact</th><th>Product</th><th>Quantity</th><th>total</th><th>Date and Time</th><th>Payment</th><th>Order Status</th><th></th>
		<%
		do { %>
			<tr><td><%= rs.getString(1) %></td><td><%= rs.getString(2) %></td><td><%= rs.getString(3) %></td><td><%= rs.getString(4) %></td><td><%= rs.getString(5) %></td><td><%= rs.getString(6) %></td><td><%= rs.getString(7) %></td><td><%= rs.getString(8) %></td><td><%= rs.getString(9) %></td><td><%= rs.getString(10) %></td><td><%= rs.getString(11) %></td>
			<td>
			<form action="updateOrders" method="post">
			<input type="hidden" name="uname" id="uname" value="<%= rs.getString(4) %>">
			<input type="hidden" name="productName" id="productName" value="<%= rs.getString(6) %>">
			<input type="hidden" name="datetime" id="datetime" value="<%= rs.getString(9) %>">
			<button type="submit">Edit Order</button>
			</form>
			<br>
			<form action="updateStatus" method="post">
			<input type="hidden" name="uname" id="uname" value="<%= rs.getString(4) %>">
			<input type="hidden" name="productName" id="productName" value="<%= rs.getString(6) %>">
			<input type="hidden" name="datetime" id="datetime" value="<%= rs.getString(9) %>">
			<button type="submit">Update Order Status</button>
			</form>
			</td></tr>
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
<form action="adminHomePage.jsp">
<button class="backbtn" class="Btn">Back</button>
</form>
</div>
</div>


</body>
</html>