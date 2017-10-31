package com.ts.xjz.entity;

import java.io.Serializable;
import java.util.Date;

public class Att_Notes implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int noteID;
	private int departmentID;//---外键（部门）
	private int employeeID;//--外键（员工）
	private int noteType;//----外键（考勤状态）
	private String employeeIDs;
	private String cause;
	private Date fillInTime;
	private String directorSign;
	private String administrationSign;
	private String presidentSign;
	private Date startDate;
	private String startTime;
	private Date endDate;
    private String endTime;
    private String vehicle;
    private String overtimeIDs;
    private String projectName;
    private int adminID;//--外键（用户）
    private String noteMemo ;
    private int operatorID ;//--外键（员工)
    private int isVerify;//----(0（审批） 否 1 是)
    private int isDaoXiu;
    
	public int getIsDaoXiu() {
		return isDaoXiu;
	}

	public void setIsDaoXiu(int isDaoXiu) {
		this.isDaoXiu = isDaoXiu;
	}
	//不是本表的
	private String typeName;//请假名称
    public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	private String employeeName;// 申请人
	private String overTime; // 查询用的加班时间字段
	private String fillTableTime; //查询用的填表时间字段
	private String operatorName;//代理人
	public Att_Notes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Att_Notes(int noteID, int departmentID, int employeeID,
			int noteType, String employeeIDs, String cause, Date fillInTime,
			String directorSign, String administrationSign,
			String presidentSign, Date startDate, String startTime,
			Date endDate, String endTime, String vehicle, String overtimeIDs,
			String projectName, int adminID, String noteMemo, int operatorID,
			int isVerify,int isDaoXiu) {
		super();
		this.noteID = noteID;
		this.departmentID = departmentID;
		this.employeeID = employeeID;
		this.noteType = noteType;
		this.employeeIDs = employeeIDs;
		this.cause = cause;
		this.fillInTime = fillInTime;
		this.directorSign = directorSign;
		this.administrationSign = administrationSign;
		this.presidentSign = presidentSign;
		this.startDate = startDate;
		this.startTime = startTime;
		this.endDate = endDate;
		this.endTime = endTime;
		this.vehicle = vehicle;
		this.overtimeIDs = overtimeIDs;
		this.projectName = projectName;
		this.adminID = adminID;
		this.noteMemo = noteMemo;
		this.operatorID = operatorID;
		this.isVerify = isVerify;
		this.isDaoXiu = isDaoXiu;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getOverTime() {
		return overTime;
	}

	public void setOverTime(String overTime) {
		this.overTime = overTime;
	}

	public String getFillTableTime() {
		return fillTableTime;
	}

	public void setFillTableTime(String fillTableTime) {
		this.fillTableTime = fillTableTime;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public int getNoteID() {
		return noteID;
	}
	public void setNoteID(int noteID) {
		this.noteID = noteID;
	}
	public int getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public int getNoteType() {
		return noteType;
	}
	public void setNoteType(int noteType) {
		this.noteType = noteType;
	}
	public String getEmployeeIDs() {
		return employeeIDs;
	}
	public void setEmployeeIDs(String employeeIDs) {
		this.employeeIDs = employeeIDs;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public Date getFillInTime() {
		return fillInTime;
	}
	public void setFillInTime(Date fillInTime) {
		this.fillInTime = fillInTime;
	}
	public String getDirectorSign() {
		return directorSign;
	}
	public void setDirectorSign(String directorSign) {
		this.directorSign = directorSign;
	}
	public String getAdministrationSign() {
		return administrationSign;
	}
	public void setAdministrationSign(String administrationSign) {
		this.administrationSign = administrationSign;
	}
	public String getPresidentSign() {
		return presidentSign;
	}
	public void setPresidentSign(String presidentSign) {
		this.presidentSign = presidentSign;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getVehicle() {
		return vehicle;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	public String getOvertimeIDs() {
		return overtimeIDs;
	}
	public void setOvertimeIDs(String overtimeIDs) {
		this.overtimeIDs = overtimeIDs;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	public String getNoteMemo() {
		return noteMemo;
	}
	public void setNoteMemo(String noteMemo) {
		this.noteMemo = noteMemo;
	}
	public int getOperatorID() {
		return operatorID;
	}
	public void setOperatorID(int operatorID) {
		this.operatorID = operatorID;
	}
	public int getIsVerify() {
		return isVerify;
	}
	public void setIsVerify(int isVerify) {
		this.isVerify = isVerify;
	}
	@Override
	public String toString() {
		return "Att_Notes [noteID=" + noteID + ", departmentID=" + departmentID
				+ ", employeeID=" + employeeID + ", noteType=" + noteType
				+ ", employeeIDs=" + employeeIDs + ", cause=" + cause
				+ ", fillInTime=" + fillInTime + ", directorSign="
				+ directorSign + ", administrationSign=" + administrationSign
				+ ", presidentSign=" + presidentSign + ", startDate="
				+ startDate + ", startTime=" + startTime + ", endDate="
				+ endDate + ", endTime=" + endTime + ", vehicle=" + vehicle
				+ ", overtimeIDs=" + overtimeIDs + ", projectName="
				+ projectName + ", adminID=" + adminID + ", noteMemo="
				+ noteMemo + ", operatorID=" + operatorID + ", isVerify="
				+ isVerify + ", isDaoXiu=" + isDaoXiu + ", typeName="
				+ typeName + ", employeeName=" + employeeName + ", overTime="
				+ overTime + ", fillTableTime=" + fillTableTime
				+ ", operatorName=" + operatorName + "]";
	}
}
