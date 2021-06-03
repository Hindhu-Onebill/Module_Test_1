/*Option 3 show all songs
 * To display all songs in table order by song title static query is used.
 * Hence Statement is used.*/

package com.onebill.corejava.MusicApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import net.proteanit.sql.DbUtils;

public class ShowAllSongs {
	
	ShowAllSongs(){
		
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);

		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/MusicPlayer?autoReconnect=true&useSSL=false", "root",
					"Onebill@2020");
			String query = "select * from MusicFiles order by (Song_Title)";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery(query);
			
			System.out.println("      File name               |                 Title             "
					+ " |             Artist             |         Album       |       Song_ID");
			while (rs.next()) {
				
				String filename = rs.getString("Song_Location");
				int SongID = rs.getInt("Song_ID");
				String SongTitle = rs.getString("Song_Title");
				String artist = rs.getString("Artist_Name");
				String album = rs.getString("Album_Name");
				
				System.out.println(SongTitle+   ".mp3            |   "+ SongTitle 
						+ "                       |                   " +artist+ "             |          " +album+   "          |           " +SongID);
				
		    }
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (stmt != null)
					stmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		
	}
		public static void main(String[] args) {
	
		
    }
}
