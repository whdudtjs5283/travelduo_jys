<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="product.model.vo.Product" %>
<%
	Product product = (Product)request.getAttribute("product");
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Travel Duo</title>

<style type="text/css">
* {
  margin: 0;
  padding: 0px;
  box-sizing: border-box;
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  -webkit-font-smoothing: antialiased;
  -moz-font-smoothing: antialiased;
  -o-font-smoothing: antialiased;
  font-smoothing: antialiased;
  text-rendering: optimizeLegibility;
}


.container {
  max-width: 400px;
  width: 100%;
  margin: 0 auto;
  position: relative;
}

#contact input[type="text"],
#contact input[type="email"],
#contact input[type="tel"],
#contact input[type="url"],
#contact textarea,
#contact button[type="submit"] {
  font: 400 12px/16px "Roboto", Helvetica, Arial, sans-serif;
}

#contact {
  background: #F9F9F9;
  padding: 25px;
  margin: 30px -70px;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}

#contact h3 {
  display: block;
  font-size: 30px;
  font-weight: 300;
  margin-bottom: 10px;
}

#contact h4 {
  margin: 5px 0 15px;
  display: block;
  font-size: 13px;
  font-weight: 400;
}

fieldset {
  border: medium none !important;
  margin: 0 0 10px;
  min-width: 100%;
  padding: 0;
  width: 100%;
}

#contact input[type="text"],
#contact input[type="email"],
#contact input[type="tel"],
#contact input[type="url"],
#contact textarea {
  width: 100%;
  border: 1px solid #ccc;
  background: #FFF;
  margin: 0 0 5px;
  padding: 10px;
}

#contact input[type="text"]:hover,
#contact input[type="email"]:hover,
#contact input[type="tel"]:hover,
#contact input[type="url"]:hover,
#contact textarea:hover {
  -webkit-transition: border-color 0.3s ease-in-out;
  -moz-transition: border-color 0.3s ease-in-out;
  transition: border-color 0.3s ease-in-out;
  border: 1px solid #aaa;
}

#contact textarea {
  height: 100px;
  max-width: 100%;
  resize: none;
}

#contact button[type="submit"] {
  cursor: pointer;
  width: 41%;
  border: none;
  background: #2587ce;
  color: #FFF;
  margin: 0 15px 5px;
  padding: 10px;
  font-size: 15px;
}

#contact button[type="submit"]:hover {
  background: #3d5fe5;
  -webkit-transition: background 0.3s ease-in-out;
  -moz-transition: background 0.3s ease-in-out;
  transition: background-color 0.3s ease-in-out;
}

#contact button[type="submit"]:active {
  box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.5);
}

.copyright {
  text-align: center;
}

#contact input:focus,
#contact textarea:focus {
  outline: 0;
  border: 1px solid #aaa;
}

::-webkit-input-placeholder {
  color: #888;
}

:-moz-placeholder {
  color: #888;
}

::-moz-placeholder {
  color: #888;
}

:-ms-input-placeholder {
  color: #888;
}
</style>
</head>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">

    <!-- Sidebar -->
    <%@ include file="/../views/common/adminLeftNav.jsp" %>

    <div id="content-wrapper" class="d-flex flex-column">

      <div id="content">


        <div class="container-fluid">

          

