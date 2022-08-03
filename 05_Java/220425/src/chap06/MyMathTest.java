package chap06;

import java.util.Scanner;

public class MyMathTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		MyMath mm = new MyMath();
		
		int x = 0;
		int y = 0;
		int intResult = 0;
		double douResult = 0.0;
		
		System.out.print("첫 번째 숫자 입력 : ");
		x = Integer.parseInt(sc.nextLine());
		System.out.print("두 번째 숫자 입력 : ");
		y = Integer.parseInt(sc.nextLine());
		
		intResult = mm.add(x, y); 
		System.out.println(intResult);
		
		intResult = mm.sub(x, y); 
		System.out.println(intResult);

		intResult = mm.mul(x, y); 
		System.out.println(intResult);

		douResult = mm.div(x, y); 
		System.out.println(douResult);

		System.out.println(mm.showNum(x, y));
		
	}// end main

}// end MyMathTest
