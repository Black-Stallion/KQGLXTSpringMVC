package com.ts.xjz.daoimpl;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ts.xjz.dao.Att_PositionDao;
import com.ts.xjz.entity.Att_Position;
import com.ts.xjz.entityrowmapping.Att_PositionRowMap;
@Repository("att_PositionDao")
public class Att_PositionDaoImpl implements Att_PositionDao{
	@Resource
	JdbcTemplate jdbcTemplate;
	@Override
	public int addAtt_Position(Att_Position position) {
		int result = -1;
		String sql = "insert into Att_Position(positionName) values(?)";
		result = jdbcTemplate.update(sql, new Object[]{position.getPositionName()});
		return result;
	}

	@Override
	public int delectAtt_Position(int positionID) {
		int result = -1;
		String sql = "delete from Att_Position where positionID=?";
		result = jdbcTemplate.update(sql, new Object[]{positionID});
		return result;
	}

	@Override
	public int updateAtt_Position(Att_Position position) {
		int result = -1;
		String sql = "update Att_Position set PositionName = ? where PositionID = ? ";
		result = jdbcTemplate.update(sql, new Object[]{position.getPositionName(),position.getPositionID()});
		return result;
	}

	@Override
	public ArrayList<Map<String,Object>> findAtt_Position() {
		String sql = "select * from Att_Position";
		ArrayList<Map<String,Object>> list = null;
		try {
			list = (ArrayList<Map<String,Object>>)jdbcTemplate.queryForList(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Att_Position findAtt_Position(int positionID) {
		String sql = "select * from Att_Position where positionID = ?";
		Att_Position position = null;
		try{
		position = jdbcTemplate.queryForObject(sql, new Object[]{positionID},new Att_PositionRowMap());
		}catch(Exception e){
			e.printStackTrace();
		}
		return position;
	}

}
