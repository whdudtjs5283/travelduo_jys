package Match.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Match.service.MatchService;
import Match.vo.MatchMessage;
import board_hoogi.model.service.Product_Hoogi_Service;


/**
 * Servlet implementation class MatchMessageView
 */
@WebServlet("/matchList")
public class MatchMessageView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatchMessageView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		//userid request로 보냄.
		System.out.println("받은 커렌트 페이지 : " + request.getParameter("page"));
		int currentPage = 1;
		
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		//한 페이지에 보여지는 게시글의 갯수임.
		int limit = 5;
		//userid가 toUser여야함
		String userID = request.getParameter("userid");
		System.out.println("유저아이디 받았는지 확인 :  " + userID);
		MatchService Mservice = new MatchService();
		//테이블에 저장된 전체 게시글의 목록 갯수 조회
		int listCount = Mservice.getListMessage(userID);
		
		
		System.out.println("총 매칭 목록수 : " + listCount);
		
		//현재 페이지에 출력할 목록 조회
		
		
		ArrayList<MatchMessage> list = 
			
			new MatchService().select_MatchMessage(userID, currentPage, limit);
		
	
		
		
		int maxPage = (int)((double)listCount / limit + 0.9);
		//현재 페이지그룹(10개 페이지를 한 그룹으로 처리)에 
		//보여줄 시작 페이지 수
		//현재 페이지가 13이면 그룹은 게시글번호 11부터~20번이 보여지게 함
		int startPage = (((int)((double)currentPage / limit + 0.9)) - 1)
						* limit + 1;
		int endPage = startPage + limit - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher view = null;
		
		if(list.size() > 0) {
			view = request.getRequestDispatcher(
					"views/message/messageViewList.jsp");
			
			request.setAttribute("list", list);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("listCount", listCount);
			
			//request.setAttribute(name, o);
			
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher("views/message/messageError.jsp");
			request.setAttribute("message", "아직 도착한 쪽지나 매칭이 없습니다.");
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
