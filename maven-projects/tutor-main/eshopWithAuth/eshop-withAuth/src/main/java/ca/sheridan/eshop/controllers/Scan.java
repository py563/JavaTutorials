package ca.sheridan.eshop.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ca.sheridan.eshop.dao.ScanItemService;
import ca.sheridan.eshop.model.ProductCatalogue;

@WebServlet("/users/Scan")

public class Scan extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NullPointerException{
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		List<ProductCatalogue> itemsList;
		String itemCode = request.getParameter("code");
		ScanItemService sItemServe = new ScanItemService();
		if(session.getAttribute("scannedItems")!= null) {
			itemsList = (List<ProductCatalogue>)session.getAttribute("scannedItems");
		}
		else 
		{
			itemsList = new ArrayList<ProductCatalogue>();
		}
		ProductCatalogue itemScanned = sItemServe.getScannedItem(itemCode);
		if(itemScanned == null)
		{
			//validation
			request.setAttribute("errorWrongItem", itemCode);
		}
		else 
		{
			itemsList.add(itemScanned);
			session.setAttribute("scannedItems", itemsList);
		}
		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
		view.include(request, response);
	}
}
