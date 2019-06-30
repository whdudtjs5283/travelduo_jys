package board_hoogi.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board_hoogi.model.service.Product_Hoogi_Service;
import board_hoogi.model.vo.Product_Hoogi;


/**
 * Servlet implementation class HoogiWriteServlet
 */
@WebServlet("/hwrite")
public class HoogiWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 235235L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HoogiWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view = null;
		if(!ServletFileUpload.isMultipartContent(request)) {
			//form 태그에 enctype 속성이 없다면
			view = request.getRequestDispatcher("views/board/hoogiError.jsp");
			request.setAttribute("message", 
					"form 태그에 enctype 속성이 설정되지 않았습니다.");
			view.forward(request, response);			
		}
		
		int maxSize = 1024 * 1024 * 10;
		
		//세션 부분을 빼봄
		//String root = request.getSession().getServletContext().getRealPath("/");
		
		String root = request.getSession().getServletContext().getRealPath("/");
		
		System.out.println(root + "루트 경로");
		String savePath = root + "files/hoogi";
		System.out.println(savePath + "세이브패스");
		
		
		////////////////
		MultipartRequest mrequest = new MultipartRequest(
				request, savePath, maxSize, "UTF-8", 
				new DefaultFileRenamePolicy());
		
		Product_Hoogi Phoogi = new Product_Hoogi();
		
		//Phoogi.setuse 유저아이디가 아니라 유저네임으로 해야되는거로 추측
		
		//Phoogi.setUserid(mrequest.getParameter("bwriter"));
		Phoogi.setUserid(mrequest.getParameter("bwriter"));
		Phoogi.setBtitle(mrequest.getParameter("subject"));
		Phoogi.setBcontent(mrequest.getParameter("content"));
		
		System.out.println("멀티파트로 받은 글 제목 출력");
		System.out.println("");
		System.out.println(mrequest.getParameter("subject"));
		
		String originalFileName = mrequest.getFilesystemName("upfile");
		System.out.println("파일명출력");
		System.out.println("");
		System.out.println(originalFileName);
		
		//vo객체에 추가해야되는데 일단 안함
		if(originalFileName != null) {
			//바꿀 파일명 만들기
			//"년월일시분초.확장자"
			SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyyMMddHHmmss");
			String renameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis()))
					+ "." + originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
			
			//java.io.File 객체의 renameTo() 메소드 사용
			File originFile = new File(savePath + "\\" + originalFileName);
			File renameFile = new File(savePath + "\\" + renameFileName);
			
			if(!originFile.renameTo(renameFile)) {
				//파일명 직접 바꾸기함
				//원본 파일의 내용 읽어서, 리네임 파일에 복사 기록하기
				//원본 파일 삭제함
				int read = -1;
				byte[] buf = new byte[1024];
				
				FileInputStream fin = 
						new FileInputStream(originFile);
				FileOutputStream fout = 
						new FileOutputStream(renameFile);
				
				while((read = fin.read(buf, 0, buf.length)) != -1) {
					fout.write(buf, 0, read);
				}
				
				fin.close();
				fout.close();
				originFile.delete();
			}  //renameTo
			
			Phoogi.setBoardOriginalFileName(originalFileName);
			Phoogi.setBoardRenameFileName(renameFileName);
			
			System.out.println("리네임파일네임" + renameFileName);
			
			//Phoogi.setBoardOriginalFileName(originalFileName);
			//Phoogi.setBoardRenameFileName(renameFileName);
		} //첨부파일 있을 때
		
		
		//파일은 업로드되는데 밑에 result값이 0임...
		// 파일이있을때랑 파일이 없을때랑 메소드가 두개여야하나?
		int result = new Product_Hoogi_Service().inserthoogi(Phoogi);
		
		if(result > 0) {
			//후기글 등록 성공시에는 공지글 목록보기 출력
			//response.sendRedirect("/first/nlist");
			response.sendRedirect("/travelduo/blist");
		}else {
			view = request.getRequestDispatcher("views/board/hoogiError.jsp");
			request.setAttribute("message", "새 후기 등록 실패함....");
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
