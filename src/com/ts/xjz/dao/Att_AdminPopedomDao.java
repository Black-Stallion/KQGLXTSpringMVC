package com.ts.xjz.dao;

import java.util.ArrayList;
import java.util.Map;

import com.ts.xjz.entity.Att_AdminPopedom;


public interface Att_AdminPopedomDao {
	/* 
	select adminid,AdminRight,adminstate from att_admin from adminaccount = ? 
	and adminpwd = ? 

	--�õ� �Ƿ���ϵͳ����Ա �� ����Ա

	-- ����ǿ���Ա�����Ǽ��� ��ѯ�������Ա ��Ӧ�Ĳ��� 
	
	/*
	   --- �����б� List<Integer> , 10001*1002*1003

	select * from att_admin inner join Att_AdminPopedom on att_admin.adminid =
			Att_AdminPopedom.adminid where 
			att_admin.adminid = ?
	ϵͳ����Ա�� adminid , adminaccount , AdminRight 
	����Ա�� adminid , adminaccount , AdminRight  , ���ű���б�
		 * */
	/**
	 * ����Ȩ���б�
	 * @param adminID
	 * @return
	 */
	public ArrayList<Map<String,Att_AdminPopedom>> getList(int adminID);
}
