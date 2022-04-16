package controllers;

import java.util.List;

import com.trms.models.Department;
import com.trms.services.DepartmentService;
import com.trms.services.DepartmentServiceImpl;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class DepartmentController {
	
	private static DepartmentService deptService = new DepartmentServiceImpl();
	
	public static void getDepartments(Context ctx) {
		
		try {
			List<Department> depts = deptService.getAllDepartments();
			ctx.json(depts);
		} catch (Exception e) {
			ctx.status(HttpCode.NO_CONTENT); // 401 unauthorized
		}
	}
}
