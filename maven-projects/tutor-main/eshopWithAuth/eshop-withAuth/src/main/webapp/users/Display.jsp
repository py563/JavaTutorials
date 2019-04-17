<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.ArrayList, ca.sheridan.eshop.model.PizzaBean" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>pizza order</title>
</head>
<body>
<div>
<% PizzaBean pbD = (PizzaBean)request.getAttribute("displayPizzaBean"); %>
<h1> Hi <%=pbD.getCustomerName() %> View Your Pizza Order Below</h1>
<table>
<tr>
<td><span>Crust:</span></td>
<td><span><%=pbD.getSelectedCrust()%></span></td>
</tr>
<tr>
<td><span>Sauce:</span></td>
<td><span><%=pbD.getSelectedSauce()%></span></td>
</tr>
<tr>
<%	ArrayList<String> selListImages = pbD.getSelectedTopinsImages();%>
<td colspan=<%=selListImages.size()%> align="center"><h2>Selected Toppings</h2></td>
</tr>
<tr>
<% 	for (String imgLink : selListImages) { %>
		<td>
			<img src="<%=imgLink%>" alt="no_img">
		</td>
<%	}	%>
</tr>
</table>
</div>
<footer>
	<a href="OrderAPizza.jsp" > Order Again </a>
</footer>
</body>
</html>