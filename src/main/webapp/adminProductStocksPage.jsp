<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Stocks</title>
<link rel="stylesheet" href="css/adminProductStocksStyles.css">
</head>
<style>
body {
   font-family: 'Ovo', serif;
}
</style>
<body><div class = "search">
	<form id = "Searchstocks"action="searchProductPage.jsp">
		<input type="text" name="product" placeholder="Type..."/>
		<input type="submit" value ="Search"/>	
	</form>
<div class = "table-container">
<h2 style="color:#DF7D60">Product Stocks</h2>
</div>
<div class="updateStocks">
<form action="updateStocks" method="post">
	<select name="product" id="product">
	</div>
	<optgroup label="Siomai">
		<option value="Siomai-Beef">Siomai-Beef</option>
    	<option value="Siomai-Pork">Siomai-Pork</option>
  		<option value="Siomai-Chicken">Siomai-Chicken</option>
  		<option value="Siomai-Japanese">Siomai-Japanese</option>
  		<option value="Siomai-Pork-Dumpling-Gyoza">Siomai-Pork-Dumpling-Gyoza</option>
  		<option value="Siopao-Asado-Jumbo">Siopao-Asado-Jumbo</option>
  		<option value="Siopao-Asado-Mini">Siopao-Asado-Mini</option>
  		<option value="Siopao-Bola-Bola-Jumbo">Siopao-Bola-Bola-Jumbo</option>
  		<option value="Siopao-Bola-Bola-Mini">Siopao-Bola-Bola-Mini</option>
  		<option value="Siopao-Chicken-Asado">Siopao-Chicken-Asado</option>
  		<option value="Gyoza">Gyoza</option>
  	</optgroup>
  	<optgroup label="Meat">
    	<option value="Bacon">Bacon</option>
  		<option value="Beef-Tapa">Beef-Tapa</option>
  		<option value="BK-Unmolded-Patty">BK-Unmolded-Patty</option>
  		<option value="Burger-Patties">Burger-Patties</option>
  		<option value="Burger-Patties-Unmolded">Burger-Patties-Unmolded</option>
  		<option value="Embutido">Embutido</option>
  		<option value="Jollibee-Hotdog">Jollibee-Hotdog</option>
  		<option value="Jollibee-Longganisa">Jollibee-Longganisa</option>
  		<option value="Longga-Lucban">Longga-Lucban</option>
  		<option value="Longga-Vigan">Longga-Vigan</option>
  		<option value="Pork-Tonkatsu">Pork-Tonkatsu</option>
  	</optgroup>
  	<optgroup label="Promeat">
  		<option value="Promeat-Corned-Beef-1/2k">Promeat-Corned-Beef-1/2k</option>
  		<option value="Promeat-Corned-Beef-1k">Promeat-Corned-Beef-1k</option>
  		<option value="Promeat-Glazed-Ham">Promeat-Glazed-Ham</option>
  		<option value="Promeat-Glazed-Ham-Loaf">Promeat-Glazed-Ham-Loaf</option>
  		<option value="Promeat-Spam-Ham">Promeat-Spam-Ham</option>
  		<option value="Promeat-Spam-Ham-Loaf">Promeat-Spam-Ham-Loaf</option>
  	</optgroup>
  	<optgroup label="Patatas Corner">
  		<option value="Burger-King-French-Fries">Burger-King-French-Fries</option>
  		<option value="French-Fries-Regular">French-Fries-Regular</option>
  		<option value="Hashbrown">Hashbrown</option>
  		<option value="Hashbrown-10s">Hashbrown-10s</option>
  		<option value="KFC-Fries">KFC-Fries</option>
  		<option value="Mojos">Mojos</option>
  	</optgroup>
  	<optgroup label="Chicken">
  		<option value="Chicken-Skin-Spicy">Chicken-Skin-Spicy</option>
  		<option value="KFC-NB-250">KFC-NB-250</option>
  		<option value="KFC-NB-500">KFC-NB-500</option>
  		<option value="McFillet">McFillet</option>
  		<option value="McNuggets">McNuggets</option>
  		<option value="Chicken-Skin-Original">Chicken-Skin-Original</option>
  	</optgroup>
  	<optgroup label="Others">
  		<option value="Chowking-Fish-Fillet">Chowking-Fish-Fillet</option>
  		<option value="Chicharong-Bulaklak">Chicharong-Bulaklak</option>
  		<option value="Chicken-Oil">Chicken-Oil</option>
  		<option value="Crunchy-Garlic">Crunchy-Garlic"</option>
  		<option value="Hungarian-Cheese">Hungarian-Cheese</option>
  		<option value="Hungarian-Sausage">Hungarian-Sausage</option>
  	</optgroup>
	</select>
		<input type="number" id="stockChange" name="stockChange" min="0" value="0">
		<input type="submit" value = "Update"/>
</form>
</div>
<%
try
{
	Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest","root","rootpass123");
	String sql =  "select * from product";
	PreparedStatement pst = con.prepareStatement(sql);
	
	ResultSet rs = pst.executeQuery();
	
	if (rs.next() == false)
	{
		out.println("No records found in the table!");
	}
	else 
	{ %>
		<div class="tablecon">
		<table border="1">
			<tr><th>Product ID</th><th>Product Name</th><th>Category</th><th>Quantity</th><th>Price</th>
		<%
		do { %>
			<tr><td><%= rs.getString(1) %></td><td><%= rs.getString(2) %></td><td><%= rs.getString(3) %></td><td><%= rs.getString(4) %></td><td><%= rs.getString(5) %></td></tr>
			<%	
		} while (rs.next());
			
			}
			%>
		</table> 
		</div>
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
</body>
</html>