<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Insert title here</title>
 <style>
  table, th, td {
    border: 1px solid #bcbcbc;
  }
  table {
    width: 50%;
    height: 50px;
  }
  div {width:50%;
  }
  </style>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>

<div>
<form action="/travelduo/login" method="post">
<table>
<div class="form-group">
     <input type="text" class="form-control" placeholder="아이디" name="userid" maxlength="20" required>
    </div>
<div class="form-group">
     <input type="password" class="form-control" placeholder="비밀번호" name="userpwd" maxlength="20" required>
    </div>

<tr>
	<th colspan="2">
		  <input type="submit" class="btn btn-primary form-control" value="로그인">
		<a href="/travle_duo/views/member/join.html">회원가입</a>
	</th>
</tr>

</table>
</form>
</div>

 <ul class="nav navbar-nav navbar-right">
    <li class="dropdown">
     <a href="#" class="dropdown-toggle"
      data-toggle="dropdown" role="button" aria-haspopup="true"
      aria-expanded="false">접속하기<span class="caret"></span></a>
     <ul class="dropdown-menu">
      <li class="active"><a href="login.jsp">로그인</a></li>
      <li><a href="join.jsp">회원가입</a></li>
     </ul>
    </li>
   </ul>
   
</body>
</html>