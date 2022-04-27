package step2;

import java.util.Scanner;

public class PhoneBookVer02_1 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int choice = 0;

		while (true) {
			showMenu();
			choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {
			case 1:
				inputData();
				break;
			case 2:
				System.out.println("프로그램 종료");
				return;
			}// end switch
		} // end while

	}// end main

	static void inputData() {

		System.out.print("이름==> ");
		String name = scanner.nextLine();
		System.out.print("전번==> ");
		String phoneNumber = scanner.nextLine();
		System.out.print("생일==> ");
		String birth = scanner.nextLine();

		Person p = new Person(name, phoneNumber, birth);

		p.showPhoneInfo();
	}// end inputData

	static void showMenu() {
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 프로그램 종료");
		System.out.print("선택: ==> ");
	}// end showMenu

}// end PhoneBookVer02_1
