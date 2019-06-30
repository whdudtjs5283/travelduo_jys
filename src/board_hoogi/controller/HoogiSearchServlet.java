package board_hoogi.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board_hoogi.model.vo.Product_Hoogi;
import board_hoogi.model.service.Product_Hoogi_Service;


/**
 * Servlet implementation class NoticeSearchServlet
 */
@WebServlet("/bsearch")
public class HoogiSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HoogiSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공지글 검색 처리용 컨트롤러
		//1. 
		request.setCharacterEncoding("utf-8");
		
		String type = request.getParameter("type");
        String word = request.getParameter("word");
        int currentPage = 1;
        int limit = 10;

		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
        
        System.out.println("검색옵션 값은 :   " + type + "키워드값은 :   " + word);
        System.out.println("");
        System.out.println("currentPage값은 : " + currentPage);
        
        Product_Hoogi_Service pservice = new Product_Hoogi_Service();
      //객체를 switch 바깥에 선언함
        ArrayList<Product_Hoogi> list = new ArrayList<Product_Hoogi>();
        
        
        
        switch(type) {
        
        case "title" : 
        list = pservice.hoogiSearchTitle(word, currentPage, limit);
        break;
        
        case "content" : 
         list = pservice.hoogiSearchContent(word, currentPage, limit);
         break;
         
        case "tcmix" : 
            list = pservice.hoogiSearchTCmix(word, currentPage, limit);
            break;
            
        case "writer" : 
            list = pservice.hoogiSearchWriter(word, currentPage, limit);
            break;
        
        
        }//스위치

        int maxPage = (int) ((double) list.size() / limit + 0.9);
    	int startPage = (((int) ((double) currentPage / limit + 0.9)) - 1) * limit + 1;
    	int endPage = startPage + limit - 1;
    	if (maxPage < endPage) {
    		endPage = maxPage;
    	}
    	
    	
    	response.setContentType("text/html; charset=utf-8");
    		RequestDispatcher view = null;
    		if(list.size() > 0) {
    			
    			view = request.getRequestDispatcher("views/board/hoogiListView.jsp");
    			request.setAttribute("list", list);
    		request.setAttribute("currentPage", currentPage);
    		request.setAttribute("maxPage", maxPage);
    		request.setAttribute("startPage", startPage);
    		request.setAttribute("endPage", endPage);
    		request.setAttribute("listCount", list.size());
    		request.setAttribute("type", "type");
    		request.setAttribute("word", word);
    			
    			
    			view.forward(request, response);
    		}else {
    			view = request.getRequestDispatcher("views/board/hoogiError.jsp");
    			request.setAttribute("message", "요청된 조회결과가 없습니다.");
    			view.forward(request, response);
    		}
    		
    		
          /*  case "content" : 
           view = request.getRequestDispatcher("travelduo/SearchContent");
           	break;*/
           	
        
        
        	
	}//doget


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
