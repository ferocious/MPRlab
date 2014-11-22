package db.app.repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.app.domain.AirlineData;
import db.app.domain.AirportData;
import db.app.domain.FlightData;
import db.app.repositories.IFlightDataRepository;

public class FlightRepository implements IFlightDataRepository {

	private String insertSql = "INSERT INTO flight(id, flight_no, departure_date, "
			+ "arrival_date, create_date, dep_airport_id, arr_airport_id, airline_id) "
			+ "VALUES(?,?,?,?,?,?,?,?)";
	
	private String updateSql = "UPDATE flight SET flight_no = ?, departure_date = ?, arrival_date = ?, "
			+ "create_date = ?, create_date = ?, dep_airport_id = ?, arr_airport_id = ?, "
			+ "airline_id = ? WHERE id = ?";
	
	private String deleteSql = "DELETE FROM flight WHERE id = ?";
	
	private String selectByIdSql = "SELECT * FROM flight WHERE id = ?";

	private String selectByFlightNoSql = "SELECT * FROM flight WHERE flight_no = ?";
	
	private String selectAllSql = "SELECT * FROM flight";

	private PreparedStatement insertStatement;
	
	private PreparedStatement updateStatement;

	private PreparedStatement deleteStatement;

	private PreparedStatement selectByIdStatement;

	private PreparedStatement selectByFlightNoStatement;

	private PreparedStatement selectAllStatement;
	
	public FlightRepository(Connection connection) {
		try {
			insertStatement = connection.prepareStatement(insertSql);
			updateStatement = connection.prepareStatement(updateSql);
			deleteStatement = connection.prepareStatement(deleteSql);
			selectByIdStatement = connection.prepareStatement(selectByIdSql);
			selectByFlightNoStatement = connection.prepareStatement(selectByFlightNoSql);
			selectAllStatement = connection.prepareStatement(selectAllSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void save(FlightData entity) {
		try {
			insertStatement.setInt(1, entity.getId());
			insertStatement.setString(2, entity.getFlightNo());
			insertStatement.setTimestamp(3, entity.getDepartureDate());
			insertStatement.setTimestamp(4, entity.getArrivalDate());
			insertStatement.setTimestamp(5, entity.getCreateDate());
			insertStatement.setInt(6, entity.getDepartureAirport().getId());
			insertStatement.setInt(7, entity.getArrivalAirport().getId());
			insertStatement.setInt(8, entity.getAirline().getId());
			
			insertStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(FlightData entity) {
		try {
			updateStatement.setString(1, entity.getFlightNo());
			updateStatement.setTimestamp(2, entity.getDepartureDate());
			updateStatement.setTimestamp(3, entity.getArrivalDate());
			updateStatement.setTimestamp(4, entity.getCreateDate());
			updateStatement.setInt(5, entity.getDepartureAirport().getId());
			updateStatement.setInt(6, entity.getArrivalAirport().getId());
			updateStatement.setInt(7, entity.getAirline().getId());
			updateStatement.setInt(8, entity.getId());
			
			updateStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(FlightData entity) {
		try {
			deleteStatement.setInt(1, entity.getId());
			
			deleteStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public FlightData get(int id) {
		try {
			selectByIdStatement.setInt(1, id);

			ResultSet result = selectByIdStatement.executeQuery();
			
			if (result.next()) {
				FlightData flight = new FlightData();
				
				AirportData depAirport = new AirportData();
				depAirport.setId(result.getInt("dep_airport_id"));
				
				AirportData arrAirport = new AirportData();
				depAirport.setId(result.getInt("arr_airport_id"));
				
				AirlineData airline = new AirlineData();
				airline.setId(result.getInt("airline_id"));
				
				flight.setId(result.getInt("id"));
				flight.setArrivalDate(result.getTimestamp("arrival_date"));
				flight.setDepartureDate(result.getTimestamp("departure_date"));
				flight.setFlightNo(result.getString("flight_no"));
				flight.setAirline(airline);
				flight.setArrivalAirport(arrAirport);
				flight.setDepartureAirport(depAirport);
				
				return flight;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<FlightData> getAll() {
		List<FlightData> resultList = new ArrayList<>();
		
		try {
			ResultSet result = selectAllStatement.executeQuery();
			
			if (result.next()) {
				FlightData flight = new FlightData();
				
				AirportData depAirport = new AirportData();
				depAirport.setId(result.getInt("dep_airport_id"));
				
				AirportData arrAirport = new AirportData();
				depAirport.setId(result.getInt("arr_airport_id"));
				
				AirlineData airline = new AirlineData();
				airline.setId(result.getInt("airline_id"));
				
				flight.setId(result.getInt("id"));
				flight.setArrivalDate(result.getTimestamp("arrival_date"));
				flight.setDepartureDate(result.getTimestamp("departure_date"));
				flight.setFlightNo(result.getString("flight_no"));
				flight.setAirline(airline);
				flight.setArrivalAirport(arrAirport);
				flight.setDepartureAirport(depAirport);
				
				resultList.add(flight);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultList;
	}

	@Override
	public FlightData withFlightNo(String flightNo) {
		try {
			selectByFlightNoStatement.setString(1, flightNo);

			ResultSet result = selectByFlightNoStatement.executeQuery();
			
			if (result.next()) {
				FlightData flight = new FlightData();
				
				AirportData depAirport = new AirportData();
				depAirport.setId(result.getInt("dep_airport_id"));
				
				AirportData arrAirport = new AirportData();
				depAirport.setId(result.getInt("arr_airport_id"));
				
				AirlineData airline = new AirlineData();
				airline.setId(result.getInt("airline_id"));
				
				flight.setId(result.getInt("id"));
				flight.setArrivalDate(result.getTimestamp("arrival_date"));
				flight.setDepartureDate(result.getTimestamp("departure_date"));
				flight.setFlightNo(result.getString("flight_no"));
				flight.setAirline(airline);
				flight.setArrivalAirport(arrAirport);
				flight.setDepartureAirport(depAirport);
				
				return flight;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
}
