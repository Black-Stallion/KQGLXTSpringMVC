package com.ts.xjz.util;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ts.xjz.entity.Att_AdminPopedom;


public class SessionManager {
	private static HttpSession hsession;
	private int adminID;
	private int adminRight;
	private String adminName;
	private HashMap<String,Integer> HashMap;
	private ArrayList<Att_AdminPopedom> plist;
	public static ArrayList<Att_AdminPopedom> getPlist() {
		if(hsession.getAttribute("plist")!=null){
			Object obj = hsession.getAttribute("plist");
			@SuppressWarnings("unchecked")
			ArrayList<Att_AdminPopedom> list = (ArrayList<Att_AdminPopedom>) obj;
			return list;
		}else{
			return null;
		}
	}
	public static void setPlist(ArrayList<Att_AdminPopedom> plist) {
		hsession.setAttribute("plist", plist);
	}
	private SessionManager()
	{
		
	}
	public static void createSession(HttpServletRequest request){
		hsession = request.getSession(); 
	}
	public static HashMap<String,Integer> getHashMap(){
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("AttendanceCategoryManage.jsp", 1);
		map.put("DepartmentList.jsp", 1);
		map.put("BusinessTripList.jsp", 0);
		map.put("BusinessTripAdd.jsp", 0);
		map.put("BusinessTripEdit.jsp", 0);
		map.put("DepartmentEdit.jsp", 1);
		map.put("EmployeeAdd.jsp", 1);
		map.put("EmployeeEdit.jsp", 1);
		map.put("EmployeeList.jsp", 1);
		map.put("LeaveEdit.jsp", 0);
		map.put("LeaveAdd.jsp", 0);
		map.put("LeaveList.jsp", 0);
		map.put("OutgoingList.jsp", 0);
		map.put("OutgoingAdd.jsp", 0);
		map.put("OutgoingEdit.jsp", 0);
		map.put("OvertimeDetail.jsp", 0);
		map.put("OvertimeDetailAdd.jsp", 0);
		map.put("OvertimeEdit.jsp",0);
		map.put("OvertimeList.jsp",0);
		map.put("PositionList.jsp", 1);
		map.put("PositionEdit.jsp", 1);
		map.put("a.jsp", 1);
		map.put("ShiftHolidaysNoteList.jsp", 0);
		map.put("ShiftHolidaysNoteEdit.jsp", 0);
		map.put("ShiftHolidaysNoteAdd.jsp", 0);
		map.put("SubDepartmentList.jsp", 1);
		map.put("TodayAttendance.jsp", 0);
		map.put("SelectUser.jsp", 0);
		map.put("bjsp.jsp", 0);
		map.put("AttendanceCollect.jsp", 0);
		map.put("AttendanceNotice.jsp", 0);
		return map;
	}
	public static int getAdminID() {
		if(hsession.getAttribute("adminID")!=null){
			Object obj =  hsession.getAttribute("adminID");
			int i = Integer.parseInt((String) obj);
			return i;
		}else{
			return -1;
		}
	}
	public static void setAdminID(int adminID) {
		hsession.setAttribute("adminID",adminID);
	}
	public static int getAdminRight() {
		if(hsession.getAttribute("adminRight")!=null){
			Object obj = hsession.getAttribute("adminRight");
			int i = Integer.parseInt(obj.toString());
			return i;
		}else{
			return -1;
		}
	}
	public static void setAdminRight(int adminRight) {
		hsession.setAttribute("adminRight", adminRight);
	}
	public static String getAdminName() {
		if(hsession.getAttribute("adminName")!= null){
			Object obj = hsession.getAttribute("adminName" );
			return (String) obj;
		}else{
			return null;
		}
	}
	public static void setAdminName(String adminName) {
		hsession.setAttribute("adminName", adminName);
	}
	@Override
	public String toString() {
		return "SessionManager [adminID=" + adminID + ", adminRight="
				+ adminRight + ", adminName=" + adminName + ", HashMap="
				+ HashMap + ", plist=" + plist + "]";
	}
}
