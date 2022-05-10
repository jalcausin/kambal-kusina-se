<!DOCTYPE html>
<html>
<head>
<title>Verify Email - Kambal Kusina</title>
<link rel="stylesheet" type="text/css" href="css/verifyEmailStyles.css">
<link
	href="https://fonts.googleapis.com/css2?family=Merriweather:wght@300&family=Ovo&display=swap"
	rel="stylesheet">
<script src="https://kit.fontawesome.com/a81368914c.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<div class="container">
		<div class="instructions">
			<p>We already sent a verification code to your email.</p>
		</div>
		<div class="forgotpass-content">
			<form action="verifyCode" method="post">
				<input type="hidden" name="fname" value="<%=session.getAttribute("fname")%>">
				<input type="hidden" name="lname" value="<%=session.getAttribute("lname")%>">
				<input type="hidden" name="email" value="<%=session.getAttribute("email")%>">
				<input type="hidden" name="uname" value="<%=session.getAttribute("uname")%>">
				<input type="hidden" name="password" value="<%=session.getAttribute("password")%>">
				<h2 class="title" style="color:#E39871">Verification</h2>
				<h5>Please enter below the code sent.</h5>
				<div class="input-div one">
					<div class="i"></div>
					<div class="div">
						<input type="text" name="authcode" autocomplete="off">
					</div>
				</div>
				<input type="submit" class="btn" value="VERIFY"> <a
					href="loginPage.jsp">Go back to Log-In Page</a>
			</form>
		</div>
	</div>
	<script type="text/javascript" src="js/verify.js"></script>
</body>
</html>