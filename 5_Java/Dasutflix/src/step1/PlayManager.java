package step1;

public class PlayManager {
	private static PlayManager pm;
	UserManager um;

	private PlayManager() {
		um = UserManager.getInstance();
		um.userStorage.add(new Admin());
	}

	public static PlayManager getInstance() {
		if (pm == null) {
			pm = new PlayManager();
		} // end if
		return pm;
	}// end getInstance

	User signIn() throws ChoiceException, NotExistException {
		System.out.print("ID를 입력하세요: ");
		String id = MenuViewer.sc.nextLine();
		System.out.print("PassWord를 입력하세요: ");
		String pw = MenuViewer.sc.nextLine();
		User uTemp = um.search(id);
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

	void signOut() {
		User uTemp = um.searchIsOnline();
		uTemp.setOnline(false);
	}// end signOut

	void play(User user) throws ChoiceException, NotExistException {
		int choice = -1;
		try {
			while (true) {
				MenuViewer.showMainMenu(user);
				choice = Integer.parseInt(MenuViewer.sc.nextLine());
				switch (choice) {
				case 0:
					signOut();
					return;
				case 1:
					um.profileSetting();
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				default:
					throw new ChoiceException(choice);
				}// end switch
			} // end while
		} catch (ChoiceException e) {
			throw new ChoiceException(choice);
		} catch (NotExistException e) {
			throw new NotExistException();
		}
		// end try-catch
	}// end play

	void play(Admin admin) throws ChoiceException {
		int choice = 0;
		try {
			MenuViewer.showMainMenu(admin);
			choice = Integer.parseInt(MenuViewer.sc.nextLine());
			switch (choice) {
			case 0:
				return;
			case 1:
				break;
			case 2:
				break;
			}// end switch
		} catch (Exception e) {
			throw new ChoiceException(choice);
		} // end try-catch
	}// end play
}// end PlayManager
