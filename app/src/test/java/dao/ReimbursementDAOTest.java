package dao;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;
import org.junit.jupiter.api.Order;

import com.trms.data.DaoFactory;
import com.trms.data.ReimbursementDAO;
import com.trms.models.Reimbursement;

public class ReimbursementDAOTest {
private ReimbursementDAO reimDAO = DaoFactory.getReimbursementDAO();
private Reimbursement reimbursement = new Reimbursement();	
private long requestId;
	@Test
	public void getByIdDoesNotExist() {
		Reimbursement reimbursement = reimDAO.getById(0);
		assertNull(reimbursement);
	}
	public void getByIdExists() {
		long id = 1;

		Reimbursement request = reimDAO.getById(id);

		assertEquals(id, request.getRequestId());
	}
	
	@Test
	public void getAll() {
		assertNotNull(reimDAO.getAll());
	}
	
	@Test
	public void updateRequestDoesNotExist() {
		assertThrows(SQLException.class, () -> {
			reimDAO.update(new Reimbursement());
		});
	}
	@Test	
	public void deleteRequestDoesNotExist() {
			assertThrows(SQLException.class, () -> {
				reimDAO.delete(new Reimbursement());
			});
		}
	
	@Test
	@Order(1)
	public void createRequestSuccessfully() {
		
		reimbursement.setSubmitterId(25);
		reimbursement.setSubmittedAt(new Date(System.currentTimeMillis()));
		reimbursement.setStatusId(8);
		reimbursement.setLocation("Taraz");
		reimbursement.setEventTypeId(1);
		reimbursement.setEventDate(new Date(System.currentTimeMillis()));
		reimbursement.setDescription("ok");
		reimbursement.setCost(2000);
		requestId = reimDAO.create(reimbursement);
		reimbursement.setRequestId(requestId);
		assertNotEquals(0, requestId);
	}
	
	@Test
	@Order(2)
	public void deleteRequestExists() {
		
		//newDept.setDeptName("Marketing");
		//newDept.setHeadId(3);
		//newDept.setId(deptId);
		assertDoesNotThrow(() -> {
			reimDAO.delete(reimbursement);
		});
	}
}
