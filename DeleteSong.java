/*Get song name from user and delete the song*/

package com.onebill.corejava.MusicApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteSong {

	DeleteSong(){
		
		Connection con = null;
		PreparedStatement pstmt = null;		
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/MusicPlayer?autoReconnect=true&useSSL=false", "root",
					"Onebill@2020");
			String query = "delete from MusicFiles where Song_ID=?";
			pstmt = con.prepareStatement(query);
			
			System.out.println("Enter the song id to delete :");
			int sid = sc.nextInt();
						
			pstmt.setInt(1,sid);
			
			pstmt.executeUpdate();
			System.out.println("Deletion succesful");			
			
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
