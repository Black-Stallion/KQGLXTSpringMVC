<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<c:if test="${list == null }">
	<c:redirect url="/notes/overtime?param=eall"></c:redirect>
</c:if>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>员工选择</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/public.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript">
	$(function(){
		$("#btnOK").click(function(){
		
			if(window.dialogArguments=="employee" || window.dialogArguments == "operator"){
				if($("#selectSpan input:checked").length>1){
					alert("只能选择一个员工!");
					return false;
				}
			}
			var temp = "";
			$("#selectSpan input:checked").each(function(){
			temp = temp+this.value+";";
			});
			if(temp !=""){
			temp = temp.substring(0, temp.length-1);//把分号给截了去
			}
			window.returnValue = temp;
			window.close();
		});
	});
</script>
</head>
<body>
<center>
		<div id="dcMain1">
			<div class="mainBox"
				style="height:auto!important;height:550px;min-height:550px;">
				<form method="post" action="notes/overtime?param=eall">
					<table width="100%" border="0" cellpadding="8" cellspacing="0"
						class="tableBasic">
								<tr>
									<td colspan="2"><span style="font-size:20px">请选择员工</span></td>
								</tr>
								<tr>
									<td colspan="2">输入员工姓名：<input type="text" id="name" name="name">
									<input class="btn btn-info" type="submit" id="btn" name="btn" value="查询"></td>
								</tr>
								<tr><td>
								<c:forEach items="${list }" var="item" varStatus="state">
											<span id="selectSpan"> <span> <input
													class="cls_rad" type="checkbox"
													value="${item.employeeID}(${item.employeeName})"
													id="chk${item.employeeID}_${state.index}"
													name="chk${item.employeeID }"> </span> <span>
													(${item.employeeID }) &nbsp; ${item.employeeName }</span> </span>
								</c:forEach>
								</td></tr>
								<tr>
									<td colspan="2" align="center"><input class="btn btn-info"
										type="button" value="确定" name="btnOK" id="btnOK" /></td>
								</tr>
					</table>
				</form>
			</div>
		</div>
	</center>
</body>
</html>
