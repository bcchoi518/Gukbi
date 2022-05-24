package step3;

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

	void userMenu() {
		while (true) {
			Iterator<Movie> it = MovieManager.getInstance().movieStorage.iterator();
			Movie tmpMovie = it.next();
			int number = 0;
			System.out.println("~~~영화목록~~~");
			System.out.println("┌───────────────┬───────────────┬───────────────┬───────────────┬───────────────┐");
			for (int j = 0; j < 3; j++) {
				Movie[] tmpMovieArray = new Movie[5];
				for (int i = 0; i < 5; i++) {
					number++;
					tmpMovieArray[i] = tmpMovie;
					System.out.print("│");
					System.out.print(" ");
					System.out.print(number + ". ");
					if (tmpMovie.title.length() < 7) {
						System.out.print((tmpMovieArray[i].title == null) ? "\t" : tmpMovieArray[i].title);
					} else {
						System.out.print(
								(tmpMovieArray[i].title == null) ? "\t" : tmpMovieArray[i].title.substring(0, 6));
						System.out.print("...");
					}
					if (tmpMovieArray[i].title.length() < 3) {
						System.out.print("\t\t");
					} else {
						System.out.print("\t");
					}
					tmpMovie = it.next();
				}
				System.out.print("│");
				System.out.println("");
				for (int i = 0; i < 5; i++) {
					System.out.print("│");
					System.out.print(" ");
					System.out.print(tmpMovieArray[i].getStarScore() + " " + tmpMovieArray[i].score);
					if (tmpMovieArray[i].getScore() <= 1) {
						System.out.print("\t\t");
					} else {
						System.out.print("\t");
					}
				}
				System.out.print("│");
				System.out.println("");

				for (int i = 0; i < 5; i++) {
					System.out.print("│");
					System.out.print(" ");
					System.out.print("#" + tmpMovieArray[i].genre);
					if (tmpMovieArray[i].genre.length() <= 3) {
						System.out.print("\t\t");
					} else {
						System.out.print("\t");
					}
				}
				System.out.print("│");
				System.out.println("");

				if (j >= 0 && j <= 1) {
					for (int i = 0; i < 6; i++) {
						if (i == 0) {
							System.out.print("├");
						}
						if (i == 5) {
							System.out.print("┤");
						}
						if (i >= 0 && i <= 4) {
							System.out.print("───────────────");
						}
						if (i >= 0 && i <= 3) {
							System.out.print("┼");
						}
					}
					System.out.println("");
				}

			}
			System.out.println("└───────────────┴───────────────┴───────────────┴───────────────┴───────────────┘");

			// UserManager.getInstance().searchIsOnline().pf.saved
			// tmpMovie2
			// MovieManager.getInstance().search(tmpMovie2)

			System.out.println("~~~찜목록~~~");

			Iterator<Movie> it2 = UserManager.getInstance().searchIsOnline().pf.myList.iterator();
			Movie tmpMovie2 = it2.next();

			System.out.println("┌───────────────┬───────────────┬───────────────┬───────────────┬───────────────┐");
			for (int i = 0; i < 5; i++) {
				number++;
				System.out.print("│");
				System.out.print(" ");
				System.out.print(number + ". ");
				if (tmpMovie2 != null && tmpMovie2.getTitle().length() < 7) {
					System.out.print(tmpMovie2);
				} else {
					System.out.print((tmpMovie2 == null) ? "\t" : tmpMovie2.getTitle().substring(0, 6) + "...");
				}
				if (tmpMovie2 != null && tmpMovie2.getTitle().length() < 3) {
					System.out.print("\t\t");
				} else {
					System.out.print("\t");
				}
			}
			System.out.print("│");
			System.out.println("");
			for (int i = 0; i < 5; i++) {
				System.out.print("│");
				System.out.print(" ");
				if (tmpMovie2 != null) {
					System.out.print(MovieManager.getInstance().search(tmpMovie2.getTitle()).getStarScore() + " "
							+ MovieManager.getInstance().search(tmpMovie2.getTitle()).score);
					if (MovieManager.getInstance().search(tmpMovie2.getTitle()).getScore() <= 1) {
						System.out.print("\t\t");
					} else {
						System.out.print("\t");
					}
				} else {
					System.out.print("\t\t");
				}

			}
			System.out.print("│");
			System.out.println("");

			for (int i = 0; i < 5; i++) {
				System.out.print("│");
				System.out.print(" ");
				if (tmpMovie2 != null) {
					System.out.print("#" + MovieManager.getInstance().search(tmpMovie2.getTitle()).genre);
				}
				if (tmpMovie2 != null && MovieManager.getInstance().search(tmpMovie2.getTitle()).genre.length() <= 3
						|| tmpMovie2 == null) {
					System.out.print("\t\t");
				} else {
					System.out.print("\t");
				}
			}
			System.out.print("│");
			System.out.println("");

			System.out.println("└───────────────┴───────────────┴───────────────┴───────────────┴───────────────┘");
			/*
			 * for(int i=0;i<5;i++) { //찜목록 단순호출(테두리 없음) number++;
			 * if(SelectProfile.logProfile.myList!=null
			 * &&SelectProfile.logProfile.myList.get(i).title.length()<7) {
			 * System.out.print(number+". ");
			 * System.out.print(SelectProfile.logProfile.myList.get(i).title); } else {
			 * System.out.print((SelectProfile.logProfile.myList==null)?"\t":SelectProfile.
			 * logProfile.myList.get(i).title.substring(0, 6)+"..."); }
			 * System.out.print("\t"); }
			 */
			System.out.println("");
			System.out.println("(종료 : 0)");
			System.out.println("번호 입력 : ");
			MovieView mv = new MovieView();
			int selectNumber = Integer.parseInt(MenuViewer.sc.nextLine());
			if (selectNumber >= 0 && selectNumber <= 20) {// 해당번호 무비 가져오기
				mv.movieStart(selectNumber - 1);
			} else if (selectNumber == 0) {
				return;
			}
		}
	}
}
