package db.app.repositories;

import db.app.domain.FlightData;

public interface IFlightDataRepository extends IRepository<FlightData> {

	public FlightData withFlightNo(String flightNo);
}
