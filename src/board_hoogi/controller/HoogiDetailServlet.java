package board_hoogi.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board_hoogi.model.service.Product_Hoogi_Service;
import board_hoogi.model.vo.Product_Hoogi;
import comment.model.service.HComment_Service;
import comment.model.vo.HComment;

/**
 * Servlet implementation class NoticeDetailServlet
 */
@WebServlet("/bdetail")
public class HoogiDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HoogiDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전송된 글번호에 대한 상세보기 처리용 컨트롤러
		response.setContentType("text/html; charset=utf-8");
		
		//여기서 에러남..
		int HoogiNo = Integer.parseInt(request.getParameter("bnum"));
		
		//댓글 입력 작업때문에 밑에 int currentPage는 주석처리했는데 , 원글 수정때문에 다시 품
		
		int currentPage = Integer.parseInt(request.getParameter("page"));
		
		Product_Hoogi_Service Pservice = new Product_Hoogi_Service();
		
		Pservice.addReadCount(HoogiNo);
		
		Product_Hoogi Phoogi = Pservice.selectHoogiNo(HoogiNo);
		
		/// 여기서부터 댓글에 대한 부분을 삽입
		//댓글을 페이징하지않고 그냥 10개까지만 달수있도록 만듬
		
		// 페이징은 하지않을거지만, board번호는 필요해서 board번호를 넘겨줘야함.
		//리스트에서 댓글이 보이는게 아니기 때문에 디테일서블릿에서 해야될듯
		
		//아래 잘못됨...여러개를 clist에 넣어야되기때문임

		//내생각에 쿼리문을 하나 따로 만들어야됨 보드명 같은 댓글명만 긁어오는거로
			ArrayList<HComment> clist = new HComment_Service().select_HComment(HoogiNo);
			// clist가 돌아온값이 있어야 보내는지 없어도보내는지..
			//내 생각에 있든 없든 보내고, 뷰단에서 넘버가 같을때 출력
		
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher view = null;
		
		//임시적으로 돌아오는 값 테스트
	/*	if(clist ==! null) 
		{ view = request.getRequestDispatcher("views/board/hoogiError.jsp");
		request.setAttribute("message", HoogiNo + "번 글 clist 조회값이 없음!");
		view.forward(request, response);
		}*/
		
		
		//if(Phoogi != null && clist != null) {
			if(Phoogi != null) {
			view = request.getRequestDispatcher("views/board/hoogiDetailView.jsp");
			request.setAttribute("Phoogi", Phoogi);
			request.setAttribute("clist", clist);
			request.setAttribute("currentPage", currentPage);
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher("views/board/hoogiError.jsp");
			request.setAttribute("message", HoogiNo + "클릭한 번호 게시물 조회실패!");
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
