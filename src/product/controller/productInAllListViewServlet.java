package product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.model.service.ProductService;
import product.model.vo.Product;

/**
 * Servlet implementation class productInAllListViewServlet
 */
@WebServlet("/pialist")
public class productInAllListViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productInAllListViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		
		ArrayList<Product> list = new ProductService().productInAllList();
		
		
		RequestDispatcher view = null;
		
		if(list.size() > 0) {
			view = request.getRequestDispatcher("views/product/productListView.jsp");
			request.setAttribute("list", list);
			view.forward(request, response);
			System.out.println("list : " + list);
		} else {
			view = request.getRequestDispatcher("views/product/productError.jsp");
			request.setAttribute("message", "여행 리스트를 불러올 수 없습니다.");
			view.forward(request, response);
		}		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
