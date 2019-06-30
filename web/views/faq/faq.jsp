<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../common/header.jsp" %>

<hr style="clear:left;"> 
<br>
<br>
<br>

<div class="container">
<div class="row faq_margin">
<h2>자주하는 질문(FAQ)</h2>
</div>
<hr>
	<div class="accordion" id="accordionExample">
	<div class="col-md-15 col-md-offset-1">
  <div class="card">
    <div class="card-header" id="headingOne">
      <h2 class="mb-0">
        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
          해외여행자 보험이란??
        </button>
      </h2>
    </div>

    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
      <div class="card-body">
       여행도중에 우연히 발생하게 되는 각종 사고 및 질병, 조난 시 구조비용, 휴대품의 도난 손해 등의 보상을 목적으로 하는 보험. 

해외여행자보험의 실손의료비는 여러 보험사에 중복 계약을 했더라도 중복보상이 안되고 비례보상으로 처리된다. 
(단 , 사망보험금은 중복보상 가능) 
( 휴대품 손해, 배상책임도 비례보상으로 처리) 
국내에서 상해 및 질병으로 치료 받는경우 발생한 실손의료비에 대해 100% 보상을 받을수 없다. 자기부담금이 설정되어 있어 그만큼의 비용을 제외하고 보상을 받을수 있다. 
      </div>
    </div>
  </div>
  <div class="card">
    <div class="card-header" id="headingTwo">
      <h2 class="mb-0">
        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
          항공권 업그레이드 가능한가요?
        </button>
      </h2>
    </div>
    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
      <div class="card-body">
        보통 패키지 상품의 경우는 기본 이코노미 좌석을 이용합니다. 
비지니즈석이나 그 이상으로 업그레이드 하실 경우는, 차액부분을 부담하시거나 또는 고객님의 해당항공사 마일리지를 이용하셔서도 가능하십니다. 

단, 성수기 날짜나 좌석확보가 어려운 날짜는 불가할 수도 있으니 사전에 문의하시어 예약하시는것이 중요합니다.
      </div>
    </div>
  </div>
  <div class="card">
    <div class="card-header" id="headingThree">
      <h2 class="mb-0">
        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
          돌아오는 날짜 변경 가능한가요?
        </button>
      </h2>
    </div>
    <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
      <div class="card-body">
        일정이 모두 끝난 후 개별귀국을 원하실 경우는 출발전에 우선 돌아오실 날짜와 좌석가능여부를 사전에 체크.예약과 발권을 완료 하셔야하며 한국에서 혹은 현지에서 돌아오실때 일정금액을 현지공항에서 지불하셔야 하시면 됩니다. 
노선에 따라서 또는 항공편에 따라서 리턴변경이 불가한 경우도 있으니, 출발전에 필히 가능여부를 체크하시는 것이 중요합니다.
      </div>
    </div>
  </div>
   <div class="card">
    <div class="card-header" id="headingFour">
      <h2 class="mb-0">
        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
          E-Ticket이란?
        </button>
      </h2>
    </div>
    <div id="collapseFour" class="collapse" aria-labelledby="headingFour" data-parent="#accordionExample">
      <div class="card-body">
        기존 종이항공권(Paper Ticket)대신 전자항공권(Electronic Ticket)으로 발급하여 
고객님의 모든 여행정보가 항공사의 시스템에 보관/처리되는 서비스입니다. 

고객님의 티켓정보가 항공사의 시스템에 전자문서로 보관 되므로 분실의 위험이 없으며 원하시는 e-mail 또는 fax로도 받아보실 수 있습니다. 
      </div>
    </div>
  </div>
   <div class="card">
    <div class="card-header" id="headingFive">
      <h2 class="mb-0">
        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
          면세점에서 구입한도와 입국시 면세한도는 얼마인가요?
        </button>
      </h2>
    </div>
    <div id="collapseFive" class="collapse" aria-labelledby="headingFive" data-parent="#accordionExample">
      <div class="card-body">
        여행자 1인당 총 면세품 구입금액이 $3,000을 넘어서는 안되며, 시계 등의 고가품은 
물건 1개당 $400을 넘어서는 안됩니다.


$3,000을 초과하여 물품을 반입하는 경우, 비록 출국시 국내 면세점에서 구입한 
물품일지라도 세관에 반드시 신고하여 관세를 납부하여야 합니다. 위 사항을 위반할 
시에는 관세법 규정에 의거 처벌받게 됩니다.


우리나라 입국 시에는 면세금액 한도가 $400미만으로 적용되기 때문에 주의해서 
들어오셔야합니다.
      </div>
    </div>
  </div>
   <div class="card">
    <div class="card-header" id="headingSix">
      <h2 class="mb-0">
        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseSix" aria-expanded="false" aria-controls="collapseSix">
         애완동물을 기내에 데려갈 수 있나요?
        </button>
      </h2>
    </div>
    <div id="collapseSix" class="collapse" aria-labelledby="headingSix" data-parent="#accordionExample">
      <div class="card-body">
       가능합니다. 하지만 탑승할 수 있는 애완 동물의 종류가 제한이 되어있습니다. 
보통 1인 1마리로 제한, 예방 접종과 건강 진단서 등 서류를 준비하셔야합니다. 애완동물의 종류나 입국하는 나라에 따라서 데려갈 수 없는 경우도 있으니 자세한 사항은 해당 항공사로 문의하시면 됩니다. 
      </div>
    </div>
  </div>
   <div class="card">
    <div class="card-header" id="headingSeven">
      <h2 class="mb-0">
        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseSeven" aria-expanded="false" aria-controls="collapseSeven">
          도둑 맞았을 때는 어떻게 대처 해야하나요?
        </button>
      </h2>
    </div>
    <div id="collapseSeven" class="collapse" aria-labelledby="headingSeven" data-parent="#accordionExample">
      <div class="card-body">
        1)절도를 당한 즉시 가장 가까운 경찰서로 가서 반드시 POLICE REPORT를 받습니다. 이때 신고는 본인이 직접 작성해야 하며 절도를 당한 여행객 인원수대로 별도작성해야 손해를 줄일 가능성이 더 있습니다. 
2)본국으로 귀국후 POLICE REPORT를 가지고 보험회사에 신고합니다. 
보험사 제출시 필요서류 : POLICE REPORT, 손상품 수리견적서(영수증 포함),여권사본, 통장사본 (본인의 통장이 아닐 경우 관계를 나타낼 수 있는 서류) 

보험처리가 안되는 것들 : 현금, 수표, 항공권 등등의 유가증권 
      </div>
    </div>
  </div>
   <div class="card">
    <div class="card-header" id="headingeight">
      <h2 class="mb-0">
        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseeight" aria-expanded="false" aria-controls="collapseeight">
          팁은 어떻게 주어야 하나요?
        </button>
      </h2>
    </div>
    <div id="collapseeight" class="collapse" aria-labelledby="headingeight" data-parent="#accordionExample">
      <div class="card-body">
       - 유럽이나 미주 지역에서는 식당에서도 10% 정도의 팁을 주는 게 예의랍니다. 

- 가방을 방까지 들어다주거나 호텔에서 서비스를 받았다면 조금의 팁을 주는게 관례입니다.($1 정도) 

- 방을 청소해주거나 CHECK-OUT할 때 침대옆 탁자위에 $1 정도 놓는 것이 예의랍니다.
      </div>
    </div>
  </div>
</div>
</div>
</div>


<hr>
<%@ include file="../common/footer.jsp" %>
</body>
<style>
.faq_margin{

	margin-left:430px;
	margin-top:100px;
}
</style>
</html>