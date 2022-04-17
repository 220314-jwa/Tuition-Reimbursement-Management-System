package controllers;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.trms.exceptions.EmplAlreadyExistsException;
import com.trms.exceptions.IncorrectCredentialsException;
import com.trms.models.Employee;
import com.trms.models.Reimbursement;
import com.trms.services.UserService;
import com.trms.services.UserServiceImpl;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class UserController {
	private static UserService userServ = new UserServiceImpl();
	
		public static void logIn(Context ctx) {
		Map<String,String> credentials = ctx.bodyAsClass(Map.class);
		String username = credentials.get("username");
		String password = credentials.get("password");
		System.out.println(username);
		System.out.println(password);
		try {
			Employee user = userServ.logIn(username, password);
			System.out.println(user);
			ctx.json(user);
		} catch (IncorrectCredentialsException e) {
			ctx.status(HttpCode.UNAUTHORIZED); // 401 unauthorized
		}
	}
	
		// POST to /users
		public static void registerUser(Context ctx) {
			Employee newUser = ctx.bodyAsClass(Employee.class);
			
			try {
				newUser = userServ.register(newUser);
				ctx.json(newUser);
			} catch (EmplAlreadyExistsException e) {
				ctx.status(HttpCode.CONFLICT); // 409 conflict
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// GET to /users/{id} where {id} is the user's id
		public static void getUserById(Context ctx) {
			String pathParam = ctx.pathParam("id");
			if (pathParam != null && !pathParam.equals("undefined") && !pathParam.equals("null")) {
				int userId = Integer.parseInt(pathParam);
				
				Employee user = userServ.getUserById(userId);
				if (user != null)
					ctx.json(user);
				else
					ctx.status(HttpCode.NOT_FOUND); // 404 not found
			} else {
				ctx.status(HttpCode.BAD_REQUEST); // 400 bad request
			}
		}

		public static void viewReimbursements(Context ctx){
			
			long id = Long.parseLong(ctx.pathParam("id"));
			List<Reimbursement> requests = userServ.viewReimbursements(userServ.getUserById(id));
			System.out.println(id);
			System.out.println(requests);
			ctx.json(requests);
		}
		
		public static void viewMyPendingTasks(Context ctx) {
			
			long id = Long.parseLong(ctx.pathParam("id"));
			List<Reimbursement> requests = userServ.viewMyPendingTasks(id);
			ctx.json(requests);
			
		}


}
