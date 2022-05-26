package step7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class MovieUser {
	private static MovieUser mu;

	private MovieUser() {
	}

	public static MovieUser getInstance() {
		if (mu == null) {
			return mu = new MovieUser();
		}
		return mu;
	}

	void userMenu() throws InterruptedException {
		Iterator<Movie> it2 = MovieManager.getInstance().movieStorage.iterator();
		ArrayList<Movie> movieFavoriteSort = new ArrayList<Movie>();
		ArrayList<Movie> movieNotFavoriteSort = new ArrayList<Movie>();
		Movie tmp = new Movie();
		for(;it2.hasNext()==true;) {
			tmp = it2.next();
			if(UserManager.getInstance().searchIsOnline().getAge()>=tmp.filmRating) {
				if(UserManager.getInstance().searchIsOnline().pf.favorite.contains(tmp.genre)) {
					movieFavoriteSort.add(tmp);
				} else {
					movieNotFavoriteSort.add(tmp);
				}
			}
		}
		movieFavoriteSort.addAll(movieNotFavoriteSort);
		
		Iterator<Movie> it = movieFavoriteSort.iterator();
		Movie tmpMovie = new Movie();
		if(it.hasNext()) {
			tmpMovie = it.next();
		} else {
			tmpMovie = null;
		}
		int number = 0;
		System.out.println();
		System.out.println("       ▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄ M O V I E L I S T ▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀");
		System.out.println("    ┌──────────────────┬──────────────────┬──────────────────┬──────────────────┬──────────────────┐");
		for (int j = 0; j < 3; j++) {
			ArrayList<Movie> tmpMovieArray = new ArrayList<Movie>();
			
			System.out.print("    ");
			for (int i = 0; i < 5; i++) {
				number++;
				tmpMovieArray.add(tmpMovie);
				System.out.print("│");
				System.out.print("   ");
				String tmpTitle = "";	
				if(tmpMovieArray.get(i) != null) {
					tmpTitle = String.format("%-15s", number + ". "+tmpMovieArray.get(i).title);
					if(tmpMovieArray.get(i).title.length()<13) {
						System.out.print(tmpTitle);
					} else if(tmpTitle.length()>=13){
						System.out.print(tmpTitle.substring(0, 12));
						System.out.print("...");
					}
				} else {
					tmpTitle = String.format("%-15s", number + ". "+tmpTitle);
					System.out.print(tmpTitle);
				}
				
				if(it.hasNext()) {
					tmpMovie = it.next();
				} else {
					tmpMovie = null;
				}
			}
			System.out.print("│");
			System.out.println("");
			//줄 경계
			System.out.print("    ");
			for (int i = 0; i < 5; i++) {
				System.out.print("│");
				System.out.print("   ");
				String tmpScore = "";
				if(tmpMovieArray.get(i) != null) {
					tmpScore = String.format("%-15s", "Score "+tmpMovieArray.get(i).score);
				} else {
					tmpScore = String.format("%-15s", tmpScore);
				}
				System.out.print(tmpScore);
			}
			System.out.print("│");
			System.out.println("");
			//줄 경계
			System.out.print("    ");
			for (int i = 0; i < 5; i++) {
				System.out.print("│");
				//System.out.print("�봻");
				//System.out.print(" ");
				System.out.print("   ");
				String tmpGenre = "";
				if(tmpMovieArray.get(i) != null) {
					tmpGenre = String.format("%-15s", tmpMovieArray.get(i).genre);
				} else {
					tmpGenre = String.format("%-15s", tmpGenre);
				}
				System.out.print(tmpGenre);
			}
			System.out.print("│");
			System.out.println("");

			if (j >= 0 && j <= 1) { 
				System.out.print("    ");
				for (int i = 0; i < 6; i++) {
					if (i == 0) {
						System.out.print("├");
					}
					if (i == 5) {
						System.out.print("┤");
					}
					if (i >= 0 && i <= 4) {
						System.out.print("──────────────────");
					}
					if (i >= 0 && i <= 3) {
						System.out.print("┼");
					}
				}
				System.out.println("");
			}

		}
		System.out.println("    └──────────────────┴──────────────────┴──────────────────┴──────────────────┴──────────────────┘");
		System.out.println();
		System.out.println("       ▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄ F A V O R I T E S ▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀");
		System.out.println("    ┌──────────────────┬──────────────────┬──────────────────┬──────────────────┬──────────────────┐");
		System.out.print("    ");
		for (int i = 0; i < 5; i++) {
			
			number++;
			
			String tmpMovieTitle = null;
			if (UserManager.getInstance().searchIsOnline().pf.myList.size()>0){
				tmpMovieTitle = UserManager.getInstance().searchIsOnline().pf.myList.get(i).title;
			}
			System.out.print("│");
			System.out.print("   ");		
			String tmpTitle = "";
			if(tmpMovieTitle != null) {
				tmpTitle = String.format("%-15s", number + ". "+tmpMovieTitle);
				if(tmpMovieTitle.length()<13) {
					System.out.print(tmpTitle);
				} else if(tmpTitle.length()>=13){
					System.out.print(tmpTitle.substring(0, 10));
					System.out.print("...");
				}
			} else {
				tmpTitle = String.format("%-15s", number + ". "+tmpTitle);
				System.out.print(tmpTitle);
			}
			
		}
		System.out.print("│");
		System.out.println("");
		//줄 경계
		System.out.print("    ");
		for (int i = 0; i < 5; i++) {
			System.out.print("│");
			System.out.print("   ");
			Movie tmpMovieMyList = null;
			if (UserManager.getInstance().searchIsOnline().pf.myList.size()>0){
				tmpMovieMyList = UserManager.getInstance().searchIsOnline().pf.myList.get(i);
			}
			
			String tmpScore = "";
			if(tmpMovieMyList != null) {
				tmpScore = String.format("%-15s", tmpMovieMyList.getStarScore() + tmpMovieMyList.score);
			} else {
				tmpScore = String.format("%-15s", tmpScore);
			}
			System.out.print(tmpScore);
		}
		System.out.print("│");
		//System.out.print("�봻");
		System.out.println("");

		System.out.print("    ");
		for (int i = 0; i < 5; i++) {
			String tmpMovieGenre = null;
			if (UserManager.getInstance().searchIsOnline().pf.myList.size()>0){
				tmpMovieGenre = UserManager.getInstance().searchIsOnline().pf.myList.get(i).genre;
			}
			System.out.print("│");
			System.out.print("   ");
			String tmpGenre = "";
			if(tmpMovieGenre != null) {
				tmpGenre = String.format("%-15s", tmpMovieGenre);
			} else {
				tmpGenre = String.format("%-15s", tmpGenre);
			}
			System.out.print(tmpGenre);
		}
		System.out.print("│");
		//System.out.print("�봻");
		System.out.println("");

		System.out.println("    └──────────────────┴──────────────────┴──────────────────┴──────────────────┴──────────────────┘");
		System.out.println("");
		System.out.println("    ──────────────────────────── 0> Exit ");
		System.out.print("    ──────────────────────────── ◇  Choice> ");
		MovieView mv = new MovieView();
		int selectNumber = Integer.parseInt(MenuViewer.sc.nextLine());
		if (selectNumber >= 1 && selectNumber <= 20) {
			mv.movieStart(selectNumber - 1);
		} else if (selectNumber == 0) {
			return;
		}
	}
}
