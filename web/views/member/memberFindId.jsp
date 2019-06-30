<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
   String result =(String)request.getAttribute("result");
   %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>아이디 찾기</title>

<link rel="stylesheet" href="/travelduo/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="/travelduo/resources/css/main.css">

<script type="text/javascript"
	src="/travelduo/resources/js/jquery-3.3.1.min.js"></script>

<style type="text/css">
#pos1 {
	position: relative;
	left: -4px;
	margin-bottom: 10px; /* 위아래공백만들어줌 */
}
/*  content를 좌측으로 이동시키기 위함   */
#divEmail {
	position: relative;
	top: -50px;
}

#posbutton {
	position: relative;
	right: -285px;
	top: -103px
}
</style>
<script type="text/javascript">
window.onload=function(){
	<% if(result != null && result.equals("fail")){ %>
	alert("이름 또는 이메일이 일치하지 않습니다.\n다시 한번 확인해 주세요.");
	<% } %>
	
}

</script>
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
						<!--숨김 콘텐츠의 경우, 정보는 전달하되 단순히 화면에서만 보이지 않도록 처리된 콘텐츠에 aria-hidden=”true”를 지정하지 말아야 한다. aria-hidden=”true”를 설정하면 의미적으로도 숨겨진 콘텐츠로 인식하기 때문이다.  -->
					</div>
					<div class="modal-body">
						<!-- 모달 몸통 -->
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
					가입할 때 입력한 이름과 이메일 주소를 입력하고, 버튼을 클릭해주세요.<br />
				</p>


				<div id="pos1">
					<form method="post" action="/travelduo/mfind">
						<td>
							<div class="form-group " id="divName">
								<label for="inputName"></label>
								<div class="col-lg-3">
									<input type="text" class="form-control onlyHangul"
										id="username" name="username" data-rule-required="true"
										placeholder="이름" maxlength="20">
								</div>
							</div>
						</td>&emsp; &nbsp;
						<td>
							<div class="form-group" id="divEmail">
								<label for="inputEmail"></label>
								<div class="col-lg-3">
									<input type="text" class="form-control" id="email" name="email"
										data-rule-required="true" placeholder="이메일 주소" maxlength="25">

								</div>
							</div> <input type="submit" id="posbutton" value=" ID 찾기 "
							class="btn btn-secondary ">
						</td>
						<!-- <button class="btn" onclick="return checkId();" >ID 찾기</button> -->
					</form>
				</div>

				<br> <br> <br> <br> <br> <br> <br>


			</div>
		</div>
	</div>

	<script>
         
            $(function(){
               
            	//var변수를 통해 모달을 전역변수로 선언해보자 . 
                var modalContents = $(".modal-contents");
                var modal = $("#defaultModal");
                 
                $('.onlyAlphabetAndNumber').keyup(function(event){
                    if (!(event.keyCode >=37 && event.keyCode<=40)) {
                        var inputVal = $(this).val();
                        $(this).val($(this).val().replace(/[^_a-z0-9]/gi,'')); //_(underscore), 영어, 숫자만 가능
                    }
                });
                 
                //한글만 입력되어지도록 함.
                $(".onlyHangul").keyup(function(event){
                    if (!(event.keyCode >=37 && event.keyCode<=40)) {
                        var inputVal = $(this).val();
                        $(this).val(inputVal.replace(/[a-z0-9]/gi,''));
                    }
                });
             	//휴대폰번호도 --등 입력되않도록 함.
                $(".onlyNumber").keyup(function(event){
                    if (!(event.keyCode >=37 && event.keyCode<=40)) {
                        var inputVal = $(this).val();
                        $(this).val(inputVal.replace(/[^0-9]/gi,''));
                    }
                });
                 //나이도 나이만 입력되어지도록 함.
                $(".onlyAge").keyup(function(event){
                    if (!(event.keyCode >=37 && event.keyCode<=40)) {
                        var inputVal = $(this).val();
                        $(this).val(inputVal.replace(/[^0-9]/gi,''));
                    }
                });
                 
        
                
                //------- 검사하여 상태를 class에 적용
                //아이디가 빈값이거나 null값이면 그에따른 이벤트를 발생시키도록 함 .
                
                $('#id').keyup(function(event){
                     
                    var divId = $('#divId');
                     
                    if($('#id').val()=="" || $('#id').val()== null){
                        divId.removeClass("has-success");
                        divId.addClass("has-error");
                    }else{
                        divId.removeClass("has-error");
                        divId.addClass("has-success");
                    }
                });
                 
                $('#username').keyup(function(event){
                     
                    var divName = $('#divName');
                     
                    if($.trim($('#name').val())==""){
                        divName.removeClass("has-success");
                        divName.addClass("has-error");
                    }else{
                        divName.removeClass("has-error");
                        divName.addClass("has-success");
                    }
                });
                $('#userpwd').keyup(function(event){
                     
                    var divPassword = $('#divPassword');
                     
                    if($('#password').val()=="" ||$('#password').val()== null){
                        divPassword.removeClass("has-success");
                        divPassword.addClass("has-error");
                    }else{
                        divPassword.removeClass("has-error");
                        divPassword.addClass("has-success");
                    }
                });
                 
                $('#userpwdchk').keyup(function(event){
                     
                    var passwordCheck = $('#passwordCheck').val();
                    var password = $('#password').val();
                    var divPasswordCheck = $('#divPasswordCheck');
                     
                    if((passwordCheck=="") || (password!=passwordCheck)){
                        divPasswordCheck.removeClass("has-success");
                        divPasswordCheck.addClass("has-error");
                    }else{
                        divPasswordCheck.removeClass("has-error");
                        divPasswordCheck.addClass("has-success");
                    }
                });
                 
                 
                 
                $('#email').keyup(function(event){
                     
                    var divEmail = $('#divEmail');
                     
                    if($.trim($('#email').val())==""){
                        divEmail.removeClass("has-success");
                        divEmail.addClass("has-error");
                    }else{
                        divEmail.removeClass("has-error");
                        divEmail.addClass("has-success");
                    }
                });
                 
                $('#phone').keyup(function(event){
                     
                    var divPhoneNumber = $('#divPhoneNumber');
                     
                    if($.trim($('#phone').val())==""){
                        divPhoneNumber.removeClass("has-success");
                        divPhoneNumber.addClass("has-error");
                    }else{
                        divPhoneNumber.removeClass("has-error");
                        divPhoneNumber.addClass("has-success");
                    }
                });
                
                $('#age').keyup(function(event){
                    
                    var divAge = $('#divAge');
                     
                    if($.trim($('#age').val())==""){
                        divAge.removeClass("has-success");
                        divAge.addClass("has-error");
                    }else{
                        divAge.removeClass("has-error");
                        divAge.addClass("has-success");
                    }
                });
               
    		   $('#gender').keyup(function(event){
                    
                    var divGender = $('#divGender');
                     
                    if($.trim($('#gender').val())==""){
                        divGender.removeClass("has-success");
                        divGender.addClass("has-error");
                    }else{
                        divGender.removeClass("has-error");
                        divGender.addClass("has-success");
                    }
                });
                 
                
                 
                //------- validation 검사
                $( "form" ).submit(function( event ) {
                     
                    var provision = $('#provision');
                    var memberInfo = $('#memberInfo');
                    var divId = $('#divId');
                    var divPassword = $('#divPassword');
                    var divPasswordCheck = $('#divPasswordCheck');
                    var divName = $('#divName');
                    var divEmail = $('#divEmail');
                    var divPhoneNumber = $('#divPhoneNumber');
                    var divAge = $('#divAge');
                    var divGender = $('#divGender');
               
                     
                    //아이디 검사
                    if($('#userid').val()==""){
                        modalContents.text("아이디를 입력하여 주시기 바랍니다.");
                        modal.modal('show');
                         
                        divId.removeClass("has-success");
                        divId.addClass("has-error");
                        $('#id').focus();
                        return false;
                    }else{
                        divId.removeClass("has-error");
                        divId.addClass("has-success");
                    }
                     
                    //이름
                    if($('#username').val()==""){
                        modalContents.text("이름을 입력하여 주시기 바랍니다.");
                        modal.modal('show');
                         
                        divName.removeClass("has-success");
                        divName.addClass("has-error");
                        $('#name').focus();
                        return false;
                    }else{
                        divName.removeClass("has-error");
                        divName.addClass("has-success");
                    }
                    
           
                    //이메일
                    if($('#email').val()==""){
                        modalContents.text("이메일을 입력하여 주시기 바랍니다.");
                        modal.modal('show');
                         
                        divEmail.removeClass("has-success");
                        divEmail.addClass("has-error");
                        $('#email').focus();
                        return false;
                    }else{
                        divEmail.removeClass("has-error");
                        divEmail.addClass("has-success");
                    }

                });
                 
            });
             
        </script>



	<!-- 		<hr style= "clear:left"> -->
	<%@ include file="../common/footer.jsp"%>
	<!--여기선 절대경로 안돼 상대경로써야함  -->

</body>
</html>
