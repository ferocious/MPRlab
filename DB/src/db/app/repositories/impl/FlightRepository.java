package db.app.repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.app.domain.FlightData;
import db.app.repositories.IFlightDataRepository;
import db.app.repositories.impl.builder.FlightDataBuilder;
import db.app.unitofwork.IUnitOfWork;

public class FlightRepository extends Repository<FlightData> implements IFlightDataRepository {

	private static String insertSql = "INSERT INTO flight(id, flight_no, departure_date, "
			+ "arrival_date, create_date, dep_airport_id, arr_airport_id, airline_id) "
			+ "VALUES(?,?,?,?,?,?,?,?)";
	
	private static String updateSql = "UPDATE flight SET flight_no = ?, departure_date = ?, arrival_date = ?, "
			+ "create_date = ?, create_date = ?, dep_airport_id = ?, arr_airport_id = ?, "
			+ "airline_id = ? WHERE id = ?";
	
	private static String selectByFlightNoSql = "SELECT * FROM flight WHERE flight_no = ?";
	
	private PreparedStatement selectByFlightNoStatement;
	
	public FlightRepository(Connection connection, IUnitOfWork uow) {
		super(connection, new FlightDataBuilder(), uow);
		
		try {
			selectByFlightNoStatement = connection.prepareStatement(selectByFlightNoSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public FlightData withFlightNo(String flightNo) {
		try {
			selectByFlightNoStatement.setString(1, flightNo);

			ResultSet result = selectByFlightNoStatement.executeQuery();
			
			if (result.next()) {
				FlightData flight = new FlightDataBuilder().build(result);
				
				return flight;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	protected void setUpUpdateQuery(FlightData entity) throws SQLException {
		update.setString(1, entity.getFlightNo());
		update.setTimestamp(2, entity.getDepartureDate());
		update.setTimestamp(3, entity.getArrivalDate());
		update.setTimestamp(4, entity.getCreateDate());
		update.setInt(5, entity.getDepartureAirport().getId());
		update.setInt(6, entity.getArrivalAirport().getId());
		update.setInt(7, entity.getAirline().getId());
		update.setInt(8, entity.getId());
	}

	@Override
	protected void setUpInsertQuery(FlightData entity) throws SQLException {
		insert.setInt(1, entity.getId());
		insert.setString(2, entity.getFlightNo());
		insert.setTimestamp(3, entity.getDepartureDate());
		insert.setTimestamp(4, entity.getArrivalDate());
		insert.setTimestamp(5, entity.getCreateDate());
		insert.setInt(6, entity.getDepartureAirport().getId());
		insert.setInt(7, entity.getArrivalAirport().getId());
		insert.setInt(8, entity.getAirline().getId());
	}

	@Override
	protected String getTableName() {
		return "flight";
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
