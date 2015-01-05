package db.app.unitofwork;

import db.app.domain.Entity;

public interface IUnitOfWork {

	void commit();
	
	void rollback();
	
	void markAsNew(Entity entity, IUnitOfWorkRepository repository);
	
	void markAsDirty(Entity entity, IUnitOfWorkRepository repository);
	
	void markAsDelete(Entity entity, IUnitOfWorkRepository repository);
}
