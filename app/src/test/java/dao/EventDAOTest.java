package dao;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.Test;

import com.trms.data.DaoFactory;
import com.trms.data.EventDAO;
import com.trms.models.Event;

public class EventDAOTest {
private EventDAO eventDAO = DaoFactory.getEventDAO();
	
	@Test
	public void getByIdDoesNotExist() {
		Event event = eventDAO.getById(0);
		assertNull(event);
	}
	
}
