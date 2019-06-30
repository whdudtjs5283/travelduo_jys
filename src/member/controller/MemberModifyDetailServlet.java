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
@WebServlet("/mmodifydetail")
public class MemberModifyDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberModifyDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				request.setCharacterEncoding("utf-8"); 
				
				Member member = new Member();

				member.setUserId(request.getParameter("userid"));
				member.setUserName(request.getParameter("username"));  //request를 통해 전송되어져 온 값을 parameter라고 하는 거 같다 .  그리고 숫자를 보내든 날짜를보내든 무조건 string으로 꺼내지기에 string 변수가 받는다.
				member.setUserPwd(request.getParameter("userpwd"));
				member.setEmail(request.getParameter("email"));
				member.setPhone(request.getParameter("phone"));
				member.setAge(Integer.parseInt(request.getParameter("age")));

				
			System.out.println("member를 보자" + member);

			   
			MemberService mservice = new MemberService();
				int result= mservice.modifyDetailMember(member);
				
				response.setContentType("text/html; charset=utf-8");  
				RequestDispatcher view = request.getRequestDispatcher("views/member/memberMyPage.jsp");
				if(result > 0) {
				
					request.setAttribute("result", "success");
					request.getSession(false).setAttribute("loginUser",mservice.selectModifyMember(member.getUserId()) );
					
				}else {
					request.setAttribute("result", "fail");
				} 
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
