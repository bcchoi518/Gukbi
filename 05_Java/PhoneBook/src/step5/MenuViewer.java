package step5;

import java.util.Scanner;

public class MenuViewer {
	static Scanner scanner = new Scanner(System.in);

	static void showMenu() {
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 수정");
		System.out.println("4. 데이터 삭제");
		System.out.println("6. 전체 출력");
		System.out.println("7. 프로그램 종료");
		System.out.print("선택: ==> ");
	}// end showMenu

	static void showInputSubMenu() {
		System.out.println("선택하세요...");
		System.out.println("1. 일반");
		System.out.println("2. 대학");
		System.out.println("3. 직장");
		System.out.print("선택: ==> ");
	}// end showSubMenu

	static void showUpdateSubMenu(Person p) {
		System.out.println("선택하세요...");
		System.out.println("0. 나가기");
		System.out.println("1. 전번");
		System.out.println("2. 생일");
		if (p instanceof UnivPerson) {
			System.out.println("3. 전공");
			System.out.println("4. 학년");
		} else if (p instanceof CompanyPerson) {
			System.out.println("3. 회사");
		} // end if
		System.out.print("선택: ==> ");
	}// end showUpdateSubMenu
}// end MenuViewer
