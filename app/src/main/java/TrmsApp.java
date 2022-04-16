
import controllers.EventController;
import controllers.ReimbursementController;
import controllers.UserController;
import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.*;
public class TrmsApp {

	public static void main(String[] args) {
		
		Javalin app = Javalin.create(config -> {
		    config.enableCorsForAllOrigins();
		}).start(8085);
		
		//UserService userService = new UserServiceImpl();
		
		/*app.post("/depts", ctx -> {
			Department dept = ctx.bodyAsClass(com.trms.models.Department.class);
			System.out.println(dept);
			// get the DAO from the factory:
			 DeptDAO deptdao = DaoFactory.getDeptDao();
			// create the pet:
			long id = deptdao.create(dept);
			System.out.println(id);
		});
		
		app.get("/depts/{id}", ctx -> {
			int id = Integer.parseInt(ctx.pathParam("id"));
			System.out.println(id);
			// get the DAO from the factory:
			// get our pet dao from the dao factory:
			DeptDAO deptDAO = DaoFactory.getDeptDao();
			Department resultDept = deptDAO.getById(id);
			ctx.json(resultDept);

		});
		
		app.post("/event", ctx -> {
			Event event = ctx.bodyAsClass(com.trms.models.Event.class);
			System.out.println(event);
			// get the DAO from the factory:
			 EventDAO eventDao = DaoFactory.getEventDAO();
			// create the pet:
			long id = eventDao.create(event);
			System.out.println(id);
		});
		
		app.post("/status", ctx -> {
			Status status = ctx.bodyAsClass(com.trms.models.Status.class);
			System.out.println(status);
			// get the DAO from the factory:
			 StatusDAO statusDao = DaoFactory.getStatusDAO();
			// create the pet:
			long id = statusDao.create(status);
			System.out.println(id);
		});
		
		app.post("/reqreimbursement", ctx -> {
			Reimbursement reimbursement = ctx.bodyAsClass(com.trms.models.Reimbursement.class);
			System.out.println(reimbursement);
			// get the DAO from the factory:
			 ReimbursementDAO reimbursementDao = DaoFactory.getReimbursementDAO();
			// create the pet:
			long id = reimbursementDao.create(reimbursement);
			System.out.println(id);
		});
		
		app.put("/dept", ctx ->{
			Department dept = ctx.bodyAsClass(com.trms.models.Department.class);
			DeptDAO deptDao = DaoFactory.getDeptDao();
			deptDao.update(dept);
		});
		
		app.delete("/dept", ctx ->{
			Department dept = ctx.bodyAsClass(com.trms.models.Department.class);
			DeptDAO deptDao = DaoFactory.getDeptDao();
			deptDao.delete(dept);
		});
		
		app.post("/adduser", ctx ->{
			
			
			Employee user = ctx.bodyAsClass(com.trms.models.Employee.class);
			EmplDAO emplDao = DaoFactory.geEmplDAO();
			emplDao.create(user);
		});
		
		
		app.get("/user/{username}", ctx -> {
			String username = ctx.pathParam("username");
			System.out.println(username);
			// get the DAO from the factory:
			// get our pet dao from the dao factory:
			EmplDAO emplDao = DaoFactory.geEmplDAO();
			Employee resultUser = emplDao.getByUsername(username);
			ctx.json(resultUser);

		});
		
		app.get("/getuser/{email}", ctx -> {
			String email = ctx.pathParam("email");
			System.out.println(email);
			// get the DAO from the factory:
			// get our pet dao from the dao factory:
			EmplDAO emplDao = DaoFactory.geEmplDAO();
			Employee resultUser = emplDao.getByEmail(email);
			ctx.json(resultUser);

		});
		app.post("/login",ctx ->{
			try {
			Employee user = ctx.bodyAsClass(com.trms.models.Employee.class);
			String username = user.getUserName();
			String password = user.getPassword();
			System.out.println(username);
			System.out.println(password);
			Employee employee = userService.logIn(username, password);
			ctx.json(employee);
			System.out.println(ctx.body());}
			catch(IncorrectCredentialsException e) {
				ctx.status(HttpCode.UNAUTHORIZED);
			}
			
			

			//System.out.println(ctx.queryParam("username"));
			//System.out.println(ctx.queryParam("password"));
		});
*/
		// cleaning up my main method by switching to app.routes and moving logic to controllers
				app.routes(() -> {
					// all paths starting with /pets
					path("users", () -> {
						post(UserController::registerUser);
						path("{id}", () -> {
							get(UserController::getUserById);
						});
					});

					// all paths starting with /auth
					path("auth", () -> {
						post(UserController::logIn);
					});
					
					path("events",() ->{
						get(EventController::getEvents);
					});
					
					path("createReimbursement",() ->{
						post(ReimbursementController::createReimbursement);
					});
					
					path("myReimbursements/{id}",() ->{
						get(UserController::viewReimbursements);
					});
					
				});

		
	}
}
