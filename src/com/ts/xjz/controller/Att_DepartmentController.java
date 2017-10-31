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
	 //��ѯ��������
	@RequestMapping(value = "/list/{name}")
	public String departmentList(@PathVariable String name,ModelMap map){
		ArrayList<Map<String, Object>>  departmentlist = att_departmentService.findAllFirstAtt_Department();
		map.put("departmentlist", departmentlist);
		return "jsp/DepartmentList";
	}
	//��Ӳ���
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
			System.out.println("��Ӳ��ųɹ�");
			return "jsp/DepartmentList";
		}else{
			System.out.println("��Ӳ���ʧ��");
			return "jsp/DepartmentList";
		}
	}
	//�޸Ĳ���ҳ����ת
	@RequestMapping(value = "/updateDep/{name}")
	public String update(@PathVariable String name,ModelMap map,HttpServletRequest request){
		int departmentId = Integer.parseInt(request.getParameter("departmentId"));
		Att_Department department =  att_departmentService.findAtt_Department(departmentId);
		//System.out.println(department+""+departmentId);
		map.put("department", department);
		return "jsp/DepartmentEdit";
	}
	//�޸Ĳ���
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
			System.out.println("�޸Ĳ��ųɹ�");
			return "jsp/DepartmentList";
		}else{
			System.out.println("�޸Ĳ���ʧ��");
			return "jsp/DepartmentList";
		}
	}
	//ɾ������
	@RequestMapping(value = "/delete/{name}")
	public String deleteDepartment(@PathVariable String name,ModelMap map,HttpServletRequest request){
		int parentId = Integer.parseInt(request.getParameter("departmentId"));
		ArrayList<Att_Department> sublist = att_departmentService.findDepartmentByParentId(parentId);
		if(sublist.size() !=0){
			//request.println("<script>alert('�ò��ź����Ӳ��ţ�����ɾ���Ӳ�����ɾ���ò��ţ�');window.location.href='/KQGLXT/jsp/DepartmentList.jsp'</script>");
			System.out.println("�ò��ź����Ӳ��ţ�����ɾ���Ӳ���!");
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
					System.out.println("ɾ��ʧ��!");
					return "jsp/DepartmentList";
				}
		}
	}
	//��ʾ�Ӳ�����Ϣ
	@RequestMapping(value = "handle/{name}")
	public String subDepartmentList(@PathVariable String name,ModelMap map,HttpServletRequest request){
		int parentId = Integer.parseInt(request.getParameter("departmentId"));
		ArrayList<Att_Department> sublist = att_departmentService.findDepartmentByParentId(parentId);
		map.put("sublist", sublist);
		map.put("departmentId", parentId);
		return "jsp/SubDepartmentList";
	}
	//ɾ���Ӳ���
	@RequestMapping(value = "subdelete/{name}")
	public String deleteSubDepartment(@PathVariable String name,ModelMap map,HttpServletRequest request){
		int departmentId = Integer.parseInt(request.getParameter("departmentId"));
		int parentID = Integer.parseInt(request.getParameter("parentID"));
		//����һ�����󼯺�
//		ArrayList<Att_Employees> list = edao.findEmployesslist(departmentId);
//		if(list.size()==0){
		boolean result =att_departmentService.delectAtt_Department(departmentId);
		if(result == true){
			ArrayList<Att_Department> sublist = att_departmentService.findDepartmentByParentId(parentID);
			map.put("sublist", sublist);
			map.put("departmentId", parentID);
			System.out.println("ɾ���ɹ�");
			return "jsp/SubDepartmentList";
		}else{
			ArrayList<Att_Department> sublist = att_departmentService.findDepartmentByParentId(departmentId);
			map.put("sublist", sublist);
			map.put("departmentId", parentID);
			System.out.println("ɾ��ʧ��");
			return "jsp/SubDepartmentList";
		}
//		}else{
//			pw.println("<script>alert('���Ӳ��ź���Ա��������ɾ���Ӳ����е�Ա����');window.location.href='/KQGLXT/jsp/EmployeeList.jsp'</script>");
//		}
//		return "jsp/SubDepartmentList";
	}
	//�޸��Ӳ���ҳ����ת
		@RequestMapping(value = "/updateSubDepartment/{name}")
		public String updateSub(@PathVariable String name,ModelMap map,HttpServletRequest request){
			int departmentId = Integer.parseInt(request.getParameter("departmentId"));
			Att_Department department =  att_departmentService.findAtt_Department(departmentId);
			//System.out.println(department+""+departmentId);
			map.put("department", department);
			return "jsp/SubDepartmentEdit";
		}
	//�޸��Ӳ���
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
				System.out.println("�޸��Ӳ��ųɹ�");
				return "jsp/SubDepartmentList";
			}else{
				ArrayList<Att_Department>  sublist = att_departmentService.findDepartmentByParentId(parentID);
				map.put("sublist", sublist);
				map.put("departmentId", parentID);
				System.out.println("�޸��Ӳ���ʧ��");
				return "jsp/SubDepartmentList";
			}
		}
		//����Ӳ���
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
				System.out.println("��Ӳ��ųɹ�");
				return "jsp/SubDepartmentList";
			}else{
				ArrayList<Att_Department>  sublist = att_departmentService.findDepartmentByParentId(parentID);
				map.put("sublist", sublist);
				map.put("departmentId", parentID);
				System.out.println("��Ӳ���ʧ��");
				return "jsp/SubDepartmentList";
			}
		}
}
