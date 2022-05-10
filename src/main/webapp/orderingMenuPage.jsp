<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link rel="stylesheet" href="css/orderingMenuPageStyles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" >
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
			  <li><a href="homePageCustomer.jsp#home" id="header-links">Home</a></li>
              <li><a href="homePageCustomer.jsp#about" id="header-links">About</a></li>
			  <li><form action="viewOrders" method="post">
			  	  <input type="hidden" name="uname" value="<%= session.getAttribute("name")%>">
   			      <button type="submit" id="ViewOrderBtn">View Orders</button>
			      </form></li> 
			      
			  <h2> Hello, <%= session.getAttribute("name")%></h2>
			  <li><form action="logout">
			<button type="submit">Logout</button>
			</form></li>
			</ul>
		  </div>
		</div>
	  </nav>
	  <form action="orderForm" method="get">
		<input type="hidden" name="uname" value="<%= session.getAttribute("name")%>">
    <div class="grid">
        <div class="menu">
            <h1 s>Food Products</h1>

    <div class="flex-container">

        
        <div class="category">
        <img id ="myDimsumimg" class= "dimsumImage" src="foodimg/Siomai1.jpg" height="250px" width= '250px'border ="1">
        <div class="overlay">
        <div id ="mySiomai" class="foodText">Dimsum</div>
        </div>
        </div>
        
        <div class="category"> 
        <img id ="myChickenimg" class= "ChickenImage" src="foodimg/Chicken.jpeg" height="250px" width= '250px'border ="1">
        <div class="overlay">
        <div id="myChicken" class="foodText">Chicken</div>   
        </div>
        </div>

        <div class="category"> 
        <img id ="myMeatimg" class= "MeatImage" src="foodimg/meat.jpg" height="250px" width= '250px'border ="1">
        <div class="overlay">
        <div id="myMeat" class="foodText">Meat</div>
        </div>
        </div>
        </div>
        <div class="flex-container">

        <div class="category"> 
        <img id ="myPromeatimg" class = "PromeatImage" src="foodimg/Promeat.jpg" height="250px" width= '250px'border ="1">
        <div class="overlay">
        <div id="myPromeat" class="foodText">Promeat</div>
        </div>
        </div>

        <div class="category">
        <img id ="myPatatasCornerimg" class= "PatatasCornerImage" src="foodimg/FRIESS.png" height="250px" width= '250px'border ="1">
        <div class="overlay">
        <div id="myPotato" class="foodText">Patatas Corner</div>
        </div>
        </div>

        <div class="category">
        <img id ="myOthersimg" class= "OthersImage" src="foodimg/ChicharonBulaklak.jpg" height="250px" width= '250px' border ="1">
        <div class="overlay">
        <div id="myOthers" class="foodText">Others</div>
        </div>
        </div>
    </div>
	<button class = "Checkout">Proceed To Checkout</button>

