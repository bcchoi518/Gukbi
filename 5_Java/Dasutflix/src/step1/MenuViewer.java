package step1;

import java.util.Scanner;

public class MenuViewer {
	static Scanner sc = new Scanner(System.in);

	static void showLogIn() {
		System.out.println("1. 로그인");
		System.out.println("2. 프로그램 종료");
		System.out.print("선택: ==> ");
	}// end showLogIn

	static void showUserMenu() {
		System.out.println("0. 로그아웃");
		System.out.println("1. 프로필");
		System.out.println("2. 영상검색");
		System.out.println("3. 영상정보");
		System.out.println("4. 환경설정");
		System.out.print("선택: ==> ");
	}// end showUserMenu

	static void showAdminMenu() {
		System.out.println("0. 로그아웃");
		System.out.println("1. 회원관리");
		System.out.println("2. 영상관리");
		System.out.print("선택: ==> ");
	}// end showAdminMenu

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
