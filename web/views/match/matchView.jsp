<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="matchinfo.model.vo.MatchInfo"
	import="member.model.vo.Member"%>
<%-- <%
	String matchprivate = request.getParameter("matchprivate");
%> --%>
<%
	Member loginUser = (Member) session.getAttribute("loginUser");
	String result = (String)request.getAttribute("result");
%>
<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<meta name="google" value="notranslate">
<title>여행가듀오</title>

<!--scripts loaded here -->

<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="./resources/css/animate.min.css" />
<link rel="stylesheet" href="./resources/css/ionicons.min.css" />
<link rel="stylesheet" href="./resources/css/styles.css" />

<script type="text/javascript">

	window.onload = function(){
		<% if(result != null && result.equals("success")){ %>
		alert("등록성공");
		<% }else if(result != null && result.equals("fail")){ %>
		alert("등록실패");
		<% } %>
	}
	/* 오른쪽 내비바 설정 */
	function openNav() {
		document.getElementById("mySidenav").style.width = "200px";

	}

	function closeNav() {
		document.getElementById("mySidenav").style.width = "0";
	}

	/* 여행정보 등록 */

	function icategoryChange(e) {
		var good_a = [ "싱가포르", "방콕", "푸켓", "코타키나발루", "마닐라", "세부", "보라카이",
				"하노이", "호치민", "다낭", "자카르타", "쿠알라룸푸르", "기타" ];
		var good_b = [ "타이페이", "홍콩", "마카오", "상해", "북경", "청도", "광저우", "장가계",
				"기타" ];
		var good_c = [ "오키나와", "오사카", "도쿄", "후쿠오카", "삿포로", "교토", "유후인", "나고야",
				"센다이", "기타" ];
		var good_d = [ "괌", "사이판", "팔라우", "시드니", "멜버른", "골드코스트", "웰링턴", "오클랜드",
				"기타" ];
		var good_e = [ "파리", "로마", "피렌체", "밀라노", "베니스", "비엔나", "런던", "베를린",
				"프라하", "바르셀로나", "부다페스트", "모스크바", "취리히", "암스테르담", "이스탄불", "기타" ];
		var good_f = [ "호놀룰루", "마우이", "로스엔젤레스", "뉴욕", "시카고", "시애틀", "벤쿠버",
				"토론토", "기타" ];
		var target = document.getElementById("igood");

		if (e.value == "a")
			var d = good_a;
		else if (e.value == "b")
			var d = good_b;
		else if (e.value == "c")
			var d = good_c;
		else if (e.value == "d")
			var d = good_d;
		else if (e.value == "e")
			var d = good_e;
		else if (e.value == "f")
			var d = good_f;

		target.options.length = 0;

		for (x in d) {
			var opt = document.createElement("option");
			opt.value = d[x];
			opt.innerHTML = d[x];
			target.appendChild(opt);
		}
	}
	
	/* 여행정보 수정 */
	
	function pcategoryChange(e) {
		var good_a = [ "싱가포르", "방콕", "푸켓", "코타키나발루", "마닐라", "세부", "보라카이",
				"하노이", "호치민", "다낭", "자카르타", "쿠알라룸푸르", "기타" ];
		var good_b = [ "타이페이", "홍콩", "마카오", "상해", "북경", "청도", "광저우", "장가계",
				"기타" ];
		var good_c = [ "오키나와", "오사카", "도쿄", "후쿠오카", "삿포로", "교토", "유후인", "나고야",
				"센다이", "기타" ];
		var good_d = [ "괌", "사이판", "팔라우", "시드니", "멜버른", "골드코스트", "웰링턴", "오클랜드",
				"기타" ];
		var good_e = [ "파리", "로마", "피렌체", "밀라노", "베니스", "비엔나", "런던", "베를린",
				"프라하", "바르셀로나", "부다페스트", "모스크바", "취리히", "암스테르담", "이스탄불", "기타" ];
		var good_f = [ "호놀룰루", "마우이", "로스엔젤레스", "뉴욕", "시카고", "시애틀", "벤쿠버",
				"토론토", "기타" ];
		var target = document.getElementById("pgood");

		if (e.value == "a")
			var d = good_a;
		else if (e.value == "b")
			var d = good_b;
		else if (e.value == "c")
			var d = good_c;
		else if (e.value == "d")
			var d = good_d;
		else if (e.value == "e")
			var d = good_e;
		else if (e.value == "f")
			var d = good_f;

		target.options.length = 0;

		for (x in d) {
			var opt = document.createElement("option");
			opt.value = d[x];
			opt.innerHTML = d[x];
			target.appendChild(opt);
		}
	}
	

	/* 회원 검색 */

	function scategoryChange(e) {
		var good_a = [ "싱가포르", "방콕", "푸켓", "코타키나발루", "마닐라", "세부", "보라카이",
				"하노이", "호치민", "다낭", "자카르타", "쿠알라룸푸르", "기타" ];
		var good_b = [ "타이페이", "홍콩", "마카오", "상해", "북경", "청도", "광저우", "장가계",
				"기타" ];
		var good_c = [ "오키나와", "오사카", "도쿄", "후쿠오카", "삿포로", "교토", "유후인", "나고야",
				"센다이", "기타" ];
		var good_d = [ "괌", "사이판", "팔라우", "시드니", "멜버른", "골드코스트", "웰링턴", "오클랜드",
				"기타" ];
		var good_e = [ "파리", "로마", "피렌체", "밀라노", "베니스", "비엔나", "런던", "베를린",
				"프라하", "바르셀로나", "부다페스트", "모스크바", "취리히", "암스테르담", "이스탄불", "기타" ];
		var good_f = [ "호놀룰루", "마우이", "로스엔젤레스", "뉴욕", "시카고", "시애틀", "벤쿠버",
				"토론토", "기타" ];
		var target = document.getElementById("sgood");

		if (e.value == "a")
			var d = good_a;
		else if (e.value == "b")
			var d = good_b;
		else if (e.value == "c")
			var d = good_c;
		else if (e.value == "d")
			var d = good_d;
		else if (e.value == "e")
			var d = good_e;
		else if (e.value == "f")
			var d = good_f;

		target.options.length = 0;

		for (x in d) {
			var opt = document.createElement("option");
			opt.value = d[x];
			opt.innerHTML = d[x];
			target.appendChild(opt);
		}
	}

	/*이미지 미리보기*/
	var InputImage = (function loadImageFile() {
		if (window.FileReader) {
			var ImagePre;
			var ImgReader = new window.FileReader();
			var fileType = /^(?:image\/bmp|image\/gif|image\/jpeg|image\/png|image\/x\-xwindowdump|image\/x\-portable\-bitmap)$/i;

			ImgReader.onload = function(Event) {
				if (!ImagePre) {
					var newPreview = document.getElementById("imagePreview");
					ImagePre = new Image();
					ImagePre.style.width = "200px";
					ImagePre.style.height = "150px";
					newPreview.appendChild(ImagePre);
				}
				ImagePre.src = Event.target.result;

			};

			return function() {

				var img = document.getElementById("image").files;

				if (!fileType.test(img[0].type)) {
					alert("이미지 파일을 업로드 하세요");
					return;
				}

				ImgReader.readAsDataURL(img[0]);
			}

		}

		document.getElementById("imagePreview").src = document
				.getElementById("image").value;

	})();

	/* 	function run() {
	
	 $("#two").html($("#two").html().replace("등록", "수정"));
	 $("#two").html($("#two").html().replace("등록", "수정"));
	 $("#two").html($("#two").html().replace("등록", "수정"));

	
	 } */