</div>
</div>
<!--DIMSUM MODAL-->
<div id="myModalSiomai" class="modal">
    <div class="modal-content">
    <span class="close">&times;</span>
        <div class ="modal-box">
        <div class="row">
            <div class="column-dimsum">
	              <img src="foodimg/Beef Siomai.jpg" style="height:120px; width:120px;border-radius:25%">
	              <p style="font-size:15px">Beef Siomai</p1>
	              <p style="font-size:15px">P. 90</p1>
	              <input type="hidden" name="beefName" value="Siomai-Beef"> <br>
	              <input type="number" id="beefquantity" name="beefquantity" min="0" max="10" value="0">
				</div>
				
				<div class="column-dimsum">
				<img src="foodimg/Ken Siomai.jpg" style="height:120px; width:120px;border-radius:25%">
	    		<p style="font-size:15px">Chicken Siomai</p>
	    		<p style="font-size:15px">P. 90</p>
				<input type="hidden" name="chickenName" value="Siomai-Chicken">
				<input type="number" id="chickenquantity" name="chickenquantity" min="0" max="10" value="0"> 
				</div>
				
				<div class="column-dimsum">
	    		<img src="foodimg/Japanese Siomai.jpg" style="height:120px; width:120px;border-radius:25%">
	    		<p style="font-size:15px">Japanese Siomai</p>
	    		<p style="font-size:15px">P. 110</p>
				<input type="hidden" name="japaneseName" value="Siomai-Japanese">
				<input type="number" id="japanesequantity" name="japanesequantity" min="0" max="10" value="0">   		<br>
	    		<br>
	  			</div>
	  			
	  			<div class="column-dimsum">
	    		<img src="foodimg/Pork Siomai.jpg" style="height:120px; width:120px;border-radius:25%">
	    		<p style="font-size:15px">Pork Siomai</p>
	    		<p style="font-size:15px">P. 90</p>
				<input type="hidden" name="porkName" value="Siomai-Pork">
	    		<input type="number" id="porkquantity" name="porkquantity" min="0" max="10" value="0">    	<br>
	    		<br>
	  			</div>

	  			<div class="column-dimsum">
	    		<img src="foodimg/Pork Dumpling.jpg" style="height:120px; width:120px;border-radius:25%">
	    		<p style="font-size:15px">Pork Dumpling Gyoza 30's</p>
	    		<p style="font-size:15px">P. 90</p>
				<input type="hidden" name="porkGyozaName" value="Siomai-Pork-Dumpling-Gyoza">
				<input type="number" id="dumplinggyozaquantity" name="dumplinggyozaquantity" min="0" max="10" value="0">   	<br>
	    		<br>
	  			</div>
  			
				<div class="column-dimsum">
	  			<img src="foodimg/logo.png" style="height:120px; width:120px;border-radius:25%">
	    		<p style="font-size:15px">Siopao Asado - Jumbo 10's</p>
	    		<p style="font-size:15px">P. 170</p>
				<input type="hidden" name="asadoJumboName" value="Siopao-Asado-Jumbo">
				<input type="number" id="asadojumboquantity" name="asadojumboquantity" min="0" max="10" value="0">   		<br>
	    		<br>
	  			</div>
				</div>

	  			<div class="row">
	  			<div class="column-dimsum">
	  			<img src="foodimg/logo.png" style="height:120px; width:120px;border-radius:25%">
	    		<p style="font-size:15px">Siopao Asado - Mini 24's</p>
	    		<p style="font-size:15px">P. 170</p>
	    		<input type="hidden" name="asadoMiniName" value="Siopao-Asado-Mini">
				<input type="number" id="asadominiquantity" name="asadominiquantity" min="0" max="10" value="0">
			    <br>
			  	</div>
			  	
			  	<div class="column-dimsum">
	  			<img src="foodimg/Siopao Bola-Bola.jpg" style="height:120px; width:120px;border-radius:25%">
	    		<p style="font-size:15px">Siopao Bola Bola - Jumbo 10's</p>
	    		<p style="font-size:15px">P. 170</p>
				<input type="hidden" name="bolabolaJumboName" value="Siopao-BolaBola-Jumbo">
				<input type="number" id="bolajumboquantity" name="bolajumboquantity" min="0" max="10" value="0">    	<br>
		    	<br>
		  		</div>
		  		
		  		<div class="column-dimsum">
			  	<img src="foodimg/logo.png" style="height:120px; width:120px;border-radius:25%">
			    <p style="font-size:15px">Siopao Bola Bola - Mini 24's</p>
			    <p style="font-size:15px">P. 170</p>
				<input type="hidden" name="bolabolaMiniName" value="Siopao-BolaBola-Mini">
				<input type="number" id="bolaminiquantity" name="bolaminiquantity" min="0" max="10" value="0">    		<br>
			    <br>
			  	</div>
			  	
			  	<div class="column-dimsum">
	  			<img src="foodimg/Chicken Asado.jpg" style="height:120px; width:120px;border-radius:25%">
	    		<p style="font-size:15px">Siopao Chicken Asado - Mini 24's</p>
	    		<p style="font-size:15px">P. 170</p>
				<input type="hidden" name="chickenAsadoName" value="Siopao-Chicken-Asado">
				<input type="number" id="chickenasadominiquantity" name="chickenasadominiquantity" min="0" max="10" value="0">    		<br>
		    	<br>
		  		</div>
		  		
				<div class="column-dimsum">
				<img src="foodimg/gyoza.png" style="height:120px; width:120px;border-radius:25%">
				<p style="font-size:15px">Gyoza</p>
				<p style="font-size:15px">P. 190</p>
				<input type="hidden" name="gyozaName" value="Gyoza">
				<input type="number" id="gyozaquantity" name="gyozaquantity" min="0" max="10" value="0">    		<br>
				<br>
				</div>
             </div>
             </div>
			 
           </div>
       </div>
