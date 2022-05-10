<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
	integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<head>
<link rel="stylesheet" href="css/confirmOrderPageStyles.css">
<meta charset="ISO-8859-1">
<title>Confirm Order</title>
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
                    <li><a href="#home" id="nav-link">Home</a></li>
                    <li><a href="#about" id="nav-link">About</a></li>
                    <li><form action="viewOrders" method="post">
                            <input type="hidden" name="uname"
                                value="<%=session.getAttribute("name")%>">
                        </form></li>
                    <li><button id="ViewOrderBtn" type="submit">View
                            Orders</button></li>
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
	<br>
	<br>
	<H1 style="color: #DF7D60">ORDERS</H1>
	<%
try
{
    Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest","root","rootpass123");
    String sql =  "select * from temp";
    PreparedStatement pst = con.prepareStatement(sql);
    ResultSet rs = pst.executeQuery();
    
    if (rs.next() == false)
    {
        %>
	<p style="color: white; text-align: center">
		No orders found!<% 
  	  }
    else 
    { %>
	
	<table id="orderTable" border="1">
		<tr>
			<th>Product</th>
			<th>Quantity</th>
			<th>Total</th>
			<th>Date/Time</th>
			<%
        do { %>
		
		<tr>
			<td><%= rs.getString(2) %></td>
			<td><%= rs.getString(3) %></td>
			<td><%= rs.getString(4) %></td>
			<td><%= rs.getString(5) %></td>
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
	<div class="modifyBtnWrapper">
		<button onclick="history.go(-1)" class="modifyBtn">Modify
			Order</button>
	</div>
	<div class="confirmOrderContainer">
		<form action="confirmOrder" method="post">
			<div style="width: 100%;">
				<div style="width: 50%; height: 100px; float: left;">
					<p>Name:</p>
					<input type="text" name="fullName"
						value="<%=session.getAttribute("fname")%> <%=session.getAttribute("lname")%>"
						readonly><br>
				</div>
				<div style="flex-grow: 1; height: 100px;">
					<p class="email">Email:</p>
					<input type="text"  name="email" value="<%=session.getAttribute("email")%>"
						readonly><br>
				</div>
				<div style="width: 50%; height: 100px; float: left;">
					<p>Username:</p>
					<input type="text" name="uname" value="<%=session.getAttribute("uname")%>"
						readonly><br>
				</div>
				<div style="flex-grow: 1; height: 100px;">
					<p>Contact Number:</p>
					<input type="text" min="0" name="contact" onkeypress=" return onlyNumberKey(event)" maxlength="11" autocomplete="off" required> <br>
				</div>
				<p>Delivery Address:</p>
				<input type="text" name="address" size="50" autocomplete="off" required><br> <br> <br> <br>
				<input type="checkbox" required>I accept the <a id="myBtn" href="#">Order Policy</a> <br>
				<input type="submit" class="confirmBtn" value="Confirm Order">
			</div>
			<!-- Update Stocks -->
			
			<!-- Siomai Stocks -->
			<input type="hidden" name="beefSiomai" value="<%= session.getAttribute("beefSiomai")%>">
			<input type="hidden" name="chickenSiomai" value="<%= session.getAttribute("chickenSiomai")%>">
			<input type="hidden" name="japaneseSiomai" value="<%= session.getAttribute("japaneseSiomai")%>">
			<input type="hidden" name="porkSiomai" value="<%= session.getAttribute("porkSiomai")%>">
			<input type="hidden" name="porkGyozaSiomai" value="<%= session.getAttribute("porkGyozaSiomai")%>">
			<input type="hidden" name="siopaoAsadoDimsum" value="<%= session.getAttribute("siopaoAsadoDimsum")%>">
			<input type="hidden" name="siopaoAsadoMDimsum" value="<%= session.getAttribute("siopaoAsadoMDimsum")%>">
			<input type="hidden" name="siopaoBolabolaDimsum" value="<%= session.getAttribute("siopaoBolabolaDimsum")%>">
			<input type="hidden" name="siopaoBolabolaMDimsum" value="<%= session.getAttribute("siopaoBolabolaMDimsum")%>">
			<input type="hidden" name="siopaoCAsadoDimsum" value="<%= session.getAttribute("siopaoCAsadoDimsum")%>">
			<input type="hidden" name="gyozaDimsum" value="<%= session.getAttribute("gyozaDimsum")%>">
			
			<!-- Meat Stocks -->
			<input type="hidden" name="baconMeat" value="<%= session.getAttribute("baconMeat")%>">
			<input type="hidden" name="beefTapaMeat" value="<%= session.getAttribute("beefTapaMeat")%>">
			<input type="hidden" name="bkUnmoldedMeat" value="<%= session.getAttribute("bkUnmoldedMeat")%>">
			<input type="hidden" name="burgerPattiesMeat" value="<%= session.getAttribute("burgerPattiesMeat")%>">
			<input type="hidden" name="bpUnmoldedMeat" value="<%= session.getAttribute("bpUnmoldedMeat")%>">
			<input type="hidden" name="embutidoMeat" value="<%= session.getAttribute("embutidoMeat")%>">
			<input type="hidden" name="jHotdogMeat" value="<%= session.getAttribute("jHotdogMeat")%>">
			<input type="hidden" name="jLonggaMeat" value="<%= session.getAttribute("jLonggaMeat")%>">
			<input type="hidden" name="longgaLucbanMeat" value="<%= session.getAttribute("longgaLucbanMeat")%>">
			<input type="hidden" name="longgaViganMeat" value="<%= session.getAttribute("longgaViganMeat")%>">
			<input type="hidden" name="porkTonkatsuMeat" value="<%= session.getAttribute("porkTonkatsuMeat")%>">
			
			<!-- ProMeat Stocks -->
			<input type="hidden" name="cornedBeefPromeat" value="<%= session.getAttribute("cornedBeefPromeat")%>">
			<input type="hidden" name="cornedBeef1Promeat" value="<%= session.getAttribute("cornedBeef1Promeat")%>">
			<input type="hidden" name="glazedHamPromeat" value="<%= session.getAttribute("glazedHamPromeat")%>">
			<input type="hidden" name="glazedHamLoafPromeat" value="<%= session.getAttribute("glazedHamLoafPromeat")%>">
			<input type="hidden" name="spamHamPromeat" value="<%= session.getAttribute("spamHamPromeat")%>">
			<input type="hidden" name="spamHamLoafPromeat" value="<%= session.getAttribute("spamHamLoafPromeat")%>">
			
			<!--Patatas Stocks -->
			<input type="hidden" name="bkFriesPatatas" value="<%= session.getAttribute("bkFriesPatatas")%>">
			<input type="hidden" name="regularPatatas" value="<%= session.getAttribute("regularPatatas")%>">
			<input type="hidden" name="hashbrownPatatas" value="<%= session.getAttribute("hashbrownPatatas")%>">
			<input type="hidden" name="hashbrown10Patatas" value="<%= session.getAttribute("hashbrown10Patatas")%>">
			<input type="hidden" name="kfcFriesPatatas" value="<%= session.getAttribute("kfcFriesPatatas")%>">
			<input type="hidden" name="mojosPatatas" value="<%= session.getAttribute("mojosPatatas")%>">			
		
			<!--Chicken Stocks -->
			<input type="hidden" name="skinSpicyChicken" value="<%= session.getAttribute("skinSpicyChicken")%>">
			<input type="hidden" name="kfcNB250Chicken" value="<%= session.getAttribute("kfcNB250Chicken")%>">
			<input type="hidden" name="kfcNB500Chicken" value="<%= session.getAttribute("kfcNB500Chicken")%>">
			<input type="hidden" name="mcfilletChicken" value="<%= session.getAttribute("mcfilletChicken")%>">
			<input type="hidden" name="McNuggetsChicken" value="<%= session.getAttribute("McNuggetsChicken")%>">
			<input type="hidden" name="skinOrigChicken" value="<%= session.getAttribute("skinOrigChicken")%>">
			
			<!--Others Stocks -->
			<input type="hidden" name="fishFilletOthers" value="<%= session.getAttribute("fishFilletOthers")%>">
			<input type="hidden" name="bulaklakOthers" value="<%= session.getAttribute("bulaklakOthers")%>">
			<input type="hidden" name="oilOthers" value="<%= session.getAttribute("oilOthers")%>">
			<input type="hidden" name="garlicOthers" value="<%= session.getAttribute("garlicOthers")%>">
			<input type="hidden" name="cheeseOthers" value="<%= session.getAttribute("cheeseOthers")%>">
			<input type="hidden" name="sausageOthers" value="<%= session.getAttribute("sausageOthers")%>">
		</form>
	</div>

	<!-- The Modal -->
	<div id="myModal" class="modal">
		<div class="modal-content">
			<span class="close">&times;</span>
			<h1 style="text-align: center">Order Policy</h1>
			<p style="font-weight: bold;">Products featured in the Online
				Services.</p>
			<p>All products are subject to availability. Images of products presented on the website are examples only and may not reflect the products that are delivered to you.</p>

			<p style="font-weight: bold;">Payment Instructions</p>
			<p>Gcash, Bank of the Philippine Islands (BPI) bank transfer, and Cash on Delivery (COD) are the available
				payment methods. For payment information and instructions, contact the business owner, Contact information is provided at the bottom of the website.
			</p>
			<p style="font-weight: bold;">Cancellation.</p>
			<p>Within 24 hours of placing an order, the customer may cancel it. Customers can cancel orders by visiting the "View Orders" section of our Food Products Page's navigation bar.</p>
			<p style="font-weight: bold;">Refunds and Returns.</p>
			<p>The business will not issue any refunds or accept any returns.</p>
			<p style="font-weight: bold;">Pick Up.</p>
			<p>Customers must first notify the business owner of the time and date they will pick up their orders so that the owner is aware and can prepare the products on time.</p>	
			<p style ="font-weight: bold;">Delivery</p>
			<p> Delivery time may vary depending on the location of the customer. The business owner will contact you using the details inputted in the order form when they are close to the specified location.
				If the customer's location is far, the owner may opt to deliver the product through the use of delivery services, and the customer will pay for the additional delivery fee.
			</p>
		</div>
	</div>
		<footer>
		<div class="social-links">
		<h3 class="contactusH3">Contact Us!</h3>
		<br>
			<ul id="listfooter">
			<li><a href="https://www.instagram.com/kambal_kusina/"><i class="fab fa-instagram"></i></a> </li>
			<li><a href="https://www.facebook.com/KambalKusinaByKathie/"><i class="fab fa-facebook"></i></a></li> 
			<li><a href="http://m.me/KambalKusinaByKathie/"><i class="fab fa-facebook-messenger"></i></a></li>
			</ul>
		</div>
	</footer>
	<span class="copyright"
      >2022 &copy; All rights reserved by Kambal Kusina</span
    >
</body>
<script>
//Get the modal
var modal = document.getElementById("myModal");

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on the button, open the modal
btn.onclick = function() {
  modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
function onlyNumberKey(evt) {
    
    // Only ASCII character in that range allowed
    var ASCIICode = (evt.which) ? evt.which : evt.keyCode
    if (ASCIICode > 31 && (ASCIICode < 48 || ASCIICode > 57))
        return false;
    return true;
}
</script>
<script src="script.js"></script>
</html>