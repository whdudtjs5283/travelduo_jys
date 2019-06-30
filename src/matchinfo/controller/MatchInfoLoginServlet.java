package matchinfo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import matchinfo.model.service.MatchInfoService;
import matchinfo.model.vo.MatchInfo;

/**
 * Servlet implementation class MatchInfoLoginServlet
 */
@WebServlet("/milogin")
public class MatchInfoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatchInfoLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 요청 처리용 컨트롤러
		
				//1. 전송온 값의 한글이 있다면, 인코딩 처리함
				request.setCharacterEncoding("UTF-8"); //이거 안하면 한글깨짐
				
				//2.전송 온 값 꺼내서, 변수 또는 객체에 저장 처리
				String matchPrivate = request.getParameter("matchprivate");
			
				//확인
				System.out.println("전송온값 : " + matchPrivate);
				
				//3.서비스 모델로 추출한 값 전송하고, 결과 받기
				MatchInfo matchState = new MatchInfoService().selectLogin(matchPrivate);
				//확인
				System.out.println("matchState : " + matchState);
				
				
				//4.받은결과에 따라 성공/실패에 따른 뷰 파일 선택해서 내보냄
				//내보내는 값에 한글이 있다면, 컨텐츠타입을 셋팅함. 내보내는 정보는 response에 저장되어있음
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter(); // getWriter()
				if(matchState != null) { //로그인 성공시 처리
					
					//로그인 확인을 통한 세션 객체 생성하기
					HttpSession session = request.getSession();
					//session.setMaxInactiveInterval(10*60); //10분뒤 자동 로그아웃
					System.out.println("세션아이디 : " + session.getId());
					
					session.setAttribute("matchState", matchState); //로그인했다 안했다 기준 판단
					
					response.sendRedirect("index.jsp");
				}else { //로그인 실패시 처리
					out.println("<script type='text/javascript'>");
					out.println("alert('등록실패!');");
					out.println("history.back();");
					out.println("</script>");
					out.flush();
					return;
				}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
