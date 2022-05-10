<!DOCTYPE html>
<html>
<head>
<title>Admin Homepage</title>
    <link rel="stylesheet" type="text/css" href="css/adminStyles.css">
<body>
    <div class="container">
    <img src="img/kkonlyorange.png" class="avatar">
        <h1>Kambal Kusina</h1>
            <p>Welcome, Administrator</p>
            <p>What do you want to access?</p>
             <form action="adminCustomerOrdersPage.jsp">
		    <button type="submit">Customer Orders</button>
		    </form>
		    <form action="adminCustomerAccountsPage.jsp">
		    <button type="submit">Customer Account Information</button>
		    </form>
		    <form action="adminProductStocksPage.jsp">
		    <button type="submit">Product Stocks</button>
		    </form>
		    <div class="center">
		    <form action="logout">
		    <button class="logout" type="submit">Logout</button>
		    </form>
		    </div>
    </div>
</body>
</head>
</html>