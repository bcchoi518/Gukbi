package homework;

import java.util.Scanner;

public class CafeTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Cafe cf = new Cafe();

		String[] menu = new String[4];
		int active = 0;
		boolean isDup = false;

		System.out.println("저희 카페에 오신 것을 환영합니다. ^^");

		do {
			System.out.println("1.주문 2.퇴장 3.테이블확인 4.종료");
			System.out.print("선택 : ");
			active = Integer.parseInt(sc.nextLine());

			switch (active) {
			case 1:
				cf.showMenu();
				for (int i = 0; i < menu.length; i++) {

					System.out.print("주문할 메뉴를 입력하세요(종료:엔터) : ");
					menu[i] = sc.nextLine();

					if (menu[i].equals("")) {
						break;
					} // end if

					for (int j = 0; j < cf.menu.length; j++) {
						if (menu[i].equals(cf.menu[j])) {
							isDup = true;
							break;
						} // end if
					} // end for

					if (isDup) {
						isDup = false;
						continue;
					} else {
						System.out.println("주문하신 " + menu[i] + "는 메뉴에 없습니다.");
						i--;
					} // end if
				} // end for

				cf.order(menu);
				System.out.println();
				break;
			case 2:
				cf.byebye();
				System.out.println();
				break;
			case 3:
				cf.checkTable();
				System.out.println();
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				break;
			}// end switch

		} while (active != 4); // end while

		sc.close();
	}// end main

}// end CafeTest
