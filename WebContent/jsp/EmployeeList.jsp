<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:if test="${elist==null }">
	<c:redirect url="/employee/emp?param=query"></c:redirect>
</c:if>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>员工列表</title>
    
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

	<script type="text/javascript" language="java">
	addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); }
	function sel_onchange(obj){
		var currentPageIndex = obj.value;
		window.location.href = "/KQGLXTSpringMVC/employee/emp?param=query&currentPageIndex=" + currentPageIndex;
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
						考勤系统<b>></b><strong>基本设置</strong><b>></b><strong>员工管理</strong>
					</h2>
					<div class="panel-ctrls" data-actions-container=""
						data-action-collapse="{&quot;target&quot;: &quot;.panel-body&quot;}">
						<span class="button-icon has-bg"><i
							class="ti ti-angle-down"></i></span>
					</div>
				</div>
				<div class="panel-body no-padding" style="display: block;">
					<form id="form1" name="form1" onsubmit="return Check();"
						method="post"
						action="employee/emp?param=queryEmployee&currentPageIndex=${util.currentPageIndex }">
						<table class="table table-bordered">
							<tr>
								<td>姓名：</td>
								<td><input type="text" id="name" name="name" /></td>
							</tr>
							<tr>
								<td>部门：</td>
								<td><select id="dele" name="dele">
										<option value="0">选择一级部门</option>
								</select> <select id="del" name="del">
										<option value="0">选择二级部门</option>
								</select></td>
							</tr>
							<tr>
								<td align="center" colspan="2"><input class="btn btn-info"
									type="submit" value="查询" /></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<span style="float:left">员工列表</span>
					<span style="float:right">
						<a href="employee/emp?param=addEmployee1" class="btn btn-info">添加员工</a>
					</span>
				</div>
				<div class="panel-body">
					<div class="table-responsive">
						<table width="100%" border="0" cellpadding="8" cellspacing="0"
							class="table table-striped table-bordered table-hover">
							<tr>
								<th>编号</th>
								<th>姓名</th>
								<th>性别</th>
								<th>职位</th>
								<th>部门</th>
								<th>卡号</th>
								<th>状态</th>
								<th>操作</th>
							</tr>
							<c:forEach var="item" items="${elist }">
								<tr>
									<td value="${item.employeeID }">${item.employeeID }</td>
									<td>${item.employeeName }</td>
									<td><c:choose>
											<c:when test="${item.employeeGender==1 }">男</c:when>
											<c:otherwise>女</c:otherwise>
										</c:choose></td>
									<td><c:forEach var="items" items="${positionlist }">
											<c:if test="${item.positionID == items.positionID }">
						${items.positionName }
						</c:if>
										</c:forEach></td>
									<td><c:forEach var="items" items="${departmentlist }">
											<c:if test="${items.departmentID == item.departmentID }">
						${items.departmentName }
						</c:if>
										</c:forEach></td>
									<td>${item.cardNumber }</td>
									<td><c:choose>
											<c:when test="${item.employeeStatc==1 }">正常</c:when>
											<c:otherwise>停用</c:otherwise>
										</c:choose></td>
									<td colspan="2"><a
										href="employee/emp?param=updateEmployee&employeeid=${item.employeeID }">修改</a>|
										<a onclick="javascript:return confirm('是否删除?')"
										href="employee/emp?param=deleteEmployee&employeeid=${item.employeeID }">删除</a></td>
								</tr>
							</c:forEach>
							<tr>
								<td colspan="8">总共<span style="color: red;" id="count">${util.count }</span>笔数据，
									每页<span style="color: red;">${util.pageSize }</span>笔数据， 共<span
									style="color: red;">${util.pageCount }</span>页， 当前是第<span
									style="color: red;">${util.currentPageIndex }</span>页 <a
									href="employee/emp?param=query&currentPageIndex=${util.currentPageIndex-1}">上一页</a>
									<a
									href="employee/emp?param=query&currentPageIndex=${util.currentPageIndex+1}">下一页</a>
									<select id="sel" name="sel" onchange="sel_onchange(this)">
										<c:forEach begin="1" end="${util.pageCount}" step="1" var="i">
											<c:if test="${i == util.currentPageIndex}">
												<option selected="selected" value="${i}">${i}</option>
											</c:if>
											<c:if test="${i != util.currentPageIndex}">
												<option value="${i}">${i}</option>
											</c:if>
										</c:forEach>
								</select>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
