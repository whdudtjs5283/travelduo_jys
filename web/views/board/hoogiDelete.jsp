<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="member.model.vo.Member, board_hoogi.model.vo.Product_Hoogi, 
    java.sql.Date, comment.model.vo.HComment, java.util.*" %>
<% Product_Hoogi Phoogi = new Product_Hoogi(); %>
<% int HoogiNo = Integer.parseInt(request.getParameter("bnum"));
	int currentPage = Integer.parseInt(request.getParameter("page"));
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<title>Insert title here</title>
</head>

<script type="text/javascript">


function delete(){
	var toUser = document.getElementById('message').value;
	var url ="/travelduo/views/message/message.jsp?id="+toUser;
	window.open(url, "", "width=700, height=500, left=600");
	
}


</script>

<body>
<br><br><br><br><br><br>
<%@ include file="../common/header.jsp" %>


<center>
<div>
<br><br>
<%=HoogiNo %>  "번 후기글을 정말 삭제하시겠습니까?"
<br><br>
<br><br>
 <a href="/travelduo/bdel?bnum=<%=HoogiNo%>&currentPage=<%=currentPage %>"
class="btn btn-outline-secondary">삭제</a>



</div>

<a href="/travelduo/bdel?currentPage=<%=currentPage %>&bnum=<%=HoogiNo %>"
<%= Phoogi.getBoardnum() %>" name="hoogiNo" class="btn btn-outline-secondary">삭제하지 않겠습니다</a>


</center>



&nbsp;

<br><br>






<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>