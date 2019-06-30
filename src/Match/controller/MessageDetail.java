package Match.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Match.service.MatchService;
import Match.vo.MatchMessage;
import board_hoogi.model.service.Product_Hoogi_Service;
import board_hoogi.model.vo.Product_Hoogi;
import matchinfo.model.service.MatchInfoService;
import matchinfo.model.vo.MatchInfo;
import member.model.service.MemberService;
import member.model.vo.Member;


/**
 * Servlet implementation class MessageDetail
 */
@WebServlet("/messagedetail")
public class MessageDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher view = null;
		
		int MessageNo = Integer.parseInt(request.getParameter("bnum"));
		int currentPage = Integer.parseInt(request.getParameter("page"));
		System.out.println("메세지 번호 : " + MessageNo + "페이지번호 :  " + currentPage);
		
		
		//근데 원글번호에 해당하는 MessageNo 는 없어도 될듯함
		MatchService MatchService = new MatchService();
		
		
		//이거 추가후 구동임
		MatchService.addReadCount(MessageNo);
		
		
		MatchMessage Message = MatchService.selectMessage(MessageNo);
		
		System.out.println("선택된 메세지 번호 :   " + Message.getMessage_No());
		
		//ArrayList<Member> mlist = new ArrayList<Member>();
		//선언만 한거고 다오를 안가져옴
		
		
		//fromuser를 다오에 보내면됨
		String fromUserID = Message.getFromUser();
		
		
		MemberService MService = new MemberService();
		
		//멤버객체
		Member member = MService.selectMember(fromUserID);
		System.out.println("선택된 멤버 출력해보기 :   " + member.toString());
		
		MatchInfoService matinfoService = new MatchInfoService();
		
		
		//여행정보 객체
		MatchInfo matchinfo = matinfoService.selectMatchinfo(fromUserID);
		
		if (  matchinfo==null && (Message !=null && member !=null)  ) {
			System.out.println("선택된 여행정보가 없습니다"); 
			System.out.println("돌아온 메세지 객체는 : " + Message.toString());
			System.out.println("돌아온 멤버 객체는 : " + member.toString());
			System.out.println("돌아온 커렌트 페이지 : " + currentPage);
			view = request.getRequestDispatcher("views/message/messageDetail.jsp");
			
			request.setAttribute("Message", Message);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("member", member);
			
			view.forward(request, response);
			}
		
		else if( (Message !=null) && (matchinfo!=null) ){
				System.out.println("돌아온 메세지 객체는 : " + Message.toString());
				view = request.getRequestDispatcher("views/message/messageDetail.jsp");
				request.setAttribute("Message", Message);
				request.setAttribute("currentPage", currentPage);
				request.setAttribute("member", member);
				request.setAttribute("matchinfo", matchinfo);
				
				view.forward(request, response);
			}
		
		
		

		
		
		
		
		
	}//두겟부분

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
