<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="qnaError.jsp" %>
<%@ page import="qna.model.vo.*, java.util.*, member.model.vo.Member" %>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    
<%
/* 	ArrayList<QNA> list = 
		(ArrayList<QNA>)request.getAttribute("list"); */
	/* Member loginUser = (Member)session.getAttribute("loginUser"); */

	/* Collection<QNA> values = map.values();
	ArrayList<QNA> list = new ArrayList<QNA>(values); */
/* 	ArrayList<QNA> list = new ArrayList<QNA>(list.values());
	Collections.sort(list, new QNANoDescending()); */
	
	java.sql.Date begin = null, end = null;
	
	 /* if(request.getAttribute("search") != null){
		search = request.getAttribute("search").toString();	
	}else{
		keyword = request.getAttribute("keyword").toString();
	}  */
	
	ArrayList<QNA> list = (ArrayList<QNA>)request.getAttribute("list");
	int listCount = ((Integer)request.getAttribute("listCount")).intValue();
	int startPage = ((Integer)request.getAttribute("startPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	String search = (String)request.getAttribute("search");
	String keyword = null;
	if(search != null && search.equals("title")){
		keyword = (String)request.getAttribute("keyword");
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>travelduo</title>
<script type="text/javascript" src="/travelduo/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
function moveWritePage(){
	//글쓰기 버튼을 클릭하면, qnaWriteForm.jsp 파일로 이동함
	location.href="/travelduo/views/qna/qnaWriteForm.jsp";
}

$(function(){
	showDiv();
	
	$("input[name=item]").on("change", function(){
		showDiv();
	});
});

function showDiv(){
	if($("input[name=item]").eq(0).is(":checked")){
		$("#titleDiv").css("display", "block");
		$("#writerDiv").css("display", "none");
		$("#dateDiv").css("display", "none");
	}
	
	if($("input[name=item]").eq(1).is(":checked")){
		$("#titleDiv").css("display", "none");
		$("#writerDiv").css("display", "block");
		$("#dateDiv").css("display", "none");
	}
	
	if($("input[name=item]").eq(2).is(":checked")){
		$("#titleDiv").css("display", "none");
		$("#writerDiv").css("display", "none");
		$("#dateDiv").css("display", "block");
	}
}
</script>
</head>
<body>
<%@ include file="../common/header.jsp" %>

<br>
<br>
<br>
	<div class="container">
	<div class="qna_margin">
		<h2 align="center">QNA 목록 보기</h2>	
	</div>
<hr>
			<div class="row">
				<div class="col-md-12 col-md-offset-0">
<%-- QNA 목록 출력 --%>
					<table class="table table-striped">
				<thead>
					<tr>
						<th style="width:15%;">번호</th>
						<th style="width:60%;">제목</th>
						<th style="width:15%;">작성자</th>
						<th style="width:10%;">날짜</th>
					</tr>
				</thead>
				<tbody>
<% 
	for(QNA qna : list){
%>
<tr>
	<td align="left"><%= qna.getQNANo() %></td>
	<td>
		<% if(qna.getQNAReply() == 1){ //원글의 댓글일 때 %>
		&nbsp; &nbsp; &nbsp; [RE ] : 
		<% } %>
	<% if(loginUser != null){ //로그인한 상태 %>
		&nbsp;  <a href="/travelduo/qdetail?no=<%= qna.getQNANo() %>&page=<%= currentPage %>"><%= qna.getQNATitle() %></a>
	<% }else{ %>
		&nbsp;  <%= qna.getQNATitle() %>
	<% } %>
	</td>
	<td align="left"><%= qna.getQNAWriter() %></td>
	<td align="left"><%= qna.getQNADate() %></td>
</tr>
<%  } %>
			</tbody>
		</table>
	</div>
	</div>
<br>
<%-- 검색기능 --%>
<div id="titleDiv" class="row">
<div class="search">
	<form action="/travelduo/qsearcht" method="post">
	<input type="hidden" name="search" value="title">
	<label>제목 검색 : 
	<input type="text" name="keyword"></label>
	<input type="submit" value="검색"  class="btn btn-info btn-sm">
		<%-- 글쓰기 버튼은 로그인했을 때만 보여지게 함 --%>
<% //관리자일 때만 글쓰기 제공 처리
	 /* if(loginUser != null 
		&& loginUser.getUserId().equals("admin")){  */
	 if(loginUser != null){  %>
	<button type="button" onclick="moveWritePage();" class="btn btn-warning btn-sm">글쓰기</button>
<% } %>
	
	</form>
</div>
</div>

<br>
<%-- 페이징 처리 --%>
<div style="text-align:center;">
<% if(currentPage <= 1 && keyword == null){ %>
	[맨처음]&nbsp;
<% }else if (currentPage <= 1 && keyword != null){%>

<% }else if(currentPage > 1 && keyword != null){ %>
	
<% }else{ %>
	<a href="/travelduo/qlist?page=1">[맨처음]</a>&nbsp;
<% } %>
<% if((currentPage - 10) < startPage && (currentPage - 10) >= 1){ %>
	<a href="/travelduo/qlist?page=<%= startPage - 10 %>">[prev]</a>
<% }else{ %>
	[prev]
<% } %>
<%-- 현재 페이지가 포함된 페이지 그룹 숫자 출력 처리 --%>
<% for(int p = startPage; p <= endPage; p++){ 
		if(p == currentPage){
%>
	<font color="red" size="4"><b>[<%= p %>]</b></font>
	<% }else{ 
		if(search != null && search.equals("title")){%>
		<a href="/travelduo/qsearcht?keyword=<%= keyword %>&page=<%= p %>"><%= p %></a>
		<%}else{ %>
	<a href="/travelduo/qlist?page=<%= p %>"><%= p %></a>
<% }}} %>&nbsp;
<% if((currentPage + 10) > endPage && (currentPage + 10) <= ((maxPage/10)+1)*10){ %>
	<a href="/travelduo/qlist?page=<%= startPage + 10 %>">[next]</a>&nbsp;
<% }else{ %>
	[next]&nbsp;
<% } %>
<% if(currentPage >= maxPage && keyword == null){ %>
	[맨끝]
<% }else if (currentPage>=maxPage && keyword != null){ %>

<% }else if (currentPage < maxPage && keyword != null){ %>
	
<% }else if (currentPage < maxPage){ %>
	<a href="/travelduo/qlist?page=<%= maxPage %>">[맨끝]</a>
<% } %>
</div>
<hr>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
<style>
.qna_margin{
	margin-top:100px;
}

.search{
	margin-left:400px;
}
</style>
</html>







