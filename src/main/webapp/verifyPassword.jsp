<!DOCTYPE html>
<html>
<head>
<title>Verify</title>
<link rel="stylesheet" type="text/css" href="css/verifyPasswordStyles.css">
<link
	href="https://fonts.googleapis.com/css2?family=Merriweather:wght@300&family=Ovo&display=swap"
	rel="stylesheet">
<script src="https://kit.fontawesome.com/a81368914c.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<div class="container">
		<div class="instructions">
			<p>Hello, <%= session.getAttribute("email")%> <br><br>We already sent a verification code to your email.</p>
		</div>
		
		<div class="forgotpass-content">
			<form action="verifyCode2" method="post">
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
	<script type="text/javascript" src="verify2.js"></script>
</body>
</html>