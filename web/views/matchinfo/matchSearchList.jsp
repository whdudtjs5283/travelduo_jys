<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="member.model.vo.Member ,matchinfo.model.vo.MatchInfo, member.model.vo.Member,java.util.ArrayList"%>
<%
	ArrayList<MatchInfo> list = (ArrayList<MatchInfo>) request.getAttribute("list");
	String result = (String) request.getAttribute("result");
	String user = (String) request.getAttribute("user");
%>

<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<meta name="google" value="notranslate">
<title>여행가듀오</title>

<!--scripts loaded here -->

<link rel="stylesheet" href="./resource/css/bootstrap.min.css" />
<link rel="stylesheet" href="./resource/css/animate.min.css" />
<link rel="stylesheet" href="./resource/css/ionicons.min.css" />
<link rel="stylesheet" href="./resource/css/styles.css" />
<link rel="stylesheet" href="./resource/css/style2.css" />
<style type="text/css">
p {
	text-overflow: ellipsis;
	overflow: hidden;
	width: 400px;
	height: 80px;
	text-overflow: ellipsis;
	display: inline-block;
}
</style>
<head>
<body>
	<div id="" tabindex="-1" role="dialog">
		<div>
			<div >
				<div class="modal-body">
					<a href="/travelduo/index2.jsp"><button>홈 화면으로 돌아가기</button></a>
					<h4 class="text-center">검색결과</h4>

					<br> <br>

					<table style="margin-left: auto; margin-right: auto;">
						 <thead class="text-center">
						<tr class="text-center">
							<th width="200" height="50" class="text-center">아이디</th>
							<th width="200" height="50" class="text-center">여행 지역</th>
							<th width="200" height="50" class="text-center">여행 도시</th>
							<th width="200" height="50" class="text-center">여행 년</th>
							<th width="200" height="50" class="text-center">여행 월</th>
							<th width="100" height="50" class="text-center">사진</th>
							<th width="400" height="50" class="text-center">여행 계획</th>
						</tr>
						</thead>
						<%
							for (MatchInfo m : list) {
						%>
						<tbody>
						<tr>
							<td align="center"><%=m.getUserId()%></td>
							<td align="center">
								<%
									switch (m.getMatchArea()) {
										case "a":
											out.print("아시아");
											break;
										case "b":
											out.print("홍콩/중국");
											break;
										case "c":
											out.print("일본");
											break;
										case "d":
											out.print("남태평양");
											break;
										case "e":
											out.print("유럽");
											break;
										case "f":
											out.print("미주/캐나다");
											break;
										}
								%>
							
							<td align="center"><%=m.getMatchCity()%></td>
							<td align="center"><%=m.getMatchYear()%>년</td>
							<td align="center">
								<%
									switch (m.getMatchMonth()) {
										case "jan":
											out.print("1월");
											break;
										case "feb":
											out.print("2월");
											break;
										case "mar":
											out.print("3월");
											break;
										case "apr":
											out.print("4월");
											break;
										case "may":
											out.print("5월");
											break;
										case "jun":
											out.print("6월");
											break;
										case "jul":
											out.print("7월");
											break;
										case "aug":
											out.print("8월");
											break;
										case "sep":
											out.print("9월");
											break;
										case "oct":
											out.print("10월");
											break;
										case "nov":
											out.print("11월");
											break;
										case "dec":
											out.print("12월");
											break;
										}
								%>
							</td>
							<td align="center">
								<%
									if (m.getMatchPhoto() != null) { //첨부파일이 있다면
								%> ◎ <%
									} else { //첨부파일이 없다면
								%> &nbsp; <%
 	}
 %>
							</td>
							<td><p><%=m.getMatchPlan()%></p></td>
							
						</tr>
						<%
							}
						%>						 
						 </tbody>
					</table>
				</div>
			</div>
		</div>
	</div>	
	<br><br><br><br><br><br>

	<script src="./resource/js/jquery-3.3.1.min.js"></script>
	<script src="./resource/js/jquery.min.js"></script>
	<script src="./resource/js/bootstrap.min.js"></script>
	<script src="./resource/js/jquery.easing.min.js"></script>
	<script src="./resource/js/wow.js"></script>
	<script src="./resource/js/scripts.js"></script>
	<script src="https://unpkg.com/ionicons@4.5.5/dist/ionicons.js"></script>

</body>
</html>