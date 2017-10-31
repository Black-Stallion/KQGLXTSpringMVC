<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>员工修改</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/public.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript">
	addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); }
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
						考勤系统<b>></b><strong>基本设置</strong><b>></b><strong>员工管理</strong><b>></b><strong>员工修改</strong>
					</h2>
					<div class="panel-ctrls" data-actions-container=""
						data-action-collapse="{&quot;target&quot;: &quot;.panel-body&quot;}">
						<span class="button-icon has-bg"><i
							class="ti ti-angle-down"></i></span>
					</div>
				</div>
				<div class="panel-body no-padding" style="display: block;">
					<form id="form1" name="form1" onsubmit="return Check();"
				method="post" action="employee/emp?param=saveEmployee">
				<input type="hidden" value="${elist.employeeID}" name="employeeID">
						<table class="table table-bordered">
						<tr>
					<td><font style="color:red">*&nbsp;</font>姓名</td>
					<td><input type="text" name="employeeName" id="employeeName" value="${elist.employeeName }"/></td>
				</tr>
				<tr>
					<td align="left"><font color="red">*&nbsp;</font>性别</td>
					<c:choose>
							<c:when test="${elist.employeeGender==1 }">
							<td><input class="cls_rad" type="radio" name="employeeGender" checked="checked" value="1" />男 &nbsp; 
							<input class="cls_rad" type="radio" name="employeeGender" value="0" />女</td>
							</c:when>
							<c:otherwise>
							<td><input class="cls_rad" type="radio" name="employeeGender" value="1" />男 &nbsp; 
							<input class="cls_rad" type="radio" checked="checked" name="employeeGender" value="0" />女</td>
							</c:otherwise>
						</c:choose>
					</tr>
				<tr>
					<td><font style="color:red">*&nbsp;</font>职位</td>
					<td><select id="positionID" name="positionID">
						<option>选择职位</option>
	 	 				<c:forEach var="item" items="${positionlist }">
	 	 				<c:choose>
	 	 				<c:when test="${item.positionID==elist.positionID }">
	 	 				<option selected="selected" value="${item.positionID }">${item.positionName }</option>
	 	 				</c:when>
	 	 				<c:otherwise>
	 	 				<option value="${item.positionID }">${item.positionName }</option>
	 	 				</c:otherwise>
	 	 				</c:choose>
	 	 				</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td><font style="color:red">*&nbsp;</font>部门</td>
					<td><select id="departmentID" name="departmentID">
						<option>选择部门</option>
	 	 			<c:forEach var="item" items="${departmentlist }">
	 	 			<c:choose>
	 	 				<c:when test="${item.departmentID==elist.departmentID }">
	 	 				<option selected="selected" value="${item.departmentID }">${item.departmentName }</option>
	 	 			</c:when>
	 	 				<c:otherwise>
	 	 				<option value="${item.departmentID }">${item.departmentName }</option>
	 	 				</c:otherwise>
	 	 			</c:choose>
	 	 		</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td><font style="color:red">*&nbsp;</font>初始状态</td>
					<c:choose>
							<c:when test="${elist.employeeStatc==1 }">
							<td><input class="cls_rad" type="radio" name="employeeStatc" checked="checked" value="1" />正常 &nbsp; 
							<input class="cls_rad" type="radio" name="employeeStatc" value="0" />停用</td>
							</c:when>
							<c:otherwise>
							<td><input class="cls_rad" type="radio" name="employeeStatc" value="1" />正常 &nbsp; 
							<input class="cls_rad" type="radio" checked="checked" name="employeeStatc" value="0" />停用</td>
							</c:otherwise>
						</c:choose>
				</tr>
				<tr>
					<td><font style="color:red">*&nbsp;</font>卡号</td>
					<td><input  type="text" id="cardNumber" name="cardNumber" value="${elist.cardNumber }"/></td>	
				</tr>
				<tr>
					<td align="center"colspan="2" align="center"><input class="btn btn-info"
							type="submit" value="保存" name="btnSave" id="btnSave" /></td>
				</tr>
			</table>
			</form>
		</div>
	</div>
   
  </body>
</html>
