<%@page contentType="text/html; charset=UTF-8" language="java" import="java.util. *" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" >
<head>
<meta charset="UTF-8">
<title>Bootstrap登录注册表单代码 - 站长素材</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<!--图标库-->
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css'>

<!--响应式框架-->
<link rel='stylesheet' href='/static/css/bootstrap.min.css'>

<!--主要样式-->
<link rel="stylesheet" href="/static/css/style1.css">

</head>
<body>
  
<div class="container">

	<div class="card-wrap">
		
		<div class="card border-0 shadow card--login is-show" id="login">
			<div class="card-body">
				<h2 class="card-title">欢迎登录！</h2>
				<p>用登录名登录</p>
				<form action="${pageContext.request.contextPath}/login">
					<div class="form-group">
						<input class="form-control" type="text" name="username" value="请输入你的账号" placeholder="账号" required="required">
					</div>
					<div class="form-group">
						<input class="form-control" type="password" name="password" value="请输入你的密码" placeholder="密码" required="required">
					</div>
					<p><a href="#">忘记密码?</a></p>
					<button class="btn btn-lg" id="login">登录</button>
				</form>
			</div>
			<button class="btn btn-back js-btn" data-target="welcome"><i class="fas fa-angle-left"></i></button>
		</div>
		
	</div>
	
</div>
<script type="text/javascript">
</script>
</body>
</html>