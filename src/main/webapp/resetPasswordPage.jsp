<!DOCTYPE html>
<html>
<head>
<title>Reset Password - Kambal Kusina</title>
<link rel="stylesheet" type="text/css" href="css/resetPasswordPageStyles.css">
<link
	href="https://fonts.googleapis.com/css2?family=Merriweather:wght@300&family=Ovo&display=swap"
	rel="stylesheet">
<script src="https://kit.fontawesome.com/a81368914c.js"></script>
<script>
	function validateForm(){
		var password = document.forms["resetForm"]["pwd"].value;
		var confirmpassword = document.forms["resetForm"]["cpwd"].value;
		
		if (password == null || password == ""){
			alert("Password cannot be blank");
			return false;
		}
		else if (password!=confirmpassword){
			alert("Password does not match. Please Re-enter password.");
			return false;
		}
	}
</script>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<div class="container">
		<div class="resetpass-content">
		<h2 style="text-align:center">Hello, <%= session.getAttribute("email")%></h2>
		<h2 class="title">Reset Password</h2>
			<form name="resetForm" action="resetPass"  method="post" onSubmit="return validateForm()">
				<input type="hidden" name="email" value="<%= session.getAttribute("email")%>"/>
				<p>Passsword must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters</p>
        		<input type="password" id="pwd" name="pwd" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" placeholder="Password">
        		<input type="password" id="cpwd" name="cpwd" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" placeholder="Confirm Password">
				<input type="submit" class="btn" value="Reset My Password">
			</form>
			</div>
		</div>
	<script type="text/javascript" src="resetPass.js"></script>
</body>	
</html>