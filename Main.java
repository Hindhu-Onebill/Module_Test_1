package com.onebill.corejava.MusicApp;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int choice1; // User input for action to be taken like play,search,show all songs..
		int choice2; // user input for playing a song
		int choice3; // user input to edit the playlist
		String songName;

		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to SoundCheck.!");
		System.out.println();
		while (true) {
			System.out.println("1.Play a song. \n2.Search a song. \n3.Show all Songs. \n4.Edit the playlist.");
			System.out.println();

			System.out.println("What can we do now? Your choice!");
			choice1 = sc.nextInt();

			// switch case
			switch (choice1) {
			case 1: // Play a song
				System.out.println("1.Play all songs \n2.Play songs randomly \n3.Play a particular song");
				System.out.println("Enter your option!");
				choice2 = sc.nextInt();
				
				switch(choice2) {
				case 1:
					System.out.println("Playing all songs in the list");
					
					try {
						PlayAll one = new PlayAll();
						Thread tone = new Thread(one);
						tone.start();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 2:
					System.out.println("Playing Random Song");
					PlayRandomSong two;
					try {
						two = new PlayRandomSong();
						Thread ttwo = new Thread(two);
						ttwo.start();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 3:
					System.out.println("Enter the song to play");
					//already search song available so using the same
					sc.nextLine();
					songName = sc.nextLine();
					System.out.println("Playing "+songName+ ".mp3");
					SearchSong obj = new SearchSong(songName);
					break;
				}
				
				
				break;
			case 2:
				System.out.println("Enter the song to search.");
				sc.nextLine();
				songName = sc.nextLine();
				//obj for class containing jdbc code to search in db
				SearchSong obj = new SearchSong(songName);
				break;
			case 3:
				System.out.println("Showing all songs!");
				System.out.println();
				// jdbc show the song tables
				ShowAllSongs object = new ShowAllSongs();
				break;
			case 4:
				System.out.println("Editing playlist.");
				System.out.println("1.Add a song \n2.Change song \n3.Delete a song ");
				System.out.println("Enter your option!");
				choice3 = sc.nextInt();
				// switch jdbc
				switch(choice3) {
				case 1:
					System.out.println("Adding new song to play list ");
					AddSong object2 = new AddSong();
					break;
				case 2:
					System.out.println("Edit the song.");
					UpdateSong object4 = new UpdateSong();
					break;
				case 3:
					System.out.println("Delete song!");
					DeleteSong object3 = new DeleteSong();
					break;
				}
				break;

			}

		}

	}

}
