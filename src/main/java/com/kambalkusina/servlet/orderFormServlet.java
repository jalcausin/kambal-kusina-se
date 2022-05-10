package com.kambalkusina.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/orderForm")
public class orderFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		LocalDateTime date = LocalDateTime.now();     //Today
        LocalDateTime exp = date.plusDays(1); 
		//beef Siomai
		String beef = request.getParameter("beefquantity");
		String beefName = request.getParameter("beefName");
		int beefSiomai = Integer.parseInt(beef);
		int beefPrice = 90;
		int beefTotal = beefSiomai * beefPrice;
		//Chicken Siomai
		String chicken = request.getParameter("chickenquantity");
		String chickenName = request.getParameter("chickenName");
		int chickenSiomai = Integer.parseInt(chicken);
		int chickenPrice = 90;
		int chickenTotal = chickenSiomai * chickenPrice;
		//Pork Siomai
		String pork = request.getParameter("porkquantity");
		String porkName = request.getParameter("porkName");
		int porkSiomai = Integer.parseInt(pork);
		int porkPrice = 90;
		int porkTotal = porkSiomai * porkPrice;
		//Japanese Siomai
		String japanese = request.getParameter("japanesequantity");
		String japaneseName = request.getParameter("japaneseName");
		int japaneseSiomai = Integer.parseInt(japanese);
		int japanesePrice = 110;
		int japaneseTotal = japaneseSiomai * japanesePrice;
		//Pork Dumpling Gyoza
		String porkGyoza = request.getParameter("dumplinggyozaquantity");
		String porkGyozaName = request.getParameter("porkGyozaName");
		int porkGyozaSiomai = Integer.parseInt(porkGyoza);
		int porkGyozaPrice = 90;
		int porkGyozaTotal = porkGyozaSiomai * porkGyozaPrice;
		//Siopao Asado - Jumbo 10
		String siopaoAsado = request.getParameter("asadojumboquantity");
		String siopaoAsadoName = request.getParameter("asadoJumboName");
		int siopaoAsadoDimsum = Integer.parseInt(siopaoAsado);
		int siopaoAsadoPrice = 170;
		int siopaoAsadoTotal = siopaoAsadoDimsum * siopaoAsadoPrice;
		//Siopao Asado - Mini 24
		String siopaoAsadoM = request.getParameter("asadominiquantity");
		String siopaoAsadoMName = request.getParameter("asadoMiniName");
		int siopaoAsadoMDimsum = Integer.parseInt(siopaoAsadoM);
		int siopaoAsadoMPrice = 170;
		int siopaoAsadoMTotal = siopaoAsadoMDimsum * siopaoAsadoMPrice;
		//Siopao Bola Bola - Jumbo 10
		String siopaoBolabola = request.getParameter("bolajumboquantity");
		String siopaoBolabolaName = request.getParameter("bolabolaJumboName");
		int siopaoBolabolaDimsum = Integer.parseInt(siopaoBolabola);
		int siopaoBolabolaPrice = 170;
		int siopaoBolabolaTotal = siopaoBolabolaDimsum * siopaoBolabolaPrice;
		//Siopao Bola Bola - Mini 24
		String siopaoBolabolaM = request.getParameter("bolaminiquantity");
		String siopaoBolabolaMName = request.getParameter("bolabolaMiniName");
		int siopaoBolabolaMDimsum = Integer.parseInt(siopaoBolabolaM);
		int siopaoBolabolaMPrice = 170;
		int siopaoBolabolaMTotal = siopaoBolabolaMDimsum * siopaoBolabolaMPrice;
		//Siopao Asado - Jumbo 10
		String siopaoCAsado = request.getParameter("chickenasadominiquantity");
		String siopaoCAsadoName = request.getParameter("chickenAsadoName");
		int siopaoCAsadoDimsum = Integer.parseInt(siopaoCAsado);
		int siopaoCAsadoPrice = 170;
		int siopaoCAsadoTotal = siopaoCAsadoDimsum * siopaoCAsadoPrice;
		//Siopao Asado - Jumbo 10
		String gyoza = request.getParameter("gyozaquantity");
		String gyozaName = request.getParameter("gyozaName");
		int gyozaDimsum = Integer.parseInt(gyoza);
		int gyozaPrice = 170;
		int gyozaTotal = gyozaDimsum * gyozaPrice;
		
		//MEAT
		//Bacon Premium
		String bacon = request.getParameter("baconpremiumquantity");
		String baconName = request.getParameter("baconPremiumName");
		int baconMeat = Integer.parseInt(bacon);
		int baconPrice = 240;
		int baconTotal = baconMeat * baconPrice;
		//Beef Tapa
		String beefTapa = request.getParameter("beefTapaquantity");
		String beefTapaName = request.getParameter("beefTapaName");
		int beefTapaMeat = Integer.parseInt(beefTapa);
		int beefTapaPrice = 310;
		int beefTapaTotal = beefTapaMeat * beefTapaPrice;
		//BK Unmolded Patty
		String bkUnmolded = request.getParameter("bkUnmoldedquantity");
		String bkUnmoldedName = request.getParameter("bkUnmoldedName");
		int bkUnmoldedMeat = Integer.parseInt(bkUnmolded);
		int bkUnmoldedPrice = 210;
		int bkUnmoldedTotal = bkUnmoldedMeat * bkUnmoldedPrice;
		//Burger Patties
		String burgerPatties = request.getParameter("burgerPattiesquantity");
		String burgerPattiesName = request.getParameter("burgerPattiesName");
		int burgerPattiesMeat = Integer.parseInt(burgerPatties);
		int burgerPattiesPrice = 220;
		int burgerPattiesTotal = burgerPattiesMeat * burgerPattiesPrice;
		//Burger Patties Unmolded
		String bpUnmolded = request.getParameter("bpUnmoldedquantity");
		String bpUnmoldedName = request.getParameter("bpUnmoldedName");
		int bpUnmoldedMeat = Integer.parseInt(bpUnmolded);
		int bpUnmoldedPrice = 210;
		int bpUnmoldedTotal = bpUnmoldedMeat * bpUnmoldedPrice;
		//Embutido
		String embutido = request.getParameter("embutidoquantity");
		String embutidoName = request.getParameter("embutidoName");
		int embutidoMeat = Integer.parseInt(embutido);
		int embutidoPrice = 115;
		int embutidoTotal = embutidoMeat * embutidoPrice;
		//Jollibee Hotdog
		String jHotdog = request.getParameter("jHotdogquantity");
		String jHotdogName = request.getParameter("jHotdogName");
		int jHotdogMeat = Integer.parseInt(jHotdog);
		int jHotdogPrice = 210;
		int jHotdogTotal = jHotdogMeat * jHotdogPrice;
		//Jollibee Longganisa
		String jLongga = request.getParameter("jLonggaquantity");
		String jLonggaName = request.getParameter("jLonggaName");
		int jLonggaMeat = Integer.parseInt(jLongga);
		int jLonggaPrice = 220;
		int jLonggaTotal = jLonggaMeat * jLonggaPrice;
		//Longga Lucban
		String longgaLucban = request.getParameter("longgaLucbanquantity");
		String longgaLucbanName = request.getParameter("longgaLucbanName");
		int longgaLucbanMeat = Integer.parseInt(longgaLucban);
		int longgaLucbanPrice = 150;
		int longgaLucbanTotal = longgaLucbanMeat * longgaLucbanPrice;
		//Longga Vigan
		String longgaVigan = request.getParameter("longgaViganquantity");
		String longgaViganName = request.getParameter("longgaViganName");
		int longgaViganMeat = Integer.parseInt(longgaVigan);
		int longgaViganPrice = 150;
		int longgaViganTotal = longgaViganMeat * longgaViganPrice;
		//Pork Tonkatsu
		String porkTonkatsu = request.getParameter("porkTonkatsuquantity");
		String porkTonkatsuName = request.getParameter("porkTonkatsuName");
		int porkTonkatsuMeat = Integer.parseInt(porkTonkatsu);
		int porkTonkatsuPrice = 150;
		int porkTonkatsuTotal = porkTonkatsuMeat * porkTonkatsuPrice;
		
		
		//PROMEAT
		//Promeat Corned Beef 1/2k
		String cornedBeef = request.getParameter("cornedBeefquantity");
		String cornedBeefName = request.getParameter("cornedBeefName");
		int cornedBeefPromeat = Integer.parseInt(cornedBeef);
		int cornedBeefPrice = 150;
		int cornedBeefTotal = cornedBeefPromeat * cornedBeefPrice;
		//Promeat-Corned-Beef 1k
		String cornedBeef1 = request.getParameter("cornedBeef1quantity");
		String cornedBeef1Name = request.getParameter("cornedBeef1Name");
		int cornedBeef1Promeat = Integer.parseInt(cornedBeef1);
		int cornedBeef1Price = 290;
		int cornedBeef1Total = cornedBeef1Promeat * cornedBeef1Price;
		//Promeat Glazed Ham
		String glazedHam = request.getParameter("glazedHamquantity");
		String glazedHamName = request.getParameter("glazedHamName");
		int glazedHamPromeat = Integer.parseInt(glazedHam);
		int glazedHamPrice = 250;
		int glazedHamTotal = glazedHamPromeat * glazedHamPrice;
		//Promeat Glazed Ham Loaf
		String glazedHamLoaf = request.getParameter("glazedHamLoafquantity");
		String glazedHamLoafName = request.getParameter("glazedHamLoafName");
		int glazedHamLoafPromeat = Integer.parseInt(glazedHamLoaf);
		int glazedHamLoafPrice = 710;
		int glazedHamLoafTotal = glazedHamLoafPromeat * glazedHamLoafPrice;
		//Promeat Spam Ham
		String spamHam = request.getParameter("spamHamquantity");
		String spamHamName = request.getParameter("spamHamName");
		int spamHamPromeat = Integer.parseInt(spamHam);
		int spamHamPrice = 250;
		int spamHamTotal = spamHamPromeat * spamHamPrice;
		//Promeat Spam Ham Loaf
		String spamHamLoaf= request.getParameter("spamHamLoafquantity");
		String spamHamLoafName = request.getParameter("spamHamLoafName");
		int spamHamLoafPromeat = Integer.parseInt(spamHamLoaf);
		int spamHamLoafPrice = 600;
		int spamHamLoafTotal = spamHamLoafPromeat * spamHamLoafPrice;
		
		//Chicken
		//Chicken Skin Spicy
		String skinSpicy = request.getParameter("skinSpicyquantity");
		String skinSpicyName = request.getParameter("skinSpicyName");
		int skinSpicyChicken = Integer.parseInt(skinSpicy);
		int skinSpicyPrice = 135;
		int skinSpicyTotal = skinSpicyChicken * skinSpicyPrice;
		//KFC NB 250 
		String kfcNB250 = request.getParameter("kfcNB250quantity");
		String kfcNB250Name = request.getParameter("kfcNB250Name");
		int kfcNB250Chicken = Integer.parseInt(kfcNB250);
		int kfcNB250Price = 95;
		int kfcNB250Total = kfcNB250Chicken * kfcNB250Price;
		//KFC NB 500
		String kfcNB500 = request.getParameter("kfcNB500quantity");
		String kfcNB500Name = request.getParameter("kfcNB500Name");
		int kfcNB500Chicken = Integer.parseInt(kfcNB500);
		int kfcNB500Price = 180;
		int kfcNB500Total = kfcNB500Chicken * kfcNB500Price;
		//McFillet
		String mcfillet = request.getParameter("mcfilletquantity");
		String mcfilletName = request.getParameter("mcfilletName");
		int mcfilletChicken = Integer.parseInt(mcfillet);
		int mcfilletPrice = 320;
		int mcfilletTotal = mcfilletChicken * mcfilletPrice;
		//McNuggets
		String McNuggets = request.getParameter("McNuggetsquantity");
		String McNuggetsName = request.getParameter("McNuggetsName");
		int McNuggetsChicken = Integer.parseInt(McNuggets);
		int McNuggetsPrice = 290;
		int McNuggetsTotal = McNuggetsChicken * McNuggetsPrice;
		//Chicken Skin Original
		String skinOrig = request.getParameter("skinOrigquantity");
		String skinOrigName = request.getParameter("skinOrigName");
		int skinOrigChicken = Integer.parseInt(skinOrig);
		int skinOrigPrice = 135;
		int skinOrigTotal = skinOrigChicken * skinOrigPrice;
		
		//Patatas Corner
		//Burger King French Fries
		String bkFries = request.getParameter("bkFriesquantity");
		String bkFriesName = request.getParameter("bkFriesName");
		int bkFriesPatatas = Integer.parseInt(bkFries);
		int bkFriesPrice = 160;
		int bkFriesTotal = bkFriesPatatas * bkFriesPrice;
		//French Fries Regular
		String regular = request.getParameter("regularquantity");
		String regularName = request.getParameter("regularName");
		int regularPatatas = Integer.parseInt(regular);
		int regularPrice = 100;
		int regularTotal = regularPatatas * regularPrice;
		//Hashbrown
		String hashbrown = request.getParameter("hashbrownquantity");
		String hashbrownName = request.getParameter("hashbrownName");
		int hashbrownPatatas = Integer.parseInt(hashbrown);
		int hashbrownPrice = 250;
		int hashbrownTotal = hashbrownPatatas * hashbrownPrice;
		//Hashbrown 10s
		String hashbrown10 = request.getParameter("hashbrown10quantity");
		String hashbrown10Name = request.getParameter("hashbrown10Name");
		int hashbrown10Patatas = Integer.parseInt(hashbrown10);
		int hashbrown10Price = 180;
		int hashbrown10Total = hashbrown10Patatas * hashbrown10Price;
		//KFC Fries
		String kfcFries = request.getParameter("kfcFriesquantity");
		String kfcFriesName = request.getParameter("kfcFriesName");
		int kfcFriesPatatas = Integer.parseInt(kfcFries);
		int kfcFriesPrice = 200;
		int kfcFriesTotal = kfcFriesPatatas * kfcFriesPrice;
		//Mojos
		String mojos= request.getParameter("mojosquantity");
		String mojosName = request.getParameter("mojosName");
		int mojosPatatas = Integer.parseInt(mojos);
		int mojosPrice = 200;
		int mojosTotal = mojosPatatas * mojosPrice;
		
		//Others
		//Chowking Fish Fillet
		String fishFillet = request.getParameter("fishFilletquantity");
		String fishFilletName = request.getParameter("fishFilletName");
		int fishFilletOthers = Integer.parseInt(fishFillet);
		int fishFilletPrice = 150;
		int fishFilletTotal = fishFilletOthers * fishFilletPrice;
		//Chicharong Bulaklak
		String bulaklak = request.getParameter("bulaklakquantity");
		String bulaklakName = request.getParameter("bulaklakName");
		int bulaklakOthers = Integer.parseInt(bulaklak);
		int bulaklakPrice = 160;
		int bulaklakTotal = bulaklakOthers * bulaklakPrice;
		//Chicken Oil
		String oil = request.getParameter("oilquantity");
		String oilName = request.getParameter("oilName");
		int oilOthers = Integer.parseInt(oil);
		int oilPrice = 90;
		int oilTotal = oilOthers * oilPrice;
		//Crunchy Garlic
		String garlic = request.getParameter("garlicquantity");
		String garlicName = request.getParameter("garlicName");
		int garlicOthers = Integer.parseInt(garlic);
		int garlicPrice = 50;
		int garlicTotal = garlicOthers * garlicPrice;
		//Hungarian Cheese
		String cheese = request.getParameter("cheesequantity");
		String cheeseName = request.getParameter("cheeseName");
		int cheeseOthers = Integer.parseInt(cheese);
		int cheesePrice = 300;
		int cheeseTotal = cheeseOthers * cheesePrice;
		//Hungarian Sausage
		String sausage = request.getParameter("sausagequantity");
		String sausageName = request.getParameter("sausageName");
		int sausageOthers = Integer.parseInt(sausage);
		int sausagePrice = 300;
		int sausageTotal = sausageOthers * sausagePrice;
		
		RequestDispatcher dispatcher = null;
		Connection con = null;
		
		HttpSession session = request.getSession();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest","root","rootpass123");
			
			//Get Name and Email
			PreparedStatement pst = con.prepareStatement("select * from users where uname = ?");
			
			pst.setString(1, uname);
			
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				String fname = rs.getString(2);
				String lname = rs.getString(3);
				String email = rs.getString(4);
				session.setAttribute("fname", fname);
				session.setAttribute("lname", lname);
				session.setAttribute("email", email);
				session.setAttribute("uname", uname);
			}
			//Update Stocks
			//Siomai
			session.setAttribute("beefSiomai", beefSiomai);
			session.setAttribute("chickenSiomai", chickenSiomai);
			session.setAttribute("japaneseSiomai", japaneseSiomai);
			session.setAttribute("porkSiomai", porkSiomai);
			session.setAttribute("porkGyozaSiomai", porkGyozaSiomai);
			session.setAttribute("siopaoAsadoDimsum", siopaoAsadoDimsum);
			session.setAttribute("siopaoAsadoMDimsum", siopaoAsadoMDimsum);
			session.setAttribute("siopaoBolabolaDimsum", siopaoBolabolaDimsum);
			session.setAttribute("siopaoBolabolaMDimsum", siopaoBolabolaMDimsum);
			session.setAttribute("siopaoCAsadoDimsum", siopaoCAsadoDimsum);
			session.setAttribute("gyozaDimsum", gyozaDimsum);
			
			//Meat
			session.setAttribute("baconMeat", baconMeat);
			session.setAttribute("beefTapaMeat", beefTapaMeat);
			session.setAttribute("bkUnmoldedMeat", bkUnmoldedMeat );
			session.setAttribute("burgerPattiesMeat", burgerPattiesMeat);
			session.setAttribute("bpUnmoldedMeat", bpUnmoldedMeat);
			session.setAttribute("embutidoMeat", embutidoMeat);
			session.setAttribute("jHotdogMeat", jHotdogMeat);
			session.setAttribute("jLonggaMeat", jLonggaMeat);
			session.setAttribute("longgaLucbanMeat", longgaLucbanMeat);
			session.setAttribute("longgaViganMeat", longgaViganMeat);
			session.setAttribute("porkTonkatsuMeat", porkTonkatsuMeat);
			
			//Promeat
			session.setAttribute("cornedBeefPromeat", cornedBeefPromeat);
			session.setAttribute("cornedBeef1Promeat", cornedBeef1Promeat);
			session.setAttribute("glazedHamPromeat", glazedHamPromeat);
			session.setAttribute("glazedHamLoafPromeat", glazedHamLoafPromeat);
			session.setAttribute("spamHamPromeat", spamHamPromeat);
			session.setAttribute("spamHamLoafPromeat", spamHamLoafPromeat);
			
			//Patatas Corner
			session.setAttribute("bkFriesPatatas", bkFriesPatatas);
			session.setAttribute("regularPatatas", regularPatatas);
			session.setAttribute("hashbrownPatatas", hashbrownPatatas);
			session.setAttribute("hashbrown10Patatas", hashbrown10Patatas);
			session.setAttribute("kfcFriesPatatas", kfcFriesPatatas);
			session.setAttribute("mojosPatatas", mojosPatatas);
			
			//Chicken
			session.setAttribute("skinSpicyChicken", skinSpicyChicken);
			session.setAttribute("kfcNB250Chicken", kfcNB250Chicken);
			session.setAttribute("kfcNB500Chicken", kfcNB500Chicken);
			session.setAttribute("mcfilletChicken", mcfilletChicken);
			session.setAttribute("McNuggetsChicken", McNuggetsChicken);
			session.setAttribute("skinOrigChicken", skinOrigChicken);
			
			//Others
			session.setAttribute("fishFilletOthers", fishFilletOthers);
			session.setAttribute("bulaklakOthers", bulaklakOthers);
			session.setAttribute("oilOthers", oilOthers);
			session.setAttribute("garlicOthers", garlicOthers);
			session.setAttribute("cheeseOthers", cheeseOthers);
			session.setAttribute("sausageOthers", sausageOthers);
			//Reset Temp Database
			Statement stmt =  con.createStatement();
			String sql = "DROP TABLE temp";
	        stmt.executeUpdate(sql);
	        stmt.executeUpdate("create table temp (uname varchar(30), product varchar(30), quantity int, total int, datentime varchar(100), datentimeExp varchar(100), orderStatus varchar(10), payment varchar(7))");
			
			//Siomai Orders
			if (beefSiomai > 0) {
				PreparedStatement beefpst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				beefpst.setString(1,  uname);
				beefpst.setString(2, beefName);
				beefpst.setInt(3, beefSiomai);
				beefpst.setInt(4, beefTotal);
				beefpst.setString(5, date.toString());
				beefpst.setString(6, exp.toString());
				beefpst.setString(7, "Processing");
				beefpst.setString(8, "Pending");
				
				int rowCount = beefpst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
				
			}
			if (chickenSiomai > 0) {
				PreparedStatement chickenpst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				chickenpst.setString(1,  uname);
				chickenpst.setString(2, chickenName);
				chickenpst.setInt(3, chickenSiomai);
				chickenpst.setInt(4, chickenTotal);
				chickenpst.setString(5, date.toString());
				chickenpst.setString(6, exp.toString());
				chickenpst.setString(7, "Processing");
				chickenpst.setString(8, "Pending");
				
				int rowCount = chickenpst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			if (porkSiomai > 0) {
				PreparedStatement porkpst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				porkpst.setString(1,  uname);
				porkpst.setString(2, porkName);
				porkpst.setInt(3, porkSiomai);
				porkpst.setInt(4, porkTotal);
				porkpst.setString(5, date.toString());
				porkpst.setString(6, exp.toString());
				porkpst.setString(7, "Processing");
				porkpst.setString(8, "Pending");
				
				int rowCount = porkpst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			if (japaneseSiomai > 0) {
				PreparedStatement japanesepst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				japanesepst.setString(1,  uname);
				japanesepst.setString(2, japaneseName);
				japanesepst.setInt(3, japaneseSiomai);
				japanesepst.setInt(4, japaneseTotal);
				japanesepst.setString(5, date.toString());
				japanesepst.setString(6, exp.toString());
				japanesepst.setString(7, "Processing");
				japanesepst.setString(8, "Pending");
				
				int rowCount = japanesepst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}			
			if (porkGyozaSiomai > 0) {
				PreparedStatement porkGyozapst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				porkGyozapst.setString(1,  uname);
				porkGyozapst.setString(2, porkGyozaName);
				porkGyozapst.setInt(3, porkGyozaSiomai);
				porkGyozapst.setInt(4, porkGyozaTotal);
				porkGyozapst.setString(5, date.toString());
				porkGyozapst.setString(6, exp.toString());
				porkGyozapst.setString(7, "Processing");
				porkGyozapst.setString(8, "Pending");
				
				int rowCount = porkGyozapst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			if (siopaoAsadoDimsum > 0) {
				PreparedStatement siopaoAsadopst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				siopaoAsadopst.setString(1,  uname);
				siopaoAsadopst.setString(2, siopaoAsadoName);
				siopaoAsadopst.setInt(3, siopaoAsadoDimsum);
				siopaoAsadopst.setInt(4, siopaoAsadoTotal);
				siopaoAsadopst.setString(5, date.toString());
				siopaoAsadopst.setString(6, exp.toString());
				siopaoAsadopst.setString(7, "Processing");
				siopaoAsadopst.setString(8, "Pending");
				
				int rowCount = siopaoAsadopst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (siopaoAsadoMDimsum > 0) {
				PreparedStatement siopaoAsadoMpst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				siopaoAsadoMpst.setString(1,  uname);
				siopaoAsadoMpst.setString(2, siopaoAsadoMName);
				siopaoAsadoMpst.setInt(3, siopaoAsadoMDimsum);
				siopaoAsadoMpst.setInt(4, siopaoAsadoMTotal);
				siopaoAsadoMpst.setString(5, date.toString());
				siopaoAsadoMpst.setString(6, exp.toString());
				siopaoAsadoMpst.setString(7, "Processing");
				siopaoAsadoMpst.setString(8, "Pending");
				
				int rowCount = siopaoAsadoMpst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (siopaoBolabolaDimsum > 0) {
				PreparedStatement siopaoBolabolapst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				siopaoBolabolapst.setString(1,  uname);
				siopaoBolabolapst.setString(2, siopaoBolabolaName);
				siopaoBolabolapst.setInt(3, siopaoBolabolaDimsum);
				siopaoBolabolapst.setInt(4, siopaoBolabolaTotal);
				siopaoBolabolapst.setString(5, date.toString());
				siopaoBolabolapst.setString(6, exp.toString());
				siopaoBolabolapst.setString(7, "Processing");
				siopaoBolabolapst.setString(8, "Pending");
				
				int rowCount = siopaoBolabolapst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}

			if (siopaoBolabolaMDimsum > 0) {
				PreparedStatement siopaoBolabolaMpst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				siopaoBolabolaMpst.setString(1,  uname);
				siopaoBolabolaMpst.setString(2, siopaoBolabolaMName);
				siopaoBolabolaMpst.setInt(3, siopaoBolabolaMDimsum);
				siopaoBolabolaMpst.setInt(4, siopaoBolabolaMTotal);
				siopaoBolabolaMpst.setString(5, date.toString());
				siopaoBolabolaMpst.setString(6, exp.toString());
				siopaoBolabolaMpst.setString(7, "Processing");
				siopaoBolabolaMpst.setString(8, "Pending");
				
				int rowCount = siopaoBolabolaMpst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (siopaoCAsadoDimsum > 0) {
				PreparedStatement siopaoCAsadopst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				siopaoCAsadopst.setString(1,  uname);
				siopaoCAsadopst.setString(2, siopaoCAsadoName);
				siopaoCAsadopst.setInt(3, siopaoCAsadoDimsum);
				siopaoCAsadopst.setInt(4, siopaoCAsadoTotal);
				siopaoCAsadopst.setString(5, date.toString());
				siopaoCAsadopst.setString(6, exp.toString());
				siopaoCAsadopst.setString(7, "Processing");
				siopaoCAsadopst.setString(8, "Pending");
				
				int rowCount = siopaoCAsadopst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (gyozaDimsum > 0) {
				PreparedStatement gyozapst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				gyozapst.setString(1,  uname);
				gyozapst.setString(2, gyozaName);
				gyozapst.setInt(3, gyozaDimsum);
				gyozapst.setInt(4, gyozaTotal);
				gyozapst.setString(5, date.toString());
				gyozapst.setString(6, exp.toString());
				gyozapst.setString(7, "Processing");
				gyozapst.setString(8, "Pending");
				
				int rowCount = gyozapst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			//Meat Orders
			if (baconMeat > 0) {
				PreparedStatement baconpst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				baconpst.setString(1,  uname);
				baconpst.setString(2, baconName);
				baconpst.setInt(3, baconMeat);
				baconpst.setInt(4, baconTotal);
				baconpst.setString(5, date.toString());
				baconpst.setString(6, exp.toString());
				baconpst.setString(7, "Processing");
				baconpst.setString(8, "Pending");
				
				int rowCount = baconpst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (beefTapaMeat > 0) {
				PreparedStatement beeftapapst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				beeftapapst.setString(1,  uname);
				beeftapapst.setString(2, beefTapaName);
				beeftapapst.setInt(3, beefTapaMeat);
				beeftapapst.setInt(4, beefTapaTotal);
				beeftapapst.setString(5, date.toString());
				beeftapapst.setString(6, exp.toString());
				beeftapapst.setString(7, "Processing");
				beeftapapst.setString(8, "Pending");
				
				int rowCount = beeftapapst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (bkUnmoldedMeat > 0) {
				PreparedStatement bkUnmoldedpst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				bkUnmoldedpst.setString(1,  uname);
				bkUnmoldedpst.setString(2, bkUnmoldedName);
				bkUnmoldedpst.setInt(3, bkUnmoldedMeat);
				bkUnmoldedpst.setInt(4, bkUnmoldedTotal);
				bkUnmoldedpst.setString(5, date.toString());
				bkUnmoldedpst.setString(6, exp.toString());
				bkUnmoldedpst.setString(7, "Processing");
				bkUnmoldedpst.setString(8, "Pending");
				
				int rowCount = bkUnmoldedpst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (burgerPattiesMeat > 0) {
				PreparedStatement burgerPattiespst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				burgerPattiespst.setString(1,  uname);
				burgerPattiespst.setString(2, burgerPattiesName);
				burgerPattiespst.setInt(3, burgerPattiesMeat);
				burgerPattiespst.setInt(4, burgerPattiesTotal);
				burgerPattiespst.setString(5, date.toString());
				burgerPattiespst.setString(6, exp.toString());
				burgerPattiespst.setString(7, "Processing");
				burgerPattiespst.setString(8, "Pending");
				
				int rowCount = burgerPattiespst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (bpUnmoldedMeat > 0) {
				PreparedStatement bpUnmoldedpst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				bpUnmoldedpst.setString(1,  uname);
				bpUnmoldedpst.setString(2, bpUnmoldedName);
				bpUnmoldedpst.setInt(3, bpUnmoldedMeat);
				bpUnmoldedpst.setInt(4, bpUnmoldedTotal);
				bpUnmoldedpst.setString(5, date.toString());
				bpUnmoldedpst.setString(6, exp.toString());
				bpUnmoldedpst.setString(7, "Processing");
				bpUnmoldedpst.setString(8, "Pending");
				
				int rowCount = bpUnmoldedpst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (embutidoMeat > 0) {
				PreparedStatement embutidopst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				embutidopst.setString(1,  uname);
				embutidopst.setString(2, embutidoName);
				embutidopst.setInt(3, embutidoMeat);
				embutidopst.setInt(4, embutidoTotal);
				embutidopst.setString(5, date.toString());
				embutidopst.setString(6, exp.toString());
				embutidopst.setString(7, "Processing");
				embutidopst.setString(8, "Pending");
				
				int rowCount = embutidopst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (jHotdogMeat > 0) {
				PreparedStatement jHotdogpst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				jHotdogpst.setString(1,  uname);
				jHotdogpst.setString(2, jHotdogName);
				jHotdogpst.setInt(3, jHotdogMeat);
				jHotdogpst.setInt(4, jHotdogTotal);
				jHotdogpst.setString(5, date.toString());
				jHotdogpst.setString(6, exp.toString());
				jHotdogpst.setString(7, "Processing");
				jHotdogpst.setString(8, "Pending");
				
				int rowCount = jHotdogpst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (jLonggaMeat > 0) {
				PreparedStatement jLonggapst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				jLonggapst.setString(1,  uname);
				jLonggapst.setString(2, jLonggaName);
				jLonggapst.setInt(3, jLonggaMeat);
				jLonggapst.setInt(4, jLonggaTotal);
				jLonggapst.setString(5, date.toString());
				jLonggapst.setString(6, exp.toString());
				jLonggapst.setString(7, "Processing");
				jLonggapst.setString(8, "Pending");
				
				int rowCount = jLonggapst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (longgaLucbanMeat > 0) {
				PreparedStatement longgaLucbanpst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				longgaLucbanpst.setString(1,  uname);
				longgaLucbanpst.setString(2, longgaLucbanName);
				longgaLucbanpst.setInt(3, longgaLucbanMeat);
				longgaLucbanpst.setInt(4, longgaLucbanTotal);
				longgaLucbanpst.setString(5, date.toString());
				longgaLucbanpst.setString(6, exp.toString());
				longgaLucbanpst.setString(7, "Processing");
				longgaLucbanpst.setString(8, "Pending");
				
				int rowCount = longgaLucbanpst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (longgaViganMeat > 0) {
				PreparedStatement longgaViganpst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				longgaViganpst.setString(1,  uname);
				longgaViganpst.setString(2, longgaViganName);
				longgaViganpst.setInt(3, longgaViganMeat);
				longgaViganpst.setInt(4, longgaViganTotal);
				longgaViganpst.setString(5, date.toString());
				longgaViganpst.setString(6, exp.toString());
				longgaViganpst.setString(7, "Processing");
				longgaViganpst.setString(8, "Pending");
				
				int rowCount = longgaViganpst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (porkTonkatsuMeat > 0) {
				PreparedStatement porkTonkatsupst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				porkTonkatsupst.setString(1,  uname);
				porkTonkatsupst.setString(2, porkTonkatsuName);
				porkTonkatsupst.setInt(3, porkTonkatsuMeat);
				porkTonkatsupst.setInt(4, porkTonkatsuTotal);
				porkTonkatsupst.setString(5, date.toString());
				porkTonkatsupst.setString(6, exp.toString());
				porkTonkatsupst.setString(7, "Processing");
				porkTonkatsupst.setString(8, "Pending");
				
				int rowCount = porkTonkatsupst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (cornedBeefPromeat > 0) {
				PreparedStatement cornedBeefpst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				cornedBeefpst.setString(1,  uname);
				cornedBeefpst.setString(2, cornedBeefName);
				cornedBeefpst.setInt(3, cornedBeefPromeat);
				cornedBeefpst.setInt(4, cornedBeefTotal);
				cornedBeefpst.setString(5, date.toString());
				cornedBeefpst.setString(6, exp.toString());
				cornedBeefpst.setString(7, "Processing");
				cornedBeefpst.setString(8, "Pending");
				
				int rowCount = cornedBeefpst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (cornedBeef1Promeat > 0) {
				PreparedStatement cornedBeef1pst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				cornedBeef1pst.setString(1,  uname);
				cornedBeef1pst.setString(2, cornedBeef1Name);
				cornedBeef1pst.setInt(3, cornedBeef1Promeat);
				cornedBeef1pst.setInt(4, cornedBeef1Total);
				cornedBeef1pst.setString(5, date.toString());
				cornedBeef1pst.setString(6, exp.toString());
				cornedBeef1pst.setString(7, "Processing");
				cornedBeef1pst.setString(8, "Pending");
				
				int rowCount = cornedBeef1pst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (glazedHamPromeat > 0) {
				PreparedStatement glazedHampst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				glazedHampst.setString(1,  uname);
				glazedHampst.setString(2, glazedHamName);
				glazedHampst.setInt(3, glazedHamPromeat);
				glazedHampst.setInt(4, glazedHamTotal);
				glazedHampst.setString(5, date.toString());
				glazedHampst.setString(6, exp.toString());
				glazedHampst.setString(7, "Processing");
				glazedHampst.setString(8, "Pending");
				
				int rowCount = glazedHampst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (glazedHamLoafPromeat > 0) {
				PreparedStatement glazedHamLoafpst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				glazedHamLoafpst.setString(1,  uname);
				glazedHamLoafpst.setString(2, glazedHamLoafName);
				glazedHamLoafpst.setInt(3, glazedHamLoafPromeat);
				glazedHamLoafpst.setInt(4, glazedHamLoafTotal);
				glazedHamLoafpst.setString(5, date.toString());
				glazedHamLoafpst.setString(6, exp.toString());
				glazedHamLoafpst.setString(7, "Processing");
				glazedHamLoafpst.setString(8, "Pending");
				
				int rowCount = glazedHamLoafpst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (spamHamPromeat > 0) {
				PreparedStatement spamHampst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				spamHampst.setString(1,  uname);
				spamHampst.setString(2, spamHamName);
				spamHampst.setInt(3, spamHamPromeat);
				spamHampst.setInt(4, spamHamTotal);
				spamHampst.setString(5, date.toString());
				spamHampst.setString(6, exp.toString());
				spamHampst.setString(7, "Processing");
				spamHampst.setString(8, "Pending");
				
				int rowCount = spamHampst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (spamHamLoafPromeat > 0) {
				PreparedStatement spamHamLoafpst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				spamHamLoafpst.setString(1,  uname);
				spamHamLoafpst.setString(2, spamHamLoafName);
				spamHamLoafpst.setInt(3, spamHamLoafPromeat);
				spamHamLoafpst.setInt(4, spamHamLoafTotal);
				spamHamLoafpst.setString(5, date.toString());
				spamHamLoafpst.setString(6, exp.toString());
				spamHamLoafpst.setString(7, "Processing");
				spamHamLoafpst.setString(8, "Pending");
				
				int rowCount = spamHamLoafpst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (skinSpicyChicken > 0) {
				PreparedStatement skinSpicypst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				skinSpicypst.setString(1,  uname);
				skinSpicypst.setString(2, skinSpicyName);
				skinSpicypst.setInt(3, skinSpicyChicken);
				skinSpicypst.setInt(4, skinSpicyTotal);
				skinSpicypst.setString(5, date.toString());
				skinSpicypst.setString(6, exp.toString());
				skinSpicypst.setString(7, "Processing");
				skinSpicypst.setString(8, "Pending");
				
				int rowCount = skinSpicypst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (kfcNB250Chicken > 0) {
				PreparedStatement kfcNB250pst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				kfcNB250pst.setString(1,  uname);
				kfcNB250pst.setString(2, kfcNB250Name);
				kfcNB250pst.setInt(3, kfcNB250Chicken);
				kfcNB250pst.setInt(4, kfcNB250Total);
				kfcNB250pst.setString(5, date.toString());
				kfcNB250pst.setString(6, exp.toString());
				kfcNB250pst.setString(7, "Processing");
				kfcNB250pst.setString(8, "Pending");
				
				int rowCount = kfcNB250pst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (kfcNB500Chicken > 0) {
				PreparedStatement kfcNB500pst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				kfcNB500pst.setString(1,  uname);
				kfcNB500pst.setString(2, kfcNB500Name);
				kfcNB500pst.setInt(3, kfcNB500Chicken);
				kfcNB500pst.setInt(4, kfcNB500Total);
				kfcNB500pst.setString(5, date.toString());
				kfcNB500pst.setString(6, exp.toString());
				kfcNB500pst.setString(7, "Processing");
				kfcNB500pst.setString(8, "Pending");
				
				int rowCount = kfcNB500pst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (mcfilletChicken > 0) {
				PreparedStatement mcfilletpst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				mcfilletpst.setString(1,  uname);
				mcfilletpst.setString(2, mcfilletName);
				mcfilletpst.setInt(3, mcfilletChicken);
				mcfilletpst.setInt(4, mcfilletTotal);
				mcfilletpst.setString(5, date.toString());
				mcfilletpst.setString(6, exp.toString());
				mcfilletpst.setString(7, "Processing");
				mcfilletpst.setString(8, "Pending");
				
				int rowCount = mcfilletpst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (McNuggetsChicken > 0) {
				PreparedStatement McNuggetspst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				McNuggetspst.setString(1,  uname);
				McNuggetspst.setString(2, McNuggetsName);
				McNuggetspst.setInt(3, McNuggetsChicken);
				McNuggetspst.setInt(4, McNuggetsTotal);
				McNuggetspst.setString(5, date.toString());
				McNuggetspst.setString(6, exp.toString());
				McNuggetspst.setString(7, "Processing");
				McNuggetspst.setString(8, "Pending");
				
				int rowCount = McNuggetspst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (skinOrigChicken > 0) {
				PreparedStatement skinOrigpst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				skinOrigpst.setString(1,  uname);
				skinOrigpst.setString(2, skinOrigName);
				skinOrigpst.setInt(3, skinOrigChicken);
				skinOrigpst.setInt(4, skinOrigTotal);
				skinOrigpst.setString(5, date.toString());
				skinOrigpst.setString(6, exp.toString());
				skinOrigpst.setString(7, "Processing");
				skinOrigpst.setString(8, "Pending");
				
				int rowCount = skinOrigpst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (bkFriesPatatas > 0) {
				PreparedStatement bkFriespst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				bkFriespst.setString(1,  uname);
				bkFriespst.setString(2, bkFriesName);
				bkFriespst.setInt(3, bkFriesPatatas);
				bkFriespst.setInt(4, bkFriesTotal);
				bkFriespst.setString(5, date.toString());
				bkFriespst.setString(6, exp.toString());
				bkFriespst.setString(7, "Processing");
				bkFriespst.setString(8, "Pending");
				
				int rowCount = bkFriespst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (regularPatatas > 0) {
				PreparedStatement regularpst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				regularpst.setString(1,  uname);
				regularpst.setString(2, regularName);
				regularpst.setInt(3, regularPatatas);
				regularpst.setInt(4, regularTotal);
				regularpst.setString(5, date.toString());
				regularpst.setString(6, exp.toString());
				regularpst.setString(7, "Processing");
				regularpst.setString(8, "Pending");
				
				int rowCount = regularpst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (hashbrownPatatas > 0) {
				PreparedStatement hashbrownpst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				hashbrownpst.setString(1,  uname);
				hashbrownpst.setString(2, hashbrownName);
				hashbrownpst.setInt(3, hashbrownPatatas);
				hashbrownpst.setInt(4, hashbrownTotal);
				hashbrownpst.setString(5, date.toString());
				hashbrownpst.setString(6, exp.toString());
				hashbrownpst.setString(7, "Processing");
				hashbrownpst.setString(8, "Pending");
				
				int rowCount = hashbrownpst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (hashbrown10Patatas > 0) {
				PreparedStatement hashbrown10pst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				hashbrown10pst.setString(1,  uname);
				hashbrown10pst.setString(2, hashbrown10Name);
				hashbrown10pst.setInt(3, hashbrown10Patatas);
				hashbrown10pst.setInt(4, hashbrown10Total);
				hashbrown10pst.setString(5, date.toString());
				hashbrown10pst.setString(6, exp.toString());
				hashbrown10pst.setString(7, "Processing");
				hashbrown10pst.setString(8, "Pending");
				
				int rowCount = hashbrown10pst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (kfcFriesPatatas > 0) {
				PreparedStatement kfcFriespst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				kfcFriespst.setString(1,  uname);
				kfcFriespst.setString(2, kfcFriesName);
				kfcFriespst.setInt(3, kfcFriesPatatas);
				kfcFriespst.setInt(4, kfcFriesTotal);
				kfcFriespst.setString(5, date.toString());
				kfcFriespst.setString(6, exp.toString());
				kfcFriespst.setString(7, "Processing");
				kfcFriespst.setString(8, "Pending");
				
				int rowCount = kfcFriespst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (mojosPatatas > 0) {
				PreparedStatement mojospst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				mojospst.setString(1,  uname);
				mojospst.setString(2, mojosName);
				mojospst.setInt(3, mojosPatatas);
				mojospst.setInt(4, mojosTotal);
				mojospst.setString(5, date.toString());
				mojospst.setString(6, exp.toString());
				mojospst.setString(7, "Processing");
				mojospst.setString(8, "Pending");
				
				int rowCount = mojospst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (fishFilletOthers > 0) {
				PreparedStatement fishFilletpst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				fishFilletpst.setString(1,  uname);
				fishFilletpst.setString(2, fishFilletName);
				fishFilletpst.setInt(3, fishFilletOthers);
				fishFilletpst.setInt(4, fishFilletTotal);
				fishFilletpst.setString(5, date.toString());
				fishFilletpst.setString(6, exp.toString());
				fishFilletpst.setString(7, "Processing");
				fishFilletpst.setString(8, "Pending");
				
				int rowCount = fishFilletpst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (bulaklakOthers > 0) {
				PreparedStatement bulaklakpst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				bulaklakpst.setString(1,  uname);
				bulaklakpst.setString(2, bulaklakName);
				bulaklakpst.setInt(3, bulaklakOthers);
				bulaklakpst.setInt(4, bulaklakTotal);
				bulaklakpst.setString(5, date.toString());
				bulaklakpst.setString(6, exp.toString());
				bulaklakpst.setString(7, "Processing");
				bulaklakpst.setString(8, "Pending");
				
				int rowCount = bulaklakpst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (oilOthers > 0) {
				PreparedStatement oilpst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				oilpst.setString(1,  uname);
				oilpst.setString(2, oilName);
				oilpst.setInt(3, oilOthers);
				oilpst.setInt(4, oilTotal);
				oilpst.setString(5, date.toString());
				oilpst.setString(6, exp.toString());
				oilpst.setString(7, "Processing");
				oilpst.setString(8, "Pending");
				
				int rowCount = oilpst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (garlicOthers > 0) {
				PreparedStatement garlicpst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				garlicpst.setString(1,  uname);
				garlicpst.setString(2, garlicName);
				garlicpst.setInt(3, garlicOthers);
				garlicpst.setInt(4, garlicTotal);
				garlicpst.setString(5, date.toString());
				garlicpst.setString(6, exp.toString());
				garlicpst.setString(7, "Processing");
				garlicpst.setString(8, "Pending");
				
				int rowCount = garlicpst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (cheeseOthers > 0) {
				PreparedStatement cheesepst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				cheesepst.setString(1,  uname);
				cheesepst.setString(2, cheeseName);
				cheesepst.setInt(3, cheeseOthers);
				cheesepst.setInt(4, cheeseTotal);
				cheesepst.setString(5, date.toString());
				cheesepst.setString(6, exp.toString());
				cheesepst.setString(7, "Processing");
				cheesepst.setString(8, "Pending");
				
				int rowCount = cheesepst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			if (sausageOthers > 0) {
				PreparedStatement sausagepst = con.prepareStatement("insert into temp(uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) value(?,?,?,?,?,?,?,?)");
				sausagepst.setString(1,  uname);
				sausagepst.setString(2, sausageName);
				sausagepst.setInt(3, sausageOthers);
				sausagepst.setInt(4, sausageTotal);
				sausagepst.setString(5, date.toString());
				sausagepst.setString(6, exp.toString());
				sausagepst.setString(7, "Processing");
				sausagepst.setString(8, "Pending");
				
				int rowCount = sausagepst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
			}
			
			dispatcher = request.getRequestDispatcher("confirmOrderPage.jsp");
			dispatcher.forward(request,response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
