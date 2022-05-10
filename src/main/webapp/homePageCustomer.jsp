
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
      integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />
    <link rel="stylesheet" href="css/homePageCustomerStyles.css" />
    <title>Kambal Kusina</title>
  </head>
  <body onload="bodyLoaded()">
    <div class="preloader"></div>
    <div class="scrollToTop"></div>
    <nav>
      <div class="container">
        <div class="brand">
          <div class="logo">
            <img src="img/logo.png" alt="" />
          </div>
          <div class="responsive-toggle">
            <i class="fas fa-bars"></i>
          </div>
        </div>
        <div class="links">
          <ul>
            <li><a href="#home" id="nav-link">Home</a></li>
            <li><a href="#about" id="nav-link">About</a></li>
            <li><a href="#bestsellers" id="nav-link">Food Categories</a></li>
            <li><form action="viewOrders" method="post">
			  	  <input type="hidden" name="uname" value="<%= session.getAttribute("name")%>">
   			      <button type="submit" id="ViewOrderBtn">Customer Profile</button>
			      </form></li>
            <li><a href="loginPage.jsp"><button>Log Out</button></a></li>
          </ul>
        </div>
      </div>
    </nav>
    <section class="starter">
      <div class="info">
        <h1 class="title"> Hello, <%= session.getAttribute("name")%></h1>
        <h5 class="description">
          What are you craving for today?
        </h5>
      </div>
      <div class="image" id="home">
        <img src="img/coverOne.png" alt="" />
      </div>
    </section>
    <section class="about" id="about">
      <div class="image">
        <img src="img/coverTwo.png" alt="" />
      </div>
      <div class="info">
       
        <h2 class="title">About Kambal Kusina</h2>
        <h6 class="description">
         Kambal Kusina is a family business that we started during the pandemic. 
         In our quest to find an additional source of income, we have decided to start selling something that we love - food! 
         So, with one chest freezer and a mindset of a winner, Kambal Kusina was born.
        </p>
      </div>
    </section>
    <section class="bestsellers" id="bestsellers">
      <div class="info">

        <h2 class="title">Shop By Category</h2>
      </div>
      <div class="content">
        </div>
        <div class="cards">
          <a href="orderingMenuPage.jsp">
          <div class="card">
            <div class="text">
              
            <img src="foodimg/Siomai1.jpg" alt="" />
              <h3 class="title">Dimsum</h3>
              <p class="description">
                Craving for some Chinese dishes? Here at Kambal Kusina, we offer fresh dimsum products that you will certaintly enjoy! Partner it as well with our soft siopao products or with the unique Creamy ube Siopao! 

              </p>
            </a>
            </div>
            </div>
            <a href="orderingMenuPage.jsp">
          <div class="card">
            <div class="text">
            <img src="foodimg/meat.jpg" alt="" />
              <h3 class="title">Meat</h3>
              <p class="description">
                Kambal Kusina's premium frozen meats that has a variety of products to choose from! From your Breakfast Bacon, Longganisa, patties, to your Japanese dish tonkatsu, all meat products are fresh and will surely get your energy up for the day!

              </p>
            </a>
            </div>
            </div>
            <a href="orderingMenuPage.jsp">
          <div class="card">
            <div class="text">
            <img src="foodimg/Chicken.jpeg" alt="" />
              <h3 class="title">Chicken</h3>
              <p class="description">
                Everyone loves chicken especially chicken nuggets! Satisfy your needs and order now your favorite chicken products with us! Kambal Kusina also has Chicken skin ready to be easily fried and to enjoy!

              </p>
            </a>
            </div>
          </div>
          <a href="orderingMenuPage.jsp">
          <div class="card">
            <div class="text">
            <img src="foodimg/Promeat.jpg" alt="" />
              <h3 class="title">Promeat</h3>
              <p class="description">
                For our Vegan/Protein lovers we have a class of Corned Beef and Hams of your liking! Choose the ham that you prefer and enjoy these delacies from the comfort of your home!

              </p>
            </a>
            </div>
          </div>
          <a href="orderingMenuPage.jsp">
          <div class="card">
            <div class="text">
            <img src="foodimg/FRIESS.png" alt="" />
              <h3 class="title">Patatas Corner</h3>
              <p class="description">
                We offer a variety of fries that would satisfy your potato cravings from your all-time favorite restaurants! From twister or coated fries, thin or thick, we have them all year around!
              </p>
            </a>
            </div>
          </div>
          <a href="orderingMenuPage.jsp">
          <div class="card">
            <div class="text">
            <img src="foodimg/ChicharonBulaklak.jpg" alt="" />
              <h3 class="title">Others</h3>
              <p class="description">
                Kambal Kusina also offer these assorted goods from your favorite Chicarong bulaklak, Fish Fillet, Hungarian Sausage, and many more! Check it out from the menu and order now quick!

              </p>
            </a>
            </div>
          </div>
        </div>
      </div>
    </section>
    <footer>
      <div class="social-links">
        <i class="fab fa-instagram"></i>
        <i class="fab fa-facebook"></i>
        <i class="fab fa-facebook-messenger"></i>
      </div>
    </footer>
    <span class="copyright"
      >2022 &copy; All rights reserved by Kambal Kusina</span
    >
    <script src="https://unpkg.com/scrollreveal"></script>
    <script src="js/script.js"></script>
  </body>
</html>
