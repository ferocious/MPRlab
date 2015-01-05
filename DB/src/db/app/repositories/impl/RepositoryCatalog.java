package db.app.repositories.impl;

import java.sql.Connection;

import db.app.repositories.IAirlineDataRepository;
import db.app.repositories.IAirportDataRepository;
import db.app.repositories.ICountryDataRepository;
import db.app.repositories.IFlightDataRepository;
import db.app.repositories.IPassengerDataRepository;
import db.app.repositories.IRepositoryCatalog;
import db.app.unitofwork.IUnitOfWork;

public class RepositoryCatalog implements IRepositoryCatalog {
	
	private Connection connection;
	
	private IUnitOfWork uow;

	public RepositoryCatalog(Connection connection, IUnitOfWork uow) {
		super();
		this.connection = connection;
		this.uow = uow;
	}

	@Override
	public void commit() {
		uow.commit();
	}

	@Override
	public IAirportDataRepository getAirporDatatRepository() {
		return new AirportRepository(connection, uow);
	}

	@Override
	public IAirlineDataRepository getAirlineDataRepository() {
		return new AirlineRepository(connection, uow);
	}

	@Override
	public IFlightDataRepository getFlightDataRepository() {
		return new FlightRepository(connection, uow);
	}

	@Override
	public IPassengerDataRepository getPassengerDataRepository() {
		return new PassengerRepository(connection, uow);
	}

	@Override
	public ICountryDataRepository getCountryDataRepository() {
		return new CountryRepository(connection, uow);
	}
}