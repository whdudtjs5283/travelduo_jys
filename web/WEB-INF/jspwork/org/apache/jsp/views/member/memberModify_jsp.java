/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2019-04-05 09:36:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import member.model.vo.Member;

public final class memberModify_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/views/member/../common/header.jsp", Long.valueOf(1554456826902L));
    _jspx_dependants.put("/views/member/../common/footer.jsp", Long.valueOf(1554293034000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("member.model.vo.Member");
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
      out.write("\r\n");

	String modifyResult = (String) request.getAttribute("modifyResult");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<meta name=\"viewport\"\r\n");
      out.write("\tcontent=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("\r\n");
      out.write("<title>회원정보 수정</title>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/travelduo/resources/css/bootstrap.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/travelduo/resources/css/main.css\">\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"/travelduo/resources/js/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\twindow.onload = function() {\r\n");
if (modifyResult != null && modifyResult.equals("fail")) {
      out.write("\r\n");
      out.write("\talert(\"비밀번호가 회원 아이디와 일치하지 않습니다. \\n비밀번호를 확인해주세요\");\r\n");
}
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("#pos1 {\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\tleft: -4px;\r\n");
      out.write("\tmargin-bottom: 10px; /* 위아래공백만들어줌 */\r\n");
      out.write("\ttop: -10px;\r\n");
      out.write("}\r\n");
      out.write("/*  content를 좌측으로 이동시키기 위함   */\r\n");
      out.write("#divPwd {\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\ttop: -53px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#posbutton {\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\tright: -285px;\r\n");
      out.write("\ttop: -107px\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"signup-img\">\r\n");
      out.write("\t\t<img src=\"/travelduo/resources/images/wan/회원가입에서 풍경사진2.jpg\"\r\n");
      out.write("\t\t\twidth=\"1519\" height=\"250\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- <hr style= \"clear:left\"> -->\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("    \r\n");

	Member loginUser = (Member)session.getAttribute("loginUser");

      out.write("\r\n");
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
      out.write("<div>\r\n");
      out.write("<tr>\r\n");
      out.write("&ensp;&emsp;&emsp;&emsp; &emsp;&emsp;&emsp;&emsp;&ensp;&ensp;&ensp;<p class=\"line\"><input class=\"btn btn-secondary btn\" type=\"submit\" value=\"로 그 인\"></p>\r\n");
      out.write("</tr>\r\n");
      out.write("</div>\r\n");
      out.write("<br>\r\n");
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
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-md-12 content-body\">\r\n");
      out.write("\t\t\t\t<ul class=\"nav nav-tabs\">\r\n");
      out.write("\t\t\t\t\t<li class=\"nav-item \"><a class=\"nav-link\"\r\n");
      out.write("\t\t\t\t\t\thref=\"/travelduo/views/member/memberMyPage.jsp\">회원정보 보기</a></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link active\"\r\n");
      out.write("\t\t\t\t\t\thref=\"/travelduo/views/member/memberModify.jsp\">회원정보 수정</a></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\"\r\n");
      out.write("\t\t\t\t\t\thref=\"/travelduo/views/member/memberDelete.jsp\">회원 탈퇴</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<br>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<h1>비밀번호 재확인</h1>\r\n");
      out.write("\t\t\t\t<p>&nbsp;회원의 정보를 안전하게 보호하기 위해, &nbsp;비밀번호를 다시 한번 입력해 주세요.</p>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<form method=\"post\" action=\"/travelduo/mmodify\">\r\n");
      out.write("\t\t\t\t\t<div id=\"pos1\">\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-group \" id=\"divId\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label for=\"inputId\"></label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"col-lg-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control \" id=\"userid\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tname=\"userid\" data-rule-required=\"true\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tvalue=\"");
      out.print(loginUser.getUserId());
      out.write("\" readonly maxlength=\"20\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</td>&emsp; &nbsp;\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-group\" id=\"divPwd\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label for=\"inputPwd\"></label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"col-lg-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"password\" class=\"form-control\" id=\"userpwd\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tname=\"userpwd\" data-rule-required=\"true\" placeholder=\"비밀번호\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmaxlength=\"25\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div> <input type=\"submit\" id=\"posbutton\" value=\" 확인  \"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"btn btn-secondary \">\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<!-- <button class=\"btn\" onclick=\"return checkId();\" >ID 찾기</button> -->\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t<br> <br> <br> <br> <br> <br> <br>\r\n");
      out.write("\t\t\t<br> <br>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- \t\t<hr style= \"clear:left\"> -->\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<head>\r\n");
      out.write("<!-- Mobile Specific Meta -->\r\n");
      out.write("<meta name=\"viewport\"\r\n");
      out.write("\tcontent=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("<!-- Favicon-->\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"img/fav.png\">\r\n");
      out.write("<!-- Author Meta -->\r\n");
      out.write("<meta name=\"author\" content=\"colorlib\">\r\n");
      out.write("<!-- Meta Description -->\r\n");
      out.write("<meta name=\"description\" content=\"\">\r\n");
      out.write("<!-- Meta Keyword -->\r\n");
      out.write("<meta name=\"keywords\" content=\"\">\r\n");
      out.write("<!-- meta character set -->\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<!-- Site Title -->\r\n");
      out.write("<title>Travel Duo</title>\r\n");
      out.write("\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--\r\n");
      out.write("\t\t\tCSS\r\n");
      out.write("\t\t\t============================================= -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/travelduo/resources/css/linearicons.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/travelduo/resources/css/bootstrap.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/travelduo/resources/css/magnific-popup.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/travelduo/resources/css/jquery-ui.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/travelduo/resources/css/nice-select.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/travelduo/resources/css/animate.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/travelduo/resources/css/owl.carousel.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/travelduo/resources/css/main.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/travelduo/resources/css/bootstrap.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/travelduo/resources/css/fontawesome.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.linearicons.com/free/1.0.0/icon-font.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.7.2/css/all.css\" integrity=\"sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr\" crossorigin=\"anonymous\">\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".carousel-item {\r\n");
      out.write("\theight: 100vh;\r\n");
      out.write("\tmin-height: 350px;\r\n");
      out.write("\tbackground: no-repeat center center scroll;\r\n");
      out.write("\t-webkit-background-size: cover;\r\n");
      out.write("\t-moz-background-size: cover;\r\n");
      out.write("\t-o-background-size: cover;\r\n");
      out.write("\tbackground-size: cover;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!-- start footer Area -->\r\n");
      out.write("\t\t\t\t<footer class=\"footer-area\">\r\n");
      out.write("\t\t\t\t<div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-lg-7 col-md-6 col-sm-6\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"single-footer-widget\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<h6>About Agency</h6>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p>copyright@kh.org 2019-03-04 master : 박건영<br>\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttel : 02-1234-5678, 서울시 강남구 역삼동 777, fax : 02-1111-2356<br>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t본사 : 서울시 강남 역삼동 khacademy 1관 4층 S클래스<br>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t(주)자바스크류바투어 팀장 : 박건영<br>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t사업자등록번호 : 365-87-00612 | 관광사업등록증 : 제2019-000001호<br>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t개인정보 관리 책임자 : 조영선 부팀장 | TEL : 031-512-5293 | FAX : 02-754-6678<br>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t여행업자 전문인 배상책임보험 : 2018-2299298 / 보상 가입액 : 5억<br>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t일반 여행업의 기획 여행 : 100-000-2019 0002 9033 호/ 보증 보험 : 2억 \r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-lg-5  col-md-6 col-sm-6\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"single-footer-widget\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<p><img src=\"/travelduo/resources/images/logoplus.png\" style=\"width:400px;height:230px;\"></p>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"row footer-bottom d-flex justify-content-between align-items-center\">\r\n");
      out.write("\t\t\t\t\t\t<p class=\"col-lg-8 col-sm-12 footer-text m-0\"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->\r\n");
      out.write("Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved<i class=\"fa fa-heart-o\" aria-hidden=\"true\"></i>\r\n");
      out.write("<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t</div><br><br>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</footer>\r\n");
      out.write("\r\n");
      out.write("\t<!--\r\n");
      out.write("\t\tJS\r\n");
      out.write("\t\t============================================= -->\r\n");
      out.write("\t<script type=\"text/javascript\"src=\"/travelduo/resources/js/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\"src=\"/travelduo/resources/js/bootstrap.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"/travelduo/resources/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"/travelduo/resources/js/popper.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"/travelduo/resources/js/jquery-ui.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"/travelduo/resources/js/easing.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"/travelduo/resources/js/hoverIntent.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"/travelduo/resources/js/superfish.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"/travelduo/resources/js/jquery.ajaxchimp.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"/travelduo/resources/js/jquery.magnific-popup.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"/travelduo/resources/js/jquery.nice-select.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"/travelduo/resources/js/owl.carousel.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"/travelduo/resources/js/main.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\t<!--여기선 절대경로 안돼 상대경로써야함  -->\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
