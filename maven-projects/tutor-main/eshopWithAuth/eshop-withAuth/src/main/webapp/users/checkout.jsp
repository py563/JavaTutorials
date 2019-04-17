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
               	<td><%=request.getAttribute("totalAmount")%></td>
               </tr>
              </table>
             <% }%>	
		</div>
		<div>
			<a href=index.jsp><span>Start Scanning for Next Customer</span></a>
		</div>
	</div>
<footer>
	<a href="../logout.jsp" > Logout </a>
</footer> 
</body>
</html>