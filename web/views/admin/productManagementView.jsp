<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="product.model.vo.Product, java.util.*" %>
<%
	ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("list");
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

      <div id="content">

        <nav class="navbar navbar-expand mb-1 static-top">

          <ul class="navbar-nav ml-auto">

          </ul>

        </nav>

        <div class="container-fluid">
          <div class="row">
         
          </div>

          <div class="row">

            <div class="col-lg-6 mb-4">

            </div>

            <div class="col-lg-6 mb-4">

            </div>
          </div>
          <div class="container-fluid">


        </div>
          
			  <div class="container-fluid">

                   <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">전체상품목록</h6>
              <nav class="navbar navbar-expand-sm bg-light navbar-white">
			  <form class="form-inline" action="/travelduo/psearch">
	    <select class="custom-select" name="search">
			<option value="pnum">상품번호</option>
			<option value="coun">국가</option>
			<option value="des">여행지</option>
		</select>&nbsp;
		<input class="form-control mr-sm-2" type="text" name="content" placeholder="Search">
    <button class="btn btn-primary" type="submit">검색</button>
  </form>
     &nbsp;&nbsp;&nbsp;<button class="btn btn-primary" onclick="location.href='/travelduo/views/admin/productWriteView.jsp';">상품등록</button>
</nav>
<script type="text/javascript"></script>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th style="width:50px;">No</th>
                      <th>상품번호</th>
                      <th>상품명</th>
                      <th>국가</th>
                      <th>지역</th>
                      <th>수정/삭제</th>
                    </tr>
                  </thead>
                  <tfoot>
                    <tr>
                      <th>No</th>
                      <th>상품번호</th>
                      <th>상품명</th>
                      <th>국가</th>
                      <th>지역</th>
                      <th>수정/삭제</th>
                    </tr>
                  </tfoot>
                  <% for(Product product : list) { %>
                  <tbody>
                    <tr>
                      <td><%= product.getProductListNo() %></td>
                      <td id="pnum"><%= product.getProductNum() %></td>
                      <td><a href="/travelduo/pdetail?num=<%= product.getProductNum() %>"><%= product.getProductName() %></a></td>
                      <td><%= product.getCountry() %></td>
                      <td><%= product.getDestination() %></td>
                      <td style="width:130px;">
                      		<a href="/travelduo/pupdateview?num=<%= product.getProductNum() %>" class="btn btn-primary btn-sm">수정</a>&nbsp;
                     		<a href="/travelduo/pdelete?num=<%= product.getProductNum() %>" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#deleteModal">삭제</a>
              </a>
                     </td>
                    </tr>
                  </tbody>
                    <!-- 삭제 모달-->
                   <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
				    <div class="modal-dialog" role="document">
				      <div class="modal-content">
				        <div class="modal-header">
				          <h5 class="modal-title" id="exampleModalLabel">삭제 하시겠습니까?</h5>
				          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
				            <span aria-hidden="true">×</span>
				          </button>
				        </div>
				        <div class="modal-body">삭제 버튼을 누르시면 삭제 됩니다.</div>
				        <div class="modal-footer">
				          <button class="btn btn-secondary" type="button" data-dismiss="modal">취소</button>
				          <a class="btn btn-primary" href="/travelduo/pdelete?num=<%= product.getProductNum() %>">삭제</a>
				        </div>
				      </div>
				    </div>
				  </div>
                    <% } %>
            
                
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

</body>
</html>