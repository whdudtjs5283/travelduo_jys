<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="member.model.vo.Member, Match.vo.MatchMessage,  java.util.*" %> 
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
	String toid = request.getParameter("id"); 
	
	
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
<meta charset="UTF-8">
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
    
</style>

<br><br>
<%= loginUser.getUserId() %> 님이
<br>

<%= toid %> 님에게 답장


<br><br><br>

<div >

    
     <form action="/travelduo/matchWrite" method="post" name="MAnswer">
      
     <input type="hidden" name="fromUser" value="<%=loginUser.getUserId() %>">
     <input type="hidden" name="toUser" value="<%= toid  %>">
<textarea name="content"
placeholder="내용을 입력하세요. "  cols="100" rows="7"
></textarea>
	<input type="submit" value="전송" >
 	</form>
 		
		</div>  
		
			<td colspan="2">
                  
                    <button onclick="button1_click();">창 닫기</button>
                
                </td>

</body>
</html>