package com.ts.xjz.entityrowmapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ts.xjz.entity.Att_Admin;

public class Att_AdminRowMap implements RowMapper<Att_Admin>{

	public Att_Admin mapRow(ResultSet rs, int arg1) throws SQLException {
		Att_Admin att_admin=new Att_Admin(rs.getInt("AdminID"),rs.getString("Adminaccount"),rs.getString("adminPwd"),rs.getInt("AdminState"),rs.getInt("AdminRight"),rs.getString("AdminName"));
		return att_admin;
	}
}
