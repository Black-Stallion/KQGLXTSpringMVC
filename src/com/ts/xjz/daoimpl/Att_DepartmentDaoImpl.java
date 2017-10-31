package com.ts.xjz.daoimpl;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ts.xjz.dao.Att_DepartmentDao;
import com.ts.xjz.entity.Att_Department;
import com.ts.xjz.entityrowmapping.Att_DepartmentRowMap;
@Repository("att_departmentDao")
public class Att_DepartmentDaoImpl implements Att_DepartmentDao{
	@Resource
	JdbcTemplate jdbcTemplate;
	@Override
	public int addAtt_Department(Att_Department department) {
		int result = -1;
		String sql = "insert into Att_Department(DepartmentName,StartTimeAM,EndTimeAM,StartTimePM," +
				"EndTimePM,WeekType,parentID) values(?,?,?,?,?,?,?)";
		result = jdbcTemplate.update(sql,new Object[]{department.getDepartmentName(),
				department.getStartTimeAM(),department.getEndTimeAM(),department.getStartTimePM(),
				department.getEndTimePM(),department.getWeekType(),department.getParentID()});
		return result;
	}

	@Override
	public int delectAtt_Department(int departmentid) {
		int result = -1;
		String sql = "delete from Att_Department where departmentid=?";
		result = jdbcTemplate.update(sql, new Object[]{departmentid});
		return result;
	}

	@Override
	public int updateAtt_Department(Att_Department department) {
		int result = -1;
		String sql = "update Att_Department set DepartmentName = ?,StartTimeAM = ?,EndTimeAM = ?,StartTimePM = ?," +
				"EndTimePM = ?,WeekType = ? where DepartmentID = ?";
		result = jdbcTemplate.update(sql,new Object[]{department.getDepartmentName(),
				department.getStartTimeAM(),department.getEndTimeAM(),department.getStartTimePM(),
				department.getEndTimePM(),department.getWeekType(),department.getDepartmentID()});
		return result;
	}

	@Override
	public ArrayList<Map<String, Object>> findAtt_Department() {
		String sql = "select DepartmentID,DepartmentName from Att_Department where ParentID = 0 ";
		return (ArrayList<Map<String, Object>>) jdbcTemplate.queryForList(sql);
	}
	
	@Override
	public ArrayList<Map<String, Object>> findAllAtt_Department() {
		String sql = "select DepartmentID,DepartmentName from Att_Department";
		return (ArrayList<Map<String, Object>>) jdbcTemplate.queryForList(sql);
	}
	
	@Override
	public ArrayList<Map<String, Object>> findAllFirstAtt_Department() {
		String sql = "select * from Att_Department where ParentID = 0";
		return (ArrayList<Map<String, Object>>) jdbcTemplate.queryForList(sql);
	}
	
	@Override
	public Att_Department findAtt_Department(int departmentid) {
		String sql = "select * from Att_Department where departmentID = ?";
		Att_Department department = null;
		try{
			department = jdbcTemplate.queryForObject(sql, new Object[]{departmentid},new Att_DepartmentRowMap());
		}catch(Exception e){
			e.printStackTrace();
			}
		return department;
	}

	@Override
	public ArrayList<Att_Department> findDepartmentByParentId(int parentId) {
		String sql = "select * from Att_Department where parentid = ?";
		ArrayList<Att_Department> list = null;
		try{
		list = (ArrayList<Att_Department>) jdbcTemplate.query(sql,new Object[]{parentId},new Att_DepartmentRowMap());
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

}
