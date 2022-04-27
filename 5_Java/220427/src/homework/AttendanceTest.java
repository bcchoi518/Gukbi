package homework;

import java.util.Scanner;

public class AttendanceTest {
	
	static int idx = 0;
	static int foundIdx = 0;

	public static void main(String[] args) {
		int input = 0;

		do {
			showMenu();
			input = Integer.parseInt(sc.nextLine());
			System.out.println();

			switch (input) {
			case 1:
				userCheckIn();
				break;
			case 2:
				userCheckOut();
				break;
			case 3:
				printAll();
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못 누르셨습니다.");
			} // end switch
		} while (input != 4); // end while

	} // end main

	

	

} // end AttendanceTest
