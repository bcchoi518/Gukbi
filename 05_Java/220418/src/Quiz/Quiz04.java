package Quiz;

import java.util.Scanner;

public class Quiz04 {

	public static void main(String[] args) {

//		본봉과 직급을 입력받아 세금을 공제한 다음 실제 수령액을 출력하는 프로그램을 작성하시오.
//		직급이 7, 8급인 경우 : 세금 8%
//		직급이 5, 6급인 경우 : 세금 12%

		int salary = 0, tax = 0;
		String rank = "";

		Scanner sc = new Scanner(System.in);

		System.out.print("직급 : ");
		rank = sc.nextLine();
		System.out.print("본봉 : ");
		salary = Integer.parseInt(sc.nextLine());

		if (rank.equals("7급") || rank.equals("8급")) {
			tax = 8;
		} else if (rank.equals("5급") || rank.equals("6급")) {
			tax = 12;
		} else {
			System.out.println("잘못 입력하셨습니다.");
		} // end if

		salary -= (salary / 100 * tax);

		System.out.println("실수령액(세금" + tax + "%적용): " + salary);

		sc.close();
	}// end main

}// end Quiz04
