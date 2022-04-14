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
import com.trms.data.EventDAO;
import com.trms.models.Event;

public class EventDAOTest {
	
	private EventDAO eventDAO = DaoFactory.getEventDAO();
	private Event event = DaoFactory.getEvent();
	private long eventId = DaoFactory.getEventId();
	
	@Test
	public void getByIdDoesNotExist() {
		Event newEvent = eventDAO.getById(0);
		assertNull(newEvent);
	}
	
	@Test
	public void getByIdExists() {
		
		long id = 1;

		Event event = eventDAO.getById(id);
		assertEquals(id, event.getEventTypeId());
	}
	
	@Test
	public void getAll() {
		assertNotNull(eventDAO.getAll());
	}
	
	@Test
	public void updateDepartmentDoesNotExist() {
		assertThrows(SQLException.class, () -> {
			eventDAO.update(new Event());
		});
	}
	
	@Test	
	public void deleteEventDoesNotExist() {
			assertThrows(SQLException.class, () -> {
				eventDAO.delete(new Event());
			});
		}
	@Test
	@Order(1)
	public void createEventSuccessfully() {
		
		event.setEventTypeName("Java course");
		
		eventId = eventDAO.create(event);
		
		event.setEventTypeId(eventId);
		System.out.println(event.getEventTypeId());
		assertNotEquals(0, eventId);
	}
	
	@Test
	@Order(2)
	public void deleteUserExists() {
		event.setEventTypeId(eventId);
		assertDoesNotThrow(() -> {
			eventDAO.delete(event);
		});
	}
}
