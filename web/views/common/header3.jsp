<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<!-- Mobile Specific Meta -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Favicon-->
<link rel="shortcut icon" href="img/fav.png">
<!-- Author Meta -->
<meta name="author" content="colorlib">
<!-- Meta Description -->
<meta name="description" content="">
<!-- Meta Keyword -->
<meta name="keywords" content="">
<!-- meta character set -->
<meta charset="UTF-8">
<!-- Site Title -->
<title>Travel Duo</title>
<script type="text/javascript">
	function openNav() {
		document.getElementById("mySidenav").style.width = "300px";
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
  z-index: 3;
  top: 0;
  right: 0px;
  background-color: #111;
  overflow-x: hidden;
  transition: 0.5s;
  padding-top: 60px;
  float: left;
}

.sidenav a {
  padding: 8px 8px 8px 32px;
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
  top: 50px;
  right: 0px;
  font-size: 36px;
  margin-left: 50px;
}

#main {
  transition: margin-right .5s;
  padding: 16	px;
  text-align: right;
}

 @media screen and (max-height: 6000px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}
/* 
header nav ul { list-style: none; } 
 */
/* header nav ul li {
	float: left;
	margin-right: 0px;
	background: white;
	background-color:rgba(255,255,255,0.0);
	text-decoration: none; */

}
/* header nav ul li a {
	display:block;
	text-align: center;
	padding-top: 15px;
	padding-bottom: 0;
	width: 158px;
	height: 60px;
	color: white;
	font-weight: bold;
	font-size: 25px;
	text-decoration:none; */
	
}

/* header nav ul li a:hover {
/* 	background: gray;
	text-shadow: 1px 1px 2px white;
	box-shadow: 2px 2px 4px white; */
	
} */
#h1 {
/* background-image: url("/travelduo/resources/images/여행가듀오_로고_투명.png"); */
/* 	background-color:rgba(255,255,255,0.5); */
width: 200px;
height: 80px;
/* background-repeat: no-repeat; */
float: left;
}
/* #h2 {
width: 3000px;
height: 80px;
} */
/* #three{
	display: block;
	text-align: center;
	padding-top: 0px;
	padding-bottom: 0;
	width: 70px;
	height: 60px;
	color: white;
	font-weight: bold;
	font-size: 45px;
	text-decoration:none;
}
 */
.three{
width: 150px;
	height: 20px;

}

.col {
    display: block;
    float: right;
    margin: 1% 0 1% 1.6%;
}

.col:first-of-type {
    margin-left: 0;
}

.row .three {
padding: 1px 3px;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
    background-color: #2c3e50;
    color: #ecf0f1;
    text-align: center;
}

.hamburger .line {
    width: 10px;
    height: 2px;
    background-color: #ecf0f1;
    display: block;
    margin: 2px auto;
    -webkit-transition: all 0.3s ease-in-out;
    -o-transition: all 0.3s ease-in-out;
    transition: all 0.3s ease-in-out;
}

.hamburger:hover {
    cursor: pointer;
    
}

#hamburger-4.is-active .line:nth-child(1),
#hamburger-4.is-active .line:nth-child(3) {
    width: 20px;
}

#hamburger-4.is-active .line:nth-child(1) {
    -webkit-transform: translateX(10px) rotate(45deg);
    -ms-transform: translateX(10px) rotate(45deg);
    -o-transform: translateX(10px) rotate(45deg);
    transform: translateX(10px) rotate(45deg);
}

#hamburger-4.is-active .line:nth-child(3) {
    -webkit-transform: translateX(10px) rotate(-45deg);
    -ms-transform: translateX(10px) rotate(-45deg);
    -o-transform: translateX(10px) rotate(-45deg);
    transform: translateX(10px) rotate(-45deg);
}
</style>

<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700"
	rel="stylesheet">


<!--
			CSS
			============================================= -->
<link rel="stylesheet" href="/travelduo/resources/css/linearicons.css">
<link rel="stylesheet" href="/travelduo/resources/css/bootstrap.css">
<link rel="stylesheet"
	href="/travelduo/resources/css/magnific-popup.css">
