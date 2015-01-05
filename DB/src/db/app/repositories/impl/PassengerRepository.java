package db.app.repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.app.domain.PassengerData;
import db.app.repositories.IPassengerDataRepository;
import db.app.repositories.impl.builder.PassengerDataBuilder;
import db.app.unitofwork.IUnitOfWork;

public class PassengerRepository extends Repository<PassengerData> implements IPassengerDataRepository {

	private static String insertSql = "INSERT INTO passenger(id, first_name, last_name, id_type, id_no, country_id) "
			+ "VALUES(?,?,?,?,?,?)";
	
	private static String updateSql = "UPDATE passenger SET first_name = ?, last_name = ?, id_type = ?, "
			+ "id_no = ?, country_no = ? WHERE id = ?";
	
	private static String selectByIdNoSql = "SELECT * FROM passenger WHERE id_no = ?";

	private PreparedStatement selectByIdNoStatement;
	
	public PassengerRepository(Connection connection, IUnitOfWork uow) {
		super(connection, new PassengerDataBuilder(), uow);
		
		try {
			selectByIdNoStatement = connection.prepareStatement(selectByIdNoSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public PassengerData withIdNo(String idNo) {
		try {
			selectByIdNoStatement.setString(1, idNo);

			ResultSet result = selectByIdNoStatement.executeQuery();
			
			if (result.next()) {
				PassengerData passenger = new PassengerDataBuilder().build(result);
				
				return passenger;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	protected void setUpUpdateQuery(PassengerData entity) throws SQLException {
		update.setString(1, entity.getFirstName());
		update.setString(2, entity.getLastName());
		update.setString(3, entity.getIdType());
		update.setString(4, entity.getIdNo());
		update.setInt(5, entity.getCountry().getId());
		update.setInt(6, entity.getId());
	}

	@Override
	protected void setUpInsertQuery(PassengerData entity) throws SQLException {
		insert.setInt(1, entity.getId());
		insert.setString(2, entity.getFirstName());
		insert.setString(3, entity.getLastName());
		insert.setString(4, entity.getIdType());
		insert.setString(5, entity.getIdNo());
		insert.setInt(6, entity.getCountry().getId());
	}

	@Override
	protected String getTableName() {
		return "passenger";
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
