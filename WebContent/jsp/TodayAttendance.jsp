<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<c:if test="${list==null }">
	<c:redirect
		url="/attendance/att?param=getListByKeyWords&attendanceFlag=-1"></c:redirect>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>今日考勤</title>
<meta name="Copyright" content="Douco Design." />
<link href="css/public.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" language="java">
addEventListener("load", function() {
	setTimeout(hideURLbar, 0);
}, false);
function hideURLbar() {
	window.scrollTo(0, 1);
}
$(function(){
	//初始化数据
	initData();
	$("#dele").change(
	function(){
	var id ="departmentid="+document.getElementById("dele").value;
	var time = new Date()+""+Math.random();
		$.ajax({
			type:"post",
			url:"employee/empjson?param=secendlist",
			data:id+"&time="+time,
			success:function(data){
				var $_name = $("#del");
				$_name.html("");
				var ele = document.createElement("OPTION");
				$_name[0].add(ele);
				ele.value=0;
				ele.innerHTML = "选择二级部门";
				var result = $.parseJSON(data);
				for(var i = 0; i < result.length;i++){
				//添加部门
				var ele = document.createElement("OPTION");
				$_name[0].add(ele);
				ele.value=result[i].departmentID;
				ele.name=result[i].departmentID;
				ele.innerHTML = result[i].departmentName;
				}
				//查询后保存选中状态
				//	$_name.val(<%=request.getParameter("dele")==null?"0":request.getParameter("dele")%>);
			}
		});
	});
	});
	function initData(){
		var time = new Date()+""+Math.random();
		$.ajax({
			type:"post",
			url:"employee/empjson?param=list",
			data:"time="+time,
			success:function(data){
				var $_name = $("#dele");
				//var result = [{"DEPARTMENTID":1001,"DEPARTMENTNAME":"财务部","STARTTIMEAM":"8:00","ENDTIMEAM":"11:30","STARTTIMEPM":"14:00","ENDTIMEPM":"17:30","WEEKTYPE":1,"PARENTID":0},{"DEPARTMENTID":1002,"DEPARTMENTNAME":"后勤部","STARTTIMEAM":"7:30","ENDTIMEAM":"11:30","STARTTIMEPM":"13:30","ENDTIMEPM":"5:30","WEEKTYPE":1,"PARENTID":0},{"DEPARTMENTID":1008,"DEPARTMENTNAME":"董事会","STARTTIMEAM":"9:00","ENDTIMEAM":"11:00","STARTTIMEPM":"14:00","ENDTIMEPM":"17:30","WEEKTYPE":1,"PARENTID":0}];
				var result = $.parseJSON(data);
				for(var i = 0; i < result.length;i++){
				//添加部门
				var ele = document.createElement("OPTION");
				$_name[0].add(ele);
				ele.value=result[i].DEPARTMENTID;
				ele.name=result[i].DEPARTMENTID;
				ele.innerHTML = result[i].DEPARTMENTNAME;
				}
				//	$_name.val(<%=request.getParameter("dele")==null?"0":request.getParameter("dele")%>);
			}
		});
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
						考勤系统<b>></b><strong>考勤管理</strong><b>></b><strong>今日考勤</strong>
					</h2>
					<div class="panel-ctrls" data-actions-container=""
						data-action-collapse="{&quot;target&quot;: &quot;.panel-body&quot;}">
						<span class="button-icon has-bg"><i
							class="ti ti-angle-down"></i></span>
					</div>
				</div>
				<div class="panel-body no-padding" style="display: block;">
					<form action="attendance/att?param=getListByKeyWords" id="form1"
						name="form1" method="post">
						<table class="table table-bordered">
							<tr>
								<td>部门：</td>
								<td><select name="dele" id="dele">
										<option value="0">一级部门</option>
								</select> &nbsp;&nbsp;&nbsp; <select name="del" id="del">
										<option value="0">二级部门</option>
								</select></td>
							</tr>
							<tr>
								<td>出勤时段：</td>
								<td><input type="date" id="attendanceDate"
									placeholder="YYYY-MM-DD" name="attendanceDate"
									value="${param.attendanceDate}"> <select
									id="attendanceFlag" name="attendanceFlag">
										<option value="-1">请选择</option>
										<c:choose>
											<c:when test="${param.attendanceFlag == 0}">
												<option selected="selected" value="0">上午</option>
												<option value="1">下午</option>
											</c:when>
											<c:when test="${param.attendanceFlag == 1}">
												<option value="0">上午</option>
												<option selected="selected" value="1">下午</option>
											</c:when>
											<c:otherwise>
												<option value="0">上午</option>
												<option value="1">下午</option>
											</c:otherwise>
										</c:choose>
								</select></td>
							</tr>
							<tr>
								<td align="center" colspan="2"><input class="btn btn-info" type="submit"
									value="查询" name="btnQuery" id="btnQuery" /></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
			<div class="panel panel-default">
			<form action="attendance/att?param=save" id="form1" name="form1" method="post">
				<div class="panel-heading">
					<h2 align="right">
						<input class="btn btn-info" type="submit" value="提交" name="btnSave"
							id="btnSave" />
					</h2>
				</div>
				<div class="panel-body">
					<div class="table-responsive">

						<table width="100%" border="0" cellpadding="8" cellspacing="0"
							class="table table-striped table-bordered table-hover">
							<input type="hidden" value="${adminID}" id="adminID"
								name="adminID">
							<tr>
								<th>员工卡号</th>
								<th>员工名称</th>
								<th>员工部门</th>
								<th>刷卡时间</th>
								<th>出勤时间</th>
								<th>出勤状态</th>
							</tr>

							<c:forEach items="${list}" varStatus="v" var="item">
								<tr>
									<td>${item.cardNumber}&nbsp;<input type="hidden"
										value="${item.attendanceID}" id="h_attendanceID${v.count}"
										name="h_attendanceID"> <input type="hidden"
										value="${item.employeeID}" id="h_employeeID${v.count}"
										name="h_employeeID"> <input type="hidden"
										value="${item.cardNumber}" id="h_cardNumber${v.count}"
										name="h_cardNumber"> <input type="hidden"
										value="<fmt:formatDate value="${item.attendanceDate}" pattern="yyyy-MM-dd"/>"
										id="h_attendanceDate${v.count}" name="h_attendanceDate">
										<input type="hidden" value="${item.attendanceFlag}"
										id="h_attendanceFlag${v.count}" name="h_attendanceFlag">
										<input type="hidden" value="${item.departmentId}"
										id="h_departmentId${v.count}" name="h_departmentId">
									</td>
									<td>${item.employeeName }&nbsp;</td>
									<td>${item.departmentName }&nbsp;</td>
									<td>${item.attendanceTime }</td>
									<td><fmt:formatDate value="${item.attendanceDate}"
											pattern="yyyy-MM-dd E" /> &nbsp; <c:if
											test="${item.attendanceFlag==0}">
										 	上午
										 </c:if> <c:if test="${item.attendanceFlag==1}">
										 	下午
										 </c:if></td>
									<td><select id="attendanceType" name="attendanceType">
											<c:forEach items="${type_list}" var="items">
												<c:choose>
													<c:when test="${items.typeId==item.attendanceType }">
														<option selected="selected" value="${ items.typeId}">${items.typeName }</option>
													</c:when>
													<c:otherwise>
														<option value="${ items.typeId}">${items.typeName }</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
									</select></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
