package com.ts.xjz.entity;

import java.io.Serializable;

public class Att_AdminPopedom implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int popedomID;
	private int DepartmentID;
	private int AdminID;
	public Att_AdminPopedom() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Att_AdminPopedom(int popedomID, int departmentID, int adminID) {
		super();
		this.popedomID = popedomID;
		DepartmentID = departmentID;
		AdminID = adminID;
	}
	public int getPopedomID() {
		return popedomID;
	}
	public void setPopedomID(int popedomID) {
		this.popedomID = popedomID;
	}
	public int getDepartmentID() {
		return DepartmentID;
	}
	public void setDepartmentID(int departmentID) {
		DepartmentID = departmentID;
	}
	public int getAdminID() {
		return AdminID;
	}
	public void setAdminID(int adminID) {
		AdminID = adminID;
	}
	@Override
	public String toString() {
		return "Att_AdminPopedom [popedomID=" + popedomID + ", DepartmentID="
				+ DepartmentID + ", AdminID=" + AdminID + "]";
	}
}
