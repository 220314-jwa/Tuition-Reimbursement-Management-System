package com.trms.services;

import com.trms.data.Impl.ReimbursamentDAOImpl;
import com.trms.models.Reimbursement;

public class ReimbursementServiceImpl implements ReimbursementService{
	private ReimbursamentDAOImpl requestDAO = new ReimbursamentDAOImpl();
	
	@Override
	public long createReimbursement(Reimbursement reimbursement) {
		
		return requestDAO.create(reimbursement);
	}

	
	@Override
	public void updateReimbursement(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		 Reimbursement request = requestDAO.getById(reimbursement.getRequestId());
		 
		 if(reimbursement.getStatusId()!=request.getStatusId()) {
			 request.setStatusId(reimbursement.getStatusId());
		 }
		 requestDAO.update(request);
	}

}
