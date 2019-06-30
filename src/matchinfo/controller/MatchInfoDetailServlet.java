package matchinfo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import matchinfo.model.service.MatchInfoService;
import matchinfo.model.vo.MatchInfo;

/**
 * Servlet implementation class MatchInfoDetailViewServlet
 */
@WebServlet("/midetail")
public class MatchInfoDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatchInfoDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전송된 글번호에 대한 상세보기 처리용 컨트롤러
		int matchNum = Integer.parseInt(request.getParameter("match"));
		
		MatchInfo matchInfo = new MatchInfoService().selectOne(matchNum);
		
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher view = null;
		if(matchInfo != null) {
			view = request.getRequestDispatcher("views/matchinfo/matchSearchList.jsp");
			request.setAttribute("match", matchInfo);
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher("views/matchinfo/matchInfoError.jsp");
			request.setAttribute("message", matchNum + "번 공지글 상세보기 실패!");
			view.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
