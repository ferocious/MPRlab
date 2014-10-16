package db.app.repositories.impl;

import java.util.List;

import db.app.domain.AirportData;
import db.app.repositories.IAirportDataRepository;

public class DummyAirportDataRepository implements IAirportDataRepository {
	
	private DummyDb db;

	public DummyAirportDataRepository(DummyDb db) {
		this.db = db;
	}

	@Override
	public void save(AirportData entity) {
		db.airports.add(entity);
	}

	@Override
	public void update(AirportData entity) {
		AirportData airport = get(entity.getId());
		
		if (airport != null) {
			airport.setAirportAddress(entity.getAirportAddress());
			airport.setAirportCity(entity.getAirportCity());
			airport.setAirportCode(entity.getAirportCode());
			airport.setAirportCountry(entity.getAirportCountry());
		}
	}

	@Override
	public void delete(AirportData entity) {
		db.airports.remove(entity);
	}

	@Override
	public AirportData get(int id) {
		for (AirportData airport : db.airports) {
			if (airport.getId() == id) {
				return airport;
			}
		}
		
		return null;
	}

	@Override
	public List<AirportData> getAll() {
		return db.airports;
	}

	@Override
	public AirportData withCode(String code) {
		for (AirportData airport : db.airports) {
			if (airport.getAirportCode().equals(code)) {
				return airport;
			}
		}
		
		return null;
	}

}
