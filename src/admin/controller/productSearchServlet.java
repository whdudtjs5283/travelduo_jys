package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;
import product.model.vo.Product;

/**
 * Servlet implementation class productSearchServlet
 */
@WebServlet("/psearch")
public class productSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String search = request.getParameter("search");
		
		ArrayList<Product> list = null;
		
		AdminService adservice = new AdminService();
		
		switch(search) {
		case "pnum": String productNum = request.getParameter("content");
				  list = adservice.searchProductNum(productNum);
				  break;
		case "coun": String country = request.getParameter("content");
				  list = adservice.searchCountry(country);
				  break;
		case "des": String destination = request.getParameter("content");
				  list = adservice.searchDestination(destination);
				  break;
		}
		
		RequestDispatcher view =  request.getRequestDispatcher("views/admin/productManagementView.jsp");
			request.setAttribute("list", list);
			view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