<!--CHICKEN MODAL-->
<div id="myModalChicken" class ="modal">
    <div class ="modal-content">
    <span class ="close">&times;</span>
	<div class = "modal-box">
    	<div class = "row">
    
	  		<div class="column-chicken">
	     	<img src ="foodimg/chicken skin spicy.png" style ="height:120px; width:120px;border-radius:25%;">
	        <p style="font-size:15px w - 100 text-center">Chicken Skin Spicy</p>
	        <p style="font-size:15px">P. 135</p>
	        <input type="hidden" name="skinSpicyName" value="Chicken-Skin-Spicy">
	        <input type="number" id="skinSpicyquantity" name="skinSpicyquantity" min="0" max="10"value="0">
	        </div>
	        
	  		<div class="column-chicken">
	     	<img src ="foodimg/Kfc Nugget bites.png" style ="height:120px; width:120px;border-radius:25%">
	        <p style="font-size:15px">KFC NB 250</p>
	        <p style="font-size:15px">P. 95</p>
	        <input type="hidden" name="kfcNB250Name" value="KFC-NB-250">
	        <input type="number" id="kfcNB250quantity" name="kfcNB250quantity" min="0" max="10"value="0">
	        </div>
	        
	  		<div class="column-chicken">
	     	<img src ="foodimg/Kfc Nugget bites.png" style ="height:120px; width:120px;border-radius:25%">
	        <p style="font-size:15px">KFC NB 500</p>
	        <p style="font-size:15px">P. 180</p>
	        <input type="hidden" name="kfcNB500Name" value="KFC-NB-500">
	        <input type="number" id="kfcNB500quantity" name="kfcNB500quantity" min="0" max="10"value="0">
	        </div>
	        
	  		<div class="column-chicken">
	     	<img src ="foodimg/Mcfillet 10_s.jpg" style ="height:120px; width:120px;border-radius:25%">
	        <p style="font-size:15px">Mcfillet Chicken</p>
	        <p style="font-size:15px">P. 320</p>
	        <input type="hidden" name="mcfilletName" value="McFillet">
	        <input type="number" id="mcfilletquantity" name="mcfilletquantity" min="0" max="10"value="0">
	        </div>
	        
	  		<div class="column-chicken">
	     	<img src ="foodimg/McNuggets.jpg" style ="height:120px; width:120px;border-radius:25%">
	        <p style="font-size:15px">Mcnuggets Chicken</p>
	        <p style="font-size:15px">P. 290</p>
	        <input type="hidden" name="McNuggetsName" value="McNuggets">
	        <input type="number" id="McNuggetsquantity" name="McNuggetsquantity" min="0" max="10"value="0">
	        </div>
	        
	   		<div class="column-chicken">
	     	<img src ="foodimg/chicken skin.png" style ="height:120px; width:120px;border-radius:25%">
	        <p style="font-size:15px">Chicken Skin Original</p>
	        <p style="font-size:15px">P. 135</p>
	        <input type="hidden" name="skinOrigName" value="Chicken-Skin-Original">
	        <input type="number" id="skinOrigquantity" name="skinOrigquantity" min="0" max="10"value="0">
	         </div>
			 </div>

			 

    </div>
	</div>
	</div>
	
