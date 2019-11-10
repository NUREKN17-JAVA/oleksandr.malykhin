package UM.malykhin.nure.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactoryImpl implements ConnectionFactory {
	
	private String driver;
	private String url;
	private String user;
	private String pasword;
	
	public ConnectionFactoryImpl(String driver, String url, String user, String password) {
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.pasword = pasword;
	}

	@Override
	public Connection createConnection() throws DatabaseException {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		try {
			return DriverManager.getConnection(url, user, pasword);
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
	}

}
