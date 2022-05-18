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
		System.out.println("회원가입을 축하합니다!");
		userStorage.add(uTemp);
	}// end createUser

	User signIn() {
		System.out.print("ID를 입력하세요: ");
		String id = MenuViewer.sc.nextLine();
		System.out.print("PassWord를 입력하세요: ");
		String pw = MenuViewer.sc.nextLine();
		User uTemp = search(id);
		if (uTemp.getPw().equals(pw)) {
			System.out.println("Hello Dasutflix world!!");
			return uTemp;
		} else {

		}
		return uTemp;
	}// end createUser

	void allDisplay() {
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

	private User search(String id) {
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

	private boolean userStorageCheck() {
		if (userStorage.isEmpty()) {
			System.out.printf("저장된 정보가 없습니다.%n%n");
			return false;
		} // end if
		return true;
	}// end infoStorageCheck
}// end UserManager
