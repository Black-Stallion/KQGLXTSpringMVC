package com.ts.xjz.service;

import java.util.ArrayList;
import java.util.Map;

import com.ts.xjz.entity.Att_AttendanceType;

public interface Att_AttendanceTypeService {
	/**
	 * 添加出勤类别
	 * @param Type
	 * @return
	 */
	public boolean addAtt_AttendanceType(Att_AttendanceType Type);
	/**
	 * 根据ID来删除出勤类别
	 * @param typeId
	 * @return
	 */
	public boolean deleteAtt_AttendanceType(int typeId);
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
