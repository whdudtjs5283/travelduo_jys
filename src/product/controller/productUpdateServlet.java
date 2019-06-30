package product.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import product.model.service.ProductService;
import product.model.vo.Product;

/**
 * Servlet implementation class productUpdateServlet
 */
@WebServlet("/pupdate")
public class productUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		RequestDispatcher view = null;
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			view = request.getRequestDispatcher("views/product/productError.jsp");
			request.setAttribute("message", "이미지 등록 실패!");
			view.forward(request, response);			
		}
		
		int maxSize = 1024 * 1024 * 10;
		
		String root = request.getSession().getServletContext().getRealPath("/");
		
		String savePath = root + "resources/images/product";
		
		MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		Product product = new Product();
		product.setProductNum(mrequest.getParameter("num"));
		product.setProductName(mrequest.getParameter("title"));
		product.setCountry(mrequest.getParameter("coun"));
		product.setDestination(mrequest.getParameter("des"));
		product.setDestinationInfo(mrequest.getParameter("desinfo"));
		product.setTouristSpot1(mrequest.getParameter("ts1"));
		product.setTouristSpot1Info(mrequest.getParameter("ts1info"));
		product.setTouristSpot2(mrequest.getParameter("ts2"));
		product.setTouristSpot2Info(mrequest.getParameter("ts2info"));
		product.setTouristSpot3(mrequest.getParameter("ts3"));
		product.setTouristSpot3Info(mrequest.getParameter("ts3info"));
		product.setrProduct(mrequest.getParameter("rp"));
		String oBannerImage1 = mrequest.getFilesystemName("bimg1");
		product.setoBannerImage1(oBannerImage1);
		String oBannerImage2 = mrequest.getFilesystemName("bimg2");
		product.setoBannerImage2(oBannerImage2);
		String oBannerImage3 = mrequest.getFilesystemName("bimg3");
		product.setoBannerImage3(oBannerImage3);
		String oDestinationImage = mrequest.getFilesystemName("dimg");
		product.setoDestinationImage(oDestinationImage);
		String oTouristImage1 = mrequest.getFilesystemName("timg1");
		product.setoTouristImage1(oTouristImage1);
		String oTouristImage2 = mrequest.getFilesystemName("timg2");
		product.setoTouristImage2(oTouristImage2);
		String oTouristImage3 = mrequest.getFilesystemName("timg3");
		product.setoTouristImage3(oTouristImage3);
		
		
		if(oBannerImage1 != null) {
			//파일명 rename 처리 진행
			//새로운 파일명 만들기 : "년월일시분초.확장자"
			SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyyMMddHHmmss_1");
			Date currentTime = new Date(System.currentTimeMillis());
			String rBannerName1 = sdf.format(currentTime) 
					+ "." + oBannerImage1.substring(
							oBannerImage1.lastIndexOf(".") + 1);
			//System.out.println(renameFileName);
			
			//java.io.File 의 renameTo() 사용함
			File originFile = new File(savePath + "\\" + oBannerImage1);
			File renameFile = new File(savePath + "\\" + rBannerName1);
			
			//파일 이름바꾸기 실행함
			//이름바꾸기가 실패할 경우에는 직접 바꾸기 처리함
			//직접 바꾸기는 원본 파일에 대한 복사본 파일을 만들고 원본 삭제함
			if(!originFile.renameTo(renameFile)) {
				//renameTo() 가 실패했을 때
				int read = -1;
				byte[] buf = new byte[1024];
				//한번에 읽을 배열크기 지정
				
				//원본파일을 읽기 위한 입력스트림 생성
				FileInputStream fin = new FileInputStream(originFile);
				//읽은 내용 기록할 복사본 파일에 대한 출력스트림 생성
				FileOutputStream fout = new FileOutputStream(renameFile);
				
				//원본 읽어서 복사본에 기록 처리
				while((read = fin.read(buf, 0, buf.length)) != -1) {
					fout.write(buf, 0, read);
				}
				
				//스트림 반납
				fin.close();
				fout.close();
				
				//원본 파일 삭제
				originFile.delete();
			}  //rename if
			
			
			product.setrBannerImage1(rBannerName1);
			
			if(!mrequest.getParameter("obi1").equals(product.getoBannerImage1()))
				new File(savePath + "\\" + mrequest.getParameter("rbi1")).delete();
		
		}else { // 첨부 파일이 변경되지 않았을 때
			product.setoBannerImage1(mrequest.getParameter("obi1"));
			product.setrBannerImage1(mrequest.getParameter("rbi1"));
		}
		
		if(oBannerImage2 != null) {
			//파일명 rename 처리 진행
			//새로운 파일명 만들기 : "년월일시분초.확장자"
			SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyyMMddHHmmss_2");
			Date currentTime = new Date(System.currentTimeMillis());
			String rBannerName1 = sdf.format(currentTime) 
					+ "." + oBannerImage2.substring(
							oBannerImage2.lastIndexOf(".") + 1);
			//System.out.println(renameFileName);
			
			//java.io.File 의 renameTo() 사용함
			File originFile = new File(savePath + "\\" + oBannerImage2);
			File renameFile = new File(savePath + "\\" + rBannerName1);
			
			//파일 이름바꾸기 실행함
			//이름바꾸기가 실패할 경우에는 직접 바꾸기 처리함
			//직접 바꾸기는 원본 파일에 대한 복사본 파일을 만들고 원본 삭제함
			if(!originFile.renameTo(renameFile)) {
				//renameTo() 가 실패했을 때
				int read = -1;
				byte[] buf = new byte[1024];
				//한번에 읽을 배열크기 지정
				
				//원본파일을 읽기 위한 입력스트림 생성
				FileInputStream fin = new FileInputStream(originFile);
				//읽은 내용 기록할 복사본 파일에 대한 출력스트림 생성
				FileOutputStream fout = new FileOutputStream(renameFile);
				
				//원본 읽어서 복사본에 기록 처리
				while((read = fin.read(buf, 0, buf.length)) != -1) {
					fout.write(buf, 0, read);
				}
				
				//스트림 반납
				fin.close();
				fout.close();
				
				//원본 파일 삭제
				originFile.delete();
			}  //rename if
			
			product.setrBannerImage2(rBannerName1);
			
			if(!mrequest.getParameter("obi2").equals(product.getoBannerImage2()))
				new File(savePath + "\\" + mrequest.getParameter("rbi2")).delete();
		
		}else { // 첨부 파일이 변경되지 않았을 때
			product.setoBannerImage2(mrequest.getParameter("obi2"));
			product.setrBannerImage2(mrequest.getParameter("rbi2"));
		}
		
		if(oBannerImage3 != null) {
			//파일명 rename 처리 진행
			//새로운 파일명 만들기 : "년월일시분초.확장자"
			SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyyMMddHHmmss_3");
			Date currentTime = new Date(System.currentTimeMillis());
			String rBannerName1 = sdf.format(currentTime) 
					+ "." + oBannerImage3.substring(
							oBannerImage3.lastIndexOf(".") + 1);
			//System.out.println(renameFileName);
			
			//java.io.File 의 renameTo() 사용함
			File originFile = new File(savePath + "\\" + oBannerImage3);
			File renameFile = new File(savePath + "\\" + rBannerName1);
			
			//파일 이름바꾸기 실행함
			//이름바꾸기가 실패할 경우에는 직접 바꾸기 처리함
			//직접 바꾸기는 원본 파일에 대한 복사본 파일을 만들고 원본 삭제함
			if(!originFile.renameTo(renameFile)) {
				//renameTo() 가 실패했을 때
				int read = -1;
				byte[] buf = new byte[1024];
				//한번에 읽을 배열크기 지정
				
				//원본파일을 읽기 위한 입력스트림 생성
				FileInputStream fin = new FileInputStream(originFile);
				//읽은 내용 기록할 복사본 파일에 대한 출력스트림 생성
				FileOutputStream fout = new FileOutputStream(renameFile);
				
				//원본 읽어서 복사본에 기록 처리
				while((read = fin.read(buf, 0, buf.length)) != -1) {
					fout.write(buf, 0, read);
				}
				
				//스트림 반납
				fin.close();
				fout.close();
				
				//원본 파일 삭제
				originFile.delete();
			}  //rename if
			
			product.setrBannerImage3(rBannerName1);
			
			if(!mrequest.getParameter("obi3").equals(product.getoBannerImage3()))
				new File(savePath + "\\" + mrequest.getParameter("rbi3")).delete();
		
		}else { // 첨부 파일이 변경되지 않았을 때
			product.setoBannerImage3(mrequest.getParameter("obi3"));
			product.setrBannerImage3(mrequest.getParameter("rbi3"));
		}
		
		
		if(oDestinationImage != null) {
			//파일명 rename 처리 진행
			//새로운 파일명 만들기 : "년월일시분초.확장자"
			SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyyMMddHHmmss_4");
			Date currentTime = new Date(System.currentTimeMillis());
			String rBannerName1 = sdf.format(currentTime) 
					+ "." + oDestinationImage.substring(
							oDestinationImage.lastIndexOf(".") + 1);
			//System.out.println(renameFileName);
			
			//java.io.File 의 renameTo() 사용함
			File originFile = new File(savePath + "\\" + oDestinationImage);
			File renameFile = new File(savePath + "\\" + rBannerName1);
			
			//파일 이름바꾸기 실행함
			//이름바꾸기가 실패할 경우에는 직접 바꾸기 처리함
			//직접 바꾸기는 원본 파일에 대한 복사본 파일을 만들고 원본 삭제함
			if(!originFile.renameTo(renameFile)) {
				//renameTo() 가 실패했을 때
				int read = -1;
				byte[] buf = new byte[1024];
				//한번에 읽을 배열크기 지정
				
				//원본파일을 읽기 위한 입력스트림 생성
				FileInputStream fin = new FileInputStream(originFile);
				//읽은 내용 기록할 복사본 파일에 대한 출력스트림 생성
				FileOutputStream fout = new FileOutputStream(renameFile);
				
				//원본 읽어서 복사본에 기록 처리
				while((read = fin.read(buf, 0, buf.length)) != -1) {
					fout.write(buf, 0, read);
				}
				
				//스트림 반납
				fin.close();
				fout.close();
				
				//원본 파일 삭제
				originFile.delete();
			}  //rename if
			
			product.setrDestinationImage(rBannerName1);
			
			if(!mrequest.getParameter("od").equals(product.getoDestinationImage()))
				new File(savePath + "\\" + mrequest.getParameter("rd")).delete();
		
		}else { // 첨부 파일이 변경되지 않았을 때
			product.setoDestinationImage(mrequest.getParameter("od"));
			product.setrDestinationImage(mrequest.getParameter("rd"));
		}
		
		if(oTouristImage1 != null) {
			//파일명 rename 처리 진행
			//새로운 파일명 만들기 : "년월일시분초.확장자"
			SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyyMMddHHmmss_5");
			Date currentTime = new Date(System.currentTimeMillis());
			String rBannerName1 = sdf.format(currentTime) 
					+ "." + oTouristImage1.substring(
							oTouristImage1.lastIndexOf(".") + 1);
			//System.out.println(renameFileName);
			
			//java.io.File 의 renameTo() 사용함
			File originFile = new File(savePath + "\\" + oTouristImage1);
			File renameFile = new File(savePath + "\\" + rBannerName1);
			
			//파일 이름바꾸기 실행함
			//이름바꾸기가 실패할 경우에는 직접 바꾸기 처리함
			//직접 바꾸기는 원본 파일에 대한 복사본 파일을 만들고 원본 삭제함
			if(!originFile.renameTo(renameFile)) {
				//renameTo() 가 실패했을 때
				int read = -1;
				byte[] buf = new byte[1024];
				//한번에 읽을 배열크기 지정
				
				//원본파일을 읽기 위한 입력스트림 생성
				FileInputStream fin = new FileInputStream(originFile);
				//읽은 내용 기록할 복사본 파일에 대한 출력스트림 생성
				FileOutputStream fout = new FileOutputStream(renameFile);
				
				//원본 읽어서 복사본에 기록 처리
				while((read = fin.read(buf, 0, buf.length)) != -1) {
					fout.write(buf, 0, read);
				}
				
				//스트림 반납
				fin.close();
				fout.close();
				
				//원본 파일 삭제
				originFile.delete();
			}  //rename if
			
			product.setrTouristImage1(rBannerName1);
			
			if(!mrequest.getParameter("oti1").equals(product.getoTouristImage1()))
				new File(savePath + "\\" + mrequest.getParameter("rti1")).delete();
		
		}else { // 첨부 파일이 변경되지 않았을 때
			product.setoTouristImage1(mrequest.getParameter("oti1"));
			product.setrTouristImage1(mrequest.getParameter("rti1"));
		}
		
		if(oTouristImage2 != null) {
			//파일명 rename 처리 진행
			//새로운 파일명 만들기 : "년월일시분초.확장자"
			SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyyMMddHHmmss_6");
			Date currentTime = new Date(System.currentTimeMillis());
			String rBannerName1 = sdf.format(currentTime) 
					+ "." + oTouristImage2.substring(
							oTouristImage2.lastIndexOf(".") + 1);
			//System.out.println(renameFileName);
			
			//java.io.File 의 renameTo() 사용함
			File originFile = new File(savePath + "\\" + oTouristImage2);
			File renameFile = new File(savePath + "\\" + rBannerName1);
			
			//파일 이름바꾸기 실행함
			//이름바꾸기가 실패할 경우에는 직접 바꾸기 처리함
			//직접 바꾸기는 원본 파일에 대한 복사본 파일을 만들고 원본 삭제함
			if(!originFile.renameTo(renameFile)) {
				//renameTo() 가 실패했을 때
				int read = -1;
				byte[] buf = new byte[1024];
				//한번에 읽을 배열크기 지정
				
				//원본파일을 읽기 위한 입력스트림 생성
				FileInputStream fin = new FileInputStream(originFile);
				//읽은 내용 기록할 복사본 파일에 대한 출력스트림 생성
				FileOutputStream fout = new FileOutputStream(renameFile);
				
				//원본 읽어서 복사본에 기록 처리
				while((read = fin.read(buf, 0, buf.length)) != -1) {
					fout.write(buf, 0, read);
				}
				
				//스트림 반납
				fin.close();
				fout.close();
				
				//원본 파일 삭제
				originFile.delete();
			}  //rename if
			
			product.setrTouristImage2(rBannerName1);
			
			if(!mrequest.getParameter("oti2").equals(product.getoTouristImage2()))
				new File(savePath + "\\" + mrequest.getParameter("rti2")).delete();
		
		}else { // 첨부 파일이 변경되지 않았을 때
			product.setoTouristImage2(mrequest.getParameter("oti2"));
			product.setrTouristImage2(mrequest.getParameter("rti2"));
		}
		
		if(oTouristImage3 != null) {
			//파일명 rename 처리 진행
			//새로운 파일명 만들기 : "년월일시분초.확장자"
			SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyyMMddHHmmss_7");
			Date currentTime = new Date(System.currentTimeMillis());
			String rBannerName1 = sdf.format(currentTime) 
					+ "." + oTouristImage3.substring(
							oTouristImage3.lastIndexOf(".") + 1);
			//System.out.println(renameFileName);
			
			//java.io.File 의 renameTo() 사용함
			File originFile = new File(savePath + "\\" + oTouristImage3);
			File renameFile = new File(savePath + "\\" + rBannerName1);
			
			//파일 이름바꾸기 실행함
			//이름바꾸기가 실패할 경우에는 직접 바꾸기 처리함
			//직접 바꾸기는 원본 파일에 대한 복사본 파일을 만들고 원본 삭제함
			if(!originFile.renameTo(renameFile)) {
				//renameTo() 가 실패했을 때
				int read = -1;
				byte[] buf = new byte[1024];
				//한번에 읽을 배열크기 지정
				
				//원본파일을 읽기 위한 입력스트림 생성
				FileInputStream fin = new FileInputStream(originFile);
				//읽은 내용 기록할 복사본 파일에 대한 출력스트림 생성
				FileOutputStream fout = new FileOutputStream(renameFile);
				
				//원본 읽어서 복사본에 기록 처리
				while((read = fin.read(buf, 0, buf.length)) != -1) {
					fout.write(buf, 0, read);
				}
				
				//스트림 반납
				fin.close();
				fout.close();
				
				//원본 파일 삭제
				originFile.delete();
			}  //rename if
			
			product.setrTouristImage3(rBannerName1);
			
			if(!mrequest.getParameter("oti3").equals(product.getoTouristImage3()))
				new File(savePath + "\\" + mrequest.getParameter("rti3")).delete();
		
		}else { // 첨부 파일이 변경되지 않았을 때
			product.setoTouristImage3(mrequest.getParameter("oti3"));
			product.setrTouristImage3(mrequest.getParameter("rti3"));
			
		}
		
		int result = new ProductService().updateProduct(product);
		
		if(result > 0) {
			response.sendRedirect("/travelduo/pmlist");
			System.out.println(result);
		} else {
			view = request.getRequestDispatcher("views/product/productError.jsp");
			request.setAttribute("message", "상품 수정 실패!");
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
