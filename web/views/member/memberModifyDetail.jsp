<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>회원정보 수정</title>
       	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="/travelduo/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="/travelduo/resources/css/main.css">

<script type="text/javascript" src="/travelduo/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
function passwordCheckFunction(){
	  var userpwd = $('#userpwd').val();
	  var userpwdchk = $('#userpwdchk').val();
	  if(userpwd != userpwdchk){
		  $('#passwordCheckMessage').html('비밀번호가 서로 일치하지 않습니다.');
	  
	  }else{
		  $('#passwordCheckMessage').html('');
	  }
	  
}


</script>

<style type="text/css">
#posx {
	position: relative;
	top: -10px;
}
#pos1 {
	position: relative;
	left: 25px;
}
#posbox {
	position: relative;
	right: -150px;
	top: -35px;
} /* 박스옮기기 */

#posgender {
	position: relative;
	right: -165px;
	top: -28px;
}
</style>

   
    </head>
    
   <body>
   <div class="signup-img"><img src="/travelduo/resources/images/wan/회원가입에서 풍경사진1.jpg" width= "1519" height= "250"> </div>
<!-- <hr style= "clear:left"> -->
<br><br>
<%@ include file="../common/header.jsp" %>
     <!-- 좌우측의 공간 확보 -->
   				
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
		
          <!-- 모달창 -->
          <div class="modal fade" id="defaultModal">
               <div class="modal-dialog">     <!--크기를 보다 작게, 화면에 맞도록 조정해주고 ,//모달창이 위에서 아래로 내려오게 뜨도록 함 클릭하면 다시위로 올라가는 듯하면서 사라짐.// 설정을 하지않으면 ,내려오지않고 맨위에 크게박혀있다. -->
                   <div class="modal-content"> <!-- 모달창의 화면을 나타냄 . 이게 없으면 모달창이 투명하게 보인다.  -->
                       <div class="modal-header">  <!-- 모달창 위의 헤더에 뜨는 부분  -->
                           <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>  <!--  data-dismiss="modal 은 x를 누르면 꺼지도록 함.--> 
                            																	<!-- close 를 하면 맨우측으로 가면서  x가 모양이 바뀜-->
                            																	<!--숨김 콘텐츠의 경우, 정보는 전달하되 단순히 화면에서만 보이지 않도록 처리된 콘텐츠에 aria-hidden=”true”를 지정하지 말아야 한다. aria-hidden=”true”를 설정하면 의미적으로도 숨겨진 콘텐츠로 인식하기 때문이다.  -->

                       </div>
                       <div class="modal-body">	<!-- 모달 몸통 -->
                           <p class="modal-contents"></p> <!--모달 몸통에서의 내용이다 나중에 전역변수를 통해 , 상황에 맞는 말들을 넣어줄 것이다.  -->
                       </div>
                       <div class="modal-footer">	<!-- modal footer -->
                           <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>  <!-- 마지막에는 x와 동일한 기능을 하는 닫기버튼을 만들어준다. -->
                       </div>
                   </div><!-- /.modal-content -->
               </div><!-- /.modal-dialog -->
           </div><!-- /.modal -->
        <!-- 모달창 -->
   

                 
        <form class="form-horizontal" role="form" method="post"  action="/travelduo/mmodifydetail">
     <br>
    <div id="posx"><h3 ><strong> &nbsp;회원정보 수정</strong></h3></div>
        <div id="pos1"> <!-- content를 좌측으로 이동시키기 위함  -->
         <br>
            <div class="form-group " id="divId">
                <label for="inputId" class="col-lg-2 control-label "><em style="color:Red"> * </em><strong>아이디</strong></label>
                <div class="col-lg-4" id="posbox">
                    <input type="text" class="form-control" id="userid" name="userid" readonly value="<%= loginUser.getUserId()%>" maxlength="20">
                </div>																		<!-- placeholder="아이디는 수정할 수 없습니다." -->
                
            </div>
            <div class="form-group" id="divName">
                <label for="inputName" class="col-lg-2 control-label"><em style="color:Red"> * </em><strong>이름</strong> </label>
                <div class="col-lg-4" id="posbox">
                    <input type="text" class="form-control onlyHangul" id="username" name="username"  data-rule-required="true" value="<%= loginUser.getUserName() %>" maxlength="5">
                </div>
                
            </div>
            <div class="form-group" id="divPassword">
                <label for="inputPassword" class="col-lg-2 control-label"><em style="color:Red"> * </em><strong>비밀번호</strong></label>
                <div class="col-lg-4" id="posbox"> 
                    <input type="password" class="form-control" id="userpwd" name="userpwd" onkeyup="passwordCheckFunction();" data-rule-required="true" value="<%= loginUser.getUserPwd() %>" maxlength="25">
            																				<!-- name="excludeHangul" -->
                </div>
            </div>
            <div class="form-group" id="divPasswordCheck">
                <label for="inputPasswordCheck" class="col-lg-2 control-label"><em style="color:Red"> * </em><strong>비밀번호 확인</strong></label>
                <div class="col-lg-4" id="posbox">
                    <input type="password" class="form-control" id="userpwdchk" name="userpwdchk" onkeyup="passwordCheckFunction();" data-rule-required="true" value="<%= loginUser.getUserPwd() %>" maxlength="25">
                  <h5 style="color: red;" id="passwordCheckMessage"></h5>
                </div>
                
            </div>
             
            <div class="form-group" id="divEmail">
                <label for="inputEmail" class="col-lg-2 control-label"><em style="color:Red"> * </em><strong>이메일 주소</strong></label>
                <div class="col-lg-4" id="posbox">
                    <input type="email" class="form-control" id="email" name="email" data-rule-required="true" value="<%= loginUser.getEmail()%>" maxlength="40">
                </div>
            </div>
            <div class="form-group" id="divPhoneNumber">
                <label for="inputPhoneNumber" class="col-lg-2 control-label"><em style="color:Red"> * </em><strong>휴대폰 번호</strong></label>
                <div class="col-lg-4" id="posbox">
                    <input type="tel" class="form-control onlyNumber" id="phone" name="phone" data-rule-required="true"  value="<%= loginUser.getPhone()%>" maxlength="11">
                </div>
            </div>
            <div class="form-group" id="divAge">
            	<label for="inputAge" class="col-lg-2 control-label"><em style="color:Red"> * </em><strong>나이</strong></label>
            	<div class="col-lg-4" id="posbox">
            		<input type="text" class="form-control onlyAge" id="age" name="age"   data-rule-required="true" value="<%= loginUser.getAge()%>" maxlength="2">

            	</div>
            </div>
            
            <div class="form-group" id="divGender" >
                <label for="inputGender" class="col-lg-2 control-label"><em style="color:Red"> * </em><strong>성별</strong> </label>
                <div class="col-lg-4" id="posbox">
                    <input type="text" class="form-control" id="userid" name="userid"  readonly value="<%= loginUser.getGender()%>" maxlength="20">
                </div>
