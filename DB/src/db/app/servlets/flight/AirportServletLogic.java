package db.app.servlets.flight;

import javax.servlet.http.HttpServletRequest;

import db.app.domain.AirportData;
import db.app.domain.CountryData;
import db.app.repositories.IRepositoryCatalog;
import db.app.repositories.impl.RepositoryCatalogProvider;

public class AirportServletLogic {

	private IRepositoryCatalog catalog = RepositoryCatalogProvider.catalog();
	
	public void addNewAirport(HttpServletRequest request) {
		AirportData airport = new AirportData();
		airport.setAirportAddress(request.getParameter("airportAddress"));
		airport.setAirportCity(request.getParameter("airportCity"));
		airport.setAirportCode(request.getParameter("airportCode"));
		
		CountryData country = new CountryData();
		country.setId(1);
		
		airport.setCountry(country);
		
		catalog.getAirporDatatRepository().save(airport);
		catalog.commit();
	}
	
	public String showAirportsInHtmlForm() {
		String html = "<ol>";
		
		for (AirportData airport : catalog.getAirporDatatRepository().getAll()) {
			html += "<li>" + airport.getAirportCode() + "</li>";
		}
		
		html += "</ol>";
		return html;
	}
}
