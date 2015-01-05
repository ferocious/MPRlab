package db.app;

import java.sql.Connection;
import java.util.List;

import db.app.domain.AirportData;
import db.app.domain.CountryData;
import db.app.repositories.impl.AirportRepository;
import db.app.unitofwork.IUnitOfWork;

public class AirportTest {

	public void airportTest(Connection connection, IUnitOfWork uow) {
		AirportRepository airportRepo = new AirportRepository(connection, uow);

		insertAirport(airportRepo);
		updateAirport(airportRepo);
		deleteAirport(airportRepo);
		getAirport(airportRepo);
		getAllAirports(airportRepo);
	}
	
	private void insertAirport(AirportRepository airportRepo) {
		CountryData country = new CountryData();
		country.setId(1);
		
		AirportData airport1 = new AirportData();
		airport1.setId(1);
		airport1.setAirportAddress("addres1");
		airport1.setAirportCity("Gdansk");
		airport1.setAirportCode("GDN");
		airport1.setCountry(country);
		
		airportRepo.save(airport1);
		
		AirportData airport2 = new AirportData();
		airport2.setId(2);
		airport2.setAirportAddress("addres1");
		airport2.setAirportCity("Warszawa");
		airport2.setAirportCode("WAR");
		airport2.setCountry(country);
		
		airportRepo.save(airport2);
	}
	
	private void updateAirport(AirportRepository airportRepo) {
		CountryData country = new CountryData();
		country.setId(1);
		
		AirportData airport1 = new AirportData();
		airport1.setId(1);
		airport1.setAirportAddress("addres2");
		airport1.setAirportCity("Gdansk");
		airport1.setAirportCode("GDN");
		airport1.setCountry(country);
		
		airportRepo.update(airport1);
	}

	private void deleteAirport(AirportRepository airportRepo) {
		AirportData airport = new AirportData();
		
		airport.setId(2);
		
		airportRepo.delete(airport);
	}

	private void getAirport(AirportRepository airportRepo) {
		AirportData airport = airportRepo.get(1);
		
		if (airport != null) {
			System.out.println(airport);
		} else {
			System.out.println("Airport not found!");
		}
	}
	
	private void getAllAirports(AirportRepository airportRepo) {
		List<AirportData> airportList = airportRepo.getAll();
		
		for (AirportData airport : airportList) {
			System.out.println(airport);
		}
	}
}