<!--     <br><br><br>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;  <strong>수정되지 않는 것들에 대해 수정이 필요하다면, 고객센터로 문의하시길 바랍니다.</strong> -->
				</div>				
                
            	</div>			      
             
            <br><br>
            		<div style="border-top:1px solid #ccc;padding-top:10px"></div>
			<a href="/travelduo/index.jsp" ><button type="button" class="btn btn-danger">취소	</button></a>
	  	   <input type="submit" value="수정하기" class="btn btn btn-primary disabled float-right">
       	
            
             
        </form>

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
                     
                    //패스워드 
                    if($('#userpwd').val()==""){
                        modalContents.text("패스워드를 입력하여 주시기 바랍니다.");
                        modal.modal('show');
                         
                        divPassword.removeClass("has-success");
                        divPassword.addClass("has-error");
                        $('#password').focus();
                        return false;
                    }else{
                        divPassword.removeClass("has-error");
                        divPassword.addClass("has-success");
                    }
                     
                    //패스워드 확인
                    if($('#userpwdchk').val()==""){
                        modalContents.text("패스워드 확인을 입력하여 주시기 바랍니다.");
                        modal.modal('show');
                         
                        divPasswordCheck.removeClass("has-success");
                        divPasswordCheck.addClass("has-error");
                        $('#passwordCheck').focus();
                        return false;
                    }else{
                        divPasswordCheck.removeClass("has-error");
                        divPasswordCheck.addClass("has-success");
                    }
                     
                    //패스워드와 배스워드 확인을 서로 비교함
                    if($('#userpwd').val() != $('#userpwdchk').val() || $('#userpwdchk').val()==""){
                        modalContents.text("패스워드가 일치하지 않습니다.");
                        modal.modal('show');
                         
                        divPasswordCheck.removeClass("has-success");
                        divPasswordCheck.addClass("has-error");
                        $('#passwordCheck').focus();
                        return false;
                    }else{
                        divPasswordCheck.removeClass("has-error");
                        divPasswordCheck.addClass("has-success");
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
                     
                    //휴대폰 번호
                    if($('#phone').val()=="" ){
                        modalContents.text("휴대폰 번호를 입력하여 주시기 바랍니다.");
                        modal.modal('show');
                         
                        divPhoneNumber.removeClass("has-success");
                        divPhoneNumber.addClass("has-error");
                        $('#phone').focus();
                        return false;
                   
                    }if( $('#phone').val().length != "11"){
                    	modalContents.text("휴대폰 번호를 끝까지 입력하여 주시기 바랍니다.");
                        modal.modal('show');
                         
                        divPhoneNumber.removeClass("has-success");
                        divPhoneNumber.addClass("has-error");
                        $('#phone').focus();
                        return false;
                    }else{
                        divPhoneNumber.removeClass("has-error");
                        divPhoneNumber.addClass("has-success");
                    }
                    
                     //나이
                    if($('#age').val()=="" ) {
                        modalContents.text("나이를 입력하여 주시기 바랍니다.");
                        modal.modal('show');
                         
                        divAge.removeClass("has-success");
                        divAge.addClass("has-error");
                        $('#age').focus();
                        return false;
                    }if($('#age').val() <="19"  ){
                    	modalContents.text("나이는 20살 이상이어야 합니다.");
                    	modal.modal('show');
                         
                         divAge.removeClass("has-success");
                         divAge.addClass("has-error");
                         $('#age').focus();
                         return false;
                    }else{
                        divAge.removeClass("has-error");
                        divAge.addClass("has-success");
                    }
                   
                   
                 
                });
                 
            });
             
        </script>

          <br><br>

        </div>
<%@ include file="../common/footer.jsp" %>
<!--여기선 절대경로 안돼 상대경로써야함  -->
    </body>
</html>