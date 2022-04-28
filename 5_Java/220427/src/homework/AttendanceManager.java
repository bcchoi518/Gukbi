package homework;

import java.util.Scanner;

public class AttendanceManager {
	Scanner sc = new Scanner(System.in);
	final int MAX_PEOPLE = 10;
	Attendance[] userArr = new Attendance[MAX_PEOPLE];
	int curCnt;
	int idx = -1;

	int search(String name) {
		for (int i = 0; i < curCnt; i++) {
			if (name.equals(userArr[i].getName())) {
				return i;
			} // end if
		} // end for
		return -1;
	}// end search

	void userCheckIn() {
		userArr[curCnt] = new Attendance();
		System.out.print("이름을 입력하세요 : ");
		userArr[curCnt].setName(sc.nextLine());
		System.out.print("입실 시간을 입력하세요(0~23) : ");
		userArr[curCnt].setCheckInTime(Integer.parseInt(sc.nextLine()));
		System.out.println("*** 입실 완료 ***");
		System.out.println();
		curCnt++;
	}// end userCheckIn

	void userCheckOut() {
		System.out.print("이름을 입력하세요 : ");
		String tmp = sc.nextLine();

		idx = search(tmp);

		if (idx > -1) {
			System.out.print("퇴실 시간을 입력하세요(0~23) : ");
			userArr[idx].setCheckOutTime(Integer.parseInt(sc.nextLine()));
			System.out.println("*** 퇴실 완료 ***");
		} else {
			System.out.println("해당 하는 정보가 없습니다.");
		} // end if
		System.out.println();
	}// end userCheckOut

	void userSearch() {
		System.out.print("검색할 이름을 입력하세요 : ");
		String tmp = sc.nextLine();
		System.out.println();

		idx = search(tmp);

		if (idx > -1) {
			System.out.println("*** 검색 결과 ***");
			userArr[idx].printInfo();
		} else {
			System.out.println("해당 하는 정보가 없습니다.");
		} // end if
		System.out.println();
	}// end userSearch

	void userUpdate() {
		System.out.print("수정할 이름을 입력하세요 : ");
		String tmp = sc.nextLine();
		System.out.println();

		idx = search(tmp);

		if (idx > -1) {
			if (userArr[idx].checkInOut() == 0) {
				System.out.println(tmp + "님은 현재 입실 중 입니다.");
				System.out.print("수정할 입실 시간을 입력하세요(0~23) : ");
				userArr[idx].setCheckInTime(Integer.parseInt(sc.nextLine()));
				System.out.println();
			} else {
				System.out.println(tmp + "님은 퇴실하셨습니다.");
				System.out.println("1. 입실 시간 수정");
				System.out.println("2. 퇴실 시간 수정");
				int choice = Integer.parseInt(sc.nextLine());

				switch (choice) {
				case 1:
					System.out.print("수정할 입실 시간을 입력하세요(0~23) : ");
					userArr[idx].setCheckInTime(Integer.parseInt(sc.nextLine()));
					break;
				case 2:
					System.out.print("수정할 퇴실 시간을 입력하세요(0~23) : ");
					userArr[idx].setCheckOutTime(Integer.parseInt(sc.nextLine()));
					break;
				default:
					System.out.println("잘못 입력하셨습니다.");
				}// end switch
			} // end if
			System.out.println("*** 수정 완료 ***");
		} else {
			System.out.println("해당 하는 정보가 없습니다.");
		} // end if
		System.out.println();
	}// end userUpdate

	void userDelete() {
		System.out.print("삭제할 이름을 입력하세요 : ");
		String tmp = sc.nextLine();

		idx = search(tmp);

		if (idx > -1) {
			for (int i = idx; i < curCnt; i++) {
				if (i == MAX_PEOPLE - 1) {
					userArr[i] = null;
				} else {
					userArr[i] = userArr[i + 1];
				} // end if
			} // end for
			curCnt--;
			System.out.println("*** 삭제 완료 ***");
		} else {
			System.out.println("삭제할 정보가 존재하지 않음");
		} // end if
		System.out.println();
	}// end userDelete

	void printAll() {
		int checkInCnt = 0;
		System.out.println("*** 전체 이용 내역 ***");
		for (int i = 0; i < curCnt; i++) {
			userArr[i].printInfo();
			if (userArr[i].getCheckOutTime() == 0) {
				checkInCnt++;
			} // end if
		} // end for
		System.out.println("------------------");
		System.out.println("전체 사용자: " + curCnt + "명");
		System.out.println("현재 입실중: " + checkInCnt + "명");
		System.out.println();
	}// end printAll

}// end AttendanceManager
