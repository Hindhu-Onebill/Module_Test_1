/*Table creation using JDBC*/

package com.onebill.corejava.MusicApp;

//table creation using jdbc

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	private static final String CREATE_TABLE_SQL = "CREATE TABLE MusicPlayer.MusicFiles (" + "Song_ID INT Primary key,"
			+ "Song_Title VARCHAR(50) ," + "Artist_Name VARCHAR(50) ," + "Album_Name VARCHAR(50) ," 
			+ "Song_Location VARCHAR(50) ," + "Description VARCHAR(50) )";
	
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost/";
		String username = "root";
		String password = "Onebill@2020";

		Connection conn = null;
		Statement stmt = null;

		try {

			conn = DriverManager.getConnection(jdbcUrl, username, password);
			stmt = conn.createStatement();

			stmt.executeUpdate(CREATE_TABLE_SQL);

			System.out.println("Table created");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// Close connection
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
