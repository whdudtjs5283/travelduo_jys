<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  %>

<%
	String result = (String)request.getAttribute("result");
%>

<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<meta name="google" value="notranslate">
<title>여행가듀오</title>


<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="./resources/css/bootstrap.min3.css" />
<link rel="stylesheet" href="./resources/css/animate.min3.css" />
<link rel="stylesheet" href="./resources/css/ionicons.min3.css" />
<link rel="stylesheet" href="./resources/css/styles.css" />



</head>

<body>
	<!-- 상단 네비바  -->
	<%@ include file="views/common/header.jsp" %>
  	<!-- 상단 네비바 끝  -->
  	
  	<!-- 동적 배경화면  -->

 <header>
  <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
      <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
      <!-- Slide One - Set the background image for this slide in the line below -->
      <div class="carousel-item active" style="background-image: url('/travelduo/resources/images/japan1.jpg')">
        <div class="carousel-caption d-none d-md-block">
          <h3 class="display-4"><!-- 첫번째 사진 타이틀 --></h3>
          <p class="lead"><!-- 첫번째 사진 내용 --></p>
        </div>
      </div>
      <!-- Slide Two - Set the background image for this slide in the line below -->
      <div class="carousel-item" style="background-image: url('/travelduo/resources/images/japan4.jpg')">
        <div class="carousel-caption d-none d-md-block">
          <h3 class="display-4"><!-- 두번째 사진 타이틀 --></h3>
          <p class="lead"><!-- 두번째 사진 내용 --></p>
        </div>
      </div>
      <!-- Slide Three - Set the background image for this slide in the line below -->
      <div class="carousel-item" style="background-image: url('/travelduo/resources/images/japan3.jpg')">
        <div class="carousel-caption d-none d-md-block">
          <h3 class="display-4"></h3>
          <p class="lead"></p>
        </div>
      </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
  </div>
</header>
  <!-- Page Content -->
  <div class="container" class="bg-dark">

  
    <!-- Portfolio Section -->
   <h2 class="text-center wow fadeIn">해외 여행</h2>

    <div class="row">
      <div class="col-lg-4 col-sm-6 portfolio-item">
        <div class="card h-100">
          <a href="#"><img class="card-img-top" src="/travelduo/resources/images/paris.jpg" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="#">파리</a>
            </h4>
            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur eum quasi sapiente nesciunt? Voluptatibus sit, repellat sequi itaque deserunt, dolores in, nesciunt, illum tempora ex quae? Nihil, dolorem!</p>
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-sm-6 portfolio-item">
        <div class="card h-100">
           <a href="#"><img class="card-img-top" src="/travelduo/resources/images/london.jpeg" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="#">런던</a>
            </h4>
            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae.</p>
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-sm-6 portfolio-item">
        <div class="card h-100">
            <a href="#"><img class="card-img-top" src="/travelduo/resources/images/rome.jpg" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="#">로마</a>
            </h4>
            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quos quisquam, error quod sed cumque, odio distinctio velit nostrum temporibus necessitatibus et facere atque iure perspiciatis mollitia recusandae vero vel quam!</p>
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-sm-6 portfolio-item">
        <div class="card h-100">
           <a href="#"><img class="card-img-top" src="/travelduo/resources/images/sydney.jpg" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="#">시드니</a>
            </h4>
            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae.</p>
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-sm-6 portfolio-item">
        <div class="card h-100">
      <a href="#"><img class="card-img-top" src="/travelduo/resources/images/osaka.jpg" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="#">오사카</a>
            </h4>
            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae.</p>
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-sm-6 portfolio-item">
        <div class="card h-100">
            <a href="#"><img class="card-img-top" src="/travelduo/resources/images/bangkok.jpg" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="#">방콕</a>
            </h4>
            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque earum nostrum suscipit ducimus nihil provident, perferendis rem illo, voluptate atque, sit eius in voluptates, nemo repellat fugiat excepturi! Nemo, esse.</p>
          </div>
        </div>
      </div>
    </div>
    <!-- /.row -->
    
  

    <!-- 매칭시스템 -->
    <div class="row">
      <div class="col-lg-6">
        <h2>매칭시스템</h2>
        <p>듀오를 찾기1234</p>
        <ul>
          <li>
            <strong>회원가입을 해야되는데</strong>
          </li>
          <li>얀녕</li>
          <li>폰트는 뭐다</li>
          <li>매칭미칭매칭12345</li>
          <li>가나다라마바상</li>
        </ul>
        <p>매칭을 해봅시다 하하하하</p>
      </div>
      <div class="col-lg-6">
        <a href="index2.jsp"><img class="img-fluid rounded" src="./resources/images/home_match.jpg" alt=""></a> 
      </div>
    </div>
    <!-- /.row -->
  </div>
  <!-- /.container -->

  <!-- Footer -->
