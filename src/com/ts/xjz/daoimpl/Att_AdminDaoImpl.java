package com.ts.xjz.daoimpl;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ts.xjz.dao.Att_AdminDao;
import com.ts.xjz.entity.Att_Admin;
import com.ts.xjz.entityrowmapping.Att_AdminRowMap;

@Repository("att_adminDao")
public class Att_AdminDaoImpl implements Att_AdminDao {
	@Resource
	JdbcTemplate jdbcTemplate;
	@Override
	public Att_Admin loginAdmin(String adminAccount, String adminPwd) {
		String sql ="select AdminID,Adminaccount,AdminState,AdminRight,AdminName from att_admin"
				+ " where AdminAccount = ? and AdminPwd = ?";																	
		Att_Admin att_admin = null;
		try{
			att_admin = (Att_Admin) jdbcTemplate.queryForObject(sql,new Object[]{adminAccount,adminPwd},((RowMapper<Att_Admin>)(rs,index)->
			new Att_Admin(rs.getInt("AdminID"),rs.getString("Adminaccount"),null,rs.getInt("AdminState"),rs.getInt("AdminRight"),rs.getString("AdminName"))
			));
		}catch(Exception e){
		}
//		Att_Admin att_admin = (Att_Admin) jdbcTemplate.queryForObject(sql,new Object[]{adminAccount,adminPwd},new Att_AdminRowMappingUtil());
		return att_admin;
	}
//	@Override
//	public ArrayList<Map<String, Object>> queryAll() {
//		String sql = "select * from Att_Admin";
//		System.out.println(jdbcTemplate.queryForList(sql));
//		return (ArrayList<Map<String, Object>>) jdbcTemplate.queryForList(sql);
//	}
	@Override
	public Att_Admin findAdmin(String adminAccount) {
		Att_Admin att_admin = null;
		String sql = "select * from att_admin where AdminAccount = ?";
		try{
			att_admin = jdbcTemplate.queryForObject(sql, new Object[]{adminAccount},new Att_AdminRowMap());
		}catch(Exception e){
			e.printStackTrace();
		}
		return att_admin;
	}
	@Override
	public Att_Admin findPWD(int adminID) {
		Att_Admin att_admin = null;
		String sql = "select * from att_admin  where adminID = ?";
		try{
			att_admin = jdbcTemplate.queryForObject(sql, new Object[]{adminID},new Att_AdminRowMap());
		}catch(Exception e){
			e.printStackTrace();
		}
		return att_admin;
	}
	@Override
	public int updateAdminPWD(String adminpwd, int adminID) {
		int result = -1;
		String sql = "update Att_Admin set AdminPwd = ?  where adminID = ?";
		result = jdbcTemplate.update(sql, new Object[]{adminpwd,adminID});
		return result;
	}

}
