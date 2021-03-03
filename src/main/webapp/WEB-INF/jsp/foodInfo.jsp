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
    <link rel="stylesheet" href="/static/css/showStar.css">
    <link rel="stylesheet" href="/static/css/comment.css">


      <style>
          .praiseLike{ font-size:66px;  color:#ccc; cursor:pointer;}
          .collectLike{ font-size:66px;  color:#ccc; cursor:pointer;}
          .cs{color:#f00;}
      </style>

  </head>
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
            <li class="probootstrap-animate active" data-animate-effect="fadeInLeft"><a href="/toIndex">首页</a></li>
            <li class="probootstrap-animate" data-animate-effect="fadeInLeft"><a href="/toIndex">美食推荐</a></li>
            <li class="probootstrap-animate" data-animate-effect="fadeInLeft"><a href="/toAddFood">上传美食</a></li>
            <li class="probootstrap-animate" data-animate-effect="fadeInLeft"><a href="/getAllFoodByUid">我的美食</a></li>
            <li class="probootstrap-animate" data-animate-effect="fadeInLeft"><a href="/toContact">关于我们</a></li>
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
            <p class="mb-5"><img src="${foodInfo.image}" alt="Free Bootstrap 4 Template by sc.chinaz.com" class="img-fluid"></p>

            <div class="row">
              <div class="col-xl-8 col-lg-12 mx-auto">
                <div style="border-radius: 5px;background-color: #ced2db"></div>
                <c:if test="${empty(praise)}">
                  <p style="float: left;margin-left: 60%;" class="praiseLike">&#10084;&nbsp;</p>
                </c:if>
                <c:if test="${!empty(praise)}">
                  <p style="float: left;margin-left: 60%;" class="praiseLike cs">&#10084;&nbsp;</p>
                </c:if>
                <c:if test="${empty(collect)}">
                  <p class="collectLike">&#9733;</p>
                </c:if>
                <c:if test="${!empty(collect)}">
                  <p class="collectLike cs">&#9733;</p>
                </c:if>
                <h1 class="mb-5">${foodInfo.fname}</h1>
                 <p>菜系：${foodInfo.cname}</p>
                <div class="star">
                  <span>推荐星级：</span>
                  <c:forEach begin="1" end="${foodInfo.star}" step="1" varStatus="cnt">
                    <input type="radio" id="rate${cnt.count}" name="star" value="${cnt.count}">
                    <label for="rate${cnt.count}" title="${foodInfo.star}星"></label>
                  </c:forEach>
                </div>

                <p>美食介绍：${foodInfo.fname}</p>
              <%--                <p>When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrove, the headline of Alphabet Village and the subline of her own road, the Line Lane. Pityful a rethoric question ran over her cheek, then she continued her way.</p>  --%>
              </div>
            </div>
            
          </div>
        </div>
        <!-- END row -->

        <section class="probootstrap-section">
          <div class="comments">

            <div class="comment-wrap">
                <div class="photo">
                    <div class="avatar" style="background-color: azure"></div>

                <%--                <div class="avatar" style="background-image: url('/assets/coolboy.jpg')"></div>--%>
                </div>
                <div class="comment-block">
                  <form name="addcomment" action="/saveComment">
                    <input type="hidden" name="fid" value="${foodInfo.fid}">
                    <textarea name="content" id="" cols="30" rows="3" placeholder="说两句吧..."></textarea>
                  </form>
                </div>
            </div>
              <div class="form-group" style="margin-left: 87%;">
                  <input type="button" onClick="addcomment.submit()" class="btn btn-primary" id="submit" name="submit" value="提交评论">
              </div>


              <c:forEach items="${commentList}" var="comment" varStatus="s">
                <div class="comment-wrap">
                    <div class="photo">
                      <div class="avatar" style="background-image: url('${comment.image}')"></div>
<%--                      <div class="avatar" style="background-color: azure"></div>--%>
                    </div>
                    <div class="comment-block">
                      <p class="comment-text">${comment.content}</p>
                      <div class="bottom-comment">
                          <c:if test="${foodInfo.uid == comment.uid}">
                              <em>(作者)</em>
                          </c:if>
                          <div class="comment-date">${comment.username}</div>
                          <div class="comment-actions">${comment.createTime}</div>
                      </div>
                    </div>
                </div>
              </c:forEach>
              <c:if test="${empty(commentList)}">
                <div class="fly-none" style="align-content: center;">我来占沙发</div>
              </c:if>

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



    <script src="/static/js/jquery-3.2.1.min.js"></script>
    <script src="/static/js/popper.min.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <script src="/static/js/owl.carousel.min.js"></script>
    <script src="/static/js/jquery.waypoints.min.js"></script>
    <script src="/static/js/imagesloaded.pkgd.min.js"></script>

    <script src="/static/js/main.js"></script>
    <script>
        $(function () {
            $(".praiseLike").click(function () {
              let name = $(this).attr("class");
                if(name.indexOf("cs") != -1){
                  $.ajax({
                    type:"POST",
                    url:"/deletePraise?uid=0&fid="+${foodInfo.fid},
                    dataType:"json",
                    success:function(data){
                      if(data=='0'){

                      }else{
                        alert("取消点赞失败,请重试")
                        return ;
                      }
                    },
                    error:function(){
                      alert("取消点赞失败,请重试")
                      return ;
                    }
                  });
                }else{
                  $.ajax({
                    type:"POST",
                    url:"/savePraise?uid=0&fid="+${foodInfo.fid},
                    dataType:"json",
                    success:function(data){
                      if(data=='0'){

                      }else{
                        alert("点赞失败,请重试")
                        return ;
                      }
                    },
                    error:function(){
                      alert("点赞失败,请重试")
                      return ;
                    }
                  });
                }
                $(this).toggleClass('cs');
            });
          $(".collectLike").click(function () {
            let name = $(this).attr("class");
            if(name.indexOf("cs") != -1){
              //包含,调用删除接口
              $.ajax({
                type:"POST",
                url:"/deleteCollect?uid=0&fid="+${foodInfo.fid},
                dataType:"json",
                success:function(data){
                  if(data=='0'){
                  }else{
                    alert("取消收藏失败,请重试")
                    return ;
                  }
                },
                error:function(){
                  alert("取消收藏失败,请重试")
                  return ;
                }
              });
            }else{
              //不包含,调用新增接口
              $.ajax({
                type:"POST",
                url:"/saveCollect?uid=0&fid="+${foodInfo.fid},
                dataType:"json",
                success:function(data){
                  if(data=='0'){
                  }else{
                    alert("收藏失败,请重试")
                    return ;
                  }
                },
                error:function(){
                  alert("收藏失败,请重试")
                  return ;
                }
              });
            }
            $(this).toggleClass('cs');
          })
        })
    </script>
  </body>
</html>