<%@ include file="/views/common/footer2.jsp"%>
<%@ include file="/views/common/floating.jsp"%>

<!-- 사이드 네비바 -->

	<div id="mySidenav" class="sidenav">
		<br> <br> <br> <a href="javascript:void(0)"
			class="closebtn" onclick="closeNav()">&times;</a> <a
			href="/travelduo"><img
			src="/travelduo/resources/images/logo2.png" width="150" height="54"></a><br>
		<br> <br> <br> <br>
		<%
			if (loginUser != null) {
		%>
		<!--로그인하였을 경우  -->
		<div>
			<table>
				<tr>
					<th>&ensp;&ensp; <%=loginUser.getUserId()%>님
					</th>
					<td><a href="/travelduo/logout"><h5>로그아웃</h5></a></td>

				</tr>
			</table>

			<ul class="fa-ul">
				<li class="text-muted"><span class="fa-li"><i
						class="fas fa-times"></i></span>회원정보 확인/수정</li>

				<br>
				<li class="text-muted"><span class="fa-li"><i
						class="fas fa-times"></i></span>찜한 상품</li>

				<br>
				<li class="text-muted"><span class="fa-li"><i
						class="fas fa-times"></i></span>결제 내역 확인</li>

				<br>
				<li class="text-muted"><span class="fa-li"><i
						class="fas fa-times"></i></span>고객센터</li>
				<!-- 		<br>
				<br>
				<a href="/travelduo/logout"><li class="text-muted"><span
						class="fa-li"><i class="fas fa-times"></i></span></li>로그아웃</a>
				<br>
				<br> -->
			</ul>
		</div>

		<%
			} else {
		%>
		<!--로그인하지 않았을 경우  -->
		<form action="/travelduo/login" method="post">
			<!-- 	<h3 class="logincolor818181">&ensp;&ensp;로그인</h3> -->
			<div style="padding: 4px 1px 3px 3px;">
				<tr>
					<td>&ensp;&emsp;<input type="text" name="userid"
						placeholder="ID" required></td>
				</tr>
				<br>
			</div>
			<div style="padding: 4px 1px 10px 3px;">
				<tr>
					<td>&ensp;&emsp;<input type="password" name="userpwd"
						placeholder="Password" required></td>
					<br>
				</tr>
			</div>
			<tr>
				&ensp;&ensp;&emsp;
				<input type="checkbox" value="Y"
					onclick="if(this.checked) return confirm('로그인 유지 기능을 사용할 경우! 브라우저를 닫더라도 로그인이 계속 유지될 수 있습니다.\n\n따라서 공공장소에서 이용 할 경우 반드시 로그아웃을 하시길 바랍니다.');">
				<span style="color: #818181">자동 로그인</span>
			</tr>
			<br> <br>
			<tr>
				&ensp;&emsp;&emsp;&emsp; &emsp;
				<input type="submit" value="로그인" class="btn btn-primary ">
			</tr>

			<!-- 	<input type="submit" data-toggle="modal"
							data-target="#alertModal2"
							class="btn btn-primary btn-block btn-lg" name="input" id="input"
							value="검색"> -->
			<hr>
			<br> <br>
			<tr>
				<a href="/travelduo/views/member/signUp.jsp"><h5>회원가입</h5></a>
				<a href=""><h5>ID/PW 찾기</h5></a>
			</tr>
		</form>
		<%
			if (loginUser != null && loginUser.getUserId().equals("admin")) {
		%>
		<!--관리자 전용 페이지 만든후 거기로 이동하게 끔  -->
		<td><a href="">관리자 페이지로 이동</a></td>
		<%
			}
		%>
		<%
			}
		%>

  <!-- Bootstrap core JavaScript -->
		<script src="./resources/js/jquery-3.3.1.min.js"></script>
		<script src="./resources/js/jquery.min.js"></script>
		<script src="./resources/js/bootstrap.min.js"></script>
		<script src="./resources/js/jquery.easing.min.js"></script>
		<script src="./resources/js/wow.js"></script>
		<script src="./resources/js/scripts.js"></script>
		<script src="https://unpkg.com/ionicons@4.5.5/dist/ionicons.js"></script>
</body>

</html>
