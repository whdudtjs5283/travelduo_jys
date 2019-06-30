<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import=" java.util.*, product.model.vo.Product" %>
<%
	ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("list");
%>
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
  <link href="/travelduo/resources/css/sb-admin-2.min.css" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">


<!--
			CSS
			============================================= -->

<style type="text/css">
.carousel-item {
	height: 100vh;
	min-height: 350px;
	background: no-repeat center center scroll;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
}

.listText {
	color: black;
}

.listText:hover {
	text-decoration: none;
	color: black;
}
</style>
</head>
<body id="page-top">
	<%@ include file="/../views/common/header.jsp" %>
	<!-- #header -->
	<div id="carouselExampleIndicators" class="carousel slide"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0"class="active"></li>
			<% if(list.size() > 1) {%>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<% } %>
			<% if(list.size() > 2) {%>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
			<% } %>
			<% if(list.size() > 3) {%>
			<li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
			<% } %>
			<% if(list.size() > 4) {%>
			<li data-target="#carouselExampleIndicators" data-slide-to="4"></li>
			<% } %>
		</ol>
		<div class="carousel-inner" role="listbox">
			<!-- Slide One - Set the background image for this slide in the line below -->
			<div class="carousel-item active"
				style="background-image: url('/travelduo/resources/images/product/<%= list.get(0).getrBannerImage1() %>')">
				<div class="carousel-caption d-none d-md-block">
					<h3 class="display-4">
						<!-- 첫번째 사진 타이틀 -->
					</h3>
					<p class="lead">
						<!-- 첫번째 사진 내용 -->
					</p>
				</div>
			</div>
			
			<% if(list.size() > 1) {%>
			<!-- Slide Two - Set the background image for this slide in the line below -->
			<div class="carousel-item"
				style="background-image: url('/travelduo/resources/images/product/<%= list.get(1).getrBannerImage1() %>')">
				<div class="carousel-caption d-none d-md-block">
					<h3 class="display-4">
						<!-- 두번째 사진 타이틀 -->
					</h3>
					<p class="lead">
						<!-- 두번째 사진 내용 -->
					</p>
				</div>
			</div>
			<% } %>
			
			<% if(list.size() > 2) {%>
			<!-- Slide Three - Set the background image for this slide in the line below -->
			<div class="carousel-item"
				style="background-image: url('/travelduo/resources/images/product/<%= list.get(2).getrBannerImage1() %>')">
				<div class="carousel-caption d-none d-md-block">
					<h3 class="display-4"></h3>
					<p class="lead"></p>
				</div>
			</div>
			<% } %>
			
			<% if(list.size() > 3) {%>
			<!-- Slide Three - Set the background image for this slide in the line below -->
			<div class="carousel-item"
				style="background-image: url('/travelduo/resources/images/product/<%= list.get(3).getrBannerImage1() %>')">
				<div class="carousel-caption d-none d-md-block">
					<h3 class="display-4"></h3>
					<p class="lead"></p>
				</div>
			</div>
			<% } %>
			
			<% if(list.size() > 4) {%>
			<!-- Slide Three - Set the background image for this slide in the line below -->
			<div class="carousel-item"
				style="background-image: url('/travelduo/resources/images/product/<%= list.get(4).getrBannerImage1() %>')">
				<div class="carousel-caption d-none d-md-block">
					<h3 class="display-4"></h3>
					<p class="lead"></p>
				</div>
			</div>
			<% } %>
			
		</div>
		<a class="carousel-control-prev" href="#carouselExampleIndicators"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>

	<!-- 추천 여행지 -->
	<section class="destinations-area section-gap">
		<div class="container" style="margin-top:-100px;">
		
			<div class="row">
			<% for(Product product : list) { %>
				<a href="/travelduo/pdetail?num=<%= product.getProductNum() %>" 
					class="listText">
					<div class="col-lg-4">
						<div class="single-destinations">
							<div class="thumb" style="width:350px; height:196px;">
								<img src="/travelduo/resources/images/product/<%= product.getrBannerImage1() %>" alt="">
							</div>
							<div class="details">
								<h4><%= product.getProductName() %></h4>
								<ul class="package-list">
									<li class="d-flex justify-content-between align-items-center">
										<span>국가</span> <span><%= product.getCountry() %></span>
									</li>
									<li class="d-flex justify-content-between align-items-center">
										<span>여행지역</span> <span><%= product.getDestination() %></span>
									</li>
									<li class="d-flex justify-content-between align-items-center">
										<span></span> <a href="#" class="price-btn" style="text-decoration:none;">
											이동</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</a>
		<% } %>
			</div>
	</section>
	<!-- End destinations Area -->

 <a class="scroll-to-top rounded" href="#page-top">▲</a>
	<%@ include file="/../views/common/footer.jsp" %>

	<script type="text/javascript" src="/travelduo/resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/travelduo/resources/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/travelduo/resources/js/superfish.min.js"></script>
	<script type="text/javascript" src="/travelduo/resources/js/jquery.magnific-popup.min.js"></script>
	<script type="text/javascript" src="/travelduo/resources/js/owl.carousel.min.js"></script>
	<script type="text/javascript" src="/travelduo/resources/js/main.js"></script>
	
	  <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
  <script src="/travelduo/resources/js/sb-admin-2.min.js"></script>
  
</body>
</html>