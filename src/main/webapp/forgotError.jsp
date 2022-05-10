<!DOCTYPE html>
<html>
<head>
    <title>Forgot Password - Kambal Kusina</title>
    <link rel="stylesheet" type="text/css" href="css/forgotErrorStyles.css">
    <link href="https://fonts.googleapis.com/css2?family=Merriweather:wght@300&family=Ovo&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/a81368914c.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<style>
</style>
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
                    <li><a href="homePage.jsp#home" id="header-links">Home</a></li>
                    <li><a href="homePage.jsp#about" id="header-links">About</a></li>
                    <li><a href="homePage.jsp#bestsellers" id="header-links">Food Categories</a></li>
                    <li><button>Log In</button></li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="instructionsContainer">
        <div class="instructions">
            <p><em>Email Doesn't Exist in our Database<br><br></em>Please enter the email address you used to register for this account below and click the RESET PASSWORD button to receive an email that contains a code to set your new password.</p>
        </div>
        <div class="forgotpass-content">
            <form action="forgotPass" method="post">
                <h2 class="title">Forgot Password</h2>
                   <div class="input-div one">
                      <div class="i">
                      </div>

                      <div class="div">
                              <h5>Email</h5>
                              <input type="text" name="email" id="email" autocomplete="off" required>
                              <input type="hidden" name="error" id="error" value="<%= session.getAttribute("status") %>">
                      </div>
                   </div>
                    <input type="submit" class="btn" value="Send Code"  onclick="errorMessage()">
                <a href="LoginPage2.jsp">Go back to Log-In Page</a>
                
            </form>
        </div>
    </div>
        <footer>
        <div class="social-links">
        <h3 class="contactusH3">Contact Us!</h3>
        <br>
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
</html>