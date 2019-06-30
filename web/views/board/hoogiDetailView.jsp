<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="member.model.vo.Member, board_hoogi.model.vo.Product_Hoogi, 
    java.sql.Date, comment.model.vo.HComment, java.util.*" %>
<%
	Product_Hoogi Phoogi = (Product_Hoogi)request.getAttribute("Phoogi");
	//원글 번호가 필요해서 보냄
	//ArrayList<Product_Hoogi> list = (ArrayList<Product_Hoogi>)request.getAttribute("list");
	ArrayList<HComment> clist = (ArrayList<HComment>)request.getAttribute("clist");
	
	//위에서 이미 본문글번호와 같은 댓글만 추려서 온것임. 그래서 출력만하면됨.
	
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	//원글번호
	
	//bnum 변수 있어야함
	int bNum = Phoogi.getBoardnum();
	int originalNum = Phoogi.getBoardnum();
	
	//파일명
	String imageName = Phoogi.getBoardRenameFileName();
	
	//Member loginUser = (Member)session.getAttribute("loginUser");
%> 


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<title> 글 상세보기 </title>

<script type="text/javascript">




function sendmessage(){
	var toUser = document.getElementById('message').value;
	var url ="/travelduo/views/message/message.jsp?id="+toUser;
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

<br>
<br><br>
<br><br>
<br>
	<div class="container">
		<div class="row">
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="3" style="background-color:#eeeeee; text-align: center;">게시판 글 보기 양식</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 20%; ">글 제목</td>
						<td colspan="2"><%= Phoogi.getBtitle() %></td>
					</tr>
					
					
					
					<!-- 작성자 프로필 -->
					<!-- 로긴 유저가 아니라 해당 작성자의 정보가 보여져야함 -->
					
					<% if (loginUser != null) { %>
					
					<tr>
						<td style="width: 20%; "> <br><br>작성자 정보</td>
						
						
						<td colspan="2">
						<br> 나이 : <%= loginUser.getAge() %>
						<br> 성별 : <%= loginUser.getGender() %>
						<br> 연락처 : <%= loginUser.getPhone() %>
						<br> 이메일 : <%= loginUser.getEmail() %>
						
						
						</td>
						
						
					</tr>
					
					<% } %>
					
					
					
					<!-- 작성자 프로필 -->
					
					
				
					<tr>
						<td>작성일자</td>
						<td colspan="2"><%= Phoogi.getBoarddate() %></td>
					</tr>
					
					<tr>
						<td>내용</td>
						<td colspan="2" style="min-height: 200px; text-align: left;"><%= Phoogi.getBcontent().replaceAll(" ","&nbsp;")
						.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>") %></td>
					</tr>
					
					<% if ( imageName !=null) { %>
						<tr>
						<td>후기사진</td>
						<td colspan="2" style="min-height: 200px; text-align: left;">
						<img src="/travelduo/files/hoogi/<%=imageName%>" width="600" height="500" class="img-thumbnail">
						</td>
						</tr>
						<% } %>
				</tbody>
			</table>
					<a href="/travelduo/blist" class="btn btn-outline-secondary">목록</a>
					
					&nbsp;&nbsp;&nbsp;
					
					
					<!-- 매칭 신청 버튼이 이 위치에서만 값을 제대로 전달한다. -->
					
					<br>
					
			<% String loginID = loginUser.getUserId(); %>
			<% if(!Phoogi.getUserid().equals(loginID)) {%>
					
					<form class="btn btn-danger" onclick="sendmessage()">매칭신청
					<input type="hidden" name="address" 
					id="message" value="<%=Phoogi.getUserid()%>"  />
					</form>
					
					<% } %>
					
					<!-- 매칭 신청 버튼이. 여기서만 값을 제대로 전달한다. -->
					
					
					
			&nbsp; &nbsp;
			
		
	<% if(   loginUser.getUserId().equals(Phoogi.getUserid()) ){ %>
		<a href="/travelduo/bupview?bnum=<%= Phoogi.getBoardnum() %>&page=<%= currentPage %>" class="btn btn-outline-secondary">수정</a> 
		&nbsp; &nbsp;
	<a href="/travelduo/views/board/hoogiDelete.jsp?bnum=<%= Phoogi.getBoardnum() %>&page=<%= currentPage %>" 
	class="btn btn-outline-secondary">글삭제</a>
	
	
	<% }else{ %>
	&nbsp; &nbsp;
	&nbsp; &nbsp;
					
		
	<% } %>
		</div>
	</div>
			
			<!-- 게시글 상세보기 끝 -->
			
			
			
			
			
			<!--  댓글 시작 -->
			<br>
			<br>
			
			<% 
	if ( clist !=null ){
		for(int i=0; i<clist.size(); i++) {
%>


<div class="container">
		<div class="row">
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<thead>
				</thead>
				<tbody>
					<tr>
						<td width="60" height="50" valign="top" align="left" style="padding:50 0 0 50;"> <%= clist.get(i).getUserid() %> 님의 코멘트&nbsp;
						 <a href="/travelduo/replydel?cnum=<%= clist.get(i).getCOMMENT_NUM() %>&bnum=<%= Phoogi.getBoardnum() %>&page=<%=currentPage %>"
					class="btn btn-secondary btn-sm">삭제
		</a></td>
					</tr>
			
					<tr>
						<td align="left"><%= clist.get(i).getHCOMMENT_CONTENT() %></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

<% }} %>
			
			<!-- 테스트용 댓글 끝 -->
			
			
			<br>
		</form>
	</div>
	
	
	
	<!-- 코멘트 입력 부분 시작 -->
	
	<div class="container" >
  <form action="/travelduo/hcwrite" method="post" name="hoogicomment">
    <div class="form-group">
      <label><%=loginUser.getUserId()%> 님의 코멘트</label>
      <input type="hidden" name="userid" value="<%=loginUser.getUserId()%>">
       <input type="hidden" name="page" value="<%=currentPage%>">
        <input type="hidden" name="hoogiNo" value="<%= originalNum %>">
      <textarea class="form-control" rows="5" id="comment" name="content"></textarea>
      <br>
      <input type="submit" class="btn btn-secondary btn-sm" value="전송">
    </div>
  </form>
</div>
	<!-- 코멘트 입력 부분 끝 -->
	
	
	<!--  이상하게 밑에 js 적용 없애도 잘나온다. -->
	
	<script src="/resources/js/jquery-3.3.1.min.js"></script>
	<script src="/resources/js/bootstrap.js"></script>
	<br>
	<br>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
</body>
</html>