/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.39
 * Generated at: 2019-04-05 07:32:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import product.model.vo.Product;
import java.util.*;

public final class productManagementView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/../views/common/adminLeftNav.jsp", Long.valueOf(1554292406000L));
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
    _jspx_imports_classes.add("product.model.vo.Product");
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

	ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("list");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("  <meta charset=\"utf-8\">\r\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("  <meta name=\"description\" content=\"\">\r\n");
      out.write("  <meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("  <title>Travel Duo</title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body id=\"page-top\">\r\n");
      out.write("\r\n");
      out.write("  <!-- Page Wrapper -->\r\n");
      out.write("  <div id=\"wrapper\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Sidebar -->\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Travel Duo</title>\r\n");
      out.write("  <!-- Custom styles for this template-->\r\n");
      out.write("  <link href=\"/travelduo/resources/css/sb-admin-2.min.css\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("<body style=\"padding:0px 0px 0px 220px;\">\r\n");
      out.write("\r\n");
      out.write("<!-- Sidebar -->\r\n");
      out.write("    <ul class=\"navbar-nav bg-gradient-primary sidebar sidebar-dark accordion fixed-top\" id=\"accordionSidebar\" >\r\n");
      out.write("\r\n");
      out.write("      <!-- Sidebar - Brand -->\r\n");
      out.write("      <a class=\"sidebar-brand d-flex align-items-center justify-content-center\" href=\"/travelduo/index.jsp\">\r\n");
      out.write("        <div class=\"sidebar-brand-icon\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <img src=\"/travelduo/resources/images/logo.png\" style=\"width:100px;\">\r\n");
      out.write("      </a>\r\n");
      out.write("\r\n");
      out.write("      <!-- Divider -->\r\n");
      out.write("      <hr class=\"sidebar-divider my-0\">\r\n");
      out.write("\r\n");
      out.write("      <!-- Nav Item - Charts -->\r\n");
      out.write("\r\n");
      out.write("         <li class=\"nav-item\">\r\n");
      out.write("        <a class=\"nav-link text-center\" href=\"/travelduo/mm\">\r\n");
      out.write("          <span>회원관리</span></a>\r\n");
      out.write("      </li>\r\n");
      out.write("         <li class=\"nav-item\">\r\n");
      out.write("        <a class=\"nav-link text-center\" href=\"/travelduo/amreview\">\r\n");
      out.write("          <span>매치리뷰</span></a>\r\n");
      out.write("      </li>\r\n");
      out.write("         <li class=\"nav-item\">\r\n");
      out.write("        <a class=\"nav-link text-center\" href=\"/travelduo/pmlist\">\r\n");
      out.write("          <span>상품관리</span></a>\r\n");
      out.write("      </li>\r\n");
      out.write("   \t<li class=\"nav-item\">\r\n");
      out.write("              <a class=\"nav-link text-center\" href=\"#\" data-toggle=\"modal\" data-target=\"#logoutModal\">\r\n");
      out.write("                <span class=\"\">로그아웃</span>\r\n");
      out.write("              </a>\r\n");
      out.write("            </li>\r\n");
      out.write("      <!-- Nav Item - Tables -->\r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("      <!-- Divider -->\r\n");
      out.write("      <!-- Sidebar Toggler (Sidebar) -->\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("    </ul>\r\n");
      out.write("\r\n");
      out.write(" <!-- Logout Modal-->\r\n");
      out.write("  <div class=\"modal fade\" id=\"logoutModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("    <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("      <div class=\"modal-content\">\r\n");
      out.write("        <div class=\"modal-header\">\r\n");
      out.write("          <h5 class=\"modal-title\" id=\"exampleModalLabel\">로그아웃 하시겠습니까?</h5>\r\n");
      out.write("          <button class=\"close\" type=\"button\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("            <span aria-hidden=\"true\">×</span>\r\n");
      out.write("          </button>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"modal-body\">로그아웃 버튼을 누르시면 로그아웃 됩니다.</div>\r\n");
      out.write("        <div class=\"modal-footer\">\r\n");
      out.write("          <button class=\"btn btn-secondary\" type=\"button\" data-dismiss=\"modal\">취소</button>\r\n");
      out.write("          <a class=\"btn btn-primary\" href=\"/travelduo/logout\">로그아웃</a>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write(" <!-- Bootstrap core JavaScript-->\r\n");
      out.write("  <script type=\"text/javascript\"src=\"/travelduo/resources/js/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("  <script type=\"text/javascript\" src=\"/travelduo/resources/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("    <!-- End of Sidebar -->\r\n");
      out.write("\r\n");
      out.write("    <!-- Content Wrapper -->\r\n");
      out.write("    <div id=\"content-wrapper\" class=\"d-flex flex-column\">\r\n");
      out.write("\r\n");
      out.write("      <div id=\"content\">\r\n");
      out.write("\r\n");
      out.write("        <nav class=\"navbar navbar-expand mb-1 static-top\">\r\n");
      out.write("\r\n");
      out.write("          <ul class=\"navbar-nav ml-auto\">\r\n");
      out.write("\r\n");
      out.write("          </ul>\r\n");
      out.write("\r\n");
      out.write("        </nav>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("          <div class=\"row\">\r\n");
      out.write("         \r\n");
      out.write("          </div>\r\n");
      out.write("\r\n");
      out.write("          <div class=\"row\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-lg-6 mb-4\">\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-lg-6 mb-4\">\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"container-fluid\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("          \r\n");
      out.write("\t\t\t  <div class=\"container-fluid\">\r\n");
      out.write("\r\n");
      out.write("                   <!-- DataTales Example -->\r\n");
      out.write("          <div class=\"card shadow mb-4\">\r\n");
      out.write("            <div class=\"card-header py-3\">\r\n");
      out.write("              <h6 class=\"m-0 font-weight-bold text-primary\">전체상품목록</h6>\r\n");
      out.write("              <nav class=\"navbar navbar-expand-sm bg-light navbar-white\">\r\n");
      out.write("\t\t\t  <form class=\"form-inline\" action=\"/travelduo/psearch\">\r\n");
      out.write("\t    <select class=\"custom-select\" name=\"search\">\r\n");
      out.write("\t\t\t<option value=\"pnum\">상품번호</option>\r\n");
      out.write("\t\t\t<option value=\"coun\">국가</option>\r\n");
      out.write("\t\t\t<option value=\"des\">여행지</option>\r\n");
      out.write("\t\t</select>&nbsp;\r\n");
      out.write("\t\t<input class=\"form-control mr-sm-2\" type=\"text\" name=\"content\" placeholder=\"Search\">\r\n");
      out.write("    <button class=\"btn btn-primary\" type=\"submit\">검색</button>\r\n");
      out.write("  </form>\r\n");
      out.write("     &nbsp;&nbsp;&nbsp;<button class=\"btn btn-primary\" onclick=\"location.href='/travelduo/views/admin/productWriteView.jsp';\">상품등록</button>\r\n");
      out.write("</nav>\r\n");
      out.write("<script type=\"text/javascript\"></script>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"card-body\">\r\n");
      out.write("              <div class=\"table-responsive\">\r\n");
      out.write("                <table class=\"table table-bordered\" id=\"dataTable\" width=\"100%\" cellspacing=\"0\">\r\n");
      out.write("                  <thead>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <th style=\"width:50px;\">No</th>\r\n");
      out.write("                      <th>상품번호</th>\r\n");
      out.write("                      <th>상품명</th>\r\n");
      out.write("                      <th>국가</th>\r\n");
      out.write("                      <th>지역</th>\r\n");
      out.write("                      <th>수정/삭제</th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                  </thead>\r\n");
      out.write("                  <tfoot>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <th>No</th>\r\n");
      out.write("                      <th>상품번호</th>\r\n");
      out.write("                      <th>상품명</th>\r\n");
      out.write("                      <th>국가</th>\r\n");
      out.write("                      <th>지역</th>\r\n");
      out.write("                      <th>수정/삭제</th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                  </tfoot>\r\n");
      out.write("                  ");
 for(Product product : list) { 
      out.write("\r\n");
      out.write("                  <tbody>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td>");
      out.print( product.getProductListNo() );
      out.write("</td>\r\n");
      out.write("                      <td id=\"pnum\">");
      out.print( product.getProductNum() );
      out.write("</td>\r\n");
      out.write("                      <td><a href=\"/travelduo/pdetail?num=");
      out.print( product.getProductNum() );
      out.write('"');
      out.write('>');
      out.print( product.getProductName() );
      out.write("</a></td>\r\n");
      out.write("                      <td>");
      out.print( product.getCountry() );
      out.write("</td>\r\n");
      out.write("                      <td>");
      out.print( product.getDestination() );
      out.write("</td>\r\n");
      out.write("                      <td style=\"width:130px;\">\r\n");
      out.write("                      \t\t<a href=\"/travelduo/pupdateview?num=");
      out.print( product.getProductNum() );
      out.write("\" class=\"btn btn-primary btn-sm\">수정</a>&nbsp;\r\n");
      out.write("                     \t\t<a href=\"/travelduo/pdelete?num=");
      out.print( product.getProductNum() );
      out.write("\" class=\"btn btn-primary btn-sm\" data-toggle=\"modal\" data-target=\"#deleteModal\">삭제</a>\r\n");
      out.write("              </a>\r\n");
      out.write("                     </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                  </tbody>\r\n");
      out.write("                    <!-- 삭제 모달-->\r\n");
      out.write("                   <div class=\"modal fade\" id=\"deleteModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("\t\t\t\t    <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("\t\t\t\t      <div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t        <div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t          <h5 class=\"modal-title\" id=\"exampleModalLabel\">삭제 하시겠습니까?</h5>\r\n");
      out.write("\t\t\t\t          <button class=\"close\" type=\"button\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("\t\t\t\t            <span aria-hidden=\"true\">×</span>\r\n");
      out.write("\t\t\t\t          </button>\r\n");
      out.write("\t\t\t\t        </div>\r\n");
      out.write("\t\t\t\t        <div class=\"modal-body\">삭제 버튼을 누르시면 삭제 됩니다.</div>\r\n");
      out.write("\t\t\t\t        <div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t          <button class=\"btn btn-secondary\" type=\"button\" data-dismiss=\"modal\">취소</button>\r\n");
      out.write("\t\t\t\t          <a class=\"btn btn-primary\" href=\"/travelduo/pdelete?num=");
      out.print( product.getProductNum() );
      out.write("\">삭제</a>\r\n");
      out.write("\t\t\t\t        </div>\r\n");
      out.write("\t\t\t\t      </div>\r\n");
      out.write("\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t  </div>\r\n");
      out.write("                    ");
 } 
      out.write("\r\n");
      out.write("            \r\n");
      out.write("                \r\n");
      out.write("                </table>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /.container-fluid -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /.container-fluid -->\r\n");
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("      <!-- End of Main Content -->\r\n");
      out.write("\r\n");
      out.write("      <!-- Footer -->\r\n");
      out.write("\r\n");
      out.write("      <!-- End of Footer -->\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- End of Content Wrapper -->\r\n");
      out.write("\r\n");
      out.write("  </div>\r\n");
      out.write("  <!-- End of Page Wrapper -->\r\n");
      out.write("\r\n");
      out.write("  <!-- Scroll to Top Button-->\r\n");
      out.write("  <a class=\"scroll-to-top rounded\" href=\"#page-top\">▲</a>\r\n");
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
