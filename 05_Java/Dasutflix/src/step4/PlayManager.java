package step4;

public class PlayManager {
	private static PlayManager playM;
	private UserManager userM;
	private ProfileManager profileM;
	private MovieManager movieM;
	MovieUser mu;

	private PlayManager() {
		userM = UserManager.getInstance();
		profileM = ProfileManager.getInstance();
		movieM = MovieManager.getInstance();
		userM.userStorage.add(new Admin());
		mu = MovieUser.getInstance();
	}

	public static PlayManager getInstance() {
		if (playM == null) {
			playM = new PlayManager();
		} // end if
		return playM;
	}// end getInstance

	void signUp() {
		System.out.print("Enter ID to use: ");
		String id = MenuViewer.sc.nextLine();
		System.out.print("Enter Password to use: ");
		String pw = MenuViewer.sc.nextLine();
		System.out.print("Enter your age: ");
		int age = Integer.parseInt(MenuViewer.sc.nextLine());
		User uTemp = new User(id, pw, age);
		if (!userM.userStorage.add(uTemp)) {
			System.out.println("Member that already exists");
			return;
		} // end if
		System.out.print("Enter the profile nickname to use: ");
		String nickname = MenuViewer.sc.nextLine();
		uTemp.pf = new Profile(nickname);
		System.out.println("Choose 3 genres that you prefer");
		MenuViewer.showGenre();
		for (int i = 0; i < uTemp.pf.FAVORITE_MAX; i++) {
			System.out.print(">> ");
			int tmp = Integer.parseInt(MenuViewer.sc.nextLine());
			uTemp.pf.favorite.add(MenuViewer.genreArr[tmp - 1]);
		} // end for
		uTemp.pf.setActive(true);
		if (uTemp.profileStorage.add(uTemp.pf)) {
			System.out.println("Congratulations on your membership!");
		} else {
			System.out.println("Failed to sign up for membership");
		} // end if
	}// end signUp

	User signIn() throws ChoiceException, NotExistException {
		System.out.print("ID: ");
		String id = MenuViewer.sc.nextLine();
		System.out.print("PW: ");
		String pw = MenuViewer.sc.nextLine();
		User uTemp = userM.search(id);
		if (uTemp == null) {
			throw new NotExistException();
		} // end if
		if (uTemp.getPw().equals(pw)) {
			uTemp.setOnline(true);
			System.out.println("Login successful");
			System.out.println();
			return uTemp;
		} else {
			throw new ChoiceException(pw);
		} // end if
	}// end createUser

	private void signOut() {
		User uTemp = userM.searchIsOnline();
		uTemp.setOnline(false);
	}// end signOut

	void play(User user) {
		int choice = -1;
		while (true) {
			try {
				MenuViewer.showMainMenu(user);
				choice = Integer.parseInt(MenuViewer.sc.nextLine());
				switch (choice) {
				case 0:
					signOut();
					return;
				case 1:
					profileM.profileSetting();
					break;
				case 2:
					mu.userMenu();
					Screen.getWatchScreen();
					break;
				case 3:
					configurationSetting(user);
					break;
				default:
					throw new ChoiceException(choice);
				}// end switch
			} catch (ChoiceException e) {
				e.showErrorMessage();
			} catch (NotExistException e) {
				e.showErrorMessage();
			} catch (NumberFormatException e) {
				System.err.println("[ERROR] Please enter numbers only.");
			} catch (Exception e) {
				System.err.println("[ERROR] Unknown error occurred");
				System.err.println(e);
			} // end try-catch
		} // end while
	}// end play

