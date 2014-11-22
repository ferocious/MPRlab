package db.app.repositories.impl;

import java.util.List;

import db.app.domain.FlightData;
import db.app.repositories.IFlightDataRepository;

public class DummyFlightDataRepository implements IFlightDataRepository {

	private DummyDb db;
	
	public DummyFlightDataRepository(DummyDb db) {
		this.db = db;
	}

	@Override
	public void save(FlightData entity) {
		db.flights.add(entity);
	}

	@Override
	public void update(FlightData entity) {
		FlightData flight = get(entity.getId());
		
		if (flight != null) {
			flight.setAirline(entity.getAirline());
//			flight.setAirplaneType(entity.getAirplaneType());
//			flight.setArrivalDate(entity.getArrivalDate());
//			flight.setDepartureDate(entity.getDepartureDate());
//			flight.setFlightFrom(entity.getFlightFrom());
//			flight.setFlightNo(entity.getFlightNo());
//			flight.setFlightTo(entity.getFlightTo());
//			flight.setPassengersList(entity.getPassengersList());
		}
	}

	@Override
	public void delete(FlightData entity) {
		db.flights.remove(entity);
	}

	@Override
	public FlightData get(int id) {
		for (FlightData flight : db.flights) {
			if (flight.getId() == id) {
				return flight;
			}
		}
		
		return null;
	}

	@Override
	public List<FlightData> getAll() {
		return db.flights;
	}

	@Override
	public FlightData withFlightNo(String flightNo) {
		for (FlightData flight : db.flights) {
			if (flight.getFlightNo().equals(flightNo)) {
				return flight;
			}
		}
		
		return null;
	}

}
