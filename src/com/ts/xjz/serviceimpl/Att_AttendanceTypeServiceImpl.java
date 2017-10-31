package com.ts.xjz.serviceimpl;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ts.xjz.dao.Att_AttendanceTypeDao;
import com.ts.xjz.entity.Att_AttendanceType;
import com.ts.xjz.service.Att_AttendanceTypeService;
@Service("TypeService")
@Transactional(rollbackFor=Exception.class)//��������,���쳣�ع�
public class Att_AttendanceTypeServiceImpl implements Att_AttendanceTypeService {
	//�������ﴦ��
	@Resource
	DataSourceTransactionManager dataSourceTransactionManager;
	//����Dao��
	@Resource(name="att_AttendanceTypeDao")
	Att_AttendanceTypeDao att_AttendanceTypeDao;
	@Override
	public boolean addAtt_AttendanceType(Att_AttendanceType Type) {
		int result = -1;
		result = att_AttendanceTypeDao.addAtt_AttendanceType(Type);
		if(result>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean deleteAtt_AttendanceType(int typeId) {
		int result = -1;
		result = att_AttendanceTypeDao.deleteAtt_AttendanceType(typeId);
		if(result>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public ArrayList<Map<String, Object>> listType() {
		return att_AttendanceTypeDao.listType();
	}

	@Override
	public ArrayList<Map<String, Object>> listType1() {
		// TODO Auto-generated method stub
		return att_AttendanceTypeDao.listType1();
	}

}
