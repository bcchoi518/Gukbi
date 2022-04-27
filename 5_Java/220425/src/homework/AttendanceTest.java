package homework;

import java.util.Scanner;

public class AttendanceTest {
	static Scanner sc = new Scanner(System.in);
	static Attendance[] at = new Attendance[10];
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

		sc.close();
	} // end main

	static void showMenu() {
		System.out.println("1.입실, 2.퇴실, 3.정보확인, 4.종료");
		System.out.print("선택 : ");
	}// end showMenu

	static void userCheckIn() {
		at[idx] = new Attendance();
		System.out.print("이름을 입력하세요 : ");
		at[idx].setName(sc.nextLine());
		System.out.print("입실 시간을 입력하세요(0~23) : ");
		at[idx].setCheckInTime(Integer.parseInt(sc.nextLine()));
		System.out.println();
		idx++;
	}// end userCheckIn

	static void userCheckOut() {
		System.out.print("이름을 입력하세요 : ");
		String tmp = sc.nextLine();

		for (int i = 0; i < idx; i++) {
			if (tmp.equals(at[i].getName())) {
				foundIdx = i;
			} // end if
		} // end for

		System.out.print("퇴실 시간을 입력하세요(0~23) : ");
		at[foundIdx].setCheckOutTime(Integer.parseInt(sc.nextLine()));
		System.out.println();
	}// end userCheckOut

	static void printAll() {
		for (int i = 0; i < idx; i++) {
			at[i].printInfo();
		} // end for
	}// end printAll

} // end AttendanceTest
