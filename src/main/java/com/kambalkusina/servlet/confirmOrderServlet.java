package com.kambalkusina.servlet;

import java.io.IOException;
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


@WebServlet("/confirmOrder")
public class confirmOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LocalDateTime date = LocalDateTime.now();     //Today
        LocalDateTime exp = date.plusDays(1); 
		String fullName = request.getParameter("fullName");
		String email = request.getParameter("email");
		String uname = request.getParameter("uname");
		String contact = request.getParameter("contact");
		String address = request.getParameter("address");
		
		//Quantity
		//Dimsum
		String beef = request.getParameter("beefSiomai");
		int beefSiomai = Integer.parseInt(beef);
		String chicken = request.getParameter("chickenSiomai");
		int chickenSiomai = Integer.parseInt(chicken);
		String japanese = request.getParameter("japaneseSiomai");
		int japaneseSiomai = Integer.parseInt(japanese);
		String pork = request.getParameter("porkSiomai");
		int porkSiomai = Integer.parseInt(pork);
		String porkGyoza = request.getParameter("porkGyozaSiomai");
		int porkGyozaSiomai = Integer.parseInt(porkGyoza);
		String siopaoAsado = request.getParameter("siopaoAsadoDimsum");
		int siopaoAsadoDimsum = Integer.parseInt(siopaoAsado);
		String siopaoAsadoM = request.getParameter("siopaoAsadoMDimsum");
		int siopaoAsadoMDimsum = Integer.parseInt(siopaoAsadoM);
		String siopaoBolabola = request.getParameter("siopaoBolabolaDimsum");
		int siopaoBolabolaDimsum = Integer.parseInt(siopaoBolabola);
		String siopaoBolabolaM = request.getParameter("siopaoBolabolaMDimsum");
		int siopaoBolabolaMDimsum = Integer.parseInt(siopaoBolabolaM);
		String siopaoCAsado = request.getParameter("siopaoCAsadoDimsum");
		int siopaoCAsadoDimsum = Integer.parseInt(siopaoCAsado);
		String gyoza = request.getParameter("gyozaDimsum");
		int gyozaDimsum = Integer.parseInt(gyoza);
		
		//Meat
		String bacon = request.getParameter("baconMeat");
		int baconMeat = Integer.parseInt(bacon);
		String  beefTapa = request.getParameter("beefTapaMeat");
		int beefTapaMeat = Integer.parseInt(beefTapa);
		String bkUnmolded = request.getParameter("bkUnmoldedMeat");
		int bkUnmoldedMeat = Integer.parseInt(bkUnmolded);
		String burgerPatties = request.getParameter("burgerPattiesMeat");
		int burgerPattiesMeat = Integer.parseInt(burgerPatties);
		String bpUnmolded = request.getParameter("bpUnmoldedMeat");
		int bpUnmoldedMeat = Integer.parseInt(bpUnmolded);
		String embutido = request.getParameter("embutidoMeat");
		int embutidoMeat = Integer.parseInt(embutido);
		String jHotdog = request.getParameter("jHotdogMeat");
		int jHotdogMeat = Integer.parseInt(jHotdog);
		String jLongga = request.getParameter("jLonggaMeat");
		int  jLonggaMeat = Integer.parseInt(jLongga);
		String longgaLucban = request.getParameter("longgaLucbanMeat");
		int longgaLucbanMeat = Integer.parseInt(longgaLucban);
		String longgaVigan = request.getParameter("longgaViganMeat");
		int  longgaViganMeat = Integer.parseInt(longgaVigan);
		String porkTonkatsu = request.getParameter("porkTonkatsuMeat");
		int porkTonkatsuMeat = Integer.parseInt(porkTonkatsu);
		
		//Promeat
		String cornedBeef = request.getParameter("cornedBeefPromeat");
		int  cornedBeefPromeat = Integer.parseInt(cornedBeef);
		String cornedBeef1 = request.getParameter("cornedBeef1Promeat");
		int  cornedBeef1Promeat = Integer.parseInt(cornedBeef1);
		String glazedHam = request.getParameter("glazedHamPromeat");
		int glazedHamPromeat = Integer.parseInt(glazedHam);
		String glazedHamLoaf = request.getParameter("glazedHamLoafPromeat");
		int glazedHamLoafPromeat = Integer.parseInt(glazedHamLoaf);
		String spamHam = request.getParameter("spamHamPromeat");
		int spamHamPromeat  = Integer.parseInt(spamHam);
		String  spamHamLoaf = request.getParameter("spamHamLoafPromeat");
		int spamHamLoafPromeat = Integer.parseInt(spamHamLoaf);
		
		//Patatas
		String bkFries = request.getParameter("bkFriesPatatas");
		int bkFriesPatatas  = Integer.parseInt(bkFries);
		String regular = request.getParameter("regularPatatas");
		int regularPatatas = Integer.parseInt(regular);
		String  hashbrown = request.getParameter("hashbrownPatatas");
		int  hashbrownPatatas = Integer.parseInt(hashbrown);
		String hashbrown10 = request.getParameter("hashbrown10Patatas");
		int hashbrown10Patatas = Integer.parseInt(hashbrown10);
		String kfcFries = request.getParameter("kfcFriesPatatas");
		int  kfcFriesPatatas = Integer.parseInt(kfcFries);
		String mojos = request.getParameter("mojosPatatas");
		int mojosPatatas = Integer.parseInt(mojos);
		
		//Chicken
		String skinSpicy = request.getParameter("skinSpicyChicken");
		int skinSpicyChicken  = Integer.parseInt(skinSpicy);
		String kfcNB250 = request.getParameter("kfcNB250Chicken");
		int kfcNB250Chicken  = Integer.parseInt(kfcNB250);
		String kfcNB500 = request.getParameter("kfcNB500Chicken");
		int kfcNB500Chicken  = Integer.parseInt(kfcNB500);
		String mcfillet = request.getParameter("mcfilletChicken");
		int  mcfilletChicken = Integer.parseInt(mcfillet);
		String McNuggets = request.getParameter("McNuggetsChicken");
		int McNuggetsChicken  = Integer.parseInt(McNuggets);
		String skinOrig = request.getParameter("skinOrigChicken");
		int  skinOrigChicken = Integer.parseInt(skinOrig);
		
		//Others
		String fishFillet = request.getParameter("fishFilletOthers");
		int fishFilletOthers = Integer.parseInt(fishFillet);
		String bulaklak = request.getParameter("bulaklakOthers");
		int bulaklakOthers = Integer.parseInt(bulaklak);
		String oil = request.getParameter("oilOthers");
		int oilOthers = Integer.parseInt(oil);
		String garlic = request.getParameter("garlicOthers");
		int garlicOthers = Integer.parseInt(garlic);
		String cheese = request.getParameter("cheeseOthers");
		int cheeseOthers = Integer.parseInt(cheese);
		String sausage = request.getParameter("sausageOthers");
		int sausageOthers = Integer.parseInt(sausage);
		
		RequestDispatcher dispatcher = null;
		Connection con = null;
		
		HttpSession session = request.getSession();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest","root","rootpass123");
			//Reset Current Order
			Statement stmt =  con.createStatement();
			String sql = "DROP TABLE currentorder";
	        stmt.executeUpdate(sql);
	        //Create currentorder table
	        stmt.executeUpdate("create table currentorder(fullName varchar(50), email varchar(30), address varchar(100),uname varchar(50), contact varchar(11), product varchar(30), quantity int, total int, datentime varchar(100), payment varchar(30), orderStatus varchar(30), datentimeExp varchar(100))");
	        
			PreparedStatement pst = con.prepareStatement("insert into currentorder (uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment) select uname, product, quantity, total, datentime, datentimeExp, orderStatus, payment from temp");
			int rowCount = pst.executeUpdate();
			if (rowCount > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement pst1 = con.prepareStatement("update currentorder SET fullName=?, email=?, contact=?, address=? WHERE uname = ?");
			pst1.setString(1, fullName);
			pst1.setString(2, email);
			pst1.setString(3, contact);
			pst1.setString(4, address);
			pst1.setString(5, uname);
			
			int rowCount1 = pst1.executeUpdate();
			if (rowCount1 > 0) {
				session.setAttribute("contact", contact);
				session.setAttribute("address", address);
				session.setAttribute("date", date);
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement totalpst = con.prepareStatement("select * from currentorder");
			ResultSet rs = totalpst.executeQuery();
			int sum = 0;
			while (rs.next()) {
			String total = rs.getString(8);
			int totalint = Integer.parseInt(total);
			sum += totalint;	
			}
		
			session.setAttribute("sum", sum);
			PreparedStatement pst2 = con.prepareStatement("insert into customerorders select * from currentorder");
			
			int rowCount2 = pst2.executeUpdate();
			if (rowCount2 > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			
			
			//Dimsum Update
			PreparedStatement beefpst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			beefpst.setInt(1,  beefSiomai);
			beefpst.setString(2, "Siomai-Beef");
			
			int rowCountbeef = beefpst.executeUpdate();
			if (rowCountbeef > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement chickenpst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			chickenpst.setInt(1,  chickenSiomai);
			chickenpst.setString(2, "Siomai-Chicken");
			
			int rowCountchicken = chickenpst.executeUpdate();
			if (rowCountchicken > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement japanesepst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			japanesepst.setInt(1,  japaneseSiomai);
			japanesepst.setString(2, "Siomai-Japanese");
			
			int rowCountjapanese = japanesepst.executeUpdate();
			if (rowCountjapanese > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement porkpst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			porkpst.setInt(1,  porkSiomai);
			porkpst.setString(2, "Siomai-Pork");
			
			int rowCountpork = porkpst.executeUpdate();
			if (rowCountpork > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement porkGyozapst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			porkGyozapst.setInt(1,  porkGyozaSiomai);
			porkGyozapst.setString(2, "Siomai-Pork-Dumpling-Gyoza");
			
			int rowCountporkGyoza = porkGyozapst.executeUpdate();
			if (rowCountporkGyoza > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement siopaoAsadopst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			siopaoAsadopst.setInt(1,  siopaoAsadoDimsum);
			siopaoAsadopst.setString(2, "Siopao-Asado-Jumbo");
			
			int rowCountsiopaoAsado = siopaoAsadopst.executeUpdate();
			if (rowCountsiopaoAsado > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement siopaoAsadoMpst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			siopaoAsadoMpst.setInt(1, siopaoAsadoMDimsum);
			siopaoAsadoMpst.setString(2, "Siopao-Asado-Mini");
			
			int rowCountsiopaoAsadoM = siopaoAsadoMpst.executeUpdate();
			if (rowCountsiopaoAsadoM > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement siopaoBolabolapst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			siopaoBolabolapst.setInt(1,  siopaoBolabolaDimsum);
			siopaoBolabolapst.setString(2, "Siopao-Bola-Bola-Jumbo");
			
			int rowCountsiopaoBolabola = siopaoBolabolapst.executeUpdate();
			if (rowCountsiopaoBolabola > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement siopaoBolabolaMpst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			siopaoBolabolaMpst.setInt(1,  siopaoBolabolaMDimsum);
			siopaoBolabolaMpst.setString(2, "Siopao-Bola-Bola-Mini");
			
			int rowCountsiopaoBolabolaM = siopaoBolabolaMpst.executeUpdate();
			if (rowCountsiopaoBolabolaM > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			PreparedStatement siopaoCAsadopst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			siopaoCAsadopst.setInt(1,  siopaoCAsadoDimsum);
			siopaoCAsadopst.setString(2, "Siopao-Chicken-Asado");
			
			int rowCountsiopaoCAsado = siopaoCAsadopst.executeUpdate();
			if (rowCountsiopaoCAsado > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			PreparedStatement gyozapst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			gyozapst.setInt(1,  gyozaDimsum);
			gyozapst.setString(2, "Gyoza");
			
			int rowCountgyoza = gyozapst.executeUpdate();
			if (rowCountgyoza > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			//Meat
			PreparedStatement baconpst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			baconpst.setInt(1, baconMeat);
			baconpst.setString(2, "Bacon");
			
			int rowCountbacon = baconpst.executeUpdate();
			if (rowCountbacon > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement beefTapapst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			beefTapapst.setInt(1, beefTapaMeat);
			beefTapapst.setString(2, "Beef-Tapa");
			
			int rowCountbeefTapa = beefTapapst.executeUpdate();
			if (rowCountbeefTapa > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement bkUnmoldedpst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			bkUnmoldedpst.setInt(1, bkUnmoldedMeat);
			bkUnmoldedpst.setString(2, "BK-Unmolded-Patty");
			
			int rowCountbkUnmolded = bkUnmoldedpst.executeUpdate();
			if (rowCountbkUnmolded > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement burgerPattiespst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			burgerPattiespst.setInt(1, burgerPattiesMeat);
			burgerPattiespst.setString(2, "Burger-Patties");
			
			int rowCountburgerPatties = burgerPattiespst.executeUpdate();
			if (rowCountburgerPatties > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement bpUnmoldedpst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			bpUnmoldedpst.setInt(1, bpUnmoldedMeat);
			bpUnmoldedpst.setString(2, "Burger-Patties-Unmolded");
			
			int rowCountbpUnmolded = bpUnmoldedpst.executeUpdate();
			if (rowCountbpUnmolded > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement embutidopst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			embutidopst.setInt(1, embutidoMeat);
			embutidopst.setString(2, "Embutido");
			
			int rowCountembutido = embutidopst.executeUpdate();
			if (rowCountembutido > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement jHotdogpst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			jHotdogpst.setInt(1, jHotdogMeat);
			jHotdogpst.setString(2, "Jollibee-Hotdog");
			
			int rowCountjHotdog = jHotdogpst.executeUpdate();
			if (rowCountjHotdog > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement jLonggapst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			jLonggapst.setInt(1, jLonggaMeat);
			jLonggapst.setString(2, "Jollibee-Longganisa");
			
			int rowCountjLongga = jLonggapst.executeUpdate();
			if (rowCountjLongga > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement longgaLucbanpst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			longgaLucbanpst.setInt(1, longgaLucbanMeat);
			longgaLucbanpst.setString(2, "Longga-Lucban");
			
			int rowCountlonggaLucban = longgaLucbanpst.executeUpdate();
			if (rowCountlonggaLucban > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement longgaViganpst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			longgaViganpst.setInt(1, longgaViganMeat);
			longgaViganpst.setString(2, "Longga-Vigan");
			
			int rowCountlonggaVigan = longgaViganpst.executeUpdate();
			if (rowCountlonggaVigan > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement porkTonkatsupst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			porkTonkatsupst.setInt(1, porkTonkatsuMeat);
			porkTonkatsupst.setString(2, "Pork-Tonkatsu");
			
			int rowCountporkTonkatsu = porkTonkatsupst.executeUpdate();
			if (rowCountporkTonkatsu > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			//Promeat
			PreparedStatement cornedBeefpst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			cornedBeefpst.setInt(1, cornedBeefPromeat);
			cornedBeefpst.setString(2, "Promeat-Corned-Beef-1/2k");
			
			int rowCountcornedBeef = cornedBeefpst.executeUpdate();
			if (rowCountcornedBeef > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement cornedBeef1pst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			cornedBeef1pst.setInt(1, cornedBeef1Promeat);
			cornedBeef1pst.setString(2, "Promeat-Corned-Beef-1k");
			
			int rowCountcornedBeef1 = cornedBeef1pst.executeUpdate();
			if (rowCountcornedBeef1 > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement glazedHampst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			glazedHampst.setInt(1, glazedHamPromeat);
			glazedHampst.setString(2, "Promeat-Glazed-Ham");
			
			int rowCountglazedHam = glazedHampst.executeUpdate();
			if (rowCountglazedHam > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement glazedHamLoafpst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			glazedHamLoafpst.setInt(1, glazedHamLoafPromeat);
			glazedHamLoafpst.setString(2, "Promeat-Glazed-Ham-Loaf");
			
			int rowCountglazedHamLoaf = glazedHamLoafpst.executeUpdate();
			if (rowCountglazedHamLoaf > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement spamHampst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			spamHampst.setInt(1, spamHamPromeat);
			spamHampst.setString(2, "Promeat-Spam-Ham");
			
			int rowCountspamHam = spamHampst.executeUpdate();
			if (rowCountspamHam > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement spamHamLoafpst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			spamHamLoafpst.setInt(1, spamHamLoafPromeat);
			spamHamLoafpst.setString(2, "Promeat-Spam-Ham-Loaf");
			
			int rowCountspamHamLoaf = spamHamLoafpst.executeUpdate();
			if (rowCountspamHamLoaf > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			//Patatas
			PreparedStatement bkFriesPatataspst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			bkFriesPatataspst.setInt(1, bkFriesPatatas);
			bkFriesPatataspst.setString(2, "Burger-King-French-Fries");
			
			int rowCountbkFriesPatatas = bkFriesPatataspst.executeUpdate();
			if (rowCountbkFriesPatatas > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement regularPatataspst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			regularPatataspst.setInt(1, regularPatatas);
			regularPatataspst.setString(2, "French-Fries-Regular");
			
			int rowCountregularPatatas = regularPatataspst.executeUpdate();
			if (rowCountregularPatatas > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement hashbrownPatataspst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			hashbrownPatataspst.setInt(1, hashbrownPatatas);
			hashbrownPatataspst.setString(2, "Hashbrown");
			
			int rowCounthashbrownPatatas = hashbrownPatataspst.executeUpdate();
			if (rowCounthashbrownPatatas > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement hashbrown10Patataspst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			hashbrown10Patataspst.setInt(1, hashbrown10Patatas);
			hashbrown10Patataspst.setString(2, "Hashbrown-10s");
			
			int rowCounthashbrown10Patatas = hashbrown10Patataspst.executeUpdate();
			if (rowCounthashbrown10Patatas > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement kfcFriesPatataspst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			kfcFriesPatataspst.setInt(1, kfcFriesPatatas);
			kfcFriesPatataspst.setString(2, "KFC-Fries");
			
			int rowCountkfcFriesPatatas = kfcFriesPatataspst.executeUpdate();
			if (rowCountkfcFriesPatatas > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement mojosPatataspst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			mojosPatataspst.setInt(1, mojosPatatas);
			mojosPatataspst.setString(2, "Mojos");
			
			int rowCountmojosPatatas = mojosPatataspst.executeUpdate();
			if (rowCountmojosPatatas > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			//Chicken
			PreparedStatement skinSpicyChickenpst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			skinSpicyChickenpst.setInt(1, skinSpicyChicken);
			skinSpicyChickenpst.setString(2, "Chicken-Skin-Spicy");
			
			int rowCountskinSpicyChicken = skinSpicyChickenpst.executeUpdate();
			if (rowCountskinSpicyChicken > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement kfcNB250Chickenpst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			kfcNB250Chickenpst.setInt(1, kfcNB250Chicken);
			kfcNB250Chickenpst.setString(2, "KFC-NB-250");
			
			int rowCountkfcNB250Chicken = kfcNB250Chickenpst.executeUpdate();
			if (rowCountkfcNB250Chicken > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement kfcNB500Chickenpst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			kfcNB500Chickenpst.setInt(1, kfcNB500Chicken);
			kfcNB500Chickenpst.setString(2, "KFC-NB-500");
			
			int rowCountkfcNB500Chicken = kfcNB500Chickenpst.executeUpdate();
			if (rowCountkfcNB500Chicken > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement mcfilletChickenpst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			mcfilletChickenpst.setInt(1, mcfilletChicken);
			mcfilletChickenpst.setString(2, "McFillet");
			
			int rowCountmcfilletChicken = mcfilletChickenpst.executeUpdate();
			if (rowCountmcfilletChicken > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement McNuggetsChickenpst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			McNuggetsChickenpst.setInt(1, McNuggetsChicken);
			McNuggetsChickenpst.setString(2, "McNuggets");
			
			int rowCountMcNuggetsChicken = McNuggetsChickenpst.executeUpdate();
			if (rowCountMcNuggetsChicken > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement skinOrigChickenpst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			skinOrigChickenpst.setInt(1, skinOrigChicken);
			skinOrigChickenpst.setString(2, "Chicken-Skin-Original");
			
			int rowCountskinOrigChicken = skinOrigChickenpst.executeUpdate();
			if (rowCountskinOrigChicken > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			//Others
			PreparedStatement fishFilletOtherspst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			fishFilletOtherspst.setInt(1, fishFilletOthers);
			fishFilletOtherspst.setString(2, "Chowking-Fish-Fillet");
			
			int rowCountfishFilletOthers = fishFilletOtherspst.executeUpdate();
			if (rowCountfishFilletOthers > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement bulaklakOtherspst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			bulaklakOtherspst.setInt(1, bulaklakOthers);
			bulaklakOtherspst.setString(2, "Chicharong-Bulaklak");
			
			int rowCountbulaklakOthers = bulaklakOtherspst.executeUpdate();
			if (rowCountbulaklakOthers > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement oilOtherspst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			oilOtherspst.setInt(1, oilOthers);
			oilOtherspst.setString(2, "Chicken-Oil");
			
			int rowCountoilOthers = oilOtherspst.executeUpdate();
			if (rowCountoilOthers > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement garlicOtherspst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			garlicOtherspst.setInt(1, garlicOthers);
			garlicOtherspst.setString(2, "Crunchy-Garlic");
			
			int rowCountgarlicOthers = garlicOtherspst.executeUpdate();
			if (rowCountgarlicOthers > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement cheeseOtherspst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			cheeseOtherspst.setInt(1, cheeseOthers);
			cheeseOtherspst.setString(2, "Hungarian-Cheese");
			
			int rowCountcheeseOthers = cheeseOtherspst.executeUpdate();
			if (rowCountcheeseOthers > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			PreparedStatement sausageOtherspst = con.prepareStatement("update product SET quantity = quantity - ? WHERE productName = ?");
			sausageOtherspst.setInt(1, sausageOthers);
			sausageOtherspst.setString(2, "Hungarian-Sausage");
			
			int rowCountsausageOthers = sausageOtherspst.executeUpdate();
			if (rowCountsausageOthers > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			
			
			dispatcher = request.getRequestDispatcher("invoicePage.jsp");
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}