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
 * Servlet implementation class QNAWriteServlet
 */
@WebServlet("/qinsert")
public class QNAWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QNAWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파일 업로드 기능이 포함된 공지글 등록 처리용 컨트롤러
		
				//1. enctype="multipart/form-data" 로 전송왔는지 확인
				response.setContentType("text/html; charset=utf-8");
				request.setCharacterEncoding("utf-8");
				RequestDispatcher view = null;
				
				QNA qna = new QNA();
				qna.setQNATitle(request.getParameter("title"));
				qna.setQNAWriter(request.getParameter("writer"));
				qna.setQNAContent(request.getParameter("content"));
				
				//서비스모델로 notice 객체 전달하고 결과 받기
				int result = new QNAService().insertQNA(qna);
				
				
				//받은 결과를 가지고 성공/실패 뷰 선택 내보내기
				if(result > 0) {
					//공지글 등록 성공시에는 공지글 목록보기 출력
					response.sendRedirect("/travelduo/qlist");
				}else {
					view = request.getRequestDispatcher("views/qna/qnaError.jsp");
					request.setAttribute("message", "새 공지글 등록 실패!");
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
