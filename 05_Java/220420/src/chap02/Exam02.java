package chap02;

import java.util.Scanner;

public class Exam02 {

	public static void main(String[] args) {

		String regNo = "";
		char gender = ' ';
		Scanner sc = new Scanner(System.in);

		System.out.print("당신의 주민번호를 입력하세요(xxxxxx-xxxxxxx) : ");
		regNo = sc.nextLine();
		gender = regNo.charAt(7);

		switch (gender) {
		case '1':
		case '3':
			switch (gender) {
			case '1':
				System.out.println("당신은 2000년 이전 출생 남자입니다.");
				break;
			case '3':
				System.out.println("당신은 2000년 이후 출생 남자입니다.");
				break;
			}// end switch
			break;
		case '2':
		case '4':
			switch (gender) {
			case '2':
				System.out.println("당신은 2000년 이전 출생 여자입니다.");
				break;
			case '4':
				System.out.println("당신은 2000년 이후 출생 여자입니다.");
				break;
			}// end switch
			break;
		default:
			System.out.println("유효하지 않은 주민번호입니다.");
		}// end switch

		sc.close();
	}// end main

}// end Exam02
