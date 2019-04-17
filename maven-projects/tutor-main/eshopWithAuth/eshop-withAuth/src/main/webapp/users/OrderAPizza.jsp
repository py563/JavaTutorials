<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>pizza order</title>
</head>
<body>
<div>
<h1> Please select our Pizza offerings here</h1>
<form action="orderPizza" method="post">
<table>
<tbody>
	<tr>
	<td> <label for="custName"> Enter your name: </label> </td>
	<td> <input type="text" name="custName" required /> </td>
	</tr>
	<tr>
	<td> <label for="selectedCrust"> Select a Crust: </label> </td>
	<td>
		<select name="selectedCrust">
  			<option value="Hand_Tossed">Hand Tossed</option>
  			<option value="Thin">Thin Crust</option>
 		 	<option value="Pan">Deep-Pan</option>
  		</select>
	</td>
	</tr>
	<tr>
	<td> <label for="selectedSauce"> Select your Sauce </label> </td>
	<td>
		<select name="selectedSauce">
  			<option value="Marinara">Marinara</option>
  			<option value="Alferdo">Alfredo</option>
 		 	<option value="Olive_Ginger">Ginger & Olive Oil</option>
 		 	<option value="Hot">Hot</option>
  		</select>
	</td>
	</tr>
	<tr>
	<td> <label for="selectedMeatTop"> Select your Meat: </label> </td>
	<td>
		<select name="selectedMeatTop" multiple>
  			<option value="Chicken">Chicken</option>
  			<option value="Pepperoni">Pepperoni</option>
 		 	<option value="Ham">Ham</option>
  		</select>
	</td>
	</tr>
	<tr>
	<td> <label for="selectedVeggies"> Select Other Toppins: </label> </td>
	<td>
		<select name="selectedVeggies" multiple>
  			<option value="Extra_Cheese">Extra Cheese</option>
  			<option value="Green_Pepper">Green Peppers</option>
 		 	<option value="Onions">Onions</option>
 		 	<option value="Tomato">Tomato</option>
  		</select>
	</td>
	</tr>	
	<tr>
	<td>
	<input type="submit" value="Order" />
	</td>
	<td>
	<input type="reset" value="Reset" />
	</td>
	</tr>
</tbody>
</table>
</form>
<span>Hold down the Ctrl (windows) / Command (Mac) button to select multiple options.</span>
</div>
<footer>
	<a href="../logout.jsp" > Logout </a>
</footer>
</body>
</html>