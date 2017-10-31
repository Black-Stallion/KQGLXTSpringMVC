package com.ts.xjz.entity;

import java.io.Serializable;

public class Att_AttendanceCollect implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int employeeId;
	private String employeeName;
	private int departmentId;
	private String departmentName;
	private double type1;
	private double type2;
	private double type3;
	private double type4;
	private double type5;
	private double type6;
	private double type7;
	private double type8;
	private double type9;
	private double type10;
	private double type11;
	private double type12;
	private double type13;
	private double type14;
	private double total;
	private double days;
	private String cardNumber;
	private int noteID;
	public int getNoteID() {
		return noteID;
	}
	public void setNoteID(int noteID) {
		this.noteID = noteID;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Att_AttendanceCollect() {
		super();
	}
	public Att_AttendanceCollect(int employeeId, String employeeName,
			int departmentId, String departmentName, double type1,
			double type2, double type3, double type4, double type5,
			double type6, double type7, double type8, double type9,
			double type10, double type11, double type12, double type13,double type14,
			double total, double days) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.type1 = type1;
		this.type2 = type2;
		this.type3 = type3;
		this.type4 = type4;
		this.type5 = type5;
		this.type6 = type6;
		this.type7 = type7;
		this.type8 = type8;
		this.type9 = type9;
		this.type10 = type10;
		this.type11 = type11;
		this.type12 = type12;
		this.type13 = type13;
		this.type14 = type14;
		this.total = total;
		this.days = days;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public double getType1() {
		return type1;
	}
	public void setType1(double type1) {
		this.type1 = type1;
	}
	public double getType2() {
		return type2;
	}
	public void setType2(double type2) {
		this.type2 = type2;
	}
	public double getType3() {
		return type3;
	}
	public void setType3(double type3) {
		this.type3 = type3;
	}
	public double getType4() {
		return type4;
	}
	public void setType4(double type4) {
		this.type4 = type4;
	}
	public double getType5() {
		return type5;
	}
	public void setType5(double type5) {
		this.type5 = type5;
	}
	public double getType6() {
		return type6;
	}
	public void setType6(double type6) {
		this.type6 = type6;
	}
	public double getType7() {
		return type7;
	}
	public void setType7(double type7) {
		this.type7 = type7;
	}
	public double getType8() {
		return type8;
	}
	public void setType8(double type8) {
		this.type8 = type8;
	}
	public double getType9() {
		return type9;
	}
	public void setType9(double type9) {
		this.type9 = type9;
	}
	public double getType10() {
		return type10;
	}
	public void setType10(double type10) {
		this.type10 = type10;
	}
	public double getType11() {
		return type11;
	}
	public void setType11(double type11) {
		this.type11 = type11;
	}
	public double getType12() {
		return type12;
	}
	public void setType12(double type12) {
		this.type12 = type12;
	}
	public double getType13() {
		return type13;
	}
	public void setType13(double type13) {
		this.type13 = type13;
	}
	public double getType14() {
		return type14;
	}
	public void setType14(double type14) {
		this.type14 = type14;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getDays() {
		return days;
	}
	public void setDays(double days) {
		this.days = days;
	}
	@Override
	public String toString() {
		return "Att_AttendanceCollect [employeeId=" + employeeId
				+ ", employeeName=" + employeeName + ", departmentId="
				+ departmentId + ", departmentName=" + departmentName
				+ ", type1=" + type1 + ", type2=" + type2 + ", type3=" + type3
				+ ", type4=" + type4 + ", type5=" + type5 + ", type6=" + type6
				+ ", type7=" + type7 + ", type8=" + type8 + ", type9=" + type9
				+ ", type10=" + type10 + ", type11=" + type11 + ", type12="
				+ type12 + ", type13=" + type13 +", type14=" + type14 + ", total=" + total
				+ ", days=" + days + "]";
	}
	
}
