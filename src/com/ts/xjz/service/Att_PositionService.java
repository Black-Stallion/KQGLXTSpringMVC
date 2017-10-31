package com.ts.xjz.service;

import java.util.ArrayList;
import java.util.Map;

import com.ts.xjz.entity.Att_Position;

public interface Att_PositionService {
	/**
	 * ���ְλ
	 * @param position
	 * @return
	 */
	public boolean addAtt_Position(Att_Position position);
	/**
	 * ����IDɾ������
	 * @param positionID
	 * @return
	 */
	public boolean delectAtt_Position(int positionID);
	/**
	 * ����ID���޸Ĳ���
	 * @param Att_Position
	 * @return
	 */
	public boolean updateAtt_Position(Att_Position position);
	/**
	 * ����ְλ��ArrayList����
	 * @return
	 */
	public ArrayList<Map<String,Object>> findAtt_Position();
	/**
	 * ����ID������һ������
	 * @param positionID
	 * @return
	 */
	public Att_Position findAtt_Position(int positionID);
}
