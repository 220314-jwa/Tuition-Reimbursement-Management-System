package com.trms.services;

import java.util.List;

import com.trms.data.EventDAO;
import com.trms.data.Impl.EventDAOImpl;
import com.trms.models.Event;

public class EventServiceImpl implements EventService {
	private EventDAO eventDAO = new EventDAOImpl();
	
	@Override
	public List<Event> getAllEvents() {
		
		List<Event> events = eventDAO.getAll();
		
		return events;
	}

}
