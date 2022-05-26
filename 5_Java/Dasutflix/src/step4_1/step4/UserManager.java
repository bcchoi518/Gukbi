package step4;

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
				System.err.println("    .....oOoOoOoOoOoOoOoOps!( Please enter Numbers ONLY )");
			} catch (Exception e) {
				System.err.println("    .....oOoOoOoOoOoOoOoOps!( Unknown ERROR Occurred )");
			} // end try-catch
		} // end while
	}// end profileSetting

	private void allDisplayUser() {
		if (!userStorageCheck()) {
			return;
		} // end if
		Iterator<User> it = userStorage.iterator();
		System.out.println();
		System.out.println("    ──────────────────────────── Membership information ");
		while (it.hasNext()) {
			User uTemp = it.next();
			System.out.print("    ──────────────────────────── ");
			System.out.println(uTemp.toString());
		} // end while
		//System.out.printf("    ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━%n%n");
		System.out.println();
	}// end allDisplayUser

	private void searchUser() throws NotExistException {
		if (!userStorageCheck()) {
			return;
		} // end if
		System.out.print("    ──────────────────────────── Enter ID to search> ");
		String id = MenuViewer.sc.nextLine();
		User uTemp = search(id);
		if (uTemp == null) {
			throw new NotExistException();
		} // end if
		System.out.print("    ──────────────────────────── ");
		System.out.println(uTemp.toString());
	}// end searchUser

	private void updateUser() throws NotExistException {
		if (!userStorageCheck()) {
			return;
		} // end if
		System.out.print("    ──────────────────────────── Enter ID to modify> ");
		String id = MenuViewer.sc.nextLine();
		User uTemp = search(id);
		if (uTemp == null) {
			throw new NotExistException();
		} // end if
		System.out.print("    ──────────────────────────── Enter a new password> ");
		String pw = MenuViewer.sc.nextLine();
		uTemp.setPw(pw);
		System.out.print("    ──────────────────────────── Enter a new age> ");
		int age = Integer.parseInt(MenuViewer.sc.nextLine());
		uTemp.setAge(age);
		System.out.println("    ──────────────────────────── Modification complete !");
	}// end updateUser

	private void deleteUser() throws NotExistException {
		if (!userStorageCheck()) {
			return;
		} // end if
		System.out.print("    ──────────────────────────── Enter ID to delete> ");
		String id = MenuViewer.sc.nextLine();
		User uTemp = search(id);
		if (uTemp == null) {
			throw new NotExistException();
		} else if (uTemp.getId() == "admin") {
			System.out.println("    ──────────────────────────── Administrator cannot delete");
		} // end if
		if (userStorage.remove(uTemp)) {
			System.out.println("    ──────────────────────────── Delete complete !");
		} else {
			System.out.println("    ──────────────────────────── Deletion failed !");
		} // end if
	}// end deleteUser

	void changeAdminPassword() {
		User uTemp = search("admin");
		System.out.print("    ──────────────────────────── Enter password to change> ");
		String pw = MenuViewer.sc.nextLine();
		uTemp.setPw(pw);
		System.out.println("    ──────────────────────────── Password change completed !");
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
			System.out.printf("    ──────────────────────────── No information saved%n%n");
			return false;
		} // end if
		return true;
	}// end userStorageCheck
}// end UserManager
