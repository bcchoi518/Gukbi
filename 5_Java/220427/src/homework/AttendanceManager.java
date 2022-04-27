package homework;

import java.util.Scanner;

public class AttendanceManager {
	final int MAX_PEOPLE = 10;
	Scanner sc = new Scanner(System.in);
	Attendance[] at = new Attendance[MAX_PEOPLE];
	int curCnt;
	int idx = -1;

	void userCheckIn() {
		at[curCnt] = new Attendance();
		System.out.print("이름을 입력하세요 : ");
		at[curCnt].setName(sc.nextLine());
		System.out.print("입실 시간을 입력하세요(0~23) : ");
		at[curCnt].setCheckInTime(Integer.parseInt(sc.nextLine()));
		System.out.println();
		curCnt++;
	}// end userCheckIn

	void userCheckOut() {
		System.out.print("이름을 입력하세요 : ");
		String tmp = sc.nextLine();

		idx = search(tmp);

		if (idx > -1) {
			System.out.print("퇴실 시간을 입력하세요(0~23) : ");
			at[idx].setCheckOutTime(Integer.parseInt(sc.nextLine()));
		} else {
			System.out.println("해당 하는 정보가 없습니다.");
		} // end if
		System.out.println();
	}// end userCheckOut

	void printAll() {
		for (int i = 0; i < curCnt; i++) {
			at[i].printInfo();
		} // end for
	}// end printAll

	int search(String name) {
		for (int i = 0; i < curCnt; i++) {
			if (name.equals(at[i].getName())) {
				return i;
			} // end if
		} // end for
		return -1;
	}//end search
}//end AttendanceManager
