package step6;

import java.util.Scanner;

public class MovieView {
	Scanner sc = new Scanner(System.in);

	void movieShow(Movie selectMovie) {
		System.out.println("? œëª? : " + selectMovie.title);
		System.out.println("ë³„ì  : " + selectMovie.score);
		System.out.println("ì¤„ê±°ë¦? : " + selectMovie.synopsis);
		System.out.println("?ƒœê·? : " + selectMovie.genre);
	}

	void showMovieStartMenu() {
		System.out.println("1. ?˜?™” ?¬?ƒ");
		System.out.println("2. ì°œí•˜ê¸?");
		System.out.println("3. ë©”ë‰´ë¡? ?Œ?•„ê°?ê¸?");
	}

	void showMovieEndMenu() {
		System.out.println("1. ë³„ì  ë§¤ê¸°ê¸?");
		System.out.println("2. ?‹¤?Œ ?˜?™”?¬?ƒ");
		System.out.println("3. ë©”ë‰´ë¡? ?Œ?•„ê°?ê¸?");
	}

	// UserManager.getInstance().searchIsOnline().pf.saved
	// MovieManager.getInstance().search(tmpMovie2)

	void movieStart(int selectNumber) {
		movieShow(MovieManager.getInstance().movieStorage.get(selectNumber));
		showMovieStartMenu();
		int choice = Integer.parseInt(sc.nextLine());
		switch (choice) {
		case 1:
			movieEnd(selectNumber);// ?¬?ƒ ?›„ ?˜?™” ? ë©”ë‰´ë¡?
			break;
		case 2:
			UserManager.getInstance().searchIsOnline().pf.myList
					.add(MovieManager.getInstance().movieStorage.get(selectNumber));// ?˜„?¬
			// ? ‘?†
			// ?”„ë¡œí•„?—
			// ?˜?™”
			// ì°?
			break;
		case 3:
			return;
		}
	}

	void movieEnd(int selectNumber) {
		showMovieEndMenu();
		int choice = Integer.parseInt(sc.nextLine());
		switch (choice) {
		case 1:// ?•˜?‚˜?”© ?“¤ê³ ì??•¼?• ?ˆ˜?„
			double userScore = Double.parseDouble(sc.nextLine());
			MovieManager.getInstance().movieStorage.get(selectNumber).setScore(userScore);
		case 2:
			movieStart(selectNumber + 1);
			break;
		case 3:
			return;
		}
	}
}
