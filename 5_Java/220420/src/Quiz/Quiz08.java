package Quiz;

import java.util.Scanner;

public class Quiz08 {

	public static void main(String[] args) {

//		사용자로부터 가장 좋아하는 월을 입력받아 그 월에 해당되는 계절을 출력하는 프로그램을
//		메뉴 형태로 do~while문을 사용하여 작성하시오.

		int month = 1;

		Scanner sc = new Scanner(System.in);

		System.out.println("────────── for 반복문 ──────────");
		for (; month != 0;) {
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println("가장 좋아하는 월은?(종료:0)");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.print("월 입력(1~12) : ");
			month = Integer.parseInt(sc.nextLine());
			System.out.println();

			switch (month) {
			case 0:
				System.out.println("for 반복문 프로그램을 종료합니다.");
				break;
			case 3:
			case 4:
			case 5:
				System.out.println("****** " + month + "월 ******");
				System.out.println(month + "월은 봄에 해당됩니다");
				System.out.println();
				break;
			case 6:
			case 7:
			case 8:
				System.out.println("****** " + month + "월 ******");
				System.out.println(month + "월은 여름에 해당됩니다");
				System.out.println();
				break;
			case 9:
			case 10:
			case 11:
				System.out.println("****** " + month + "월 ******");
				System.out.println(month + "월은 가을에 해당됩니다");
				System.out.println();
				break;
			case 12:
			case 1:
			case 2:
				System.out.println("****** " + month + "월 ******");
				System.out.println(month + "월은 겨울에 해당됩니다");
				System.out.println();
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				System.out.println();
			}// end switch
		} // end for

		System.out.println();
		System.out.println("────────── while 반복문 ──────────");
		month = 1;

		while (month != 0) {
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println("가장 좋아하는 월은?(종료:0)");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.print("월 입력(1~12) : ");
			month = Integer.parseInt(sc.nextLine());
			System.out.println();

			switch (month) {
			case 0:
				System.out.println("while 반복문 프로그램을 종료합니다.");
				break;
			case 3:
			case 4:
			case 5:
				System.out.println("****** " + month + "월 ******");
				System.out.println(month + "월은 봄에 해당됩니다");
				System.out.println();
				break;
			case 6:
			case 7:
			case 8:
				System.out.println("****** " + month + "월 ******");
				System.out.println(month + "월은 여름에 해당됩니다");
				System.out.println();
				break;
			case 9:
			case 10:
			case 11:
				System.out.println("****** " + month + "월 ******");
				System.out.println(month + "월은 가을에 해당됩니다");
				System.out.println();
				break;
			case 12:
			case 1:
			case 2:
				System.out.println("****** " + month + "월 ******");
				System.out.println(month + "월은 겨울에 해당됩니다");
				System.out.println();
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				System.out.println();
			}// end switch
		} // end while

		System.out.println();
		System.out.println("────────── do~while 반복문 ──────────");
		month = 1;

		do {
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println("가장 좋아하는 월은?(종료:0)");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.print("월 입력(1~12) : ");
			month = Integer.parseInt(sc.nextLine());
			System.out.println();

			switch (month) {
			case 0:
				System.out.println("do~while 반복문 프로그램을 종료합니다.");
				break;
			case 3:
			case 4:
			case 5:
				System.out.println("****** " + month + "월 ******");
				System.out.println(month + "월은 봄에 해당됩니다");
				System.out.println();
				break;
			case 6:
			case 7:
			case 8:
				System.out.println("****** " + month + "월 ******");
				System.out.println(month + "월은 여름에 해당됩니다");
				System.out.println();
				break;
			case 9:
			case 10:
			case 11:
				System.out.println("****** " + month + "월 ******");
				System.out.println(month + "월은 가을에 해당됩니다");
				System.out.println();
				break;
			case 12:
			case 1:
			case 2:
				System.out.println("****** " + month + "월 ******");
				System.out.println(month + "월은 겨울에 해당됩니다");
				System.out.println();
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				System.out.println();
			}// end switch
		} while (month != 0); // end do~while

		sc.close();
	}// end main

}// end Quiz08
