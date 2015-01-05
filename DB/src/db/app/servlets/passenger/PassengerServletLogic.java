package db.app.servlets.passenger;

import javax.servlet.http.HttpServletRequest;

import db.app.domain.CountryData;
import db.app.domain.PassengerData;
import db.app.repositories.IRepositoryCatalog;
import db.app.repositories.impl.RepositoryCatalogProvider;

public class PassengerServletLogic {

	private IRepositoryCatalog catalog = RepositoryCatalogProvider.catalog();
	
	public void addNewPassenger(HttpServletRequest request) {
		PassengerData passenger = new PassengerData();
		passenger.setFirstName(request.getParameter("passengerFirstName"));
		passenger.setLastName(request.getParameter("passengerLastName"));
		passenger.setIdNo(request.getParameter("passengerIdNo"));
		passenger.setIdType(request.getParameter("passengerIdType"));
		
		CountryData country = new CountryData();
		country.setId(1);
		
		passenger.setCountry(country);
		
		catalog.getPassengerDataRepository().save(passenger);
		catalog.commit();
	}
	
	public String showPassengersInHtmlForm() {
		String html = "<ol>";
		
		for (PassengerData passenger : catalog.getPassengerDataRepository().getAll()) {
			html += "<li>" + passenger.getLastName() + "</li>";
		}
		
		html += "</ol>";
		return html;
	}
}
