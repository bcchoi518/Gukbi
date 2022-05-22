package fiveflix;

import java.util.HashSet;
import java.util.Iterator;

public class UserManager {
	private static UserManager um;
	// private static MenuManager mm;

	private HashSet<User> infoStorage = new HashSet<User>();
	// private Object general;
	// private Object vip;

	public static UserManager getInstance() {
		if (um == null)
			um = new UserManager();
		return um;
	}

	private User readNewUser() {
		System.out.println("Input Name==>");
		String name = MainViewer.sc.nextLine();
		System.out.println("Input Age==>");
		String age = MainViewer.sc.nextLine();
		System.out.println("Input ID to use==>");
		String id = MainViewer.sc.nextLine();
		System.out.println("Input password to use==>");
		String password = MainViewer.sc.nextLine();
		System.out.println("Choose Grade (general,pro)==>");
		String grade = MainViewer.sc.nextLine();
		return new User(name, age, id, password, grade);
	}

	void signIn() {
		System.out.println("Input Name==>");
		String name = MainViewer.sc.nextLine();
		System.out.println("Input Age==>");
		String age = MainViewer.sc.nextLine();
		System.out.println("Input ID to use==>");
		String id = MainViewer.sc.nextLine();
		System.out.println("Input password to use==>");
		String password = MainViewer.sc.nextLine();
		System.out.println("Choose Grade (general,pro)==>");
		String grade = MainViewer.sc.nextLine();

		User tmp = new User(name, age, id, password, grade);
		if (infoStorage.add(tmp)) {
			System.out.println("Welcome! Plz LogIn with your New ID/PW");
			//System.out.println("Your Grade is" + grade + "!");
		}
		// System.out.println(tmp);
		// System.out.println("Welcome! Plz LogIn with your New ID/Password");

	}

	void logIn() {

		System.out.println("Input ID==>");
		String id = MainViewer.sc.nextLine();
		System.out.println("Input PW==>");
		String password = MainViewer.sc.nextLine();

		Iterator<User> it = infoStorage.iterator();
		while (it.hasNext()) {
			User tmp = (User) it.next();
			if (!id.equals(tmp.id)) {
				System.out.println("There is no info");
				logIn();
			} else if ((id.equals(tmp.id))) {
				System.out.println("Hello!");
			} else {
				System.out.println("Wrong Info,Try Again");
				logIn();
			}
		}

	}

}
