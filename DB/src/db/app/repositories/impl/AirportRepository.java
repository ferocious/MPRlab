package db.app.repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.app.domain.AirportData;
import db.app.domain.CountryData;
import db.app.repositories.IAirportDataRepository;

public class AirportRepository implements IAirportDataRepository {

	private String insertSql = "INSERT INTO airport(id, airport_code, city, address, country_id) VALUES(?,?,?,?,?)";
	
	private String updateSql = "UPDATE airport SET airport_code = ?, city = ?, address = ?, country_id = ? WHERE id = ?";
	
	private String deleteSql = "DELETE FROM airport WHERE id = ?";
	
	private String selectByIdSql = "SELECT * FROM airport WHERE id = ?";

	private String selectByCodeSql = "SELECT * FROM airport WHERE airport_code = ?";
	
	private String selectAllSql = "SELECT * FROM airport";

	private PreparedStatement insertStatement;
	
	private PreparedStatement updateStatement;

	private PreparedStatement deleteStatement;

	private PreparedStatement selectByIdStatement;

	private PreparedStatement selectByCodeStatement;

	private PreparedStatement selectAllStatement;
	
	public AirportRepository(Connection connection) {
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
	public void save(AirportData entity) {
		try {
			insertStatement.setInt(1, entity.getId());
			insertStatement.setString(2, entity.getAirportCode());
			insertStatement.setString(3, entity.getAirportCity());
			insertStatement.setString(4, entity.getAirportAddress());
			insertStatement.setInt(5, entity.getCountry().getId());
			
			insertStatement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(AirportData entity) {
		try {
			updateStatement.setString(1, entity.getAirportCode());
			updateStatement.setString(2, entity.getAirportCity());
			updateStatement.setString(3, entity.getAirportAddress());
			updateStatement.setInt(4, entity.getCountry().getId());
			updateStatement.setInt(5, entity.getId());
			
			updateStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(AirportData entity) {
		try {
			deleteStatement.setInt(1, entity.getId());
			
			deleteStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public AirportData get(int id) {
		try {
			selectByIdStatement.setInt(1, id);

			ResultSet result = selectByIdStatement.executeQuery();
			
			if (result.next()) {
				AirportData airport = new AirportData();
				
				airport.setId(result.getInt("id"));
				airport.setAirportCode(result.getString("airport_code"));
				airport.setAirportCity(result.getString("city"));
				airport.setAirportAddress(result.getString("address"));
				
				CountryData country = new CountryData();
				country.setId(result.getInt("country_id"));
				
				airport.setCountry(country);
				
				return airport;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<AirportData> getAll() {
		final List<AirportData> resultList = new ArrayList<>();
		
		try {
			ResultSet result = selectAllStatement.executeQuery();
			
			while (result.next()) {
				AirportData airport = new AirportData();
				
				airport.setId(result.getInt("id"));
				airport.setAirportCode(result.getString("airport_code"));
				airport.setAirportCity(result.getString("city"));
				airport.setAirportAddress(result.getString("address"));
				
				CountryData country = new CountryData();
				country.setId(result.getInt("country_id"));
				
				airport.setCountry(country);
				
				resultList.add(airport);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultList;
	}

	@Override
	public AirportData withCode(String code) {
		try {
			selectByCodeStatement.setString(1, code);

			ResultSet result = selectByCodeStatement.executeQuery();
			
			if (result.next()) {
				AirportData airport = new AirportData();
				
				airport.setId(result.getInt("id"));
				airport.setAirportCode(result.getString("airport_code"));
				airport.setAirportCity(result.getString("city"));
				airport.setAirportAddress(result.getString("address"));
				
				CountryData country = new CountryData();
				country.setId(result.getInt("country_id"));
				
				airport.setCountry(country);
				
				return airport;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
