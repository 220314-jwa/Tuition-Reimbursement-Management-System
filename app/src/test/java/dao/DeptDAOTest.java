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
import com.trms.data.DeptDAO;
import com.trms.models.Department;




public class DeptDAOTest {
	
	private DeptDAO deptDAO = DaoFactory.getDeptDao();
	private long deptId = 0;
	private static Department newDept = new Department();
	
	@Test
	public void getByIdDoesNotExist() {
		Department dept = deptDAO.getById(0);
		assertNull(dept);
	}
	
	@Test
	public void getByIdExists() {
		long id = 1;

		Department dept = deptDAO.getById(id);

		assertEquals(id, dept.getId());
	}
	
	@Test
	public void getAll() {
		assertNotNull(deptDAO.getAll());
	}
	
	@Test
	public void updateDepartmentDoesNotExist() {
		assertThrows(SQLException.class, () -> {
			deptDAO.update(new Department());
		});
	}
		
	@Test	
	public void deleteDepartmentDoesNotExist() {
			assertThrows(SQLException.class, () -> {
				deptDAO.delete(new Department());
			});
		}
	
	@Test
	@Order(1)
	public void createDepartmentSuccessfully() {
		
		newDept.setDeptName("Marketing");
		newDept.setHeadId(3);
		
		deptId = deptDAO.create(newDept);
		newDept.setId(deptId);
		assertNotEquals(0, deptId);
	}	
	
	@Test
	@Order(2)
	public void deleteUserExists() {
		
		//newDept.setDeptName("Marketing");
		//newDept.setHeadId(3);
		//newDept.setId(deptId);
		assertDoesNotThrow(() -> {
			deptDAO.delete(newDept);
		});
	}
}
*/
