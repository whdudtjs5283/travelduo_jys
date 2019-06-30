<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board_hoogi.model.vo.Product_Hoogi"%>
 <%@ page import="member.model.vo.Member" %>
<% 
	Member loginUser = (Member)session.getAttribute("loginUser");
  	String UserName = loginUser.getUserName();
  	Product_Hoogi Phoogi = (Product_Hoogi)request.getAttribute("Phoogi");
  	
  	//커렌트 페이지는 글쓰기 후 넘어가는 페이지 때문에 필요한듯
  	int currentPage = ((Integer)request.getAttribute("page")).intValue();
%>
    
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<title>first</title>
 <style>
  table, th, td {
    border: 1px solid #bcbcbc;
  }
  table {
    width: 70%;
    height: 300px;
  }
  textarea {height: 250px;}
</style>
</head>
<body>
	<h1 align="center">게시글 수정</h1>
<h2 align="center"><%= Phoogi.getBoardnum() %>번 게시글 수정페이지</h2>
<br>

<table align="center" width="600">
    <thead>
    </thead>
    <tbody>
    
    
        <form action="/travelduo/bupdate" method="post"
        enctype="multipart/form-data">
        <input type="hidden" name="page" value="<%=currentPage%>">
<input type="hidden" name="bnum" value="<%= Phoogi.getBoardnum() %>">
<input type="hidden" name="ofile" value="<%= Phoogi.getBoardOriginalFileName() %>">
<input type="hidden" name="rfile" value="<%= Phoogi.getBoardRenameFileName() %>">
        	<tr><td>작성자</td><td><input type="text" name="bwriter" readonly value="<%= loginUser.getUserId() %>"></td></tr>
        	<tr><td>이 름</td><td> <%= UserName %></td></tr>
            <tr>
                <th>제목: </th>
                <td><input type="text" name="htitle" value="<%= Phoogi.getBtitle() %>" /></td>
            </tr>
            <tr>
                <th>내용: </th>
                <td><textarea cols="10" name="hcontent" class="form-control" height="300"><%= Phoogi.getBcontent() %></textarea></td>
            </tr>
            
            
            <tr><th>첨부파일</th>
            
<td><% if(Phoogi.getBoardOriginalFileName() != null){ %>
	<%= Phoogi.getBoardOriginalFileName() %>
<% } %><br>
<input type="file" name="bupfile">
</td>
</tr>
		
            <tr>
                <td colspan="2">
                    
                    <input type="submit" value="전송" class="btn btn-light">
                    <input align="center" type="button" class="btn btn-light" value="목록 " onclick=""/>
                </td>
            </tr>
        </form>
    </tbody>
</table>


<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<br>
	<br>
</body>
</html>

