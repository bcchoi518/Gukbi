package chap05;

import java.util.Scanner;

public class IfExam02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("나이를 입력하세요 : ");
		int age = Integer.parseInt(sc.nextLine());

		if (age >= 20) {
			System.out.println("성인입니다.");
		} else {
			System.out.println("미성년자입니다.");
		}
		
		if (age % 2 == 0) {
			System.out.println("짝수입니다.");
		} else {
			System.out.println("홀수입니다.");
		}
		sc.close();
	}

}
