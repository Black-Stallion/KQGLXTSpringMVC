package com.ts.xjz.serviceimpl;

import javax.annotation.Resource;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ts.xjz.dao.Att_AdminDao;
import com.ts.xjz.entity.Att_Admin;
import com.ts.xjz.service.Att_AdminService;
@Service("att_adminService")
@Transactional(rollbackFor=Exception.class)//事物配置,有异常回滚
public class Att_AdminServiceImpl implements Att_AdminService {
	//调用事物处理
	@Resource
	DataSourceTransactionManager dataSourceTransactionManager;
	@Resource(name="att_adminDao")
	Att_AdminDao att_adminDao;
	@Override
	public Att_Admin loginAdmin(String adminAccount, String adminPwd) {
		return att_adminDao.loginAdmin(adminAccount, adminPwd);
	}

	@Override
	public boolean findAdmin(String adminAccount) {
		boolean result = false;
		Att_Admin admin = att_adminDao.findAdmin(adminAccount);
		if(admin!=null){
			result = true;
		}
		return result;
	}

	@Override
	public Att_Admin findPWD(int adminID) {
		return att_adminDao.findPWD(adminID);
	}

	@Override
	public boolean updateAdminPWD(String adminpwd, int adminID) {
		int result = -1;
		result = att_adminDao.updateAdminPWD(adminpwd, adminID);
		if(result > 0){
			return true;
		}else{
			return false;
		}
	}

}
