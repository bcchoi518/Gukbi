package step1;

import java.util.Iterator;

public class ProfileManager {
	private static ProfileManager profileM;
	UserManager userM;

	private ProfileManager() {
		userM = UserManager.getInstance();
	}

	public static ProfileManager getInstance() {
		if (profileM == null) {
			profileM = new ProfileManager();
		} // end if
		return profileM;
	}// end getInstance

	void profileSetting() {
		while (true) {
			try {
				User uTemp = userM.searchIsOnline();
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
	}// end profileSetting

	void createProfile() {
		User uTemp = userM.searchIsOnline();
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
			uTemp.pf.setActive(false);
			uTemp.pf = pfTemp;
			uTemp.pf.setActive(true);
			System.out.println("프로필 생성 완료");
		} // end if
	}// end createProfile

	void changeProfile() throws NotExistException {
		System.out.print("사용할 프로필 닉네임을 입력하세요: ");
		String nickname = MenuViewer.sc.nextLine();
		Profile changeTemp = searchProfile(nickname);
		if (changeTemp == null) {
			throw new NotExistException();
		} // end if
		User uTemp = userM.searchIsOnline();
		uTemp.pf.setActive(false);
		uTemp.pf = changeTemp;
		uTemp.pf.setActive(true);
	}// end changeProfile

	void updateProfile() throws NotExistException {
		Profile pfTemp = searchIsActive();
		if (pfTemp == null) {
			throw new NotExistException();
		} // end if
		pfTemp.favorite.removeAll(pfTemp.favorite);
		System.out.print("수정할 프로필 닉네임을 입력하세요: ");
		pfTemp.setNickname(MenuViewer.sc.nextLine());

		System.out.println("수정할 장르를 3가지 고르세요");
		System.out.println("공포, 코믹, 드라마, 에로, SF");
		for (int i = 0; i < pfTemp.FAVORITE_MAX; i++) {
			System.out.print(">> ");
			String favorite = MenuViewer.sc.nextLine();
			pfTemp.favorite.add(favorite);
		} // end for
		System.out.println("수정 완료");
	}// end updateProfile

	void deleteProfile() throws NotExistException {
		System.out.print("삭제할 프로필 닉네임을 입력하세요: ");
		String nickname = MenuViewer.sc.nextLine();
		Profile pfTemp = searchProfile(nickname);
		if (pfTemp == null) {
			throw new NotExistException();
		} else if (pfTemp.isActive()) {
			System.out.println("현재 선택된 프로필은 삭제할 수 없습니다.");
			return;
		} // end if
		User uTemp = userM.searchIsOnline();
		uTemp.profileStorage.remove(pfTemp);
		System.out.println("삭제 완료");
	}// end deleteProfile

	void allDisplayProfile() {
		if (!profileStorageCheck()) {
			return;
		} // end if
		User uTemp = userM.searchIsOnline();

		Iterator<Profile> it = uTemp.profileStorage.iterator();

		System.out.println("━━━━━━━━━━━━━━━━━━━━ 프로필 정보 ━━━━━━━━━━━━━━━━━━━━");
		while (it.hasNext()) {
			Profile pfTemp = it.next();
			System.out.println(pfTemp.toString());
		} // end while
		System.out.printf("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━%n%n");
	}// end allDisplayProfile

	Profile searchProfile(String nickname) {
		User uTemp = userM.searchIsOnline();
		Iterator<Profile> it = uTemp.profileStorage.iterator();
		Profile pfTemp = null;
		while (it.hasNext()) {
			pfTemp = it.next();
			if (pfTemp.getNickname().equals(nickname)) {
				return pfTemp;
			} // end if
		} // end while
		return null;
	}// end searchProfile

	Profile searchIsActive() {
		User uTemp = userM.searchIsOnline();
		Iterator<Profile> it = uTemp.profileStorage.iterator();
		Profile pfTemp = null;
		while (it.hasNext()) {
			pfTemp = it.next();
			if (pfTemp.isActive()) {
				return pfTemp;
			} // end if
		} // end while
		return null;
	}// end searchIsActive

	private boolean profileStorageCheck() {
		User uTemp = userM.searchIsOnline();
		if (uTemp.profileStorage.isEmpty()) {
			System.out.printf("저장된 정보가 없습니다.%n%n");
			return false;
		} // end if
		return true;
	}// end profileStorageCheck
}// end ProfileManager
