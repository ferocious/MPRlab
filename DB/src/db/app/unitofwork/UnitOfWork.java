package db.app.unitofwork;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import db.app.domain.Entity;
import db.app.domain.EntityState;

public class UnitOfWork implements IUnitOfWork {
	private Connection connection;
	private Map<Entity, IUnitOfWorkRepository> entities = new LinkedHashMap<Entity, IUnitOfWorkRepository>();

	public UnitOfWork(Connection connection) {
		super();
		this.connection = connection;
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void commit() {
		for (Entity entity : entities.keySet()) {
			switch (entity.getState()) {
			case CHANGED:
				entities.get(entity).persistUpdate(entity);
				break;
			case DELETED:
				entities.get(entity).persistDelete(entity);
				break;
			case NEW:
				entities.get(entity).persistAdd(entity);
				break;
			}
		}
		try {
			connection.commit();
			entities.clear();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void rollback() {
		entities.clear();
	}

	@Override
	public void markAsNew(Entity entity, IUnitOfWorkRepository repository) {
		entity.setState(EntityState.NEW);
		entities.put(entity, repository);
	}

	@Override
	public void markAsDirty(Entity entity, IUnitOfWorkRepository repository) {
		entity.setState(EntityState.CHANGED);
		entities.put(entity, repository);
	}

	@Override
	public void markAsDelete(Entity entity, IUnitOfWorkRepository repository) {
		entity.setState(EntityState.DELETED);
		entities.put(entity, repository);
	}
}
