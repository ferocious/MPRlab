package db.app.repositories.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import db.app.repositories.IRepositoryCatalog;
import db.app.unitofwork.IUnitOfWork;
import db.app.unitofwork.UnitOfWork;

public class RepositoryCatalogProvider {
	
	private static String url = "jdbc:mysql://localhost/lotnisko";

	public static IRepositoryCatalog catalog() {
		try {
			Connection connection = DriverManager.getConnection(url, "root", "xxx");
			IUnitOfWork uow = new UnitOfWork(connection);
			IRepositoryCatalog catalog = new RepositoryCatalog(connection, uow);
			return catalog;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}