	void play(Admin admin) {
		int choice = 0;
		while (true) {
			try {
				MenuViewer.showMainMenu(admin);
				choice = Integer.parseInt(MenuViewer.sc.nextLine());
				switch (choice) {
				case 0:
					return;
				case 1:
					userM.userManagement();
					break;
				case 2:
					movieM.movieManagement();
					break;
				case 3:
					userM.changeAdminPassword();
					break;
				default:
					throw new ChoiceException(choice);
				}// end switch
			} catch (ChoiceException e) {
				e.showErrorMessage();
			} catch (NotExistException e) {
				e.showErrorMessage();
			} catch (NumberFormatException e) {
				System.err.println("[ERROR] Please enter numbers only.");
			} catch (Exception e) {
				System.err.println("[ERROR] Unknown error occurred");
			} // end try-catch
		} // end while
	}// end play

	private void configurationSetting(User user) {
		int choice = -1;
		while (true) {
			try {
				MenuViewer.showSettingsMenu(user);
				choice = Integer.parseInt(MenuViewer.sc.nextLine());
				switch (choice) {
				case 0:
					return;
				case 1:
					showConfiguration();
					break;
				case 2:
					selectNation();
					break;
				case 3:
					selectCaption();
					break;
				case 4:
					selectQuality();
					break;
				default:
					throw new ChoiceException(choice);
				}// end switch
			} catch (ChoiceException e) {
				e.showErrorMessage();
			} catch (NumberFormatException e) {
				System.err.println("[ERROR] Please enter numbers only.");
			} catch (Exception e) {
				System.err.println("[ERROR] Unknown error occurred");
			} // end try-catch
		} // end while
	}// end configurationSetting

	private void selectNation() {
		User uTemp = userM.searchIsOnline();
		String[] sArr = { "Korea", "USA", "Japan", "China" };
		for (int i = 0; i < sArr.length; i++) {
			System.out.printf("%d.%s  ", (i + 1), sArr[i]);
		} // end for
		System.out.println();
		System.out.print(uTemp.pf.getNickname() + "> ");
		int input = Integer.parseInt(MenuViewer.sc.nextLine());
		uTemp.pf.config.setNations(sArr[input - 1]);
		System.out.println("Country Settings Completed");
	}// end selectNation

	private void selectCaption() {
		User uTemp = userM.searchIsOnline();
		uTemp.pf.config.setCaption(!uTemp.pf.config.isCaption());
		if (uTemp.pf.config.isCaption()) {
			System.out.println("Caption ON");
		} else {
			System.out.println("Caption OFF");
		} // end if
	}// end selectCaption

	private void selectQuality() {
		User uTemp = userM.searchIsOnline();
		String[] sArr = { "144p", "240p", "360p", "480p", "720p", "1080p" };
		for (int i = 0; i < sArr.length; i++) {
			System.out.printf("%d.%s  ", (i + 1), sArr[i]);
		} // end for
		System.out.println();
		System.out.print(uTemp.pf.getNickname() + "> ");
		int input = Integer.parseInt(MenuViewer.sc.nextLine());
		uTemp.pf.config.setQuality(sArr[input - 1]);
		System.out.println("Image quality setting complete");
	}// end selectQuality

	private void showConfiguration() {
		User uTemp = userM.searchIsOnline();
		System.out.println(uTemp.pf.config.toString());
	}// end showConfiguration

	void showContents() {
		int col = 5;
		for (int i = 0; i < movieM.movieStorage.size(); i += 5) {
			for (int k = i; k < (i + col); k++) {
				System.out.printf("Title: %-20s", movieM.movieStorage.get(k).getTitle());
			} // end for
			System.out.println();
			for (int k = i; k < (i + col); k++) {
				System.out.printf("Genre: %-20s", movieM.movieStorage.get(k).getGenre());
			} // end for
			System.out.println();
			for (int k = i; k < (i + col); k++) {
				System.out.printf("FilmRating: %-20d", movieM.movieStorage.get(k).getFilmRating());
			} // end for
			System.out.println();
			for (int k = i; k < (i + col); k++) {
				System.out.printf("Score: %-20.1f", movieM.movieStorage.get(k).getScore());
			} // end for
			System.out.printf("%n%n");
		} // end for
	}// end showContents
}// end PlayManager
