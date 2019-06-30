<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String modifyResult = (String) request.getAttribute("modifyResult");
%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>회원정보 수정</title>

<link rel="stylesheet" href="/travelduo/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="/travelduo/resources/css/main.css">

<script type="text/javascript"
	src="/travelduo/resources/js/jquery-3.3.1.min.js"></script>

<script type="text/javascript">
	window.onload = function() {
<%if (modifyResult != null && modifyResult.equals("fail")) {%>
	alert("비밀번호가 회원 아이디와 일치하지 않습니다. \n비밀번호를 확인해주세요");
<%}%>
	}
</script>
<style type="text/css">
#pos1 {
	position: relative;
	left: -4px;
	margin-bottom: 10px; /* 위아래공백만들어줌 */
	top: -10px;
}
/*  content를 좌측으로 이동시키기 위함   */
#divPwd {
	position: relative;
	top: -53px;
}

#posbutton {
	position: relative;
	right: -285px;
	top: -107px
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
	<%@ include file="../common/header.jsp"%>


	<div class="container">
		<div class="row">
			<div class="col-md-12 content-body">
				<ul class="nav nav-tabs">
					<li class="nav-item "><a class="nav-link"
						href="/travelduo/views/member/memberMyPage.jsp">회원정보 보기</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="/travelduo/views/member/memberModify.jsp">회원정보 수정</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/travelduo/views/member/memberDelete.jsp">회원 탈퇴</a></li>
				</ul>

				<br>

				<h1>비밀번호 재확인</h1>
				<p>&nbsp;회원의 정보를 안전하게 보호하기 위해, &nbsp;비밀번호를 다시 한번 입력해 주세요.</p>

				<form method="post" action="/travelduo/mmodify">
					<div id="pos1">
						<td>
							<div class="form-group " id="divId">
								<label for="inputId"></label>
								<div class="col-lg-3">
									<input type="text" class="form-control " id="userid"
										name="userid" data-rule-required="true"
										value="<%=loginUser.getUserId()%>" readonly maxlength="20">

								</div>
							</div>
						</td>&emsp; &nbsp;
						<td>
							<div class="form-group" id="divPwd">
								<label for="inputPwd"></label>
								<div class="col-lg-3">
									<input type="password" class="form-control" id="userpwd"
										name="userpwd" data-rule-required="true" placeholder="비밀번호"
										maxlength="25">

								</div>
							</div> <input type="submit" id="posbutton" value=" 확인  "
							class="btn btn-secondary ">
						</td>
						<!-- <button class="btn" onclick="return checkId();" >ID 찾기</button> -->
				</form>
			</div>
			</form>
			<br> <br> <br> <br> <br> <br> <br>
			<br> <br>

		</div>
	</div>
	</div>


	<!-- 		<hr style= "clear:left"> -->
	<%@ include file="../common/footer.jsp"%>
	<!--여기선 절대경로 안돼 상대경로써야함  -->

</body>
</html>
