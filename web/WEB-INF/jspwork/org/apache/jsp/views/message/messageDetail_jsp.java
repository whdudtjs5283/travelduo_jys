/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.39
 * Generated at: 2019-04-05 08:54:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.message;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import member.model.vo.Member;
import Match.vo.MatchMessage;
import matchinfo.model.vo.MatchInfo;
import java.sql.Date;
import java.util.*;
import member.model.vo.Member;

public final class messageDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/views/message/../common/header.jsp", Long.valueOf(1554453177897L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("matchinfo.model.vo.MatchInfo");
    _jspx_imports_classes.add("member.model.vo.Member");
    _jspx_imports_classes.add("Match.vo.MatchMessage");
    _jspx_imports_classes.add("java.sql.Date");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("     \r\n");
      out.write(" ");

 	int currentPage = 
 	((Integer)request.getAttribute("currentPage")).intValue(); 
 
 	//서블릿에서 받은 멤버 객체 써야함
 	Member member = (Member)request.getAttribute("member");
 	MatchInfo matchinfo = (MatchInfo)request.getAttribute("matchinfo");
 
 	MatchMessage Message = (MatchMessage)request.getAttribute("Message");
 
	
 	String fromUser = Message.getFromUser();
 	String content = Message.getContent();
 
 	
    
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/bootstrap.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/custom.css\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function sendmessage(){\r\n");
      out.write("\tvar toUser = document.getElementById('message').value;\r\n");
      out.write("\tvar url =\"/travelduo/views/message/messageAnswer.jsp?id=");
      out.print( fromUser );
      out.write("&content=");
      out.print( content );
      out.write("\";\r\n");
      out.write("\twindow.open(url, \"\", \"width=700, height=500, left=600\");\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write(" <style>\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" header \r\n");
      out.write("{ \r\n");
      out.write("     background: url(https://az837918.vo.msecnd.net/publishedimages/articles/1733/ko-KR/images/1/free-download-this-stunning-alberta-scene-for-your-device-background-image-L-6.jpg) no-repeat center center fixed; \r\n");
      out.write("    background-size: cover; \r\n");
      out.write("} \r\n");
      out.write("  \r\n");
      out.write("  </style>\r\n");
      out.write("  \r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("\r\n");

	Member loginUser = (Member)session.getAttribute("loginUser");

      out.write("\r\n");
      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>travelduo</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/travelduo/resources/css/bootstrap.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/travelduo/resources/css/main.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"/travelduo/resources/js/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/travelduo/resources/js/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("function openNav() {\r\n");
      out.write("\t  document.getElementById(\"mySidenav\").style.width = \"257px\";\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction closeNav() {\r\n");
      out.write("\t  document.getElementById(\"mySidenav\").style.width = \"0\";\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".sidenav {\r\n");
      out.write("  height: 100%;\r\n");
      out.write("  width: 0;\r\n");
      out.write("  position: fixed;\r\n");
      out.write("  z-index: 1;\r\n");
      out.write("  top: 0;\r\n");
      out.write("  right: 0;\r\n");
      out.write("  background-color: #111;\r\n");
      out.write("  overflow-x: hidden;\r\n");
      out.write("  transition: 0.5s;\r\n");
      out.write("  padding-top: 60px;\r\n");
      out.write("  float: left;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(" /* 회원가입 , ID/PW 찾기 */\r\n");
      out.write(".sidenav a {\r\n");
      out.write("  padding: 8px 8px 8px 9px;\r\n");
      out.write("  text-decoration: none;\r\n");
      out.write("  font-size: 25px;\r\n");
      out.write("  color: #818181;\r\n");
      out.write("  display: block;\r\n");
      out.write("  transition: 0.3s;\r\n");
      out.write("  float: left;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".sidenav a:hover {\r\n");
      out.write("  color: #f1f1f1;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".sidenav .closebtn {\r\n");
      out.write("  position: absolute;\r\n");
      out.write("  top: 0;\r\n");
      out.write("  right: 23px;\r\n");
      out.write("  font-size: 36px;\r\n");
      out.write("  margin-left: 50px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("@media screen and (max-height: 6000px) {\r\n");
      out.write("  .sidenav {padding-top: 15xp;}\r\n");
      out.write("  .sidenav a {font-size: 18px;}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* 여행가듀오 로고아래 로그인에 대한 글씨 */\r\n");
      out.write(" .logincolor818181 { \r\n");
      out.write(" color: #818181;\r\n");
      out.write(" } \r\n");
      out.write(" \r\n");
      out.write("/*로그인 글자 앞에 생기는 줄에대한 것  */\r\n");
      out.write(".logincolor818181:after {display: inline-block; margin: 0 0 6px 5px; height: 1px; content: \" \"; text-shadow: none; background-color: #999; width:\r\n");
      out.write("44%; }\r\n");
      out.write("\r\n");
      out.write("/*로그인버튼  앞에 생기는 줄에 대한 것  */\r\n");
      out.write(".line:before {display: inline-block; margin: 0 5px 6px 23px; height: 1px; content: \" \"; text-shadow: none; background-color: #999; width:\r\n");
      out.write("38%; }\r\n");
      out.write("\r\n");
      out.write("/*로그인 후 햄버거 클릭 시 나오는 앞선에 대한 것  */\r\n");
      out.write(".line2:before {display: inline-block; margin: 0 5px 6px 23px; height: 1px; content: \" \"; text-shadow: none; background-color: #999; width:83%;}\r\n");
      out.write("\r\n");
      out.write("/*로그인 후 햄버거 클릭 시 나오는 뒷선에 대한 것  */\r\n");
      out.write(".line3:before {display: inline-block; margin: 0 5px 6px 23px; height: 1px; content: \" \"; text-shadow: none; background-color: #999; width:\r\n");
      out.write("83%;}\r\n");
      out.write("\r\n");
      out.write("/* \r\n");
      out.write("\t\t\tCSS\r\n");
      out.write("\t\t\t============================================= -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/travelduo/resources/css/linearicons.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/travelduo/resources/css/bootstrap.css\">\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"/travelduo/resources/css/magnific-popup.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/travelduo/resources/css/jquery-ui.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/travelduo/resources/css/nice-select.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/travelduo/resources/css/animate.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/travelduo/resources/css/owl.carousel.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/travelduo/resources/css/main.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/travelduo/resources/css/bootstrap.min.css\">\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write(" */\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body id=\"main\">\r\n");
      out.write("\t<header id=\"header\">\r\n");
      out.write("\t\t<div class=\"container main-menu\">\r\n");
      out.write("\t\t\t<div class=\"row align-items-center justify-content-between d-flex\">\r\n");
      out.write("\t\t\t\t<div id=\"logo\">\r\n");
      out.write("\t\t\t\t\t<a href=\"/travelduo/index.jsp\"><img\r\n");
      out.write("\t\t\t\t\t\tsrc=\"/travelduo/resources/images/logo2.png\" alt=\"\" title=\"\"\r\n");
      out.write("\t\t\t\t\t\tstyle=\"height: 30px;\"></a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<nav id=\"nav-menu-container\">\r\n");
      out.write("\t\t\t\t\t<ul class=\"nav-menu\">\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"/travelduo/index2.jsp\">매칭시스템</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"/travelduo/pialist\">국내여행</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"/travelduo/poalist\">해외여행\r\n");
      out.write("\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"/travelduo/pclist?coun=일본\">일본</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"/travelduo/pclist?coun=영국\">영국</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"/travelduo/pclist?coun=프랑스\">프랑스</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"/travelduo/pclist?coun=체코\">체코</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"/travelduo/pclist?coun=미국\">미국</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"/travelduo/pclist?coun=이탈리아\">이탈리아</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"/travelduo/pclist?coun=헝가리\">헝가리</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"/travelduo/pclist?coun=독일\">독일</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"/travelduo/pclist?coun=중국\">중국</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"/travelduo/pclist?coun=호주\">호주</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"/travelduo/pclist?coun=태국\">태국</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"/travelduo/blist\">매칭게시판</a></li>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t");
 if(loginUser!=null) { 
      out.write("\r\n");
      out.write("\t\t<li><a href=\"/travelduo/matchList?userid=");
      out.print( loginUser.getUserId() );
      out.write("\"> 내게 온 매칭</a></li>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t");
 }else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<li class=\"menu-has-children\"><a href=\"\">고객센터</a>\r\n");
      out.write("\t\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"/travelduo/nlist?page=1\">공지사항</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"/travelduo/views/faq/faq.jsp\">FAQ</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"/travelduo/qlist?page=1\">QnA</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li><a><span style=\"font-size:15px;color:white;cursor:pointer\" onclick=\"openNav()\">&#9776;　</span>\r\n");
      out.write("\t\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</nav>\r\n");
      out.write("\t\t\t\t<!-- #nav-menu-container -->\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"mySidenav\" class=\"sidenav\">\r\n");
      out.write("\r\n");
      out.write("<br>\r\n");
      out.write("  <a href=\"javascript:void(0)\" class=\"closebtn\" onclick=\"closeNav()\">&times;</a>\r\n");
      out.write("  <a href=\"/travelduo\" align=\"center\"><img src=\"/travelduo/resources/images/logo2.png\" width= \"180\" height= \"60\"></a><br>\r\n");
      out.write("  <br>\r\n");
      out.write("  <br>\r\n");
      out.write("  <br>\r\n");
      out.write("  <br>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
if(loginUser!=null){ 
      out.write("<!--로그인하였을 경우  -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<p class=\"line2\"></p>\r\n");
      out.write("<ul class=\"fa-ul\">\r\n");
      out.write("\r\n");
      out.write("<a href=\"/travelduo/views/member/memberMyPage.jsp\" > <img src=\"/travelduo/resources/images/Person_icon-icons.com_51960.png\" width= \"20\" height= \"20\"> 회원정보 보기/수정</a>\r\n");
      out.write("<a href=\"/travelduo/index2.jsp\" > <img src=\"/travelduo/resources/images/멤버 매칭시스템 로고.png\" width= \"20\" height= \"20\"> 매칭 시스템</a>\r\n");
      out.write("<a href=\"/travelduo/nlist?page=1\" > <img src=\"/travelduo/resources/images/Phone-call_icon-icons.com_51956.png\" width= \"20\" height= \"20\"> 고객 센터 문의</a>\r\n");
      out.write("<a href=\"/travelduo/logout\" > <img src=\"/travelduo/resources/images/Login_icon-icons.com_52028 (1).png\" width= \"20\" height= \"20\"> 로그아웃</a>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</ul>\r\n");
      out.write("<p class=\"line3\"></p>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \t<!-- \t <ul class=\"fa-ul\">\r\n");
      out.write("              <li class=\"text-muted\"><span class=\"fa-li\"><i class=\"fas fa-times\"></i></span><a href=\"\"><h5>회원정보 확인/수정</h5></a></li>\r\n");
      out.write("              <br>\r\n");
      out.write("              <br>\r\n");
      out.write("              <li class=\"text-muted\"><span class=\"fa-li\"><i class=\"fas fa-times\"></i></span>찜한 상품</li>\r\n");
      out.write("              <br>\r\n");
      out.write("              <br>\r\n");
      out.write("              <li class=\"text-muted\"><span class=\"fa-li\"><i class=\"fas fa-times\"></i></span>결제 내역 확인</li>\r\n");
      out.write("              <br>\r\n");
      out.write("              <br>\r\n");
      out.write("              <li class=\"text-muted\"><span class=\"fa-li\"><i class=\"fas fa-times\"></i></span>고객센터</li>\r\n");
      out.write("              <br>\r\n");
      out.write("              <br>\r\n");
      out.write("              <a href=\"/travelduo/logout\"><li class=\"text-muted\"><span class=\"fa-li\"><i class=\"fas fa-times\"></i></span></li>로그아웃</a>\r\n");
      out.write("              <br>\r\n");
      out.write("              <br>\r\n");
      out.write("           </ul>  -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
}else{ 
      out.write("<!--로그인하지 않았을 경우  -->\r\n");
      out.write("<form action=\"/travelduo/mlogin\" method=\"post\">\r\n");
      out.write(" \r\n");
      out.write("  <h4 class=\"logincolor818181\">&ensp;&ensp; 로그인</h4> \r\n");
      out.write("\r\n");
      out.write("<div style = \"padding: 4px 1px 3px 3px;\">  \r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>&ensp;&emsp;<input type=\"text\" name=\"userid\" placeholder=\"ID\" required></td>\r\n");
      out.write("\t</tr><br>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div style = \"padding: 4px 1px 10px 3px;\"> \r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>&ensp;&emsp;<input type=\"password\" name=\"userpwd\" placeholder=\"Password\" required></td><br>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div>\r\n");
      out.write("<tr>\r\n");
      out.write("&ensp;&emsp;&emsp;&emsp; &emsp;&emsp;&emsp;&emsp;&ensp;&ensp;&ensp;<p class=\"line\"><input class=\"btn btn-secondary btn\" type=\"submit\" value=\"로 그 인\"></p>\r\n");
      out.write("</tr>\r\n");
      out.write("</div>\r\n");
      out.write("<br>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<div class=\"btn\">\r\n");
      out.write("\r\n");
      out.write("\t<a href=\"/travelduo/views/member/memberAccept.jsp\">회원가입</a>\r\n");
      out.write("\t<a href=\"/travelduo/views/member/memberFindId.jsp\">ID/PW 찾기</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("</tr>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 if(loginUser != null && loginUser.getUserId().equals("admin")){ 
      out.write("\r\n");
      out.write("\t<!--관리자 전용 페이지 만든후 거기로이동하게 끔  --> \t\r\n");
      out.write("\t<ul class=\"fa-ul\">\r\n");
      out.write("\t<a href=\"/travelduo/mm\">관리자 페이지로 이동</a>\r\n");
      out.write("\t</ul>\r\n");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--   로그인화면 -->\r\n");
      out.write("<!--   <form>\r\n");
      out.write("                <div class=\"form-label-group\">\r\n");
      out.write("                  <input type=\"id\" id=\"inputId\" class=\"form-control\" placeholder=\"ID\" required autofocus>\r\n");
      out.write("                </div>\r\n");
      out.write("                <br>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"form-label-group\">\r\n");
      out.write("                  <input type=\"password\" id=\"inputPassword\" class=\"form-control\" placeholder=\"Password\" required>\r\n");
      out.write("                </div>\r\n");
      out.write("                <br>\r\n");
      out.write("                <button class=\"btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2\" type=\"submit\">로그인</button>\r\n");
      out.write("                \r\n");
      out.write("                <button class=\"btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2\" type=\"button\">아이디 비밀번호찾기</button>\r\n");
      out.write("                <button class=\"btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2\" type=\"button\">회원가입</button>\r\n");
      out.write("              </form> -->\r\n");
      out.write("              \r\n");
      out.write("              \r\n");
      out.write("<!-- 회원가입 -->\r\n");
      out.write("<!--               <article class=\"container\">\r\n");
      out.write("            <div class=\"page-header\">\r\n");
      out.write("                <div class=\"col-md-6 col-md-offset-3\">\r\n");
      out.write("                <h3><a href=\"#\">회원가입</a></h3>\r\n");
      out.write("                <br><br>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-sm-6 col-md-offset-3\">\r\n");
      out.write("                <form role=\"form\">\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"inputName\"><a href=\"#\">성명</a></label>\r\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"inputName\" placeholder=\"이름을 입력해 주세요\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"InputEmail\"><a href=\"#\">이메일 주소</a></label>\r\n");
      out.write("                        <input type=\"email\" class=\"form-control\" id=\"InputEmail\" placeholder=\"이메일 주소를 입력해주세요\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"inputPassword\"><a href=\"#\">비밀번호</a></label>\r\n");
      out.write("                        <input type=\"password\" class=\"form-control\" id=\"inputPassword\" placeholder=\"비밀번호를 입력해주세요\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"inputPasswordCheck\"><a href=\"#\">비밀번호 확인</a></label>\r\n");
      out.write("                        <input type=\"password\" class=\"form-control\" id=\"inputPasswordCheck\" placeholder=\"비밀번호 확인을 위해 다시한번 입력 해 주세요\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"inputMobile\"><a href=\"#\">휴대폰 번호</a></label>\r\n");
      out.write("                        <input type=\"tel\" class=\"form-control\" id=\"inputMobile\" placeholder=\"휴대폰번호를 입력해 주세요\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"inputtelNO\"><a href=\"#\">비밀번호 힌트</a></label>\r\n");
      out.write("                        <select name=\"\">\r\n");
      out.write("                        <option value=\"좋아하는 색은?\" selected>좋아하는 색은?\r\n");
      out.write("                        <option value=\"아버지 성함은?\">아버지 성함은?\r\n");
      out.write("                        <option value=\"어머니 성함은?\">어머니 성함은?\r\n");
      out.write("                        <option value=\"첫번째 연인의 이름은?\">첫사랑 했던 연인의 이름은?\r\n");
      out.write("                        <option value=\"일생중 일어났던 중요한 사건은?\">일생중 일어났던 중요한 사건은?\r\n");
      out.write("                        </select>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"hint\"><a href=\"#\">힌트의 정답</a></label>\r\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"inputHint\" placeholder=\"정답을 입력해 주세요\">\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                    <label>약관 동의</label>\r\n");
      out.write("                    <div data-toggle=\"buttons\">\r\n");
      out.write("                    <label class=\"btn btn-primary active\">\r\n");
      out.write("                    <span class=\"fa fa-check\"></span>\r\n");
      out.write("                    <input id=\"agree\" type=\"checkbox\" autocomplete=\"off\" checked>\r\n");
      out.write("                    </label>\r\n");
      out.write("                    <a href=\"#\">이용약관</a>에 동의합니다.\r\n");
      out.write("                    </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <div class=\"form-group text-center\">\r\n");
      out.write("                        <button type=\"submit\" id=\"join-submit\" class=\"btn btn-primary\">\r\n");
      out.write("                            회원가입<i class=\"fa fa-check spaceLeft\"></i>\r\n");
      out.write("                        </button>\r\n");
      out.write("                        <button type=\"button\" class=\"btn btn-warning\">\r\n");
      out.write("                            가입취소<i class=\"fa fa-times spaceLeft\"></i>\r\n");
      out.write("                        </button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("            <br>\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <br>text-muted\r\n");
      out.write("                    <br>\r\n");
      out.write("\r\n");
      out.write("        </article> -->\r\n");
      out.write("        <br><br>\r\n");
      out.write("<!-- 마이페이지 -->\r\n");
      out.write("<!-- #header -->\r\n");
      out.write("\t<!--\r\n");
      out.write("\t\tJS\r\n");
      out.write("\t\t============================================= -->\r\n");
      out.write("\t\t\t   <script type=\"text/javascript\" src=\"/travelduo/resources/js/superfish.min.js\"></script>\r\n");
      out.write("   <script type=\"text/javascript\" src=\"/travelduo/resources/js/jquery.magnific-popup.min.js\"></script>\r\n");
      out.write("   <script type=\"text/javascript\" src=\"/travelduo/resources/js/owl.carousel.min.js\"></script>\r\n");
      out.write("   <script type=\"text/javascript\" src=\"/travelduo/resources/js/main.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</header>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<br><br><br><br><br><br>\r\n");
      out.write("\r\n");
      out.write("<center>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("\t\t\t<table class=\"table table-striped\" \r\n");
      out.write("\t\t\tstyle=\"text-align: center; border: 2px; solid :#dddddd;  height: 80px; width: 500px;\">\r\n");
      out.write("\t\t\r\n");
      out.write(" \t\t\t\r\n");
      out.write("                <td>  메세지 내용입니다 : <br>\r\n");
      out.write("                ");
      out.print( Message.getContent() );
      out.write("</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"wrap\" >\r\n");
      out.write("    <br><br>\r\n");
      out.write("    <div id=\"board\">\r\n");
      out.write("        <table id=\"detailBoard\" width=\"500\" border=\"3\" bordercolor=\"lightgray\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t<th>보낸사람 아이디 :  ");
      out.print( fromUser );
      out.write("<br></th>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t<th> <br>\r\n");
      out.write("\t\t\t\t나이 : ");
      out.print( member.getAge() );
      out.write(" <br>\r\n");
      out.write("\t\t\t\t연락처 : ");
      out.print( member.getPhone() );
      out.write(" <br>\r\n");
      out.write("\t\t\t\t실명 : ");
      out.print( member.getUserName() );
      out.write(" <br>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</th>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<br><br>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");
 if ( matchinfo != null) {
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t<th> <br>  등록한 여행정보 <br>\r\n");
      out.write("\t\t\t지역 : ");
 
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
   
      out.write(" <br>\r\n");
      out.write("\t\t\t도시 : ");
      out.print( matchinfo.getMatchCity() );
      out.write(" <br>\r\n");
      out.write("\t\t\t월 :  ");

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
   
      out.write(" <br><br>\r\n");
      out.write("\t\t\t상세 계획 : <br> ");
      out.print( matchinfo.getMatchPlan() );
      out.write(" <br><br>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<br><br>\r\n");
      out.write("\t\t\t</th>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("            \r\n");
      out.write(" \t\t\t</table>\r\n");
      out.write(" \t\t\t<br><br>\r\n");
      out.write(" \t\t\t\r\n");
      out.write(" \t\t\t\r\n");
      out.write(" \t\t\r\n");
      out.write(" \t\t\t\r\n");
      out.write(" \t\t\t\r\n");
      out.write(" \t\t\t\r\n");
      out.write(" \t\t\t");
 }else{ 
      out.write("\r\n");
      out.write(" \t\t\t\r\n");
      out.write(" \t\t\t");
} 
      out.write("\r\n");
      out.write(" \t\t\t<br>\r\n");
      out.write(" \t\t\t\r\n");
      out.write(" \t\t\t\t<!--  사진태그 -->\r\n");
      out.write(" \t\t\t");
 if (matchinfo.getMatchPhoto()!=null ) { 
      out.write("\t\r\n");
      out.write(" \t\t\t<td colspan=\"2\" style=\"min-height: 500px; text-align: left;\">\r\n");
      out.write("<img src=\"/travelduo/file/matchinfo/");
      out.print( matchinfo.getMatchPhoto() );
      out.write("\" width=\"600\" height=\"500\" class=\"img-thumbnail\">\r\n");
      out.write("</td>\r\n");
      out.write(" \t\t\t\r\n");
      out.write(" \t\t\t<br><br>\r\n");
      out.write(" \t\t\t\r\n");
      out.write(" \t\t\t");
 } 
      out.write("\r\n");
      out.write(" \t\t\t\r\n");
      out.write(" \t\t\t<!--  사진태그 끝-->\r\n");
      out.write(" \t\t\t\r\n");
      out.write(" \t\t\t<a href=\"/travelduo/matchList?page=");
      out.print(currentPage );
      out.write("&userid=");
      out.print( loginUser.getUserId() );
      out.write("\"\r\n");
      out.write(" \t\t\tclass=\"btn btn-danger\" >목록</a>\r\n");
      out.write(" \t\t\t&nbsp;&nbsp;\r\n");
      out.write(" \t\t\t<form onclick=\"sendmessage()\" class=\"btn btn-info\">답장하기\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"address\" \r\n");
      out.write("\t\t\t\t\tid=\"message\" value=\"");
      out.print( Message.getFromUser()  );
      out.write("\"  />\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write(" \t\t\t\r\n");
      out.write("    \t</div>\r\n");
      out.write("\t\t</div>    \r\n");
      out.write("<!--  아코디언 -->\r\n");
      out.write("\t\t\r\n");
      out.write("            <!-- 아코디언 끝 -->\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("</center>\r\n");
      out.write("<br><br>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
