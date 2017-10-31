package com.ts.xjz.serviceimpl;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ts.xjz.dao.Att_PositionDao;
import com.ts.xjz.entity.Att_Position;
import com.ts.xjz.service.Att_PositionService;
@Service("att_PositionService")
@Transactional(rollbackFor=Exception.class)//事物配置,有异常回滚
public class Att_PositionServiceImpl implements Att_PositionService{
	//调用事物处理
	@Resource
	DataSourceTransactionManager dataSourceTransactionManager;
	@Resource(name="att_PositionDao")
	Att_PositionDao att_PositionDao;
	@Override
	public boolean addAtt_Position(Att_Position position) {
		int result = -1;
		result = att_PositionDao.addAtt_Position(position);
		if(result>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean delectAtt_Position(int positionID) {
		int result = -1;
		result = att_PositionDao.delectAtt_Position(positionID);
		if(result>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateAtt_Position(Att_Position position) {
		int result = -1;
		result = att_PositionDao.updateAtt_Position(position);
		if(result>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public ArrayList<Map<String, Object>> findAtt_Position() {
		return att_PositionDao.findAtt_Position();
	}

	@Override
	public Att_Position findAtt_Position(int positionID) {
		return att_PositionDao.findAtt_Position(positionID);
	}

}
