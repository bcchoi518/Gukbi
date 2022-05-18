package step1;

public class Dasutflix01 {
	public static void main(String[] args) {
		UserManager um = UserManager.getInstance();

		MenuViewer.showLogIn();
		int choice = Integer.parseInt(MenuViewer.sc.nextLine());
		switch (choice) {
		case 1:
			um.signIn();
			break;
		}

		um.showProfile();

		mm.showMovies();

		MenuViewer.showUserMenu();

	}// end main
}// end Test
