package com.ts.xjz.entity;

import java.io.Serializable;

public class Att_AttendanceType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int typeId;
    private String typeName;
    private int typeCategory;
	public Att_AttendanceType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Att_AttendanceType(int typeId, String typeName, int typeCategory) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.typeCategory = typeCategory;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public int getTypeCategory() {
		return typeCategory;
	}
	public void setTypeCategory(int typeCategory) {
		this.typeCategory = typeCategory;
	}
	@Override
	public String toString() {
		return "Att_AttendanceType [typeId=" + typeId + ", typeName="
				+ typeName + ", typeCategory=" + typeCategory + "]";
	}
}
