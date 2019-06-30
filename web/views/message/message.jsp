<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="member.model.vo.Member, java.util.*" %> 
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
	String toid = request.getParameter("id"); 
	
	
	%>
			
<!DOCTYPE html>
<html>


<head>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">

 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    
    <title>Bootstrap</title>
 
</head>
<script type="text/javascript">


function selectValue(){
	   
    var requestValue = document.getElementById("Name").value;                   // 전송 파라미터 값
    var theURL = "/servlet/servlet.ExampleCloseUrl?requestValue="+requestValue; // 전송 URL
    // 호출 한 부모 페이지에서 URL 호출
    opener.window.location = url;
    // 호출 한 뒤 현재 팝업 창 닫기 이벤트
    close();
} 



function button1_click(s) {
	alert( s + " 매칭 시도가 완료되었습니다.");
	window.close();
}


</script>

  <style>
    table, th, td {
    border: 1px solid #bcbcbc;
  }
  table {
    width: 70%;
    height: 300px;
  }
  textarea {height: 250px;}
  
   body {

font-family: "Helvetica Nene", Helvetica, Arial, sans-serif;
font-size: 20px;
line-height: 1.42857143;
color: #333;
background-color: #fff;

}
  
  
</style>

<body >
     

 

<br>

<center>

매칭시에는 정확한 일정 비용 기간 등을 기재해주세요.
</center>




<br><br>

 <table align="center" width="600">
    <thead>
    </thead>
    <tbody>
        <form action="/travelduo/matchWrite" method="post">
        	<tr><td><%= toid %> 님에게 매칭 시도하기 </td></tr>
        	<input type="hidden" name="fromUser" value="<%= loginUser.getUserId() %>">
        	
                <td><textarea cols="10" placeholder="내용을 입력하세요." name="content" class="form-control" height="300" required></textarea></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="전송" id="Name"
                    class="btn btn-primary" >
                </td>
            </tr>
           <input type="hidden" name="toUser" value="<%= toid %>"  />
        </form>
    </tbody>
</table>




<br><br><br>


 
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
</body>
</html>