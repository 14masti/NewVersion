package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		String url = "jdbc:postgresql://192.168.110.48:5432/plf_training";
		String username = "plf_training_admin";
		String password = "pff123";
		Class.forName("org.postgresql.Driver");
		return DriverManager.getConnection(url, username, password);
	}

}
