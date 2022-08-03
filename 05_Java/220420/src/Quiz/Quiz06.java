package Quiz;

import java.util.Scanner;

public class Quiz06 {

	public static void main(String[] args) {

//		사용자로부터 단을 입력받아 그 단에 해당하는 구구단을 다음과 같은 형태로
//		출력하는 프로그램을 do~while문을 사용하여 작성하시오.

		int dan = 0;
		int i = 0;

		Scanner sc = new Scanner(System.in);
		System.out.print("사용자 입력 : ");
		dan = Integer.parseInt(sc.nextLine());

		System.out.println();
		System.out.println("────────── for 반복문 ──────────");
		System.out.println("** " + dan + "단 **");
		for (i = 8; i > 0; i -= 2) {
			System.out.println(i + " * " + dan + " = " + i * dan);
		} // end for

		System.out.println();
		System.out.println("────────── while 반복문 ──────────");
		i = 8;

		System.out.println("** " + dan + "단 **");
		while (i > 0) {
			System.out.println(i + " * " + dan + " = " + i * dan);
			i -= 2;
		} // end while

		System.out.println();
		System.out.println("────────── do~while 반복문 ──────────");
		i = 8;

		System.out.println("** " + dan + "단 **");
		do {
			System.out.println(i + " * " + dan + " = " + i * dan);
			i -= 2;
		} while (i > 0); // end do~while

		sc.close();
	}// end main

}// end Quiz06
