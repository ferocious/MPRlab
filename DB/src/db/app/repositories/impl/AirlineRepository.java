package db.app.repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.app.domain.AirlineData;
import db.app.domain.CountryData;
import db.app.repositories.IAirlineDataRepository;

public class AirlineRepository implements IAirlineDataRepository {
	
	private String insertSql = "INSERT INTO airline(id, code, name, country_id) VALUES(?,?,?,?)";
	
	private String updateSql = "UPDATE airline SET code = ?, name = ?, country_id = ? WHERE id = ?";
	
	private String deleteSql = "DELETE FROM airline WHERE id = ?";
	
	private String selectByIdSql = "SELECT * FROM airline WHERE id = ?";

	private String selectByCodeSql = "SELECT * FROM airline WHERE code = ?";
	
	private String selectAllSql = "SELECT * FROM airline";

	private PreparedStatement insertStatement;
	
	private PreparedStatement updateStatement;

	private PreparedStatement deleteStatement;

	private PreparedStatement selectByIdStatement;

	private PreparedStatement selectByCodeStatement;

	private PreparedStatement selectAllStatement;

	public AirlineRepository(Connection connection) {
		try {
			insertStatement = connection.prepareStatement(insertSql);
			updateStatement = connection.prepareStatement(updateSql);
			deleteStatement = connection.prepareStatement(deleteSql);
			selectByIdStatement = connection.prepareStatement(selectByIdSql);
			selectByCodeStatement = connection.prepareStatement(selectByCodeSql);
			selectAllStatement = connection.prepareStatement(selectAllSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void save(AirlineData entity) {
		try {
			insertStatement.setInt(1, entity.getId());
			insertStatement.setString(2, entity.getAirlineCode());
			insertStatement.setString(3, entity.getName());
			insertStatement.setInt(4, entity.getAirlineCountry().getId());
			
			insertStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(AirlineData entity) {
		try {
			updateStatement.setString(1, entity.getAirlineCode());
			updateStatement.setString(2, entity.getName());
			updateStatement.setInt(3, entity.getAirlineCountry().getId());
			updateStatement.setInt(4, entity.getId());
			
			updateStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(AirlineData entity) {
		try {
			deleteStatement.setInt(1, entity.getId());
			
			deleteStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public AirlineData get(int id) {
		try {
			selectByIdStatement.setInt(1, id);

			ResultSet result = selectByIdStatement.executeQuery();
			
			if (result.next()) {
				AirlineData airline = new AirlineData();
				
				airline.setId(result.getInt("id"));
				airline.setAirlineCode(result.getString("code"));
				airline.setName(result.getString("name"));
				
				CountryData country = new CountryData();
				country.setId(result.getInt("country_id"));
				
				airline.setAirlineCountry(country);
				
				return airline;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<AirlineData> getAll() {
		final List<AirlineData> resultList = new ArrayList<>();
		
		try {
			ResultSet result = selectAllStatement.executeQuery();
			
			while (result.next()) {
				AirlineData airline = new AirlineData();
				
				airline.setId(result.getInt("id"));
				airline.setAirlineCode("code");
				airline.setName("name");
				
				CountryData country = new CountryData();
				country.setId(result.getInt("country_id"));
				
				airline.setAirlineCountry(country);
				
				resultList.add(airline);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultList;
	}

	@Override
	public AirlineData withCode(String code) {
		try {
			selectByCodeStatement.setString(1, code);

			ResultSet result = selectByCodeStatement.executeQuery();
			
			if (result.next()) {
				AirlineData airline = new AirlineData();
				
				airline.setId(result.getInt("id"));
				airline.setAirlineCode(result.getString("code"));
				airline.setName(result.getString("name"));
				
				CountryData country = new CountryData();
				country.setId(result.getInt("country_id"));
				
				airline.setAirlineCountry(country);
				
				return airline;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
