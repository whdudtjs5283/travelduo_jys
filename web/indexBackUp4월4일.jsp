<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/travelduo/resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/travelduo/resources/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="/travelduo/resources/css/bootstrap.min.css">
<script type="text/javascript" src="/travelduo/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
function fnMove(seq){
    var offset = $("#h" + seq).offset();
    $('html, body').animate({scrollTop : offset.top}, 400);
}
</script>
<meta charset="UTF-8">
<title>travel duo</title>
</head>
<body>
<%@ include file="views/common/header.jsp" %>


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


<div class="container" class="bg-dark">

  
    <!-- Portfolio Section -->
   <h2 class="text-center wow fadeIn"></h2>
   <br><br>

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
           <a href="#"><img class="card-img-top" src="/travelduo/resources/images/london.jpg" alt=""></a>
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
    
  <br>

    <!-- 매칭시스템 -->
    <div class="row">
      <div class="col-lg-6">
        <h2>매칭시스템</h2>
        <p>여행가 듀오를 이용해 여행 친구를 찾아보세요! </p>
        <ul> 
          <li>여행가 듀오는 완벽한 여행 친구를 찾을 수 있는 최선의 방법입니다! 본 서비스는 여행 친구를 찾거나 동일한 여행 계획을 가진 싱글 여행 동반자들을 찾는 분들을 타겟으로 하고 있습니다. </li><br>
          <li>어디를 가시든지, 진심이 통하는 멋진 여행 친구를 만나보세요. 쇼핑도 하고 함께 놀러도 가고, 밥도 먹으며 바닷가와 이국적인 자연 경치를 감상하시거나 그냥 멋진 상대와 함께 편안한 휴식을 취해 보세요.</li><br>
          <li>꿈꾸던 곳을 방문하시고 그 곳에서 멋진 여행 친구를 찾아보세요. 여행 친구를 찾는 방법은 매우 안전하고, 편안하며 몇 초 밖에 소요되지 않습니다... 그리고 무엇보다도 즐겁구요!</li><br>
          <li><strong>듀오를 찾아 함께 여행해 보세요!</strong></li>
        </ul>
      </div>
      <div class="col-lg-6">
        <a href="index2.jsp"><img class="img-fluid rounded" src="./resources/images/home_match.jpg" alt=""></a> 
      </div>
    </div>
    <!-- /.row -->
  </div>
  <!-- /.container -->
  <%@ include file="views/common/floating.jsp" %>
<%@ include file="views/common/footer.jsp" %>
</body>
</html>