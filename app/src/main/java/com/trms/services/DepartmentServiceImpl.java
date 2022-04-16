package com.trms.services;

import java.util.List;

import com.trms.data.DaoFactory;
import com.trms.data.DeptDAO;
import com.trms.models.Department;

public class DepartmentServiceImpl implements DepartmentService {
	
	private DeptDAO deptDAO = DaoFactory.getDeptDao();
	
	@Override
	public List<Department> getAllDepartments() {
		
		return deptDAO.getAll();
	}

}
