package step4_1;

import java.util.Scanner;

public class MovieView {
	Scanner sc = new Scanner(System.in);

	void movieShow(Movie selectMovie) {
		System.out.println("Title : " + selectMovie.title);
		System.out.println("Score : " + selectMovie.score);
		System.out.println("Synopsis : " + selectMovie.synopsis);
		System.out.println("Genre : " + selectMovie.genre);
	}

	void showMovieStartMenu() {
		System.out.println("1. Watch");
		System.out.println("2. Add Favorite");
		System.out.println("3. Exit");
	}

	void showMovieEndMenu() {
		System.out.println("1. Rating");
		System.out.println("2. Next Movie");
		System.out.println("3. Exit");
	}

	// UserManager.getInstance().searchIsOnline().pf.saved
	// MovieManager.getInstance().search(tmpMovie2)

	void movieStart(int selectNumber) {
		movieShow(MovieManager.getInstance().movieStorage.get(selectNumber));
		showMovieStartMenu();
		int choice = Integer.parseInt(sc.nextLine());
		switch (choice) {
		case 1:
			movieEnd(selectNumber);// ?��?�� ?�� ?��?�� ?�� 메뉴�?
			break;
		case 2:
			UserManager.getInstance().searchIsOnline().pf.myList
					.add(MovieManager.getInstance().movieStorage.get(selectNumber));// ?��?��
			// ?��?��
			// ?��로필?��
			// ?��?��
			// �?
			break;
		case 3:
			return;
		}
	}

	void movieEnd(int selectNumber) {
		showMovieEndMenu();
		int choice = Integer.parseInt(sc.nextLine());
		switch (choice) {
		case 1:// ?��?��?�� ?��고�??��?��?��?��
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
