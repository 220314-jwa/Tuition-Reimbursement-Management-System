package controllers;

import java.util.List;
import com.trms.models.Event;
import com.trms.services.EventService;
import com.trms.services.EventServiceImpl;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class EventController {

	private static  EventService eventService = new EventServiceImpl();
	
	public static void getEvents(Context ctx) {
		
		try {
			List<Event> events = eventService.getAllEvents();
			ctx.json(events);
		} catch (Exception e) {
			ctx.status(HttpCode.NO_CONTENT); // 401 unauthorized
		}
	}
}
