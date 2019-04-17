package ca.sheridan.eshop.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.sheridan.eshop.dao.AddItemService;

@WebServlet("/admin/InsertProduct")

/**
 * Servlet implementation class AddAnItem
 */
public class AddAnItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAnItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AddItemService ads = new AddItemService();
		if (ads.insertItemToProductCatalogue(request.getParameterMap()) == -1) 
			request.setAttribute("msg", "Error in adding item try again");
		else
			request.setAttribute("msg", "Item Added Succesfully");
		RequestDispatcher view = request.getRequestDispatcher("addAnItem.jsp");
		view.include(request, response);
				
		
	}

}
