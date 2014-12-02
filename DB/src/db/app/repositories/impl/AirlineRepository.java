package db.app.repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.app.domain.AirlineData;
import db.app.repositories.IAirlineDataRepository;
import db.app.repositories.impl.builder.AirlineDataBuilder;

public class AirlineRepository extends Repository<AirlineData> implements IAirlineDataRepository {
	
	private static String insertSql = "INSERT INTO airline(id, code, name, country_id) VALUES(?,?,?,?)";
	
	private static String updateSql = "UPDATE airline SET code = ?, name = ?, country_id = ? WHERE id = ?";
	
	private static String selectByCodeSql = "SELECT * FROM airline WHERE code = ?";
	
	private PreparedStatement selectByCodeStatement;

	public AirlineRepository(Connection connection) {
		super(connection, new AirlineDataBuilder());
		
		try {
			selectByCodeStatement = connection.prepareStatement(selectByCodeSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public AirlineData withCode(String code) {
		try {
			selectByCodeStatement.setString(1, code);

			ResultSet result = selectByCodeStatement.executeQuery();
			
			if (result.next()) {
				AirlineData airline = new AirlineDataBuilder().build(result);
				
				return airline;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	protected void setUpUpdateQuery(AirlineData entity) throws SQLException {
		update.setString(1, entity.getAirlineCode());
		update.setString(2, entity.getName());
		update.setInt(3, entity.getAirlineCountry().getId());
		update.setInt(4, entity.getId());
	}

	@Override
	protected void setUpInsertQuery(AirlineData entity) throws SQLException {
		insert.setInt(1, entity.getId());
		insert.setString(2, entity.getAirlineCode());
		insert.setString(3, entity.getName());
		insert.setInt(4, entity.getAirlineCountry().getId());
	}

	@Override
	protected String getTableName() {
		return "airline";
	}

	@Override
	protected String getInsertQuery() {
		return insertSql;
	}

	@Override
	protected String getUpdateQuery() {
		return updateSql;
	}

}
