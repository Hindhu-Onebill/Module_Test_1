//To add a new song into the playlist

package com.onebill.corejava.MusicApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AddSong {
	
	AddSong(){
		
		Connection con = null;
		PreparedStatement pstmt = null;		
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/MusicPlayer?autoReconnect=true&useSSL=false", "root",
					"Onebill@2020");
			String query = "insert into MusicFiles values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(query);
			
			System.out.println("Enter song id :");
			int songid = sc.nextInt();
			pstmt.setInt(1,songid);
			
			System.out.println("Song name :");
			sc.nextLine();
			String song = sc.nextLine();
			pstmt.setString(2, song);
			
			System.out.println("Enter artist name :");
			String artist = sc.nextLine();
			pstmt.setString(3, artist);
			
			System.out.println("Enter album name :");
			String album = sc.nextLine();
			pstmt.setString(4, album);
			
			System.out.println("Enter file name A/B/C/D :");
			String file = sc.nextLine();
			pstmt.setString(5, file);
			
			System.out.println("Enter description :");
			String description = sc.nextLine();
			pstmt.setString(6, description);
			
			
			pstmt.executeUpdate();
			System.out.println("Insertion succesful");
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(con!=null)
					con.close();
				if(pstmt!= null)
					pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}
	
	public static void main(String[] args) {
		
	}
}