</script>

</head>

<body>

	<!-- 상단바 -->

	<nav id="topNav" class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand page-scroll" href="index.jsp"><i
					class="ion-ios-analytics-outline"></i> 여행가 듀오</a>
			</div>
			<div class="navbar-collapse collapse" id="bs-navbar">
				<ul class="nav navbar-nav">
					<li><a class="page-scroll" href="#zero">홈</a></li>
					<li><a class="page-scroll" href="#one">이용 방법</a></li>
					<li><a class="page-scroll" href="#two">정보 등록</a></li>
					<li><a class="page-scroll" href="#three">듀오 찾기</a></li>
					<li><a class="page-scroll" href="#four">듀오 채팅</a></li>
					<li><a class="page-scroll" href="#five">리뷰 등록</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a> <span id="menu"
							style="font-size: 30px; color: white; cursor: pointer"
							onclick="openNav()"> &#9776; </span>
					</a></li>
				</ul>

			</div>
		</div>
	</nav>
	
	<!-- 메인 -->

	<header id="zero">
		<div class="header-content">
			<div class="inner">
				<h1 class="cursive">Welcome Traveller!</h1>
				<h4>
					<b>여행자 여러분!</b> 어디를 가시든지, 진심이 통하는 멋진 여행 친구를 만나보세요.
				</h4>
				<hr>
				<a href="#two" class="btn btn-primary btn-xl page-scroll"><ion-icon
						name="airplane"></ion-icon>내 여행정보</a> &nbsp; <a href="#three"
					class="btn btn-primary btn-xl page-scroll">친구찾기</a> &nbsp; <a
					href="#four" class="btn btn-primary btn-xl page-scroll">대화하기</a>
				&nbsp;
			</div>
		</div>

	</header>

	<!-- 이용방법 -->

	<section id="one" class="bg-dark">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="margin-top-0 text-primary wow fadeIn">How&nbsp;
						to&nbsp; Use</h2>
					<hr class="primary">
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-lg-4 col-md-4 text-center">
					<div class="feature">
						<i class="icon-lg ion-android-contact wow fadeIn"
							data-wow-delay=".9s"></i>
						<h3>Registration</h3>
						<p class="text-muted">먼저 당신의 여행정보를 등록하세요!</p>
					</div>
				</div>
				<div class="col-lg-4 col-md-4 text-center">
					<div class="feature">
						<i class="icon-lg ion-heart wow fadeInUp" data-wow-delay=".9s"></i>
						<h3>Like!</h3>
						<p class="text-muted">호감이 가는 회원에게 Like를 누르세요!</p>
					</div>
				</div>
				<div class="col-lg-4 col-md-4 text-center">
					<div class="feature">
						<i class="icon-lg ion-android-star-outline wow fadeIn"
							data-wow-delay=".9s"></i>
						<h3>Favorite</h3>
						<p class="text-muted">나만의 여행친구를 즐겨찾기 해보세요.</p>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- 여행정보등록  -->

	<section id="two">
		<div class="container">
			<div class="row">
				<form class="contact-form row" method="post">
					<div
						class="col-lg-6 col-lg-offset-3 col-md-8 col-md-offset-2 text-center">
						<h2 class="margin-top-0 text-primary wow fadeIn">여행정보등록</h2>
						<br>
						<p class="text-faded">지금 여행일정을 등록해서 내 마음에 쏙드는 트레블 메이트를 찾아보세요!</p>
						<!-- <a class="btn btn-default btn-xl page-scroll" data-toggle="modal"
						title="듀오매칭을 이용하기위해 내 여행정보를 활성화 합니다." href="#aboutModal">지금
						등록!</a> -->
						<%
							if (loginUser != null) {
						%>
						<a class="btn btn-default btn-xl page-scroll" data-toggle="modal"
							title="듀오매칭을 이용하기위해 내 여행정보를 활성화 합니다." href="#aboutModal1">지금
							등록!</a>
						<%
							} else {
						%>
						<a class="btn btn-default btn-xl page-scroll" data-toggle="modal"
							title="회원전용 서비스입니다. 먼저 로그인 해주세요." href="#alertModal3">지금 등록!</a>
						<%
							}
						%>
					</div>
				</form>
			</div>
		</div>
	</section>
	
	

	<!-- 듀오찾기 -->

	<section class="bg-dark" id="three">
		<!-- class="bg-dark" "bg-primary" -->

		<div class="text-center">
			<h2 class="margin-top-0 text-primary wow fadeIn">여행듀오 찾기</h2>

			<div class="container">
				<form class="row mb-5">
					<!-- action="/duo2/milogin"  -->

					<div class="col-sm-6 col-md-4 col-lg-3 mb-4">
						<div class="select-wrap">
							<span class="icon icon-arrow_drop_down"></span> <select
								name="offer-types" id="offer-types"
								class="form-control d-block rounded-0">
								<option value="" selected disabled hidden>성별</option>
								<option value="all">모두</option>
								<option value="male">남성</option>
								<option value="female">여성</option>
							</select>
						</div>
					</div>
					<div class="col-sm-6 col-md-4 col-lg-3 mb-4">
						<div class="select-wrap">
							<span class="icon icon-arrow_drop_down"></span> <select
								name="offer-types" id="offer-types"
								class="form-control d-block rounded-0">
								<option value="" selected disabled hidden>나이</option>
								<option value="20s">20대</option>
								<option value="30s">30대</option>
								<option value="40s">40대</option>
								<option value="50s">50대 이상</option>
							</select>
						</div>
					</div>
					<div class="col-sm-6 col-md-4 col-lg-3 mb-4">
						<div class="select-wrap">
							<span class="icon icon-arrow_drop_down"></span> <select
								class="form-control" onchange="scategoryChange(this)">
								<option value="" selected disabled hidden>여행 지역</option>
								<option value="a">아시아</option>
								<option value="b">홍콩/중국</option>
								<option value="c">일본</option>
								<option value="d">남태평양</option>
								<option value="e">유럽</option>
								<option value="f">미주/캐나다</option>
							</select>
						</div>
					</div>



					<!-- 	<div class="col-md-12">
								<tr>
									<th bgcolor="#ccccff">내 여행정보 공개여부</th>
									<td>&nbsp;</td>
									<td><input type="radio" name="matchprivate" value="T"
										required > 공개 &nbsp;&nbsp; <input type="radio"
										name="matchprivate" value="F" required> 비공개</td>
								</tr>
							</div> -->


					<div class="col-sm-6 col-md-4 col-lg-3 mb-4">
						<div class="select-wrap">
							<span class="icon icon-arrow_drop_down"></span> <select
								id="sgood" select class="form-control">
								<option value="" selected disabled hidden>여행 도시</option>
							</select>
						</div>
					</div>

					<div class="col-md-4 col-md-offset-4">
						<label></label>
						<!-- 	<button type="button" data-toggle="modal"
							data-target="#alertModal2"
							class="btn btn-primary btn-block btn-lg" value="Search" method="post">
							<ion-icon name="search"></ion-icon>
							검색
						</button> -->

						<input type="submit" data-toggle="modal"
							data-target="#alertModal2"
							class="btn btn-primary btn-block btn-lg" name="input" id="input"
							value="검색">


					</div>

				</form>
			</div>
		</div>
		<br> <br> <br> <br>

	<!-- 듀오사진 -->

		<div class="container-fluid">
			<div class="row no-gutter">
				<div class="col-lg-4 col-sm-6">
					<a href="#galleryModal1" class="gallery-box" data-toggle="modal"
						data-src="./assets/alf.jpg"> <img
						src="./resources/assets/alf.jpg" class="img-responsive"
						alt="Image 1">
						<div class="gallery-box-caption">
							<div class="gallery-box-content">
								<div>
									<i class="icon-lg ion-ios-search"></i>
								</div>
							</div>
						</div>
					</a>
				</div>
				<div class="col-lg-4 col-sm-6">
					<a href="#galleryModal2" class="gallery-box" data-toggle="modal"
						data-src="./assets/dol.jpg"> <img
						src="./resources/assets/dol.jpg" class="img-responsive"
						alt="Image 2">
						<div class="gallery-box-caption">
							<div class="gallery-box-content">
								<div>
									<i class="icon-lg ion-ios-search"></i>
								</div>
							</div>
						</div>
					</a>
				</div>
				<div class="clearfix hidden-lg"></div>
				<div class="col-lg-4 col-sm-6">
					<a href="#galleryModal3" class="gallery-box" data-toggle="modal"
						data-src="./assets/eu.jpg"> <img
						src="./resources/assets/eu.jpg" class="img-responsive"
						alt="Image 3">
						<div class="gallery-box-caption">
							<div class="gallery-box-content">
								<div>
									<i class="icon-lg ion-ios-search"></i>
								</div>
							</div>
						</div>
					</a>
				</div>
				<div class="col-lg-4 col-sm-6">
					<a href="#galleryModal4" class="gallery-box" data-toggle="modal"
						data-src="./assets/winter.jpg"> <img
						src="./resources/assets/winter.jpg" class="img-responsive"
						alt="Image 4">
						<div class="gallery-box-caption">
							<div class="gallery-box-content">
								<div>
									<i class="icon-lg ion-ios-search"></i>
								</div>
							</div>
						</div>
					</a>
				</div>
				<div class="clearfix hidden-lg"></div>
				<div class="col-lg-4 col-sm-6">
					<a href="#galleryModal5" class="gallery-box" data-toggle="modal"
						data-src="./assets/ris.jpg"> <img
						src="./resources/assets/ris.jpg" class="img-responsive"
						alt="Image 5">
						<div class="gallery-box-caption">
							<div class="gallery-box-content">
								<div>
									<i class="icon-lg ion-ios-search"></i>
								</div>
							</div>
						</div>
					</a>
				</div>
				<div class="col-lg-4 col-sm-6">
					<a href="#galleryModal6" class="gallery-box" data-toggle="modal"
						data-src="./assets/santo.jpg"> <img
						src="./resources/assets/santo.jpg" class="img-responsive"
						alt="Image 6">
						<div class="gallery-box-caption">
							<div class="gallery-box-content">
								<div>
									<i class="icon-lg ion-ios-search"></i>
								</div>
							</div>
						</div>
					</a>
				</div>
			</div>
		</div>
	</section>

	<!-- 듀오채팅 -->

	<section class="container-fluid" id="four">
		<div class="row">
			<h2 class="text-center text-primary wow fadeIn">듀오 채팅</h2>


			<div class="container">
				<h3 class=" text-center"></h3>
				<div class="messaging">
					<div class="inbox_msg">
						<div class="inbox_people">
							<div class="headind_srch">
								<div class="recent_heading">
									<h4>List</h4>
								</div>
								<div class="srch_bar">
									<div class="stylish-input-group">
										<input type="text" class="search-bar" placeholder="Search">
										<span class="input-group-addon">
											<button type="button">
												<i class="fa fa-search" aria-hidden="true"></i>
											</button>
										</span>
									</div>
								</div>
							</div>
							<div class="inbox_chat">
								<div class="chat_list active_chat">
									<div class="chat_people">
										<div class="chat_img">
											<img src="https://ptetutorials.com/images/user-profile.png"
												alt="sunil">
										</div>
										<div class="chat_ib">
											<h5>
												Sunil Rajput <span class="chat_date">Dec 25</span>
											</h5>
											<p>Test, which is a new approach to have all solutions
												astrology under one roof.</p>
										</div>
									</div>
								</div>

								<div class="chat_list">
									<div class="chat_people">
										<div class="chat_img">
											<img src="https://ptetutorials.com/images/user-profile.png"
												alt="sunil">
										</div>
										<div class="chat_ib">
											<h5>
												Sunil Rajput <span class="chat_date">Dec 25</span>
											</h5>
											<p>Test, which is a new approach to have all solutions
												astrology under one roof.</p>
										</div>
									</div>
								</div>
								<div class="chat_list">
									<div class="chat_people">
										<div class="chat_img">
											<img src="https://ptetutorials.com/images/user-profile.png"
												alt="sunil">
										</div>
										<div class="chat_ib">
											<h5>
												Sunil Rajput <span class="chat_date">Dec 25</span>
											</h5>
											<p>Test, which is a new approach to have all solutions
												astrology under one roof.</p>
										</div>
									</div>
								</div>
								<div class="chat_list">
									<div class="chat_people">
										<div class="chat_img">
											<img src="https://ptetutorials.com/images/user-profile.png"
												alt="sunil">
										</div>
										<div class="chat_ib">
											<h5>
												Sunil Rajput <span class="chat_date">Dec 25</span>
											</h5>
											<p>Test, which is a new approach to have all solutions
												astrology under one roof.</p>
										</div>
									</div>
								</div>
								<div class="chat_list">
									<div class="chat_people">
										<div class="chat_img">
											<img src="https://ptetutorials.com/images/user-profile.png"
												alt="sunil">
										</div>
										<div class="chat_ib">
											<h5>
												Sunil Rajput <span class="chat_date">Dec 25</span>
											</h5>
											<p>Test, which is a new approach to have all solutions
												astrology under one roof.</p>
										</div>
									</div>
								</div>
								<div class="chat_list">
									<div class="chat_people">
										<div class="chat_img">
											<img src="https://ptetutorials.com/images/user-profile.png"
												alt="sunil">
										</div>
										<div class="chat_ib">
											<h5>
												Sunil Rajput <span class="chat_date">Dec 25</span>
											</h5>
											<p>Test, which is a new approach to have all solutions
												astrology under one roof.</p>
										</div>
									</div>
								</div>
								<div class="chat_list">
									<div class="chat_people">
										<div class="chat_img">
											<img src="https://ptetutorials.com/images/user-profile.png"
												alt="sunil">
										</div>
										<div class="chat_ib">
											<h5>
												Sunil Rajput <span class="chat_date">Dec 25</span>
											</h5>
											<p>Test, which is a new approach to have all solutions
												astrology under one roof.</p>
										</div>
									</div>
								</div>
								<div class="chat_list">
									<div class="chat_people">
										<div class="chat_img">
											<img src="https://ptetutorials.com/images/user-profile.png"
												alt="sunil">
										</div>
										<div class="chat_ib">
											<h5>
												Sunil Rajput <span class="chat_date">Dec 25</span>
											</h5>
											<p>Test, which is a new approach to have all solutions
												astrology under one roof.</p>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="mesgs">
							<div class="msg_history">
								<div class="incoming_msg">
									<div class="incoming_msg_img">
										<img src="https://ptetutorials.com/images/user-profile.png"
											alt="sunil">
									</div>
									<div class="received_msg">
										<div class="received_withd_msg">
											<p>Test which is a new approach to have all solutions</p>
											<span class="time_date"> 11:01 AM | June 9</span>
										</div>
									</div>
								</div>
								<div class="outgoing_msg">
									<div class="sent_msg">
										<p>Test which is a new approach to have all solutions</p>
										<span class="time_date"> 11:01 AM | June 9</span>
									</div>
								</div>
								<div class="incoming_msg">
									<div class="incoming_msg_img">
										<img src="https://ptetutorials.com/images/user-profile.png"
											alt="sunil">
									</div>
									<div class="received_msg">
										<div class="received_withd_msg">
											<p>Test, which is a new approach to have</p>
											<span class="time_date"> 11:01 AM | Yesterday</span>
										</div>
									</div>
								</div>

								<div class="outgoing_msg">
									<div class="sent_msg">
										<p>Apollo University, Delhi, India Test</p>
										<span class="time_date"> 11:01 AM | Today</span>
									</div>
								</div>
								<div class="incoming_msg">
									<div class="incoming_msg_img">
										<img src="https://ptetutorials.com/images/user-profile.png"
											alt="sunil">
									</div>
									<div class="received_msg">
										<div class="received_withd_msg">
											<p>We work directly with our designers and suppliers, and
												sell direct to you, which means quality, exclusive products,
												at a price anyone can afford.</p>
											<span class="time_date"> 11:01 AM | Today</span>
										</div>
									</div>
								</div>
							</div>
							<div class="type_msg">
								<div class="input_msg_write">
									<input type="text" class="write_msg"
										placeholder="Type a message" />
									<button class="msg_send_btn" type="button">
										<i class="fa fa-paper-plane-o" aria-hidden="true"></i>
									</button>
								</div>
							</div>
						</div>
					</div>


				</div>
			</div>

		</div>
	</section>

	<!-- 매칭 서비스 리뷰 -->

	<section id="five" class="bg-dark">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 text-center">
					<h2 class="margin-top-0 text-primary wow fadeIn">매칭 서비스 리뷰</h2>
					<hr class="primary">
					<p>여행가듀오 매칭을 잘 사용하고 계신가요? 더 나은 서비스를 위해 당신의 소중한 리뷰를 기다립니다.</p>
				</div>
				<div class="col-lg-10 col-lg-offset-1 text-center">
					<form class="contact-form row" action="/travelduo/mreview" method="post">
						<div class="col-md-4">
							<label></label> <input type="text" class="form-control"
								placeholder="이름" name="username">
						</div>
						<div class="col-md-4">
							<label></label> <input type="email" class="form-control"
								placeholder="이메일" name="email">
						</div>
						<div class="col-md-4">
							<label></label> <input type="text" class="form-control"
								placeholder="전화번호" name="phone">
						</div>
						<div class="col-md-12">
							<label></label>
							<textarea class="form-control" rows="9" placeholder="리뷰 작성.." name="review"></textarea>
						</div>
						<div class="col-md-4 col-md-offset-4">
							<label></label>
							<%
							if (loginUser != null) {
						%>
						<br>
					<input type="submit" data-toggle="modal"
								data-target=""
								class="btn btn-primary btn-block btn-lg">
							</a>
						<%
							} else {
						%>
						<br>
						<a class="btn btn-primary btn-block btn-lg" data-toggle="modal"
							title="회원전용 서비스입니다. 먼저 로그인 해주세요." href="#alertModal3">제출</a>
						<%
							}
						%>
								
								<br><ion-icon name="mail"></ion-icon>
								보내기
							</input>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>

	<!-- Footer -->

	<!--  <footer id="footer">
        <div class="container-fluid">
            <div class="row">
                <div class="col-xs-6 col-sm-3 column">
                    <h4>Information</h4>
                    <ul class="list-unstyled">
                        <li><a href="">Products</a></li>
                        <li><a href="">Services</a></li>
                        <li><a href="">Benefits</a></li>
                        <li><a href="">Developers</a></li>
                    </ul>
                </div>
                <div class="col-xs-6 col-sm-3 column">
                    <h4>About</h4>
                    <ul class="list-unstyled">
                        <li><a href="#">Contact Us</a></li>
                        <li><a href="#">Delivery Information</a></li>
                        <li><a href="#">Privacy Policy</a></li>
                        <li><a href="#">Terms &amp; Conditions</a></li>
                    </ul>
                </div>
      
                <div class="col-xs-12 col-sm-3 text-right">
                    <h4 align="center">Follow</h4>
                    <ul class="list-inline">
                      <li><a rel="nofollow" href="http://facebook.com" title="Facebook"><i class="icon-lg ion-social-facebook-outline" ></i></a>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</li>
                      <li><a rel="nofollow" href="http://instagram.com" title="Instagram"><i class="icon-lg ion-social-instagram-outline"></i></a>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</li>
                    </ul>
                </div>
            </div>
            <br/>
            <span class="pull-right text-muted small"><a href="http://www.naver.com">여행가듀오 by Java screw bar</a> ©2019 Company</span>
        </div>
    </footer> -->

	<%@ include file="/resources/common/footer2.jsp"%>

	<!-- 갤러지 이미지 확대 -->

	<div id="galleryModal1" class="modal fade" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-body">
					<img src="./resources/assets/alf.jpg" class="img-responsive" />
					<p>
						<br />
						<button class="btn btn-primary btn-lg center-block"
							data-dismiss="modal" aria-hidden="true">
							<ion-icon name="checkmark"></ion-icon>
							확인
						</button>
					</p>
				</div>
			</div>
		</div>
	</div>

	<div id="galleryModal2" class="modal fade" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-body">
					<img src="./resources/assets/dol.jpg" class="img-responsive" />
					<p>
						<br />
						<button class="btn btn-primary btn-lg center-block"
							data-dismiss="modal" aria-hidden="true">
							<ion-icon name="checkmark"></ion-icon>
							확인
						</button>
					</p>
				</div>
			</div>
		</div>
	</div>

	<div id="galleryModal3" class="modal fade" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-body">
					<img src="./resources/assets/eu.jpg" class="img-responsive" />
					<p>
						<br />
						<button class="btn btn-primary btn-lg center-block"
							data-dismiss="modal" aria-hidden="true">
							<ion-icon name="checkmark"></ion-icon>
							확인
						</button>
					</p>
				</div>
			</div>
		</div>
	</div>

	<div id="galleryModal4" class="modal fade" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-body">
					<img src="./resources/assets/winter.jpg" class="img-responsive" />
					<p>
						<br />
						<button class="btn btn-primary btn-lg center-block"
							data-dismiss="modal" aria-hidden="true">
							<ion-icon name="checkmark"></ion-icon>
							확인
						</button>
					</p>
				</div>
			</div>
		</div>
	</div>

	<div id="galleryModal5" class="modal fade" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-body">
					<img src="./resources/assets/ris.jpg" class="img-responsive" />
					<p>
						<br />
						<button class="btn btn-primary btn-lg center-block"
							data-dismiss="modal" aria-hidden="true">
							<ion-icon name="checkmark"></ion-icon>
							확인
						</button>
					</p>
				</div>
			</div>
		</div>
	</div>

	<div id="galleryModal6" class="modal fade" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-body">
					<img src="./resources/assets/santo.jpg" class="img-responsive" />
					<p>
						<br />
						<button class="btn btn-primary btn-lg center-block"
							data-dismiss="modal" aria-hidden="true">
							<ion-icon name="checkmark"></ion-icon>
							확인
						</button>
					</p>
				</div>
			</div>
		</div>
	</div>

	<!-- 내 여행정보 등록-->

	<div id="aboutModal1" class="modal fade" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<h2 class="text-center">내 여행정보</h2>
					<p class="text-center" align="right">여행일정과 계획을 정확히 입력하시면 매칭에
						도움이 됩니다.</p>
					<h5 class="text-center">주의) 허위 및 타인의 정보를 무단으로 도용하면 제재의 원인이 될
						수있습니다.</h5>
					<div class="col-lg-10 col-lg-offset-1 text-center">
						<form class="contact-form row" action="/travelduo/miinsert"
							method="post" enctype="multipart/form-data">
							
							<div class="text-center col-xs-12 col-sm-6">

								<div id="imagePreview" class="btn center-block"></div>
								<br>
								 <input id="image" type="file" name="matchphoto"
									onchange="InputImage();">

								<div>
									<div class="input-group-prepend">
									<h5 align="left">프로필 사진 등록</h5>
										<span class="input-group-text" id="inputGroupFileAddon01"></span>
									</div>
									<br> <br>
									<br> <br>
								</div>
							</div>
							
							<div class="col-md-6">
								<label></label> <select class="form-control"
									onchange="icategoryChange(this)" name="matcharea"
									id="matcharea" required>
									<option value="" selected disabled hidden>여행 지역</option>
									<option value="a">아시아</option>
									<option value="b">홍콩/중국</option>
									<option value="c">일본</option>
									<option value="d">남태평양</option>
									<option value="e">유럽</option>
									<option value="f">미주/캐나다</option>
								</select>
							</div>

							<div class="col-md-6">
								<label></label> <select id="igood" select class="form-control"
									name="matchcity" id="matchcity">
									<option value="" selected disabled hidden>여행 도시</option>
								</select>
							</div>


							<div class="col-md-6">
								<label></label> <select class="form-control" name="matchyear"
									id="matchyear" required>

									<option value="2019" selected="selected">2019년</option>
									<option value="2020">2020년</option>
									<option value="2021">2021년</option>
								</select>
							</div>

							<div class="col-md-6">
								<label></label> <select class="form-control" name="matchmonth"
									id="matchmonth" required>

									<option value="jan" selected="selected">1월</option>
									<option value="feb">2월</option>
									<option value="mar">3월</option>
									<option value="apr">4월</option>
									<option value="may">5월</option>
									<option value="jun">6월</option>
									<option value="jul">7월</option>
									<option value="aug">8월</option>
									<option value="sep">9월</option>
									<option value="oct">10월</option>
									<option value="nov">11월</option>
									<option value="dec">12월</option>


								</select>
							</div>

							

							<div class="col-md-12">
								<label></label>
								<textarea class="form-control" rows="9" name="matchplan"
									placeholder="나의 여행계획"></textarea>
							</div>
							<div class="col-md-12">
								<tr>
									<th bgcolor="#ccccff">내 여행정보 공개여부</th>
									<td>&nbsp;</td>
									<td><input type="radio" name="matchprivate" value="T"
										required> 공개 &nbsp;&nbsp; <input type="radio"
										name="matchprivate" value="F" required> 비공개</td>
								</tr>
							</div>
							<% if(loginUser != null){ %>
							<div class="col-md-12" hidden>
								<label></label>
								<input type="text" name="userid"
									value="<%= loginUser.getUserId() %>">
							</div>
							<% } %>
							<div class="col-md-4 col-md-offset-4">
								<label></label> <input type="submit" data-toggle="modal"
									data-target="#alertModal1"
									class="btn btn-primary btn-block btn-lg" name="input"
									id="input" value="등록"> &nbsp;&nbsp; <br>


								<button type="button" data-toggle="modal" data-dismiss="modal"
									aria-hidden="true" class="btn btn-primary btn-lg center-block">
									나가기&nbsp;&nbsp;<i class="ion-android-close"></i>
								</button>
							</div>
						</form>
					</div>
				</div>


				<p>
				<h6>
					<a href="http://www.bootstrapzero.com">©Javascrew bar
						&nbsp;여행가듀오 마이페이지</a>
				</h6>
				</p>

			</div>
		</div>
	</div>
	</div>



				<p>
				<h6>
					<a href="http://www.bootstrapzero.com">©Javascrew bar
						&nbsp;여행가듀오 마이페이지</a>
				</h6>
				</p>

			</div>
		</div>
	</div>
	</div>

	<!-- 알림1 -->

	<!-- <div id="alertModal1" class="modal fade" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-body">
					<h2 class="text-center">등록완료!</h2>
					<p class="text-center">
						이제 여행준비가 끝났습니다. <br> 여행 듀오를 찾아보세요!
					</p>
					<br />
					<button class="btn btn-primary btn-lg center-block"
						data-dismiss="modal" aria-hidden="true">
						<ion-icon name="checkmark"></ion-icon>
						확인
					</button>
				</div>
			</div>
		</div>
	</div> -->

	<!-- 알림2 -->

	<div id="alertModal2" class="modal fade" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-body">
					<h2 class="text-center">전송완료!</h2>
					<p class="text-center">여행가듀오는 회원님의 의견을 적극 반영하겠습니다.</p>
					<p class="text-center">
						<a href="http://www.bootstrapzero.com">고객센터로 바로가기</a>
					</p>
					<br />
					<button class="btn btn-primary btn-lg center-block"
						data-dismiss="modal" aria-hidden="true">
						<ion-icon name="checkmark"></ion-icon>
						확인
					</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 알림3 -->

	<div id="alertModal3" class="modal fade" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-body">
					<h4 class="text-center">회원전용 서비스입니다!</h4>
					<p class="text-center">먼저 로그인해주세요.</p>
					<p class="text-center">
						<a href="http://www.bootstrapzero.com">고객센터로 바로가기</a>
					</p>
					<br />
					<button class="btn btn-primary btn-lg center-block"
						data-dismiss="modal" aria-hidden="true">
						<ion-icon name="checkmark"></ion-icon>
						확인
					</button>
				</div>
			</div>
		</div>
	</div>

	<!--여행가듀오 메인 header.jsp 사이드바 태그 -->

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
					<td><a href="/travelduo/logout2"><h5>로그아웃</h5></a></td>

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
		<form action="/travelduo/login2" method="post">
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
		
		<script src="./resources/js/jquery-3.3.1.min.js"></script>
		<script src="./resources/js/jquery.min.js"></script>
		<script src="./resources/js/bootstrap.min.js"></script>
		<script src="./resources/js/jquery.easing.min.js"></script>
		<script src="./resources/js/wow.js"></script>
		<script src="./resources/js/scripts.js"></script>
		<script src="https://unpkg.com/ionicons@4.5.5/dist/ionicons.js"></script>
		
</body>
</html>