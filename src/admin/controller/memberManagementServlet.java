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
import member.model.vo.Member;

/**
 * Servlet implementation class memberManagementServlet
 */
@WebServlet("/mm")
public class memberManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memberManagementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		
		ArrayList<Member> list = new AdminService().memberManagement();
		
		RequestDispatcher view = null;
		
		if(list.size() > 0) {
			view = request.getRequestDispatcher("/views/admin/memberManagementView.jsp");
			request.setAttribute("list", list);
			view.forward(request, response);
			System.out.println(list);
		} else {
			view = request.getRequestDispatcher("views/product/productError.jsp");
			request.setAttribute("message", "회원 목록을 불러올 수 없습니다.");
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