<!--MEAT MODAL-->
<!-- MEAT -->
  	<div id="myModalMeat" class ="modal">
    <div class ="modal-content">
    <span class ="close">&times;</span>
    <div class = "modal-box">
		<div class = "row">
			<div class="column-meat">
	        <img id = "foodimg/meat-img" src ="foodimg/bacon.png" style ="height:120px; width:120px;border-radius:25%">
	        <p style="font-size:15px">Bacon Premium (500gm)</p>
	        <p style="font-size:15px">P. 240</p>
	        <input type="hidden" name="baconPremiumName" value="Bacon">
	        <input type="number" id="baconpremiumquantity" name="baconpremiumquantity" min="0" max="10"value="0">
	        </div>
	        
			<div class="column-meat">
	        <img id = "foodimg/meat-img" src ="foodimg/logo.png" style ="height:120px; width:120px;border-radius:25%">
	        <p style="font-size:15px">Beef Tapa</p>
	        <p style="font-size:15px">P. 310</p>
	        <input type="hidden" name="beefTapaName" value="Beef-Tapa">
	        <input type="number" id="beefTapaquantity" name="beefTapaquantity" min="0" max="10"value="0">
	        </div>
	        
			<div class="column-meat">
	        <img id = "foodimg/meat-img" src ="foodimg/logo.png" style ="height:120px; width:120px;border-radius:25%">
	        <p style="font-size:15px">BK Unmolded Patty</p>
	        <p style="font-size:15px">P. 210</p>
	        <input type="hidden" name="bkUnmoldedName" value="BK-Unmolded-Patty">
	        <input type="number" id="bkUnmoldedquantity" name="bkUnmoldedquantity" min="0" max="10"value="0">
	        </div>
	        
			<div class="column-meat">
	        <img id = "foodimg/meat-img" src ="foodimg/logo.png" style ="height:120px; width:120px;border-radius:25%">
	        <p style="font-size:15px">Burger Patties</p>
	        <p style="font-size:15px">P. 220</p>
	        <input type="hidden" name="burgerPattiesName" value="Burger-Patties">
	        <input type="number" id="burgerPattiesquantity" name="burgerPattiesquantity" min="0" max="10"value="0">
	        </div>
	        
			<div class="column-meat">
	        <img id = "foodimg/meat-img" src ="foodimg/logo.png" style ="height:120px; width:120px;border-radius:25%">
	        <p style="font-size:15px">Burger Patties Unmolded</p>
	        <p style="font-size:15px">P. 210</p>
	        <input type="hidden" name="bpUnmoldedName" value="Burger-Patties-Unmolded">
	        <input type="number" id="bpUnmoldedquantity" name="bpUnmoldedquantity" min="0" max="10"value="0">
	        </div>
	        
	        <div class="column-meat">
	        <img id = "foodimg/meat-img" src ="foodimg/embutido.png" style ="height:120px; width:120px;border-radius:25%">
	        <p style="font-size:15px">Embutido</p>
	        <p style="font-size:15px">P. 115</p>
	        <input type="hidden" name="embutidoName" value="Embutido">
	        <input type="number" id="embutidoquantity" name="embutidoquantity" min="0" max="10"value="0">
	        </div>
			</div>

			<div class="row">
		    
	  		<div class="column-meat">
	        <img id = "meat-img" src ="foodimg/jb hotdog.png" style ="height:120px; width:120px;border-radius:25%">
	        <p style="font-size:15px">Jollibee Hotdog</p>
	        <p style="font-size:15px">P. 210</p>
	        <input type="hidden" name="jHotdogName" value="Jollibee-Hotdog">
	        <input type="number" id="jHotdogquantity" name="jHotdogquantity" min="0" max="10"value="0">
	        </div>
	        
	      	<div class="column-meat">
	        <img id = " meat-img" id = " meat-img" src ="foodimg/jb breakfast longganisa.png" style ="height:120px; width:120px;border-radius:25%">
	        <p style="font-size:15px">Jollibee Longganisa</p>
	        <p style="font-size:15px">P. 220</p>
	        <input type="hidden" name="jLonggaName" value="Jollibee-Longganisa">
	        <input type="number" id="jLonggaquantity" name="jLonggaquantity" min="0" max="10"value="0">
	        </div>
	        
			<div class="column-meat">
	        <img id = " meat-img" src ="foodimg/logo.png" style ="height:120px; width:120px;border-radius:25%">
	        <p style="font-size:15px">Longga Lucban(12s)</p>
	        <p style="font-size:15px">P. 150</p>
	        <input type="hidden" name="longgaLucbanName" value="Longga-Lucban">
	        <input type="number" id="longgaLucbanquantity" name="longgaLucbanquantity" min="0" max="10"value="0">
	        </div>
	        
	 		<div class="column-meat">
	        <img id = " meat-img" src ="foodimg/logo.png" style ="height:120px; width:120px;border-radius:25%">
	        <p style="font-size:15px">Longga Vigan(12s)</p>
	        <p style="font-size:15px">P. 150</p>
	        <input type="hidden" name="longgaViganName" value="Longga-Vigan">
	        <input type="number" id="longgaViganquantity" name="longgaViganquantity" min="0" max="10"value="0">
	        </div>
	        
			<div class="column-meat">
	        <img  src ="foodimg/tonkatsu.png" style ="height:120px; width:120px;border-radius:25%">
	        <p style="font-size:15px">Pork Tonkatsu</p>
	        <p style="font-size:15px">P. 290</p>
	        <input type="hidden" name="porkTonkatsuName" value="Pork-Tonkatsu">
	        <input type="number" id="porkTonkatsuquantity" name="porkTonkatsuquantity" min="0" max="10"value="0">
			</div>
			</div>
			</div>
			
			

	</div>
	</div>
