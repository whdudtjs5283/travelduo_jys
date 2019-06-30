package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberModifyServlet
 */
@WebServlet("/mmodify")
public class MemberModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//로그인유저가 회원정보를 수정하기위해 비밀번호를 한번 더 입력하도록 처리하는 서블릿 

		String userId = request.getParameter("userid");
		String userPwd = request.getParameter("userpwd");

		Member modifyUser = new MemberService().modifyUser(userId , userPwd); 
		response.setContentType("text/html; charset=utf-8");
	
		RequestDispatcher view = null;
		
		if(modifyUser !=null) {		

	response.sendRedirect("/travelduo/views/member/memberModifyDetail.jsp");
		
		}else {
			request.setAttribute("modifyResult", "fail");
			view = request.getRequestDispatcher("views/member/memberModify.jsp");
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
