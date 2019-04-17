package ca.sheridan.eshop.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.sheridan.eshop.model.PizzaBean;

@WebServlet (name= "PizzaOrderServlet",
urlPatterns =  "/users/orderPizza")
public class PizzaOrderServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PizzaBean pb = processData(req);
		req.setAttribute("displayPizzaBean", pb);
		RequestDispatcher view = req.getRequestDispatcher("Display.jsp");
        view.forward(req, resp);
	}

	private PizzaBean processData(HttpServletRequest req) {
		PizzaBean pb = new PizzaBean();
		pb.setCustomerName(req.getParameter("custName"));
		pb.setSelectedCrust(formatInput(req.getParameter("selectedCrust")));
		pb.setSelectedSauce(formatInput(req.getParameter("selectedSauce")));
		ArrayList<String> selected = new ArrayList<String>();
		ArrayList<String> selectedImages = new ArrayList<String>();
		for(String selectedMeat: req.getParameterValues("selectedMeatTop")) {
			selectedImages.add(addSelectedImage(selectedMeat));
			selected.add(formatInput(selectedMeat));
		}
		for (String selectedVeggie : req.getParameterValues("selectedVeggies")) {
			selectedImages.add(addSelectedImage(selectedVeggie));
			selected.add(formatInput(selectedVeggie));
		}
		pb.setSelectedTopins(selected);
		pb.setSelectedTopinsImages(selectedImages);
		return pb;
	}
	
	private String addSelectedImage(String selected) {
		// addSelected topping Image to bean
		selected = selected.toLowerCase();
		switch (selected) {
		case "chicken":
			return "../images/chickenToppings.jpg";
		case "extra_cheese":
			return "../images/extraCheeseToppings.jpg";
		case "green_pepper":
			return "../images/greenPepperToppings.jpg";
		case "ham":
			return "../images/hamToppings.jpg";
		case "pepperoni":
			return "../images/pepperoniToppings.jpg";
		case "onions":
			return "../images/onionsToppings.jpg";
		case "tomato":
			return "../images/tomatoToppings.jpg";
		default:
			return "";
		}
		
	}

	//method to tokenize strings with _ to space
	private String formatInput(String s) {
		if (s.contains("_"))
			return s.replace('_', ' ');
		return s;
	}

}
