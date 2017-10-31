package com.ts.xjz.entity;

import java.io.Serializable;

public class Att_Employees implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int employeeID;
    private String employeeName;
    private int employeeGender;
    private int positionID;
    private int departmentID;
    private String cardNumber;
    private char employeeStatc;
    private String employeeMemo;
	public Att_Employees(int employeeID, String employeeName,
			int employeeGender, int positionID, int departmentID,
			String cardNumber, char employeeStatc, String employeeMemo) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.employeeGender = employeeGender;
		this.positionID = positionID;
		this.departmentID = departmentID;
		this.cardNumber = cardNumber;
		this.employeeStatc = employeeStatc;
		this.employeeMemo = employeeMemo;
	}
	public Att_Employees() {
		super();
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getEmployeeGender() {
		return employeeGender;
	}
	public void setEmployeeGender(int employeeGender) {
		this.employeeGender = employeeGender;
	}
	public int getPositionID() {
		return positionID;
	}
	public void setPositionID(int positionID) {
		this.positionID = positionID;
	}
	public int getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public char getEmployeeStatc() {
		return employeeStatc;
	}
	public void setEmployeeStatc(char employeeStatc) {
		this.employeeStatc = employeeStatc;
	}
	public String getEmployeeMemo() {
		return employeeMemo;
	}
	public void setEmployeeMemo(String employeeMemo) {
		this.employeeMemo = employeeMemo;
	}
	@Override
	public String toString() {
		return "Att_Employees [employeeID=" + employeeID + ", employeeName="
				+ employeeName + ", employeeGender=" + employeeGender
				+ ", positionID=" + positionID + ", departmentID="
				+ departmentID + ", cardNumber=" + cardNumber
				+ ", employeeStatc=" + employeeStatc + ", employeeMemo="
				+ employeeMemo + "]";
	}
}
