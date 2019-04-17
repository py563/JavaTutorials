<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddItem</title>
</head>
<body>
<div style="margin:2em; padding:1em; background-color: lightblue">
		<h1> Add a New Product to the Scanner </h1>
		<form method="post" action="InsertProduct">
    		<label for="code"> Code: </label> <input type="text" name="code" required> <br>
    		<label for="name"> Name: </label> <input type="text" name="name" required> <br>
    		<label for="price">Price: </label> <input type="text" name="price" required> <br>
    		<label>Type: </label> <input type="text" name="type" value="purchase"> <br>
    		<label>Taxable: </label> 
    			<select name="taxable" >
    				<option value="Yes">Yes</option>
    				<option value="No">No</option>
    			</select> <br> 
    		<input style="margin:1em; padding:0.5em;" type="submit" value="Insert">
		</form>
</div>
<div>
<% if (request.getAttribute("msg")!= null) { %>
	<span> <%=request.getAttribute("msg")%></span>
<% } %>
</div>
<footer>
	<a href="../logout.jsp" > Logout </a>
</footer> 
</body>
</html>