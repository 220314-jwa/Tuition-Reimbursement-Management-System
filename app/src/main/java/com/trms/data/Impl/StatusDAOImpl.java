package com.trms.data.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trms.data.StatusDAO;
import com.trms.factory.ConnectionFactory;
import com.trms.models.Status;

public class StatusDAOImpl implements StatusDAO {

	Connection connection;
	
	public StatusDAOImpl() {
		connection = ConnectionFactory.getConnection();
	}
	
	public long create(Status newStatus) {
		
		String sql = "Insert into Status(id,status_name)" + 
					"Values(default,?);";
		
		try {
		PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		
		preparedStatement.setString(1,newStatus.getStatusName());
		
		int count = preparedStatement.executeUpdate();
		
		ResultSet resultSet = preparedStatement.getGeneratedKeys();
		
		if(count>0) {
			System.out.println("Status added!");
			// return the id generated by this entry
			resultSet.next();
			int id = resultSet.getInt(1);
			return id;
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Something went wrong!");
		}
		
		return -1L;
	}
	
	public Status getById(long id) {
		String sql = "SELECT * FROM status s where s.id = ?; ";
		Status status = null;
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setLong(1,id);
			// execute the command, and save the count of rows affected:
			ResultSet resultSet = preparedStatement.executeQuery();
			 if(resultSet.next()) {
				 status  = StatusDAOImpl.parseResultSet(resultSet);
	                // now, we've created a pet Java object based on the info from our table:
	                return status;            }
	            else {
	                System.out.println("Something went wrong when querying the status with id " + id);
	                // return null in this case:
	            }

		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	public List<Status> getAll() {
		List<Status> statuses = new ArrayList<Status>();

        String sql = "SELECT * FROM status;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // get the result from our query:
            ResultSet resultSet = preparedStatement.executeQuery();
            // because the resultSet has multiple pets in it, we don't just want an if-statement. We want a loop:
            while(resultSet.next()) {
                Status status = StatusDAOImpl.parseResultSet(resultSet);
                statuses.add(status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return statuses;

	}

	public void update(Status updatedObj) {
		// we create the template for the SQL string:
    	String sql = "UPDATE status SET status_name = ? where id = ?;";
    	try {
        	PreparedStatement preparedStatement = connection.prepareStatement(sql);
        	// fill in the template:
        	preparedStatement.setString(1,updatedObj.getStatusName());
        	preparedStatement.setLong(2,updatedObj.getStatusId());
        	
        	// return a count of how many records were updated
        	int count = preparedStatement.executeUpdate();
        	if(count != 1) {
        		System.out.println("Oops! Something went wrong with the update!");
        	}
        	else {
        		System.out.println("Status with id "+ updatedObj.getStatusId()+" was updated!");
        	}
    		
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
		
	}

	public void delete(Status objToDelete) {
		
		String sql = "DELETE FROM status where id = ?;";
    	try {
    		PreparedStatement preparedStatement = connection.prepareStatement(sql);
    		preparedStatement.setLong(1, objToDelete.getStatusId());
    		int count = preparedStatement.executeUpdate();
    		if (count != 1) {
    			System.out.println("Something went wrong with the deletion of status!");
    		}
    		else {
    			System.out.println("Status with id" + objToDelete.getStatusId() + " was deleted");
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
		
	}

	private static Status parseResultSet(ResultSet resultSet) {
	
		Status status = new Status();
		
		try {
			status.setStatusId(resultSet.getInt(1));
			status.setStatusName(resultSet.getString(2));}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}
}
