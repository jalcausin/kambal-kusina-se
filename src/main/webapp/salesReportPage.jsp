<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Daily Sales Report</title>
<link rel="stylesheet" href="css/adminPagesStyles.css">
</head>
<body>
<h2 style="color:#DF7D60">Daily Sales Report</h2>
<div class = "search">
<br>
<%
try
{
	Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest","root","rootpass123");	
	String sql =  "select * from successfulSalesTemp";
	PreparedStatement pst = con.prepareStatement(sql);
	HttpSession session1 = request.getSession();
	ResultSet rs = pst.executeQuery();
	
	if (rs.next() == false)
	{
		out.println("No records found in the table!");
		
	}
	else 
	{ %>	
		<table id="tableid" border="1">
			<tr><th>Full Name</th>
			<th>Email</th>
			<th>Username</th>
			<th>Contact</th>
			<th>Product</th>
			<th>Quantity</th>
			<th>total</th>
			<th>Date and Time</th>
		<%
		do { %>
			<tr><td><%= rs.getString(1) %></td>
			<td><%= rs.getString(2) %></td>
			<td><%= rs.getString(3) %></td>
			<td><%= rs.getString(4) %></td>
			<td><%= rs.getString(5) %></td>
			<td><%= rs.getString(6) %></td>
			<td><%= rs.getString(7) %></td>
			<td><%= rs.getString(8) %></td>
			</tr>
			<%	
		} while (rs.next());
			}
	%><tfoot>
    <tr>
    	<td>Total: </td>
    	<td><% PreparedStatement totalpst = con.prepareStatement("select * from successfulSalesTemp");
		ResultSet rsTotal = totalpst.executeQuery();
		int sum = 0;
		while (rsTotal.next()) {
		String total = rsTotal.getString(7);
		int totalint = Integer.parseInt(total);
		sum += totalint;
		}
		out.println(sum);%></td>
    </tr>
    </tfoot>
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
</body>
</html>