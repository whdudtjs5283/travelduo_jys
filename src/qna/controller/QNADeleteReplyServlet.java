package qna.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qna.model.service.QNAService;

/**
 * Servlet implementation class QNADeleteReplyServlet
 */
@WebServlet("/qdelre")
public class QNADeleteReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QNADeleteReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전송된 글번호의 공지글 삭제 처리용 컨트롤러
		int qnaNo = Integer.parseInt(request.getParameter("no"));
		int currentPage = Integer.parseInt(request.getParameter("page"));
		
		int result = new QNAService().deleteQNAReply(qnaNo);
		
		if(result > 0) {
			//삭제 성공시 공지글 목록보기 출력
			response.sendRedirect("/travelduo/qlist?page=" + currentPage);
		}else {
			RequestDispatcher view = 
					request.getRequestDispatcher("views/qna/qnaError.jsp");
			request.setAttribute("message", 
					qnaNo + "번 qna 답글 삭제 실패!");
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
