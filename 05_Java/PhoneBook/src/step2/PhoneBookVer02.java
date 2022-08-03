package step2;

import java.util.Scanner;

public class PhoneBookVer02 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("이름==> ");
		String name = scanner.nextLine();
		System.out.print("전번==> ");
		String phoneNumber = scanner.nextLine();
		System.out.print("생일==> ");
		String birth = scanner.nextLine();

		Person p = new Person(name, phoneNumber, birth);

		p.showPhoneInfo();

	}// end main

}// end PhoneBookVer02
