package com.ts.xjz.dao;
import com.ts.xjz.entity.Att_Admin;

public interface Att_AdminDao {
	
	/**
	 * 根据用户名和密码，返回一个Att_Admin
	 * @param adminAccount
	 * @param adminPwd
	 * @return
	 */
	public Att_Admin loginAdmin(String adminAccount,String adminPwd);
	/**
	 * 根据用户名，返回一个Att_Admin
	 * @param adminAccount
	 * @return
	 */
	public Att_Admin findAdmin(String adminAccount);
	public Att_Admin findPWD (int adminID);
	public int updateAdminPWD(String adminpwd,int adminID);
}
