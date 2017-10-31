package com.ts.xjz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ts.xjz.entity.Att_Position;
import com.ts.xjz.service.Att_PositionService;

@Controller
@RequestMapping("/position")
public class Att_PositionController {
	//Service
	@Resource(name = "att_PositionService")
	Att_PositionService att_PositionService;
	
	//查询所有职位
	@RequestMapping(value = "/list/{name}")
	public String findAtt_Position(@PathVariable String name,ModelMap map){
		ArrayList<Map<String,Object>> list = att_PositionService.findAtt_Position();
		map.put("positionlist", list);
		return "jsp/PositionList";
	}
	//添加职位
	@RequestMapping(value = "/addPosition/{name}")
	public String addAtt_Position(@PathVariable String name,ModelMap map,HttpServletRequest request){
		String positionname = request.getParameter("pname");
		Att_Position Position = new Att_Position();
		Position.setPositionName(positionname);
		boolean result = att_PositionService.addAtt_Position(Position);
		if(result){
			ArrayList<Map<String,Object>> list = att_PositionService.findAtt_Position();
			map.put("positionlist", list);
			System.out.println("添加成功");
			return "jsp/PositionList";
		}else{
			return "jsp/PositionList";
		}
	}
	//删除职位
	@RequestMapping(value = "/deletePosition/{name}")
	public String delectAtt_Position(@PathVariable String name,ModelMap map,HttpServletRequest request,HttpServletResponse response){
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int id = Integer.parseInt(request.getParameter("positionId"));
		boolean result = att_PositionService.delectAtt_Position(id);
		if(result){
			pw.println("<script>alert('删除成功!');</script>");
			return "jsp/PositionList";
		}else{
			pw.println("<script>alert('删除失败!');</script>");
			return "jsp/PositionList";
		}
	}
	//修改职位页面跳转
	@RequestMapping(value = "/update/{name}")
	public String updateJump(@PathVariable String name,ModelMap map,HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("positionId"));
		Att_Position posit = att_PositionService.findAtt_Position(id);
		if(posit == null || posit.equals(" ")){
			System.out.println("页面跳转有错！");
			return "jsp/PositionList";
		}else{
			map.put("position", posit);
			return "jsp/PositionEdit";
			}
	}
	@RequestMapping(value = "/updatePosition/{name}")
	public String updatePosition(@PathVariable String name,ModelMap map,HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("positionID"));
		String pname = request.getParameter("pname");
		Att_Position posit = new Att_Position();
		posit.setPositionID(id);
		posit.setPositionName(pname);
		boolean result = att_PositionService.updateAtt_Position(posit);
		if(result == true){
			ArrayList<Map<String,Object>> list = att_PositionService.findAtt_Position();
			System.out.println("修改成功");
			map.put("PositionList", list);
			return "jsp/PositionList";
		}else{
			map.put("position", posit);
			System.out.println("修改失败！");
			return "jsp/PositionEdit";
		}
	}
}
