package com.sorhovigarat.videogame.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.postgresql.Driver;

public class DBConnection {
	public static Connection getConnection() throws SQLException {

		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "project0";
				
		Connection connection = null;
		
		DriverManager.registerDriver(new Driver());
		connection = DriverManager.getConnection(url, username, password);
		
		return connection;
	}
}
