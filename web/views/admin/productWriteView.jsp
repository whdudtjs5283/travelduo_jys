<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  background: #43A047;
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
  <form id="contact" action="/travelduo/pwrite" method="post" enctype="multipart/form-data">
    <h3>상품 등록하기</h3>
    <fieldset>
      <input placeholder="상품번호( ex: 일본 = jp, 오사카 = osk, 번호 = 01 / jposk01 )" type="text" name="num" tabindex="1" required autofocus>
    </fieldset>
    <fieldset>
      <input placeholder="상품명" type="text" name="title" tabindex="2" required>
    </fieldset>
       <fieldset>
      배너 이미지1 : <input type="file" name="bimg1" >
    </fieldset>
      <fieldset>
      배너 이미지2 : <input type="file" name="bimg2" >
    </fieldset>
    <fieldset>
      배너 이미지3 : <input type="file" name="bimg3" >
    </fieldset>
    <fieldset>
      <input placeholder="국가( ex : 일본 )" type="text" name="coun" tabindex="4" required >
    </fieldset>
    <fieldset>
      <input placeholder="여행지명( ex : 오사카 )" type="text" name="des" tabindex="5" required >
    </fieldset>
     <fieldset>
      여행지 소개 이미지 : <input type="file" name="dimg" >
    </fieldset>
    <fieldset>
      <textarea placeholder="여행지소개( 1000 byte )" name="desinfo" tabindex="6" required></textarea>
    </fieldset>
    <fieldset>
      <input placeholder="관광지명1" type="text" name="ts1" tabindex="7" required >
    </fieldset>
    <fieldset>
      관광지1 소개 이미지 : <input type="file" name="timg1" >
    </fieldset>
    <fieldset>
      <textarea placeholder="관광지소개1( 1000 byte )" name="ts1info" tabindex="8" required></textarea>
    </fieldset>
    <fieldset>
      <input placeholder="관광지명2" type="text" name="ts2" tabindex="9" required>
    </fieldset>
        <fieldset>
      관광지2 소개 이미지 : <input type="file" name="timg2" >
    </fieldset>
    <fieldset>
      <textarea placeholder="관광지소개2( 1000 byte )" name="ts2info" tabindex="10" required></textarea>
    </fieldset>
    <fieldset>
      <input placeholder="관광지명3" type="text" name="ts3" tabindex="11" required>
    </fieldset>
    <fieldset>
      관광지3 소개 이미지 : <input type="file" name="timg3" >
    </fieldset>
    <fieldset>
      <textarea placeholder="관광지소개3( 1000 byte )" name="ts3info" tabindex="12" required></textarea>
    </fieldset>
    <fieldset>
    	<select name="rp">
    		<option value="Y">추천상품O</option>
    		<option value="N" selected>추천상품X</option>
    	</select>  
      <button name="submit" type="submit" id="contact-submit" data-submit="...Sending" >등록하기</button>
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