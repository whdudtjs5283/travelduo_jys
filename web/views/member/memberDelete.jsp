<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"%>

              <% 
   String result =(String)request.getAttribute("result");
   %>  
  
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="/travelduo/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="/travelduo/resources/css/main.css">

<script type="text/javascript" src="/travelduo/resources/js/jquery-3.3.1.min.js"></script>
	<title>회원 탈퇴</title>

<script type="text/javascript">

window.onload=function(){
	<% if(result !=null && result.equals("success")){ %>
	alert("탈퇴가 정상적으로 진행되었습니다.\n이용해주셔서 감사합니다.");

	<% }else if(result != null && result.equals("fail")){ %>
	alert("탈퇴가 정상적으로 이루어지지 않았습니다.\n비밀번호를 확인해주세요.");
	<% } %>
	
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
<style>
.deleteon{
padding: 4px 6px;  /* 중간으로약간밀어줌 */
    margin-bottom: 10px;  /* 위아래공백만들어줌 */
    border: 1px solid #cccccc;
background-color: #eeeeee;
    height: 26px!important;   /* 칸크기 조금넓혀줌 */

    border: 1px solid #cccccc;
    -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
    -moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
    box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
    -webkit-transition: border linear 0.2s, box-shadow linear 0.2s;
    -moz-transition: border linear 0.2s, box-shadow linear 0.2s;
    -o-transition: border linear 0.2s, box-shadow linear 0.2s;
    transition: border linear 0.2s, box-shadow linear 0.2s

}

</style>


<body>
<div class="signup-img"><img src="/travelduo/resources/images/wan/회원가입에서 풍경사진2.jpg" width= "1519" height= "250"> </div>
<!-- <hr style= "clear:left"> -->
<br><br>
<%@ include file="../common/header.jsp" %>


<div class="container">
				<div class="row">
			<div class="col-md-12 content-body">
				<ul class="nav nav-tabs">
					<li class="nav-item "><a class="nav-link"
						href="/travelduo/views/member/memberMyPage.jsp">회원정보 보기</a></li>
					<li class="nav-item"><a class="nav-link "
						href="/travelduo/views/member/memberModify.jsp">회원정보 수정</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="/travelduo/views/member/memberDelete.jsp">회원 탈퇴</a></li>
				</ul>

				<br>
		
		<h1>회원 탈퇴</h1>
<p>&nbsp;비밀번호 입력 시 &nbsp;바로 탈퇴가 진행되오니 , 유의하시기 바랍니다.</p>
	
<form action="/travelduo/mdelete" method="post" >
		<div id="pos1">
						<td>
							<div class="form-group " id="divId">
								<label for="inputId"></label>
								<div class="col-lg-3">
									<input type="text" class="form-control "
										id="userid" name="userid" data-rule-required="true" value="<%= loginUser.getUserId()%>" readonly maxlength="20">

								</div>
							</div>
						</td>&emsp; &nbsp;
						<td>
							<div class="form-group" id="divPwd">
								<label for="inputPwd"></label>
								<div class="col-lg-3">
									<input type="password" class="form-control" id="userpwd" name="userpwd"
										data-rule-required="true" placeholder="비밀번호" maxlength="25">

								</div>
							</div> <input type="submit" id="posbutton" value=" 탈퇴하기 "
							class="btn btn-secondary ">
						</td>
						<!-- <button class="btn" onclick="return checkId();" >ID 찾기</button> -->
					</form>
				</div>
				
				
				
</form>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

		</div>
	</div>
</div>

		
<!-- 		<hr style= "clear:left"> -->
<%@ include file="../common/footer.jsp" %>
<!--여기선 절대경로 안돼 상대경로써야함  -->
		
	</body>
</html>
