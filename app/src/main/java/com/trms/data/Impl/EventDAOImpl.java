package com.trms.data.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.trms.data.EventDAO;
import com.trms.factory.ConnectionFactory;
import com.trms.models.Event;

public class EventDAOImpl implements EventDAO{
	
	Connection connection;
	
	public EventDAOImpl() {
		connection = ConnectionFactory.getConnection();
	}
	
	public long create(Event newEvent) {
		// create a basic string to store sql query for creating department
		String sql = "Insert into Event(id,event_name)" +
					 "Values(default,?);";
		
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, newEvent.getEventTypeName());
			
			int count = preparedStatement.executeUpdate();
			
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			
			if(count>0) {
				
				System.out.println("Event added!");
				// return the id generated by this entry
				resultSet.next();
				int id = resultSet.getInt(1);
				
				return id;
				
			}else {
				System.out.println("Something went wrong when adding event type!");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return -1L;
	}

	public Event getById(long id) {
		String sql = "select * from event where id =?;";
		Event event = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setLong(1,id);
			// execute the command, and save the count of rows affected:
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				event = EventDAOImpl.parseResultSet(resultSet);
				//System.out.println(empl);
				// now, we've created a pet Java object based on the info from our table:
			} else {
				System.out.println("Event with id - " + id +" - does not exist!");
				// return null in this case:
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return event;
		
	}
	private static Event parseResultSet(ResultSet resultSet) {

		Event event = new Event();

		try {
			event.setEventTypeId(resultSet.getInt(1));
			event.setEventTypeName(resultSet.getString(2));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return event;
	}

	public List<Event> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Event updatedObj) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Event objToDelete) {
		// TODO Auto-generated method stub
		
	}

}