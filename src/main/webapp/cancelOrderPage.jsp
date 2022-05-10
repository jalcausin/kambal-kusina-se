<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/cancelOrderPageStyles.css">
<link rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" > 
<title>Cancel Order</title>
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
					<li><a href="homepageCustomer.jsp#about" id="nav-link">About</a></li>
					<li><a href="homepageCustomer.jsp#Where" id="nav-link">Category</a></li>
					<li><form action="viewOrders" method="post">
							<input type="hidden" name="uname" value="<%=session.getAttribute("uname1")%>">
						
					<button id="ViewOrderBtn" type="submit">View
							Orders</button>
							</form></li>
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
	<div class="cancelContainer">
		<form action="updateCancel" method="post">
			<p>Full name:</p>
			<input type="text" value="<%=session.getAttribute("fullName")%>"
				readonly>
			<p>Email:</p>
			<input type="text" value="<%=session.getAttribute("email")%>"
				readonly>
			<p>Address:</p>
			<input type="text" value="<%=session.getAttribute("address")%>"
				readonly>
			<p>Username:</p>
			<input type="text" name="uname1"
				value="<%=session.getAttribute("uname1")%>" readonly>
			<p>Contact:</p>
			<input type="text" value="<%=session.getAttribute("contact")%>"
				readonly>
			<p>Product Name:</p>
			<input type="text" name="product"
				value="<%=session.getAttribute("productName")%>" readonly>
			<p>Quantity:</p>
			<input type="text" value="<%=session.getAttribute("quantity")%>"
				readonly>
			<p>Total:</p>
			<input type="text" value="<%=session.getAttribute("total")%>"
				readonly>
			<p>Date and Time:</p>
			<input type="text" value="<%=session.getAttribute("datentime")%>"
				readonly>
			<p>Cancel Order Policy: The customer can cancel his/her order within 24 hours after confirming the order</p>
			<p>
				Cancellation Valid Until:<input type="text" name="exp"
					value="<%=session.getAttribute("exp")%>" readonly>
			</p>
			<p>Payment:</p>
			<input type="text" value="<%=session.getAttribute("payment")%>"
				readonly>
			<p>Order Status:</p>
			<input type="text" value="<%=session.getAttribute("orderStatus")%>"
				readonly> <br>
			<button type="submit">Cancel Order</button>
		</form>
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
</body>
<%
String message = (String) request.getAttribute("alertMsg");
%>
<script>
	var msg = "
<%=message%>";
 if (msg == "null") {
 	var msg1 = "Please be advised that we have a policy regarding cancelling orders."
 	alert(msg1)
 } else {
 	alert(msg);
 }
 </script>
</html>