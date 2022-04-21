package Quiz;

import java.util.Scanner;

public class Quiz03 {

	public static void main(String[] args) {

//		10개의 숫자를 입력받아, 0보다 큰 수에 대해서만 전체 합과 평균을
//		출력하는 프로그램을 do~while 반복문을 이용하여 작성하시오.

		Scanner sc = new Scanner(System.in);

		int num = 0;
		int sum = 0;
		int i = 0;
		int idx = 0;
		double avg = 0.0;

		System.out.println("────────── for 반복문 ──────────");
		for (i = 0; i < 10; i++) {
			System.out.print("숫자를 입력하세요(" + (i + 1) + "/10) : ");
			num = Integer.parseInt(sc.nextLine());

			if (num > 0) {
				sum += num;
				idx++;
			} // end if
		} // end for

		avg = sum / (double) idx;

		System.out.println("전체 합 : " + sum);
		System.out.printf("평균 : %.2f", avg);

		System.out.println();
		System.out.println("────────── while 반복문 ──────────");
		sum = 0;
		idx = 0;
		i = 0;
		avg = 0.0;

		while (i < 10) {
			System.out.print("숫자를 입력하세요(" + (i + 1) + "/10) : ");
			num = Integer.parseInt(sc.nextLine());

			if (num > 0) {
				sum += num;
				idx++;
			} // end if

			i++;
		} // end while

		avg = sum / (double) idx;

		System.out.println("전체 합 : " + sum);
		System.out.printf("평균 : %.2f", avg);

		System.out.println();
		System.out.println("────────── do~while 반복문 ──────────");
		sum = 0;
		idx = 0;
		i = 0;
		avg = 0.0;

		do {
			System.out.print("숫자를 입력하세요(" + (i + 1) + "/10) : ");
			num = Integer.parseInt(sc.nextLine());

			if (num > 0) {
				sum += num;
				idx++;
			} // end if

			i++;
		} while (i < 10); // end do~while

		avg = sum / (double) idx;

		System.out.println("전체 합 : " + sum);
		System.out.printf("평균 : %.2f", avg);

		sc.close();
	}// end main

}// end Quiz03
