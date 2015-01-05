package db.app.servlets.airline;

import javax.servlet.http.HttpServletRequest;

import db.app.domain.AirlineData;
import db.app.domain.CountryData;
import db.app.repositories.IRepositoryCatalog;
import db.app.repositories.impl.RepositoryCatalogProvider;

public class AirlineServletLogic {

	private IRepositoryCatalog catalog;
	
	public AirlineServletLogic() {
		catalog = RepositoryCatalogProvider.catalog();
	}
	
	public void addNewAirline(HttpServletRequest request) {
		AirlineData airline = new AirlineData();
		airline.setAirlineCode(request.getParameter("airlineCode"));
		airline.setName(request.getParameter("airlineName"));
		
		CountryData country = new CountryData();
		country.setId(1);
		
		airline.setAirlineCountry(country);
		
		catalog.getAirlineDataRepository().save(airline);
		catalog.commit();
	}

	public String showAirlinesInHtmlForm() {
		String html = "<ol>";
		
		for (AirlineData airline : catalog.getAirlineDataRepository().getAll()) {
			html += "<li>" + airline.getName() + "</li>";
		}
		
		html += "</ol>";
		
		return html;
	}
}
