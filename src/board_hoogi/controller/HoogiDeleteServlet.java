package board_hoogi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board_hoogi.model.service.Product_Hoogi_Service;
import board_hoogi.model.service.Product_Hoogi_Service;

/**
 * Servlet implementation class NoticeDeleteServlet
 */
@WebServlet("/bdel")
public class HoogiDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HoogiDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전송된 글번호의 공지글 삭제 처리용 컨트롤러
		int HoogiNo = Integer.parseInt(request.getParameter("bnum"));
		//int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		int result = new Product_Hoogi_Service().deleteHoogi(HoogiNo);
		System.out.println("페이지값 : " + Integer.parseInt(request.getParameter("currentPage")));
		
		if(result >0) {
			//삭제 성공시 후기글 목록보기 출력
			//response.sendRedirect("/travleduo/blist?page=" + Integer.parseInt(request.getParameter("currentPage")));
			response.sendRedirect("/travelduo/blist?page=1");
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
