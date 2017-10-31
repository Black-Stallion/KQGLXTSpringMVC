/*---------------登录页的验证----------------------*/
		function check(){
		 var name = document.getElementById("adminAccount").value;
		 var pwd = document.getElementById("adminPwd").value;
		 if(name==null || name.length==0){
		 alert("用户名不能为空!");
		 return false;
		 }else if(pwd==null || pwd.length==0){
		 alert("密码不能为空!");
		  return false;
		 }
		 return true;
		}
/*----------------------添加部门格式验证--------------------------------*/		
		function Check(){
			var name = document.getElementById("departmentName").value;
			var startam =document.getElementById("startTimeAM").value;
			var endam =document.getElementById("endTimeAM").value;
			var startpm =document.getElementById("startTimePM").value;
			var endpm =document.getElementById("endTimePM").value;
			//验证不能为空
			if(name.length == 0){
				alert("部门名称不能为空!");
				return false;
			}if(startam.length ==0||endam.length ==0||startpm.length ==0||endpm.length ==0){
				alert("时间不能为空!");
				return false;
			}
			//验证时间格式
			var temp = startam.split(":");
			var temp1 = endam.split(":");
			var temp2 = startpm.split(":");
			var temp3 = endpm.split(":");
			if(startam.length !=0 && temp.length !=2 || endam.length !=0 && temp1.length !=2){
				alert("上午时间格式不对!");
				return false;
			}
			if(startpm.length !=0 && temp2.length !=2 || endpm.length !=0 && temp3.length !=2){
				alert("下午时间格式不对!");
				return false;
			}
			//判断小时
			if((!(temp[0].length == 1 || temp[0].length ==2))||(!(temp1[0].length == 1 || temp1[0].length ==2))){
				alert("上午时间格式不对！");
				return false;
			}
			if((!(temp2[0].length == 1 || temp2[0].length ==2))||(!(temp3[0].length == 1 || temp3[0].length ==2))){
				alert("下午时间格式不对！");
				return false;
			}
			//判断分钟
			if( (temp[1].length != 2)||(temp1[1].length != 2)  )
			{
				alert("上午时间格式不对!");
				return false;
			}
			if( (temp2[1].length != 2)||(temp3[1].length != 2)  )
			{
				alert("下午时间格式不对!");
				return false;
			}
			//判断是不是数字，不是返回true
			if( (isNaN(temp[0]) == true)||(isNaN(temp[1]) == true)||(isNaN(temp1[0]) == true)||(isNaN(temp1[1]) == true))
			{
				alert("上午时间有非数字!");
				return false;
			}if( (isNaN(temp2[0]) == true)||(isNaN(temp2[1]) == true)||(isNaN(temp3[0]) == true)||(isNaN(temp3[1]) == true))
			{
				alert("下午时间有非数字!");
				return false;
			}
			if(parseInt(temp[0]<0)|| parseInt(temp[0]>=12)||parseInt(temp1[0]<0)|| parseInt(temp1[0]>=12)){
				alert("上午小时格式不对!");
				return false;
			}
			if(parseInt(temp2[0]<12)|| parseInt(temp2[0]>23)||parseInt(temp3[0]<12)|| parseInt(temp3[0]>23)){
				alert("下午小时格式不对!");
				return false;
			}
			if( parseInt( temp[1]) < 0 || parseInt( temp[1]) > 59|| parseInt( temp1[1]) < 0 || parseInt( temp1[1]) > 59){
				alert("上午分钟格式不对!");
				return false;
			}
			if( parseInt( temp2[1]) < 0 || parseInt( temp2[1]) > 59|| parseInt( temp3[1]) < 0 || parseInt( temp3[1]) > 59){
				alert("下午分钟格式不对!");
				return false;
			}
			return true;
	}
/*-------------------------------------------------------------------*/