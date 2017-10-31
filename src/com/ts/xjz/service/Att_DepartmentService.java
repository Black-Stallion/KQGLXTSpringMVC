package com.ts.xjz.service;

import java.util.ArrayList;
import java.util.Map;

import com.ts.xjz.entity.Att_Department;

public interface Att_DepartmentService {
	/**
	 * 添加部门
	 * @param department
	 * @return
	 */
	public boolean addAtt_Department(Att_Department department);
	/**
	 * 根据ID删除部门
	 * @param departmentid
	 * @return
	 */
	public boolean delectAtt_Department(int departmentid);
	/**
	 * 根据ID修改部门
	 * @param departmentid
	 * @return
	 */
	public boolean updateAtt_Department(Att_Department department);
	/**
	 * 返回Att_Department一级列表
	 * @return
	 */
	public ArrayList<Map<String,Object>> findAtt_Department();
	/**
	 * 返回Att_Department所有列表
	 * @return
	 */
	public ArrayList<Map<String,Object>> findAllAtt_Department();
	/**
	 * 返回Att_Department所有一级列表
	 * @return
	 */
	public ArrayList<Map<String,Object>> findAllFirstAtt_Department();
	/**
	 * 根据ID返回一个对象
	 * @param departmentid
	 * @return
	 */
	public Att_Department findAtt_Department(int departmentid);
	/**
	 * 根据parentId返回一个部门列表对象
	 * @param parentId
	 * @return
	 */
	public ArrayList<Att_Department> findDepartmentByParentId(int parentId);
}
