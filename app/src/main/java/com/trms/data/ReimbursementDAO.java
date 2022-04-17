package com.trms.data;

import java.util.List;

import com.trms.models.Employee;
import com.trms.models.Reimbursement;

public interface ReimbursementDAO extends GenericDAO<Reimbursement> {
	public abstract List<Reimbursement> getAllByEmployee(Employee employee);
	public abstract List<Reimbursement> getReimbursementsByStatus(String status);
	public abstract List<Reimbursement> getByManagerId(long id);
}
