package comment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board_hoogi.model.vo.Product_Hoogi;
import comment.model.service.HComment_Service;
import comment.model.vo.HComment;

/**
 * Servlet implementation class HCWriteServlet
 */
@WebServlet("/hcwrite")
public class HCWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HCWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher view = null;
		//if().. 
		
		String originalNum = request.getParameter("hoogiNo");
		System.out.println("전달된 원글번호 테스트" + originalNum);
		int originalNo = Integer.parseInt(originalNum);
		System.out.println("파싱 확인 :  " + originalNo);
		
		HComment hcomment = new HComment();
	
		hcomment.setUserid(request.getParameter("userid"));
		hcomment.setHCOMMENT_CONTENT(request.getParameter("content"));
		hcomment.setBOARD_NUM(originalNo);
		
		String user = hcomment.getUserid();
		String content = hcomment.getHCOMMENT_CONTENT();
		//댓글이 아직 작성된게아니므로 원글의 글번호로 가져와야함
		//int HoogiNo = hcomment.getBOARD_NUM();
		
		System.out.println("아이디  : " + user + "내용:  " 
						+ content + "원글번호 " + originalNo);
		
		int result = new HComment_Service().insertComment(hcomment, originalNo);

		if(result > 0) {
			response.sendRedirect("/travelduo/bdetail");
			
		}else {
			view = request.getRequestDispatcher("views/comment/commentError.jsp");
			request.setAttribute("message", "댓글 등록 실패각....");
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
