package matchinfo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import matchinfo.model.service.MatchInfoService;
import matchinfo.model.vo.MatchInfo;

/**
 * Servlet implementation class QNAListServlet
 */
@WebServlet("/milist")
public class MatchInfoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatchInfoListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MatchInfoService mservice = new MatchInfoService();
		
		String user = request.getParameter("id");
		//테이블에 저장된 전체 목록 갯수 조회
		//int listCount = mservice.getListCount();
		//System.out.println("총목록수 : " + listCount);
		//현재 페이지에 출력할 목록 조회
		ArrayList<MatchInfo> list = mservice.selectList(user);
		//System.out.println("list : " + list);
		
		
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher view = null;
		if(list.size() > 0) {
			view = request.getRequestDispatcher(
					"views/matchinfo/matchList.jsp");
			request.setAttribute("user", user);
			request.setAttribute("list", list);
			
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher(
					"views/match/matchError.jsp");
			request.setAttribute("message", "목록 조회 실패!");
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
