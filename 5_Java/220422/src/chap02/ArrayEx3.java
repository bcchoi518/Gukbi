package chap02;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] numbers = new int[10];
		int sum = 0;

		for (int i = 0; i < numbers.length; i++) {

			System.out.print("숫자를 입력하세요(" + (i + 1) + "/10) : ");
			numbers[i] = Integer.parseInt(sc.nextLine());

			sum += numbers[i];
		}//end for

		System.out.println("총 합: " + sum);
		
		System.out.println(Arrays.toString(numbers));

		sc.close();
	}// end main

}// end ArrayEx3
