<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" import="member.model.vo.Member ,matchinfo.model.vo.MatchInfo, member.model.vo.Member,java.util.ArrayList" %> 
<%
   ArrayList <MatchInfo> list = (ArrayList<MatchInfo>)request.getAttribute("list");
   /* Member loginUser = (Member) session.getAttribute("loginUser"); */
   String result = (String)request.getAttribute("result");
   String user = (String)request.getAttribute("user");
%>

<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<meta name="google" value="notranslate">
<title>여행가듀오</title>

<!--scripts loaded here -->

<link rel="stylesheet" href="./resource/css/animate.min.css" />
<link rel="stylesheet" href="./resource/css/ionicons.min.css" />
<link rel="stylesheet" href="./resource/css/styles.css" />
<link rel="stylesheet" href="./resource/css/style1.css" />


<head>
<style type="text/css">
p {
 overflow: hidden; 
  text-overflow: ellipsis;
  white-space: nowrap; 
  width: 100px;
  height: 20px;
}
</style>
</head>
<body>
 
 
 

   <div id="aboutModal3" class="modal fade" tabindex="-1" role="dialog"
      aria-hidden="true">
      <div class="modal-dialog">
         <div class="modal-content">
            <div class="modal-body">
            <a href="/travelduo/index2.jsp"><button>홈 화면으로 돌아가기</button></a>
               <h2 align="center" class="text-center">내 여행정보 리스트</h2>
                  <!-- 등록한 테이블 제작 장소 -->

                     <table style="margin-left: auto; margin-right: auto;">
                     <thead class="text-center">
                     <tr class="text-center">
                     <th width="100" class="text-center">등록 번호</th>
                     <th width="100" class="text-center">여행 지역</th>
                     <th width="100" class="text-center">여행 도시</th>
                     <th width="100" class="text-center">여행 년도</th>
                     <th width="100" class="text-center">여행 월</th>
                     <th width="100" class="text-center">사진</th>
                     <th width="300" class="text-center">여행 계획</th>
                     <th height="120" class="text-center">삭제</th>
                     </tr>
                     </thead>
   <%    for(MatchInfo matchInfo : list){%>
<tbody>
<tr>
   <td align="center">   <%= matchInfo.getMatchNum() %></td>
   <td align="center">
   <% 
   switch (matchInfo.getMatchArea()){
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
   %>
   </td>
   <td align="center"><%= matchInfo.getMatchCity() %></td>
   <td align="center"><%= matchInfo.getMatchYear() %>년</td>
   <td align="center">
   <%
   switch(matchInfo.getMatchMonth()){
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
   %>
   </td>
      				<td align="center" class="page-scroll" data-toggle="modal"
								height="50">
								<%
									if (matchInfo.getMatchPhoto() != null) { //첨부파일이 있다면
								%> ◎ <%
									} else { //첨부파일이 없다면
								%> &nbsp; <%
 	}
 %>
							</td>
   <td align="center"><p><%= matchInfo.getMatchPlan() %></p></td>
   <td align="center"><button onclick="deleteMatch();">삭제하기</button></td>
   <script type="text/javascript">
   
function deleteMatch(){
   location.href = "/travelduo/mdel?no=<%= matchInfo.getMatchNum() %>&user=<%= user %>";
}

</script>
</tr>
<%  } %>
</tbody>
</table> 
</div>

</div></div>
   </div> 
   <br><br><br><br><br><br>
 
   
      <script src="./resources/js/jquery-3.3.1.min.js"></script>
      <script src="./resources/js/jquery.min.js"></script>
      <script src="./resources/js/bootstrap.min.js"></script>
      <script src="./resources/js/jquery.easing.min.js"></script>
      <script src="./resources/js/wow.js"></script>
      <script src="./resources/js/scripts.js"></script>
      <script src="https://unpkg.com/ionicons@4.5.5/dist/ionicons.js"></script> 
   
</body>
</html>