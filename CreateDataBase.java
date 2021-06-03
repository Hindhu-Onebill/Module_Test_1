/*created a database using JDBC*/

package com.onebill.corejava.MusicApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDataBase {
	static final String DB_URL = "jdbc:mysql://localhost/";
	static final String USER = "root";
	static final String PASS = "Onebill@2020";

	public static void main(String[] args) {
		// Open a connection
		try {DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement(); 
			String sql = "CREATE DATABASE MusicPlayer";
			stmt.executeUpdate(sql);
			System.out.println("Database created successfully...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}