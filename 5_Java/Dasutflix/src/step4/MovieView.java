package step4;

import java.util.Scanner;

public class MovieView {
	Scanner sc = new Scanner(System.in);

	void movieShow(Movie selectMovie) {
		System.out.println("? λͺ? : " + selectMovie.title);
		System.out.println("λ³μ  : " + selectMovie.score);
		System.out.println("μ€κ±°λ¦? : " + selectMovie.synopsis);
		System.out.println("?κ·? : " + selectMovie.genre);
	}

	void showMovieStartMenu() {
		System.out.println("1. ?? ?¬?");
		System.out.println("2. μ°νκΈ?");
		System.out.println("3. λ©λ΄λ‘? ??κ°?κΈ?");
	}

	void showMovieEndMenu() {
		System.out.println("1. λ³μ  λ§€κΈ°κΈ?");
		System.out.println("2. ?€? ???¬?");
		System.out.println("3. λ©λ΄λ‘? ??κ°?κΈ?");
	}

	// UserManager.getInstance().searchIsOnline().pf.saved
	// MovieManager.getInstance().search(tmpMovie2)

	void movieStart(int selectNumber) {
		movieShow(MovieManager.getInstance().movieStorage.get(selectNumber));
		showMovieStartMenu();
		int choice = Integer.parseInt(sc.nextLine());
		switch (choice) {
		case 1:
			movieEnd(selectNumber);// ?¬? ? ?? ? λ©λ΄λ‘?
			break;
		case 2:
			UserManager.getInstance().searchIsOnline().pf.myList
					.add(MovieManager.getInstance().movieStorage.get(selectNumber));// ??¬
			// ? ?
			// ?λ‘ν?
			// ??
			// μ°?
			break;
		case 3:
			return;
		}
	}

	void movieEnd(int selectNumber) {
		showMovieEndMenu();
		int choice = Integer.parseInt(sc.nextLine());
		switch (choice) {
		case 1:// ???© ?€κ³ μ??Ό? ??
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
