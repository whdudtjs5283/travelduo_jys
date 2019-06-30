package matchinfo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import matchinfo.model.service.MatchInfoService;
import matchinfo.model.vo.MatchInfo;

/**
 * Servlet implementation class MatchInfoUpdateServlet
 */
@WebServlet("/miupdate")
public class MatchInfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatchInfoUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원정보 수정 처리용 컨트롤러
		//1. 
		int maxSize = 1024 * 1024 * 10;
	       String root = request.getSession().getServletContext().getRealPath("/");
           //System.out.println("root : " + root);
           //업로드되는 파일이 저장되는 폴더명과 루트를 연결함
           String savePath = root + "file/matchinfo";
           
           MultipartRequest mrequest = new MultipartRequest(
	                  request, savePath, maxSize, "UTF-8", 
	                  new DefaultFileRenamePolicy());
		
		//2.
		MatchInfo minfo = new MatchInfo();
		
		minfo.setMatchArea(mrequest.getParameter("matcharea"));
		minfo.setMatchCity(mrequest.getParameter("matchcity"));
		minfo.setMatchYear(mrequest.getParameter("matchyear"));
		minfo.setMatchMonth(mrequest.getParameter("matchmonth"));
		minfo.setMatchPlan(mrequest.getParameter("matchplan"));
		minfo.setMatchPrivate(mrequest.getParameter("matchprivate"));		
		 String matchPhoto = mrequest.getFilesystemName("matchphoto");
	      minfo.setMatchPhoto(matchPhoto);
	      minfo.setUserId(mrequest.getParameter("userid"));

				int result = new MatchInfoService().updateMatchInfo(minfo);
				   System.out.println("minfo : " + minfo);
				//4.
				response.setContentType("text/html; charset=utf-8"); // 한글 안깨지게
				PrintWriter out = response.getWriter(); // getWriter()
				   System.out.println("result : " + result);
				if (result > 0) {

					out.println("<script type='text/javascript'>");
					out.println("alert('수정완료!');");
					out.println("history.back();");
					out.println("</script>");
					out.flush();
					return;
				} else {
					out.println("<script type='text/javascript'>");
					out.println("alert('수정실패!');");
					out.println("history.back();");
					out.println("</script>");
					out.flush();
					return;
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
