package db.app.repositories.impl.builder;

import java.sql.ResultSet;
import java.sql.SQLException;

import db.app.domain.AirlineData;
import db.app.domain.CountryData;

public class AirlineDataBuilder implements IEntityBuilder<AirlineData> {

	@Override
	public AirlineData build(ResultSet rs) throws SQLException {
		AirlineData airline = new AirlineData();
		
		airline.setId(rs.getInt("id"));
		airline.setAirlineCode(rs.getString("code"));
		airline.setName(rs.getString("name"));
		
		CountryData country = new CountryData();
		country.setId(rs.getInt("country_id"));
		
		airline.setAirlineCountry(country);
		
		return airline;
	}

}
