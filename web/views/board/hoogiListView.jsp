<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="board_hoogi.model.vo.*, java.util.*, board_hoogi.model.vo.Product_Hoogi" %> 
    <%@ page import="member.model.vo.Member" %> 
<%
	ArrayList<Product_Hoogi> list = 
			(ArrayList<Product_Hoogi>)request.getAttribute("list");
	
	int listCount = ((Integer)request.getAttribute("listCount")).intValue();
	int startPage = ((Integer)request.getAttribute("startPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();

	
	String type = null; 
	String word = null;
	//java.sql.Date begin = null, end = null;
	
	if(request.getAttribute("type") != null){
		type = request.getAttribute("type").toString();	
		word = request.getAttribute("word").toString();
	}
	
	//Member loginUser = (Member)session.getAttribute("loginUser");
	
	
%>

<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<script type="text/javascript">
function moveWritePage(){
	location.href="/travelduo/views/board/hoogiWriterForm.jsp";
}

function message(){
	var toUser = $("#message2").val();
	var url ="/travelduo/views/message/message.jsp?id="+toUser;
	window.open(url, "", "width=400, height=400, left=600");
	
}

function message3(){
	var toUser = $("#message3").val();
	location.href="/travelduo/views/message/message.jsp?id="+toUser;
	window.open(url, "", "width=400, height=400, left=600");
}

function winOpen(){
	var url ="/travelduo/views/message/message.jsp";
window.open(url ,"new","width=500,height=500,top=100,left=100"); 
} 

function viewProfile(){
	var toUser = document.getElementById('profile1').value;
	var url ="/travelduo/views/board/Profile.jsp?profile="+toUser;
	window.open(url, "", "width=700, height=500, left=600");
	
}





</script>


 <style>
  table, th, td {
    border: 1px solid #bcbcbc;
  }
  table {
    width: 100%;
    height: 200px;
  }
  header 
{ 
     background: url(https://az837918.vo.msecnd.net/publishedimages/articles/1733/ko-KR/images/1/free-download-this-stunning-alberta-scene-for-your-device-background-image-L-6.jpg) no-repeat center center fixed; 
    background-size: cover; 
} 
  
  </style>

</head>

<body>

<%@ include file="../common/header.jsp" %>


<br><br><br><br><br><br><br><br>
<% if(loginUser ==null){ %>
<center>


<br><br>
로그인을 하셔야 게시글이 보입니다. 

</center>
<% }else {} %>


<% if(loginUser !=null){ %>

<center>
이미지 파일이 너무크거나 글내용이 너무길면 등록이 되지 않을수있습니다.

<br><br>

</center>

<table align="center" width="550" cellspacing="0" border="1" class="table table-striped">
<tr>
	<th>번호</th>
	<th>제목</th>
	<th>작성자</th>
	<th>조회수</th>
	<th>날짜</th>
</tr>

<% 
if (list!=null){ 
	
  for(int i=0; i<list.size(); i++) { 
%>


<tr>
	<th align="center"> <%= list.get(i).getBoardnum() %></th>
	 <th align="center"> 
	 
	 <strong>
	 <a href="/travelduo/bdetail?bnum=<%= list.get(i).getBoardnum() %>&page=<%= currentPage %>"
	class="text-info" >
	<%= list.get(i).getBtitle() %></a> </strong>
	
	
	<strong> <a class="text-danger"> [<%= list.get(i).getCommentcount() %>]</a> </strong>
 </th>

		<!--  드롭다운 네비 -->
	<td>
	<ul class="nav nav-pills">
	<li class="dropdown active">
	<a class="dropdown-toggle" data-toggle="dropdown">
	<%= list.get(i).getUserid() %> <span class="caret"></span>
	</a>
	<ul class="dropdown-menu">
	</li>
	<li><small><a href="/travelduo/bsearch?type=writer&word=<%=list.get(i).getUserid() %>"class="btn btn-primary btn-sm">
	아이디로 게시글 검색</a></small>
	</li>
	
	
	
	</ul>
	</li>
	</ul>
	</td>
	
	
	<!-- 드롭다운 내비 끝  -->
	
	<td align="center"> <%= list.get(i).getHoogireadcount() %></td>
	<td align="center"> <%= list.get(i).getBoarddate() %></td>
</tr>
<% } %>
	<%  } %>
	<% }else{ %>	
		
		
<% } %>

<br><br>

<% if (loginUser != null) { %>

 <div id="searchForm" align="left">
        <FORM align="center" name='frm' method='GET' action="/travelduo/bsearch" 
        class="navbar-search pull-left">
            <SELECT name='type' class="chosen-select" tabindex="5">
                <option value="title">제목</option>
                <option value="content">내용</option>
                <option value="writer">글쓴이</option>
            </select>
            <input type="text" class="search-query" size="20" name="word"/> 
            <input type="submit" class="btn btn-secondary" value="검색"/>
            <br>
        </form>    
    </div>
    
    <% } %>
</div>   

</table>
<br><br><br><br>

<center>
	<tr>
        <td colspan="2">
   
   
   <% if (loginUser!=null) { %>
   <button onclick="moveWritePage();" align="center" type="button" class="btn btn-primary" value="글쓰기">글등록</button>
<% } %>
          </td>
            </tr>
            </center>
<br>

	 <center>
    <br>
    
    <!-- 원래 검색폼 위치 -->
   
	</center> 
	
	

<div style="text-align:center;">
<% if(currentPage <= 1){ %>
	[맨처음]&nbsp;
<% }else{ %>
	<a href="/travelduo/blist?page=1">[맨처음]</a>&nbsp;
<% } %>
<% if((currentPage - 10) < startPage && (currentPage - 10) > 1){ %>
	<a href="/travelduo/blist?page=<%= startPage - 10 %>">[prev]</a>
<% }else{ %>
	[prev]
<% } %>

<%-- 현재 페이지가 포함된 페이지 그룹 숫자 출력 처리 (1,2,3,4,5 ...)--%>
<% for(int p = startPage; p <= endPage; p++){ 
		if(p == currentPage){
%>

	<font color="red" size="4"><b>[<%= p %>]</b></font>
	<% }else{ if(word != null && word.equals("title")){%>
		<a href="/travelduo/bsearch?word=<%= word %>&page=<%= p %>"><%= p %></a>
		<%}else if(word != null && word.equals("writer")){ %>
		<a href="/travelduo/bsearc?word=<%= word %>&page=<%= p %>"><%= p %></a>
		<%}else{ %>
	<a href="/travelduo/blist?page=<%= p %>"><%= p %></a>
<% }}} %>&nbsp;

<% if((currentPage + 10) > endPage && (currentPage + 10) < maxPage){ %>
	<a href="/travelduo/blist?page=<%= endPage + 10 %>">[next]</a>&nbsp;
<% }else{ %>
	[next]&nbsp;
<% } %>
<% if(currentPage >= maxPage){ %>
	[맨끝]
<% }else{ %>
	<a href="/travelduo/blist?page=<%= maxPage %>">[맨끝]</a>
<% } %>
</div>

<%-- 글쓰기 버튼은 로그인했을 때만 보여지게 함 --%>

<% //관리자일 때만 글쓰기 제공 처리
	
	if(loginUser != null){ %>
	<%-- <center>
	<button onclick="moveWritePage();" class="btn btn-light">글쓰기</button>
</center>--%>


<% } %>
<br>
<script src="/resources/js/jquery-3.3.1.min.js"></script>
	<script src="/resources/js/bootstrap.js"></script>
	<br>
	<br>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>

</body>
</html>