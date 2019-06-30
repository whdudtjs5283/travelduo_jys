package Match.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Match.service.MatchService;
import Match.vo.MatchMessage;

/**
 * Servlet implementation class MatchWriteServlet
 */
@WebServlet("/matchWrite")
public class MatchWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatchWriteServlet() {
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
		
		MatchMessage matchMessage = new MatchMessage();
		matchMessage.setFromUser(request.getParameter("fromUser"));
		matchMessage.setToUser(request.getParameter("toUser"));
		matchMessage.setContent(request.getParameter("content"));
		
		String fromUser = matchMessage.getFromUser();
		String content = matchMessage.getContent();
		System.out.println("프롬 유저 아이디 : " + fromUser + "내용"
				+ content);
		
		int result = new MatchService().insertMatch(matchMessage);
		
		if(result > 0) {
			//밑으로 수정해봄
			//response.sendRedirect("/travelduo/blist");
			//
			response.sendRedirect("/travelduo/views/message/messageEnd.jsp");
		
			
			
		}else {
			view = request.getRequestDispatcher("views/Match/MatchError.jsp");
			request.setAttribute("message", "매칭이 제대로 되지않았습니다  실패....");
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