<div class="container">  
  <form id="contact" action="/travelduo/pupdate?no=<%= product.getProductNum() %>" method="post" enctype="multipart/form-data">
    <h3>상품 수정하기</h3>
    <input type="hidden" name="obi1" value="<%= product.getoBannerImage1() %>">
    <input type="hidden" name="rbi1" value="<%= product.getrBannerImage1() %>">
    <input type="hidden" name="obi2" value="<%= product.getoBannerImage2() %>">
    <input type="hidden" name="rbi2" value="<%= product.getrBannerImage2() %>">
    <input type="hidden" name="obi3" value="<%= product.getoBannerImage3() %>">
    <input type="hidden" name="rbi3" value="<%= product.getrBannerImage3() %>">
    <input type="hidden" name="od" value="<%= product.getoDestinationImage() %>">
    <input type="hidden" name="rd" value="<%= product.getrDestinationImage() %>">
    <input type="hidden" name="oti1" value="<%= product.getoTouristImage1() %>">
    <input type="hidden" name="rti1" value="<%= product.getrTouristImage1() %>">
    <input type="hidden" name="oti2" value="<%= product.getoTouristImage2() %>">
    <input type="hidden" name="rti2" value="<%= product.getrTouristImage2() %>">
    <input type="hidden" name="oti3" value="<%= product.getoTouristImage3() %>">
    <input type="hidden" name="rti3" value="<%= product.getrTouristImage3() %>">
    <fieldset>
      <input placeholder="상품번호( ex: 일본 = jp, 오사카 = osk, 번호 = 01 / jposk01 )" type="text" name="num" tabindex="1" required autofocus value="<%= product.getProductNum()  %>">
    </fieldset>
    <fieldset>
      <input placeholder="상품명" type="text" name="title" tabindex="2" required value="<%= product.getProductName() %>">
    </fieldset>
       <fieldset>
      <%= product.getoBannerImage1() %> → <input type="file" name="bimg1">
    </fieldset>
      <fieldset>
      <%= product.getoBannerImage2() %> → <input type="file" name="bimg2" >
    </fieldset>
    <fieldset>
      <%= product.getoBannerImage3() %> → <input type="file" name="bimg3" >
    </fieldset>
    <fieldset>
      <input placeholder="국가( ex : 일본 )" type="text" name="coun" tabindex="4" required value="<%= product.getCountry() %>">
    </fieldset>
    <fieldset>
      <input placeholder="여행지명( ex : 오사카 )" type="text" name="des" tabindex="5" required value="<%= product.getDestination() %>">
    </fieldset>
     <fieldset id="filetd">
      <%= product.getoDestinationImage() %> → <input type="file" name="dimg" >
    </fieldset>
    <fieldset>
      <textarea placeholder="여행지소개( 1000 byte )" name="desinfo" tabindex="6" required><%= product.getDestinationInfo() %></textarea>
    </fieldset>
    <fieldset>
      <input placeholder="관광지명1" type="text" name="ts1" tabindex="7" required value="<%= product.getTouristSpot1() %>">
    </fieldset>
    <fieldset>
      <%= product.getoTouristImage1() %> → <input type="file" name="timg1" >
    </fieldset>
    <fieldset>
      <textarea placeholder="관광지소개1( 1000 byte )" name="ts1info" tabindex="8" required><%= product.getTouristSpot1Info() %></textarea>
    </fieldset>
    <fieldset>
      <input placeholder="관광지명2" type="text" name="ts2" tabindex="9" required value="<%= product.getTouristSpot2() %>">
    </fieldset>
    <fieldset>
      <%= product.getoTouristImage2() %> →<input type="file" name="timg2" >
    </fieldset>
    <fieldset>
      <textarea placeholder="관광지소개2( 1000 byte )" name="ts2info" tabindex="10" required><%= product.getTouristSpot2Info() %></textarea>
    </fieldset>
    <fieldset>
      <input placeholder="관광지명3" type="text" name="ts3" tabindex="11" required value="<%= product.getTouristSpot3() %>">
    </fieldset>
    <fieldset>
      <%= product.getoTouristImage3() %> → <input type="file" name="timg3" >
    </fieldset>
    <fieldset>
      <textarea placeholder="관광지소개3( 1000 byte )" name="ts3info" tabindex="12" required><%= product.getTouristSpot3Info() %></textarea>
    </fieldset>
    <fieldset>
    	<select name="rp">
    		<option value="Y">추천상품O</option>
    		<option value="N" selected>추천상품X</option>
    	</select>  
      <button name="submit" type="submit" id="contact-submit" data-submit="...Sending" >수정하기</button>
      <button type="submit" onclick="location.href='javascript:history.go(-1)';">뒤로가기</button>
    </fieldset>
  </form>
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
          <a class="btn btn-primary" href="/travelduo/index.jsp">Logout</a>
        </div>
      </div>
    </div>
  </div>

  
  
</body>
</html>