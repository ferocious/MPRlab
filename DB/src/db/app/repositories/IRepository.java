package db.app.repositories;

import java.util.List;

import db.app.domain.Entity;

public interface IRepository<TEntity extends Entity> {

	public void save(TEntity entity);
	public void update(TEntity entity);
	public void delete(TEntity entity);
	public TEntity get(int id);
	public List<TEntity> getAll();
}
