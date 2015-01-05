package db.app.repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.app.domain.AirportData;
import db.app.repositories.IAirportDataRepository;
import db.app.repositories.impl.builder.AirportDataBuilder;
import db.app.unitofwork.IUnitOfWork;

public class AirportRepository extends Repository<AirportData> implements IAirportDataRepository {

	private static String insertSql = "INSERT INTO airport(id, airport_code, city, address, country_id) VALUES(?,?,?,?,?)";
	
	private static String updateSql = "UPDATE airport SET airport_code = ?, city = ?, address = ?, country_id = ? WHERE id = ?";
	
	private static String selectByCodeSql = "SELECT * FROM airport WHERE airport_code = ?";

	private PreparedStatement selectByCodeStatement;

	public AirportRepository(Connection connection, IUnitOfWork uow) {
		super(connection, new AirportDataBuilder(), uow);
		
		try {
			selectByCodeStatement = connection.prepareStatement(selectByCodeSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public AirportData withCode(String code) {
		try {
			selectByCodeStatement.setString(1, code);

			ResultSet result = selectByCodeStatement.executeQuery();
			
			if (result.next()) {
				AirportData airport = new AirportDataBuilder().build(result);
				
				return airport;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	protected void setUpUpdateQuery(AirportData entity) throws SQLException {
		update.setString(1, entity.getAirportCode());
		update.setString(2, entity.getAirportCity());
		update.setString(3, entity.getAirportAddress());
		update.setInt(4, entity.getCountry().getId());
		update.setInt(5, entity.getId());
	}

	@Override
	protected void setUpInsertQuery(AirportData entity) throws SQLException {
		insert.setInt(1, entity.getId());
		insert.setString(2, entity.getAirportCode());
		insert.setString(3, entity.getAirportCity());
		insert.setString(4, entity.getAirportAddress());
		insert.setInt(5, entity.getCountry().getId());
	}

	@Override
	protected String getTableName() {
		return "airport";
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
