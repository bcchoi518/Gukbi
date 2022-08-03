package Quiz;

public class Quiz02 {

	public static void main(String[] args) {

//		100부터 1까지의 수 중에서 홀수의 합을 구하여 출력하는 프로그램을
//		do~While문을 사용하여 작성하시오.

		int num = 100;
		int sum = 0;
		int i = 0;

		System.out.println("────────── for 반복문 ──────────");
		for (i = num - 1; i > 0; i -= 2) {
			sum += i;
		} // end for

		System.out.println(num + "부터 1까지 홀수의 합 : " + sum);

		System.out.println();
		System.out.println("────────── while 반복문 ──────────");
		sum = 0;
		i = num - 1;

		while (i > 0) {
			sum += i;
			i -= 2;
		} // end while

		System.out.println(num + "부터 1까지 홀수의 합 : " + sum);

		System.out.println();
		System.out.println("────────── do~while 반복문 ──────────");
		sum = 0;
		i = num - 1;

		do {
			sum += i;
			i -= 2;
		} while (i > 0); // end do~while

		System.out.println(num + "부터 1까지 홀수의 합 : " + sum);

	}// end main

}// end Quiz02
