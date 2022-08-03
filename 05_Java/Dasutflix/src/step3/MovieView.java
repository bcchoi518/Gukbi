package step3;

import java.util.Scanner;

public class MovieView {
	Scanner sc = new Scanner(System.in);

	void movieShow(Movie selectMovie) {
		System.out.println("제목 : " + selectMovie.title);
		System.out.println("별점 : " + selectMovie.score);
		System.out.println("줄거리 : " + selectMovie.synopsis);
		System.out.println("태그 : " + selectMovie.genre);
	}

	void showMovieStartMenu() {
		System.out.println("1. 영화 재생");
		System.out.println("2. 찜하기");
		System.out.println("3. 메뉴로 돌아가기");
	}

	void showMovieEndMenu() {
		System.out.println("1. 별점 매기기");
		System.out.println("2. 다음 영화재생");
		System.out.println("3. 메뉴로 돌아가기");
	}

	// UserManager.getInstance().searchIsOnline().pf.saved
	// MovieManager.getInstance().search(tmpMovie2)

	void movieStart(int selectNumber) {
		movieShow(MovieManager.getInstance().movieStorage.get(selectNumber));
		showMovieStartMenu();
		int choice = Integer.parseInt(sc.nextLine());
		switch (choice) {
		case 1:
			movieEnd(selectNumber);// 재생 후 영화 끝 메뉴로
			break;
		case 2:
			UserManager.getInstance().searchIsOnline().pf.myList
					.add(MovieManager.getInstance().movieStorage.get(selectNumber));// 현재
			// 접속
			// 프로필에
			// 영화
			// 찜
			break;
		case 3:
			return;
		}
	}

	void movieEnd(int selectNumber) {
		showMovieEndMenu();
		int choice = Integer.parseInt(sc.nextLine());
		switch (choice) {
		case 1:// 하나씩 들고와야할수도
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
