package step2;

import java.util.Scanner;

public class MenuViewer {
	static Scanner sc = new Scanner(System.in);

	static void showLogIn() throws InterruptedException {
		Screen.netflixLogo1();
		System.out.println();
		System.out.println("　　　"
				+ "┌ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ┐");
		System.out.print("\t\t\tSignIn(1)");
		System.out.print("\t\tSignUp(2)");
		System.out.println("\t\tExit(3)");
		System.out.println("　　　"
				+ "└ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ┘");
		System.out.println();
		System.out.print("Choice> ");
	}// end showLogIn

	static void showMainMenu(User user) throws NotExistException, InterruptedException {
		if (user instanceof Admin) {
			showAdminMenu();
			return;
		} // end if
		showUserMenu(user);
	}// end showMainMenu

	static void showUserMenu(User user) throws NotExistException, InterruptedException {
		Screen.netflixLogo1();
		System.out.println("        \t\t\t\t*_Hello Fiveflix world_*");
		System.out.println();
		System.out.println("　　　"
				+ "┌ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ┐");
		System.out.print("\t\t   LogOut(0)");
		System.out.print("\t  Profile(1)");
//		System.out.println("├───────────────────────────────────────────────────────────────────┤");
		System.out.print("\t  Contents(2)  ");
		System.out.println("\t  Configuration(3)");
		System.out.println("　　　"
				+ "└ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ┘");
		System.out.println();
//		System.out.println("0. 로그아웃");
//		System.out.println("1. 프로필");
//		System.out.println("2. 콘텐츠");
//		System.out.println("3. 환경설정");
		System.out.print(user.pf.getNickname() + "> ");
	}// end showUserMenu

	static void showProfileMenu(User user) throws NotExistException {
		System.out.println("0. 나가기");
		System.out.println("1. 프로필변경");
		System.out.println("2. 프로필생성");
		System.out.println("3. 프로필수정");
		System.out.println("4. 프로필삭제");
		System.out.print(user.pf.getNickname() + "> ");
	}// end showProfileMenu

	static void showSettingsMenu(User user) {
		System.out.println("0. 나가기");
		System.out.println("1. 설정조회");
		System.out.println("2. 국가설정");
		System.out.println("3. 자막설정");
		System.out.println("4. 화질설정");
		System.out.print(user.pf.getNickname() + "> ");
	}// end showSettingsMenu

	static void showAdminMenu() throws InterruptedException {
		Screen.netflixLogo1();
		System.out.println("        \t\t\t\t*_Hello Fiveflix world_*");
		System.out.println();
		System.out.println("　　　"
				+ "┌ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ┐");
		System.out.print("\tLogOut(0)");
		System.out.print("\tUserManagement(1)");
//		System.out.println("├───────────────────────────────────────────────────────────────────┤");
		System.out.print("\tContentsManagement(2) ");
		System.out.println("\t  ChangePassword(3)");
		System.out.println("　　　"
				+ "└ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ┘");
		System.out.println();
//		System.out.println("0. 로그아웃");
//		System.out.println("1. 회원관리");
//		System.out.println("2. 영상관리");
//		System.out.println("3. 비밀번호 변경");
		System.out.print("admin> ");
	}// end showAdminMenu

	static void showUserManagementMenu() {
		System.out.println("0. 나가기");
		System.out.println("1. 전체조회");
		System.out.println("2. 회원검색");
		System.out.println("3. 회원수정");
		System.out.println("4. 회원삭제");
		System.out.print("admin> ");
	}// end showUserManagementMenu

	static void showMovieInfo(User user) {
		System.out.println("0. 나가기");
		System.out.println("1. 줄거리");
		System.out.println("2. 별점");
		System.out.println("3. 영상시청");
		System.out.print(user.pf.getNickname() + "> ");
	}// end showMovieInfo

	static void showMovieManagementMenu() {
		System.out.println("0. 나가기");
		System.out.println("1. 영화 입력");
		System.out.println("2. 영화 검색");
		System.out.println("3. 영화 수정");
		System.out.println("4. 영화 삭제");
		System.out.println("5. 전체 출력");
		System.out.println("6. 데이터 저장");
		System.out.println("7. 데이터 로드"); // 프로그램 시작 부분에 필요함
		System.out.print("admin> ");
	}// end showMovieManagementMenu
}// end MenuViewer
