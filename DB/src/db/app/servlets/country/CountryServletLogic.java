package db.app.servlets.country;

import javax.servlet.http.HttpServletRequest;

import db.app.domain.CountryData;
import db.app.repositories.IRepositoryCatalog;
import db.app.repositories.impl.RepositoryCatalogProvider;

public class CountryServletLogic {

	private IRepositoryCatalog catalog;
	
	public CountryServletLogic() {
		catalog = RepositoryCatalogProvider.catalog();
	}
	
	public void addNewCountry(HttpServletRequest request) {
		CountryData country = new CountryData();
		country.setCode(request.getParameter("countryCode"));
		country.setName(request.getParameter("countryName"));
		
		catalog.getCountryDataRepository().save(country);
		catalog.commit();
	}

	public String showCountriesInHtmlForm() {
		String html = "<ol>";
		
		for (CountryData country : catalog.getCountryDataRepository().getAll()) {
			html += "<li>" + country.getName() + "</li>";
		}
		
		html += "</ol>";
		
		return html;
	}
}
