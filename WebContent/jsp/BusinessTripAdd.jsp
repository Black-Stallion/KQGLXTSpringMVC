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

<title>出差单添加</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/public.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script>
addEventListener("load", function() {
	setTimeout(hideURLbar, 0);
}, false);
function hideURLbar() {
	window.scrollTo(0, 1);
}
</script>
<script src="js/bootstrap.min.js"></script>
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Graph CSS -->
<link href="css/lines.css" rel='stylesheet' type='text/css' />
<link href="css/font-awesome.css" rel="stylesheet">
<!----webfonts--->
<link
	href='http://fonts.useso.com/css?family=Roboto:400,100,300,500,700,900'
	rel='stylesheet' type='text/css'>
<!---//webfonts--->
<!-- Nav CSS -->
<link href="css/custom.css" rel="stylesheet">
<!-- Metis Menu Plugin JavaScript -->
<script src="js/metisMenu.min.js"></script>
<script src="js/custom.js"></script>
<!-- Graph JavaScript -->
<script src="js/d3.v3.js"></script>
<script src="js/rickshaw.js"></script>
</head>

<body>
	<div id="wrapper">
		<nav class="top1 navbar navbar-default navbar-static-top"
			role="navigation" style="margin-bottom: 0">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.html">考勤管理系统</a>
		</div>
		<!-- /.navbar-header -->
		<ul class="nav navbar-nav navbar-right">
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown" aria-expanded="false"><i
					class="fa fa-comments-o"></i><span class="badge">4</span></a>
				<ul class="dropdown-menu">
					<li class="dropdown-menu-header"><strong>Messages</strong>
						<div class="progress thin">
							<div class="progress-bar progress-bar-success" role="progressbar"
								aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
								style="width: 40%">
								<span class="sr-only">40% Complete (success)</span>
							</div>
						</div></li>
					<li class="avatar"><a href="#"> <img src="images/2.png"
							alt="" />
							<div>考勤公告</div> <small>1 minute ago</small> <span
							class="label label-info">NEW</span>
					</a></li>
					<li class="avatar"><a href="#"> <img src="images/3.png"
							alt="" />
							<div>出差申请</div> <small>5 minute ago</small>
					</a></li>
					<li class="avatar"><a href="#"> <img src="images/4.png"
							alt="" />
							<div>调休申请</div> <small>4 minute ago</small>
					</a></li>
					<li class="avatar"><a href="#"> <img src="images/5.png"
							alt="" />
							<div>请假申请</div> <small>7 minute ago</small>
					</a></li>
					<li class="dropdown-menu-footer text-center"><a href="#">所以消息通知</a>
					</li>
				</ul></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle avatar"
				data-toggle="dropdown"><img src="images/1.png"><span
					class="badge">9</span></a>
				<ul class="dropdown-menu">

					<li class="m_2"><i class="fa fa-user"></i>您好！ <c:choose>
							<c:when test="${adminRight==0}">
								考勤员
								</c:when>
							<c:otherwise>
								管理员
								</c:otherwise>
						</c:choose>,${adminName }</a></li>
					<li class="divider"></li>
					<li class="dropdown-menu-header text-center"><strong>账号业务</strong>
					</li>
					<li class="m_2"><a href="#"><i class="fa fa-bell-o"></i>
							更新信息 </a></li>
					<li class="m_2"><a
						href="login/adminupdate?param=adminupdate&adminId=${adminID }""><i
							class="fa fa-shield"></i> 修改密码 </a></li>
					<li class="m_2"><a href="login/exit/ex"><i
							class="fa fa-lock"></i> 退出系统 </a></li>

					<li class="dropdown-menu-header text-center"><strong>系统业务</strong>
					</li>
					<c:choose>
						<c:when test="${adminRight==1}">
							<li class="m_2"><a href="jsp/DepartmentList.jsp"><i
									class="fa fa-file"></i> 部门管理</a></li>
							<li class="m_2"><a href="jsp/PositionList.jsp"><i
									class="fa fa-wrench"></i> 职务管理</a></li>
							<li class="m_2"><a href="jsp/AttendanceCategoryManage.jsp"><i
									class="fa fa-usd"></i> 出勤类别管理</a></li>
							<li class="m_2"><a href="jsp/EmployeeList.jsp"><i
									class="fa fa-user"></i> 员工管理</a></li>
						</c:when>
						<c:otherwise>
							<li class="m_2"><a href="jsp/TodayAttendance.jsp"><i
									class="fa fa-user"></i> 今日考勤</a></li>
							<li class="m_2"><a href="#"><i class="fa fa-wrench"></i>
									考勤公告</a></li>
							<li class="m_2"><a href="#"><i class="fa fa-usd"></i>
									考勤查询</a></li>
							<li class="m_2"><a href="jsp/AttendanceCollect.jsp"><i
									class="fa fa-file"></i> 考勤汇总</a></li>
							<li class="divider"></li>
							<li class="m_2"><a href="jsp/LeaveList.jsp"><i
									class="fa fa-user"></i> 请假单管理</a></li>
							<li class="m_2"><a href="jsp/ShiftHolidaysNoteList.jsp"><i
									class="fa fa-wrench"></i> 调休单管理</a></li>
							<li class="m_2"><a href="jsp/OvertimeList.jsp"><i
									class="fa fa-usd"></i> 加班单管理</a></li>
							<li class="m_2"><a href="jsp/BusinessTripList.jsp"><i
									class="fa fa-file"></i> 出差单管理</a></li>
						</c:otherwise>
					</c:choose>
				</ul></li>
		</ul>
		<!--  -->
		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					<li><a href="jsp/main.jsp"><i
							class="fa fa-dashboard fa-fw nav_icon"></i>系统首页</a></li>
					<c:choose>
						<c:when test="${adminRight==1}">
							<li><a href="#"><i class="fa fa-laptop nav_icon"></i>基本设置<span
									class="fa arrow"></span></a>
								<ul class="nav nav-second-level">
									<li><a href="jsp/DepartmentList.jsp">部门管理</a></li>
									<li><a href="jsp/PositionList.jsp">职务管理</a></li>
									<li><a href="jsp/AttendanceCategoryManage.jsp">出勤类别管理</a>
									</li>
									<li><a href="jsp/EmployeeList.jsp">员工管理</a></li>
								</ul></li>
						</c:when>
						<c:otherwise>
							<li><a href="#"><i class="fa fa-indent nav_icon"></i>考勤管理<span
									class="fa arrow"></span></a>
								<ul class="nav nav-second-level">
									<li><a href="jsp/TodayAttendance.jsp">今日考勤</a></li>
									<li><a href="nav.html">考勤公告</a></li>
									<li><a href="jsp/AttendanceCollect.jsp">考勤汇总</a></li>
									<li><a href="page.html">考勤查询</a></li>
								</ul></li>
							<li><a href="#"><i class="fa fa-table nav_icon"></i>单据管理<span
									class="fa arrow"></span></a>
								<ul class="nav nav-second-level">
									<li><a href="jsp/LeaveList.jsp">请假单管理</a></li>
									<li><a href="jsp/OvertimeList.jsp">加班单管理</a></li>
									<li><a href="jsp/ShiftHolidaysNoteList.jsp">倒休单管理</a></li>
									<li><a href="jsp/BusinessTripList.jsp">出差单管理</a></li>
								</ul></li>
						</c:otherwise>
					</c:choose>
					<li><a href="#"><i class="fa fa-sitemap fa-fw nav_icon"></i>退出/修改<span
							class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="NoteServlet/exit">退出系统</a></li>
							<li><a href="NoteServlet/adminupdate?adminId=${adminID }">修改密码</a>
							</li>
						</ul> <!-- /.nav-second-level --></li>
				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		</nav>
		<div id="page-wrapper">
			<div class="panel panel-info"
				data-widget="{&quot;draggable&quot;: &quot;false&quot;}"
				data-widget-static="">
				<div class="panel-heading">
					<h2>
						考勤系统<b>></b><strong>单据管理</strong><b>></b><strong>出差单管理</strong><b>></b><strong>出差单添加</strong>
					</h2>
					<div class="panel-ctrls" data-actions-container=""
						data-action-collapse="{&quot;target&quot;: &quot;.panel-body&quot;}">
						<span class="button-icon has-bg"><i
							class="ti ti-angle-down"></i></span>
					</div>
				</div>
				<div class="panel-body no-padding" style="display: block;">
					<form action="" method="post">
						<table class="table table-bordered">
							<tr>
								<td><font style="color: red">*&nbsp;</font>出差负责人姓名：</td>
								<td><input type="text" /> <input class="actionBtn"
									type="button" value="选择负责人" name="btnSelect" id="btnSelect" />
								</td>
							</tr>
							<tr>
								<td><font style="color: red">*&nbsp;</font>出差人集合：</td>
								<td><input type="text" /> <input class="actionBtn"
									type="submit" value="选择出差人" name="btnSelect" id="btnSelect" />
								</td>
							</tr>
							<tr>
								<td><font style="color: red">*&nbsp;</font>填表日期：</td>
								<td><input type="text" /></td>
							</tr>
							<tr>
								<td>项目名称：</td>
								<td><input type="text" id="dname" name="dname" /></td>
							</tr>
							<tr>
								<td>交通工具：</td>
								<td><input class="selec" type="checkbox" value="0"
									id="Vehicle" name="Vehicle">火车 <input class="selec"
									type="checkbox" value="1" id="Vehicle" name="Vehicle">高客
									<input class="selec" type="checkbox" value="2" id="Vehicle"
									name="Vehicle">私车 <input class="selec" type="checkbox"
									value="3" id="Vehicle" name="Vehicle">公车 <input
									class="selec" type="checkbox" value="4" id="Vehicle"
									name="Vehicle">飞机</td>
							</tr>

							<tr>
								<td><font style="color: red">*&nbsp;</font>出差事由：</td>
								<td><textarea rows="5" cols="50"></textarea></td>
							</tr>
							<tr>
								<td><font style="color: red">*&nbsp;</font>起始时间：</td>
								<td><input type="text" value="2016-07-05" /> <select>
										<option value="">上午</option>
										<option value="">下午</option>
								</select></td>
							</tr>
							<tr>
								<td><font style="color: red">*&nbsp;</font>截止时间：</td>
								<td><input type="text" value="2016-07-05" /> <select>
										<option value="">上午</option>
										<option value="">下午</option>
								</select></td>
							</tr>

							<tr>
								<td>主管经理签名意见：</td>
								<td><textarea rows="5" cols="50"></textarea></td>
							</tr>

							<tr>
								<td><font style="color: red">*&nbsp;</font>是否审核通过：</td>
								<td><input class="cls_rad" type="radio" name="weekType"
									value="1" />通过 &nbsp; <input class="cls_rad" type="radio"
									name="weekType" value="0" />不通过</td>
							</tr>
							<tr>
								<td colspan="2" align="center"><input class="btn btn-info"
									type="submit" value="保存" name="btnSave" id="btnSave" /> <input
									class="btn btn-info" type="button" value="返回" /></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
