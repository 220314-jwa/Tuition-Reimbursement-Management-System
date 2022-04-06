package app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.trms.data.EmplDAO;
import com.trms.data.Impl.EmplDAOImpl;
import com.trms.exceptions.EmplAlreadyExistsException;
import com.trms.exceptions.IncorrectCredentialsException;
import com.trms.models.Employee;
import com.trms.models.Reimbursement;
import com.trms.services.UserService;
import com.trms.services.UserServiceImpl;

public class UserServiceTest {
	// we need a field for the class that we're testing
		private UserService userServ=new UserServiceImpl();
		private EmplDAO emplDAO = new EmplDAOImpl();
		
		// test methods always have no parameters and return void
		@Test
		public void exampleTest() {
			assertTrue(true);
		}

		@Test
		public void logInSuccessfully() throws IncorrectCredentialsException {
			// setup (arguments, expected result, etc.)
			String username = "RustemA";
			String password = "pass";

			// call the method we're testing
			Employee employee = userServ.logIn(username, password);
			//System.out.println(employee.getUserName());
			// assertion
			assertEquals(username, employee.getUserName());
			//System.out.print(employee.getUserName());
		}
		
		@Test
		public void logInWrongUsername() {
			String username = "Ru";
			String password = "pass";

			assertThrows(IncorrectCredentialsException.class, () -> {
				// put the code that we're expecting to throw the exception
				userServ.logIn(username, password);
			});
		}
		
		@Test
		public void logInWrongPassword() {
			String username = "RustemA";
			String password = "1234567890";

			assertThrows(IncorrectCredentialsException.class, () -> {
				// put the code that we're expecting to throw the exception
				userServ.logIn(username, password);
			});
		}
		
		@Test
		public void registerSuccessfully() throws EmplAlreadyExistsException, SQLException {
			
			Employee newUser = new Employee();
			newUser.setFirstName("Rom");
			newUser.setEmail("Rom@gmail.com");
			newUser.setLastName("Romanov");
			newUser.setDeptId(1);
			newUser.setManagerId(2);
			newUser.setPassword("password");
			newUser.setUserName("Romans");
			
			Employee result = userServ.register(newUser);
			//System.out.println(result.getId());
			// the behavior that i'm looking for is that the
			// method returns the User with their newly generated ID,
			// so i want to make sure the ID was generated (not the default)
			assertNotEquals(0, result.getId());
		}


		@Test
		public void registerUsernameTaken() {
			Employee newUser = new Employee();
			
			newUser.setUserName("RustemA");

			assertThrows(EmplAlreadyExistsException.class, () -> {
				userServ.register(newUser);
			});
		}

		@Test
		public void viewReimbursementsSuccessfully() {
			int id = 1;
			List<Reimbursement> requests = userServ.viewReimbursements(emplDAO.getById(id));

			// i just want to make sure that the requests are returned -
			// i don't need to check that the pets are all available
			// because that filtering happens in the database. i just
			// need to check that the requests list isn't null
			assertNotNull(requests);
		}

		@Test
		public void searchReimbursementsByStatus() {
			
			String status = "cat";
			List<Reimbursement> reimbursements = userServ.getReimbursementsByStatus(status);
			boolean reimbursementExists = (reimbursements.isEmpty()?false:true);
			
			assertTrue(reimbursementExists);
		}

}
