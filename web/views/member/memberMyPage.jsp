<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="member.model.vo.Member"%>

<%
	String result = (String) request.getAttribute("result");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>회원정보</title>

<link rel="stylesheet" href="/travelduo/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="/travelduo/resources/css/main.css">

<script type="text/javascript"
	src="/travelduo/resources/js/jquery-3.3.1.min.js"></script>

<script type="text/javascript">
	window.onload = function() {
<%if (result != null && result.equals("success")) {%>
	alert("수정이 정상적으로 이루어졌습니다.");
<%} else if (result != null && result.equals("fail")) {%>
	alert("수정이 정상적으로 이루어지지 않았습니다.");
<%}%>
	}
</script>



<style type="text/css">
#pos1 {
	position: relative;
	top: 10px;
}
/*  content를 좌측으로 이동시키기 위함   */
#pos2 {
	position: relative;
	top: 17px;
}

#pos3 {
	position: relative;
	top: 24px;
}

#pos4 {
	position: relative;
	top: 31px;
}

#pos5 {
	position: relative;
	top: 38px;
}

#pos6 {
	position: relative;
	top: 45px;
}
</style>
<body>
	<div class="signup-img">
		<img src="/travelduo/resources/images/wan/회원가입에서 풍경사진1.jpg"
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
					<li class="nav-item "><a class="nav-link active"
						href="/travelduo/views/member/memberMyPage.jsp">회원정보 보기</a></li>
					<li class="nav-item"><a class="nav-link "
						href="/travelduo/views/member/memberModify.jsp">회원정보 수정</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/travelduo/views/member/memberDelete.jsp">회원 탈퇴</a></li>
				</ul>

				<br>

				</ul>
				<h1>회원 정보</h1>

				<dl class="dl-horizontal">

					<div id="pos1">
						&nbsp;<em>*</em> <strong> 아이디</strong>&emsp;
						<%=loginUser.getUserId()%>
						<br>
					</div>
					<div id="pos2">
						&nbsp;<em>*</em> <strong> 이름</strong>&emsp;&emsp;
						<%=loginUser.getUserName()%>
						<br>
					</div>
					<div id="pos3">
						&nbsp;<em>*</em> <strong>이메일</strong>&emsp;
						<%=loginUser.getEmail()%>
						<br>
					</div>
					<div id="pos4">
						&nbsp;<em>*</em> <strong> 연락처 </strong>&emsp;
						<%=loginUser.getPhone()%>
						<br>
					</div>
					<div id="pos5">
						&nbsp;<em>*</em> <strong> 나이</strong>&emsp;&emsp;
						<%=loginUser.getAge()%>
						<br>
					</div>
					<div id="pos6">
						&nbsp;<em>*</em> <strong> 성별</strong>&emsp; &emsp;
						<%=loginUser.getGender()%>
					</div>
			</div>
			<br> <br> <br>


		</div>
	</div>
	</div>

	<br>


	<br>
	<br>

	<%@ include file="../common/footer.jsp"%>

	<!--여기선 절대경로 안돼 상대경로써야함  -->

</body>
</html>
