package step1;

public class PlayManager {
	private static PlayManager playM;
	private UserManager userM;
	private ProfileManager profileM;

	private PlayManager() {
		userM = UserManager.getInstance();
		profileM = ProfileManager.getInstance();
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
		User uTemp = new User(id, pw);
		if (!userM.userStorage.add(uTemp)) {
			System.out.println("존재하는 회원입니다.");
			return;
		} // end if
		System.out.print("사용하실 프로필 닉네임을 입력하세요: ");
		String nickname = MenuViewer.sc.nextLine();
		uTemp.pf.setNickname(nickname);
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
		System.out.print("ID를 입력하세요: ");
		String id = MenuViewer.sc.nextLine();
		System.out.print("PassWord를 입력하세요: ");
		String pw = MenuViewer.sc.nextLine();
		User uTemp = userM.search(id);
		if (uTemp == null) {
			throw new NotExistException();
		} // end if
		if (uTemp.getPw().equals(pw)) {
			uTemp.setOnline(true);
			System.out.println("Hello Dasutflix world!!");
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
					System.out.println("공사중");
					break;
				case 3:
					System.out.println("공사중");
					break;
				case 4:
					configurationSetting();
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
					System.out.println("공사중");
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

	private void configurationSetting() {
		System.out.println("공사중");
	}// end configurationSetting
}// end PlayManager
