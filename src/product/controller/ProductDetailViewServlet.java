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
 * Servlet implementation class ProductDetailViewServlet
 */
@WebServlet("/pdetail")
public class ProductDetailViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetailViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		String productNum = request.getParameter("num");
		
		Product product = new ProductService().detailView(productNum);
		
		RequestDispatcher view = null;
		if(product != null) {
			view = request.getRequestDispatcher("views/product/productDetailView.jsp");
			request.setAttribute("product", product);
			view.forward(request, response);
			System.out.println("product : " + product);
		} else {
			view = request.getRequestDispatcher("views/product/productError.jsp");
			request.setAttribute("message", "상품 디테일 페이지 불러오기 실패!");
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
