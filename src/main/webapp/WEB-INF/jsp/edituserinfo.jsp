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
    <link rel="stylesheet" href="/static/css/uploadImage.css">
    <link rel="stylesheet" href="/static/css/star.css">

  </head>
  <body>
    
    <aside class="probootstrap-aside js-probootstrap-aside">
      <a href="#" class="probootstrap-close-menu js-probootstrap-close-menu d-md-none"><span class="oi oi-arrow-left"></span> Close</a>
      <div class="probootstrap-site-logo probootstrap-animate" data-animate-effect="fadeInLeft">

        <a href="${pageContext.request.contextPath}/toEditUserInfo" class="mb-2 d-block probootstrap-logo">完善个人信息</a>
          <c:if test="${user1!=null}">
              <p class="mb-0"><img style="height: 30px ;width: 30px" src="${pageContext.request.contextPath}/static/${user1.image}" />
                  <a href="${pageContext.request.contextPath}/#" target="_blank">欢迎 ${user1.username} !</a></p>
          </c:if>
          <c:if test="${user1==null}">
              <p class="mb-0"><a href="/toLogin" target="_blank" >登录</a> / <a href="/toRegist" target="_blank">注册</a></p>
          </c:if>
      </div>
      <div class="probootstrap-overflow">
        <nav class="probootstrap-nav">
          <ul>
            <li class="probootstrap-animate" data-animate-effect="fadeInLeft"><a href="#">首页</a></li>
            <li class="probootstrap-animate" data-animate-effect="fadeInLeft"><a href="#">美食推荐</a></li>
            <li class="probootstrap-animate active" data-animate-effect="fadeInLeft"><a href="/toAddFood">上传美食</a></li>
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
      <div class="probootstrap-bar">
        <a href="#" class="probootstrap-toggle js-probootstrap-toggle"><span class="oi oi-menu"></span></a>
        <div class="probootstrap-main-site-logo"><a href="index.jsp">Aside</a></div>
      </div>
      <div class="container-fluid">
        <div class="row justify-content-center">
          <div class="col-xl-8 col-lg-12">
            <div class="row">
              <div class="col-xl-8 col-lg-12 mx-auto">
                <h1 class="mb-3">个人信息</h1>
                <form action="${request.contextPath}/saveFood" method="post" enctype="multipart/form-data" class="probootstrap-form mb-5">


                  <div class="form-group">
                    <%--@declare id="fname"--%><label for="fname">用户名</label>
                    <input type="text" class="form-control" id="username" name="username" value="${user1.username}">
                  </div>
                    <div class="form-group">
                        <label for="fname">联系方式</label>
                        <input type="text" class="form-control" id="phone" name="username" value="${user1.phone}">
                    </div>
                    <div class="form-group">
                        <label for="fname">性别</label>
                        <input type="text" class="form-control" id="sex" name="username" value="${user1.sex}">
                    </div>
                    <div class="form-group">
                        <label for="fname">生日</label>
                        <input type="text" class="form-control" id="birthday" name="username" value="${user1.birthday}">
                    </div>
                    <div class="form-group">
                        <label for="fname">头像</label>
                        <input type="text" class="form-control" id="head" name="username" value="${user1.sex}">
                    </div>
                  <div class="form-group">
                    <input type="submit" class="btn btn-primary" id="submit" name="submit" value="确认提交信息">
                  </div>
                </form>
               
              </div>
            </div>
            
          </div>
        </div>
        <!-- END row -->

          </div>
        </section>
        <!-- END section -->

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

    <script>
      //图片回显
      document.querySelector('#myFile').onchange=function () {
        var read = new FileReader()
        read.readAsDataURL(this.files[0])
        read.onload = function () {
          url = read.result
          document.querySelector('#image').src = url
        }
      }
    </script>
    
    
  </body>
</html>