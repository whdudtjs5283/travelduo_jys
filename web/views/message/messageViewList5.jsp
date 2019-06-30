<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="member.model.vo.Member" %> 
    <%@ page import="Match.vo.MatchMessage, java.util.*" %> 
    
    <%
	ArrayList<MatchMessage> list = 
			(ArrayList<MatchMessage>)request.getAttribute("list");
	
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
<meta charset="UTF-8">
<title>Insert title here</title>


</head>

<body>

<script type="text/javascript">




function sendmessage(){
	var toUser = document.getElementById('message').value;
	var url ="/travelduo/views/message/messageAnswer.jsp?id="+toUser;
	window.open(url, "", "width=700, height=500, left=600");
	
}



</script>


<%@ include file="../common/header.jsp" %>

<br><br><br><br>

받은 쪽지는 일주일 후 자동 삭제됩니다.

<br><br><br><br>

<table align="center" width="550" cellspacing="0" border="1" class="table table-striped">
<tr>
	<th>번호</th>
	<th>보낸사람</th>
	<th>내용</th>
	<th>매칭도착날짜</th>
</tr>

<% 
if (list!=null&&loginUser !=null){ 
	
  for(int i=0; i<list.size(); i++) { 
%>


<tr>
	<th align="center"> <%= list.get(i).getMessage_No() %></th>
	<th align="center"> <%= list.get(i).getFromUser() %></th>
	
	
	<th align="center"> 
	 <a href="/travelduo/messagedetail?bnum=<%= list.get(i).getMessage_No() %>&page=<%= currentPage %>"class="text-info" >
	<%= list.get(i).getContent() %></a> 
 </th>
	
 </th>
	<td align="center"> <%= list.get(i).getMessageDate() %></td>
</tr>

	<%  } %>
	<% }else{ %>	
		
		<td> 도착한 매칭이 없습니다</td>
<% } %>

</table>


<div style="text-align:center;">
<% if(currentPage <= 1){ %>
	[맨처음]&nbsp;
<% }else{ %>
	<a href="/travelduo/matchList?page=1&userid=<%= loginUser.getUserId() %>">[맨처음]</a>&nbsp;
<% } %>
<% if((currentPage - 5) < startPage && (currentPage - 5) > 1){ %>
	<a href="/travelduo/matchList?page=<%= startPage - 5 %>&userid=<%= loginUser.getUserId() %>">[prev]</a>
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
	<a href="/travelduo/matchList?page=<%= p %>&userid=<%= loginUser.getUserId() %>"><%= p %></a>
<% }}} %>&nbsp;

<% if((currentPage + 5) > endPage && (currentPage + 5) < maxPage){ %>
	<a href="/travelduo/matchList?page=<%= endPage + 5 %>">[next]</a>&nbsp;
<% }else{ %>
	[next]&nbsp;
<% } %>
<% if(currentPage >= maxPage){ %>
	[맨끝]
<% }else{ %>
	<a href="/travelduo/matchList?page=<%= maxPage %>&userid=<%= loginUser.getUserId() %>">[맨끝]</a>
<% } %>
</div>




</body>
</html>