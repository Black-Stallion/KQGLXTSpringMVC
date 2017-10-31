package com.ts.xjz.entity;

import java.io.Serializable;
import java.util.Date;

public class Att_OverTimeRecord implements Serializable {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private int overtimeID;
		private int employeeID;
		private Date overtimeDate;
		private int overtimeFlag;
		private int overtimeState;
		private int noteID;
		private String employeeName;//…Í«Î»À
		public String getEmployeeName() {
			return employeeName;
		}
		public void setEmployeeName(String employeeName) {
			this.employeeName = employeeName;
		}
		public Att_OverTimeRecord() {
			super();
		}
		public Att_OverTimeRecord(int overtimeID, int employeeID,
				Date overtimeDate, char overtimeFlag, char overtimeState,
				int noteID,String employeeName) {
			super();
			this.overtimeID = overtimeID;
			this.employeeID = employeeID;
			this.overtimeDate = overtimeDate;
			this.overtimeFlag = overtimeFlag;
			this.overtimeState = overtimeState;
			this.noteID = noteID;
			this.employeeName = employeeName;
		}
		public int getOvertimeID() {
			return overtimeID;
		}
		public void setOvertimeID(int overtimeID) {
			this.overtimeID = overtimeID;
		}
		public int getEmployeeID() {
			return employeeID;
		}
		public void setEmployeeID(int employeeID) {
			this.employeeID = employeeID;
		}
		public Date getOvertimeDate() {
			return overtimeDate;
		}
		public void setOvertimeDate(Date overtimeDate) {
			this.overtimeDate = overtimeDate;
		}
		public int getOvertimeFlag() {
			return overtimeFlag;
		}
		public void setOvertimeFlag(int overtimeFlag) {
			this.overtimeFlag = overtimeFlag;
		}
		public int getOvertimeState() {
			return overtimeState;
		}
		public void setOvertimeState(int overtimeState) {
			this.overtimeState = overtimeState;
		}
		public int getNoteID() {
			return noteID;
		}
		public void setNoteID(int noteID) {
			this.noteID = noteID;
		}
		@Override
		public String toString() {
			return "Att_OverTimeRecord [overtimeID=" + overtimeID
					+ ", employeeID=" + employeeID + ", overtimeDate="
					+ overtimeDate + ", overtimeFlag=" + overtimeFlag
					+ ", overtimeState=" + overtimeState + ", noteID=" + noteID
					+ ", employeeName=" + employeeName + "]";
		}
		
	}
