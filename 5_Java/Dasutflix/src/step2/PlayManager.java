package step2;

public class PlayManager {
	private static PlayManager playM;
	private UserManager userM;
	private ProfileManager profileM;
	private MovieManager movieM;

	private PlayManager() {
		userM = UserManager.getInstance();
		profileM = ProfileManager.getInstance();
		movieM = MovieManager.getInstance();
		userM.userStorage.add(new Admin());
	}

	public static PlayManager getInstance() {
		if (playM == null) {
			playM = new PlayManager();
		} // end if
		return playM;
	}// end getInstance

	void signUp() {
		System.out.print("사용하실 ID를 입력하세요: ");
		String id = MenuViewer.sc.nextLine();
		System.out.print("사용하실 PassWord를 입력하세요: ");
		String pw = MenuViewer.sc.nextLine();
		System.out.print("나이를 입력하세요: ");
		int age = Integer.parseInt(MenuViewer.sc.nextLine());
		User uTemp = new User(id, pw, age);
		if (!userM.userStorage.add(uTemp)) {
			System.out.println("존재하는 회원입니다.");
			return;
		} // end if
		System.out.print("사용하실 프로필 닉네임을 입력하세요: ");
		String nickname = MenuViewer.sc.nextLine();
		uTemp.pf = new Profile(nickname);
		System.out.println("선호하는 장르를 3가지 고르세요");
		System.out.println("공포, 코믹, 드라마, 에로, SF");
		for (int i = 0; i < uTemp.pf.FAVORITE_MAX; i++) {
			System.out.print(">> ");
			String favorite = MenuViewer.sc.nextLine();
			uTemp.pf.favorite.add(favorite);
		} // end for
		uTemp.pf.setActive(true);
		if (uTemp.profileStorage.add(uTemp.pf)) {
			System.out.println("회원가입을 축하합니다!");
		} else {
			System.out.println("회원가입에 실패하였습니다.");
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
			System.out.println("Login Success!!");
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
					showContents();
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
				System.err.println("[ERROR] 숫자만 입력 가능합니다.");
			} catch (Exception e) {
				System.err.println("[ERROR] 알수 없는 오류가 발생하였습니다.");
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
				System.err.println("[ERROR] 숫자만 입력 가능합니다.");
			} catch (Exception e) {
				System.err.println("[ERROR] 알수 없는 오류가 발생하였습니다.");
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
				System.err.println("[ERROR] 숫자만 입력 가능합니다.");
			} catch (Exception e) {
				System.err.println("[ERROR] 알수 없는 오류가 발생하였습니다.");
			} // end try-catch
		} // end while
	}// end configurationSetting

	private void selectNation() {
		User uTemp = userM.searchIsOnline();
		String[] sArr = { "대한민국", "미국", "일본", "중국" };
		for (int i = 0; i < sArr.length; i++) {
			System.out.printf("%d.%s  ", (i + 1), sArr[i]);
		} // end for
		System.out.println();
		System.out.print(uTemp.pf.getNickname() + "> ");
		int input = Integer.parseInt(MenuViewer.sc.nextLine());
		uTemp.pf.config.setNations(sArr[input - 1]);
		System.out.println("국가 설정 완료");
	}// end selectNation

	private void selectCaption() {
		User uTemp = userM.searchIsOnline();
		uTemp.pf.config.setCaption(!uTemp.pf.config.isCaption());
		if (uTemp.pf.config.isCaption()) {
			System.out.println("자막 켬");
		} else {
			System.out.println("자막 끔");
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
		System.out.println("화질 설정 완료");
	}// end selectQuality

	private void showConfiguration() {
		User uTemp = userM.searchIsOnline();
		System.out.println(uTemp.pf.config.toString());
	}// end showConfiguration

	void showContents() {
		int col = 5;
		for (int i = 0; i < movieM.movie.size(); i += 5) {
			for (int k = i; k < (i + col); k++) {
				System.out.printf("Title: %-20s", movieM.movie.get(k).getTitle());
			} // end for
			System.out.println();
			for (int k = i; k < (i + col); k++) {
				System.out.printf("Genre: %-20s", movieM.movie.get(k).getGenre());
			} // end for
			System.out.println();
			for (int k = i; k < (i + col); k++) {
				System.out.printf("AgeGrade: %-20d", movieM.movie.get(k).getAgeGrade());
			} // end for
			System.out.println();
			for (int k = i; k < (i + col); k++) {
				System.out.printf("Score: %-20.1f", movieM.movie.get(k).getScore());
			} // end for
			System.out.printf("%n%n");
		} // end for
	}// end showContents
}// end PlayManager
