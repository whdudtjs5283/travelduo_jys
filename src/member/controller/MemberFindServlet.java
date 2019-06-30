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
import member.model.vo.Member;

/**
 * Servlet implementation class memberFindServlet
 */
@WebServlet("/mfind")
public class MemberFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFindServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String userName = request.getParameter("username");
		String email = request.getParameter("email");
		String findMember = new MemberService().findMember(userName ,email);		
		
		response.setContentType("text/html; charset=utf-8"); 
		
if(findMember !=null) {
	
	HttpSession session=request.getSession();
	session.setAttribute("findMember",findMember);
	response.sendRedirect("/travelduo/views/member/memberFindIdDetail.jsp");
	
	
}else {
	RequestDispatcher view = request.getRequestDispatcher("views/member/memberFindId.jsp");
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
