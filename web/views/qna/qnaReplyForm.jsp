<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.Member" %>    
<%
	int qnaNum = Integer.parseInt(request.getParameter("qnum"));
	int currentPage = Integer.parseInt(request.getParameter("page"));
	
	/* Member loginUser = (Member)session.getAttribute("loginUser"); */
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>travelduo</title>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<div class="container">
<div class="qna_margin">
<div class="row">
 <h2 class="qna_head"><%= qnaNum %>번 글의 답글달기</h2>
 <hr>
 </div>
		<form class="form-horizontal" action="/travelduo/qreply" method="post">
		<input type ="hidden" name="qnum" value="<%=qnaNum %>">
		<input type="hidden" name="page" value="<%= currentPage %>">
			<div class="form-group">
				<label for="title" class="col-xs-1 col-xs-offset-3">제목</label>
				<div class="col-xs-4">
			    	<input type="text" name="qtitle" value=""> 
			    </div>
			</div>
			<div class="form-group">
				<label for="writer" class="col-xs-1 col-xs-offset-3">작성자</label>
				<div class="col-xs-2">
			     <input type="text" name="qwriter" readonly value="<%= loginUser.getUserId() %>">
			    </div>
			</div>
			<div class="form-group">
				<label for="content" class="col-xs-1 col-xs-offset-3">내용</label>
				<div class="col-xs-4"><textarea class="form-control" rows="5" id="content" name="qcontent"></textarea>
			    </div>
			</div>
			<center>
			<tr>
				<th colspan="2">
					<input type="submit" value="답글등록" class="btn btn-success btn-sm"> &nbsp; 
					<button onclick="history.go(-1); return false;" class="btn btn-primary btn-sm">이전 페이지로 이동</button>
					<a href="/travelduo/qlist?page=<%= currentPage %>" class="btn btn-info btn-sm">목록</a>
				</th>
			</tr>	
			</center>
			</form>
			</div>
			</div>
<hr>
<%@ include file="../common/footer.jsp" %>
</body>
<style>
.qna_margin{
	margin-top:100px;
}
.qna_head{
	margin-left:450px;
}
</style>
</html>





