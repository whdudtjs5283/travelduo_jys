<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="noticeError.jsp" %>
<%@ page import="notice.model.vo.Notice, member.model.vo.Member" %>
<%
	Notice notice = (Notice)request.getAttribute("notice");
	int currentPage = ((Integer)request.getAttribute("currentPage"));
	/* Member loginUser = (Member)session.getAttribute("loginUser"); */
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>travelduo</title>
<script type="text/javascript">
function moveUpdatePage(){
	location.href = "/travelduo/nupview?no=<%= notice.getNoticeNo() %>&page=<%= currentPage %>";
}

function deleteNotice(){
	location.href = "/travelduo/ndel?no=" + <%= notice.getNoticeNo() %>;
}
</script>
</head>
<body>
 <%@ include file="../common/header.jsp" %> 
<div class="ndetail">
 <h2 align="center"><%= notice.getNoticeNo() %> 번 공지글 상세보기</h2>
 <hr>
 </div>
		<form method="post">
			<div align="center">
				<label for="title" >제목</label>
				<div >
			    	<%= notice.getNoticeTitle() %> 
			    </div>
			</div>
			<div align="center">
				<label for="writer">작성자</label>
				<div>
			      <%= notice.getNoticeWriter() %>
			    </div>
			</div>
			<div align="center">
				<label for="content">내용</label>
				<div>
				  <textarea rows="5" id="content" name="content" readonly><%= notice.getNoticeContent() %></textarea>
			    </div>
			</div>
			</form>
		
<tr>
<center>
	<th colspan="2">
	<% if(loginUser.getUserId().equals(notice.getNoticeWriter())){ %>
		<button onclick="moveUpdatePage();" class="btn btn-success btn-sm">수정페이지로 이동</button> &nbsp; 
		<button onclick="deleteNotice();" class="btn btn-danger btn-sm">글삭제</button> &nbsp;
	<% } %>
	<button onclick="location.href='/travelduo/nlist?page=<%= currentPage %>'; return false;" class="btn btn-info btn-sm">목록</button>
	</th>
	</center>	
</tr>
</table>
<hr>
<%@ include file="../common/footer.jsp" %>
</body>
<style>
.ndetail{
	margin-top:100px;
}
</style>
</html>









