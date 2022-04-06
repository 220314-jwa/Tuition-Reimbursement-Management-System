package com.trms.models;

public class Department {
	private long id;
	private String deptName;
	private long headId;
	
	public Department(long id, String deptName, long headId) {
		this.id = id;
		this.deptName = deptName;
		this.headId = headId;
	}
	
	public Department() {
		super();
		this.id = 0;
		this.deptName = "";
		this.headId = 0;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public long getHeadId() {
		return headId;
	}

	public void setHeadId(long headId) {
		this.headId = headId;
	}
	
	
	

}
