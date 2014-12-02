package db.app.repositories.impl.builder;

import java.sql.ResultSet;
import java.sql.SQLException;

import db.app.domain.AirlineData;
import db.app.domain.AirportData;
import db.app.domain.FlightData;

public class FlightDataBuilder implements IEntityBuilder<FlightData> {

	@Override
	public FlightData build(ResultSet rs) throws SQLException {
		FlightData flight = new FlightData();
		
		AirportData depAirport = new AirportData();
		depAirport.setId(rs.getInt("dep_airport_id"));
		
		AirportData arrAirport = new AirportData();
		depAirport.setId(rs.getInt("arr_airport_id"));
		
		AirlineData airline = new AirlineData();
		airline.setId(rs.getInt("airline_id"));
		
		flight.setId(rs.getInt("id"));
		flight.setArrivalDate(rs.getTimestamp("arrival_date"));
		flight.setDepartureDate(rs.getTimestamp("departure_date"));
		flight.setFlightNo(rs.getString("flight_no"));
		flight.setAirline(airline);
		flight.setArrivalAirport(arrAirport);
		flight.setDepartureAirport(depAirport);
		
		return flight;
	}
}
