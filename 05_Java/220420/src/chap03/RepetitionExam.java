package chap03;

public class RepetitionExam {

	public static void main(String[] args) {

		System.out.println("----- 1 ~ 10 까지 합 -----");
		System.out.println("----- for 반복문 -----");
		int sum = 0;

		for (int i = 1; i <= 10; i++) {
			sum += i;
			System.out.println("1부터 " + i + "까지의 합 = " + sum);
		} // end for

		System.out.println("----- while 반복문 -----");
		int j = 1;
		sum = 0;

		while (j <= 10) {
			sum += j;
			System.out.println("1부터 " + j + "까지의 합 = " + sum);
			j++;
		} // end while

		System.out.println("----- do ~ while 반복문 -----");
		j = 1;
		sum = 0;

		do {
			sum += j;
			System.out.println("1부터 " + j + "까지의 합 = " + sum);
			j++;
		} while (j <= 10); // end do~while

		System.out.println("----- 구구단 찍기 -----");
		System.out.println("----- for 반복문 -----");
		for (int i = 1; i < 10; i++) {
			for (int k = 2; k < 10; k++) {
				System.out.printf("%d X %d = %2d\t", k, i, k * i);
			} // end for
			System.out.println();
		} // end for

		System.out.println("----- while 반복문 -----");
		int m = 1;
		int n = 2;

		while (m < 10) {
			while (n < 10) {
				System.out.printf("%d X %d = %2d\t", n, m, n * m);
				n++;
			} // end while
			System.out.println();
			n = 2;
			m++;
		} // end while

		System.out.println("----- do~while 반복문 -----");
		m = 1;
		n = 2;

		do {
			do {
				System.out.printf("%d X %d = %2d\t", n, m, n * m);
				n++;
			} while (n < 10); // end do~while
			System.out.println();
			n = 2;
			m++;
		} while (m < 10); // end do~while

	}// end main

}// end RepetitionExam
