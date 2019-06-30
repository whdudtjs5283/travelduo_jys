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
 * Servlet implementation class QNAReplyServlet
 */
@WebServlet("/qreply")
public class QNAReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QNAReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 댓글달기 처리용 컨트롤러

				request.setCharacterEncoding("utf-8");

				int currentPage = Integer.parseInt(request.getParameter("page"));
				int qnaNum = Integer.parseInt(request.getParameter("qnum"));
				String qnaTitle = request.getParameter("qtitle");
				String qnaWriter = request.getParameter("qwriter");
				String qnaContent = request.getParameter("qcontent");

				QNAService qservice = new QNAService();

				// 원글 조회
				QNA originQNA = qservice.selectQNA(qnaNum);

				// 댓글 객체 생성
				QNA replyQNA = new QNA();
				replyQNA.setQNAContent(qnaContent);
				replyQNA.setQNATitle(qnaTitle);
				replyQNA.setQNAWriter(qnaWriter);
				replyQNA.setQNAReply(originQNA.getQNAReply() + 1);
				replyQNA.setQNARef(originQNA.getQNARef());
				

				// 댓글 등록
				int result = qservice.insertReply(replyQNA);		

				if (result > 0) {
					response.sendRedirect("/travelduo/qlist?page=" + currentPage);
				} else {
					RequestDispatcher view = request.getRequestDispatcher("views/qna/qnaError.jsp");
					request.setAttribute("message", qnaNum + "번글에 대한 답글 등록 실패!");
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
