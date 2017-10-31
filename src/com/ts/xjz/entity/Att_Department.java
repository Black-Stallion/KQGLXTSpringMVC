package com.ts.xjz.entity;

import java.io.Serializable;

public class Att_Department implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int departmentID;	
	private String departmentName;
	private String startTimeAM;
	private String endTimeAM;
	private String startTimePM;
	private String endTimePM;
	private int weekType;
	private int parentID =0;
	public Att_Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Att_Department(int departmentID, String departmentName,
			String startTimeAM, String endTimeAM, String startTimePM,
			String endTimePM, int weekType, int parentID) {
		super();
		this.departmentID = departmentID;
		this.departmentName = departmentName;
		this.startTimeAM = startTimeAM;
		this.endTimeAM = endTimeAM;
		this.startTimePM = startTimePM;
		this.endTimePM = endTimePM;
		this.weekType = weekType;
		this.parentID = parentID;
	}
	public int getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getStartTimeAM() {
		return startTimeAM;
	}
	public void setStartTimeAM(String startTimeAM) {
		this.startTimeAM = startTimeAM;
	}
	public String getEndTimeAM() {
		return endTimeAM;
	}
	public void setEndTimeAM(String endTimeAM) {
		this.endTimeAM = endTimeAM;
	}
	public String getStartTimePM() {
		return startTimePM;
	}
	public void setStartTimePM(String startTimePM) {
		this.startTimePM = startTimePM;
	}
	public String getEndTimePM() {
		return endTimePM;
	}
	public void setEndTimePM(String endTimePM) {
		this.endTimePM = endTimePM;
	}
	public int getWeekType() {
		return weekType;
	}
	public void setWeekType(int weekType) {
		this.weekType = weekType;
	}
	public int getParentID() {
		return parentID;
	}
	public void setParentID(int parentID) {
		this.parentID = parentID;
	}
	@Override
	public String toString() {
		return "Att_Department [departmentID=" + departmentID
				+ ", departmentName=" + departmentName + ", startTimeAM="
				+ startTimeAM + ", endTimeAM=" + endTimeAM + ", startTimePM="
				+ startTimePM + ", endTimePM=" + endTimePM + ", weekType="
				+ weekType + ", parentID=" + parentID + "]";
	}
	
}
