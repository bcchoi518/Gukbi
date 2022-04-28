package homework;

public class AttendanceTest {

	public static void main(String[] args) {
		AttendanceManager am = new AttendanceManager();
		int input = 0;

		do {
			AttendanceMenuViewer.showMenu();
			input = Integer.parseInt(am.sc.nextLine());
			System.out.println();

			switch (input) {
			case 1:
				am.userCheckIn();
				break;
			case 2:
				am.userCheckOut();
				break;
			case 3:
				am.userSearch();
				break;
			case 4:
				am.userUpdate();
				break;
			case 5:
				am.userDelete();
				break;
			case 6:
				am.printAll();
				break;
			case 7:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못 누르셨습니다.");
			} // end switch
		} while (input != 7); // end while

	} // end main

} // end AttendanceTest
