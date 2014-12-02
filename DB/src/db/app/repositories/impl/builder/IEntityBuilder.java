package db.app.repositories.impl.builder;

import java.sql.ResultSet;
import java.sql.SQLException;

import db.app.domain.Entity;

public interface IEntityBuilder<TEntity extends Entity> {

	public TEntity build(ResultSet rs) throws SQLException;
}
