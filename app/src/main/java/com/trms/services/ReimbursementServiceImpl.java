package com.trms.services;

import com.trms.data.Impl.ReimbursamentDAOImpl;
import com.trms.models.Reimbursement;

public class ReimbursementServiceImpl implements ReimbursementService{
	private ReimbursamentDAOImpl requestDAO = new ReimbursamentDAOImpl();
	
	@Override
	public long createReimbursement(Reimbursement reimbursement) {
		
		return requestDAO.create(reimbursement);
	}

}
