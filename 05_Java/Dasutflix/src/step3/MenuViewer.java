package step3;

import java.util.Scanner;

public class MenuViewer {
	static Scanner sc = new Scanner(System.in);
	static String[] genreArr = { "Thriller", "Horror", "Comedy", "Drama", "SF", "Action", "Romance", "Animation",
			"Fantasy" };

	static void showLogIn() throws InterruptedException {
		Screen.netflixLogo1();
		System.out.println();
		System.out.println("　　　"
				+ "┌ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ┐");
		System.out.print("\t\t\tSignIn(1)");
		System.out.print("\t\tSignUp(2)");
		System.out.println("\t\tExit(3)");
		System.out.println("　　　"
				+ "└ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ┘");
		System.out.println();
		System.out.print("Choice> ");
	}// end showLogIn

	static void showMainMenu(User user) throws NotExistException, InterruptedException {
		if (user instanceof Admin) {
			showAdminMenu();
			return;
		} // end if
		showUserMenu(user);
	}// end showMainMenu

	static void showUserMenu(User user) throws NotExistException, InterruptedException {
		Screen.netflixLogo1();
		System.out.println("        \t\t\t\t*_Hello Fiveflix world_*");
		System.out.println();
		System.out.println("　　　"
				+ "┌ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ┐");
		System.out.print("\t\t   LogOut(0)");
		System.out.print("\t  Profile(1)");
//		System.out.println("├───────────────────────────────────────────────────────────────────┤");
		System.out.print("\t  Contents(2)  ");
		System.out.println("\t  Configuration(3)");
		System.out.println("　　　"
				+ "└ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ┘");
		System.out.println();
		System.out.print(user.pf.getNickname() + "> ");
	}// end showUserMenu

	static void showProfileMenu(User user) throws NotExistException {
		System.out.println();
		System.out.println("0. Exit");
		System.out.println("1. Change Profile");
		System.out.println("2. Create Profile");
		System.out.println("3. Modify Profile");
		System.out.println("4. Delete Profile");
		System.out.print(user.pf.getNickname() + "> ");
	}// end showProfileMenu

	static void showSettingsMenu(User user) {
		System.out.println();
		System.out.println("0. Exit");
		System.out.println("1. Settings check");
		System.out.println("2. Country setting");
		System.out.println("3. Caption setting");
		System.out.println("4. Image quality settings");
		System.out.print(user.pf.getNickname() + "> ");
	}// end showSettingsMenu

	static void showAdminMenu() throws InterruptedException {
		Screen.netflixLogo1();
		System.out.println("        \t\t\t\t*_Hello Fiveflix world_*");
		System.out.println();
		System.out.println("　　　"
				+ "┌ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ┐");
		System.out.print("\tLogOut(0)");
		System.out.print("\tUserManagement(1)");
//		System.out.println("├───────────────────────────────────────────────────────────────────┤");
		System.out.print("\tContentsManagement(2) ");
		System.out.println("\t  ChangePassword(3)");
		System.out.println("　　　"
				+ "└ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ┘");
		System.out.println();
		System.out.print("admin> ");
	}// end showAdminMenu

	static void showUserManagementMenu() {
		System.out.println();
		System.out.println("0. Exit");
		System.out.println("1. Membership inquiry");
		System.out.println("2. Search for membership");
		System.out.println("3. Membership modification");
		System.out.println("4. Delete membership");
		System.out.print("admin> ");
	}// end showUserManagementMenu

	static void showMovieInfo(User user) {
		System.out.println();
		System.out.println("0. Exit");
		System.out.println("1. Synopsis");
		System.out.println("2. Movie Rating");
		System.out.println("3. Watching movies");
		System.out.print(user.pf.getNickname() + "> ");
	}// end showMovieInfo

	static void showMovieManagementMenu() {
		System.out.println();
		System.out.println("0. Exit");
		System.out.println("1. Movie registration");
		System.out.println("2. Movie search");
		System.out.println("3. Movie Correction");
		System.out.println("4. Delete a movie");
		System.out.println("5. Movie inquiry");
		System.out.println("6. Save Data");
		System.out.println("7. Load Data"); // 프로그램 시작 부분에 필요함
		System.out.print("admin> ");
	}// end showMovieManagementMenu

	static void showGenre() {
		for (int i = 0; i < genreArr.length; i++) {
			if (i > 0 && i % 3 == 0) {
				System.out.println();
			} // end if
			System.out.printf("%d.%-10s ", i + 1, genreArr[i]);
		} // end for
		System.out.println();
	}// end showGenre
}// end MenuViewer
