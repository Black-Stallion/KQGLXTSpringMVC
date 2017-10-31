<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>外出单管理</title>
<meta name="Copyright" content="Douco Design." />
<link href="css/public.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/global.js"></script>

<script type="text/javascript">
	function check() {
		return true;
	}
	function button_onclick() {

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
			<a class="navbar-brand" href="jsp/main.jsp">考勤管理系统</a>
		</div>
		<!-- /.navbar-header -->
		<ul class="nav navbar-nav navbar-right">
			<li class="dropdown"><a href="#" class="dropdown-toggle avatar"
				data-toggle="dropdown"><img src="images/1.png"><span
					class="badge"></span></a>
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
					<li class="m_2"><a
						href="login/adminupdate?param=adminupdate&adminId=${adminID }"><i
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
									<li><a href="jsp/AttendanceCollect.jsp">考勤汇总</a></li>
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
							<li><a href="login/exit/ex">退出系统</a></li>
							<li><a href="login/update?param=updateP&adminId=${adminID }">修改密码</a>
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
						考勤系统<b>></b><strong>单据管理</strong><b>></b><strong>外出单管理</strong>
					</h2>
					<div class="panel-ctrls" data-actions-container=""
						data-action-collapse="{&quot;target&quot;: &quot;.panel-body&quot;}">
						<span class="button-icon has-bg"><i
							class="ti ti-angle-down"></i></span>
					</div>
				</div>
				<div class="panel-body no-padding" style="display: block;">
					<form id="form1" name="form1" method="post" action="">
						<table class="table table-bordered">
							<tr>
								<td>是否通过审核：</td>
								<td><select>
										<option>所有</option>
										<option>是</option>
										<option>否</option>
								</select></td>
							</tr>
							<tr>
								<td>请假类型：</td>
								<td><select>
										<option>所有</option>
										<option>事假</option>
										<option>婚假</option>
										<option>病假</option>
								</select></td>
							</tr>
							<tr>
								<td>选择部门：</td>
								<td><select>
										<option>一级部门</option>
										<option>人事部</option>
										<option>财务部</option>
								</select> &nbsp;&nbsp;&nbsp; <select>
										<option>二级部门</option>
										<option>人事部</option>
										<option>财务部</option>
								</select></td>
							</tr>
							<tr>
								<td>填写时间：</td>
								<td><input type="text" /></td>
							</tr>
							<tr>
								<td>选择员工：</td>
								<td><input type="text" /></td>
							</tr>
							<tr>
								<td>代理人：</td>
								<td><input type="text" /></td>
							</tr>
							<tr>
								<td>开始结束日期中包含：</td>
								<td><input type="text" /></td>
							</tr>
							<tr>
								<td colspan="2"><input class="btn btn-info" type="submit"
									value="查询" /></td>
							</tr>

						</table>
					</form>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h2>外出单列表</h2>
					<h2 align="right">
						<a class="btn btn-info" href="notes/OutgoingAdd.jsp"
							style="color: white;">添加</a>
					</h2>
				</div>
				<div class="panel-body">
					<div class="table-responsive">
						<table width="100%" border="0" cellpadding="8" cellspacing="0"
							class="table table-striped table-bordered table-hover">
							<tr>
								<th>编号</th>
								<th>填写时间</th>
								<th>申请人</th>
								<th>起始时间</th>
								<th>结束时间</th>
								<th>代理人</th>
								<th>是否通过审核</th>
								<th colspan="2">操作</th>
							</tr>

							<tr>
								<td>230</td>
								<td>2017-02-27 09:30</td>
								<td>尹跃强</td>
								<td>2017-02-27 12:00</td>
								<td>2017-03-02 08:30</td>
								<td></td>
								<td>是</td>
								<td><a href="jsp/OutgoingEdit.jsp">修改</a> | <a
									href="product_category.php?rec=del&cat_id=4">删除</a></td>
							</tr>
							<tr>
								<td>191</td>
								<td>2017-02-27 09:30</td>
								<td>李艳霞</td>
								<td>2017-02-27 12:00</td>
								<td>2017-03-02 08:30</td>
								<td>顾伟鹏</td>
								<td>是</td>
								<td><a href="jsp/OutgoingEdit.jsp">修改</a> | <a
									href="product_category.php?rec=del&cat_id=4">删除</a></td>
							</tr>
							<tr>
								<td>157</td>
								<td>2017-02-27 09:30</td>
								<td>梁华</td>
								<td>2017-02-27 12:00</td>
								<td>2017-03-02 08:30</td>
								<td></td>
								<td>是</td>
								<td><a href="jsp/OutgoingEdit.jsp">修改</a> | <a
									href="product_category.php?rec=del&cat_id=4">删除</a></td>
							</tr>
							<tr>
								<td>147</td>
								<td>2017-02-27 09:30</td>
								<td>孙少飞</td>
								<td>2017-02-27 12:00</td>
								<td>2017-03-02 08:30</td>
								<td></td>
								<td>是</td>
								<td><a href="notes/OutgoingEdit.jsp">修改</a> | <a
									href="product_category.php?rec=del&cat_id=4">删除</a></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
