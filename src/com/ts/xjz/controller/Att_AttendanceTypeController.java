package com.ts.xjz.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ts.xjz.entity.Att_AttendanceType;
import com.ts.xjz.service.Att_AttendanceTypeService;

@Controller
@RequestMapping("/attendanceType")
public class Att_AttendanceTypeController {
	//调用Service
	@Resource(name = "TypeService")
	Att_AttendanceTypeService typeService;
	
	//@ResponseBody//返回的数据不是html标签的页面，而是其他某种格式的数据时（如json、xml等）使用
	@RequestMapping(value = "/type",produces="text/html;charset=UTF-8")
	public String typeHandle(@RequestParam("param") String param,ModelMap map,HttpServletRequest request){
		if("findall".equals(param)){
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			list = typeService.listType();
			map.put("typelist", list);
			return "jsp/AttendanceCategoryManage";
		}else if("addtype".equals(param)){
			String name = request.getParameter("StatusName");
			int weektype = Integer.parseInt(request.getParameter("weekType"));
			Att_AttendanceType type = new Att_AttendanceType();
			type.setTypeName(name);
			type.setTypeCategory(weektype);
			boolean result = typeService.addAtt_AttendanceType(type);
			if(result == true){
				List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
				list = typeService.listType();
				map.put("typelist", list);
				System.out.println("ok");
				return "jsp/AttendanceCategoryManage";
			}else{
				System.out.println("error");
				return "jsp/AttendanceCategoryManage";
			}
		}else if(param.equals("deletetype")){//删除类型
			int id = Integer.parseInt(request.getParameter("typeid"));
			boolean result = typeService.deleteAtt_AttendanceType(id);
			if(result ==true){
				List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
				list = typeService.listType();
				map.put("typelist", list);
				System.out.println("删除成功！");
				return "jsp/AttendanceCategoryManage";
			}else{
				List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
				list = typeService.listType();
				map.put("typelist", list);
				System.out.println("删除失败");
				return "jsp/AttendanceCategoryManage";
			}
		}
		return "jsp/AttendanceCategoryManage";
	}
}
