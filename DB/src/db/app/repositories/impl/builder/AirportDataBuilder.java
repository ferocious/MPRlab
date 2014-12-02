package db.app.repositories.impl.builder;

import java.sql.ResultSet;
import java.sql.SQLException;

import db.app.domain.AirportData;
import db.app.domain.CountryData;

public class AirportDataBuilder implements IEntityBuilder<AirportData> {

	@Override
	public AirportData build(ResultSet rs) throws SQLException {
		AirportData airport = new AirportData();
		
		airport.setId(rs.getInt("id"));
		airport.setAirportCode(rs.getString("airport_code"));
		airport.setAirportCity(rs.getString("city"));
		airport.setAirportAddress(rs.getString("address"));
		
		CountryData country = new CountryData();
		country.setId(rs.getInt("country_id"));
		
		airport.setCountry(country);
		
		return airport;
	}

}
