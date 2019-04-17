package ca.sheridan.eshop.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ca.sheridan.eshop.dao.OrderService;
import ca.sheridan.eshop.model.ProductCatalogue;

@WebServlet("/users/SelfCheckout")
public class SelfCheckout extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NullPointerException{
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		List<ProductCatalogue> items = (List<ProductCatalogue>) session.getAttribute("scannedItems");
		OrderService odr = new OrderService();
		double total = odr.getOrderedItemTotal(items);
		request.setAttribute("totalAmount", total);
		request.setAttribute("orderedItems", items);
		RequestDispatcher view = request.getRequestDispatcher("checkout.jsp");
		view.include(request, response);
	}
}
