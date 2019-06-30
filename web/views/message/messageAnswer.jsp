<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="member.model.vo.Member, Match.vo.MatchMessage,  java.util.*" %> 
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
	String toid = request.getParameter("id"); 
	String content = request.getParameter("content");
	
	
	%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">


function button1_click(s) {
	alert( s + " 매칭 시도가 완료되었습니다.");
	window.close();
}


</script>


<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">

 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">



<title>Insert title here</title>
</head>
<body>
   <style>
   
  .textarea_size {
    resize:none;
    line-height:150%;
    width:100%;
    overflow-y:hidden;
    height:30px;
    border:1px solid #ccc;}
    
    body {

font-family: "Helvetica Nene", Helvetica, Arial, sans-serif;
font-size: 20px;
line-height: 1.42857143;
color: #333;
background-color: #fff;

}
    
</style>

<br><br>
<%= loginUser.getUserId() %> 님이  

<%= toid %> 님에게 답장


<br><br><br>

<div >

    
     <form action="/travelduo/matchWrite" method="post" name="MAnswer">
      
     <input type="hidden" name="fromUser" value="<%=loginUser.getUserId() %>">
     <input type="hidden" name="toUser" value="<%= toid  %>">
     <td> 원문 : <br> <%= content %> </td><br><br>
<textarea name="content"
placeholder="내용을 입력하세요. "  cols="100" rows="7"
></textarea><br>
	<input type="submit" value="전송" class="btn btn-primary">
 	</form>
 		
		</div>  
		
			

</body>
</html>