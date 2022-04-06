package dao;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.Test;

import com.trms.data.DaoFactory;
import com.trms.data.DeptDAO;
import com.trms.models.Department;


public class DeptDAOTest {
	private DeptDAO deptDAO = DaoFactory.getDeptDao();
	
	@Test
	public void getByIdDoesNotExist() {
		Department dept = deptDAO.getById(0);
		assertNull(dept);
	}
	
	
}
