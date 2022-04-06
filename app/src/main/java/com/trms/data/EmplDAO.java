package com.trms.data;

import com.trms.models.Employee;

public interface EmplDAO extends GenericDAO<Employee> {

	public abstract Employee getByEmail(String email);
	
	public abstract Employee getByUsername(String username);
	
}
