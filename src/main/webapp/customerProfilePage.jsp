<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>User Settings Page</title>
<link rel="stylesheet" href="css/customerProfilePageStyles.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
</head>
<body>
	<nav>
		<div class="container">
			<div class="brand">
				<div class="logo">
					<img src="img/kkwithwordsorange.png" alt="" />
				</div>
				<div class="responsive-toggle">
					<i class="fas fa-bars"></i>
				</div>
			</div>

			<div class="links">
				<ul>
					<li><a href="homePageCustomer.jsp#home" id="nav-link">Home</a></li>
					<li><a href="homePageCustomer.jsp#about" id="nav-link">About</a></li>
					<li><a href="orderingMenuPage.jsp" id="nav-link">Ordering Menu</a></li>
					<li><h2>
							Hello,
							<%=session.getAttribute("name")%></h2></li>
					<li><form action="logout">
							<button class="logoutButton" type="submit">Logout</button>
						</form></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="profileContainer">
		<div class="leftbox">
			<nav>
				<a onclick="tabs(0)" class="tab"> <i class="fa fa-user"></i>
				</a> <a onclick="tabs(1)" class="tab"> <i class="fa fa-tasks"></i>
				</a>
			</nav>
		</div>

		<div class="rightbox">
			<div class="customerinfo tabShow">
				<h1>Customer Information</h1>
				<h2>FirstName</h2>
				<input type="text" class="input"
					value="<%=session.getAttribute("fname")%>">
				<h2>LastName</h2>
				<input type="text" class="input"
					value="<%=session.getAttribute("lname")%>">

				<h2>Email</h2>
				<input type="text" class="input"
					value="<%=session.getAttribute("email")%>">
				<h2>Username</h2>
				<input type="text" class="input"
					value="<%=session.getAttribute("uname")%>">
			</div>
			<div class="orderinfo tabShow">
				<div class="tableContainer">
					<h1>Order Information</h1>
					<%
					try {
						String uname = (String) session.getAttribute("uname");
						Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest", "root", "rootpass123");
						PreparedStatement pst = con.prepareStatement("select * from customerorders where uname = ?");
						pst.setString(1, uname);
						ResultSet rs = pst.executeQuery();

						if (rs.next() == false) {
					%>
					<p style="color: white; text-align: center">
						No orders found!<%
					} else {
					%>
					<table class="content-table">
					<thead>
						<th>Quantity</th>
						<th>Product</th>
						<th>Total</th>
						<th>Date and Time</th>
						<th>Payment</th>
						<th>Order Status</th>
					</thead>
						<%
						do {
						%>
						<tr>
							<td><%=rs.getString(7)%></td>
							<td><%=rs.getString(6)%></td>
							<td><%=rs.getString(8)%></td>
							<td><%=rs.getString(9)%></td>
							<td><%= rs.getString(10) %></td>
							<td><%= rs.getString(11) %></td>
							<td>
								<form action="cancelOrder" method="post">
									<input type="hidden" name="uname" id="uname"
										value="<%=rs.getString(4)%>"> <input type="hidden"
										name="productName" id="productName"
										value="<%=rs.getString(6)%>">
									<button type="submit">Cancel Order</button>
								</form>
							</td>
						</tr>
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
					</div>
		</div>
	</div>
	<footer>
		<div class="social-links">
			<h3 class="contactusH3">Contact Us!</h3>
			<br> <br>
			<ul id="listfooter">
				<li><a href="https://www.instagram.com/kambal_kusina/"><i
						class="fab fa-instagram"></i></a></li>
				<li><a href="https://www.facebook.com/KambalKusinaByKathie/"><i
						class="fab fa-facebook"></i></a></li>
				<li><a href="http://m.me/KambalKusinaByKathie/"><i
						class="fab fa-facebook-messenger"></i></a></li>
			</ul>
		</div>
	</footer>
	 <span class="copyright"
      >2022 &copy; All rights reserved by Kambal Kusina</span
    >
	<script src="jquery-3.6.0.min/jquery-3.6.0.min.js">
		
	</script>
	<script>
		const tab8tb = document.querySelectorAll(".tab");
		const tab = document.querySelectorAll(".tabShow");

		function tabs(panelIndex) {
			tab.forEach(function(node) {
				node.style.display = "none";
			});
			tab[panelIndex].style.display = "block";
		}
		tabs(0);
	</script>
	<script>
		$(".tab").click(function() {
			$(this).addClass("active").siblings().removeClass("active");
		})
	</script>
</body>
</html>