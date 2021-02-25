<%@page contentType="text/html; charset=UTF-8" language="java" import="java.util. *" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Free HTML5 Website Template by sc.chinaz.com" />
    <meta name="keywords" content="" />
    <meta name="author" content="sc.chinaz.com" />

    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/open-iconic-bootstrap.min.css">

    <link rel="stylesheet" href="/static/css/owl.carousel.min.css">
    <link rel="stylesheet" href="/static/css/owl.theme.default.min.css">

    <link rel="stylesheet" href="/static/css/icomoon.css">
    <link rel="stylesheet" href="/static/css/animate.css">
    <link rel="stylesheet" href="/static/css/style.css">


  </head>
  <style>
    .star{
      display: block;
      position: relative;
      /*width: 150px;*/
      height: 60px;
      padding: 0;
      border: none;
    }

    .star > input{
      position: absolute;
      margin-right: -100%;
      opacity: 0;
      /*float: left;*/
    }

    .star > label{
      position: relative;
      display: inline-block;
      float: left;
      width: 30px;
      height: 30px;
      color: transparent;
      background-image: url("/static/images/star.png");
      background-repeat: no-repeat;
      background-position: 0 -30px;
    }

    .star > span{
      float: left;
    }


    .star > input:focus + label{
      outline: none;
    }

    .star > input:focus~label
  </style>
  <body>
    <aside class="probootstrap-aside js-probootstrap-aside">
      <a href="#" class="probootstrap-close-menu js-probootstrap-close-menu d-md-none"><span class="oi oi-arrow-left"></span> Close</a>
      <div class="probootstrap-site-logo probootstrap-animate" data-animate-effect="fadeInLeft">
        
        <a href="index.jsp" class="mb-2 d-block probootstrap-logo">美食分享</a>
        <p class="mb-0"><a href="login.HTML" target="_blank">登录</a> / <a href="regist.jsp" target="_blank">注册</a></p>
      </div>
      <div class="probootstrap-overflow">
        <nav class="probootstrap-nav">
          <ul>
            <li class="probootstrap-animate active" data-animate-effect="fadeInLeft"><a href="#">首页</a></li>
            <li class="probootstrap-animate" data-animate-effect="fadeInLeft"><a href="#">美食推荐</a></li>
            <li class="probootstrap-animate" data-animate-effect="fadeInLeft"><a href="/toAddFood">上传美食</a></li>
            <li class="probootstrap-animate" data-animate-effect="fadeInLeft"><a href="portfolio.jsp">我的美食</a></li>
            <li class="probootstrap-animate" data-animate-effect="fadeInLeft"><a href="contact.jsp">关于我们</a></li>
          </ul>
        </nav>
        <footer class="probootstrap-aside-footer probootstrap-animate" data-animate-effect="fadeInLeft">
          <ul class="list-unstyled d-flex probootstrap-aside-social">
            <li><a href="#" class="p-2"><span class="icon-twitter"></span></a></li>
            <li><a href="#" class="p-2"><span class="icon-instagram"></span></a></li>
            <li><a href="#" class="p-2"><span class="icon-dribbble"></span></a></li>
          </ul>
          <p>&copy; 2017 <a href="https://sc.chinaz.com/" target="_blank">sc.chinaz.com</a>. <br> All Rights Reserved.</p>
        </footer>
      </div>
    </aside>


    <main role="main" class="probootstrap-main js-probootstrap-main">
      <form action="${request.contextPath}/getFoodByCidAndFname" method="post" class="probootstrap-form mb-5">
        <div class="row">
          <div class="form-group">
            <select class="form-control" id="ftype" name="cid" style="height: 55px;">
              <option value="0">全部</option>
              <c:forEach items="${categoryList}" var="category" varStatus="c">
                <c:if test="${cid == category.cid}">
                  <option value="${category.cid}" selected="selected">${category.cname}</option>
                </c:if>
                <c:if test="${cid != category.cid}">
                  <option value="${category.cid}">${category.cname}</option>
                </c:if>
              </c:forEach>
            </select>
          </div>
          <div class="form-group">
            <input type="text" style="width: 350px;" value="${fname}" class="form-control" id="fname" name="fname">
          </div>
          <div class="form-group">
            <input type="submit" style="height: 55px;" class="btn btn-primary" id="submit" name="submit" value="搜索">
          </div>
        </div>
      </form>
      <div class="probootstrap-bar">
        <a href="#" class="probootstrap-toggle js-probootstrap-toggle"><span class="oi oi-menu"></span></a>
        <div class="probootstrap-main-site-logo"><a href="index.jsp">Aside</a></div>
      </div>
      <div class="card-columns" style="margin-top: 30px;">
        <c:forEach items="${foodList}" var="food" varStatus="s">
        <div class="card">
          <a href="single.jsp">
            <img class="card-img-top probootstrap-animate" src="${food.image}" alt="Card image cap">
          </a>
          <p>美食名称：${food.fname}</p>
<%--          <p STYLE="color: yellowgreen">发布者：sadasdasdasd</p>--%>
          <p STYLE="color: yellowgreen">发布者：sadasdasdasd</p>
          <p>美食分类：asdasd</p>
          <div class="star">
            <span>推荐星级：</span>
            <c:forEach begin="1" end="${food.star}" step="1" varStatus="cnt">
              <input type="radio" id="rate${cnt.count}" name="star" value="${cnt.count}">
              <label for="rate${cnt.count}" title="${food.star}星"></label>
            </c:forEach>
          </div>
        </div>
        </c:forEach>
      </div>


      <div class="container-fluid d-md-none">
        <div class="row">
          <div class="col-md-12">
            <ul class="list-unstyled d-flex probootstrap-aside-social">
              <li><a href="#" class="p-2"><span class="icon-twitter"></span></a></li>
              <li><a href="#" class="p-2"><span class="icon-instagram"></span></a></li>
              <li><a href="#" class="p-2"><span class="icon-dribbble"></span></a></li>
            </ul>
            <p>Copyright &copy; 2018.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
          </div>
        </div>
      </div>

    </main>



    <script src="/static/js/jquery-3.2.1.slim.min.js"></script>
    <script src="/static/js/popper.min.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <script src="/static/js/owl.carousel.min.js"></script>
    <script src="/static/js/jquery.waypoints.min.js"></script>
    <script src="/static/js/imagesloaded.pkgd.min.js"></script>

    <script src="/static/js/main.js"></script>
    
  </body>
</html>