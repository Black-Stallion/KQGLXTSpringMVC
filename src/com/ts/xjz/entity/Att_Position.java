package com.ts.xjz.entity;

import java.io.Serializable;

public class Att_Position implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int positionID ;
    private String positionName;
	public Att_Position(int positionID, String positionName) {
		super();
		this.positionID = positionID;
		this.positionName = positionName;
	}
	public Att_Position() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPositionID() {
		return positionID;
	}
	public void setPositionID(int positionID) {
		this.positionID = positionID;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	@Override
	public String toString() {
		return "Att_Position [positionID=" + positionID + ", positionName="
				+ positionName + "]";
	}
	
}
