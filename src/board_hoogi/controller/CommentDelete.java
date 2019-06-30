package board_hoogi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board_hoogi.model.service.Product_Hoogi_Service;

/**
 * Servlet implementation class CommentDelete
 */
@WebServlet("/replydel")
public class CommentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ReplyNo = Integer.parseInt(request.getParameter("cnum"));
		int HoogiNo = Integer.parseInt(request.getParameter("bnum"));
		int currentPage = Integer.parseInt(request.getParameter("page"));
		//int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		int result = new Product_Hoogi_Service().deleteComment(ReplyNo);
		System.out.println("리플 번호 : " + Integer.parseInt(request.getParameter("cnum")));
		System.out.println("원글 번호 : " + Integer.parseInt(request.getParameter("bnum")));
		
		if(result >0) {
			
			//디테일 페이지로 가야함
			response.sendRedirect("/travelduo/bdetail?bnum=" + HoogiNo +"&page=" +currentPage );
		}else {
			RequestDispatcher view = 
					request.getRequestDispatcher("views/board/hoogierror.jsp");
			request.setAttribute("message", 
					HoogiNo + "번 게시글 삭제 실패!");
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
