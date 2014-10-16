package db.app.repositories.impl;

import java.util.List;

import db.app.domain.AirlineData;
import db.app.repositories.IAirlineDataRepository;

public class DummyAirlineDataRepository implements IAirlineDataRepository {
	
	private DummyDb db;
	
	public DummyAirlineDataRepository(DummyDb db) {
		this.db = db;
	}

	@Override
	public void save(AirlineData entity) {
		db.airlines.add(entity);
	}

	@Override
	public void update(AirlineData entity) {
		AirlineData airline = get(entity.getId());
		
		if (airline != null) {
			airline.setAirlineCode(entity.getAirlineCode());
			airline.setAirlineCountry(entity.getAirlineCountry());
			airline.setName(airline.getName());
		}
	}

	@Override
	public void delete(AirlineData entity) {
		db.airlines.remove(entity);
	}

	@Override
	public AirlineData get(int id) {
		for (AirlineData airline : db.airlines) {
			if (airline.getId() == id) {
				return airline;
			}
		}
		
		return null;
	}

	@Override
	public List<AirlineData> getAll() {
		return db.airlines;
	}

	@Override
	public AirlineData withCode(String code) {
		for (AirlineData airline : db.airlines) {
			if (airline.getAirlineCode().equals(code)) {
				return airline;
			}
		}
		
		return null;
	}

}
