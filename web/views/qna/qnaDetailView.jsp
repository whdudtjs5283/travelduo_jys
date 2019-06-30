<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="qnaError.jsp" %>
<%@ page import="qna.model.vo.QNA, member.model.vo.Member" %>
<%
	QNA qna = (QNA)request.getAttribute("qna");
	int currentPage = ((Integer)request.getAttribute("currentPage"));
	
	/* Member loginUser = (Member)session.getAttribute("loginUser"); */
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>travelduo</title>
<link rel="stylesheet" href="/travelduo/resources/css/bootstrap.css">
<link rel="stylesheet" href="/travelduo/resources/css/main.css">
<script type="text/javascript" src="/travelduo/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
function replyForm(){
	location.href = "/travelduo/views/qna/qnaReplyForm.jsp?qnum=<%= qna.getQNANo() %>&page=<%= currentPage %>";
}
function moveUpdatePage(){
	location.href = "/travelduo/qupview?no=<%= qna.getQNANo() %>&page=<%= currentPage %>";
}

function deleteQNA(){
	location.href = "/travelduo/qdel?no=<%= qna.getQNANo() %>&page=<%= currentPage %>";
}
function deleteQNAReply(){
	location.href = "/travelduo/qdelre?no=<%= qna.getQNANo() %>&page=<%= currentPage %>";
}
</script>
</head>
<body>
 <%@ include file="../common/header.jsp" %> 
 <div class="container">
	<div class="qna_margin">
	<div class="row">
		<h2 class="qna_head"><%= qna.getQNANo() %> 번 QNA 상세보기</h2>
		<hr>
	</div> 
		<form class="form-horizontal" action="" method="post">
			<div class="form-group">
				<label for="title" class="col-md-12 col-md-offset-1">제목 &nbsp; &nbsp; &nbsp;<%= qna.getQNATitle() %></label>
			</div>
			<div class="form-group">
				<label for="writer" class="col-md-12 col-md-offset-1">작성자 &nbsp; &nbsp; &nbsp; <%= qna.getQNAWriter() %></label>
			</div>
			<div class="form-group">
				<label for="content" class="col-md-6 col-md-offset-1">내용
				<textarea class="form-control" rows="5" id="content" name="content" readonly><%= qna.getQNAContent() %></textarea></label>
			</div>
			<div>
			
	<tr>
	<div class="button">
		<th colspan="2">
		<% if(loginUser != null && loginUser.getUserId().equals("admin") && qna.getQNAReply() == 0){ %>
			<input type="button" onclick="replyForm();" class="btn btn-primary btn-sm" value="답글달기">&nbsp;
		<% }else if(loginUser != null && qna.getQNAReply() == 1){  %>
		
		<% } %>
		</th>	
	</tr>
			
			<% if(loginUser.getUserId().equals(qna.getQNAWriter())){ %>
				<button type="button" onclick="moveUpdatePage();" class="btn btn-success btn-sm">수정하기</button> 				
				<% }if(loginUser != null && qna.getQNAReply()==0 && (loginUser.getUserId().equals(qna.getQNAWriter()) || loginUser.getUserId().equals("admin"))) { %>
					<button type="button" onclick="deleteQNA();" class="btn btn-danger btn-sm">삭제하기</button>
				<% }if(loginUser != null && qna.getQNAReply()==1 && (loginUser.getUserId().equals(qna.getQNAWriter()))) { %> 
				<button type="button" onclick="deleteQNAReply();" class="btn btn-danger btn-sm">답글삭제</button>
				<% } %>
				<a type="button" class="btn btn-info btn-sm" href="/travelduo/qlist">목록</a> 
				</div>
			</div>
		</form>
		</div>	


<%@ include file="../common/footer.jsp" %>
	<script type="text/javascript" src="/travelduo/resources/js/bootstrap.min.js"></script>
</body>
<style>
	.qna_margin {
		margin-top:100px;
	}
	.qna_head{
		margin-left:450px;
	}
	.form-horizontal{
		margin-left:250px;
	}
	.button{
		margin-left:200px;
	}
</style>
</html>









