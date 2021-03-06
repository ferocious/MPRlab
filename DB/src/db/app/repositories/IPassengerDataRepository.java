package db.app.repositories;

import db.app.domain.PassengerData;

public interface IPassengerDataRepository extends IRepository<PassengerData> {

	public PassengerData withIdNo(String idNo);
}