<!--PROMEAT MODAL-->
<div id="myModalPromeat" class ="modal">
    <div class ="modal-content">
    <span class ="close">&times;</span>
    	<div class = "row">
    
	  		<div class="column-Promeat">
	     	<img src ="foodimg/Promeat Corned Beef.jpg" style ="height:120px; width:120px;border-radius:25%">
	        <p style="font-size:15px">Promeat Corned beef 1/2K </p>
	        <p style="font-size:15px">P. 150</p>
	        <input type="hidden" name="cornedBeefName" value="Promeat-Corned-Beef-1/2k">
	        <input type="number" id="cornedBeefquantity" name="cornedBeefquantity" min="0" max="10"value="0">
	        </div>
	        
	  		<div class="column-Promeat">
	     	<img src ="foodimg/logo.png" style ="height:120px; width:120px;border-radius:25%">
	        <p style="font-size:15px">Promeat Corned beef 1k</p>
	        <p style="font-size:15px">P. 290</p>
	        <input type="hidden" name="cornedBeef1Name" value="Promeat-Corned-Beef-1k">
	        <input type="number" id="cornedBeef1quantity" name="cornedBeef1quantity" min="0" max="10"value="0">
	        </div>
	        
	  		<div class="column-Promeat">
	     	<img src ="foodimg/logo.png" style ="height:120px; width:120px;border-radius:25%">
	        <p style="font-size:15px">Promeat glazed ham</p>
	        <p style="font-size:15px">P. 250</p>
	        <input type="hidden" name="glazedHamName" value="Promeat-Glazed-Ham">
	        <input type="number" id="glazedHamquantity" name="glazedHamquantity" min="0" max="10"value="0">
	        </div>
	        
	  		<div class="column-Promeat">
	     	<img src ="foodimg/Promeat Glazed Ham Loaf 3 Kilos.jpg" style ="height:120px; width:120px;border-radius:25%">
	        <p style="font-size:15px">Promeat glazed ham loaf</p>
	        <p style="font-size:15px">P. 710</p>
	        <input type="hidden" name="glazedHamLoafName" value="Promeat-Glazed-Ham-Loaf">
	        <input type="number" id="glazedHamLoafquantity" name="glazedHamLoafquantity" min="0" max="10" value="0">
	        </div>
	        
	        <div class="column-Promeat">
	     	<img src ="foodimg/Promeat Spam Ham Kilo.jpg" style ="height:120px; width:120px;border-radius:25%">
	        <p style="font-size:15px">Promeat Spam Ham</p>
	        <p style="font-size:15px">P. 250</p>
	        <input type="hidden" name="spamHamName" value="Promeat-Spam-Ham">
	        <input type="number" id="spamHamquantity" name="spamHamquantity" min="0" max="10" value="0">
	        </div>
	        
	  		<div class="column-Promeat">
	     	<img src ="foodimg/logo.png" style ="height:120px; width:120px;border-radius:25%">
	        <p style="font-size:15px">Promeat spam ham loaf</p>
	        <p style="font-size:15px">P. 600</p>
	        <input type="hidden" name="spamHamLoafName" value="Promeat-Spam-Ham-Loaf">
	        <input type="number" id="spamHamLoafquantity" name="spamHamLoafquantity" min="0" max="10"value="0">
	        </div>
			

    </div>
	

	</div>
	</div>
