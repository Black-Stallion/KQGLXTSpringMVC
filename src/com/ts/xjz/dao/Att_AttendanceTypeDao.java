package com.ts.xjz.dao;

import java.util.ArrayList;
import java.util.Map;

import com.ts.xjz.entity.Att_AttendanceType;


public interface Att_AttendanceTypeDao {
	/**
	 * ��ӳ������
	 * @param Type
	 * @return
	 */
	public int addAtt_AttendanceType(Att_AttendanceType Type);
	/**
	 * ����ID��ɾ���������
	 * @param typeId
	 * @return
	 */
	public int deleteAtt_AttendanceType(int typeId);
	/**
	 * �������г�������
	 * @return
	 */
	public ArrayList<Map<String,Object>> listType();
	/**
	 * ���������������
	 * @return
	 */
	public ArrayList<Map<String,Object>> listType1();
}
