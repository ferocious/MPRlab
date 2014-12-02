package db.app.repositories.impl.builder;

import java.sql.ResultSet;
import java.sql.SQLException;

import db.app.domain.CountryData;

public class CountryDataBuilder implements IEntityBuilder<CountryData> {

	@Override
	public CountryData build(ResultSet rs) throws SQLException {
		CountryData country = new CountryData();
		
		country.setId(rs.getInt("id"));
		country.setCode(rs.getString("code"));
		country.setName(rs.getString("name"));
		
		return country;
	}
}
