package com.ts.xjz.service;

import com.ts.xjz.entity.Att_Admin;

public interface Att_AdminService {
	/**
	 * �����û��������룬����һ��Att_Admin
	 * @param adminAccount
	 * @param adminPwd
	 * @return
	 */
	public Att_Admin loginAdmin(String adminAccount,String adminPwd);
	/**
	 * �����û���������һ��Att_Admin
	 * @param adminAccount
	 * @return
	 */
	public boolean findAdmin(String adminAccount);
	
	public Att_Admin findPWD (int adminID);
	
	public boolean updateAdminPWD(String adminpwd,int adminID);
}
