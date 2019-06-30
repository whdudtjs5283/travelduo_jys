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
 * Servlet implementation class QNAUpdateViewServlet
 */
@WebServlet("/qupview")
public class QNAUpdateViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QNAUpdateViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전송온 글번호에 대한 공지글 수정페이지 출력용 컨트롤러
				int qnaNo = Integer.parseInt(request.getParameter("no"));
				int currentPage = Integer.parseInt(request.getParameter("page"));
				
				QNA qna = new QNAService().selectOne(qnaNo);
				
				response.setContentType("text/html; charset=utf-8");
				RequestDispatcher view = null;
				if(qna != null) {
					view = request.getRequestDispatcher("views/qna/qnaUpdateView.jsp");
					request.setAttribute("qna", qna);
					request.setAttribute("page", currentPage);
					view.forward(request, response);
				}else {
					view = request.getRequestDispatcher("views/qna/qnaError.jsp");
					request.setAttribute("message", qnaNo + "글에 대한 수정페이지 이동 실패!");
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
