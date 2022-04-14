package dao;

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
import com.trms.data.EmplDAO;
import com.trms.models.Employee;

public class EmplDAOTest {
	
	private EmplDAO emplDAO = DaoFactory.geEmplDAO();
	private String testUser = "RustemA";
	private long idNewUser = 0;
	
	@Test
	public void getByIdDoesNotExist() {
		Employee user = emplDAO.getById(0);
		assertNull(user);
	}
	
	@Test
	public void getByUsernameExists() {
		Employee user = emplDAO.getByUsername("RustemA");
		assertEquals(testUser, user.getUserName());
		//System.out.print(user.getUserName());
	}
	
	@Test
	public void getByUsernameDoesNotExist() {
		Employee user = emplDAO.getByUsername("qwertyuiop");
		assertNull(user);
	}

	@Test
	@Order(1)
	public void createUserSuccessfully() {
		Employee newUser = new Employee();
		newUser.setFirstName("Rom");
		newUser.setEmail("Rom@gmail.com");
		newUser.setLastName("Romanov");
		newUser.setDeptId(1);
		newUser.setManagerId(2);
		newUser.setPassword("password");
		newUser.setUserName("Romans");
		
		idNewUser = emplDAO.create(newUser);
		assertNotEquals(0, idNewUser);
	}
	
	@Test
	public void createUserDuplicateUsername() {
		Employee newUser = new Employee();
		newUser.setFirstName("Rom");
		newUser.setEmail("Rom@gmail.com");
		newUser.setLastName("Romanov");
		newUser.setDeptId(1);
		newUser.setManagerId(2);
		newUser.setPassword("password");
		newUser.setUserName("Romans");
		
		Employee existingUser = emplDAO.getByUsername(newUser.getUserName());
		long id = (existingUser.getId()!=0)?0:1;
		assertEquals(0, id);
	}
	
	@Test
	public void getByIdExists() {
		int id = 23;

		Employee user = emplDAO.getById(id);

		assertEquals(testUser, user.getUserName());
	}
	
	@Test
	public void getAll() {
		assertNotNull(emplDAO.getAll());
	}

	@Test
	public void updateUserExists() {
		Employee newUser = new Employee();
		newUser.setFirstName("Rom");
		newUser.setEmail("Rom@gmail.com");
		newUser.setLastName("Romanov");
		newUser.setDeptId(1);
		newUser.setManagerId(2);
		newUser.setPassword("password");
		newUser.setUserName("Romans");
		newUser.setId(idNewUser);
		assertDoesNotThrow(() -> {
			emplDAO.update(newUser);
		});
	}
	
	@Test
	public void updateUserDoesNotExist() {
		assertThrows(SQLException.class, () -> {
			emplDAO.update(new Employee());
		});
	}

	@Test
	@Order(2)
	public void deleteUserExists() {
		Employee newUser = new Employee();
		newUser.setFirstName("Rom");
		newUser.setEmail("Rom@gmail.com");
		newUser.setLastName("Romanov");
		newUser.setDeptId(1);
		newUser.setManagerId(2);
		newUser.setPassword("password");
		newUser.setUserName("Romans");
		newUser.setId(idNewUser);
		assertDoesNotThrow(() -> {
			emplDAO.delete(newUser);
		});
	}

	@Test
	public void deleteUserDoesNotExist() {
		assertThrows(SQLException.class, () -> {
			emplDAO.delete(new Employee());
		});
	}






	


}
