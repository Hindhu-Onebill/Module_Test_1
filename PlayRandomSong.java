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


public class PlayRandomSong implements Runnable {
	
	PlayRandomSong() throws InterruptedException {
	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/MusicPlayer?autoReconnect=true&useSSL=false", "root",
					"Onebill@2020");
			String query = "Select * from MusicFiles where Song_ID =?";
			pstmt = con.prepareStatement(query);
			// binding the parameter ??
			int Song_ID = 1;
			for(Song_ID =9;Song_ID>0;Song_ID--) {
				pstmt.setInt(1, Song_ID);
			rs = pstmt.executeQuery();
			
			System.out.println("Currently Playing");
			while (rs.next()) {
				
				String filename = rs.getString("Song_Location");
				int SongID = rs.getInt("Song_ID");
				String SongTitle = rs.getString("Song_Title");
				String artist = rs.getString("Artist_Name");
				String album = rs.getString("Album_Name");
				
				System.out.println("Song :"+ SongTitle + "||Artist :" +artist+ "||Album :" +album+   "||Song_ID : " +SongID);
				
		    }
			Thread.sleep(10000);
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
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}

