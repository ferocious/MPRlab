package db.app.repositories.impl;

import java.sql.Connection;
import java.sql.SQLException;

import db.app.domain.CountryData;
import db.app.repositories.ICountryDataRepository;
import db.app.repositories.impl.builder.CountryDataBuilder;
import db.app.unitofwork.IUnitOfWork;

public class CountryRepository extends Repository<CountryData> implements ICountryDataRepository {
	
	private static String insertSql = "INSERT INTO country(id, code, name) VALUES(?,?,?)";
	
	private static String updateSql = "UPDATE country SET code = ?, name = ? WHERE id = ?";
	
	public CountryRepository(Connection connection, IUnitOfWork uow) {
		super(connection, new CountryDataBuilder(), uow);
	}
	
	@Override
	protected void setUpUpdateQuery(CountryData entity) throws SQLException {
		update.setString(1, entity.getCode());
		update.setString(2, entity.getName());
		update.setInt(3, entity.getId());
	}

	@Override
	protected void setUpInsertQuery(CountryData entity) throws SQLException {
		insert.setInt(1, entity.getId());
		insert.setString(2, entity.getCode());
		insert.setString(3, entity.getName());
	}

	@Override
	protected String getTableName() {
		return "country";
	}

	@Override
	protected String getInsertQuery() {
		return insertSql;
	}

	@Override
	protected String getUpdateQuery() {
		return updateSql;
	}

}
