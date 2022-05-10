<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <!-- Custom Style -->
    <link rel="stylesheet" href="css/invoicePageStyles.css">
    <!-- PDF -->
    <script src="pdf.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.9.2/html2pdf.bundle.js"></script>

    <title>Invoice</title>
</head>
<body>
    <div id="invoice" class="my-5 page" size="A4">
        <div class="p-5">
            <section class="top-content bb d-flex justify-content-between">
                <div class="logo">
                    <img src="img/kkwithwordsorange.png" alt="" class="img-fluid">
                </div>
                <div class="top-left">
                    <div class="graphic-path">
                        <p>Invoice</p>
                    </div>
                    <div class="position-relative">
                        <p>"Pang ulam o Pang Meryenda"</p>
                    </div>
                </div>
            </section>

            <section class="store-user mt-5">
                <div class="col-10">
                    <div class="row bb pb-3">
                        <div class="col-7">
                            <p>Contact Details,</p>
                            <p class="address">Name: <%=session.getAttribute("fname")%> <%=session.getAttribute("lname")%>  <br> Email: <%=session.getAttribute("email")%> <br>Username: <%=session.getAttribute("uname")%></p>
                        </div>
                        <div class="col-5">
                            <p></p>
                            <p class="address"> Mobile Number: <%=session.getAttribute("contact")%> <br> Delivery Address <br><%=session.getAttribute("address")%> </p>
                        </div>
                    </div>
                    <div class="row extra-info pt-3">
                        <div class="col-7">
                            <p>Order Date: <%=session.getAttribute("date")%></p>
                        </div>
                    </div>
                </div>
            </section>

            <section class="product-area mt-4">
<%
try
{
    Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest","root","rootpass123");
    String sql =  "select * from currentorder";
    PreparedStatement pst = con.prepareStatement(sql);
    ResultSet rs = pst.executeQuery();
    
    if (rs.next() == false)
    {
        out.println("No records found in the table!");
    }
    else 
    { %>
    	<H1>ORDERS</H1>
        <table class="table table-hover">
            <th>Quantity</th><th>Product</th><th>total</th>
        <%
        do { %>
            <tr><td><%= rs.getString(7) %></td><td><%= rs.getString(6) %></td><td>Php. <%= rs.getString(8) %></td></tr>
            <%
        } while (rs.next());

            }
            %>
        </table>
        <%
        
} catch (Exception e) {
    e.getStackTrace();
}
%>
            </section>

            <section class="balance-info">
                <div class="row">
                    <div class="col-8">
                        <p class="m-0 font-weight-bold"></p>
                        <p></p>
                    </div>
                    <div class="col-4">
                        <table class="table border-0 table-hover">
                            <tfoot>
                                <tr>
                                    <td>Total:</td>
                                    <td>Php. <%=session.getAttribute("sum")%></td>
                                </tr>
                            </tfoot>
                        </table>
                      <div class="col-md-12 text-right mb-3">
                <button class="btn btn-primary" id="download"> Download PDF</button>
            </div>
                    </div>
                </div>
            </section>
            <!-- Cart BG -->
            <img src="cart.jpg" class="img-fluid cart-bg" alt="">

            <footer>
                <hr>
                <p class="m-0 text-center">
                    Contact Us 
                </p>
                <div class="social pt-3">
                    <span class="pr-2">
                        <i class="fas fa-mobile-alt"></i>
                        <span>+639666432005</span>
                    </span>
                    <span class="pr-2">
                        <i class="fas fa-envelope"></i>
                        <span>kambalkusinaregister@gmail.com</span>
                    </span>
                    <span class="pr-2">
                        <i class="fab fa-facebook-f"></i>
                        <span>www.facebook.com/KambalKusinaByKathie</span>
                    </span>
                </div>
            </footer>
        </div>
    </div>
<script>
window.onload = function () {
    document.getElementById("download")
        .addEventListener("click", () => {
            const invoice = this.document.getElementById("invoice");
            console.log(invoice);
            console.log(window);
            var opt = {
                margin: .1,
                filename: '<%=session.getAttribute("lname")%>Invoice.pdf',
                image: { type: 'jpeg', quality: 0.88 },
                html2canvas: { scale: 2 },
                jsPDF: { unit: 'in', format: 'letter', orientation: 'portrait' }
            };
            html2pdf().from(invoice).set(opt).save();
        })
}
</script>
<div style="display:flex; position:fixed; right:80px; bottom:130px;">
<form action="logout">
	<button class="exitBtn" type="submit">Exit</button>
</form>
</div>
</body>
</html>