<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="member.model.vo.Member, Match.vo.MatchMessage, matchinfo.model.vo.MatchInfo,
    java.sql.Date, java.util.*" %>
 <%
 	int currentPage = 
 	((Integer)request.getAttribute("currentPage")).intValue(); 
 
 	//서블릿에서 받은 멤버 객체 써야함
 	Member member = (Member)request.getAttribute("member");
 	MatchInfo matchinfo = (MatchInfo)request.getAttribute("matchinfo");
 
 	MatchMessage Message = (MatchMessage)request.getAttribute("Message");
 
	
 	String fromUser = Message.getFromUser();
 	String content = Message.getContent();
 
 	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<title>Insert title here</title>

<script type="text/javascript">




function sendmessage(){
	var toUser = document.getElementById('message').value;
	var url ="/travelduo/views/message/messageAnswer.jsp?id=<%= fromUser %>&content=<%= content %>";
	window.open(url, "", "width=700, height=500, left=600");
	
}



</script>
</head>

 <style>
 
 
 header 
{ 
     background: url(https://az837918.vo.msecnd.net/publishedimages/articles/1733/ko-KR/images/1/free-download-this-stunning-alberta-scene-for-your-device-background-image-L-6.jpg) no-repeat center center fixed; 
    background-size: cover; 
} 
  
  </style>
  
<body>

<%@ include file="../common/header.jsp" %>


<br><br><br><br><br><br>

<center>


<tr>
			<table class="table table-striped" 
			style="text-align: center; border: 2px; solid :#dddddd;  height: 80px; width: 500px;">
		
 			
                <td>  메세지 내용입니다 : <br>
                <%= Message.getContent() %></td>
            </tr>


<div id="wrap" >
    <br><br>
    <div id="board">
        <table id="detailBoard" width="500" border="3" bordercolor="lightgray">

			<tr>
			<th>보낸사람 아이디 :  <%= fromUser %><br></th>
			
			</tr>
			
			<tr>
			<th> <br>
				나이 : <%= member.getAge() %> <br>
				연락처 : <%= member.getPhone() %> <br>
				실명 : <%= member.getUserName() %> <br>
		<br>
				
			</th>
			
			</tr>
			
			<br><br>
			
			
			<% if ( matchinfo != null) {%>
			
			
			<tr>
			<th> <br>  등록한 여행정보 <br>
			지역 : <% 
   switch (matchinfo.getMatchArea()){
   case "a" : out.print("아시아");
      break;
   case "b" : out.print("홍콩/중국");
      break;
   case "c" : out.print("일본");
      break;
   case "d" : out.print("남태평양");
      break;
   case "e" : out.print("유럽");
      break;
   case "f" : out.print("미주/캐나다");
      break;
   }
   %> <br>
			도시 : <%= matchinfo.getMatchCity() %> <br>
			월 :  <%
   switch(matchinfo.getMatchMonth()){
   case "jan" : out.print("1월");
   break;
   case "feb" : out.print("2월");
   break;
   case "mar" : out.print("3월");
   break;
   case "apr" : out.print("4월");
   break;
   case "may" : out.print("5월");
   break;
   case "jun" : out.print("6월");
   break;
   case "jul" : out.print("7월");
   break;
   case "aug" : out.print("8월");
   break;
   case "sep" : out.print("9월");
   break;
   case "oct" : out.print("10월");
   break;
   case "nov" : out.print("11월");
   break;
   case "dec" : out.print("12월");
   break;
   }
   %> <br><br>
			상세 계획 : <br> <%= matchinfo.getMatchPlan() %> <br><br>
			
		
				
				<br><br>
			</th>
			
			</tr>
			
            
 			</table>
 			<br><br>
 			
 			
 		
 			
 			
 			
 			<% }else{ %>
 			
 			<%} %>
 			<br>
 			
 				<!--  사진태그 -->
 			<% if (matchinfo.getMatchPhoto()!=null ) { %>	
 			<td colspan="2" style="min-height: 500px; text-align: left;">
<img src="/travelduo/file/matchinfo/<%= matchinfo.getMatchPhoto() %>" width="600" height="500" class="img-thumbnail">
</td>
 			
 			<br><br>
 			
 			<% } %>
 			
 			<!--  사진태그 끝-->
 			
 			<a href="/travelduo/matchList?page=<%=currentPage %>&userid=<%= loginUser.getUserId() %>"
 			class="btn btn-danger" >목록</a>
 			&nbsp;&nbsp;
 			<form onclick="sendmessage()" class="btn btn-info">답장하기
					<input type="hidden" name="address" 
					id="message" value="<%= Message.getFromUser()  %>"  />
					</form>
 			
    	</div>
		</div>    
<!--  아코디언 -->
		
            <!-- 아코디언 끝 -->
					

		
</center>
<br><br>



</body>
</html>