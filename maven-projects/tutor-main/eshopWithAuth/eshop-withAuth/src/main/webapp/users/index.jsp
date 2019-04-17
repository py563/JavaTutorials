<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@ page import = "ca.sheridan.eshop.model.ProductCatalogue" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Eshop-Scan</title>
</head>
<body>
	<div>
		<h1 align="center">Cash Register</h1>
	</div>
	<div>
		<table bgcolor="lightBlue" align="center" border="0">
			<form action="Scan" method="post">
				<tr>
				<td align="left">Item Code</td>
				<td align="left"><input type="text" name="code" required></td>
				</tr>
				<tr>
				<td align="center"><input type="submit" value="Scan"></td>
				</tr>
			</form>
		</table>
	</div>
	<div style="margin:2em; padding:1em;">
		<% String color = "#F9EBB3";
           if (session.getAttribute("scannedItems") != null) {
        	   List<ProductCatalogue> items = (List<ProductCatalogue>) session.getAttribute("scannedItems");
         	%>
         		<table style="background-color:lightBlue;align:center;border:0;">
         			<tr>
		                <td colspan=4 align="center"
		                    style="background-color:teal">
		                    <b>List of Scanned Items</b></td>
		            </tr>
		            <tr style="background-color:lightgrey;">
		                <td><b>Code</b></td>
		                <td><b>Name</b></td>
		                <td><b>Price</b></td>
		                <td><b>Tax</b></td>
		            </tr>
			<% 
               for(ProductCatalogue item: items){%>
		         	<tr style="background-color:<%=color%>;">
			                <td><%=item.getCode()%></td>
			                <td><%=item.getName()%></td>
			                <td><%=item.getPrice()%></td>
			                <td><%=item.getTaxable()%></td>
			            </tr>
	            <% 	} %>
	            <tr>
					<td align="center">
						<form action="SelfCheckout" method="post">
							<input type="submit" value="Checkout">
						</form>
					</td>
				</tr>
	            </table>
	         <% } %>
	         <%if(request.getAttribute("errorWrongItem")!=null) { %>
	         	<span style=color:red;>The Entered Item( <%=request.getAttribute("errorWrongItem")%> ) Code is Invalid</span>;
				<br>
				<span style="color:red;">Please Enter a Valid Item Code</span>
				<% } %>
	</div>
<footer>
	<a href="../logout.jsp" > Logout </a>
</footer> 
</body>
</html>