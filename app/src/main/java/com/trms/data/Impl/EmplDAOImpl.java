package com.trms.data.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trms.data.EmplDAO;
import com.trms.factory.ConnectionFactory;
import com.trms.models.Employee;

public class EmplDAOImpl implements EmplDAO {

	// connection object, used to connect to the database:
	Connection connection;

	// constructor, retrieve/get a connection from the connection factory
	public EmplDAOImpl() {
		// calling the method that we made in ConnectionFactory:
		connection = ConnectionFactory.getConnection();
	}

	public long create(Employee newObj) {
		// this stores our sql command, that we would normally to DBeaver/command line
		// 0 1 2 3 4 5
		String sql = "insert into Employee (empl_id, first_name, second_name, password, email, manager_id,dept_id,username)"
				+ "values (default, ?, ?, ?, ?, ?,?,?);";

		try {
			// create a prepared statement, we pass in the sql command
			// also the flag "RETURN_GENERATED_KEYS" so we can get that id that is generated
			PreparedStatement preparedStatement = connection.prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			// set the fields:
			preparedStatement.setString(1, newObj.getFirstName());
			preparedStatement.setString(2, newObj.getLastName());
			preparedStatement.setString(3, newObj.getPassword());
			preparedStatement.setString(4, newObj.getEmail());
			preparedStatement.setLong(5, newObj.getManagerId());
			preparedStatement.setLong(6, newObj.getDeptId());
			preparedStatement.setString(7, newObj.getUserName());

			// execute this command, return number of rows affected:
			int count = preparedStatement.executeUpdate();
			// lets us return the id that is auto-generated
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			// if we affected one or more rows:
			if (count > 0) {
				System.out.println("Employee added!");
				// return the generated id:
				// before we call resultSet.next(), it's basically pointing to nothing useful
				// but moving that pointer allows us to get the information that we want
				resultSet.next();
				int id = resultSet.getInt(1);
				return id;
			}
			// if 0 rows are affected, something went wrong:
			else {
				System.out.println("Something went wrong when trying to add pet!");
			}
		} catch (SQLException e) {

			e.printStackTrace();

		}
		return -1;
	}

	public Employee getById(long id) {
		String sql = "Select * from Employee e where e.empl_id= ?;";
		Employee empl = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setLong(1,id);
			// execute the command, and save the count of rows affected:
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				empl = EmplDAOImpl.parseResultSet(resultSet);
				//System.out.println(empl);
				// now, we've created a pet Java object based on the info from our table:
			} else {
				System.out.println("User with id - " + id +" - does not exist!");
				// return null in this case:
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empl;
	}

	public List<Employee> getAll() {
		 
		List<Employee> users = new ArrayList<Employee>();
		String sql = "SELECT * FROM employee;";
		
		try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // get the result from our query:
            ResultSet resultSet = preparedStatement.executeQuery();
            // because the resultSet has multiple pets in it, we don't just want an if-statement. We want a loop:
            while(resultSet.next()) {
                Employee user = EmplDAOImpl.parseResultSet(resultSet);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
		
	}

	public void update(Employee updatedObj) {
		
		String sql = "update employee set first_name = ?,second_name=?,password=?,email=?,manager_id=?,dept_id=?,username=? where empl_id = ?;";
    	
		try {
        	PreparedStatement preparedStatement = connection.prepareStatement(sql);
        	
        	preparedStatement.setString(1,updatedObj.getFirstName());
        	preparedStatement.setString(2,updatedObj.getLastName());
        	preparedStatement.setString(3,updatedObj.getPassword());
        	preparedStatement.setString(4,updatedObj.getEmail());
        	preparedStatement.setLong(5,updatedObj.getDeptId());
        	preparedStatement.setLong(6,updatedObj.getManagerId());
        	preparedStatement.setLong(7,updatedObj.getDeptId());
        	preparedStatement.setLong(8,updatedObj.getId());
      
        	// return a count of how many records were updated
        	int count = preparedStatement.executeUpdate();
        	if(count != 1) {
        		System.out.println("Oops! Something went wrong with the update of employee!");
        	}
        	else {
        		System.out.println("Employee with id "+ updatedObj.getId()+ " updated!");
        	}
        	
    		
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
	}

	public void delete(Employee objToDelete) {
		String sql = "DELETE FROM employee WHERE empl_id = ?;";
    	try {
    		PreparedStatement preparedStatement = connection.prepareStatement(sql);
    		preparedStatement.setLong(1, objToDelete.getId());
    		int count = preparedStatement.executeUpdate();
    		if (count != 1) {
    			System.out.println("Something went wrong with the deletion of employee!");
    		}
    		else {
    			System.out.println("Employee with id"+objToDelete.getId()+"deleted");
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
	}

	private static Employee parseResultSet(ResultSet resultSet) {

		Employee employee = new Employee();

		try {
			employee.setId(resultSet.getInt(1));
			employee.setFirstName(resultSet.getString(2));
			employee.setLastName(resultSet.getString(3));
			employee.setPassword(resultSet.getString(4));
			employee.setEmail(resultSet.getString(5));
			employee.setManagerId(resultSet.getInt(6));
			employee.setDeptId(resultSet.getInt(7));
			employee.setUserName(resultSet.getString(8));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employee;
	}

	public Employee getByEmail(String email) {
		String sql = "Select * from Employee e where e.email= ?;";
		Employee empl = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1,email);
			// execute the command, and save the count of rows affected:
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				empl = EmplDAOImpl.parseResultSet(resultSet);
				System.out.println(empl);
				// now, we've created a pet Java object based on the info from our table:
			} else {
				System.out.println("Something went wrong when querying the employee!");
				// return null in this case:
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empl;
	}

	@Override
	public Employee getByUsername(String username) {
		String sql = "Select * from Employee e where e.username= ?;";
		Employee empl = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1,username);
			// execute the command, and save the count of rows affected:
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				empl = EmplDAOImpl.parseResultSet(resultSet);
				// now, we've created a pet Java object based on the info from our table:
			} else {
				//System.out.println("Something went wrong when querying the employee!");
				// return null in this case:
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empl;
	}

}
