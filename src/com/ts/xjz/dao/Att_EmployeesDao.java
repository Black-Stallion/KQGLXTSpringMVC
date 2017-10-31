package com.ts.xjz.dao;

import java.util.ArrayList;
import java.util.Map;

import com.ts.xjz.entity.Att_Employees;

public interface Att_EmployeesDao {
	/**
	 * ����û�
	 * @param employee
	 * @return
	 */
	public int addAtt_Employees(Att_Employees employee);
	/**
	 * ����ID�޸��û�
	 * @param employee
	 * @return
	 */
	public int updateAtt_Employees(Att_Employees employee);
	/**
	 * ����IDɾ���û�
	 * @param employeeID
	 * @return
	 */
	public int deleteAtt_Employees(int employeeID);
	/**
	 * �����û����󼯺�
	 * @return
	 */
	public ArrayList<Map<String,Object>> finEmployee();
	/**
	 * ����ID�����û�����
	 * @param employeeID
	 * @return
	 */
	public Att_Employees findEmployess(int employeeID);
	/**
	 * �����û������Ͳ���ID����һ�����󼯺�
	 * @param employeeName
	 * @param departmentID
	 * @return
	 */
	public  ArrayList<Att_Employees> findEmployess(String employeeName,int departmentID);
	/**
	 * �����û���������һ�����󼯺�
	 * @param employeeName
	 * @return
	 */
	public  ArrayList<Att_Employees> findEmployess(String employeeName);
	/**
	 * ���ݲ���ID����һ�����󼯺�
	 * @param employeeName
	 * @return
	 */
	public  ArrayList<Att_Employees> findEmployesslist(int departmentID);
	/**
	 * ��ҳ����
	 * @param page1
	 * @param page2
	 * @return
	 */
	public ArrayList<Map<String,Object>> findEmployesslist(int page1,int page2);
	/**
	 * ����Ա������
	 * @return
	 */
	public int findEmployessCount();
	public Att_Employees findEmployeeByCardID( String cardNumber ); 
	public ArrayList<Att_Employees> findEmployee(Att_Employees entity);
}
