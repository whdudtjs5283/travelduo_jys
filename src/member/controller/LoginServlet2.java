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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//로그인 처리용 서블릿
	//1. 전달 받은 값에 한글이 있다면 , 인코딩 작업하기
		//아이디 비밀번호에는 한글이 없으므로 인코딩 생략
		
	//2. 전달받은 값을 변수 또는 객체에 저장함
		//전달 받는 값은 파라미터로 받고 파라미터는 항상 string으로 온다 
		String userId=request.getParameter("userid");
		String userPwd=request.getParameter("userpwd");
	System.out.println(userId.length() +"," + userPwd.length());	
System.out.println("userid ,userpwd = " + userId +"랑"+userPwd);
	//3.저장한 값을 service모델로 보낸 후 받은 결과값을 받기
		Member loginUser = new MemberService().selectLogin(userId,userPwd);
System.out.println("loginUser : " + loginUser);

response.setContentType("text/html; charset=utf-8");   


if(loginUser !=null) {
	
	HttpSession session=request.getSession();
System.out.println("session" + session);
System.out.println("seesion" + session.getId());
	session.setAttribute("loginUser", loginUser);


	response.sendRedirect("/travelduo/index2.jsp");
	
	
}else {
	RequestDispatcher view = request.getRequestDispatcher("views/member/memberError.jsp");
	request.setAttribute("message", "로그인실패!");
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
