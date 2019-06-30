<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="member.model.vo.Member"  %>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>travelduo</title>
<link rel="stylesheet" href="/travelduo/resources/css/bootstrap.css">
<link rel="stylesheet" href="/travelduo/resources/css/main.css">
<script type="text/javascript" src="/travelduo/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/travelduo/resources/js/jquery-3.3.1.min.js"></script>
<script>
function openNav() {
	  document.getElementById("mySidenav").style.width = "257px";
	}

	function closeNav() {
	  document.getElementById("mySidenav").style.width = "0";
	}
</script>
<style type="text/css">
.sidenav {
  height: 100%;
  width: 0;
  position: fixed;
  z-index: 1;
  top: 0;
  right: 0;
  background-color: #111;
  overflow-x: hidden;
  transition: 0.5s;
  padding-top: 60px;
  float: left;
}

 /* 회원가입 , ID/PW 찾기 */
.sidenav a {
  padding: 8px 8px 8px 9px;
  text-decoration: none;
  font-size: 25px;
  color: #818181;
  display: block;
  transition: 0.3s;
  float: left;
}

.sidenav a:hover {
  color: #f1f1f1;
}

.sidenav .closebtn {
  position: absolute;
  top: 0;
  right: 23px;
  font-size: 36px;
  margin-left: 50px;
}


@media screen and (max-height: 6000px) {
  .sidenav {padding-top: 15xp;}
  .sidenav a {font-size: 18px;}
}

/* 여행가듀오 로고아래 로그인에 대한 글씨 */
 .logincolor818181 { 
 color: #818181;
 } 
 
/*로그인 글자 앞에 생기는 줄에대한 것  */
.logincolor818181:after {display: inline-block; margin: 0 0 6px 5px; height: 1px; content: " "; text-shadow: none; background-color: #999; width:
44%; }

/*로그인버튼  앞에 생기는 줄에 대한 것  */
.line:before {display: inline-block; margin: 0 5px 6px 23px; height: 1px; content: " "; text-shadow: none; background-color: #999; width:
38%; }

