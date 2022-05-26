package step7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
					saveUserData();
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
				System.err.println("[ERROR] Please enter numbers only.");
			} catch (Exception e) {
				System.err.println("[ERROR] Unknown error occurred");
			} // end try-catch
		} // end while
	}// end profileSetting

	private void allDisplayUser() {
		if (!userStorageCheck()) {
			return;
		} // end if
		Iterator<User> it = userStorage.iterator();
		System.out.println();
		System.out.println("?��?��?��?�� Membership information ?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��");
		while (it.hasNext()) {
			User uTemp = it.next();
			System.out.println(uTemp.toString());
		} // end while
		System.out.printf("?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��%n%n");
	}// end allDisplayUser

	private void searchUser() throws NotExistException {
		if (!userStorageCheck()) {
			return;
		} // end if
		System.out.print("Enter ID to search: ");
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
		System.out.print("Enter ID to modify: ");
		String id = MenuViewer.sc.nextLine();
		User uTemp = search(id);
		if (uTemp == null) {
			throw new NotExistException();
		} // end if
		System.out.print("Enter a new password: ");
		String pw = MenuViewer.sc.nextLine();
		uTemp.setPw(pw);
		System.out.print("Enter a new age: ");
		int age = Integer.parseInt(MenuViewer.sc.nextLine());
		uTemp.setAge(age);
		System.out.println("Modification complete");
	}// end updateUser

	private void deleteUser() throws NotExistException {
		if (!userStorageCheck()) {
			return;
		} // end if
		System.out.print("Enter ID to delete: ");
		String id = MenuViewer.sc.nextLine();
		User uTemp = search(id);
		if (uTemp == null) {
			throw new NotExistException();
		} else if (uTemp.getId() == "admin") {
			System.out.println("Administrator cannot delete");
		} // end if
		if (userStorage.remove(uTemp)) {
			System.out.println("Delete complete");
		} else {
			System.out.println("Deletion failed");
		} // end if
	}// end deleteUser

	void changeAdminPassword() {
		User uTemp = search("admin");
		System.out.print("Enter password to change: ");
		String pw = MenuViewer.sc.nextLine();
		uTemp.setPw(pw);
		System.out.println("Password change completed");
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
			System.out.printf("[Info] No information saved%n%n");
			return false;
		} // end if
		return true;
	}// end userStorageCheck
	
	void loadUserData() {
		File dataFile = new File("UserData.dat");
		if (!dataFile.exists()) {
			try {
				dataFile.createNewFile();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			} // end try-catch
		} // end if
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream("UserData.dat");
			in = new ObjectInputStream(fis);
			userStorage = (HashSet<User>) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				} // end if
				if (fis != null) {
					fis.close();
				} // end if
			} catch (IOException e) {
				e.printStackTrace();
			} // end try-catch
		} // end try-catch-finally
	}// end loadUserData
	
	void saveUserData() {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream("UserData.dat");
			out = new ObjectOutputStream(fos);
			out.writeObject(userStorage);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				} // end if
				if (fos != null) {
					fos.close();
				} // end if
			} catch (IOException e) {
				e.printStackTrace();
			} // end try-catch
		} // end try-catch-finally
	}// end saveUserData
}// end UserManager
