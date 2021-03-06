package step5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;

public class ProfileManager {
	private static ProfileManager profileM;
	private UserManager userM;

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
					saveProfileData();
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
				System.err.println("[ERROR] Please enter numbers only.");
			} catch (Exception e) {
				System.err.println("[ERROR] Unknown error occurred");
			} // end try-catch
		} // end while
	}// end profileSetting

	private void createProfile() {
		User uTemp = userM.searchIsOnline();
		if (uTemp.profileStorage.size() == uTemp.PROFILE_MAX) {
			System.out.println("The profile is limited to five profiles.");
			return;
		} // end if
		Profile pfTemp = new Profile();
		System.out.print("Enter a profile nickname to use: ");
		String nickname = MenuViewer.sc.nextLine();
		pfTemp.setNickname(nickname);
		System.out.println("Choose 3 genres that you prefer");
		MenuViewer.showGenre();
		for (int i = 0; i < pfTemp.FAVORITE_MAX; i++) {
			System.out.print(">> ");
			int tmp = Integer.parseInt(MenuViewer.sc.nextLine());
			pfTemp.favorite.add(MenuViewer.genreArr[tmp - 1]);
		} // end for
		if (uTemp.profileStorage.add(pfTemp)) {
			uTemp.pf.setActive(false);
			uTemp.pf = pfTemp;
			uTemp.pf.setActive(true);
			System.out.println("Profile creation complete");
		} // end if
	}// end createProfile

	private void changeProfile() throws NotExistException {
		System.out.print("Enter a profile nickname to use: ");
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

	private void updateProfile() throws NotExistException {
		System.out.print("Enter profile nickname to modify: ");
		String nickname = MenuViewer.sc.nextLine();
		Profile pfTemp = searchProfile(nickname);
		if (pfTemp == null) {
			throw new NotExistException();
		} // end if
		pfTemp.favorite.removeAll(pfTemp.favorite);
		System.out.println("Choose 3 new genres");
		MenuViewer.showGenre();
		for (int i = 0; i < pfTemp.FAVORITE_MAX; i++) {
			System.out.print(">> ");
			int tmp = Integer.parseInt(MenuViewer.sc.nextLine());
			pfTemp.favorite.add(MenuViewer.genreArr[tmp - 1]);
		} // end for
		System.out.println("Modification complete");
	}// end updateProfile

	private void deleteProfile() throws NotExistException {
		System.out.print("Enter profile nickname to delete: ");
		String nickname = MenuViewer.sc.nextLine();
		Profile pfTemp = searchProfile(nickname);
		if (pfTemp == null) {
			throw new NotExistException();
		} else if (pfTemp.isActive()) {
			System.out.println("Cannot delete currently selected profile");
			return;
		} // end if
		User uTemp = userM.searchIsOnline();
		if (uTemp.profileStorage.remove(pfTemp)) {
			System.out.println("Delete complete");
		} else {
			System.out.println("Deletion failed");
		} // end if
	}// end deleteProfile

	private void allDisplayProfile() {
		if (!profileStorageCheck()) {
			return;
		} // end if
		User uTemp = userM.searchIsOnline();

		Iterator<Profile> it = uTemp.profileStorage.iterator();

		System.out.println("???????????????????????????? Profile Information ???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
		while (it.hasNext()) {
			Profile pfTemp = it.next();
			System.out.println(pfTemp.toString());
		} // end while
		System.out.printf("??????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????%n%n");
	}// end allDisplayProfile

	private Profile searchProfile(String nickname) {
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

	private Profile searchIsActive() {
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
			System.out.printf("[Info] No information saved%n%n");
			return false;
		} // end if
		return true;
	}// end profileStorageCheck
	
	void loadProfileData() {
		User uTemp = userM.searchIsOnline();
		File dataFile = new File(uTemp.getId()+"_ProfileData.dat");
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
			fis = new FileInputStream(uTemp.getId()+"_ProfileData.dat");
			in = new ObjectInputStream(fis);
			uTemp.profileStorage = (HashSet<Profile>) in.readObject();
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
	}// end loadProfileData
	
	void saveProfileData() {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		User uTemp = userM.searchIsOnline();
		try {
			fos = new FileOutputStream(uTemp.getId()+"_ProfileData.dat");
			out = new ObjectOutputStream(fos);
			out.writeObject(uTemp.profileStorage);
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
	}// end saveProfileData
}// end ProfileManager