/*로그인 후 햄버거 클릭 시 나오는 앞선에 대한 것  */
.line2:before {display: inline-block; margin: 0 5px 6px 23px; height: 1px; content: " "; text-shadow: none; background-color: #999; width:83%;}

/*로그인 후 햄버거 클릭 시 나오는 뒷선에 대한 것  */
.line3:before {display: inline-block; margin: 0 5px 6px 23px; height: 1px; content: " "; text-shadow: none; background-color: #999; width:
83%;}


</style>
</head>
<body id="main">
	<header id="header">
		<div class="container main-menu">
			<div class="row align-items-center justify-content-between d-flex">
				<div id="logo">
					<a href="/travelduo/index.jsp"><img
						src="/travelduo/resources/images/logo2.png" alt="" title=""
						style="height: 30px;"></a>
				</div>
				<nav id="nav-menu-container">
					<ul class="nav-menu">
						<li><a href="/travelduo/index2.jsp">매칭시스템</a></li>
								<li><a href="/travelduo/pialist">국내여행</a></li>
						<li><a href="/travelduo/poalist">해외여행
						</a>
							<ul>
								<li><a href="/travelduo/pclist?coun=일본">일본</a></li>
								<li><a href="/travelduo/pclist?coun=영국">영국</a></li>
								<li><a href="/travelduo/pclist?coun=프랑스">프랑스</a></li>
								<li><a href="/travelduo/pclist?coun=체코">체코</a></li>
								<li><a href="/travelduo/pclist?coun=미국">미국</a></li>
								<li><a href="/travelduo/pclist?coun=이탈리아">이탈리아</a></li>
								<li><a href="/travelduo/pclist?coun=헝가리">헝가리</a></li>
								<li><a href="/travelduo/pclist?coun=독일">독일</a></li>
								<li><a href="/travelduo/pclist?coun=중국">중국</a></li>
								<li><a href="/travelduo/pclist?coun=호주">호주</a></li>
								<li><a href="/travelduo/pclist?coun=태국">태국</a></li>
							</ul></li>
						<li><a href="/travelduo/blist">매칭게시판</a></li>
						
						<% if(loginUser!=null) { %>
		<li><a href="/travelduo/matchList?userid=<%= loginUser.getUserId() %>"> 내게 온 매칭</a></li>
						
						<% }else { %>
						
						<% } %>
						
						
						<li class="menu-has-children"><a href="">고객센터</a>
							<ul>
								<li><a href="/travelduo/nlist?page=1">공지사항</a></li>
								<li><a href="/travelduo/views/faq/faq.jsp">FAQ</a></li>
								<li><a href="/travelduo/qlist?page=1">QnA</a></li>
							</ul>
						</li>
						<li><a><span style="font-size:15px;color:white;cursor:pointer" onclick="openNav()">&#9776;　</span>
						</a></li>
					</ul>
				</nav>
				<!-- #nav-menu-container -->
			</div>
		</div>


<div id="mySidenav" class="sidenav">

<br>
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="/travelduo" align="center"><img src="/travelduo/resources/images/logo2.png" width= "180" height= "60"></a><br>
  <br>
  <br>
  <br>
  <br>



<%if(loginUser!=null){ %><!--로그인하였을 경우  -->


<p class="line2"></p>
<ul class="fa-ul">

<a href="/travelduo/views/member/memberMyPage.jsp" > <img src="/travelduo/resources/images/Person_icon-icons.com_51960.png" width= "20" height= "20"> 회원정보 보기/수정</a>
<a href="/travelduo/index2.jsp" > <img src="/travelduo/resources/images/멤버 매칭시스템 로고.png" width= "20" height= "20"> 매칭 시스템</a>
<a href="/travelduo/nlist?page=1" > <img src="/travelduo/resources/images/Phone-call_icon-icons.com_51956.png" width= "20" height= "20"> 고객 센터 문의</a>
<a href="/travelduo/logout" > <img src="/travelduo/resources/images/Login_icon-icons.com_52028 (1).png" width= "20" height= "20"> 로그아웃</a>



</ul>
<p class="line3"></p>


<%}else{ %><!--로그인하지 않았을 경우  -->
<form action="/travelduo/mlogin" method="post">
 
  <h4 class="logincolor818181">&ensp;&ensp; 로그인</h4> 

<div style = "padding: 4px 1px 3px 3px;">  
	<tr>
		<td>&ensp;&emsp;<input type="text" name="userid" placeholder="ID" required></td>
	</tr><br>
</div>

<div style = "padding: 4px 1px 10px 3px;"> 
	<tr>
		<td>&ensp;&emsp;<input type="password" name="userpwd" placeholder="Password" required></td><br>
	</tr>
</div>

<div>
<tr>
&ensp;&emsp;&emsp;&emsp; &emsp;&emsp;&emsp;&emsp;&ensp;&ensp;&ensp;<p class="line"><input class="btn btn-secondary btn" type="submit" value="로 그 인"></p>
</tr>
</div>
<br>

<tr>
<div class="btn">

	<a href="/travelduo/views/member/memberAccept.jsp">회원가입</a>
	<a href="/travelduo/views/member/memberFindId.jsp">ID/PW 찾기</a>
	</div>
</tr>
</div>

</form>

<% } %>


<% if(loginUser != null && loginUser.getUserId().equals("admin")){ %>
	<!--관리자 전용 페이지 만든후 거기로이동하게 끔  --> 	
	<ul class="fa-ul">
	<a href="/travelduo/mm">관리자 페이지로 이동</a>
	</ul>
<% } %>

			   <script type="text/javascript" src="/travelduo/resources/js/superfish.min.js"></script>
   <script type="text/javascript" src="/travelduo/resources/js/jquery.magnific-popup.min.js"></script>
   <script type="text/javascript" src="/travelduo/resources/js/owl.carousel.min.js"></script>
   <script type="text/javascript" src="/travelduo/resources/js/main.js"></script>

</header>
</body>
</html>