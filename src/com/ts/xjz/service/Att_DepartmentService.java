package com.ts.xjz.service;

import java.util.ArrayList;
import java.util.Map;

import com.ts.xjz.entity.Att_Department;

public interface Att_DepartmentService {
	/**
	 * ��Ӳ���
	 * @param department
	 * @return
	 */
	public boolean addAtt_Department(Att_Department department);
	/**
	 * ����IDɾ������
	 * @param departmentid
	 * @return
	 */
	public boolean delectAtt_Department(int departmentid);
	/**
	 * ����ID�޸Ĳ���
	 * @param departmentid
	 * @return
	 */
	public boolean updateAtt_Department(Att_Department department);
	/**
	 * ����Att_Departmentһ���б�
	 * @return
	 */
	public ArrayList<Map<String,Object>> findAtt_Department();
	/**
	 * ����Att_Department�����б�
	 * @return
	 */
	public ArrayList<Map<String,Object>> findAllAtt_Department();
	/**
	 * ����Att_Department����һ���б�
	 * @return
	 */
	public ArrayList<Map<String,Object>> findAllFirstAtt_Department();
	/**
	 * ����ID����һ������
	 * @param departmentid
	 * @return
	 */
	public Att_Department findAtt_Department(int departmentid);
	/**
	 * ����parentId����һ�������б����
	 * @param parentId
	 * @return
	 */
	public ArrayList<Att_Department> findDepartmentByParentId(int parentId);
}
