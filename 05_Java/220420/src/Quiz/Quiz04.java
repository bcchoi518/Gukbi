package Quiz;

public class Quiz04 {

	public static void main(String[] args) {

//		1부터 100까지의 합을 구하여 다음과 같이 출력하는 프로그램을 do~while 반복문을
//		이용하여 작성하시오. 10을 기준으로 합계를 출력한다.

		int sum = 0;
		int i = 0;

		System.out.println("────────── for 반복문 ──────────");
		for (i = 1; i <= 100; i++) {
			sum += i;
			if (i % 10 == 0) {
				System.out.println("1~" + i + " : " + sum);
			} // end if
		} // end for

		System.out.println();
		System.out.println("────────── while 반복문 ──────────");
		sum = 0;
		i = 1;

		while (i <= 100) {
			sum += i;
			if (i % 10 == 0) {
				System.out.println("1~" + i + " : " + sum);
			} // end if
			i++;
		} // end while

		System.out.println();
		System.out.println("────────── do~while 반복문 ──────────");
		sum = 0;
		i = 1;

		do {
			sum += i;
			if (i % 10 == 0) {
				System.out.println("1~" + i + " : " + sum);
			} // end if
			i++;
		} while (i <= 100); // end do~while

	}// end main

}// end Quiz04
