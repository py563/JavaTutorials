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

import ca.sheridan.eshop.dao.ScanItemService;
import ca.sheridan.eshop.model.ProductCatalogue;

@WebServlet("/users/insertOrder")
/**
 * Servlet implementation class InsertOrder
 */
public class InsertOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		System.out.println("Entered servlet:"+ request.getParameter("submit"));
		ScanItemService sis = new ScanItemService();
		RequestDispatcher view;
		//Check which button clicked
		if(request.getParameter("submit").equals("Confirm Purchase")) {
			System.out.println("Entered Confirm Purchase");
			int status = sis.insertOrder(request.getParameterMap());
			if(status ==-1){
				request.setAttribute("msg", "error");
				List<ProductCatalogue> items = (List<ProductCatalogue>) session.getAttribute("scannedItems");
				request.setAttribute("orderedItems", items);
				view = request.getRequestDispatcher("checkout.jsp");
			}
			else {
				session.removeAttribute("scannedItems");
				request.setAttribute("msg", "success");
				view = request.getRequestDispatcher("index.jsp");
	
			}
		}
		//next customer button
		else {
			session.removeAttribute("scannedItems");
			request.setAttribute("msg", "success");
			view = request.getRequestDispatcher("index.jsp");
		}
		view.include(request, response);
	}

}
