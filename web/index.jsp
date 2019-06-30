<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <% 
   String result =(String)request.getAttribute("result");
   String loginResult = (String)request.getAttribute("loginResult");
   String insertResult = (String)request.getAttribute("insertResult");
   %> 
    
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

window.onload=function(){
	   <% if(result !=null && result.equals("success")){ %>
	      alert("탈퇴가 정상적으로 진행되었습니다.\n이용해주셔서 감사합니다.");

	   <% }else if(result != null && result.equals("fail")){ %>
	      alert("탈퇴가 이루어지지않았습니다.");
	   <% }else if(loginResult != null && loginResult.equals("fail")){ %>
	      alert("로그인 실패! \n회원정보가 없거나 일치하지 않습니다.");
	   <% }else if(insertResult != null && insertResult.equals("success")){ %>
	      alert("회원가입 성공! \n로그인 해주세요.")
	   <% } %>
	   
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
          <a href="/travelduo/pdetail?num=frspr"><img class="card-img-top" src="/travelduo/resources/images/paris.jpg" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="/travelduo/pdetail?num=frspr">파리</a>
            </h4>
            <p class="card-text">파리는 프랑스의 수도이자 유럽의 대표도시 중 하나입니다. 파리와 같은 대도시는 짧은 일정으로는 둘러보기 힘들 정도로 관광명소가 많은데요. 따라서 서유럽 3개국 정도를 10박에 걸쳐 방문할 예정이라면, 파리에서 3박4일 정도는 머물러야 좋습니다. 프랑스는 미식가들의 나라인 만큼, 반드시 먹어봐야 할 것들도 소개해드립니다 :-)</p>
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-sm-6 portfolio-item">
        <div class="card h-100">
           <a href="/travelduo/pdetail?num=ukld01"><img class="card-img-top" src="/travelduo/resources/images/london.jpg" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="/travelduo/pdetail?num=ukld01">런던</a>
            </h4>
            <p class="card-text">영국의 수도인 런던은 세계 중요한 비지니스와 금융 도시의 하나일 뿐만 아니라, 세계의 정치, 교육, 엔터테인먼트, 대중문화, 패션에도 많은 영향을 끼치는 중요한 도시입니다. 런던은 또한 최고의 대규모 교통시설을 갖춘 도시중의 하나이기도 합니다. 
런던에는 셀수없을 만큼의 많은 행사들과 볼거리들이 가득한 도시이며, 그중에 몇가지 아래의 볼거리들은 런던에 오면 꼭 봐야할 것들중에 속합니다.</p>
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-sm-6 portfolio-item">
        <div class="card h-100">
            <a href="/travelduo/pdetail?num=ukld01"><img class="card-img-top" src="/travelduo/resources/images/rome.jpg" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="/travelduo/pdetail?num=ukld01">로마</a>
            </h4>
            <p class="card-text">로마는 고대의 유물, 유적이 많아 그것들을 훼손하지 않으려는 노력의 결과로 지하철이 발달되어 있지 않습니다. 따라서 로마는 대개 버스나 도보로 여행하게 되므로 편한 신발은 필수입니다. 서유럽을 방문한다면, 로마는 반드시 방문하길 추천합니다.</p>
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-sm-6 portfolio-item">
        <div class="card h-100">
           <a href="/travelduo/pdetail?num=sdn01"><img class="card-img-top" src="/travelduo/resources/images/sydney.jpg" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="/travelduo/pdetail?num=sdn01">시드니</a>
            </h4>
            <p class="card-text">시드니는 세계에서 가장 활기찬 도시 중 하나이며, 
호주의 다른 지역으로 여행하기 위한 관문이기도 합니다. 시드니는 다채롭고 활기찬 곳입니다.</p>
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-sm-6 portfolio-item">
        <div class="card h-100">
      <a href="/travelduo/pdetail?num=jposk02"><img class="card-img-top" src="/travelduo/resources/images/osaka.jpg" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="/travelduo/pdetail?num=jposk02">오사카</a>
            </h4>
            <p class="card-text">오사카의 매력적인 문화와 일상에 빠져들 준비가 되셨나요? 오사카 하면 특히 음식! 음식을 빼놓을 수 없죠. 영국 가디언 지로부터 세계 최고의 음식 도시로 선정된 오사카! 오사카는 우리의 식욕을 만족시켜 줄 그 무언가를 가지고 있습니다. '먹을 수 없을 때까지 먹어라'는 오사카의 격언 쿠이다오레처럼, 이곳에는 그야말로 산해진미가 넘쳐납니다. 타코야키의 맛깔난 향기와 오코노미야키, 우동, 그리고 다른 일본 전통 음식들이 길가에 즐비합니다. 쇼핑 거리에서 쇼핑도 마음껏 즐기세요!</p>
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-sm-6 portfolio-item">
        <div class="card h-100">
            <a href="/travelduo/pdetail?num=tgbk"><img class="card-img-top" src="/travelduo/resources/images/bangkok.jpg" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="/travelduo/pdetail?num=tgbk">방콕</a>
            </h4>
            <p class="card-text">전통적 요소와 현대적 면모가 조화를 이룬 도시, 방콕

동남아시아를 대표하는 열대의 도시 방콕은 최근 대대적인 재단장을 거쳐 한결 매력적인 모습을 자랑합니다. 다채로운 외국인 공동체, 나날이 발전하는 예술, 현대식 공항 덕분에 오늘날 방콕은 세계적인 트렌드에 한몫하고 있습니다. 나날이 변신을 거듭하고 있어 방콕을 자주 찾는 여행자조차 시시각각 변하는 이 도시의 모습에 놀라곤 합니다.</p>
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