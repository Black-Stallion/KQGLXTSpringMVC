package com.ts.xjz.entityrowmapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ts.xjz.entity.Att_AttendanceType;

public class Att_AttendanceTypeRowMap implements RowMapper<Att_AttendanceType>{

	@Override
	public Att_AttendanceType mapRow(ResultSet rs, int arg1) throws SQLException {
		Att_AttendanceType type = new Att_AttendanceType(rs.getInt("typeId"),rs.getString("typeName"),rs.getInt("typeCategory"));
		return type;
	}

}
