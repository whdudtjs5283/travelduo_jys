package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;

/**
 * Servlet implementation class memberDelete
 */
@WebServlet("/mdelete")
public class MemberDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				String userId = request.getParameter("userid");
				String userPwd = request.getParameter("userpwd");
				
				int result = new MemberService().deleteMember(userId, userPwd);
				
				response.setContentType("text/html; charset=utf-8"); 
					RequestDispatcher view = null;

				if(result > 0) {
					HttpSession session=request.getSession(false);

					if(session!=null) {
						session.invalidate();}
					request.setAttribute("result", "success");
					view = request.getRequestDispatcher("index.jsp");

				}else {
					request.setAttribute("result", "fail");
					view = request.getRequestDispatcher("views/member/memberDelete.jsp");
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
