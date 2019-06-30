<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="product.model.vo.Product" %>
 <%
 	Product product = (Product)request.getAttribute("product");
 %>
<!DOCTYPE html>
<html>
<head>	
<meta charset="UTF-8">
<title>Travel Duo</title>


<link href="/travelduo/resources/css/grayscale.min.css" rel="stylesheet">
  <link href="/travelduo/resources/css/sb-admin-2.min.css" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">


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

.path a {
	text-decoration: none;
}

.pagetext {
	color : black;
}

.pagetext:hover {
	text-decoration: none;
	color: black;
}
</style>
</head>
<body id="page-top">

<!-- Navigation -->

<%@ include file="/../views/common/header.jsp" %>



<header>
  <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
      <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
      <!-- Slide One - Set the background image for this slide in the line below -->
      <div class="carousel-item active" style="background-image: url('/travelduo/resources/images/product/<%= product.getrBannerImage1() %>')">
        <div class="carousel-caption d-none d-md-block">
          <h3 class="display-4"><!-- 첫번째 사진 타이틀 --></h3>
          <p class="lead"><!-- 첫번째 사진 내용 --></p>
        </div>
      </div>
      <!-- Slide Two - Set the background image for this slide in the line below -->
      <div class="carousel-item" style="background-image: url('/travelduo/resources/images/product/<%= product.getrBannerImage2() %>')">
        <div class="carousel-caption d-none d-md-block">
          <h3 class="display-4"><!-- 두번째 사진 타이틀 --></h3>
          <p class="lead"><!-- 두번째 사진 내용 --></p>
        </div>
      </div>
      <!-- Slide Three - Set the background image for this slide in the line below -->
      <div class="carousel-item" style="background-image: url('/travelduo/resources/images/product/<%= product.getrBannerImage3() %>')">
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

   <!-- Projects Section -->
  <section id="projects" class="projects-section bg-white" style="margin-top:-100px;">
    <div class="container" >
	
	<div class="path">
		<a class="pagetext" href="/travelduo/index.jsp">&nbsp;메인페이지</a> <span class="lnr lnr-chevron-right"></span>
		<a class="pagetext" href="pclist?coun=<%= product.getCountry() %>"><%= product.getCountry() %></a> <span class="lnr lnr-chevron-right"></span>
		<%= product.getProductName() %><br>
		<span style="font-size:20pt;"><%= product.getProductName() %></span>
	</div>

<br><br>

      <!-- Featured Project Row -->
      <div class="row align-items-center no-gutters mb-4 mb-lg-5">
        <div class="col-xl-8 col-lg-7">
          <img class="img-fluid mb-3 mb-lg-0" src="/travelduo/resources/images/product/<%= product.getrDestinationImage() %>" alt="">
        </div>
        <div class="col-xl-4 col-lg-5">
          <div class="featured-text text-center text-lg-left">
            <h4><%= product.getDestination() %> 소개</h4>
            <p class="text-black-70 mb-0"><%= product.getDestinationInfo() %></p>
          </div>
        </div>
      </div>

      <!-- Project One Row -->
      <div class="row justify-content-center no-gutters mb-5 mb-lg-0">
        <div class="col-lg-6">
          <img class="img-fluid" src="/travelduo/resources/images/product/<%= product.getrTouristImage1() %>" alt="">
        </div>
        <div class="col-lg-6">
          <div class="bg-black text-center h-100 project">
            <div class="d-flex h-100">
              <div class="project-text w-100 my-auto text-center text-lg-left">
                <h4 class="text-white"><%= product.getTouristSpot1() %></h4>
                <p class="mb-0 text-white-50"><%= product.getTouristSpot1Info() %></p>
                <hr class="d-none d-lg-block mb-0 ml-0">
              </div>
            </div>
          </div>
        </div>
      </div>

      <!-- Project Two Row -->
      <div class="row justify-content-center no-gutters">
        <div class="col-lg-6">
          <img class="img-fluid" src="/travelduo/resources/images/product/<%= product.getrTouristImage2() %>" alt="">
        </div>
        <div class="col-lg-6 order-lg-first">
          <div class="bg-black text-center h-100 project">
            <div class="d-flex h-100">
              <div class="project-text w-100 my-auto text-center text-lg-right">
                <h4 class="text-white"><%= product.getTouristSpot2() %></h4>
                <p class="mb-0 text-white-50"><%= product.getTouristSpot2Info() %></p>
                <hr class="d-none d-lg-block mb-0 mr-0">
              </div>
            </div>
          </div>
        </div>
      </div>

	<!-- Project three Row -->
      <div class="row justify-content-center no-gutters mb-5 mb-lg-0">
        <div class="col-lg-6">
          <img class="img-fluid" src="/travelduo/resources/images/product/<%= product.getrTouristImage3() %>" alt="">
        </div>
        <div class="col-lg-6">
          <div class="bg-black text-center h-100 project">
            <div class="d-flex h-100">
              <div class="project-text w-100 my-auto text-center text-lg-left">
                <h4 class="text-white"><%= product.getTouristSpot3() %></h4>
                <p class="mb-0 text-white-50"><%= product.getTouristSpot3Info() %></p>
                <hr class="d-none d-lg-block mb-0 ml-0">
              </div>
            </div>
          </div>
        </div>
      </div>
      
    </div>
  </section>
<div style="margin-top:-100px;"></div>
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