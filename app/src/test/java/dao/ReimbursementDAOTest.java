package dao;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.Test;

import com.trms.data.DaoFactory;
import com.trms.data.ReimbursementDAO;
import com.trms.models.Reimbursement;

public class ReimbursementDAOTest {
private ReimbursementDAO reimDAO = DaoFactory.getReimbursementDAO();
	
	@Test
	public void getByIdDoesNotExist() {
		Reimbursement reimbursement = reimDAO.getById(0);
		assertNull(reimbursement);
	}
}
