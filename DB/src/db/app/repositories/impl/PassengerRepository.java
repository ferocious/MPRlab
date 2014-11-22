package db.app.repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.app.domain.CountryData;
import db.app.domain.PassengerData;
import db.app.repositories.IPassengerDataRepository;

public class PassengerRepository implements IPassengerDataRepository {

	private String insertSql = "INSERT INTO passenger(id, first_name, last_name, id_type, id_no, country_id) "
			+ "VALUES(?,?,?,?,?,?)";
	
	private String updateSql = "UPDATE passenger SET first_name = ?, last_name = ?, id_type = ?, "
			+ "id_no = ?, country_no = ? WHERE id = ?";
	
	private String deleteSql = "DELETE FROM passenger WHERE id = ?";
	
	private String selectByIdSql = "SELECT * FROM passenger WHERE id = ?";

	private String selectByIdNoSql = "SELECT * FROM passenger WHERE id_no = ?";
	
	private String selectAllSql = "SELECT * FROM passenger";

	private PreparedStatement insertStatement;
	
	private PreparedStatement updateStatement;

	private PreparedStatement deleteStatement;

	private PreparedStatement selectByIdStatement;

	private PreparedStatement selectByIdNoStatement;

	private PreparedStatement selectAllStatement;
	
	public PassengerRepository(Connection connection) {
		try {
			insertStatement = connection.prepareStatement(insertSql);
			updateStatement = connection.prepareStatement(updateSql);
			deleteStatement = connection.prepareStatement(deleteSql);
			selectByIdStatement = connection.prepareStatement(selectByIdSql);
			selectByIdNoStatement = connection.prepareStatement(selectByIdNoSql);
			selectAllStatement = connection.prepareStatement(selectAllSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void save(PassengerData entity) {
		try {
			insertStatement.setInt(1, entity.getId());
			insertStatement.setString(2, entity.getFirstName());
			insertStatement.setString(3, entity.getLastName());
			insertStatement.setString(4, entity.getIdType());
			insertStatement.setString(5, entity.getIdNo());
			insertStatement.setInt(6, entity.getCountry().getId());
			
			insertStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(PassengerData entity) {
		try {
			updateStatement.setString(1, entity.getFirstName());
			updateStatement.setString(2, entity.getLastName());
			updateStatement.setString(3, entity.getIdType());
			updateStatement.setString(4, entity.getIdNo());
			updateStatement.setInt(5, entity.getCountry().getId());
			updateStatement.setInt(6, entity.getId());
			
			updateStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(PassengerData entity) {
		try {
			deleteStatement.setInt(1, entity.getId());
			
			deleteStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public PassengerData get(int id) {
		try {
			selectByIdStatement.setInt(1, id);

			ResultSet result = selectByIdStatement.executeQuery();
			
			if (result.next()) {
				PassengerData passenger = new PassengerData();
				
				passenger.setId(result.getInt("id"));
				passenger.setFirstName(result.getString("first_name"));
				passenger.setLastName(result.getString("last_name"));
				passenger.setIdType(result.getString("id_type"));
				passenger.setIdNo(result.getString("id_no"));
				
				CountryData country = new CountryData();
				country.setId(result.getInt("country_id"));
				
				passenger.setCountry(country);
				
				return passenger;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<PassengerData> getAll() {
		List<PassengerData> resultList = new ArrayList<>();
		
		try {
			ResultSet result = selectAllStatement.executeQuery();
			
			if (result.next()) {
				PassengerData passenger = new PassengerData();
				
				passenger.setId(result.getInt("id"));
				passenger.setFirstName(result.getString("first_name"));
				passenger.setLastName(result.getString("last_name"));
				passenger.setIdType(result.getString("id_type"));
				passenger.setIdNo(result.getString("id_no"));
				
				CountryData country = new CountryData();
				country.setId(result.getInt("country_id"));
				
				passenger.setCountry(country);
				
				resultList.add(passenger);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultList;
	}

	@Override
	public PassengerData withIdNo(String idNo) {
		try {
			selectByIdNoStatement.setString(1, idNo);

			ResultSet result = selectByIdNoStatement.executeQuery();
			
			if (result.next()) {
				PassengerData passenger = new PassengerData();
				
				passenger.setId(result.getInt("id"));
				passenger.setFirstName(result.getString("first_name"));
				passenger.setLastName(result.getString("last_name"));
				passenger.setIdType(result.getString("id_type"));
				passenger.setIdNo(result.getString("id_no"));
				
				CountryData country = new CountryData();
				country.setId(result.getInt("country_id"));
				
				passenger.setCountry(country);
				
				return passenger;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