<!--PATATAS CORNER MODAL-->
	<div id="myModalPotato" class ="modal">
    <div class ="modal-content">
    <span class ="close">&times;</span>
	<div class ="modal-box">
		<div class ="row">
    	
	  		<div class="column-potato">
	       	<img src ="foodimg/bk fries.png" style ="height:120px; width:120px;border-radius:25%">
	        <p style="font-size:15px">Burger King French Fries</p>
	        <p style="font-size:15px">P. 160</p>
	        <input type="hidden" name="bkFriesName" value="Burger-King-French-Fries">
	        <input type="number" id="bkFriesquantity" name="bkFriesquantity" min="0" max="10"value="0">
	        </div>
	        
	  		<div class="column-potato">
	        <img src ="foodimg/french fries.png" style ="height:120px; width:120px;border-radius:25%">
	        <p style="font-size:15px">French Fries Regular</p>
	        <p style="font-size:15px">P. 200</p>
	        <input type="hidden" name="regularName" value="French-Fries-Regular">
	        <input type="number" id="regularquantity" name="regularquantity" min="0" max="10"value="0">
	        </div>
	        
	  		<div class="column-potato">
	        <img src ="foodimg/hashbrown.png" style ="height:120px; width:120px;border-radius:25%">
	        <p style="font-size:15px">Hashbrown</p>
	        <p style="font-size:15px">P. 200</p>
	        <input type="hidden" name="hashbrownName" value="Hashbrown">
	        <input type="number" id="hashbrownquantity" name="hashbrownquantity" min="0" max="10"value="0">
	        </div>
	        
	  		<div class="column-potato">
	        <img src ="foodimg/logo.png" style ="height:120px; width:120px;border-radius:25%">
	        <p style="font-size:15px">Hashbrown 10s</p>
	        <p style="font-size:15px">P. 200</p>
	        <input type="hidden" name="hashbrown10Name" value="Hashbrown-10s">
	        <input type="number" id="hashbrown10quantity" name="hashbrown10quantity" min="0" max="10"value="0">
	        </div>
	        
	  		<div class="column-potato">
	        <img src ="foodimg/kfc fries.png" style ="height:120px; width:120px;border-radius:25%">
	        <p style="font-size:15px">KFC Fries</p>
	        <p style="font-size:15px">P. 200</p>
	        <input type="hidden" name="kfcFriesName" value="KFC-Fries">
	        <input type="number" id="kfcFriesquantity" name="kfcFriesquantity" min="0" max="10"value="0">
	        </div>
	        
	    	<div class="column-potato">
	        <img src ="foodimg/mojos.png" style ="height:120px; width:120px;border-radius:25%">
	        <p style="font-size:15px">Mojos</p>
	        <p style="font-size:15px">P. 200</p>
	        <input type="hidden" name="mojosName" value="Mojos">
	        <input type="number" id="mojosquantity" name="mojosquantity" min="0" max="10"value="0">
			</div>

			<div class="column-potato">
				<img src ="foodimg/twister fries.png" style ="height:120px; width:120px;border-radius:25%">
				<p style="font-size:15px">Twister Fries</p>
				<p style="font-size:15px">P. 200</p>
				<input type="hidden" name="TwisterName" value="Twister Fries">
				<input type="number" id="Twisterquantity" name="Twisterquantity" min="0" max="10"value="0">
	        </div>
		</div>
	</div>
	

    </div>
	</div>
