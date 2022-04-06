package com.trms.models;

import java.util.Objects;

public class User {
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private long managerId;
	private long deptId;

public User(String firstName, String lastName, String userName, String password, String email, long managerId,
		long deptId) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.userName = userName;
	this.password = password;
	this.email = email;
	this.managerId = managerId;
	this.deptId = deptId;
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
@Override
public int hashCode() {
	return Objects.hash(deptId, email, firstName, lastName, managerId, password, userName);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	return deptId == other.deptId && Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
			&& Objects.equals(lastName, other.lastName) && managerId == other.managerId
			&& Objects.equals(password, other.password) && Objects.equals(userName, other.userName);
}
@Override
public String toString() {
	return "User [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", password="
			+ password + ", email=" + email + ", managerId=" + managerId + ", deptId=" + deptId + "]";
}
 
}
