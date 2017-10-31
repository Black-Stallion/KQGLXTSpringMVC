<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>添加请假单</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/public.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript">
addEventListener("load", function() {
	setTimeout(hideURLbar, 0);
}, false);
function hideURLbar() {
	window.scrollTo(0, 1);
}
	$(function() {
		//选择申请人
		$("#b_selapplicant")
				.click(
						function() {
							var returnV = window.showModalDialog("jsp/SelectUser.jsp",
											"employee",
											"dialogHeight=500px;dialogWidth=400px;resizable=no;scroll=yes");
							$("#selapplicant").val(returnV);
						});
		//选择代理人
		$("#b_selagent")
				.click(
						function() {
							var returnV = window
									.showModalDialog("jsp/SelectUser.jsp",
											"operator",
											"dialogHeight=500px;dialogWidth=400px;resizable=no;scroll=yes");
							//var result = distinctResult( returnValue , $("#operatorName").val());
							$("#selagent").val(returnV);
						});
	});
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
						考勤系统<b>></b><strong>请假单管理</strong><b>></b><strong>添加请假单</strong>
					</h2>
					<div class="panel-ctrls" data-actions-container=""
						data-action-collapse="{&quot;target&quot;: &quot;.panel-body&quot;}">
						<span class="button-icon has-bg"><i
							class="ti ti-angle-down"></i></span>
					</div>
				</div>
				<div class="panel-body no-padding" style="display: block;">
					<form id="form1" name="form1" method="post"
						action="notes/leave?param=add">
						<input type="hidden" id="adminID" name="adminID"
							value="${adminID }">
						<table class="table table-bordered">
							<tr>
								<td><font color="red">*&nbsp;</font>申请人:</td>
								<td><input value="${param.selapplicant }" type="text"
									readonly="readonly" id="selapplicant" name="selapplicant" />
								 <input class="btn btn-info" type="button" id="b_selapplicant"
									name="b_selapplicant" value="选择申请人" /></td>
							</tr>
							<tr>
								<td><font color="red">*&nbsp;</font>代理人:</td>
								<td><input value="${param.selagent }" type="text"
									id="selagent" readonly="readonly" name="selagent" /> <input
									class="btn btn-info" type="button" id="b_selagent"
									name="b_selagent" value="选择代理人" /></td>
							</tr>
							<tr>
								<td><font color="red">*&nbsp;</font>填表日期:</td>
								<td><input value="${param.filltime }" type="date"
									placeholder="YYYY-MM-DD" id="filltime" name="filltime" /></td>
							</tr>
							<tr>
								<td><font color="red">*&nbsp;</font>请假类型:</td>
								<td><select id="noteType" name="noteType"
									style="width: 215px;">
										<option value="0">全部</option>
										<c:forEach var="item" items="${list2}">
											<option value="${item.typeId}">${item.typeName}</option>
										</c:forEach>
								</select><font color="red">*&nbsp;</font></td>
							</tr>
							<tr>
								<td><font color="red">*&nbsp;</font>请假事由:</td>
								<td><textarea rows="3" cols="40" name="cause" id="cause">${param.cause }</textarea>&nbsp;
								</td>
							</tr>
							<tr>
								<td><font color="red">*&nbsp;</font>请假起始时间:</td>
								<td><input value="${param.starttime }" type="date"
									placeholder="YYYY-MM-DD" id="starttime" name="starttime" /> <select
									id="startmm" name="startmm">
										<c:choose>
											<c:when test="${param.startmm=='上午' }">
												<option value="上午" selected="selected">上午</option>
												<option value="下午">下午</option>
											</c:when>
											<c:otherwise>
												<option value="上午">上午</option>
												<option value="下午" selected="selected">下午</option>
											</c:otherwise>
										</c:choose>
								</select>&nbsp;</td>
							</tr>
							<tr>
								<td><font color="red">*&nbsp;</font>请假结束时间:</td>
								<td><input value="${param.endtime }" type="date"
									placeholder="YYYY-MM-DD" id="endtime" name="endtime" /> <select
									id="endmm" name="endmm">
										<c:choose>
											<c:when test="${param.endmm=='上午' }">
												<option value="上午" selected="selected">上午</option>
												<option value="下午">下午</option>
											</c:when>
											<c:otherwise>
												<option value="上午">上午</option>
												<option value="下午" selected="selected">下午</option>
											</c:otherwise>
										</c:choose>
								</select>&nbsp;</td>
							</tr>
							<tr>
								<td>主管经理意见:</td>
								<td><textarea rows="3" cols="40" id="directorSign"
										name="directorSign">${param.directorSign }</textarea></td>
							</tr>
							<tr>
								<td align="left">行政部经理签字:</td>
								<td><textarea rows="3" cols="40" id="presidentSign"
										name="presidentSign">${param.presidentSign }</textarea></td>
							</tr>
							<tr>
								<td>总裁意见:</td>
								<td><textarea rows="3" cols="40" name="administrationSign"
										id="administrationSign">${param.administrationSign }</textarea>
								</td>
							</tr>
							<tr>
								<td><font color="red">*&nbsp;</font>审批结果</td>
								<td><input class="cls_rad" type="radio" id="result"
									checked="checked" name="result" value="1" />通过 &nbsp; <input
									class="cls_rad" type="radio" id="result" name="result"
									value="0" />未通过</td>
							</tr>
							<tr>
								<td colspan="2" align="center"><input class="btn btn-info"
									type="submit" value="确定" name="btnSave" id="btnSave" /> <input
									class="btn btn-info" type="submit" value="取消" name="btnCancle"
									id="btnCancle" /></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
