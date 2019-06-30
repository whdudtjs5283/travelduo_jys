<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="member.model.vo.Member"%>
<%

 String findMember = (String)session.getAttribute("findMember");
	
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>아이디 찾기</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="/travelduo/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="/travelduo/resources/css/main.css">

<script type="text/javascript"
	src="/travelduo/resources/js/jquery-3.3.1.min.js"></script>

</head>

<style>
.message.info {
	border-color: #BCE8F1;
	color: #3A87AD;
	background-color: #D9EDF7;
}

.message {
	position: relative;
	margin: 1em 0;
	padding: 0 1em;
	border: 1px solid #ddd;
	border-radius: 4px;
	line-height: 1.4;
	font-size: 13px;
	text-shadow: 0 1px 0 rgba(255, 255, 255, .5);
	background-color: #f8f8f8;
}
</style>



<body>
	<div class="signup-img">
		<img src="/travelduo/resources/images/wan/회원가입에서 풍경사진2.jpg"
			width="1519" height="250">
	</div>
	<!-- <hr style= "clear:left"> -->
	<br>
	<br>
	<% if(findMember !=null){ %>
	<%@ include file="../common/header.jsp"%>



	<div class="container">


		<!-- 모달창 -->
		<div class="modal fade" id="defaultModal">
			<div class="modal-dialog">
				<!--크기를 보다 작게, 화면에 맞도록 조정해주고 ,//모달창이 위에서 아래로 내려오게 뜨도록 함 클릭하면 다시위로 올라가는 듯하면서 사라짐.// 설정을 하지않으면 ,내려오지않고 맨위에 크게박혀있다. -->
				<div class="modal-content">
					<!-- 모달창의 화면을 나타냄 . 이게 없으면 모달창이 투명하게 보인다.  -->
					<div class="modal-header">
						<!-- 모달창 위의 헤더에 뜨는 부분  -->
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<!--  data-dismiss="modal 은 x를 누르면 꺼지도록 함.-->
						<!-- close 를 하면 맨우측으로 가면서  x가 모양이 바뀜-->
						<!--숨김 콘텐츠의 경우, 정보는 전달하되 단순히 화면에서만 보이지 않도록 처리된 콘텐츠에 aria-hidden=”true”를 지정하지 말아야 한다. aria-hidden=”true”를 설정하면 의미적으로도 숨겨진 콘텐츠로 인식하기 때문이다.  --
                       </div>
                       <div class="modal-body">	<!-- 모달 몸통 -->
						<p class="modal-contents"></p>
						<!--모달 몸통에서의 내용이다 나중에 전역변수를 통해 , 상황에 맞는 말들을 넣어줄 것이다.  -->
					</div>
					<div class="modal-footer">
						<!-- modal footer -->
						<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
						<!-- 마지막에는 x와 동일한 기능을 하는 닫기버튼을 만들어준다. -->
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
		<!-- 모달창 -->

		<div class="row">
			<div class="col-md-12 content-body">
				<ul class="nav nav-tabs">
					<li class="nav-item "><a class="nav-link active"
						href="/travelduo/views/member/memberFindId.jsp">아이디 찾기</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/travelduo/views/member/memberFindPwd.jsp">비밀번호 찾기</a></li>


				</ul>
				<br>
				<h3>이름과 이메일 주소로 아이디 찾기</h3>
				<p>
					입력된 이름과 이메일 주소에 대한 아이디 값입니다.<br />
				</p>
				<div id="pos1">
					<div class="message info">
						<p>
						<h5>
							회원님의 아이디는 <strong><%= findMember  %></strong> 입니다.
						</h5>


						</p>
					</div>
				</div>
				<br>
				<!--  <input type="button" value="홈으로" class="btn btn"> -->
				<br> <br> <br>


			</div>
		</div>
	</div>
	<%} %>

	<%@ include file="../common/footer.jsp"%>

</body>
</html>