package com.ts.xjz.entityrowmapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ts.xjz.entity.Att_Department;
@Repository("att_departmentRowMappingUtil")
public class Att_DepartmentRowMap implements RowMapper<Att_Department>{

	@Override
	public Att_Department mapRow(ResultSet rs, int arg1) throws SQLException {
		Att_Department department = new Att_Department(rs.getInt("departmentID"),rs.getString("departmentName"),rs.getString("startTimeAM"),
				rs.getString("endTimeAM"),rs.getString("startTimePM"),rs.getString("endTimePM"),rs.getInt("weekType"),rs.getInt("parentID"));
		return department;
	}

}
