package notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeUpdateServlet
 */
@WebServlet("/nupdate")
public class NoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoticeUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		int currentPage = Integer.parseInt(request.getParameter("page"));
		
		RequestDispatcher view = null;
		
		// 전송온 값 꺼내서, Notice 객체에 저장하기
		Notice notice = new Notice();
		// System.out.println(request.getParameter("title"));
		notice.setNoticeNo(Integer.parseInt(request.getParameter("no")));
		notice.setNoticeTitle(request.getParameter("title"));
		notice.setNoticeWriter(request.getParameter("writer"));
		notice.setNoticeContent(request.getParameter("content"));
		
		// 서비스모델로 notice 객체 전달하고 결과 받기
		int result = new NoticeService().updateNotice(notice);

		// 받은 결과를 가지고 성공/실패 뷰 선택 내보내기
		if (result > 0) {
			// 공지글 수정 성공시에는 공지글 상세보기 출력
			response.sendRedirect("/travelduo/ndetail?no=" + notice.getNoticeNo() +"&page=" + currentPage);
		} else {
			view = request.getRequestDispatcher("views/notice/noticeError.jsp");
			request.setAttribute("message", 
					notice.getNoticeNo() + "번 공지글 수정 실패!");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
