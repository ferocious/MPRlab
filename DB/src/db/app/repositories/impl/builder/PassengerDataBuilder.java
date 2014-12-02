package db.app.repositories.impl.builder;

import java.sql.ResultSet;
import java.sql.SQLException;

import db.app.domain.CountryData;
import db.app.domain.PassengerData;

public class PassengerDataBuilder implements IEntityBuilder<PassengerData> {

	@Override
	public PassengerData build(ResultSet rs) throws SQLException {
		PassengerData passenger = new PassengerData();
		
		passenger.setId(rs.getInt("id"));
		passenger.setFirstName(rs.getString("first_name"));
		passenger.setLastName(rs.getString("last_name"));
		passenger.setIdType(rs.getString("id_type"));
		passenger.setIdNo(rs.getString("id_no"));
		
		CountryData country = new CountryData();
		country.setId(rs.getInt("country_id"));
		
		passenger.setCountry(country);
		
		return passenger;
	}
}
