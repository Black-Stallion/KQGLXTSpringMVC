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
	
	//��ѯ����ְλ
	@RequestMapping(value = "/list/{name}")
	public String findAtt_Position(@PathVariable String name,ModelMap map){
		ArrayList<Map<String,Object>> list = att_PositionService.findAtt_Position();
		map.put("positionlist", list);
		return "jsp/PositionList";
	}
	//���ְλ
	@RequestMapping(value = "/addPosition/{name}")
	public String addAtt_Position(@PathVariable String name,ModelMap map,HttpServletRequest request){
		String positionname = request.getParameter("pname");
		Att_Position Position = new Att_Position();
		Position.setPositionName(positionname);
		boolean result = att_PositionService.addAtt_Position(Position);
		if(result){
			ArrayList<Map<String,Object>> list = att_PositionService.findAtt_Position();
			map.put("positionlist", list);
			System.out.println("��ӳɹ�");
			return "jsp/PositionList";
		}else{
			return "jsp/PositionList";
		}
	}
	//ɾ��ְλ
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
			pw.println("<script>alert('ɾ���ɹ�!');</script>");
			return "jsp/PositionList";
		}else{
			pw.println("<script>alert('ɾ��ʧ��!');</script>");
			return "jsp/PositionList";
		}
	}
	//�޸�ְλҳ����ת
	@RequestMapping(value = "/update/{name}")
	public String updateJump(@PathVariable String name,ModelMap map,HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("positionId"));
		Att_Position posit = att_PositionService.findAtt_Position(id);
		if(posit == null || posit.equals(" ")){
			System.out.println("ҳ����ת�д�");
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
			System.out.println("�޸ĳɹ�");
			map.put("PositionList", list);
			return "jsp/PositionList";
		}else{
			map.put("position", posit);
			System.out.println("�޸�ʧ�ܣ�");
			return "jsp/PositionEdit";
		}
	}
}
