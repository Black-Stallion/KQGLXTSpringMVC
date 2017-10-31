package com.ts.xjz.dao;

import java.util.ArrayList;
import java.util.Map;

import com.ts.xjz.entity.Att_Position;

public interface Att_PositionDao {
	/**
	 * 添加职位
	 * @param position
	 * @return
	 */
	public int addAtt_Position(Att_Position position);
	/**
	 * 根据ID删除部门
	 * @param positionID
	 * @return
	 */
	public int delectAtt_Position(int positionID);
	/**
	 * 根据ID来修改部门
	 * @param Att_Position
	 * @return
	 */
	public int updateAtt_Position(Att_Position position);
	/**
	 * 返回职位的ArrayList集合
	 * @return
	 */
	public ArrayList<Map<String,Object>> findAtt_Position();
	/**
	 * 根据ID来返回一个对象
	 * @param positionID
	 * @return
	 */
	public Att_Position findAtt_Position(int positionID);
}
