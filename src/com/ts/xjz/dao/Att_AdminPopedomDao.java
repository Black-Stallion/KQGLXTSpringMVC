package com.ts.xjz.dao;

import java.util.ArrayList;
import java.util.Map;

import com.ts.xjz.entity.Att_AdminPopedom;


public interface Att_AdminPopedomDao {
	/* 
	select adminid,AdminRight,adminstate from att_admin from adminaccount = ? 
	and adminpwd = ? 

	--得到 是否是系统管理员 ， 考勤员

	-- 如果是考勤员，我们继续 查询这个考勤员 对应的部门 
	
	/*
	   --- 部门列表 List<Integer> , 10001*1002*1003

	select * from att_admin inner join Att_AdminPopedom on att_admin.adminid =
			Att_AdminPopedom.adminid where 
			att_admin.adminid = ?
	系统管理员： adminid , adminaccount , AdminRight 
	考勤员： adminid , adminaccount , AdminRight  , 部门编号列表
		 * */
	/**
	 * 返回权限列表
	 * @param adminID
	 * @return
	 */
	public ArrayList<Map<String,Att_AdminPopedom>> getList(int adminID);
}
