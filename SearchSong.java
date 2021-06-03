/*Option 2 Search a song is implemented using the jdbc
Dynamci query since user will enter the song name so preparedStatement is used
Since select query executeQuery() method is used*/

package com.onebill.corejava.MusicApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class SearchSong {
	
	SearchSong(String songname){
		
		int flag =0 ;
		String search_Song = songname ;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/MusicPlayer?autoReconnect=true&useSSL=false", "root",
					"Onebill@2020");
			String query = "Select * from MusicFiles where Song_title =?";
			pstmt = con.prepareStatement(query);
			// binding the parameter ??
			pstmt.setString(1, search_Song);
			rs = pstmt.executeQuery();
			
			System.out.println("      File name                  |                 Title            "
					+ " |             Artist             |              Album            |             Song_ID");
			while (rs.next()) {
				
				String filename = rs.getString("Song_Location");
				int SongID = rs.getInt("Song_ID");
				String SongTitle = rs.getString("Song_Title");
				String artist = rs.getString("Artist_Name");
				String album = rs.getString("Album_Name");
				
				System.out.println(SongTitle+   ".mp3                 |   "+ SongTitle 
						+ "                       |                   " +artist+ "             |          " +album+   "          |           " +SongID);
				flag = 1;
				
		    }
			System.out.println("Enter the song_ID if you want to play.");
			int play = sc.nextInt();
			System.out.println("Playing "+search_Song);
			
			if(flag == 0) {
				System.out.println("No record found");
			}

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		}


	public static void main(String[] args) {
		
    }
}