<!-- OTHERS -->
	<div id="myModalOthers" class ="modal">
    <div class ="modal-content">
    <span class ="close">&times;</span>
      <div class = "row">
      
	  		<div class="column-others">
	        <img src ="foodimg/logo.png" style ="height:120px; width:120px;border-radius:25%">
	        <p style="font-size:15px">Chowking Fish Fillet</p>
	        <p style="font-size:15px">P. 150</p>
	        <input type="hidden" name="fishFilletName" value="Chowking-Fish-Fillet">
	        <input type="number" id="fishFilletquantity" name="fishFilletquantity" min="0" max="10"value="0">
	        </div>
	        
	  		<div class="column-others">
	        <img src ="foodimg/chicharon bulaklak.png" style ="height:120px; width:120px;border-radius:25%">
	        <p style="font-size:15px">Chicarong bulaklak</p>
	        <p style="font-size:15px">P. 160</p>
	        <input type="hidden" name="bulaklakName" value="Chicharong-Bulaklak">
	        <input type="number" id="bulaklakquantity" name="bulaklakquantity" min="0" max="10"value="0">
	        </div>
	        
	  		<div class="column-others">
	        <img src ="foodimg/logo.png" style ="height:120px; width:120px;border-radius:25%">
	        <p style="font-size:15px">Chicken Oil</p>
	        <p style="font-size:15px">P. 90</p>
	        <input type="hidden" name="oilName" value="Chicken-Oil">
	        <input type="number" id="oilquantity" name="oilquantity" min="0" max="10"value="0">
	        </div>
	        
	  		<div class="column-others">
	        <img src ="foodimg/logo.png" style ="height:120px; width:120px;border-radius:25%">
	        <p style="font-size:15px">Crunchy Garlic</p>
	        <p style="font-size:15px">P. 50</p>
	        <input type="hidden" name="garlicName" value="Crunchy-Garlic">
	        <input type="number" id="garlicquantity" name="garlicquantity" min="0" max="10"value="0">
	        </div>
	        
	  		<div class="column-others">
	        <img src ="foodimg/cheese hungarian sausage.png" style ="height:120px; width:120px;border-radius:25%;border-radius:25%">
	        <p style="font-size:15px">Hungarian Cheese</p>
	        <p style="font-size:15px">P. 300</p>
	        <input type="hidden" name="cheeseName" value="Hungarian-Cheese">
	        <input type="number" id="cheesequantity" name="cheesequantity" min="0" max="10"value="0">
	        </div>
	        
	  		<div class="column-others">
	        <img src ="foodimg/hungarian sausage.png" style ="height:120px; width:120px;border-radius:25%">
	        <p style="font-size:15px">Hungarian sausage</p>
	        <p style="font-size:15px">P. 300</p>
	        <input type="hidden" name="sausageName" value="Hungarian-Sausage">
	        <input type="number" id="sausagequantity" name="sausagequantity" min="0" max="10"value="0">
	        </div>
	       
    </div>
	
	</div>
	</div>
	</form>
