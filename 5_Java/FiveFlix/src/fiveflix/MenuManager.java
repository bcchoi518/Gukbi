package fiveflix;

import java.util.HashSet;
import java.util.Iterator;

public class MenuManager extends MovieSet {
	private static MenuManager mm;

	public static MenuManager getInstance() {
		if (mm == null)
			mm = new MenuManager();
		return mm;
	}

	void FiveFlix() {
		System.out.println("===========Welcome===========");
		System.out.println("1.  W  A  T  C  H");
		System.out.println("2.  M  Y  I  N  F  O");
		System.out.println("3.  S  E  A  R  C  H");
		System.out.println("4.  R  E  C  O  M  M  E  N  D");
		System.out.println("5.  F  A  V  O  R  I  T  E");
		System.out.println("6.  S  E  T  T  I  N  G  S");
		System.out.println("7.  L  O  G  O  U  T");
		System.out.println("=============================");
		System.out.println("Choose Anything U Want=> ");
		int choice = Integer.parseInt(FiveFlix.sc.nextLine());
		switch (choice) {
		case MenuChoice.WATCH:
			break;
		case MenuChoice.MYINFO:
			break;
		case MenuChoice.SEARCH:
			break;
		case MenuChoice.RECOMMEND:
			mm.showRecommend();
		case MenuChoice.FAVORITE:
			mm.favorite();
			break;
		case MenuChoice.SETTING:
			break;
		case MenuChoice.LOGOUT:
			System.out.println("LogOut FiveFlix? (Y/N)");
			// String choice = FiveFlix.sc.nextLine();
			// if(choice=="Y") {
			System.out.println("See you!");
			break;
		}

	}

	void watch() {
	}

	void rate() {
	}

	void addFavorite() {
	}

	void myInfo() {
	}

	void search() {
	}

	void showRecommend() {
		System.out.println("==Plz Choose Your Favorite Genre==");
		System.out.println("=1. R O M A N C E=");
		System.out.println("=2. A C T I O N=");
		System.out.println("=3. A N I M E=");
		System.out.println("=4. 5 F L I X O R I G I N A L");
		System.out.println("==Your Choice:");
		int choice = Integer.parseInt(GenreChoice.sc.nextLine());
		// System.out.println("Your Choice is"+G+"!");
		switch (choice) {
		case Genre.ROMANCE:
			Romance();
			System.out.println(romanceSet.toString());
			break;
		case Genre.ACTION:
			Action();
			System.out.println(actionSet.toString());
			break;
		case Genre.ANIME:
			Anime();
			System.out.println(animeSet.toString());
			break;
		case Genre.ORIGINALSERIES:
			Original();
			System.out.println(originalSet.toString());
			break;
		}
		mm.FiveFlix();

	}

	void favorite() {
		AllMovie();
		HashSet<Movies> favoriteSet = new HashSet<Movies>();
		//while (true) {
			System.out.println("Enter the name of the movie you want to include in your Favorites list.");
			String movieName = FiveFlix.sc.nextLine();
			Iterator<Movies> it = allMovieSet.iterator();
			while (it.hasNext()) {
				Movies tmp = (Movies) it.next();
				if (allMovieSet.contains(movieName)) {
					favoriteSet.add(tmp);
					if (favoriteSet.add(tmp)) {
						System.out.println("Complete!");
					}
				} else {
					System.out.println("Oops Plz Check the title again");
					mm.FiveFlix();
				}
			}
			//mm.FiveFlix();
		//}

	}

	void setting() {
	}

	void logOut() {
	}

}
