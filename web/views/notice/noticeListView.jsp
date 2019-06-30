<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="noticeError.jsp" %>
<%@ page import="notice.model.vo.*, java.util.*, member.model.vo.Member" %>    

<%
/* 	ArrayList<Notice> list = 
		(ArrayList<Notice>)request.getAttribute("list"); */
	/* Member loginUser = (Member)session.getAttribute("loginUser"); */

	/* Collection<Notice> values = map.values();
	ArrayList<Notice> list = new ArrayList<Notice>(values); */
/* 	ArrayList<Notice> list = new ArrayList<Notice>(list.values());
	Collections.sort(list, new NoticeNoDescending()); */
	
	java.sql.Date begin = null, end = null;
	
	 /* if(request.getAttribute("search") != null){
		search = request.getAttribute("search").toString();	
	}else{
		keyword = request.getAttribute("keyword").toString();
	}  */
	
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
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
	//글쓰기 버튼을 클릭하면, noticeWriteForm.jsp 파일로 이동함
	location.href="/travelduo/views/notice/noticeWriteForm.jsp";
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
<div class="container">
	<div class="row notice_margin">
	<div class="image"></div>
		<h2 class="notice">공지사항 목록 보기</h2>
		<hr>
	</div>
	<div class="row">
		<div class="col-md-12 col-md-offset-0">
			<%-- 공지 목록 출력 --%>
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
					<%  for(Notice notice : list){ %>
					<tr>
						<td align="left"><%= notice.getNoticeNo() %></td>
						<td>
						<% if(loginUser != null){ //로그인한 상태 %>
							<a href="/travelduo/ndetail?no=<%= notice.getNoticeNo()%>&page=<%= currentPage %>"><%= notice.getNoticeTitle() %></a>
						<% }else{ %>
							<%= notice.getNoticeTitle() %>
						<% } %>
						</td>
						<td align="left"><%= notice.getNoticeWriter() %></td>
						<td align="left"><%= notice.getNoticeDate() %></td>
					</tr>
					<%  } %>
				</tbody>
			</table>
		</div>	
	</div>
	
	<div class="row">
		<%-- 검색기능 --%>
	
		<div class="noticee">
			<form action="/travelduo/nsearcht" method="post">
				<input type="hidden" name="search" value="title">
				<label> 제목 검색 : 
				<input type="text" name="keyword" placeholder='제목'></label>
				<input type="submit" class="btn btn-info btn-sm" value="검색">
				
				<%-- 글쓰기 버튼은 로그인했을 때만 보여지게 함 --%>
				<% //관리자일 때만 글쓰기 제공 처리
					 if(loginUser != null 
						&& loginUser.getUserId().equals("admin")){ 
					/* if(loginUser != null){ */ %>
					<button type="button" class="btn btn-warning btn-sm" onclick="moveWritePage();">글쓰기</button>
				<% } %>
			</form>
		</div>
	</div>
	<div class="row">
		<%-- 페이징 처리 --%>
		<div class="noticeee" style="text-align:center;">
		<% if(currentPage <= 1 && keyword == null){ %>
			[맨처음]&nbsp;
		<% }else if (currentPage <= 1 && keyword != null){%>
		
		<% }else if(currentPage > 1 && keyword != null){ %>
			
		<% }else{ %>
			<a href="/travelduo/nlist?page=1">[맨처음]</a>&nbsp;
		<% } %>
		<% if((currentPage - 10) < startPage && (currentPage - 10) >= 1){ %>
			<a href="/travelduo/nlist?page=<%= startPage - 10 %>">[prev]</a>
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
				<a href="/travelduo/nsearcht?keyword=<%= keyword %>&page=<%= p %>"><%= p %></a>
				<%}else{ %>
			<a href="/travelduo/nlist?page=<%= p %>"><%= p %></a>
		<% }}} %>&nbsp;
		<% if((currentPage + 10) > endPage && (currentPage + 10) <= ((maxPage/10)+1)*10){ %>
			<a href="/travelduo/nlist?page=<%= startPage + 10 %>">[next]</a>&nbsp;
		<% }else{ %>
			[next]&nbsp;
		<% } %>
		<% if(currentPage >= maxPage && keyword == null){ %>
			[맨끝]
		<% }else if (currentPage>=maxPage && keyword != null){ %>
		
		<% }else if (currentPage < maxPage && keyword != null){ %>
			
		<% }else if (currentPage < maxPage){ %>
			<a href="/travelduo/nlist?page=<%= maxPage %>">[맨끝]</a>
		<% } %>
		</div>
		<hr>
	</div>
	
</div>
<%@ include file="../common/footer.jsp" %>
</body>
<style>
	.notice_margin {
		margin-top:100px;
	}
	
	.notice {
		margin-left: 450px;
	}
	.noticee {
		margin-left: 390px;
	}
	
	.noticeee {
		margin-left: 450px;
	}
</style>
</html>