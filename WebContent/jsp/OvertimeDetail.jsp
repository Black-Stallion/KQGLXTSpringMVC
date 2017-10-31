<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>加班单明细</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link href="css/public.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<style>
</style>

<script type="text/javascript">
addEventListener("load", function() {
	setTimeout(hideURLbar, 0);
}, false);
function hideURLbar() {
	window.scrollTo(0, 1);
}
	$(function() {
		$("#btnAdd")
				.click(
						function() {
							var text = "<span><input type=\"date\" placeholder='YYYY-MM-DD' id=\"overtimeDate\" name=\"overtimeDate\" /> ";
							text = text
									+ "<select  id=\"overtimeFlag\" name=\"overtimeFlag\" >";
							text = text + "<option value=\"0\">上午</option>";
							text = text + "<option value=\"1\">下午</option>";
							text = text + "<option value=\"2\">晚上</option>";
							text = text + "</select>";
							text = text
									+ "<input type=\"button\" onclick=\"btnDelete_onclick(this)\" class=\"btn btn-info\" id=\"btnDelete\" name=\"btnDelete\" value=\"删除\" />";
							text = text + "<br/></span>";
							$("#divOverTime").append(text);
						});
	});

	function btnDelete_onclick(obj) {
		$(obj).parent().remove();
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
							<li class="m_2"><a href="jsp/OvertimeList.jsp"><i
									class="fa fa-usd"></i> 加班单管理</a></li>
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
						考勤系统<b>></b><strong>加班单管理</strong><b>></b><strong>添加加班单明细</strong>
					</h2>
					<div class="panel-ctrls" data-actions-container=""
						data-action-collapse="{&quot;target&quot;: &quot;.panel-body&quot;}">
						<span class="button-icon has-bg"><i
							class="ti ti-angle-down"></i></span>
					</div>
				</div>
				<div class="panel-body no-padding" style="display: block;">
					<form id="form1" name="form1" method="post"
						action="notes/overtime?param=addRecordDetail">
						<table class="table table-bordered">
							<tr>
								<td><font color="red">*&nbsp;</font>申请人:</td>
								<td><input type="text" readonly id="employeeName"
									name="employeeName" value="${entity.employeeName}" /> <input
									type="hidden" id="employeeId" name="employeeId"
									value="${entity.employeeID}" /></td>
							</tr>
							<tr>
								<td><font color="red">*&nbsp;</font>加班单编号:</td>
								<td><input type="text" readonly id="noteId" name="noteId"
									value="${entity.noteID}" /> <input type="hidden"
									id="overtimeState" value="${entity.isDaoXiu}"
									name="overtimeState" /></td>
							</tr>

							<td><font color="red">*&nbsp;</font>加班时间:</td>
							<td width="600">
								<div id="divOverTime">
									<input type="button" id="btnAdd" class="btn btn-info"
										name="btnAdd" value="添加" /> <br />
									<c:forEach items="${list }" var="item">
										<span> <input type="date" id="overtimeDate"
											placeholder="YYYY-MM-DD" name="overtimeDate"
											value="${item.overtimeDate }" /> <select id="overtimeFlag"
											value="${item.overtimeFlag }" name="overtimeFlag">
												<c:choose>
													<c:when test="${item.overtimeFlag  == 0 }">
														<option selected="selected" value="0">上午</option>
														<option value="1">下午</option>
														<option value="2">晚上</option>
													</c:when>
													<c:when test="${item.overtimeFlag  == 1}">
														<option value="0">上午</option>
														<option selected="selected" value="1">下午</option>
														<option value="2">晚上</option>
													</c:when>
													<c:when test="${item.overtimeFlag  == 2}">
														<option value="0">上午</option>
														<option value="1">下午</option>
														<option selected="selected" value="2">晚上</option>
													</c:when>
												</c:choose>
										</select><input type="button" onclick="btnDelete_onclick(this)"
											class="btn btn-info" id="btnDelete" name="btnDelete" value="删除" />
											<br />
										</span>
									</c:forEach>
								</div>
							</td>
							</tr>
							<tr>
								<td colspan="2" align="center"><input class="btn btn-info"
									type="submit" value="确定" name="btnSave" id="btnSave" /></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>