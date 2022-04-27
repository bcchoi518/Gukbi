package step3;

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

}// end MenuViewer