<link rel="stylesheet" href="/travelduo/resources/css/jquery-ui.css">
<link rel="stylesheet" href="/travelduo/resources/css/nice-select.css">
<link rel="stylesheet" href="/travelduo/resources/css/animate.min.css">
<link rel="stylesheet" href="/travelduo/resources/css/owl.carousel.css">
<link rel="stylesheet" href="/travelduo/resources/css/main.css">
<link rel="stylesheet" href="/travelduo/resources/css/bootstrap.min.css">



<style type="text/css">
.listText {
	color: black;
}

.listText:hover {
	text-decoration: none;
	color: black;
}
</style>
</head>
<body>


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
						<li><a href="index.html">매칭시스템</a></li>
						<li><a href="/travelduo/views/product/productListView.jsp">국내여행</a></li>
						<li><a href="/travelduo/views/product/productListView.jsp">해외여행
								<i class="fas fa-angle-down"></i>
						</a>
							<ul>
								<li><a href="blog-home.html">호주</a></li>
								<li><a href="/travelduo/views/product/productListView.jsp">일본</a></li>
								<li><a href="blog-single.html">독일</a></li>
								<li><a href="blog-single.html">러시아</a></li>
								<li><a href="blog-single.html">스위스</a></li>
								<li><a href="blog-single.html">중국</a></li>
								<li><a href="blog-single.html">멕시코</a></li>
								<li><a href="blog-single.html">괌</a></li>
							</ul></li>

						<li><a href="hotels.html">테마여행</a></li>
						<li><a href="insurance.html">패키지여행</a></li>
						<li class="menu-has-children"><a
							href="/travelduo/views/admin/dashBoard.jsp">여행후기</a>
						<li class="menu-has-children"><a href="">고객센터</a>
							<ul>
								<li><a href="elements.html">Elements</a></li>
								<li class=""><a href="">Level 2 </a>
									<ul>
										<li><a href="#">Item One</a></li>
										<li><a href="#">Item Two</a></li>
									</ul></li>
							</ul></li>
						<li><a>
								<span style="font-size:15px;color:white;cursor:pointer" onclick="openNav()">&#9776;　</span>
						</a></li>
					</ul>
				</nav>
				<!-- #nav-menu-container -->
			</div>
		</div>
	</header>
	
	
	<div id="mySidenav" class="sidenav">
<br>
<br>
<br>
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="/travelduo"><img src="/travelduo/resources/images/logo2.png" width= "150" height="54"></a><br>
  <br>
  <br>
  <br>
  <br>
<!--   로그인화면 -->
<!--   <form>
                <div class="form-label-group">
                  <input type="id" id="inputId" class="form-control" placeholder="ID" required autofocus>
                </div>
                <br>

                <div class="form-label-group">
                  <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
                </div>
                <br>
                <button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit">로그인</button>
                
                <button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="button">아이디 비밀번호찾기</button>
                <button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="button">회원가입</button>
              </form> -->
              
              
