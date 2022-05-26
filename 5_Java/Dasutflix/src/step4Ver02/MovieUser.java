package step4Ver02;

import java.util.ArrayList;
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
		Iterator<Movie> it = MovieManager.getInstance().movieStorage.iterator();
		Movie tmpMovie = new Movie();
		if(it.hasNext()) {
			tmpMovie = it.next();
		} else {
			tmpMovie = null;
		}
		int number = 0;
		System.out.println("~~~영화목록~~~");
		System.out.println("┌───────────────┬───────────────┬───────────────┬───────────────┬───────────────┐");
		for (int j = 0; j < 3; j++) {
			ArrayList<Movie> tmpMovieArray = new ArrayList<Movie>();//j루프문 안에서 하나의 열 데이터 유지
			for (int i = 0; i < 5; i++) {
				number++;
				tmpMovieArray.add(tmpMovie);
				System.out.print("│");
				System.out.print(" ");
				System.out.print(number + ". ");
				/*
				if (tmpMovieArray[i].title != null&&tmpMovieArray[i].title.length() < 7) {
					System.out.print((tmpMovieArray[i].title == null) ? "\t" : tmpMovieArray[i].title);
				} else {
					System.out.print(
							(tmpMovieArray[i].title == null) ? "\t" : tmpMovieArray[i].title.substring(0, 6));
					System.out.print("...");
				}
				*/
				if(tmpMovieArray.get(i) == null) { //제목 입력
					System.out.print("");
				} else if (tmpMovieArray.get(i).title.length() < 7) {
					System.out.print(tmpMovieArray.get(i).title);
				} else {
					System.out.print(tmpMovieArray.get(i).title.substring(0, 6)+"...");
				}
				
				if (tmpMovieArray.get(i) == null||tmpMovieArray.get(i).title.length() < 3) {
					System.out.print("\t\t");
				} else {
					System.out.print("\t");
				}
				
				if(it.hasNext()) { //데이터가 없으면 데이터 안받아옴
					tmpMovie = it.next();
				} else {
					tmpMovie = null;
				}
			}
			System.out.print("│");
			System.out.println("");
			
			for (int i = 0; i < 5; i++) { //별점 입력
				System.out.print("│");
				System.out.print(" ");
				if(tmpMovieArray.get(i) != null) {
					System.out.print(tmpMovieArray.get(i).getStarScore() + " " + tmpMovieArray.get(i).score);
					if (tmpMovieArray.get(i).getScore() <= 1) {
						System.out.print("\t\t");
					} else {
						System.out.print("\t");
					}
				}else {
					System.out.print("\t\t");
				}
			}
			System.out.print("│");
			System.out.println("");

			for (int i = 0; i < 5; i++) { //장르 입력
				/*
				System.out.print("�봻");
				System.out.print(" ");
				if(tmpMovieArray[i].genre!=null) {
					System.out.print("#" + tmpMovieArray[i].genre);
				}
				if (tmpMovieArray[i].genre.length() <= 3) {
					System.out.print("\t\t");
				} else {
					System.out.print("\t");
				}
				*/
				
				System.out.print("│");
				System.out.print(" ");
				if(tmpMovieArray.get(i)==null) {
					System.out.print("\t\t");
				} else if (tmpMovieArray.get(i).genre.length() <= 3) {
					System.out.print("#" + tmpMovieArray.get(i).genre);
					System.out.print("\t\t");
				} else {
					System.out.print("#" + tmpMovieArray.get(i).genre);
					System.out.print("\t");
				}
			}
			System.out.print("│");
			System.out.println("");

			if (j >= 0 && j <= 1) { //칸 사이 세로줄 입력
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

		System.out.println("┌───────────────┬───────────────┬───────────────┬───────────────┬───────────────┐");
		for (int i = 0; i < 5; i++) {
			String tmpMovieTitle = null;
			if (UserManager.getInstance().searchIsOnline().pf.myList.size()>0){
				tmpMovieTitle = UserManager.getInstance().searchIsOnline().pf.myList.get(i).title;
			}
			
			number++;
			System.out.print("│");
			System.out.print(" ");
			System.out.print(number + ". ");
			
			if(tmpMovieTitle == null) { //제목 입력
				System.out.print("");
			} else if (tmpMovieTitle.length() < 7) {
				System.out.print(tmpMovieTitle);
			} else {
				System.out.print(tmpMovieTitle.substring(0, 6)+"...");
			}
			
			if (tmpMovieTitle == null||tmpMovieTitle.length() < 3) {
				System.out.print("\t\t");
			} else {
				System.out.print("\t");
			}
			
			/*
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
			*/
		}
		System.out.print("│");
		System.out.println("");
		
		for (int i = 0; i < 5; i++) { //별점 입력
			Movie tmpMovie2 = null;
			if (UserManager.getInstance().searchIsOnline().pf.myList.size()>0){
				tmpMovie2 = UserManager.getInstance().searchIsOnline().pf.myList.get(i);
			}
			
			System.out.print("│");
			System.out.print(" ");
			if(tmpMovie2!=null) {
				System.out.print(tmpMovie2.getStarScore() + " " + tmpMovie2.score);
				if (tmpMovie2.getScore() <= 1) {
					System.out.print("\t\t");
				} else {
					System.out.print("\t");
				}
			} else {
				System.out.print("\t\t");
			}
		}
		/*
		for (int i = 0; i < 5; i++) {
			System.out.print("�봻");
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
		*/
		
		System.out.print("│");
		System.out.println("");

		for (int i = 0; i < 5; i++) { // 장르 입력
			String tmpMovieGenre = null;
			if (UserManager.getInstance().searchIsOnline().pf.myList.size()>0){
				tmpMovieGenre = UserManager.getInstance().searchIsOnline().pf.myList.get(i).genre;
			}
			
			System.out.print("│");
			System.out.print(" ");
			if(tmpMovieGenre==null) {
				System.out.print("\t\t");
			} else if (tmpMovieGenre.length() <= 3) {
				System.out.print("#" + tmpMovieGenre);
				System.out.print("\t\t");
			} else {
				System.out.print("#" + tmpMovieGenre);
				System.out.print("\t");
			}
			/*
			System.out.print("�봻");
			System.out.print(" ");
			if (tmpMovieGenre != null) {
				System.out.print("#" + tmpMovieGenre);
			}
			if (tmpMovieGenre != null && tmpMovieGenre.length() <= 3|| tmpMovieGenre == null) {
				System.out.print("\t\t");
			} else {
				System.out.print("\t");
			}
			*/
		}
		System.out.print("│");
		System.out.println("");

		System.out.println("└───────────────┴───────────────┴───────────────┴───────────────┴───────────────┘");
		/*
		 * for(int i=0;i<5;i++) { //李쒕ぉ濡� �떒�닚�샇異�(�뀒�몢由� �뾾�쓬) number++;
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
		if (selectNumber >= 1 && selectNumber <= 20) {// �빐�떦踰덊샇 臾대퉬 媛��졇�삤湲�
			mv.movieStart(selectNumber - 1);
		} else if (selectNumber == 0) {
			
		}
	}
}
