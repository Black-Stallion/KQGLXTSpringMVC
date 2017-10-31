<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>考勤管理系统登录页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/supersized.css">
<link rel="stylesheet" href="css/login.css">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	<script src="js/html5.js"></script>
	<![endif]-->
<script src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript" src="js/tooltips.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<link href="css/bootstrap.css" rel="stylesheet" />
<link href="css/font-awesome.css" rel="stylesheet" />
<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
</head>
<body>
	<div class="container">
		<div class="row text-center " style="padding-top: 20%;">
			<div class="col-md-12">
				<img src="images/logo.png" />
			</div>
		</div>
		<div class="row ">
			<div
				class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
				<div class="panel-body">
					<form action="login/KQGLXT/main" id="login_form" method="post">
						<div class="form-group input-group">
							<span class="input-group-addon">用户名:</span> <input type="text"
								class="form-control" name="adminAccount" id="adminAccount"
								placeholder="请输入用户名 " value="${account }"/>
						</div>
						<div class="form-group input-group" style="height: 4%;"></div>
						<div class="form-group input-group">
							<span class="input-group-addon">密&nbsp;&nbsp;&nbsp;&nbsp;码:</span>
							<input type="password" name="adminPwd" id="adminPwd"
								class="form-control" placeholder="请输入密码" value="${pwd }"/>
						</div>
						<div class="form-group input-group" style="height: 2%;">
							<label for="j_password" class="t"></label> <label
								style="color: red">${error }</label>
						</div>
						<div class="form-group space">
							<div class="form-group"></div>
							<center>
							<label class="t" style="margin-lef:20%"></label>
							<button type="button" id="submit_btn"
								class="btn btn-primary btn-lg">&nbsp;登&nbsp;录&nbsp;</button>
							<input type="reset" style="margin-left:15%"
								value="&nbsp;重&nbsp;置&nbsp;" class="btn btn-default btn-lg">
								</center>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="js/supersized.3.2.7.min.js"></script>
	<script src="js/supersized-init.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>