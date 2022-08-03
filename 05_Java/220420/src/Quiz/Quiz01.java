package Quiz;

import java.util.Scanner;

public class Quiz01 {

	public static void main(String[] args) {

//		하나의 숫자를 입력받아 그 숫자로부터 1까지의 합을 구하여 출력하는 프로그램을
//		do~While문을 사용하여 작성하시오.

		Scanner sc = new Scanner(System.in);

		int num = 0;
		int sum = 0;
		int i = 0;

		System.out.print("숫자를 입력하세요 : ");
		num = Integer.parseInt(sc.nextLine());

		System.out.println();
		System.out.println("────────── for 반복문 ──────────");
		for (i = num; i > 0; i--) {
			sum += i;
		} // end for

		System.out.println(num + "부터 1까지의 합 : " + sum);

		System.out.println();
		System.out.println("────────── while 반복문 ──────────");
		sum = 0;
		i = num;

		while (i > 0) {
			sum += i;
			i--;
		} // end while

		System.out.println(num + "부터 1까지의 합 : " + sum);

		System.out.println();
		System.out.println("────────── do~while 반복문 ──────────");
		sum = 0;
		i = num;

		do {
			sum += i;
			i--;
		} while (i > 0); // end do~while

		System.out.println(num + "부터 1까지의 합 : " + sum);

		sc.close();
	}// end main

}// end Quiz01
