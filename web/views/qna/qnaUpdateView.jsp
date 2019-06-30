<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="qnaError.jsp" %>
<%@ page import="qna.model.vo.QNA" %>
<%
	QNA qna = (QNA)request.getAttribute("qna");
	int currentPage = ((Integer)request.getAttribute("page")).intValue();
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
 <h2 class="qna_head"><%=  qna.getQNANo() %> 번 QNA 수정페이지</h2>
 <hr>
 </div>
		<form class="form-horizontal" action="/travelduo/qupdate?page=<%= currentPage %>" method="post">
		<input type ="hidden" name="no" value="<%= qna.getQNANo() %>">
			<div class="form-group">
				<label for="title" class="col-xs-1 col-xs-offset-3">제목</label>
				<div class="col-xs-4">
			    	<input type="text" name="title" value="<%= qna.getQNATitle() %>"> 
			    </div>
			</div>
			<div class="form-group">
				<label for="writer" class="col-xs-1 col-xs-offset-3">작성자</label>
				<div class="col-xs-2">
			      <%= qna.getQNAWriter() %>
			    </div>
			</div>
			<div class="form-group">
				<label for="content" class="col-xs-1 col-xs-offset-3">내용</label>
				<div class="col-xs-4">
				  <textarea class="form-control" rows="5" id="content" name="content"><%= qna.getQNAContent() %></textarea>
			    </div>
			</div>
			<center>
			<tr>
				<th colspan="2">
					<input type="submit" value="수정하기" class="btn btn-success btn-sm"> &nbsp; 
					<button onclick="history.go(-1); return false;" class="btn btn-info btn-sm">이전 페이지로 이동</button>
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
	margin-left:400px;
}
</style>
</html>



