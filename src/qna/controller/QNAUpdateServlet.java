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
 * Servlet implementation class QNAUpdateServlet
 */
@WebServlet("/qupdate")
public class QNAUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QNAUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		RequestDispatcher view = null;
		
		// 전송온 값 꺼내서, QNA 객체에 저장하기
		QNA qna = new QNA();
		// System.out.println(request.getParameter("title"));
		qna.setQNANo(Integer.parseInt(request.getParameter("no")));
		qna.setQNATitle(request.getParameter("title"));
		qna.setQNAWriter(request.getParameter("writer"));
		qna.setQNAContent(request.getParameter("content"));
		
		// 서비스모델로 qna 객체 전달하고 결과 받기
		int result = new QNAService().updateQNA(qna);

		// 받은 결과를 가지고 성공/실패 뷰 선택 내보내기
		if (result > 0) {
			// 공지글 수정 성공시에는 공지글 상세보기 출력
			response.sendRedirect("/travelduo/qdetail?no=" + qna.getQNANo() + "&page=" + request.getParameter("page"));
		} else {
			view = request.getRequestDispatcher("views/qna/qnaError.jsp");
			request.setAttribute("message", 
					qna.getQNANo() + "번 공지글 수정 실패!");
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
