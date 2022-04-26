package homework;

import java.util.Scanner;

public class AttendanceTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Attendance[] at = new Attendance[10];
		int input = 0;
		int idx = 0;
		int foundIdx = 0;

		do {
			System.out.println("1.입실, 2.퇴실, 3.정보확인, 4.종료");
			System.out.print("선택 : ");
			input = Integer.parseInt(sc.nextLine());
			System.out.println();

			switch (input) {
			case 1:
				at[idx] = new Attendance();
				System.out.print("이름을 입력하세요 : ");
				at[idx].setName(sc.nextLine());
				System.out.print("입실 시간을 입력하세요(0~23) : ");
				at[idx].setCheckInTime(Integer.parseInt(sc.nextLine()));
				System.out.println();
				idx++;
				break;
			case 2:
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
				break;
			case 3:
				for (int i = 0; i < idx; i++) {
					at[i].printInfo();
				}
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

} // end AttendanceTest
