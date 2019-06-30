package board_hoogi.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board_hoogi.model.service.Product_Hoogi_Service;
import board_hoogi.model.vo.Product_Hoogi;
import comment.model.service.HComment_Service;
import comment.model.vo.HComment;


/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/blist")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int currentPage = 1;
		
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		//한 페이지에 보여지는 게시글의 갯수임.
		int limit = 10;
		Product_Hoogi_Service pservice = new Product_Hoogi_Service();
		//테이블에 저장된 전체 게시글의 목록 갯수 조회
		int listCount = pservice.getListCount();
		
		
		System.out.println("총목록수 : " + listCount);
		
		//현재 페이지에 출력할 목록 조회
		ArrayList<Product_Hoogi> list = 
				new Product_Hoogi_Service().select_Hoogi(currentPage, limit);
		
		
		//해당 게시글의 댓글갯수만 조회해와야함..
		/*if(list.size()>0) {
		System.out.println("0번째 게시물 댓글수" + list.get(0).getCommentcount());
		System.out.println("1번째 게시물 댓글수" + list.get(1).getCommentcount());
		}*/
		
		
		
		
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
					"views/board/hoogiListView.jsp");
			
			request.setAttribute("list", list);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("listCount", listCount);
			
			//request.setAttribute(name, o);
			
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher("views/board/hoogiError.jsp");
			request.setAttribute("message", "");
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
