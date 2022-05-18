package step1;

import java.util.HashSet;
import java.util.Iterator;

public class UserManager {
	private static UserManager userM;
	HashSet<User> userStorage = new HashSet<User>();

	private UserManager() {
	}

	public static UserManager getInstance() {
		if (userM == null) {
			userM = new UserManager();
		} // end if
		return userM;
	}// end getInstance

	void userManagement() {
		while (true) {
			try {
				MenuViewer.showUserManagementMenu();
				int choice = Integer.parseInt(MenuViewer.sc.nextLine());
				switch (choice) {
				case 0:
					return;
				case 1:
					allDisplayUser();
					break;
				case 2:
					searchUser();
					break;
				case 3:
					updateUser();
					break;
				case 4:
					deleteUser();
					break;
				default:
					throw new ChoiceException(choice);
				}// end switch
			} catch (ChoiceException e) {
				e.showErrorMessage();
			} catch (NotExistException e) {
				e.showErrorMessage();
			} catch (Exception e) {
				e.printStackTrace();
			} // end try-catch
		} // end while
	}// end profileSetting

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
	}// end allDisplayUser

	void searchUser() throws NotExistException {
		if (!userStorageCheck()) {
			return;
		} // end if
		System.out.print("검색할 ID를 입력하세요: ");
		String id = MenuViewer.sc.nextLine();
		User uTemp = search(id);
		if (uTemp == null) {
			throw new NotExistException();
		} // end if
		System.out.println(uTemp.toString());
	}// end searchUser

	void updateUser() throws NotExistException {
		if (!userStorageCheck()) {
			return;
		} // end if
		System.out.print("수정할 ID를 입력하세요: ");
		String id = MenuViewer.sc.nextLine();
		User uTemp = search(id);
		if (uTemp == null) {
			throw new NotExistException();
		} // end if
		System.out.print("새로운 ID를 입력하세요: ");
		id = MenuViewer.sc.nextLine();
		uTemp.setId(id);
		System.out.print("새로운 Password를 입력하세요: ");
		String pw = MenuViewer.sc.nextLine();
		uTemp.setPw(pw);
		System.out.println("수정 완료");
	}// end updateUser

	void deleteUser() throws NotExistException {
		if (!userStorageCheck()) {
			return;
		} // end if
		System.out.print("삭제할 ID를 입력하세요: ");
		String id = MenuViewer.sc.nextLine();
		User uTemp = search(id);
		if (uTemp == null) {
			throw new NotExistException();
		} // end if
		userStorage.remove(uTemp);
		System.out.println("삭제 완료");
	}// end deleteUser

	void changeAdminPassword() {
		User uTemp = search("admin");
		System.out.print("변경할 패스워드를 입력하세요: ");
		String pw = MenuViewer.sc.nextLine();
		uTemp.setPw(pw);
	}// end changeAdminPassword

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

	private boolean userStorageCheck() {
		if (userStorage.isEmpty()) {
			System.out.printf("저장된 정보가 없습니다.%n%n");
			return false;
		} // end if
		return true;
	}// end userStorageCheck
}// end UserManager
