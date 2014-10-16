package db.app.repositories;

import db.app.domain.AirlineData;

public interface IAirlineDataRepository extends IRepository<AirlineData> {
 
	public AirlineData withCode(String code);
}
