package com.trms.data.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.trms.data.ReimbursementDAO;
import com.trms.factory.ConnectionFactory;
import com.trms.models.Employee;
import com.trms.models.Reimbursement;

public class ReimbursamentDAOImpl implements ReimbursementDAO {

	Connection connection;

	public ReimbursamentDAOImpl() {
		connection = ConnectionFactory.getConnection();
	}

	public long create(Reimbursement newReimbursement) {

		String sql = "INSERT INTO Reimbursement(id,submitter_id,event_type_id,status_id,"
				+ "event_date,cost,description,location,submitted_at)" + "Values(default,?,?,?,?,?,?,?,?)";

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);

			preparedStatement.setLong(1, newReimbursement.getSubmitterId());
			preparedStatement.setLong(2, newReimbursement.getEventTypeId());
			preparedStatement.setLong(3, newReimbursement.getStatusId());
			preparedStatement.setTimestamp(4, new Timestamp(newReimbursement.getEventDate().getTime()));
			preparedStatement.setLong(5, newReimbursement.getCost());
			preparedStatement.setString(6, newReimbursement.getDescription());
			preparedStatement.setString(7, newReimbursement.getLocation());
			preparedStatement.setTimestamp(8, new Timestamp(System.currentTimeMillis()));

			int count = preparedStatement.executeUpdate();

			ResultSet resultSet = preparedStatement.getGeneratedKeys();

			if (count > 0) {
				System.out.println("Reimbursement request added!");
				// return the id generated by this entry
				resultSet.next();
				int id = resultSet.getInt(1);
				return id;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Something went wrong!");
		}

		return -1L;

	}

	public Reimbursement getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Reimbursement> getAllByEmployee(Employee employee) {
		ArrayList<Reimbursement> reimbursements = new ArrayList<>();
		String sql = "Select * from Reimbursement where id = ?;";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, employee.getId());
			// get the result from our query:
			ResultSet resultSet = preparedStatement.executeQuery();
			// because the resultSet has multiple pets in it, we don't just want an
			// if-statement. We want a loop:
			while (resultSet.next()) {
				Reimbursement reimbursement = ReimbursamentDAOImpl.parseResultSet(resultSet);
				reimbursements.add(reimbursement);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;

	}

	private static Reimbursement parseResultSet(ResultSet resultSet) {

		Reimbursement reimbursement = new Reimbursement();

		try {
			reimbursement.setRequestId(resultSet.getInt(1));
			reimbursement.setSubmitterId(resultSet.getInt(2));
			reimbursement.setEventTypeId(resultSet.getInt(3));
			reimbursement.setStatusId(resultSet.getInt(4));
			reimbursement.setEventDate(resultSet.getTimestamp(5));
			reimbursement.setCost(resultSet.getInt(6));
			reimbursement.setDescription(resultSet.getString(7));
			reimbursement.setLocation(resultSet.getString(8));
			reimbursement.setSubmittedAt(resultSet.getTimestamp(9));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reimbursement;
	}

	public void update(Reimbursement updatedObj) {
		// TODO Auto-generated method stub

	}
	public List<Reimbursement> getReimbursementsByStatus(String status){
		List<Reimbursement> reimbursements = new ArrayList<>();
		String sql = "Select * from Reimbursement where status_id = ?;";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1,1);
			// get the result from our query:
			ResultSet resultSet = preparedStatement.executeQuery();
			// because the resultSet has multiple pets in it, we don't just want an
			// if-statesment. We want a loop:
			while (resultSet.next()) {
				Reimbursement reimbursement = ReimbursamentDAOImpl.parseResultSet(resultSet);
				reimbursements.add(reimbursement);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
		
	}
	public void delete(Reimbursement objToDelete) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Reimbursement> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}