<!--FOOTER-->
<footer>
	<div class="social-links">
		<h3>Contact Us!</h3>
	  <a href="https://www.instagram.com/kambal_kusina/"><i class="fab fa-instagram"></i></a>
	  <a href="https://www.facebook.com/KambalKusinaByKathie/"><i class="fab fa-facebook"></i></a>
	  <a href="http://m.me/KambalKusinaByKathie/"><i class="fab fa-facebook-messenger"></i></a>
	</div>
  </footer>
  <span class="copyright"
	>2022 &copy; All rights reserved by Kambal Kusina</span>


  <script src="https://unpkg.com/scrollreveal"></script>
  <script src="js/script.js"></script>

<script>
//Siomai
var modal = document.getElementById("myModalSiomai");
var btn = document.getElementById("mySiomai");
var span = document.getElementsByClassName("close")[0];

//Chicken
var modal3 = document.getElementById("myModalChicken");
var btn3 = document.getElementById("myChicken")
var span3 = document.getElementsByClassName("close")[1];

//Meat
var modal1 = document.getElementById("myModalMeat");
var btn1 = document.getElementById("myMeat")
var span1 = document.getElementsByClassName("close")[2];

//Promeat
var modal4 = document.getElementById("myModalPromeat");
var btn4 = document.getElementById("myPromeat")
var span4 = document.getElementsByClassName("close")[3];

//Potato
var modal2 = document.getElementById("myModalPotato");
var btn2 = document.getElementById("myPotato")
var span2 = document.getElementsByClassName("close")[4];

//Others
var modal5= document.getElementById("myModalOthers")
var btn5= document.getElementById("myOthers")
var span5 = document.getElementsByClassName("close")[5];

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
	
btn3.onclick = function() {
	modal3.style.display = "block";
	}
	// When the user clicks on <span> (x), close the modal
	span3.onclick = function() {
	modal3.style.display = "none";
	}
	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		if (event.target == modal3) {
		   modal3.style.display = "none";
		}
	}

btn1.onclick = function() {
	modal1.style.display = "block";
	}
	// When the user clicks on <span> (x), close the modal
	span1.onclick = function() {
	modal1.style.display = "none";
	}
	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		if (event.target == modal1) {
		modal1.style.display = "none";
		}
	}	
btn4.onclick = function() {
	modal4.style.display = "block";
	}
	// When the user clicks on <span> (x), close the modal
	span4.onclick = function() {
	modal4.style.display = "none";
	}
	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		if (event.target == modal4) {
			  modal4.style.display = "none";
		}
	}

btn2.onclick = function() {
	modal2.style.display = "block";
	}
	// When the user clicks on <span> (x), close the modal
	span2.onclick = function() {
	modal2.style.display = "none";
	}
	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		if (event.target == modal2) {
			modal2.style.display = "none";
		}
	}

btn5.onclick = function() {
	modal5.style.display = "block";
	}
	// When the user clicks on <span> (x), close the modal
	span5.onclick = function() {
	modal5.style.display = "none";
	}
	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		if (event.target == modal5) {
		    modal5.style.display = "none";
		}
	}
	 // Get the img object using its Id
	 img = document.getElementById("SiomaiImg");
      // Function to increase image size
      function enlargeImg() {
        // Set image size to 1.5 times original
        img.style.transform = "scale(1.5)";
        // Animation effect 
        img.style.transition = "transform 0.25s ease";
      }
      // Function to reset image size
      function resetImg() {
        // Set image size to original
        img.style.transform = "scale(1)";
        img.style.transition = "transform 0.25s ease";
      }
</script>
</body>
</html> 