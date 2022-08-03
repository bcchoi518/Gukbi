package chap02;

import java.util.Scanner;

public class Season {

	public static void main(String[] args) {

		int month = 0;
		String result = "";

		Scanner sc = new Scanner(System.in);

		System.out.print("월을 입력하세요(1~12) : ");
		month = Integer.parseInt(sc.nextLine());

//		if (3 <= month && month <= 5) {
//			result = "봄";
//		} else if (6 <= month && month <= 8) {
//			result = "여름";
//		} else if (9 <= month && month <= 11) {
//			result = "가을";
//		} else if (12 == month || (1 <= month && month <= 2)) {
//			result = "겨울";
//		} else {
//			result = "잘못 입력하셨습니다.";
//		} // end if

		switch (month) {
		case 3:
		case 4:
		case 5:
			result = "봄";
			break;
		case 6:
		case 7:
		case 8:
			result = "여름";
			break;
		case 9:
		case 10:
		case 11:
			result = "가울";
			break;
		case 12:
		case 1:
		case 2:
			result = "겨울";
			break;
		default:
			result = "잘못 입력하셨습니다";
		}

		System.out.println(result);
		sc.close();

	}// end main

}// end Season
