package board_hoogi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board_hoogi.model.service.Product_Hoogi_Service;
import board_hoogi.model.vo.Product_Hoogi;

/**
 * Servlet implementation class NoticeUpdateViewServlet
 */
@WebServlet("/bupview")
public class HoogiUpdateViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HoogiUpdateViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전송온 글번호에 대한 공지글 수정페이지 출력용 컨트롤러
		int HoogiNo = Integer.parseInt(request.getParameter("bnum"));
		int currentPage = Integer.parseInt(request.getParameter("page"));
		System.out.println("게시글번호 : " + HoogiNo);
		System.out.println("current page : " + currentPage );
		
		Product_Hoogi Phoogi = new Product_Hoogi_Service().selectHoogiNo(HoogiNo);

		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher view = null;
		if(Phoogi != null) {
			view = request.getRequestDispatcher("views/board/hoogiUpdateView.jsp");
			request.setAttribute("Phoogi", Phoogi);
			request.setAttribute("page", currentPage);
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher("views/board/hoogiError.jsp");
			request.setAttribute("message", HoogiNo + "글에 대한 수정페이지 이동 실패!");
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
