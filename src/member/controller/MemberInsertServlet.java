package member.controller;

import java.awt.TrayIcon.MessageType;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;


/**
 * Servlet implementation class MemberInsetServlet
 */
@WebServlet("/minsert")  
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String userId = request.getParameter("userid");
		String userName = request.getParameter("username");
		String userPwd = request.getParameter("userpwd");
		String userPwd2 = request.getParameter("userpwd2"); 
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String age =request.getParameter("age");
		String gender = request.getParameter("gender");

	
response.setContentType("text/html; charset=utf-8");  // 어떤 타입으로 출력할것인지 명시하였다

PrintWriter out = response.getWriter(); //getWriter() 출력스트림. 응답할 정보를 갖고 있는 객체에 출력스트림을 써서 out 객체에 담았다.

int result = new MemberService().insertMember(userId, userName , userPwd,email,phone,age,gender);

	RequestDispatcher view = null;

if(result > 0 ) {

request.setAttribute("insertResult", "success");
view = request.getRequestDispatcher("index.jsp");

}else {

	request.setAttribute("insertResult", "fail");
	view = request.getRequestDispatcher("views/member/memberAccept.jsp");

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