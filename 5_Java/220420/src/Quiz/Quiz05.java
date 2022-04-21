package Quiz;

import java.util.Scanner;

public class Quiz05 {

	public static void main(String[] args) {

//		① 3+6+9+12+...+N 형태로 3의 배수를 더한다.
//		② 하나의 숫자를 입력받는다.
//		③ 3의 배수의 총합이 입력된 숫자를 넘었을 때의 N 값과 총합계,
//		  N 값이 몇 번째인지를 do~while 반복문을 사용해 프로그램을 작성하시오.

		int i = 0;
		int sum = 0;
		int idx = 0;
		int num = 0;

		Scanner sc = new Scanner(System.in);
		System.out.print("사용자 입력 : ");
		num = Integer.parseInt(sc.nextLine());

		System.out.println();
		System.out.println("────────── for 반복문 ──────────");
		for (i = 0; i <= num; i += 3) {
			sum += i;
			idx++;
		} // end for

		System.out.println(num + "을 넘었을 때의 값 : " + i);
		System.out.println(num + "을 넘었을 때까지의 총합계 : " + sum);
		System.out.println(num + "을 넘었을 때까지 몇 번째 3의 배수인가 : " + idx);

		System.out.println();
		System.out.println("────────── while 반복문 ──────────");
		i = 0;
		sum = 0;
		idx = 0;

		while (i <= num) {
			sum += i;
			idx++;
			i += 3;
		} // end while

		System.out.println(num + "을 넘었을 때의 값 : " + i);
		System.out.println(num + "을 넘었을 때까지의 총합계 : " + sum);
		System.out.println(num + "을 넘었을 때까지 몇 번째 3의 배수인가 : " + idx);

		System.out.println();
		System.out.println("────────── do~while 반복문 ──────────");
		i = 0;
		sum = 0;
		idx = 0;

		do {
			sum += i;
			idx++;
			i += 3;
		} while (i <= num); // end do~while

		System.out.println(num + "을 넘었을 때의 값 : " + i);
		System.out.println(num + "을 넘었을 때까지의 총합계 : " + sum);
		System.out.println(num + "을 넘었을 때까지 몇 번째 3의 배수인가 : " + idx);

		sc.close();
	}// end main

}// end Quiz05
