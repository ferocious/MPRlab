package db.app;

import java.sql.Connection;
import java.sql.Timestamp;

import db.app.domain.AirlineData;
import db.app.domain.AirportData;
import db.app.domain.FlightData;
import db.app.repositories.impl.FlightRepository;

public class FlightTest {

	public void flightTest(Connection connection) {
		FlightRepository flightRepo = new FlightRepository(connection);
		
		insert(flightRepo);
	}
	
	private void insert(FlightRepository flightRepo) {
		AirportData airport = new AirportData();
		airport.setId(1);
		
		AirlineData airline = new AirlineData();
		airline.setId(1);
		
		FlightData flight = new FlightData();
		flight.setId(1);
		flight.setAirline(airline);
		
		flight.setDepartureAirport(airport);
		flight.setArrivalAirport(airport);
		
		flight.setArrivalDate(new Timestamp(System.currentTimeMillis()));
		flight.setDepartureDate(new Timestamp(System.currentTimeMillis()));
		
		flight.setFlightNo("flight1234");
		
		flightRepo.save(flight);
	}
}
