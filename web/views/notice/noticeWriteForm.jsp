<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="noticeError.jsp" import="member.model.vo.Member" %>
<%-- <%
	Member loginUser = (Member)session.getAttribute("loginUser");
%>     --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>travelduo</title>
</head>
<body>
<%@ include file="../common/header.jsp" %>

	<div class="notice_margin">
		<h2 align="center">공지글 등록 페이지</h2>
		<hr>
	</div>
	
		<form method="post" action="/travelduo/ninsert">
			<div align="center">
				<label for="title" >제목</label>
				<div>
			      <input type="text" id="title" name="title" placeholder="제목">
			    </div>
			</div>
			<div align="center">
				<label for="writer">작성자</label>
				<div >
			      <input type="text" id="writer" name="writer" placeholder="작성자" value="admin">
			    </div>
			</div>
			<div align="center">
				<label for="content" >내용</label>
				<div><textarea  rows="5" id="content" name="content" placeholder="내용"></textarea>	
			    </div>
			</div>
			<center>
				<button type="submit" class="btn btn-success btn-sm">등록하기</button>
				<a type="button" class="btn btn-info btn-sm" href="javascript:history.go(-1);">이전페이지로</a> 
			</center>
		</form>

<%@ include file="../common/footer.jsp" %>
</body>
<style>
	.notice_margin {
		margin-top:100px;
	}
</style>
</html>






