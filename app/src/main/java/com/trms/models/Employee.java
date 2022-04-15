package com.trms.models;

import java.util.Objects;

public class Employee {
	private long id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private long managerId;
	private long deptId;

public Employee(String firstName, String lastName, String userName, String password, String email, long managerId,
		long deptId,long id) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.userName = userName;
	this.password = password;
	this.email = email;
	this.managerId = managerId;
	this.deptId = deptId;
	this.id = id;
}
public Employee() {
	
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

public long getManagerId() {
	return managerId;
}
public void setManagerId(long managerId) {
	this.managerId = managerId;
}
public long getDeptId() {
	return deptId;
}
public void setDeptId(long deptId) {
	this.deptId = deptId;
}

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
@Override
public int hashCode() {
	return Objects.hash(deptId, email, firstName, id, lastName, managerId, password, userName);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Employee other = (Employee) obj;
	return deptId == other.deptId && Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
			&& id == other.id && Objects.equals(lastName, other.lastName) && managerId == other.managerId
			&& Objects.equals(password, other.password) && Objects.equals(userName, other.userName);
}
@Override
public String toString() {
	return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
			+ ", password=" + password + ", email=" + email + ", managerId=" + managerId + ", deptId=" + deptId + "]";
}
 
}
