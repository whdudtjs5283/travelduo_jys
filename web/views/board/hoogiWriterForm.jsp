<%@ page language="java" contentType="text/html; charset=UTF-8"
    errorPage="hoogiError.jsp" pageEncoding="UTF-8" import="member.model.vo.Member" %>
  <%
	Member loginUser = (Member)session.getAttribute("loginUser");
  	String UserName = loginUser.getUserName();
%>
    
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Bootstrap 4</title>
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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
  </head>
  <body>
					<h1 align="center">게시글 작성</h1>
					
   <table align="center" width="600">
    <thead>
    </thead>
    <tbody>
        <form action="/travelduo/hwrite" method="post"
        enctype="multipart/form-data">
        	<tr><td>작성자</td><td><input type="text" name="bwriter" readonly value="<%= loginUser.getUserId() %>"></td></tr>
        	<tr><td>이 름</td><td> <%= UserName %></td></tr>
            <tr>
                <th>제목: </th>
                <td><input type="text" placeholder="제목을 입력하세요. " name="subject" size="60" /></td>
            </tr>
            <tr>
                <th>내용: </th>
                <td><textarea cols="10" placeholder="내용을 입력하세요. " name="content" class="form-control" height="300"></textarea></td>
            </tr>
            <tr><th>첨부파일</th>
		<td><input type="file" name="upfile"></td></tr>
            <tr>
                <td colspan="2">
                    
                    <input type="submit" value="전송" class="btn btn-primary">
                    <input align="center" type="button" class="btn btn-light" value="목록 " onclick=""/>
                </td>
            </tr>
        </form>
    </tbody>
</table>

 <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
    <script>
      $( function () {
        $('[data-toggle="tooltip"]').tooltip()
      } );
    </script>
  </body>
</html>