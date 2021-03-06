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
			} catch (NumberFormatException e) {
				System.err.println("[ERROR] 숫자만 입력 가능합니다.");
			} catch (Exception e) {
				System.err.println("[ERROR] 알수 없는 오류가 발생하였습니다.");
			} // end try-catch
		} // end while
	}// end profileSetting

	private void allDisplayUser() {
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

	private void searchUser() throws NotExistException {
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

	private void updateUser() throws NotExistException {
		if (!userStorageCheck()) {
			return;
		} // end if
		System.out.print("수정할 ID를 입력하세요: ");
		String id = MenuViewer.sc.nextLine();
		User uTemp = search(id);
		if (uTemp == null) {
			throw new NotExistException();
		} // end if
		System.out.print("새로운 Password를 입력하세요: ");
		String pw = MenuViewer.sc.nextLine();
		uTemp.setPw(pw);
		System.out.print("새로운 나이를 입력하세요: ");
		int age = Integer.parseInt(MenuViewer.sc.nextLine());
		uTemp.setAge(age);
		System.out.println("수정 완료");
	}// end updateUser

	private void deleteUser() throws NotExistException {
		if (!userStorageCheck()) {
			return;
		} // end if
		System.out.print("삭제할 ID를 입력하세요: ");
		String id = MenuViewer.sc.nextLine();
		User uTemp = search(id);
		if (uTemp == null) {
			throw new NotExistException();
		} else if (uTemp.getId() == "admin") {
			System.out.println("관리자는 삭제할 수 없습니다.");
		} // end if
		if (userStorage.remove(uTemp)) {
			System.out.println("삭제 완료");
		} else {
			System.out.println("삭제 실패");
		} // end if
	}// end deleteUser

	void changeAdminPassword() {
		User uTemp = search("admin");
		System.out.print("변경할 password를 입력하세요: ");
		String pw = MenuViewer.sc.nextLine();
		uTemp.setPw(pw);
		System.out.println("password가 변경되었습니다.");
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
