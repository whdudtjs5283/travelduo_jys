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
 * Servlet implementation class MatchIfoInsertServlet
 */
@WebServlet("/miinsert")
public class MatchIfoInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MatchIfoInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	         throws ServletException, IOException {
	      // 여행정보 입력 처리용 컨트롤러
	   
	      //2. 업로드할 파일의 용량 설정 : 10Mbyte 로 제한한다면
	            int maxSize = 1024 * 1024 * 10;
	            
	            //3. 업로드할 파일의 저장 폴더 지정
	            //저장 폴더가 현재 구동중인 웹컨테이너(WAS: 톰켓)에서
	            //실행중인 웹애플리케이션 안에 있는 폴더일 경우
	            //루트 경로 알아냄
	            String root = request.getSession().getServletContext().getRealPath("/");
	            //System.out.println("root : " + root);
	            //업로드되는 파일이 저장되는 폴더명과 루트를 연결함
	            String savePath = root + "file/matchinfo";
	            //System.out.println("savePath : " + savePath);
	            
	            //웹서버 컴퓨터의 폴더일 경우
	            //String savePath = "c:\\webapp\\files\\notice";
	            
	            //4. cos.jar 라이브러리를 사용할 경우
	            //MultipartRequest 객체를 생성함
	            //객체 생성과 동시에 자동 파일이 업로드 됨 : 지정한 폴더에 자동 저장됨.
	            //request 객체가 MultipartRequest 객체로 바뀜
	            MultipartRequest mrequest = new MultipartRequest(
	                  request, savePath, maxSize, "UTF-8", 
	                  new DefaultFileRenamePolicy());
	            
	      // 2. 전송온 값 꺼내서 변수 또는 도메인객체에 저장
	      MatchInfo minfo = new MatchInfo();

	      minfo.setMatchArea(mrequest.getParameter("matcharea"));
	      minfo.setMatchCity(mrequest.getParameter("matchcity"));
	      minfo.setMatchYear(mrequest.getParameter("matchyear"));
	      minfo.setMatchMonth(mrequest.getParameter("matchmonth"));
	      minfo.setMatchPlan(mrequest.getParameter("matchplan"));
	      minfo.setMatchPrivate(mrequest.getParameter("matchprivate"));
	      minfo.setUserId(mrequest.getParameter("userid"));
	      
	      String matchPhoto = mrequest.getFilesystemName("matchphoto");
	      minfo.setMatchPhoto(matchPhoto);

	      // 확인
	      System.out.println("minfo : " + minfo);

	      // 3.서비스모델로 객체 전달하고 결과 받기
	      int result = new MatchInfoService().insertMatchInfo(minfo);

	      System.out.println("result :" + result);

	      // 4. 받은결과로 성공 실패에 따라 뷰를 선택해서 내보냄

	      response.setContentType("text/html; charset=utf-8"); // 한글 안깨지게
	      PrintWriter out = response.getWriter(); // getWriter()

	      if (result > 0) {

	         out.println("<script type='text/javascript'>");
	         out.println("alert('등록완료!');");
	         out.println("history.back();");
	         out.println("</script>");
	         out.flush();
	         return;
	      } else {
	         out.println("<script type='text/javascript'>");
	         out.println("alert('등록실패!');");
	         out.println("history.back();");
	         out.println("</script>");
	         out.flush();
	         return;
	      }

	   }

	   protected void doPost(HttpServletRequest request, HttpServletResponse response)
	         throws ServletException, IOException {
	      // TODO Auto-generated method stub
	      doGet(request, response);
	   }

	}
