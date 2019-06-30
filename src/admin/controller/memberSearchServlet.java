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
 * Servlet implementation class memberSearchServlet
 */
@WebServlet("/mmsearch")
public class memberSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memberSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		String search = request.getParameter("search");
		
		ArrayList<Member> list = null;
		
		AdminService adservice = new AdminService();
		
		switch(search) {
		case "id": String userId = request.getParameter("content");
				  list = adservice.searchMMId(userId);
				  break;
		case "name": String userName = request.getParameter("content");
				  list = adservice.searchMMName(userName);
				  break;
		case "age": int age = (Integer.parseInt(request.getParameter("content")));
				  list = adservice.searchMMAge(age);
				  break;
		case "gender": String gender = request.getParameter("content");
				  list = adservice.searchMMGender(gender);
				  break;
		case "phone": String phone = request.getParameter("content");
				  list = adservice.searchMMPhone(phone);
				  break;
		case "email": String email = request.getParameter("content");
				  list = adservice.searchMMEmail(email);
				  break;
		}
		
		RequestDispatcher view = request.getRequestDispatcher("views/admin/memberManagementView.jsp");
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
