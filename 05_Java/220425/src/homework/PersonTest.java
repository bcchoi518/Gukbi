package homework;

import java.util.Scanner;

public class PersonTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Person p = new Person();

		System.out.print("이름을 입력하세요: ");
		p.name = sc.nextLine();
		System.out.print("전번을 입력하세요: ");
		p.phoneNumber = sc.nextLine();
		System.out.print("생일을 입력하세요: ");
		p.birth = sc.nextLine();
		System.out.println();

		p.showPerson();

		sc.close();
	}// end main
}// end PersonTest
