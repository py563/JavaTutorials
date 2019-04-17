<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.List" %>
<%@ page import = "ca.sheridan.eshop.model.ProductCatalogue" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="margin:5em; padding:1em;">
		<h1>Products</h1>
		<div>
			<%  
                if (request.getAttribute("orderedItems") != null) {
                    List<ProductCatalogue> allItems = (List<ProductCatalogue>)request.getAttribute("orderedItems");
            %>
            <table style="background-color:lightBlue;border:0;">
       			<tr style="background-color:lightgrey;">
	                <td><b>Name</b></td>
	                <td><b>Price</b></td>
	                <td><b>Tax</b></td>
	                <td><b>Price After Tax</b></td>
	            </tr>
	                  <% for(ProductCatalogue thisItem: allItems){ %>
	            <tr style="background-color:#F9EBB3;">
	                <td><%=thisItem.getName()%></td>
	                <td><%=thisItem.getPrice()%></td>
	                <td><%=thisItem.getTaxable()%></td>
	                <td><%=thisItem.getPriceWithTax()%></td>
	            </tr>
                  <% }%>
               <tr>
               	<td colspan="3"> <b> Total </b> </td>
               	<td><%=request.getAttribute("totalAmount")%></span></td>
               </tr>
               </table>
             <% }%>
             <form action="insertOrder" method="post">
             <table>
             <tr>
             <td><label for="custName">Name:</label></td>
             <td><input type="text" name="custName"></td>
             </tr>
             <tr>
             <td><label for="custEmail">Email:</label></td>
             <td><input type="email" name="custEmail"></td>
             </tr>
             <tr>
             <td colspan=2><input type="submit" name="submit" value="Confirm Purchase"></td>
             </tr>
             <tr>
             <td colspan=2><input type="submit" name="submit" value="Next Customer"></td>
             </tr>
             </table>
             <input type="hidden" name="totalAmount" value=<%=request.getAttribute("totalAmount")%>>
             </form>
		</div>
		<div>
			<% if((request.getAttribute("msg")!=null) && (request.getAttribute("msg").equals("error"))) { %>
         	<span style=color:red;>The Purchase for this order cannot be confirmed please try again (or) </span>
			<br>
			<% } %>
		</div>
	</div>
<footer>
	<a href="../logout.jsp" > Logout </a>
</footer> 
</body>
</html>