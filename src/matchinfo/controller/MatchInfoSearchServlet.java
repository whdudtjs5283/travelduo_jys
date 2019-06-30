package matchinfo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import matchinfo.model.service.MatchInfoService;
import matchinfo.model.vo.MatchInfo;

/**
 * Servlet implementation class MatchSearchServlet
 */
@WebServlet("/msearch")
public class MatchInfoSearchServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatchInfoSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // 페이지별로 출력되는 게시글 제목 검색 처리용 컨트롤러
      // 출력될 페이지 기본값 지정
      request.setCharacterEncoding("utf-8");
      
      //String matchArea = request.getParameter("keyword");
      String matchArea = request.getParameter("matcharea");
      String matchYear = request.getParameter("matchyear");
      System.out.println("지역값 :    " + matchArea + "  날짜값 :   " + matchYear);
      

      MatchInfoService ms = new MatchInfoService();

      // 현재 페이지에 출력할 제목 검색 목록 조회
      ArrayList<MatchInfo> list = ms.profileMatch(matchArea, matchYear);

      response.setContentType("text/html; charset=utf-8");
      RequestDispatcher view = null;
      if (list.size() > 0) {
         view = request.getRequestDispatcher("views/matchinfo/matchSearchList.jsp");

         request.setAttribute("list", list);
         view.forward(request, response);
      } else {
         view = request.getRequestDispatcher("/travelduo/error.jsp");
         request.setAttribute("message", "에 대한 목록 조회 실패!");
         view.forward(request, response);
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }
}