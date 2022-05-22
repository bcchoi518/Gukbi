package fiveflix;

import java.util.Scanner;

public class Preference extends MovieSet {

	public static void main(String[] args) {
	   MovieManager mng = MovieManager.getInstance();
   
	Scanner sc = new Scanner(System.in);
	int preChoice = 0;

	//while(true) {
		GenreChoice.showGenre();
		preChoice = Integer.parseInt(GenreChoice.sc.nextLine());
		
		switch (preChoice) {
		case Genre.ROMANCE:
			mng.romance();
			break;
		case Genre.ACTION:
			break;
		case Genre.ANIME:
			break;
		case Genre.ORIGINALSERIES:
			break;

		}

	}
	
	}
//}
