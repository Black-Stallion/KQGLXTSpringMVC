package com.ts.xjz.entityrowmapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ts.xjz.entity.Att_Position;

public class Att_PositionRowMap implements RowMapper<Att_Position>{

	@Override
	public Att_Position mapRow(ResultSet rs, int arg1) throws SQLException {
		Att_Position position = new Att_Position(rs.getInt("positionID"),rs.getString("positionName"));
		return position;
	}

}
