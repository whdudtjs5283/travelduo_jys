package matchreview.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import matchreview.model.service.MatchReviewService;
import matchreview.model.vo.MatchReview;

/**
 * Servlet implementation class MatchReviewServlet
 */
@WebServlet("/mreview")
public class MatchReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatchReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 전송온 값에 한글이 있다면 인코딩 처리함
		request.setCharacterEncoding("utf-8");
		
		//2. 전송온 값 꺼내서 변수 또는 도메인객체에 저장
		MatchReview mreview = new MatchReview();
		
		mreview.setUserName(request.getParameter("username"));
		mreview.setEmail(request.getParameter("email"));
		mreview.setPhone(request.getParameter("phone"));
		mreview.setReview(request.getParameter("review"));
		
		System.out.println("mreview : " + mreview);
		
		//3. 서비스모델로 객체 전달하고 결과 받기
		int result = new MatchReviewService().insertReview(mreview);
		
		
		//4 받은 결과로 뷰 선택
		response.setContentType("text/html; charset=utf-8");
		  PrintWriter out = response.getWriter(); // getWriter()
		 RequestDispatcher view = request.getRequestDispatcher("index2.jsp");

		      if (result > 0) {
		    	  out.println("<script type='text/javascript'>");
			         out.println("alert('전송완료!');");
			         out.println("history.back();");
			         out.println("</script>");
			         out.flush();
			         return;
		      
		      }else {
		    	  request.setAttribute("result", "fail");
		      }
		      view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
