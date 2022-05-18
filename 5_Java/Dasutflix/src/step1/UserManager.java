package step1;

import java.util.HashSet;
import java.util.Iterator;

public class UserManager {
	private static UserManager um;
	HashSet<User> userStorage = new HashSet<User>();

	private UserManager() {
	}

	public static UserManager getInstance() {
		if (um == null) {
			um = new UserManager();
		} // end if
		return um;
	}// end getInstance

	void signUp() {
		System.out.print("사용하실 ID를 입력하세요: ");
		String id = MenuViewer.sc.nextLine();
		System.out.print("사용하실 PassWord를 입력하세요: ");
		String pw = MenuViewer.sc.nextLine();
		User uTemp = new User(id, pw);
		if (!userStorage.add(uTemp)) {
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
		System.out.println("회원가입을 축하합니다!");
	}// end createUser

	void profileSetting() throws NotExistException, ChoiceException {
		while (true) {
			User uTemp = searchIsOnline();
			MenuViewer.showProfileMenu(uTemp);
			int choice = Integer.parseInt(MenuViewer.sc.nextLine());
			switch (choice) {
			case 0:
				return;
			case 1:
				allDisplayProfile();
				changeProfile();
				break;
			case 2:
				createProfile();
				break;
			case 3:
				updateProfile();
				break;
			case 4:
				deleteProfile();
				break;
			default:
				throw new ChoiceException(choice);
			}// end switch
		} // end while
	}// end profileSetting

	void createProfile() {
		User uTemp = searchIsOnline();
		Profile pfTemp = new Profile();
		System.out.print("사용할 프로필 닉네임을 입력하세요: ");
		String nickname = MenuViewer.sc.nextLine();
		pfTemp.setNickname(nickname);
		System.out.println("선호할 장르를 3가지 고르세요");
		System.out.println("공포, 코믹, 드라마, 에로, SF");
		for (int i = 0; i < uTemp.pf.FAVORITE_MAX; i++) {
			System.out.print(">> ");
			String favorite = MenuViewer.sc.nextLine();
			pfTemp.favorite.add(favorite);
		} // end for
		if (uTemp.profileStorage.add(pfTemp)) {
			System.out.println("프로필 생성");
		} // end if
	}// end createProfile

	void changeProfile() throws NotExistException {
		System.out.print("사용할 프로필 닉네임을 입력하세요: ");
		String nickname = MenuViewer.sc.nextLine();
		Profile changeTemp = searchProfile(nickname);
		if (changeTemp == null) {
			throw new NotExistException();
		} else {
			Profile curTemp = searchIsActive();
			curTemp.setActive(false);
			changeTemp.setActive(true);
		} // end if
	}// end changeProfile

	void updateProfile() {
		Profile pfTemp = searchIsActive();
		pfTemp.favorite.removeAll(pfTemp.favorite);
		System.out.print("변경할 프로필 닉네임을 입력하세요: ");
		pfTemp.setNickname(MenuViewer.sc.nextLine());
		System.out.println("변경할 장르를 3가지 고르세요");
		System.out.println("공포, 코믹, 드라마, 에로, SF");
		for (int i = 0; i < pfTemp.FAVORITE_MAX; i++) {
			System.out.print(">> ");
			String favorite = MenuViewer.sc.nextLine();
			pfTemp.favorite.add(favorite);
		} // end for
	}// end updateProfile

	void deleteProfile() {
		System.out.print("삭제할 프로필 닉네임을 입력하세요: ");
		String nickname = MenuViewer.sc.nextLine();
		Profile pfTemp = searchProfile(nickname);
		User uTemp = searchIsOnline();
		uTemp.profileStorage.remove(pfTemp);
	}// end deleteProfile

	void allDisplayUser() {
		if (!userStorageCheck()) {
			return;
		} // end if

		Iterator<User> it = userStorage.iterator();

		System.out.println("━━━━━━━━━━━━━━━━━━━━ 회원 정보 ━━━━━━━━━━━━━━━━━━━━");
		while (it.hasNext()) {
			User uTemp = it.next();
			System.out.println(uTemp.toString());
		} // end while
		System.out.printf("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━%n%n");
	}// end allDisplay

	void allDisplayProfile() {
		if (!profileStorageCheck()) {
			return;
		} // end if
		User uTemp = searchIsOnline();

		Iterator<Profile> it = uTemp.profileStorage.iterator();

		System.out.println("━━━━━━━━━━━━━━━━━━━━ 프로필 정보 ━━━━━━━━━━━━━━━━━━━━");
		while (it.hasNext()) {
			Profile pfTemp = it.next();
			System.out.println(pfTemp.toString());
		} // end while
		System.out.printf("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━%n%n");
	}// end allDisplay

	User search(String id) {
		Iterator<User> it = userStorage.iterator();
		User uTemp = null;

		while (it.hasNext()) {
			uTemp = it.next();
			if (uTemp.getId().equals(id)) {
				return uTemp;
			} // end if
		} // end while
		return null;
	}// end search

	Profile searchProfile(String nickname) {
		User uTemp = searchIsOnline();
		Iterator<Profile> it = uTemp.profileStorage.iterator();
		Profile pfTemp = null;
		while (it.hasNext()) {
			pfTemp = it.next();
			if (pfTemp.getNickname().equals(nickname)) {
				return pfTemp;
			} // end if
		} // end while
		return null;
	}// end search

	User searchIsOnline() {
		Iterator<User> it = userStorage.iterator();
		User uTemp = null;

		while (it.hasNext()) {
			uTemp = it.next();
			if (uTemp.isOnline()) {
				return uTemp;
			} // end if
		} // end while
		return null;
	}// end searchIsOnline

	Profile searchIsActive() {
		User uTemp = searchIsOnline();
		Iterator<Profile> it = uTemp.profileStorage.iterator();
		Profile pfTemp = null;
		while (it.hasNext()) {
			pfTemp = it.next();
			if (pfTemp.isActive()) {
				return pfTemp;
			} // end if
		} // end while
		return null;
	}// end searchIsOnline

	private boolean userStorageCheck() {
		if (userStorage.isEmpty()) {
			System.out.printf("저장된 정보가 없습니다.%n%n");
			return false;
		} // end if
		return true;
	}// end userStorageCheck

	private boolean profileStorageCheck() {
		User uTemp = searchIsOnline();
		if (uTemp.profileStorage.isEmpty()) {
			System.out.printf("저장된 정보가 없습니다.%n%n");
			return false;
		} // end if
		return true;
	}// end profileStorageCheck
}// end UserManager
