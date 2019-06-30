package qna.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qna.model.service.QNAService;
import qna.model.vo.QNA;

/**
 * Servlet implementation class QNADetailServlet
 */
@WebServlet("/qdetail")
public class QNADetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QNADetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전송된 글번호에 대한 상세보기 처리용 컨트롤러
				int qnaNo = Integer.parseInt(request.getParameter("no"));
				int currentPage = Integer.parseInt(request.getParameter("page"));
				
				QNA qna = new QNAService().selectOne(qnaNo);
				
				response.setContentType("text/html; charset=utf-8");
				RequestDispatcher view = null;
				if(qna != null) {
					view = request.getRequestDispatcher("views/qna/qnaDetailView.jsp");
					request.setAttribute("qna", qna);
					request.setAttribute("currentPage", currentPage);
					view.forward(request, response);
				}else {
					view = request.getRequestDispatcher("views/qna/qnaError.jsp");
					request.setAttribute("message", qnaNo + "번 qna 상세보기 실패!");
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
