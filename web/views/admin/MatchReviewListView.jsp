<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.Member, java.util.*" %>
<%@ page import="admin.model.vo.MatchReview" %>
<%
	ArrayList<MatchReview> list = (ArrayList<MatchReview>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Travel Duo</title>


</head>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">

    <!-- Sidebar -->
    <%@ include file="/../views/common/adminLeftNav.jsp" %>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
        <nav class="navbar navbar-expand mb-1 static-top">

          <!-- Sidebar Toggle (Topbar) -->

          <!-- Topbar Search -->
        

          <!-- Topbar Navbar -->
          <ul class="navbar-nav ml-auto">

            <!-- Nav Item - Search Dropdown (Visible Only XS) -->


            <!-- Nav Item - Alerts -->

            <!-- Nav Item - Messages -->

            <!-- Nav Item - User Information -->
         

          </ul>

        </nav>
        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
 

          <!-- Content Row -->
          <div class="row">

           

          <!-- Content Row -->


            <!-- Pie Chart -->
         
          </div>

          <!-- Content Row -->
          <div class="row">

            <!-- Content Column -->
            <div class="col-lg-6 mb-4">

              <!-- Project Card Example -->
              

              <!-- Color System -->
          

            </div>

            <div class="col-lg-6 mb-4">

              <!-- Illustrations -->
          

              <!-- Approach -->
             
            </div>
          </div>
          
			  <div class="container-fluid">

                   <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">전체매치리뷰목록</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>이름</th>
                      <th>이메일</th>
                      <th>연락처</th>
                      <th>매치리뷰</th>
                    </tr>
                  </thead>
                  <tfoot>
                    <tr>
                      <th>이름</th>
                      <th>이메일</th>
                      <th>연락처</th>
                      <th>매치리뷰</th>
                    </tr>
                  </tfoot>
                  <tbody>
                  <% for(MatchReview mreview : list) { %>
                    <tr>
                      <td><%= mreview.getUserName() %></td>
                      <td><%= mreview.getEmail() %></td>
                      <td><%= mreview.getPhone() %></td>
                      <td><%= mreview.getReview() %></td>
                    </tr>
                    <% } %>
                  </tbody>
                </table>
              </div>
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->
        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

      <!-- Footer -->

      <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">▲</a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">로그아웃 하시겠습니까?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">Logout 버튼을 누르시면 로그아웃 됩니다.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="login.html">Logout</a>
        </div>
      </div>
    </div>
  </div>

</body>
</html>