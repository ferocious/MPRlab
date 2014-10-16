package db.app.repositories;

public interface IRepositoryCatalog {

	public IAirportDataRepository getAirporDatatRepository();
	public IAirlineDataRepository getAirlineDataRepository();
	public IFlightDataRepository getFlightDataRepository();
	public IPassengerDataRepository getPassengerDataRepository();
}
