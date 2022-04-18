package Quiz;

import java.util.Scanner;

public class Quiz02 {

	public static void main(String[] args) {

//		두 개의 숫자를 입력받아 두 개의 수가 모두 짝수이거나 모두 홀수이면 
//		"두 숫자는 같은 짝수 또는 홀수입니다"를 출력하는 프로그램을 작성하시오.

		int num1 = 0, num2 = 0;

		Scanner sc = new Scanner(System.in);

		System.out.print("숫자를 입력하세요 : ");
		num1 = Integer.parseInt(sc.nextLine());
		System.out.print("숫자를 입력하세요 : ");
		num2 = Integer.parseInt(sc.nextLine());

		if (num1 % 2 == 0 && num2 % 2 == 0) {
			System.out.println("두 숫자는 같은 짝수입니다.");
		} else if (num1 % 2 == 1 && num2 % 2 == 1) {
			System.out.println("두 숫자는 같은 홀수입니다.");
		} else {
			System.out.println("두 숫자는 각각 짝수, 홀수입니다.");
		}

		sc.close();
	}

}
