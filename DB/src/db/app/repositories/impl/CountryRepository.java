package db.app.repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.app.domain.CountryData;
import db.app.repositories.ICountryDataRepository;

public class CountryRepository implements ICountryDataRepository {
	
	private String insertSql = "INSERT INTO country(id, code, name) VALUES(?,?,?)";
	
	private String updateSql = "UPDATE country SET code = ?, name = ? WHERE id = ?";
	
	private String deleteSql = "DELETE FROM country WHERE id = ?";
	
	private String selectByIdSql = "SELECT * FROM country WHERE id = ?";

	private String selectAllSql = "SELECT * FROM country";

	private PreparedStatement insertStatement;
	
	private PreparedStatement updateStatement;

	private PreparedStatement deleteStatement;

	private PreparedStatement selectByIdStatement;

	private PreparedStatement selectAllStatement;
	
	public CountryRepository(Connection connection) {
		try {
			insertStatement = connection.prepareStatement(insertSql);
			updateStatement = connection.prepareStatement(updateSql);
			deleteStatement = connection.prepareStatement(deleteSql);
			selectByIdStatement = connection.prepareStatement(selectByIdSql);
			selectAllStatement = connection.prepareStatement(selectAllSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void save(CountryData entity) {
		try {
			insertStatement.setInt(1, entity.getId());
			insertStatement.setString(2, entity.getCode());
			insertStatement.setString(3, entity.getName());
			
			insertStatement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(CountryData entity) {
		try {
			updateStatement.setString(1, entity.getCode());
			updateStatement.setString(2, entity.getName());
			updateStatement.setInt(3, entity.getId());
			
			updateStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(CountryData entity) {
		try {
			deleteStatement.setInt(1, entity.getId());
			
			deleteStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public CountryData get(int id) {
		try {
			selectByIdStatement.setInt(1, id);

			ResultSet result = selectByIdStatement.executeQuery();
			
			if (result.next()) {
				CountryData country = new CountryData();
				
				country.setId(result.getInt("id"));
				country.setCode(result.getString("code"));
				country.setName(result.getString("name"));
				
				return country;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<CountryData> getAll() {
		final List<CountryData> resultList = new ArrayList<>();
		
		try {
			ResultSet result = selectAllStatement.executeQuery();
			
			while (result.next()) {
				CountryData country = new CountryData();
				
				country.setId(result.getInt("id"));
				country.setCode(result.getString("code"));
				country.setName(result.getString("name"));
				
				resultList.add(country);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultList;
	}

}
