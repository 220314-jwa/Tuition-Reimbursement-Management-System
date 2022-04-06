package com.trms.services;

import java.sql.SQLException;
import java.util.List;

import com.trms.exceptions.EmplAlreadyExistsException;
import com.trms.exceptions.IncorrectCredentialsException;
import com.trms.models.Employee;
import com.trms.models.*;

public interface UserService {

	public Employee logIn(String username, String password) throws IncorrectCredentialsException;
	
	/**
	 * creates a new employee. if the employee is available, 
	 * returns the new employee with their database-generated ID. 
	 * otherwise, throws a EmplAlreadyExistsException. 
	 * @param newEmployee
	 * @return Employee with newly generated ID
	 */
	public Employee register(Employee newEmployee) throws EmplAlreadyExistsException, SQLException;
	

	public List<Reimbursement> viewReimbursements(Employee employee);
	
	public List<Reimbursement> getReimbursementsByStatus(String status);
}

