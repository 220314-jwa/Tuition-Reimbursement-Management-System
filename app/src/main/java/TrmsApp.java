import com.trms.data.DaoFactory;
import com.trms.data.DeptDAO;
import com.trms.data.EmplDAO;
import com.trms.data.EventDAO;
import com.trms.data.ReimbursementDAO;
import com.trms.data.StatusDAO;
import com.trms.models.Department;
import com.trms.models.Employee;
import com.trms.models.Event;
import com.trms.models.Reimbursement;
import com.trms.models.Status;

import io.javalin.Javalin;

public class TrmsApp {

	public static void main(String[] args) {
		
		Javalin app = Javalin.create();
		app.start(8085);

		
		app.post("/depts", ctx -> {
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

		
	}
}
