package db.app;

import db.app.domain.AirlineData;
import db.app.repositories.IAirlineDataRepository;
import db.app.repositories.impl.DummyRepositoryCatalog;

public class Main {

	public static void main(String[] args){
		System.out.println("Project by Dorota Gmerek");
		System.out.println();
	
		AirlineData airline1 = new AirlineData();
		airline1.setId(1);
		airline1.setAirlineCode("LH");
		airline1.setAirlineCountry("Germany");
		airline1.setName("Lufthansa");
	
		AirlineData airline2 = new AirlineData();
		airline1.setId(2);
		airline2.setAirlineCode("WIZZ");
		airline2.setAirlineCountry("Hungary");
		airline2.setName("Wizzair");
		
		AirlineData airline3 = new AirlineData();
		airline1.setId(3);
		airline3.setAirlineCode("RY");
		airline3.setAirlineCountry("Ireland");
		airline3.setName("Ryanair");
		
		DummyRepositoryCatalog repositoryCatalog = new DummyRepositoryCatalog();
		IAirlineDataRepository airlineRepository = repositoryCatalog.getAirlineDataRepository();
		
		airlineRepository.save(airline1);
		airlineRepository.save(airline2);
		airlineRepository.save(airline3);
		
		System.out.println("AIRLINES:");
		for (AirlineData airline : airlineRepository.getAll()) {
			System.out.println("Name: " + airline.getName() + "\n" + "Code: " + airline.getAirlineCode() + "\n" + "Country: " + airline.getAirlineCountry());
			System.out.println();
		}
	}
	
}
