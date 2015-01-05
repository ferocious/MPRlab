package db.app;

import java.sql.Connection;
import java.util.List;

import db.app.domain.CountryData;
import db.app.repositories.impl.CountryRepository;
import db.app.unitofwork.IUnitOfWork;

public class CountryTest {

	public void countryTest(Connection connection, IUnitOfWork uow) {
		CountryRepository countryRepo = new CountryRepository(connection, uow);

		insertCountry(countryRepo);
		updateCountry(countryRepo);
		deleteCountry(countryRepo);
		getCountry(countryRepo);
		getAllCountries(countryRepo);
	}
	
	private void insertCountry(CountryRepository countryRepo) {
		CountryData countryPl = new CountryData();
		
		countryPl.setId(1);
		countryPl.setCode("pl");
		countryPl.setName("polska");
		
		countryRepo.save(countryPl);
		
		CountryData countryDe = new CountryData();
		
		countryDe.setId(2);
		countryDe.setCode("de");
		countryDe.setName("niemcy");
		
		countryRepo.save(countryDe);
	}
	
	private void updateCountry(CountryRepository countryRepo) {
		CountryData country = new CountryData();
		
		country.setId(1);
		country.setCode("PL");
		country.setName("Polska");
		
		countryRepo.update(country);
	}

	private void deleteCountry(CountryRepository countryRepo) {
		CountryData country = new CountryData();
		
		country.setId(2);
		
		countryRepo.delete(country);
	}

	private void getCountry(CountryRepository countryRepo) {
		CountryData country = countryRepo.get(1);
		
		if (country != null) {
			System.out.println(country);
		} else {
			System.out.println("Country not found!");
		}
	}
	
	private void getAllCountries(CountryRepository countryRepo) {
		List<CountryData> countryList = countryRepo.getAll();
		
		for (CountryData country : countryList) {
			System.out.println(country);
		}
	}
}