<!-- 회원가입 -->
<!--               <article class="container">
            <div class="page-header">
                <div class="col-md-6 col-md-offset-3">
                <h3><a href="#">회원가입</a></h3>
                <br><br>
                </div>
            </div>
            <div class="col-sm-6 col-md-offset-3">
                <form role="form">
                    <div class="form-group">
                        <label for="inputName"><a href="#">성명</a></label>
                        <input type="text" class="form-control" id="inputName" placeholder="이름을 입력해 주세요">
                    </div>
                    <div class="form-group">
                        <label for="InputEmail"><a href="#">이메일 주소</a></label>
                        <input type="email" class="form-control" id="InputEmail" placeholder="이메일 주소를 입력해주세요">
                    </div>
                    <div class="form-group">
                        <label for="inputPassword"><a href="#">비밀번호</a></label>
                        <input type="password" class="form-control" id="inputPassword" placeholder="비밀번호를 입력해주세요">
                    </div>
                    <div class="form-group">
                        <label for="inputPasswordCheck"><a href="#">비밀번호 확인</a></label>
                        <input type="password" class="form-control" id="inputPasswordCheck" placeholder="비밀번호 확인을 위해 다시한번 입력 해 주세요">
                    </div>
                    <div class="form-group">
                        <label for="inputMobile"><a href="#">휴대폰 번호</a></label>
                        <input type="tel" class="form-control" id="inputMobile" placeholder="휴대폰번호를 입력해 주세요">
                    </div>
                    <div class="form-group">
                        <label for="inputtelNO"><a href="#">비밀번호 힌트</a></label>
                        <select name="">
                        <option value="좋아하는 색은?" selected>좋아하는 색은?
                        <option value="아버지 성함은?">아버지 성함은?
                        <option value="어머니 성함은?">어머니 성함은?
                        <option value="첫번째 연인의 이름은?">첫사랑 했던 연인의 이름은?
                        <option value="일생중 일어났던 중요한 사건은?">일생중 일어났던 중요한 사건은?
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="hint"><a href="#">힌트의 정답</a></label>
                        <input type="text" class="form-control" id="inputHint" placeholder="정답을 입력해 주세요">
                    </div>

                    <div class="form-group">
                    <label>약관 동의</label>
                    <div data-toggle="buttons">
                    <label class="btn btn-primary active">
                    <span class="fa fa-check"></span>
                    <input id="agree" type="checkbox" autocomplete="off" checked>
                    </label>
                    <a href="#">이용약관</a>에 동의합니다.
                    </div>
                    </div>
                    <br>
                    <br>
                    <br>
                    <div class="form-group text-center">
                        <button type="submit" id="join-submit" class="btn btn-primary">
                            회원가입<i class="fa fa-check spaceLeft"></i>
                        </button>
                        <button type="button" class="btn btn-warning">
                            가입취소<i class="fa fa-times spaceLeft"></i>
                        </button>
                    </div>
                </form>
            </div>
            <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>

        </article> -->
        
<!-- 마이페이지 -->
 <ul class="fa-ul">
              <li class="text-muted"><span class="fa-li"><i class="fas fa-times"></i></span>회원정보 확인/수정</li>
              <br>
              <br>
              <li class="text-muted"><span class="fa-li"><i class="fas fa-times"></i></span>찜한 상품</li>
              <br>
              <br>
              <li class="text-muted"><span class="fa-li"><i class="fas fa-times"></i></span>결제 내역 확인</li>
              <br>
              <br>
              <li class="text-muted"><span class="fa-li"><i class="fas fa-times"></i></span>고객센터</li>
              <br>
              <br>
              <li class="text-muted"><span class="fa-li"><i class="fas fa-times"></i></span>로그아웃</li>
              <br>
              <br>
            </ul>

</div>
	<!-- #header -->
	<!--
		JS
		============================================= -->
			<script type="text/javascript"
		src="/travelduo/resources/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript"
		src="/travelduo/resources/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="/travelduo/resources/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript"
		src="/travelduo/resources/js/js2/popper.min.js"></script>
	<script type="text/javascript"
		src="/travelduo/resources/js/js2/jquery-ui.js"></script>
	<script type="text/javascript"
		src="/travelduo/resources/js/js2/easing.min.js"></script>
	<script type="text/javascript"
		src="/travelduo/resources/js/js2/hoverIntent.js"></script>
	<script type="text/javascript"
		src="/travelduo/resources/js/js2/superfish.min.js"></script>
	<script type="text/javascript"
		src="/travelduo/resources/js/js2/jquery.ajaxchimp.min.js"></script>
	<script type="text/javascript"
		src="/travelduo/resources/js/js2/jquery.magnific-popup.min.js"></script>
	<script type="text/javascript"
		src="/travelduo/resources/js/js2/jquery.nice-select.min.js"></script>
	<script type="text/javascript"
		src="/travelduo/resources/js/js2/owl.carousel.min.js"></script>
	<script type="text/javascript"
		src="/travelduo/resources/js/js2/main.js"></script>


</body>
</html>