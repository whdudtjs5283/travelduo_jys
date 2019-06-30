package matchinfo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import matchinfo.model.service.MatchInfoService;

/**
 * Servlet implementation class MatchInfoDeleteServlet
 */
@WebServlet("/mdel")
public class MatchInfoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatchInfoDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전송된 글번호의 공지글 삭제 처리용 컨트롤러
		int matchInfoNo = Integer.parseInt(request.getParameter("no"));
		String id = request.getParameter("user");
		
		
		int result = new MatchInfoService().deleteMatchInfo(matchInfoNo);
		
		
		if(result > 0) {
			//삭제 성공시 공지글 목록보기 출력
			response.sendRedirect("/travelduo/milist?id="+id);
		}else {
			RequestDispatcher view = 
					request.getRequestDispatcher("views/match/matchError.jsp");
			request.setAttribute("message", 
					matchInfoNo +"번 matchInfo 삭제 실패!");
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
