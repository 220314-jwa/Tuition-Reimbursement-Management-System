package com.trms.models;

public class Status {
	
	private long statusId;
	private String statusName;
	
	public Status(long statusId, String statusName) {
		this.statusId = statusId;
		this.statusName = statusName;
	}
	
	public Status() {
		this.statusId = 0;
		this.statusName = "";
	}

	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	
	
}
