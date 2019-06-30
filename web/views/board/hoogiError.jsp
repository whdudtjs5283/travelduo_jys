<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

등록된 게시물이 없습니다. 

<% if(exception != null){ %>
<h3>JSP 오류발생 : <%= exception.getMessage() %></h3>
<% }else{ %>
<h3> <%= (String)request.getAttribute("message") %></h3>
<% } %>

</body>
</html>