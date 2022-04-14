package com.trms.services;

import java.sql.SQLException;
import java.util.List;

import com.trms.data.DaoFactory;
import com.trms.data.EmplDAO;
import com.trms.data.ReimbursementDAO;
import com.trms.exceptions.EmplAlreadyExistsException;
import com.trms.exceptions.IncorrectCredentialsException;
import com.trms.models.Employee;
import com.trms.models.Reimbursement;

public class UserServiceImpl implements UserService {
	EmplDAO emplDao = DaoFactory.geEmplDAO() ;
	ReimbursementDAO reimDAO = DaoFactory.getReimbursementDAO();
	
	public Employee logIn(String username, String password) throws IncorrectCredentialsException {
		//String pass = "abcd";
		//String userName = "Rustem";
		Employee user = emplDao.getByUsername(username);
		if(user!=null) {
			if(password.equals(user.getPassword())) {
				System.out.println("You logged in!");
			}else {
				System.out.println("Your password is wrong!");
			}
		}else {
			System.out.println("User does not exist!");
		}
		return  user;
	}

	public Employee register(Employee newEmployee) throws EmplAlreadyExistsException, SQLException {
		
		Employee existingUser = emplDao.getByUsername(newEmployee.getUserName());
		if (existingUser!=null) {
			throw new EmplAlreadyExistsException();
		}
		
		long emplId = emplDao.create(newEmployee);
		//System.out.println(emplId);
		return emplDao.getById(emplId);
	}
	
	public List<Reimbursement> viewReimbursements(Employee employee) {
		
		List<Reimbursement> reimbursements = reimDAO.getAllByEmployee(employee);
		
		return reimbursements;
		
	}

	@Override
	public List<Reimbursement> getReimbursementsByStatus(String status) {
		List<Reimbursement> reimbursements = reimDAO.getReimbursementsByStatus(status);
		return reimbursements;
	}
	
	public Employee getUserById(long id) {
		
		Employee user = emplDao.getById(id);
		
		return user;
		
	}
	



}
