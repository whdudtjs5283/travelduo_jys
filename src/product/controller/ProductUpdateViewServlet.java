package product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.model.service.ProductService;
import product.model.vo.Product;

/**
 * Servlet implementation class ProductUpdateViewServlet
 */
@WebServlet("/pupdateview")
public class ProductUpdateViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductUpdateViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String productNum = request.getParameter("num");
		
		Product product = new ProductService().updateViewProduct(productNum);
		
		RequestDispatcher view = null;
		if(product != null) {
			view = request.getRequestDispatcher("views/admin/productUpdateView.jsp");
			request.setAttribute("product", product);
			view.forward(request, response);
		} else {
			view = request.getRequestDispatcher("views/admin/productError.jsp");
			request.setAttribute("message", "상품수정 실패!");
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
