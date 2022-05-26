package step7;

import java.util.Scanner;

public class MovieView {
	void movieShow(Movie selectMovie) {
		System.out.println();
		System.out.println("    ──────────────────────────── Title> " + selectMovie.title);
		System.out.println("    ──────────────────────────── Score> " + selectMovie.score);
		System.out.println("    ──────────────────────────── Synopsis> " + selectMovie.synopsis);
		System.out.println("    ──────────────────────────── Genre> " + selectMovie.genre);
	}

	void showMovieStartMenu() {
		System.out.println();
		System.out.println("    ──────────────────────────── 1> Watch ");
		System.out.println("    ──────────────────────────── 2> Add Favorites ");
		System.out.println("    ──────────────────────────── 3> Exit ");
		System.out.print("    ──────────────────────────── ◇  Choice> ");
	}

	void showMovieEndMenu() {
		System.out.println();
		System.out.println("    ──────────────────────────── 1> Rating ");
		System.out.println("    ──────────────────────────── 2> Next Movie ");
		System.out.println("    ──────────────────────────── 3> Exit ");
		System.out.print("    ──────────────────────────── ◇  Choice> ");
	}

	// UserManager.getInstance().searchIsOnline().pf.saved
	// MovieManager.getInstance().search(tmpMovie2)

	void movieStart(int selectNumber) throws InterruptedException {
		movieShow(MovieManager.getInstance().movieStorage.get(selectNumber));
		showMovieStartMenu();
		int choice = Integer.parseInt(MenuViewer.sc.nextLine());
		switch (choice) {
		case 1:
			Screen.getWatchScreen();
			movieEnd(selectNumber);
			break;
		case 2:
			UserManager.getInstance().searchIsOnline().pf.myList
					.add(MovieManager.getInstance().movieStorage.get(selectNumber));// ?��?��
			break;
		case 3:
			return;
		}
	}

	void movieEnd(int selectNumber) throws InterruptedException {
		showMovieEndMenu();
		int choice = Integer.parseInt(MenuViewer.sc.nextLine());
		switch (choice) {
		case 1:
			double userScore = Double.parseDouble(MenuViewer.sc.nextLine());
			MovieManager.getInstance().movieStorage.get(selectNumber).setScore(userScore);
		case 2:
			movieStart(selectNumber + 1);
			break;
		case 3:
			return;
		}
	}
}
