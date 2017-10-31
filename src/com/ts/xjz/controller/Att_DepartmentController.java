package com.ts.xjz.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ts.xjz.entity.Att_Department;
import com.ts.xjz.service.Att_DepartmentService;

@Controller
@RequestMapping("/department")
public class Att_DepartmentController {
	@Resource(name = "att_departmentService")
	Att_DepartmentService att_departmentService;
	
	String json = "";
	 //查询部门所有
	@RequestMapping(value = "/list/{name}")
	public String departmentList(@PathVariable String name,ModelMap map){
		ArrayList<Map<String, Object>>  departmentlist = att_departmentService.findAllFirstAtt_Department();
		map.put("departmentlist", departmentlist);
		return "jsp/DepartmentList";
	}
	//添加部门
	@RequestMapping(value = "/addDepartment/{name}")
	public String addDepartment(@PathVariable String name,ModelMap map,HttpServletRequest request){
		String departmentname = request.getParameter("departmentName");
		String startam = request.getParameter("startTimeAM");
		String endam = request.getParameter("endTimeAM");
		String startpm = request.getParameter("startTimePM");
		String endpm = request.getParameter("endTimePM");
		int weekType = Integer.parseInt(request.getParameter("weekType"));
		Att_Department department = new Att_Department();
		department.setDepartmentName(departmentname);
		department.setStartTimeAM(startam);
		department.setEndTimeAM(endam);
		department.setStartTimePM(startpm);
		department.setEndTimePM(endpm);
		department.setWeekType(weekType);
		department.setParentID(department.getParentID());
		boolean bol = att_departmentService.addAtt_Department(department);
		if(bol == true){
			ArrayList<Map<String, Object>>  departmentlist = att_departmentService.findAllFirstAtt_Department();
			map.put("departmentlist", departmentlist);
			System.out.println("添加部门成功");
			return "jsp/DepartmentList";
		}else{
			System.out.println("添加部门失败");
			return "jsp/DepartmentList";
		}
	}
	//修改部门页面跳转
	@RequestMapping(value = "/updateDep/{name}")
	public String update(@PathVariable String name,ModelMap map,HttpServletRequest request){
		int departmentId = Integer.parseInt(request.getParameter("departmentId"));
		Att_Department department =  att_departmentService.findAtt_Department(departmentId);
		//System.out.println(department+""+departmentId);
		map.put("department", department);
		return "jsp/DepartmentEdit";
	}
	//修改部门
	@RequestMapping(value = "/updateDepartment/{name}")
	public String updateDepartment(@PathVariable String name,ModelMap map,HttpServletRequest request){
		String departmentname = request.getParameter("departmentname");
		String startam = request.getParameter("starttimeam");
		String endam = request.getParameter("endtimeam");
		String startpm = request.getParameter("starttimepm");
		String endpm = request.getParameter("endtimepm");
		int weekType = Integer.parseInt(request.getParameter("weektype"));
		int departmentID = Integer.parseInt(request.getParameter("departmentID"));
		Att_Department department = new Att_Department();
		department.setDepartmentID(departmentID);
		department.setDepartmentName(departmentname);
		department.setStartTimeAM(startam);
		department.setEndTimeAM(endam);
		department.setStartTimePM(startpm);
		department.setEndTimePM(endpm);
		department.setWeekType(weekType);
		boolean bol = att_departmentService.updateAtt_Department(department);
		if(bol == true){
			ArrayList<Map<String, Object>>  departmentlist = att_departmentService.findAllFirstAtt_Department();
			map.put("departmentlist", departmentlist);
			System.out.println("修改部门成功");
			return "jsp/DepartmentList";
		}else{
			System.out.println("修改部门失败");
			return "jsp/DepartmentList";
		}
	}
	//删除部门
	@RequestMapping(value = "/delete/{name}")
	public String deleteDepartment(@PathVariable String name,ModelMap map,HttpServletRequest request){
		int parentId = Integer.parseInt(request.getParameter("departmentId"));
		ArrayList<Att_Department> sublist = att_departmentService.findDepartmentByParentId(parentId);
		if(sublist.size() !=0){
			//request.println("<script>alert('该部门含有子部门，请先删除子部门在删除该部门！');window.location.href='/KQGLXT/jsp/DepartmentList.jsp'</script>");
			System.out.println("该部门含有子部门，请先删除子部门!");
			map.put("result","exist");
			map.put("departmentId", parentId);
// 			json = JSONObject.toJSONString(map);
//			System.out.println(json);
//			return json;
			return "jsp/SubDepartmentList";
		}else{
				boolean bol = att_departmentService.delectAtt_Department(parentId);
//			boolean bol = true;	
			if(bol == true){
					ArrayList<Map<String,Object>> departmentlist = att_departmentService.findAllFirstAtt_Department();
					map.put("departmentlist", departmentlist);
					map.put("result", "ok");
//					json = JSONObject.toJSONString(map);
//					return json;
					return "jsp/DepartmentList";
				}else{
					ArrayList<Map<String,Object>> departmentlist = att_departmentService.findAllFirstAtt_Department();
					map.put("departmentlist", departmentlist);
					map.put("result", "error");
//					json = JSONObject.toJSONString(map);
//					return json;
					System.out.println("删除失败!");
					return "jsp/DepartmentList";
				}
		}
	}
	//显示子部门信息
	@RequestMapping(value = "handle/{name}")
	public String subDepartmentList(@PathVariable String name,ModelMap map,HttpServletRequest request){
		int parentId = Integer.parseInt(request.getParameter("departmentId"));
		ArrayList<Att_Department> sublist = att_departmentService.findDepartmentByParentId(parentId);
		map.put("sublist", sublist);
		map.put("departmentId", parentId);
		return "jsp/SubDepartmentList";
	}
	//删除子部门
	@RequestMapping(value = "subdelete/{name}")
	public String deleteSubDepartment(@PathVariable String name,ModelMap map,HttpServletRequest request){
		int departmentId = Integer.parseInt(request.getParameter("departmentId"));
		int parentID = Integer.parseInt(request.getParameter("parentID"));
		//返回一个对象集合
//		ArrayList<Att_Employees> list = edao.findEmployesslist(departmentId);
//		if(list.size()==0){
		boolean result =att_departmentService.delectAtt_Department(departmentId);
		if(result == true){
			ArrayList<Att_Department> sublist = att_departmentService.findDepartmentByParentId(parentID);
			map.put("sublist", sublist);
			map.put("departmentId", parentID);
			System.out.println("删除成功");
			return "jsp/SubDepartmentList";
		}else{
			ArrayList<Att_Department> sublist = att_departmentService.findDepartmentByParentId(departmentId);
			map.put("sublist", sublist);
			map.put("departmentId", parentID);
			System.out.println("删除失败");
			return "jsp/SubDepartmentList";
		}
//		}else{
//			pw.println("<script>alert('该子部门含有员工，请先删除子部门中的员工！');window.location.href='/KQGLXT/jsp/EmployeeList.jsp'</script>");
//		}
//		return "jsp/SubDepartmentList";
	}
	//修改子部门页面跳转
		@RequestMapping(value = "/updateSubDepartment/{name}")
		public String updateSub(@PathVariable String name,ModelMap map,HttpServletRequest request){
			int departmentId = Integer.parseInt(request.getParameter("departmentId"));
			Att_Department department =  att_departmentService.findAtt_Department(departmentId);
			//System.out.println(department+""+departmentId);
			map.put("department", department);
			return "jsp/SubDepartmentEdit";
		}
	//修改子部门
		@RequestMapping(value = "/updateSub/{name}")
		public String updateSubDepartment(@PathVariable String name,ModelMap map,HttpServletRequest request){
			String departmentname = request.getParameter("departmentname");
			String startam = request.getParameter("starttimeam");
			String endam = request.getParameter("endtimeam");
			String startpm = request.getParameter("starttimepm");
			String endpm = request.getParameter("endtimepm");
			int weekType = Integer.parseInt(request.getParameter("weektype"));
			int departmentID = Integer.parseInt(request.getParameter("departmentID"));
			int parentID = Integer.parseInt(request.getParameter("parentID"));
			Att_Department department = new Att_Department();
			department.setDepartmentID(departmentID);
			department.setDepartmentName(departmentname);
			department.setStartTimeAM(startam);
			department.setEndTimeAM(endam);
			department.setStartTimePM(startpm);
			department.setEndTimePM(endpm);
			department.setWeekType(weekType);
			department.setParentID(parentID);
			boolean bol = att_departmentService.updateAtt_Department(department);
			if(bol == true){
				ArrayList<Att_Department>  sublist = att_departmentService.findDepartmentByParentId(parentID);
				map.put("sublist", sublist);
				map.put("departmentId", parentID);
				System.out.println("修改子部门成功");
				return "jsp/SubDepartmentList";
			}else{
				ArrayList<Att_Department>  sublist = att_departmentService.findDepartmentByParentId(parentID);
				map.put("sublist", sublist);
				map.put("departmentId", parentID);
				System.out.println("修改子部门失败");
				return "jsp/SubDepartmentList";
			}
		}
		//添加子部门
		@RequestMapping(value = "/addsub/{name}")
		public String addSubDepartment(@PathVariable String name,ModelMap map,HttpServletRequest request){
			String subname = request.getParameter("departmentname");
			String startam = request.getParameter("starttimeam");
			String endam = request.getParameter("endtimeam");
			String startpm = request.getParameter("starttimepm");
			String endpm = request.getParameter("endtimepm");
			int weekType = Integer.parseInt(request.getParameter("weektype"));
			int parentID = Integer.parseInt(request.getParameter("departmentId"));
			Att_Department department = new Att_Department();
			department.setDepartmentName(subname);
			department.setStartTimeAM(startam);
			department.setEndTimeAM(endam);
			department.setStartTimePM(startpm);
			department.setEndTimePM(endpm);
			department.setWeekType(weekType);
			department.setParentID(parentID);
			boolean bol = att_departmentService.addAtt_Department(department);
			if(bol == true){
				ArrayList<Att_Department>  sublist = att_departmentService.findDepartmentByParentId(parentID);
				map.put("sublist", sublist);
				map.put("departmentId", parentID);
				System.out.println("添加部门成功");
				return "jsp/SubDepartmentList";
			}else{
				ArrayList<Att_Department>  sublist = att_departmentService.findDepartmentByParentId(parentID);
				map.put("sublist", sublist);
				map.put("departmentId", parentID);
				System.out.println("添加部门失败");
				return "jsp/SubDepartmentList";
			}
		}
}
