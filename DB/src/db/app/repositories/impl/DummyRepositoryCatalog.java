package db.app.repositories.impl;

import db.app.repositories.IAirlineDataRepository;
import db.app.repositories.IAirportDataRepository;
import db.app.repositories.IFlightDataRepository;
import db.app.repositories.IPassengerDataRepository;
import db.app.repositories.IRepositoryCatalog;

public class DummyRepositoryCatalog implements IRepositoryCatalog {
	
	private DummyDb db = new DummyDb();

	@Override
	public IAirportDataRepository getAirporDatatRepository() {
		return new DummyAirportDataRepository(db);
	}

	@Override
	public IAirlineDataRepository getAirlineDataRepository() {
		return new DummyAirlineDataRepository(db);
	}

	@Override
	public IFlightDataRepository getFlightDataRepository() {
		return new DummyFlightDataRepository(db);
	}

	@Override
	public IPassengerDataRepository getPassengerDataRepository() {
		return new DummyPassengerDataRepository(db);
	}

}
