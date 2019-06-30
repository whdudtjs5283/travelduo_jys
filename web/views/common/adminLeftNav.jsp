<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Travel Duo</title>
  <!-- Custom styles for this template-->
  <link href="/travelduo/resources/css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body style="padding:0px 0px 0px 220px;">

<!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion fixed-top" id="accordionSidebar" >

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/travelduo/index.jsp">
        <div class="sidebar-brand-icon">
        </div>
        <img src="/travelduo/resources/images/logo.png" style="width:100px;">
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider my-0">

      <!-- Nav Item - Charts -->

         <li class="nav-item">
        <a class="nav-link text-center" href="/travelduo/mm">
          <span>회원관리</span></a>
      </li>
         <li class="nav-item">
        <a class="nav-link text-center" href="/travelduo/amreview">
          <span>매치리뷰</span></a>
      </li>
         <li class="nav-item">
        <a class="nav-link text-center" href="/travelduo/pmlist">
          <span>상품관리</span></a>
      </li>
   	<li class="nav-item">
              <a class="nav-link text-center" href="#" data-toggle="modal" data-target="#logoutModal">
                <span class="">로그아웃</span>
              </a>
            </li>
      <!-- Nav Item - Tables -->
  

      <!-- Divider -->
      <!-- Sidebar Toggler (Sidebar) -->
    

    </ul>

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
        <div class="modal-body">로그아웃 버튼을 누르시면 로그아웃 됩니다.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">취소</button>
          <a class="btn btn-primary" href="/travelduo/logout">로그아웃</a>
        </div>
      </div>
    </div>
  </div>

 <!-- Bootstrap core JavaScript-->
  <script type="text/javascript"src="/travelduo/resources/js/jquery-3.3.1.min.js"></script>
  <script type="text/javascript" src="/travelduo/resources/js/bootstrap.min.js"></script>

</body>
</html>