package com.ts.xjz.service;

import java.util.ArrayList;
import java.util.Map;

import com.ts.xjz.entity.Att_AttendanceType;

public interface Att_AttendanceTypeService {
	/**
	 * ��ӳ������
	 * @param Type
	 * @return
	 */
	public boolean addAtt_AttendanceType(Att_AttendanceType Type);
	/**
	 * ����ID��ɾ���������
	 * @param typeId
	 * @return
	 */
	public boolean deleteAtt_AttendanceType(int typeId);
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
