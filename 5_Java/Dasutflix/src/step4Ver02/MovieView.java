package step4Ver02;

import java.util.Scanner;

public class MovieView {
	Scanner sc = new Scanner(System.in);

	void movieShow(Movie selectMovie) {
		System.out.println("?���? : " + selectMovie.title);
		System.out.println("별점 : " + selectMovie.score);
		System.out.println("줄거�? : " + selectMovie.synopsis);
		System.out.println("?���? : " + selectMovie.genre);
	}

	void showMovieStartMenu() {
		System.out.println("1. ?��?�� ?��?��");
		System.out.println("2. 찜하�?");
		System.out.println("3. 메뉴�? ?��?���?�?");
	}

	void showMovieEndMenu() {
		System.out.println("1. 별점 매기�?");
		System.out.println("2. ?��?�� ?��?��?��?��");
		System.out.println("3. 메뉴�? ?��?���?�?");
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
