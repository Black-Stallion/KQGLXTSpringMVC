package com.ts.xjz.serviceimpl;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ts.xjz.dao.Att_DepartmentDao;
import com.ts.xjz.entity.Att_Department;
import com.ts.xjz.service.Att_DepartmentService;
@Service("att_departmentService")
@Transactional(rollbackFor=Exception.class)//事物配置,有异常回滚
public class Att_DepartmentServieImpl implements Att_DepartmentService{
	//调用事物处理
	@Resource
	DataSourceTransactionManager dataSourceTransactionManager;
	@Resource(name="att_departmentDao")
	Att_DepartmentDao att_departmentDao;
	@Override
	public boolean addAtt_Department(Att_Department department) {
		int result = -1;
		result = att_departmentDao.addAtt_Department(department);
		if(result>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean delectAtt_Department(int departmentid) {
		int result = -1;
		result = att_departmentDao.delectAtt_Department(departmentid);
		if(result>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateAtt_Department(Att_Department department) {
		int result = -1;
		result = att_departmentDao.updateAtt_Department(department);
		if(result>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public ArrayList<Map<String, Object>> findAtt_Department() {
		return att_departmentDao.findAtt_Department();
	}

	@Override
	public ArrayList<Map<String, Object>> findAllAtt_Department() {
		return att_departmentDao.findAllAtt_Department();
	}
	
	@Override
	public ArrayList<Map<String, Object>> findAllFirstAtt_Department() {
		return att_departmentDao.findAllFirstAtt_Department();
	}
	
	@Override
	public Att_Department findAtt_Department(int departmentid) {
		return att_departmentDao.findAtt_Department(departmentid);
	}

	@Override
	public ArrayList<Att_Department> findDepartmentByParentId(int parentId) {
		return att_departmentDao.findDepartmentByParentId(parentId);
	}

}
