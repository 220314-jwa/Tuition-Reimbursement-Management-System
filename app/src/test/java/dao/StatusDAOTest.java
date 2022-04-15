package dao;
/*
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.jupiter.api.Order;

import com.trms.data.DaoFactory;
import com.trms.data.StatusDAO;
import com.trms.models.Status;

public class StatusDAOTest {
private StatusDAO statusDAO = DaoFactory.getStatusDAO();
private Status status = new Status();
private long  statusId;
	
	@Test
	public void getByIdDoesNotExist() {
		Status status = statusDAO.getById(0);
		assertNull(status);
	}
	
	@Test
	public void getByIdExists() {
		long id = 1;

		Status status = statusDAO.getById(id);

		assertEquals(id, status.getStatusId());
	}
	
	@Test
	public void getAll() {
		assertNotNull(statusDAO.getAll());
	}
	
	@Test
	public void updateStatusDoesNotExist() {
		assertThrows(SQLException.class, () -> {
			statusDAO.update(new Status());
		});
	}
	
	@Test	
	public void deleteStatudDoesNotExist() {
			assertThrows(SQLException.class, () -> {
				statusDAO.delete(new Status());
			});
		}
	
	
	@Test
	@Order(1)
	public void createStatusSuccessfully() {
		
		status.setStatusName("OK");
		
		statusId = statusDAO.create(status);
		status.setStatusId(statusId);
		assertNotEquals(0, statusId);
	}
	@Test
	@Order(2)
	public void deleteUserExists() {
		
		//newDept.setDeptName("Marketing");
		//newDept.setHeadId(3);
		//newDept.setId(deptId);
		assertDoesNotThrow(() -> {
			statusDAO.delete(status);
		});
	}
		
	
}
*/
