<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Order</title>
<link rel="stylesheet" href="css/updateOrderPageStyles.css">
</head>
<body>
    <div class="title">
       <h1> Update Order Page</h1>
    </div>
    <div class="container">
            <form action="updateChanges" method="post">
            <p>Full name:</p><input type="text"  value="<%=session.getAttribute("fullName")%>" readonly>
            <p>Email:</p><input type="text" value="<%=session.getAttribute("email")%>" readonly>
            <p>Address:</p><input type="text" value="<%=session.getAttribute("address")%>" readonly>
            <p>Username:</p><input type="text" name="uname1" value="<%=session.getAttribute("uname1")%>" readonly>
            <p>Contact:</p><input type="text" value="<%=session.getAttribute("contact")%>" readonly>
            <p>Product Name:</p><input type="text" name="product" value="<%=session.getAttribute("product")%>" readonly>
            <p>Quantity:</p><input type="text" value="<%=session.getAttribute("quantity")%>" readonly>
            <p>Total:</p><input type="text" value="<%=session.getAttribute("total")%>" readonly>
            <p>Date and Time:</p><input type="text" name="datentime" value="<%=session.getAttribute("datentime")%>" readonly>
            <p>Payment:</p>
            <select name="paymentChange" id="paymentChange">
            <optgroup label="Initial">
                <option value="<%= session.getAttribute("payment") %>"><%= session.getAttribute("payment") %></option>
            </optgroup>
            <optgroup label="Status">
                <option value="Pending">Pending</option>
                <option value="Paid">Paid</option>
            </optgroup>
            </select>
            <p>Order Status:</p><input type="text" value="<%=session.getAttribute("orderStatus")%>" readonly><br>
            <button type="submit">Update</button>
            </form>
</div>
 </body>
</html>