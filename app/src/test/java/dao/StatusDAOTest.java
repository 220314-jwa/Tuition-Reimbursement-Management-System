package dao;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.Test;

import com.trms.data.DaoFactory;
import com.trms.data.StatusDAO;
import com.trms.models.Status;

public class StatusDAOTest {
private StatusDAO statusDAO = DaoFactory.getStatusDAO();
	
	@Test
	public void getByIdDoesNotExist() {
		Status status = statusDAO.getById(0);
		assertNull(status);
	}
}
