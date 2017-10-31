package com.ts.xjz.dao;

import java.util.ArrayList;
import java.util.Map;

import com.ts.xjz.entity.Att_AttendanceType;


public interface Att_AttendanceTypeDao {
	/**
	 * 添加出勤类别
	 * @param Type
	 * @return
	 */
	public int addAtt_AttendanceType(Att_AttendanceType Type);
	/**
	 * 根据ID来删除出勤类别
	 * @param typeId
	 * @return
	 */
	public int deleteAtt_AttendanceType(int typeId);
	/**
	 * 查找所有出勤类型
	 * @return
	 */
	public ArrayList<Map<String,Object>> listType();
	/**
	 * 查找所有请假类型
	 * @return
	 */
	public ArrayList<Map<String,Object>> listType1();
}
