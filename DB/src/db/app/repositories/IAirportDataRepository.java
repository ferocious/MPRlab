package db.app.repositories;

import db.app.domain.AirportData;

public interface IAirportDataRepository extends IRepository<AirportData> {

	public AirportData withCode(String code);
}
