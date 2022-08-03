package chap02;

import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {

		char c = ' ';
		String result = "";

		Scanner sc = new Scanner(System.in);

		System.out.print("문자 하나를 입력하세요 : ");
		c = sc.nextLine().charAt(0);

//		if ('0' <= c && c <= '9') {
//			System.out.println("숫자입니다");
//		} else if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
//			System.out.println("영문자입니다");
//		} else {
//			System.out.println("문자입니다");
//		} // end if

		result = ('0' <= c && c <= '9') ? "숫자입니다" : "문자입니다";	//삼항연산자
		
		System.out.println(result);
		
		sc.close();
	}// end main

}// end Exam01
