package step1;

import java.util.Iterator;
import java.util.Scanner;

public class MenuViewer {
	static Scanner sc = new Scanner(System.in);

	static void showLogIn() {
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 프로그램 종료");
		System.out.print("선택: ==> ");
	}// end showLogIn

	static void showMainMenu(User user) throws NotExistException {
		if (user instanceof Admin) {
			showAdminMenu();
			return;
		} // end if
		showUserMenu(user);
	}// end showMainMenu

	static void showUserMenu(User user) throws NotExistException {
		Iterator<Profile> it = user.profileStorage.iterator();
		Profile pfTemp = null;
		while (it.hasNext()) {
			pfTemp = it.next();
			if (pfTemp.isActive()) {
				break;
			} else {
				throw new NotExistException();
			} // end if
		} // end while
		System.out.println("0. 로그아웃");
		System.out.println("1. 프로필");
		System.out.println("2. 영상검색");
		System.out.println("3. 영상정보");
		System.out.println("4. 환경설정");
		System.out.print(pfTemp.getNickname() + "> ");
	}// end showUserMenu

	static void showAdminMenu() {
		System.out.println("0. 로그아웃");
		System.out.println("1. 회원관리");
		System.out.println("2. 영상관리");
		System.out.print("admin> ");
	}// end showAdminMenu

	static void showProfileMenu(User user) throws NotExistException {
		Iterator<Profile> it = user.profileStorage.iterator();
		Profile pfTemp = null;
		while (it.hasNext()) {
			pfTemp = it.next();
			if (pfTemp.isActive()) {
				break;
			} else {
				throw new NotExistException();
			} // end if
		} // end while
		System.out.println("0. 나가기");
		System.out.println("1. 프로필변경");
		System.out.println("2. 프로필생성");
		System.out.println("3. 프로필수정");
		System.out.println("4. 프로필삭제");
		System.out.print(pfTemp.getNickname() + "> ");
	}// end showUserMenu

	static void showSettingsMenu() {
		System.out.println("0. 나가기");
		System.out.println("1. 국가설정");
		System.out.println("2. 자막설정");
		System.out.println("3. 화질설정");
		System.out.print("선택: ==> ");
	}// end showSettingsMenu

	static void showMoiveInfo() {
		System.out.println("0. 나가기");
		System.out.println("1. 줄거리");
		System.out.println("2. 별점");
		System.out.println("3. 영상시청");
		System.out.print("선택: ==> ");
	}// end showMoiveInfo

}// end MenuViewer
