package com.ts.xjz.entity;

import java.io.Serializable;

public class Att_Admin implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int adminID;
	 private String adminAccount;
     private String adminPwd;
     private int adminState;
     private int adminRight;
     private String adminName;
	public Att_Admin() {
		super();
	}
	public Att_Admin(int adminID, String adminAccount, String adminPwd,
			int adminState, int adminRight, String adminName) {
		super();
		this.adminID = adminID;
		this.adminAccount = adminAccount;
		this.adminPwd = adminPwd;
		this.adminState = adminState;
		this.adminRight = adminRight;
		this.adminName = adminName;
	}
	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	public String getAdminAccount() {
		return adminAccount;
	}
	public void setAdminAccount(String adminAccount) {
		this.adminAccount = adminAccount;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	public int getAdminState() {
		return adminState;
	}
	public void setAdminState(int adminState) {
		this.adminState = adminState;
	}
	public int getAdminRight() {
		return adminRight;
	}
	public void setAdminRight(int adminRight) {
		this.adminRight = adminRight;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	@Override
	public String toString() {
		return "Att_Admin [adminID=" + adminID + ", adminAccount="
				+ adminAccount + ", adminPwd=" + adminPwd + ", adminState="
				+ adminState + ", adminRight=" + adminRight + ", adminName="
				+ adminName + "]";
	}
     
}
