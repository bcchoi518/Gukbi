package Quiz;

import java.util.Scanner;

public class Quiz07 {

	public static void main(String[] args) {

//		10개의 정수를 입력받아 합을 구하는 프로그램을 do~while문을 사용하여 작성하시오.
//		단, 짝수 번째에 입력되는 숫자는 양수는 음수로, 음수는 양수로 바꾸어 합을 구하시오.

		int num = 0;
		int i = 0;
		int sum = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("────────── for 반복문 ──────────");
		for (i = 0; i < 10; i++) {
			System.out.print("숫자를 입력하세요(" + (i + 1) + "/10) : ");
			num = Integer.parseInt(sc.nextLine());

			if (i % 2 == 1) {
				num *= -1;
			} // end if

			sum += num;
		} // end for
		System.out.println("총 합: " + sum);

		System.out.println();
		System.out.println("────────── while 반복문 ──────────");
		i = 0;
		sum = 0;

		while (i < 10) {
			System.out.print("숫자를 입력하세요(" + (i + 1) + "/10) : ");
			num = Integer.parseInt(sc.nextLine());

			if (i % 2 == 1) {
				num *= -1;
			} // end if

			sum += num;
			i++;
		} // end while
		System.out.println("총 합: " + sum);

		System.out.println();
		System.out.println("────────── do~while 반복문 ──────────");
		i = 0;
		sum = 0;

		do {
			System.out.print("숫자를 입력하세요(" + (i + 1) + "/10) : ");
			num = Integer.parseInt(sc.nextLine());

			if (i % 2 == 1) {
				num *= -1;
			} // end if

			sum += num;
			i++;
		} while (i < 10); // end do~while
		System.out.println("총 합: " + sum);

		sc.close();
	}// end main

}// end Quiz07
