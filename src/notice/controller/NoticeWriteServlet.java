package notice.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeWriteServlet
 */
@WebServlet("/ninsert")
public class NoticeWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeWriteServlet() {
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
		
		Notice notice = new Notice();
		notice.setNoticeTitle(request.getParameter("title"));
		notice.setNoticeWriter(request.getParameter("writer"));
		notice.setNoticeContent(request.getParameter("content"));
		
		//서비스모델로 notice 객체 전달하고 결과 받기
		int result = new NoticeService().insertNotice(notice);
		
		
		//받은 결과를 가지고 성공/실패 뷰 선택 내보내기
		if(result > 0) {
			//공지글 등록 성공시에는 공지글 목록보기 출력
			response.sendRedirect("/travelduo/nlist");
		}else {
			view = request.getRequestDispatcher("views/notice/noticeError.jsp");
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
