package db.app.repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.app.domain.Entity;
import db.app.repositories.IRepository;
import db.app.repositories.impl.builder.IEntityBuilder;

public abstract class Repository<TEntity extends Entity> implements IRepository<TEntity> {
	
	protected Connection connection;
	protected PreparedStatement insert;
	protected PreparedStatement selectById;
	protected PreparedStatement update;
	protected PreparedStatement selectAll;
	protected PreparedStatement delete;
	protected IEntityBuilder<TEntity> builder;
	
	protected String selectByIdSql = "SELECT * FROM " + getTableName()
			+ " WHERE id=?";
	
	protected String deleteSql = "DELETE FROM " + getTableName()
			+ " WHERE id=?";
	
	protected String selectAllSql = "SELECT * FROM " + getTableName();

	protected Repository(Connection connection, IEntityBuilder<TEntity> builder) {
		this.builder = builder;
		this.connection = connection;
		
		try {
			insert = connection.prepareStatement(getInsertQuery());
			selectById = connection.prepareStatement(selectByIdSql);
			update = connection.prepareStatement(getUpdateQuery());
			delete = connection.prepareStatement(deleteSql);
			selectAll = connection.prepareStatement(selectAllSql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(TEntity entity) {
		try {
			delete.setInt(1, entity.getId());
			delete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void save(TEntity entity) {
		try {
			setUpInsertQuery(entity);
			insert.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(TEntity entity) {
		try {
			setUpUpdateQuery(entity);
			update.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public TEntity get(int id) {
		try {
			selectById.setInt(1, id);
			ResultSet rs = selectById.executeQuery();
			while (rs.next()) {
				return builder.build(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TEntity> getAll() {
		List<TEntity> result = new ArrayList<TEntity>();
		try {
			ResultSet rs = selectAll.executeQuery();
			while (rs.next()) {
				result.add(builder.build(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	protected abstract void setUpUpdateQuery(TEntity entity) throws SQLException;

	protected abstract void setUpInsertQuery(TEntity entity) throws SQLException;

	protected abstract String getTableName();

	protected abstract String getInsertQuery();

	protected abstract String getUpdateQuery();
}