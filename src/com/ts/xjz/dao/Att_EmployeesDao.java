package com.ts.xjz.dao;

import java.util.ArrayList;
import java.util.Map;

import com.ts.xjz.entity.Att_Employees;

public interface Att_EmployeesDao {
	/**
	 * 添加用户
	 * @param employee
	 * @return
	 */
	public int addAtt_Employees(Att_Employees employee);
	/**
	 * 根据ID修改用户
	 * @param employee
	 * @return
	 */
	public int updateAtt_Employees(Att_Employees employee);
	/**
	 * 根据ID删除用户
	 * @param employeeID
	 * @return
	 */
	public int deleteAtt_Employees(int employeeID);
	/**
	 * 发挥用户对象集合
	 * @return
	 */
	public ArrayList<Map<String,Object>> finEmployee();
	/**
	 * 各级ID返回用户对象
	 * @param employeeID
	 * @return
	 */
	public Att_Employees findEmployess(int employeeID);
	/**
	 * 根据用户姓名和部门ID返回一个对象集合
	 * @param employeeName
	 * @param departmentID
	 * @return
	 */
	public  ArrayList<Att_Employees> findEmployess(String employeeName,int departmentID);
	/**
	 * 根据用户姓名返回一个对象集合
	 * @param employeeName
	 * @return
	 */
	public  ArrayList<Att_Employees> findEmployess(String employeeName);
	/**
	 * 根据部门ID返回一个对象集合
	 * @param employeeName
	 * @return
	 */
	public  ArrayList<Att_Employees> findEmployesslist(int departmentID);
	/**
	 * 分页管理
	 * @param page1
	 * @param page2
	 * @return
	 */
	public ArrayList<Map<String,Object>> findEmployesslist(int page1,int page2);
	/**
	 * 返回员工人数
	 * @return
	 */
	public int findEmployessCount();
	public Att_Employees findEmployeeByCardID( String cardNumber ); 
	public ArrayList<Att_Employees> findEmployee(Att_Employees entity);
}
