package db.app;

import java.sql.Connection;

import db.app.domain.CountryData;
import db.app.domain.PassengerData;
import db.app.repositories.impl.PassengerRepository;
import db.app.unitofwork.IUnitOfWork;

public class PassengerTest {

	public void passengerTest(Connection connection, IUnitOfWork uow) {
		PassengerRepository passengerRepo = new PassengerRepository(connection, uow);
		
		insert(passengerRepo);
	}
	
	private void insert(PassengerRepository passengerRepo) {
		CountryData country = new CountryData();
		country.setId(1);
		
		PassengerData passenger1 = new PassengerData();
		passenger1.setId(1);
		passenger1.setFirstName("Dorota");
		passenger1.setLastName("Gmerek");
		passenger1.setIdNo("xyz123");
		passenger1.setIdType("Passport");
		passenger1.setCountry(country);
		
		passengerRepo.save(passenger1);
		
		PassengerData passenger2 = new PassengerData();
		passenger2.setId(2);
		passenger2.setFirstName("Jan");
		passenger2.setLastName("Kowalski");
		passenger2.setIdNo("1234sdg");
		passenger2.setIdType("ID");
		passenger2.setCountry(country);
		
		passengerRepo.save(passenger2);
	}
}
