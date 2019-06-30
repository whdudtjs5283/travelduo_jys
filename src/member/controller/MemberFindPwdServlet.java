package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;

/**
 * Servlet implementation class MemberFindPwdServlet
 */
@WebServlet("/mfindpwd")
public class MemberFindPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFindPwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String userId = request.getParameter("userid");
		String phone = request.getParameter("phone");
		
		String findPwdMember = new MemberService().findPwdMember(userId , phone);		
		
		response.setContentType("text/html; charset=utf-8"); 

if(findPwdMember !=null) {
	
	HttpSession session=request.getSession();
	session.setAttribute("findPwdMember",findPwdMember);
	response.sendRedirect("/travelduo/views/member/memberFindPwdDetail.jsp");
	
	
}else {
	RequestDispatcher view = request.getRequestDispatcher("views/member/memberFindPwd.jsp");
	request.setAttribute("result", "fail");
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
