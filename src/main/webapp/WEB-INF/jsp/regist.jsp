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

	<link rel='stylesheet' href='/static/css/bootstrap.min.css'>
	<link rel="stylesheet" href="/static/css/style1.css">

</head>
<body>
  
<div class="container">

	<div class="card-wrap">
	
		<div class="card border-0 shadow card--register is-show" id="register">
			<div class="card-body">
				<h2 class="card-title">会员注册</h2>
				<p>使用您的电子邮箱进行注册</p>
				<form>
					<div class="form-group">
						<input class="form-control" type="text" placeholder="用户名" required="required">
					</div>
<!--					<div class="form-group">
						<input class="form-control" type="email" placeholder="邮箱" required="required">
					</div>-->
					<div class="form-group">
						<input class="form-control" type="password" placeholder="密码" required="required">
					</div>
					<button class="btn btn-lg">注册</button>
				</form>
			</div>
			<button class="btn btn-back js-btn" data-target="welcome"><i class="fas fa-angle-left"></i></button>
		</div>
		
	</div>
	
</div>

</body>
</html>