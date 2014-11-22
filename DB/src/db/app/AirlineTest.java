package db.app;

import java.sql.Connection;
import java.util.List;

import db.app.domain.AirlineData;
import db.app.domain.CountryData;
import db.app.repositories.impl.AirlineRepository;

public class AirlineTest {

	public void airlineTest(final Connection connection) {
		AirlineRepository airlineRepo = new AirlineRepository(connection);
		
		insert(airlineRepo);
		update(airlineRepo);
		delete(airlineRepo);
		selectAll(airlineRepo);
		selectByCode(airlineRepo);
	}
	
	private void insert(final AirlineRepository airlineRepo) {
		CountryData country = new CountryData();
		country.setId(1);
		
		AirlineData airline1 = new AirlineData();
		airline1.setId(1);
		airline1.setAirlineCode("LOT");
		airline1.setName("Polskie Linie Lotnicze LOT");
		airline1.setAirlineCountry(country);
		
		airlineRepo.save(airline1);
		
		AirlineData airline2 = new AirlineData();
		airline2.setId(2);
		airline2.setAirlineCode("LH");
		airline2.setName("Lufthansa");
		airline2.setAirlineCountry(country);
		
		airlineRepo.save(airline2);
	}
	
	private void update(AirlineRepository airlineRepo) {
		CountryData country = new CountryData();
		country.setId(1);
		
		AirlineData airline1 = new AirlineData();
		airline1.setId(1);
		airline1.setAirlineCode("LOT_2");
		airline1.setName("Polskie Linie Lotnicze LOT_2");
		airline1.setAirlineCountry(country);
		
		airlineRepo.update(airline1);
	}
	
	private void delete(AirlineRepository airlineRepo) {
		AirlineData airline = new AirlineData();
		airline.setId(2);
		
		airlineRepo.delete(airline);
	}
	
	private void selectAll(AirlineRepository airlineRepo) {
		List<AirlineData> results = airlineRepo.getAll();
		
		System.out.println(results);
	}
	
	private void selectByCode(AirlineRepository airlineRepo) {
		AirlineData airline = airlineRepo.get(1);
		
		System.out.println(airline);
	}
}
