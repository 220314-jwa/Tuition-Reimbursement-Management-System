package controllers;

import com.trms.models.Reimbursement;
import com.trms.services.ReimbursementService;
import com.trms.services.ReimbursementServiceImpl;
import io.javalin.http.Context;

public class ReimbursementController {
	private static ReimbursementService reimService = new ReimbursementServiceImpl();
	// POST to /users
			public static void createReimbursement(Context ctx) {
				
					Reimbursement newRequest = ctx.bodyAsClass(Reimbursement.class);
					long id = reimService.createReimbursement(newRequest);
					newRequest.setRequestId(id);
					ctx.json(newRequest);
	
			}
}
