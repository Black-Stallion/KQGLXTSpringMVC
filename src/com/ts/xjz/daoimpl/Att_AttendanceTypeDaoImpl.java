package com.ts.xjz.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ts.xjz.dao.Att_AttendanceTypeDao;
import com.ts.xjz.entity.Att_AttendanceType;
@Repository("att_AttendanceTypeDao")
public class Att_AttendanceTypeDaoImpl implements Att_AttendanceTypeDao {
	@Resource
	JdbcTemplate jt;
	@Override
	public int addAtt_AttendanceType(Att_AttendanceType Type) {
		int result  = -1;
		String sql = "insert into Att_AttendanceType(typeName,typeCategory) values (?,?)";
		result = jt.update(sql, new Object[]{Type.getTypeName(),Type.getTypeCategory()});
		return result;
	}

	@Override
	public int deleteAtt_AttendanceType(int typeId) {
		int result  = -1;
		String sql = "delete from Att_AttendanceType where typeId=?";
		result = jt.update(sql, new Object[]{typeId});
		return result;
	}

	@Override
	public ArrayList<Map<String, Object>> listType() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String sql = "select * from Att_AttendanceType order by typeId";
		list = jt.queryForList(sql);
		return (ArrayList<Map<String, Object>>) list;
	}

	@Override
	public ArrayList<Map<String, Object>> listType1() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String sql = "select * from Att_AttendanceType where typeCategory>0 order by typeId";
		list = jt.queryForList(sql);
		return (ArrayList<Map<String, Object>>) list;
	}

}
